.data

.text
addi	$s0, $zero, 9	#x
addi	$s1, $zero, 6	#y
addi	$s2, $zero, 0	#w

and	$t0, $s0, $s1

beq	$t0, $zero, label
addi	$s2, $zero, 1
j	end

label:
beq	$s0, $zero, end
beq	$s1, $zero, end
addi	$s2, $zero, 2

end:
addi	$v0, $zero, 10
syscall