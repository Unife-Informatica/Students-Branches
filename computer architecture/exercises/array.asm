.data
	a:	.word	10, 11, 13, 14, 17, 9, 7, 1, 4, 99
	size:	.word	10
	stampa:	.asciiz	"Il massimo dell'array e' "

.text
	main:
	la	$a0, a		# passo l'array come argomento della funzione
	lw	$a1, size	# e il numero di elementi dell'array
	jal 	massimo		# chiamo la funzione
	move	$s0, $v0	# salvo il valore di ritorno $v0 in $s0
	
	la 	$a0, stampa	# stampo la striga
	li	$v0, 4
	syscall
	
	move	$a0, $s0	# stampo il valore che è tornato dalla funzione
	li	$v0, 1
	syscall
	
	li	$v0, 10		# esco dal programma
	syscall
	
	
	massimo:
	# gestione dello stack
	# usando 5 registri($s0, ..., $s4) di 4 byte ciascuno sposto lo stack pointer
	# indietro di 5*4 byte
	addi	$sp, $sp, -20
	sw	$s4, 16($sp)
	sw	$s3, 12($sp)
	sw	$s2, 8($sp)
	sw	$s1, 4($sp)
	sw	$s0, 0($sp)
		
	# local variables
	li	$s0, 0		# MAX
	move	$s1, $a1	# size
	li	$s2, 0		# i
	li	$s3, 0		# i*4
	move	$s4, $a0
	
	loop:
	slt	$t0, $s2, $s1	# i < size
	beq	$t0, $zero, endloop
	
	# questo mi permette di shiftare verso sinistra di due posizioni 
	# il valore => quindi di moltiplicarlo per 4
	# questo perche ogni valore dentro l'array occupa 4 byte e devo passare da uno all'altro
	#         +------+------+------+
	# value:  |  10  |  11  |  13  |
	# addr:   | 1000 | 1004 | 1008 |
	#         +------+------+------+
	sll 	$s3, $s2, 2
	
	add	$t0, $s4, $s3	#a + i*4
	lw	$t1, 0($t0)	# a[i]
	
	if:
	slt	$t2, $s0, $t1	# MAX < a[i]
	beq	$t2, $zero, endif
	move	$s0, $t1
	
	endif:
	addi	$s2, $s2, 1	# i++
	j	loop
	
	endloop:
	move	$v0, $s0	# muovo in $v0 il MAX
	
	# gestione dello stack
	lw	$s0, 0($sp)
	lw	$s1, 4($sp)
	lw	$s2, 8($sp)
	lw	$s3, 12($sp)
	lw	$s4, 16($sp)
	
	addi 	$sp, $sp, 20
	
	jr	$ra