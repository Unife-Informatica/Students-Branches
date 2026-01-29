# Java Notes

## Creazione Thread

Esistono due metodi per la creazione di un thread in java.

### Interfaccia `Runnable`

```java
// BackgroundTask.java
public class BackgroundTask implements Runnable {
  @Override
  public void run() {
    ...
  }
}
```

```java
// Main.java

public class Main {
  public static void main() {
    BackgroundTask backgroundTask = new BackgroundTask();

    Thread thread = new Thread(BackgroundTask);
    thread.start();
  }
}
```

### Estensione della classe `Thread`

```java
// BackgroundTask.java
public class BackgroundTask extends Thread {
  @Override
  public void run() {
    ...
  }
}
```

```java
// Main.java

public class Main {
  public static void main() {
    BackgroundTask backgroundTask = new BackgroundTask();

    backgroundTask.start();
  }
}
```

---

## Comunicazione tra Thread

### Memoria condivisa

In ambiente a memoria globale più thread comunicano direttamente accedendo alla memoria condivisa. Questo significa che due thread (A e B) possono accedere a uno stesso oggetto C condiviso.

```java
public class BackgroundTask extends Thread {

  private final SharedData sharedData;

  public BackgroundTask(SharedData sharedData) {
    this.sharedData = sharedData;
  }

  @Override
  public void run() {
    synchronized (sharedData) {
      sharedData.setMessage("Ciao dal background thread");
      sharedData.notify(); // avvisa il thread principale
    }
  }
}
```

```java
public class SharedData {
  private String message;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
```

### Stream

```java
// Main.java

public class Main {
    public static void main(String[] args) {
        try {
            PipedInputStream pipeIn = new PipedInputStream();
            PipedOutputStream pipeOut = new PipedOutputStream();

            pipeOut.connect(pipeIn);

            System.out.println("--- Avvio del sistema (Digita 'fine' per terminare) ---");

            FromInput threadScrittore = new FromInput(pipeOut);
            ToOutput threadLettore = new ToOutput(pipeIn);

            threadScrittore.start();
            threadLettore.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

```java
// FromInput.java

public class FromInput extends Thread {
    private OutputStream outputStream;

    public FromInput(OutputStream out) {
        this.outputStream = out;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        
        try {
            while (true) {
                String messaggio = scanner.nextLine();

                if (messaggio.equals("fine")) {
                    break; // Esce dal ciclo
                }

                byte[] dati = messaggio.getBytes();

                outputStream.write(dati);
                
                outputStream.flush();
            }
            
            outputStream.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
```

```java
// ToOutput.java

public class ToOutput extends Thread {
    private InputStream inputStream;

    public ToOutput(InputStream in) {
        this.inputStream = in;
    }

    @Override
    public void run() {
        byte[] buffer = new byte[1024];
        int byteLetti;

        try {
            while ((byteLetti = inputStream.read(buffer)) != -1) {
                String messaggioRicevuto = new String(buffer, 0, byteLetti);

                System.out.println("[ToOutput] Ricevuto: " + messaggioRicevuto);
            }
            
            System.out.println("[ToOutput] Comunicazione chiusa.");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Serializable

```java
public class Message implements Serializable {
    private final String testo;

    public Message(String testo) {
        this.testo = testo;
    }

    public String getTesto() {
        return testo;
    }
}
```

A differenza degli stream classici devo sostituire:
```java
byte[] buffer = new byte[1024];
outputStream.write(buffer);
// con
oos.writeObject(new Message("ciao"));
```

In **lettura** invece:
```java
int n = inputStream.read(buffer);
// con
Message msg = (Message) ois.readObject();
```

## Terminazione thread

Ci sono due modi per terminare un thread in java:
- Verifica periodica (flag booleano)
- Verifica + interrupt()

```java
// WorkerThread.java
public class WorkerThread extends Thread {
    private volatile boolean running = true;
    private int id;

    public WorkerThread(int id) {
        this.id = id;
    }

    public void stopThread() {
        running = false;
        /*
        per fare la versione con interrupt basta aggiungere la seguente
        istruzione che permette di risvegliare il thread dallo sleep e
        terminarlo istantaneamente.
        omettendolo il thread aspetterebbe fino alla fine del ciclo e 
        quindi anche della pausa.
        */
        this.interrupt();
    }

    @Override
    public void run() {
        while (running) {
            System.out.println("Thread " + id + " in esecuzione");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Thread " + id + " terminato");
    }
}
```

```java
// Main.java
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        WorkerThread[] threads = new WorkerThread[N];
        boolean[] terminated = new boolean[N];

        for (int i = 0; i < N; i++) {
            threads[i] = new WorkerThread(i);
            threads[i].start();
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Inserisci id thread da terminare: ");
            int id = scanner.nextInt();

            if (id >= 0 && id < N && !terminated[id]) {
                threads[id].stopThread();
                terminated[id] = true;
            } else {
                System.out.println("Thread non valido o già terminato");
            }
        }
    }
}
```

## Thread-Safe

```java
public class Magazzino {

    private Map<String, Integer> oggetti = new HashMap<>();

    public synchronized boolean esiste(String nome) {
        sleep();
        return oggetti.containsKey(nome);
    }

    public synchronized void crea(String nome) {
        sleep();
        oggetti.putIfAbsent(nome, 0);
    }

    public synchronized void aggiungi(String nome, int qta) {
        sleep();
        oggetti.put(nome, oggetti.get(nome) + qta);
    }

    public synchronized void rimuovi(String nome, int qta) {
        sleep();
        oggetti.put(nome, oggetti.get(nome) - qta);
    }

    private void sleep() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {}
    }

    @Override
    public synchronized String toString() {
        return oggetti.toString();
    }
}
```

Questa classe avvolge l'hash map che non gestisce la concorrenza. Utilizzando `synchronized` faccio in modo che solo un thread alla volta possa accedere alla funzione, in modo che da non perdere aggiornamenti.
