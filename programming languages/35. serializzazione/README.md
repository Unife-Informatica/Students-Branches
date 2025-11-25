# Serializzazione

La serializzazione in Java è un meccanismo che permette di convertire un oggetto in un flusso di byte, così da poterlo:
- salvare su disco (in un file)
- inviare attraverso la rete
- memorizzare per un uso futuro
- trasferire tra JVM diverse

## Come si usa
Basta implementare alla classe l'interfaccia `java.io.Serializzable`.
Esempio:
```java
import java.io.Serializable;

public class Persona implements Serializable {
    private String nome;
    private int eta;

    public Persona(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }
}
```

## Serial Version UID
È un identificatore univoco per la versione della classe:
```java
private static final long serialVersionUID = 1L;
```

---

## Oggetti JSON
```java
import com.fasterxml.jackson.dabind.ObjectMapper;
...
ObjectMapper objectMapper = new ObjectMapper();
Car car = new Car("yellow", "renaut");
objectMapper.writeValue(new File("target/car.json"), car);
```

