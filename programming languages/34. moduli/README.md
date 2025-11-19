# Moduli
è un blocco di codice che offre delle funzionalità.
Ogni modulo ha una serie di informazioni essenziali allegate:
- nome
- elenco di dipendenze
- un'API pubblica
- un elenco di servizi che utilizza e fornisce

Generalmente la definizione di un modulo ha la seguente struttura:
```java
module $NAME {
  // for each dependency:
  requires $MODULE;

  // for each API package:
  exports $PACKAGE

  // for each used service:
  uses $TYPE;

  // for each provided service:
  provides $TYPE with $CLASS;
}
```

## Creazione
Un modulo java ha due elementi fondamentali:
- cartella del codice
- file `module-info.java`

Immaginando un modulo `my.module`:
```sh
mio.modulo/
 ├─ module-info.java
 └─ com/mio/package/Classe.java
```
Nel file `module-info.java`:
```sh
module mio.modulo {
    exports com.mio.package;   // rende visibile questo package agli altri moduli
}
```
