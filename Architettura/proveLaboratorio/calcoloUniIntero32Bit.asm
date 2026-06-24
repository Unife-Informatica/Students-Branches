.data

.text

addi	$s0, $zero, 0	#n
addi	$s1, $zero, 0	#i
addi	$s2, $zero, 0	#y
addi	$s3, $zero, 18	#x

addi	$t0, $zero, 32

while:
	beq	$s1, $t0, endloop
	andi	$s2, $s3, 1
	add	$s0, $s0, $s2
	srl	$s3, $s3, 1
	addi	$s1, $s1, 1
	j	while
	
endloop:
addi	$v0, $zero, 1
addi	$a0, $s0, 0
syscall
addi	$v0, $zero, 10
syscall