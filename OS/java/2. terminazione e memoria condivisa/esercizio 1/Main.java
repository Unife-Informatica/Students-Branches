import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci il numero di thread (N): ");
        int n = scanner.nextInt();

        // Array per mantenere i riferimenti agli oggetti Thread (per poter chiamare arresta())
        WorkerThread[] threads = new WorkerThread[n];
        
        // Array di boolean per ricordare chi abbiamo già fermato (come da suggerimento)
        boolean[] isTerminated = new boolean[n]; // Di default sono tutti false

        // 1. Creazione e avvio dei thread
        for (int i = 0; i < n; i++) {
            threads[i] = new WorkerThread(i);
            threads[i].start();
            isTerminated[i] = false; // Inizialmente è attivo
        }

        int threadAttivi = n; // Contatore per sapere quando finire il programma

        // 2. Ciclo di gestione terminazione
        while (threadAttivi > 0) {
            System.out.println("\n[MAIN] Inserisci l'ID del thread da terminare (0 - " + (n - 1) + "): ");
            
            // Verifica che l'utente inserisca un numero intero
            if (scanner.hasNextInt()) {
                int idDaFermare = scanner.nextInt();

                // Verifica validità ID (deve essere tra 0 e N-1)
                if (idDaFermare >= 0 && idDaFermare < n) {
                    
                    // Controlliamo l'array di boolean: è già fermo?
                    if (isTerminated[idDaFermare]) {
                        System.out.println("ATTENZIONE: Il Thread " + idDaFermare + " è già stato terminato!");
                    } else {
                        // AZIONE PRINCIPALE: Chiamiamo il metodo stop personalizzato
                        threads[idDaFermare].arresta();
                        
                        // Aggiorniamo l'array di stato
                        isTerminated[idDaFermare] = true;
                        threadAttivi--; // Decrementiamo il contatore globale
                        
                        System.out.println("--- Richiesta di stop inviata al Thread " + idDaFermare + " ---");
                    }
                } else {
                    System.out.println("Errore: ID non valido. Inserire un numero tra 0 e " + (n-1));
                }
            } else {
                String inputErrato = scanner.next();
                System.out.println("Errore: '" + inputErrato + "' non è un numero.");
            }
        }

        System.out.println("\n[MAIN] Tutti i thread sono stati terminati. Programma chiuso.");
        scanner.close();
    }
}
