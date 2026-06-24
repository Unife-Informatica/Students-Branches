.data

.text
main:
	li	$a0, 2
	li	$a1, 3
	li	$a2, 4
	li	$a3, 5
	jal diffOfSums
	
	move	$a0, $v0
	li	$v0, 1
	syscall
	
	li $v0, 10
	syscall

diffOfSums:
	add	$t0, $a0, $a1
	add	$t1, $a2, $a3
	sub	$v0, $t0, $t1
	jr $ra