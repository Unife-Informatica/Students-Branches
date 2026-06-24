.data

.text
main:
	addi	$s0, $zero, 7	#a
	addi	$s1, $zero, 4	#b
	addi	$s2, $zero, 4	#c
	addi	$s3, $zero, 2	#d

	add	$a0, $zero, $s0	#a
	add	$a1, $zero, $s1	#b
	add	$a2, $zero, $s2 #c
	add	$a3, $zero, $s3	#d

	jal	dist

	addi	$s4, $v0, 0
	
	addi	$v0, $zero, 10
	syscall

	dist:
		#getione stack
		addi	$sp, $sp, -8
		sw	$t1, 0($sp)
		sw	$t2, 4($sp)
		
		#gestione calcolo
		add	$t1, $a0, $a1
		sub	$t2, $a2, $a3
		srlv	$t1, $t1, $t2
		sllv	$t2, $a1, $a3
		add	$v0, $t1, $t2 
		
		#restore stack
		lw	$t2, 4($sp)
		lw	$t1, 0($sp)
		addi	$sp, $sp, 8
		jr	$ra