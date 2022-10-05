print(true and true)
print(false and (print("Short Circuit AND: Does not execute")))

print(true or false)
print(true or (print("Short Circuit OR: Does not execute")))

a,b = 1,2
print(not (a>b))