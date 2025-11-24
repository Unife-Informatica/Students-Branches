# Maven

## Creazione di un nuovo progetto

```sh
mvn archetype:generate \                   # usa il plugin "archetype" per creare un nuovo progetto
  -DgroupId=com.example \                  # namespace del progetto (es. dominio invertito)
  -DartifactId=demo \                      # nome del progetto e della cartella generata
  -DarchetypeArtifactId=maven-archetype-quickstart \   # template base per progetti Java semplici
  -DinteractiveMode=false                  # evita domande interattive, usa i parametri forniti
```

## Comandi principali

### mvn compiler

Compila il sorgente (`src/main/java`)
Non esegue ne crea il JAR.

### mvn test

Compila ed esegue i file in `src/test/java`

### mvn package

Compila ed esegue i file in `src/test/java`.
Alla fine cre un JAR nella cartella `target/`

### mvn install

Fa tutto quello che fa package, in più installa il pacchetto nel repository locale (~/.m2/repository).

### mvn clean

Rimuove la cartella `target` e le dipendenze.

### mvn site

Genera un sito web statico con la documentazione del progetto.
Solitamente composta da:
- Sommario
- Licenza
- Dipendenze
- Team
- Issue
- SCM
- Project Reports
Il sito verrà salvato in `target/site/` dentro `index.html`.

