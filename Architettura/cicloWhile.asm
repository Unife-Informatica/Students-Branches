.data

.text
	li	$s0, 0
	li	$s1, 10
	
whileloop:
	beq	$s0, $s1, exit
	move 	$a0, $s0
	li	$v0, 1
	syscall
	addi	$s0, $s0, 1
	j whileloop
	
exit:
	li	$v0, 10
	syscall