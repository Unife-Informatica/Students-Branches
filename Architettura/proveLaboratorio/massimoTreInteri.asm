.data

.text
addi	$s0, $zero, 4	#a
addi	$s1, $zero, 10	#b
addi	$s2, $zero, 8	#c
addi	$s3, $s2, 0	#x

slt	$t0, $s1, $s0
slt	$t1, $s2, $s0

and	$t2, $t0, $t1	#&&
beq	$t2, $zero, label
addi	$s3, $s0, 0
j	end

label:
slt	$t2, $s2, $s1
beq	$t2, $zero, end
addi	$s3, $s1, 0

end:
	addi	$v0, $zero, 1
	addi	$a0, $s3, 0
	syscall
	addi	$v0, $zero, 10
	syscall
	