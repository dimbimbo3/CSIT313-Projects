a=nil
print(type(a)) --prints the data type of a (nil)

b=5
print(type(b)) --prints the data type of b (5)

c=3.14
print(type(c)) --prints the data type of c (3.14)

d="This is a string."
print(type(d)) --prints the data type of d ("This is a string.")

e='a'
print(type(e)) --prints the data type of e ('a')

print(d..e) --concatenation of d and e

print(#d) --prints the length of the string d ("This is a string.")

f=true
g=false
print(type(f)) --prints the data type of f (true)
print(type(g)) --prints the data type of g (false)

h={1,2,3}
print(type(h)) --prints the data type of g ({1,2,3})
h["key"]="example of (key,value)"
print(h["key"]) --prints the value of h["key"]

i={10, 8, 6, 4, 2}
k={}
print(#i) --prints a border value of i
print(#k) --prints a border value of k
table.sort(i)
print(table.unpack(i))

print(type(print)) --prints the data type of print