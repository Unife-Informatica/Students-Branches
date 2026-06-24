.data
	stringa: .asciiz
	.space 5
	separatore: .asciiz "\n"
	
.text
	li $v0, 8
	la $a0, stringa
	li $a1, 5
	syscall
	
	li $v0, 4
	move $t0, $a0
	la $a0, separatore
	syscall
	
	move $a0, $t0
	syscall
	
	li $v0, 10
	syscall