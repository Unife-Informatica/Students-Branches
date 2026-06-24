.data
array:	.word	0,1,4,2,7,8,4,6

.text
#salvo i in $t0, i*4 in $t1, array in $s0, ord_c in $s0, ord_sc in $s1
la	$s0, array
add	$t0, $zero, $zero	#i = 0
addi	$s1, $zero, 1		#ord_c = 1
addi	$s2, $zero, 1		#ord_sc = 1

while:
	slti	$t2, $t0, 7
	beq	$t2, $zero, endwhile
ifsc:
	sll	$t1, $t0, 2
	lw	$t2, $t1($s0)	#array[i]
	addi	$t1, $t1, 4	#l'offset da aggiungere a array per ottenere l'indirizzo di array[i+1]
	lw	$t3, $t1($s0)	#array[i+1]
	slt	$t4, $t2, $t3	#array[i] < array[i+1]
	beq	$t4, $zero, ifc
	add	$s2, $zero, $zero	#ord_sc = 0
ifc:
	slt	$t4, $t3, $t2	#array[i+1] < array[i]
	beq	$t4, $zero, endifc
	add	$s1, $zero, $zero	#ord_c = 0
endifc:
	addi	$t0, $t0, 1
	j	while
endwhile:
	li	$v0, 10
	syscall
