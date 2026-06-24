.data

.text
main:
#salvo	a,b,c,d in $s0, $s1, $s2, $s3 e v in $s4
addi	$s0, $zero, 7
addi	$s1, $zero, 4
addi	$s2, $zero, 4
addi	$s3, $zero, 2

move	$a0, $s0
move	$a1, $s1
move	$a2, $s2
move	$a3, $s3

jal	dist

move	$s4, $v0	#v = dist(a,b,c,d)

#stampa
li	$v0, 1
move	$a0, $s4
syscall

#termino
li	$v0, 10
syscall

dist:
	# gestione dello stack
	addi	$sp, $sp, -12
	sw	$s0, 0($sp)
	sw	$t0, 4($sp)
	sw	$t1, 8($sp)
	
	#result in $s0
	add	$t0, $a0, $a1	#a+b
	sub	$t1, $a2, $a3	#c-d
	srlv	$t0, $t0, $t1	#(a+b)>>(c-d)
	sllv	$t1, $a1, $a3	#b<<d
	add	$s0, $t0, $t1	#espressione finale
	move	$v0, $s0
	
	lw	$t1, 8($sp)
	lw	$t0, 4($sp)
	lw	$s0, 0($sp)
	addi	$sp, $sp, 12
	
	jr	$ra