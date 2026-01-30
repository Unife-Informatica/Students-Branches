# Sistemi Operativi – 11 giugno 2014

Un’applicazione concorrente deve aiutare un amministratore di sistema a controllare il consumo di risorse delle varie applicazioni che compongono l’infrastruttura informatica della propria azienda.

Poiché l’azienda utilizza delle applicazioni ospitate in **“Cloud”**, le risorse utilizzate sono delle **macchine virtuali (VM)** fornite da vari fornitori di servizi Cloud, come Google, Amazon, SalesForce, ecc. L’applicazione, realizzata in C, deve presentare la seguente interfaccia:

```
conta_VM dir
```

dove `dir` è un nome assoluto di directory.

Le informazioni sulle VM utilizzate da ciascuna applicazione (si noti che ogni applicazione tipicamente potrà fare uso di più di una VM), sono presenti in un file con estensione `.txt` per ognuno dei fornitori di servizi Cloud dell’azienda all’interno della directory `dir` passata come parametro.

Quindi, il nome del file contenente i dati per le VM ospitate presso Amazon sarà:

```
Amazon.txt
```

In ciascun file saranno riportati i dati di monitoraggio per le VM ospitate dal rispettivo fornitore, una per riga. Ogni riga del file summenzionato conterrà quindi:

```
nome_VM nome_applicazione tipo_VM stato_VM
```

Ad esempio:

```
VM-126 contabilità x1.large operativa
```

Tali informazioni sono mantenute costantemente aggiornate da un sistema di monitoraggio che non interessa dettagliare ai fini di questo compito.

L’applicazione deve essere composta da un processo iniziale `P0` che si interfaccia con l’amministratore, da cui riceve (via terminale) le stringhe alfanumeriche:

```
nome_fornitore
nome_applicazione
```

che rappresentano rispettivamente:

* il nome di uno dei fornitori di servizi utilizzati (es. “Amazon”, “SalesForce”, ecc.)
* il nome della specifica applicazione (tra le numerose applicazioni che formano l’infrastruttura informatica aziendale)

P0 deve quindi creare due processi figli, `P1` e `P2`, che devono collaborare per fornire all’amministratore il numero di **VM attualmente operative** per l’applicazione indicata e ospitata presso il fornitore selezionato.

P0 continua a rispondere alle richieste dell’amministratore fino all’inserimento della stringa:

```
fine
```

o alla pressione del tasto Ctrl-C. In entrambi i casi, il processo `P0` deve visualizzare il numero di richieste servite prima di terminare.
