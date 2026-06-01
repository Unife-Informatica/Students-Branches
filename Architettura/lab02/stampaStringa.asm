.data
	stringa: .asciiz "Ciao\n"

.text
	la $a0, stringa
	li $v0, 4
	syscall
	
	li $v0, 10
	syscall