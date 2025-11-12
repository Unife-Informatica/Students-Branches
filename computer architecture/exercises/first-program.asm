.data
    # Sezione dati: contiene dati statici come stringhe, variabili ecc.

    # MyMessage -> etichetta dell'indirizzo per accedere alla stringa
    # .asciiz   -> direttiva che salva la stringa e aggiunge automaticamente '\0' alla fine (null terminator)
    MyMessage: .asciiz "Hello , World !\n"   # Stringa da stampare a schermo

.text
    # Sezione di testo: contiene il codice eseguibile (le istruzioni)

Main:
    # Prima istruzione: vogliamo stampare una stringa

    li $v0, 4              # Carica il valore 4 nel registro $v0
                           # $v0 = 4 indica al sistema che vogliamo eseguire un'operazione di stampa stringa (print_string)

    la $a0, MyMessage      # Carica l'indirizzo della stringa (MyMessage) nel registro $a0
                           # $a0 è il registro usato per passare argomenti al sistema
                           # In questo caso, passiamo la stringa da stampare

    syscall                # Chiamata al sistema (System Call)
                           # Il sistema esegue l'operazione richiesta in base al valore di $v0 (in questo caso stampa la stringa)

Exit:
    # Ora vogliamo terminare il programma correttamente

    li $v0, 10             # Carica il valore 10 nel registro $v0
                           # $v0 = 10 indica la system call per terminare il programma (exit)

    syscall                # Chiamata al sistema per terminare l'esecuzione
