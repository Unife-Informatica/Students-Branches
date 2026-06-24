.data

.text
addi	$s0, $zero, 4	#a
addi	$s1, $zero, 10	#b
addi	$s2, $zero, 8	#c
add	$s3, $zero, $s2	#x

slt	$t0, $s1, $s0
slt	$t1, $s2, $s0
and	$t2, $t0, $t1

bne	$t2, $zero, label0

slt	$t3, $s2, $s1
beq	$t3, $zero, end

add	$s3, $zero, $s1
j 	end

label0:
add	$s3, $zero, $s0

end:
addi	$v0, $zero, 1
addi	$a0, $s3, 0
syscall