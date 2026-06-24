.data
a:	.word	10,11,13,14,17,9,7,1,4,99
stampa: .asciiz	"\nIl massimo dell'array e': "

.text
main:
	# massimo si trovi in $s0
	la	$a0, a
	li	$a1, 10
	jal massimo
	
	move	$s0, $v0 	# salviamo il valore di ritorno della funzione in $s0	
	
	la	$a0, stampa
	li	$v0, 4		# print string
	syscall
	
	move	$a0, $s0
	li	$v0, 1		# print integer
	syscall
	
	li	$v0, 10
	syscall
	
massimo:
	# gestione dello stack
	addi	$sp, $sp, -20
	sw	$s4, 16($sp)
	sw	$s3, 12($sp)
	sw	$s2, 8($sp)
	sw	$s1, 4($sp)
	sw	$s0, 0($sp)
	
	# max in $s0, i in $s2, ...
	li	$s0, 0		# max
	move	$s1, $a1 	# size
	li	$s2, 0		# i
	li	$s3, 0		# i*4
	move	$s4, $a0 
	
loop:
	slt	$t0, $s2, $s1		# i < size
	beq	$t0, $zero, endloop
	sll	$s3, $s2, 2		# i*4
	add	$t0, $s4, $s3		# a + i*4
	lw	$t1, 0($t0)		# a[i]
	
if:
	slt	$t2, $s0, $t1		# max < a[i]
	beq	$t2, $zero, endif
	move	$s0, $t1

endif:
	addi	$s2, $s2, 1	# i = i+1
	j	loop

endloop:
	move	$v0, $s0
	
	# gestione dello stack
	lw	$s0, 0($sp)
	lw	$s1, 4($sp)
	lw	$s2, 8($sp)
	lw	$s3, 12($sp)
	lw	$s4, 16($sp)
	addi	$sp, $sp, 20
	
	jr	$ra
	