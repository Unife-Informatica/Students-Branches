.data
	a:	.word	7
	b:	.word	4
	c:	.word	4
	d:	.word	2
	
.text
	lw	$a0, a
	lw	$a1, b
	lw	$a2, c
	lw	$a3, d
	
	jal	dist
	
	# print
	add	$a0, $0, $v0
	addi	$v0, $0, 1
	syscall
	
	# exit
	addi	$v0, $0, 10
	syscall
	
	dist:
	# stack management
	subi	$sp, $sp, 12
	sw	$s0, 8($sp)
	sw	$s1, 4($sp)
	sw	$s2, 0($sp)
	
	add 	$s0 , $a1 , $a0	# a+b
	sub 	$s1 , $a2 , $a3	# c-d
	sllv 	$s2 , $a1 , $a3	# b<<d
	srlv 	$s0 , $s0 , $s1	# >>
	add 	$v0 , $s0 , $s2
	

	sw	$s0, 8($sp)
	sw	$s1, 4($sp)
	sw	$s2, 0($sp)
	addi	$sp, $sp, 12
	
	jr	$ra
	