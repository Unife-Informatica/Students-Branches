# Funzioni Lambda

## Interfacce

Esistono 4 tipi di interfacce:
- Fornitori: non accettano argomenti, restituiscono qualcosa
- [Cosnumatori](./Consumer-BiConsumer/): accettano un argomento, non restituiscono nulla
- [Predicati](./Predicate/): prendono un argomento, restituiscono un valore booleano
- [Funzioni](./Function/): prendono un argomento, restituiscono qualcosa

## Passaggi per riferimento
Quando creo una funzione che riceve come argomento lo stesso che ho passato posso passarne il riferimento. Ad esempio queste due scritture sono equivalenti:
```java
    Function<String, Integer> numeroLettere = String::length;
    Function<String, Integer> numeroLettere = s -> s.lenght();
```

Se invece la funzione ritorna un oggetto avrò la seguente scrittura:
```java
Supplier<List<String>> newListOfStrings = () -> new ArrayList<>();
Supplier<List<String>> newListOfStrings = ArrayList::new;
```
