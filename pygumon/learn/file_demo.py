
f = open("/Users/XX77/Desktop/temp/temp.txt")
print(f)

f = open("/Users/XX77/Desktop/temp/temp.txt", "r")
print(f.read())

print("-----")
f = open("/Users/XX77/Desktop/temp/temp.txt", "r")
for x in f:
  print(x)

print("-----")
f = open("/Users/XX77/Desktop/temp/temp.txt", "a")
f.write("fuck u")
f.close()

f = open("/Users/XX77/Desktop/temp/temp.txt", "r")
print(f.read())