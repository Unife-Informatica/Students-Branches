.data
	MyMessage: .asciiz "Hello, World!\n"
	
.text
	Main:
		li $v0, 4
		la $a0, MyMessage
		syscall
	Exit:
		li $v0, 10
		syscall