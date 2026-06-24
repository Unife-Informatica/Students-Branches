.data
array:	.word 	0,1,4,2,7,8,4,6
.text
addi	$s0, $zero, 4		#i
lw	$s1, array($zero)	#x

addi	$t0, $zero, 32

while:
	beq	$s0, $t0, endloop
	lw	$t1, array($s0)
	slt	$t2, $s1, $t1
	beq	$t2, $zero, label
	addi	$s1, $t1, 0 
	
	label:
	addi	$s0, $s0, 4
	j	while
	
endloop:
	addi	$v0, $zero, 1
	addi	$a0, $s1, 0
	syscall
	addi	$v0, $zero, 10
	syscall
	