## **1️⃣ `collect`**

`collect` è un terminal operation degli **stream** in Java. Serve a raccogliere i dati dello stream in una **collezione, mappa o altro tipo di risultato**.

### Esempio:

```java
List<String> nomi = Stream.of("Mario", "Anna", "Luca")
                          .collect(Collectors.toList());
```

* Qui lo stream dei nomi viene raccolto in una **lista**.
* `Collectors` fornisce molti tipi di collezioni: `toList()`, `toSet()`, `toMap()`, `groupingBy()`, ecc.

---

## **2️⃣ `entrySet()`**

`entrySet()` si usa sulle **mappe** e restituisce un **insieme di coppie chiave-valore** (`Map.Entry<K,V>`).

### Esempio:

```java
Map<String, Integer> mappa = Map.of("Alice", 3, "Bob", 5);
for (Map.Entry<String, Integer> entry : mappa.entrySet()) {
    System.out.println(entry.getKey() + " -> " + entry.getValue());
}
```

* `entry.getKey()` → chiave
* `entry.getValue()` → valore

Spesso si usa insieme agli stream per ordinare o filtrare mappe:

```java
mappa.entrySet().stream()
     .sorted(Map.Entry.comparingByValue())
     .forEach(System.out::println);
```

---

## **3️⃣ `Comparator`**

`Comparator` è un’interfaccia che permette di **definire come ordinare gli oggetti**.

### Esempio:

```java
List<String> nomi = List.of("Mario", "Anna", "Luca");
nomi.sort(Comparator.naturalOrder()); // ordine alfabetico
nomi.sort(Comparator.reverseOrder()); // ordine inverso
```

Con gli stream:

```java
nomi.stream()
     .sorted(Comparator.naturalOrder())
     .forEach(System.out::println);
```

---

## **4️⃣ `thenComparing`**

`thenComparing` si usa quando vuoi **ordinare prima per un criterio, e in caso di parità usare un secondo criterio**.

### Esempio:

```java
class Brano {
    String titolo;
    int rating;
    // getter
}

List<Brano> brani = ...;

brani.stream()
     .sorted(Comparator.comparingInt(Brano::getRating) // primo criterio: rating
                       .thenComparing(Brano::getTitolo)) // secondo criterio: titolo alfabetico
     .forEach(b -> System.out.println(b.getTitolo()));
```

* Prima ordina per `rating`.
* Se due brani hanno lo stesso `rating`, ordina alfabeticamente per `titolo`.

---

## **5️⃣ `comparingInt`**

`Comparator.comparingInt` è un metodo **di supporto** per creare un comparator su un valore `int`.

### Esempio:

```java
brani.sort(Comparator.comparingInt(Brano::getRating));
```

* Crea un comparatore che ordina i brani **dal rating più basso al più alto**.
* Esistono anche `comparingDouble` e `comparingLong`.

---

## **6️⃣ `mapToInt`**

`mapToInt` trasforma uno **stream di oggetti** in uno **stream di interi** (`IntStream`). Utile per operazioni come `sum()`, `average()`, `max()`.

### Esempio:

```java
List<Brano> brani = ...;

int durataTotale = brani.stream()
                        .mapToInt(Brano::getDurataSecondi)
                        .sum();
```

* `mapToInt(Brano::getDurataSecondi)` → converte ogni `Brano` nella sua durata in secondi.
* Poi `.sum()` somma tutti i secondi.

---

### 💡 In sintesi:

| Metodo/Concetto | Scopo                                                                |
| --------------- | -------------------------------------------------------------------- |
| `collect`       | raccogliere gli elementi dello stream in una lista, set, mappa, ecc. |
| `entrySet()`    | ottenere coppie chiave-valore da una mappa                           |
| `Comparator`    | definire regole di ordinamento                                       |
| `thenComparing` | ordinamento secondario in caso di parità                             |
| `comparingInt`  | creare un comparator basato su valori interi                         |
| `mapToInt`      | trasformare oggetti in `int` per operazioni numeriche come `sum`     |