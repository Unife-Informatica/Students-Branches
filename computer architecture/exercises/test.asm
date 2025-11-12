.data
	a:	.word	0, 1, 2, 3, 4, 5, 6
	
.text
	la	$s0, a		# array
	add	$s1, $0, 1	# i
	lw	$s2, 0($s0)	# x
	
	loop:
	slti	$t0, $s1, 8	# i < 8
	beq	$t0, $zero, endloop
	
	sll	$t1, $s1, 2
	add	$t2, $s0, $t1
	lw	$t1, 0($t2)
	
	slt	$t3, $s2, $t1
	beq	$t3, $0, endif
	
	add	$s2, $0, $t1
	
	endif:
	addi	$s1, $s1, 1
	
	j 	loop
	
	
	endloop:
	add	$a0, $zero, $s2
	addi	$v0, $0, 1
	syscall
	
	addi	$v0, $0, 10
	syscall