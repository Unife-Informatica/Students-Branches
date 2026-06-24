.data

.text
main:
	addi	$s0, $zero, 4	#a = 4
	addi	$s1, $zero, 10	#b = 10
	addi	$s2, $zero, 8	#c = 8
	
	add	$s3, $zero, $s2	#x = c
	
	if:
		slt	$t0, $s1, $s0		#a > b
		slt	$t1, $s2, $s0		#a > c
		and	$t0, $t0, $t1
		
		beq	$t0, $zero, else	#(a > b) && (a > c)
		add	$s3, $zero, $s0		#x = a
		j	endif
		
	else:
		slt	$t0, $s2, $s1		#b > c
		beq	$t0, $zero, endif
		add	$s3, $zero, $s1		#x = b
	
	endif:
		add	$a0, $zero, $s3
		addi	$v0, $zero, 1
		syscall
		
		addi	$v0, $zero, 10
		syscall