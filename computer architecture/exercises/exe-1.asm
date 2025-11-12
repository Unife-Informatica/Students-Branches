.text
	li $v0, 5		# carico 5(costante per leggere un valore) in v0
	syscall
	
	add $s0, $zero, $v0	# carico il valore letto in s0 per non perderlo (nel passaggio seguente v0 verrà sovrascritto da 10)
	syscall
	
	li $v0, 10		# esco dal programma
	syscall