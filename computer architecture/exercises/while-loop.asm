.text
		li 	$t1, 0
	Main:
		li	$v0, 1
	WhileLoop:
		bge	$t0, 10, ExitWhileLoop
		move 	$a0, $t0
		syscall
		addi	$t0, $t0, 1
		j WhileLoop
	ExitWhileLoop:
		li	$v0, 10
		syscall
