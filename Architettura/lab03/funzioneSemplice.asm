.data

.text
main:
	jal simple
	add $s0, $s1, $s1
	
	li $v0, 10
	syscall
simple:
	jr $ra