.data
array: .word 0, 1, 2, 4, 6, 7, 9, 0

.text
addi	$s0, $zero, 1	#ord_c
addi	$s1, $zero, 1	#ord_sc
addi	$s2, $zero, 0	#i
addi	$t0, $zero, 7	#limite ciclo

addi	$t1, $zero, 0	#offset
lw	$t2, array($t1)

while:
	beq	$s2, $t0, endloop
	addi	$s2, $s2, 1
	sll	$t1, $s2, 2
	lw	$t3, array($t1)
	
	slt	$t4, $t2, $t3
	bne	$t4, $zero, label0
	addi	$s1, $zero, 0
	
	label0:
	slt	$t4, $t3, $t2
	beq	$t4, $zero, label1
	addi	$s0, $zero, 0
	
	label1:
	addi	$t2, $t3, 0
	j	while
endloop:
addi	$v0, $zero, 10
syscall
	
