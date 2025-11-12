# Servizio      -> lettura stringa
# Codice in $v0 -> 8
# Argomenti     -> $a0: indirizzo del buffer di input
#		   $a1: massimo numero di caratteri da leggere

.data
	stringa:	.asciiz
	.space		5	# gli dico di preservare 5 word (stringa max 4 + terminatore) in modo che quando andrò a scrivere la stringa non sovrascriverò il separatore
	separatore:	.asciiz "\n"
	
.text
	li $v0, 8		# carichiamo il codice della syscall per l'input
	la $a0, stringa		# indirizzo del buffer
	li $a1, 5		# numero di caratteri da leggere (più uno) => max 4 caratteri + terminatore
	syscall
	
	li $v0, 4		# carichiamo il codice della syscall per la stampa
	move $t0, $a0		# salviamo il contenuto di a0 (indirizzo input) in un registro temporaneo
	la $a0, separatore	# carico l'indirizzo del separatore nel registro degli argomenti
	syscall
	
	move $a0, $t0		# sposto l'indirizzo della stringa precedentemente salvato nel registro degli argomenti
	syscall
	
	li $v0, 10		# exit
	syscall
	

##################
# OUTPUT: input
#	  input
##################