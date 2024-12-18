import sys

# it's hello world  & demo! 2024-12-11 19:35:05
print("Hello, World!")
print('hello world')

"""
comment
"""
print(sys.version)

# -----
x = 5
print(x)

X = "2"

result = f"{x}{11}"  # 使用 f-string

print(result)
print(x, X)

y = str(5)
print(y)

print(type(x))
print(type(y))

z = '4'
print(z)

# -----
print('-----')
x, y, z = "Orange", "Banana", "Cherry"
print(x)
print(y)
print(z)

# -----
print('-----')
x = y = z = "Orange"
print(x)
print(y)
print(z)

# -----
print('-----')
fruits = ["apple", "banana", "cherry"]
x, y, z = fruits
print(x, y, z)
print(x + y + z)

# -----
print('-----')
x = "awesome"


def myfunc():
    print("Python is " + x)


myfunc()


# -----
print('-----')
x = "awesome"

def myfunc():
  x = "fantastic"
  print("Python is " + x)

myfunc()

print("Python is " + x)