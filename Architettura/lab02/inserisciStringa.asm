.data
	stringa: .asciiz
.text
	li $v0, 8
	la $a0, stringa
	li $a1, 5
	syscall
	
	li $v0, 4
	syscall
	
	li $v0, 10
	syscall