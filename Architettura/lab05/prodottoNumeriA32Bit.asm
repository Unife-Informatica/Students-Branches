.data

.text
main:
	# salvo x in $s0, y in $s1, p in $s2
	addi	$s0, $zero, 16
	addi	$s1, $zero, 18
	add	$s2, $zero, $zero
	
	# salvo i in $s3, tmp in $t0
	add	$s3, $zero, $zero
	add	$t0, $zero, $zero
	
	addi	$t1, $zero, 32	# salvo 32 in $t1
	
	while:
		slt	$t2, $s3, $t1		# i < 32
		beq	$t2, $zero, endwhile
		andi	$t0, $s1, 1		#tmp = y & 1
		beq	$t0, $zero, skip	#se tmp == 0, salta
		add	$s2, $s2, $s0		# p = p + x
		
		skip:
			srl	$s1, $s1, 1	#y = y >> 1
			sll	$s0, $s0, 1	#x = x << 1
			addi	$s3, $s3, 1	#i = i + 1
			j 	while
endwhile:
	#stampa risultato intero
	li	$v0, 1
	add	$a0, $zero, $s2
	syscall
	
	#termino
	li	$v0, 10
	syscall		