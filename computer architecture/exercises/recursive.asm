.data

.text
	main:
	
	li	$v0, 10
	syscall
	
	fib:
	bgt	$a0, 1, recurse	# $a0 > 1
	move	$v0, $a0
	jr	$ra
	
	recurse: