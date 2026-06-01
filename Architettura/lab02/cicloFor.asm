.data

.text
	# $s0 metto i
	li	$s0, 0
	li	$s1, 10
	
forloop:
	beq	$s0, $s1, exit
	move	$a0, $s0
	li	$v0, 1
	syscall
	addi	$s0, $s0, 1
	j	forloop

exit:
	li	$v0, 10
	syscall  