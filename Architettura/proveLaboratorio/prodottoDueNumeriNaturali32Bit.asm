.data

.text
addi	$s0, $zero, 16	#x
addi	$s1, $zero, 18	#y
addi	$s2, $zero, 0	#p

addi	$t0, $zero, 0	#i
addi	$t1, $zero, 32

while:
	beq	$t0, $t1, endloop
	andi	$t2, $s1, 1
	beq	$t2, $zero, label
	add	$s2, $s2, $s0
	label:
	srl	$s1, $s1, 1
	sll	$s0, $s0, 1
	addi	$t0, $t0, 1
	j 	while
endloop:
	addi	$v0, $zero, 1
	addi	$a0, $s2, 0
	syscall
	addi	$v0, $zero, 10
	syscall
	