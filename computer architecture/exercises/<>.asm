# COMPARATORI
# blt	$s1  <  $s2
# bgt	$s1  >  $s2
# ble	$s1  <= $s2
# bge	$s1  >= $s2

.text
	li 	$s1, 4		# carico in due registri due variabili
	li 	$s2, 5
	blt	$s1, $s2, vero	# blt salta all'etichetta vero nel caso $s1 < $s2
	
	li	$v0, 10		# nel caso non salti all'etichetta "vero" chiudo il programma, perché altrimenti verrebbe comunque eseguita
	syscall
	
	vero:
	li	$s3, 1		# setto $s3 a 1
		
	li	$v0, 10		# chiudo il programma
	syscall