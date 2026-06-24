.data

.text
main:
	addi	$s0, $zero, 7	#x
	addi	$s1, $zero, 4	#y
	
	addi	$a0, $s0, 0	#x
	addi	$a1, $s1, 0	#y
	
	jal dist
	
	addi	$s0, $v0, 0
	addi	$v0, $zero, 1
	addi	$a0, $s0, 0
	syscall
	addi	$v0, $zero, 10
	syscall
	
	dist:
		#gestione stack
		addi	$sp, $sp -8
		sw	$t0, 0($sp)
		sw	$t1, 4($sp)
		
		#gestione cacoli
		slt	$t1, $a1, $a0
		beq	$t1, $zero, label
		sub	$t2, $a0, $a1
		j	end
		
		label:
		sub	$t2, $a1, $a0
		
		#restore stack
		end:
		addi	$v0, $t2, 0
		lw	$t1, 4($sp)
		lw	$t0, 0($sp)
		addi	$sp, $sp, 8
		jr	$ra
		