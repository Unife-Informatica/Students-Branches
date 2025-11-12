#### TRACCIA ####
# int main() {
#	int y;
#	y = diffofsums(2, 3, 4, 5);
#}

#int diffofsums(int f, int g, int h, int i) {
#	return (f + g) - (h + i);
#}


.text
	# CHIAMATA FUNZIONE
	# carico gli argomenti della funzione negli appositi registri
	li	$a0, 2		# f
	li	$a1, 3		# g
	li	$a2, 4		# h
	li	$a3, 5		# i
	
	jal 	diffofsums	# chiamo la funzione
				# jal (jump and link) fa eseguire la funzione e al ritorno comincia dall'istruzione seguente ad essa
	
	# STAMPA
	move	$a0, $v0	# sposto il valore di ritorno in $a0 in modo che sia argomento della stampa
	li	$v0, 1
	syscall
			
	li 	$v0, 10		# exit
	syscall
	
diffofsums:
	add	$t0, $a0, $a1	# f + g
	add	$t1, $a2, $a3	# h + i
	sub	$v0, $t0, $t1	# (f + g) - (h + i)
	jr	$ra		# ritorna il puntatore alla funzione