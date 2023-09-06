var_u = {1,2,3,4,5,6,7,8,9,10,11,12,13,14}
var_a = {2,4,6,8,10,12,14}
var_b = {1,2,3,5,8,13}
var_c = {1,2,4,6,7,10,11,13}

print("U")
print(var_u)
print("A")
print(var_a)
print("B")
print(var_b)
print("C")
print(var_c)

print("\nA U B")
print(var_a.union(var_b))
print("\nC'")
print(var_u.difference(var_c))
print("\nB ^ C")
print(var_b.intersection(var_c))
print("\nB U C")
print(var_b.union(var_c))
print("\nA ^ C")
print(var_a.intersection(var_c))
print("\nA'")
print(var_u.difference(var_a))
print("\nB - A")
print(var_b.difference(var_a))
print("\nC - B'")
print(var_c.difference(var_u.difference(var_b)))