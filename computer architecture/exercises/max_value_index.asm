.data
	array:	.word	0, 1, 2, 3, 4, 5, 6, 7, 8, 9
	size:	.word	10
	elem:	.word	6

.text
	main:
	la   	$s0, array        # load address of array
	lw   	$s1, size         # size
	lw   	$s2, elem         # element to find

	li   	$s3, -1           # found = -1
	li   	$s5, 0            # low = 0
	addi 	$s6, $s1, -1      # up = size - 1

	loop:
	slt  	$t0, $s6, $s5     # if up < low
	bne  	$t0, $zero, endloop

	add  	$t1, $s5, $s6     # low + up
	srl  	$s4, $t1, 1       # i = (low + up)/2

	sll	$t2, $s4, 2       # offset = i * 4
	add	$t3, $s0, $t2     # address of array[i]
	lw	$t4, 0($t3)       # array[i]

	beq  	$t4, $s2, found   # if array[i] == elem

	slt  	$t5, $s2, $t4     # if elem < array[i]
	bne  	$t5, $zero, set_upper

	# elem > array[i]
	addi 	$s5, $s4, 1       # low = i + 1
	j loop

	set_upper:
	addi 	$s6, $s4, -1      # up = i - 1
	j 	loop

	found:
	move 	$s3, $s4          # found = i

	endloop:
	move 	$a0, $s3
	li   	$v0, 1
	syscall

	li   	$v0, 10
	syscall
