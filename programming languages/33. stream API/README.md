# Stream API

Lo Stream è una sequenza di elementi che possono essere ciclati in modo sequenziale o parallelo per essere:
 * filtrati
 * trasformati
 * contati
 * ...
 ma non modifica la collezione originale.

## Funzionamento

1. Creazione -> da una lista, array, file, ... (`list.stream()`)
2. Operazioni intermedie -> trasformano/filtrano i dati e ritornano una unova stream
3. Operazioni terminali -> produce un risultato

### Operazioni intermedie

- `.filter(Predicate<T> p)` -> tiene gli elementi che rispetta una condizione
  ```java
  stream.filter(x -> x > 10)
  ```
- `.map(Function<T, R> f)` -> trasforma ogni elemento in un altro valore
  ```java
  stream.map(x -> x * 2)
  ```

### Operazioni terminali principali
- `.forEach(Consumer<T> c)` -> esegue un azione su ogni elemento
  ```java
  stream.forEach(System.out::println)
  ```
