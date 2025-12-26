#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
这是一个全面的Python语法和知识点示例文件。
通过运行这个脚本，你可以看到几乎所有核心Python语法的实际示例。
每个部分都有详细注释解释概念。
结构基于Python官方教程和语言参考，按逻辑顺序组织。
注意：这不是“所有”细节（Python很丰富），但覆盖80/20规则——核心语法。
运行时，输出会打印示例结果。
建议：逐节阅读，复制运行测试。
版本：Python 3.12+ 兼容。
"""

# =============================================================================
# 0. 前言：Python基础概念
# Python是解释型、动态类型、高级语言。语法简洁，强调可读性。
# 缩进：用4空格（非Tab），定义代码块。
# 注释：单行#，多行"""或'''。
# 运行：python this_file.py
print("=== 0. 前言 ===")
print("Hello, Python World!")  # 第一个程序

# =============================================================================
# 1. 使用Python解释器
# 交互模式：python -i file.py
# 脚本模式：python file.py
# 编码：UTF-8默认，支持中文。

# =============================================================================
# 2. 非正式介绍（基本元素）
# 2.1 数字和字符串
print("\n=== 2.1 数字和字符串 ===")
# 整数：无大小限
a = 42  # int
b = 3.14  # float
c = 1j  # complex
print(f"数字: {a} (int), {b} (float), {c} (complex)")

# 字符串：单/双引号，多行三引号
s1 = "Hello"
s2 = 'World'
s3 = """多行
字符串"""
print(f"字符串: {s1} {s2}, {s3}")

# 2.2 变量和赋值
print("\n=== 2.2 变量和赋值 ===")
x = 5  # 动态类型
y = x  # 引用
x += 1  # 增强赋值
print(f"x={x}, y={y}")  # y仍是5，整数不可变

# 2.3 运算符
print("\n=== 2.3 运算符 ===")
print(2 + 3 * 4)  # 优先级: * > +
print(10 // 3)  # 整数除
print(10 % 3)  # 模
print(2 ** 3)  # 幂
print(True and False)  # 逻辑
print("a" in "abc")  # 成员

# =============================================================================
# 3. 更多控制流工具
# 3.1 if-elif-else
print("\n=== 3.1 if-elif-else ===")
age = 18
if age >= 18:
    print("成人")
elif age >= 13:
    print("青少年")
else:
    print("儿童")

# 3.2 for循环（迭代序列）
print("\n=== 3.2 for循环 ===")
for i in range(3):  # range生成序列
    print(i)
fruits = ["apple", "banana"]
for fruit in fruits:
    print(fruit)

# 3.3 while循环
print("\n=== 3.3 while循环 ===")
count = 0
while count < 3:
    print(count)
    count += 1

# 3.4 break, continue, else
print("\n=== 3.4 break/continue/else ===")
for i in range(5):
    if i == 3:
        break  # 退出
    if i == 1:
        continue  # 跳过
    print(i)
else:
    print("循环完成无break")  # else在for/while后

# 3.5 pass（占位）
print("\n=== 3.5 pass ===")
def noop():
    pass  # 空函数

# 3.6 match-case（Python 3.10+ 结构化模式匹配）
print("\n=== 3.6 match-case ===")
def http_status(status):
    match status:
        case 200:
            return "OK"
        case 404:
            return "Not Found"
        case _:
            return "Unknown"
print(http_status(200))

# =============================================================================
# 4. 数据结构
# 4.1 列表（可变序列）
print("\n=== 4.1 列表 ===")
lst = [1, 2, 3]
lst.append(4)  # 添加
print(lst)
print(lst[0])  # 索引
lst[1] = 5  # 修改
print(lst)
del lst[2]  # 删除
print(lst)
print(len(lst))  # 长度

# 切片
print(lst[1:3])  # [5]

# 列表推导式
squares = [x**2 for x in range(10) if x % 2 == 0]
print(squares)  # [0,4,16,36,64]

# 4.2 元组（不可变序列）
print("\n=== 4.2 元组 ===")
tup = (1, 2, 3)
print(tup[1])  # 2
# tup[1] = 4  # Error: 不可变

# 4.3 集合（无序唯一元素）
print("\n=== 4.3 集合 ===")
set1 = {1, 2, 2}  # {1,2}
set2 = {3, 4}
print(set1 | set2)  # 并
print(set1 & set2)  # 交
print(1 in set1)  # True

# 4.4 字典（键值对）
print("\n=== 4.4 字典 ===")
d = {"name": "Alice", "age": 30}
print(d["name"])
d["city"] = "NY"  # 添加
print(d)
del d["age"]  # 删除
print(d)
for k, v in d.items():
    print(k, v)

# 字典推导式
squares_dict = {x: x**2 for x in range(5)}
print(squares_dict)

# 4.5 嵌套数据结构
print("\n=== 4.5 嵌套 ===")
matrix = [[1,2], [3,4]]
print(matrix[0][1])  # 2

# =============================================================================
# 5. 模块
# 5.1 import
print("\n=== 5.1 import ===")
import math
print(math.pi)
from math import sqrt
print(sqrt(16))
import sys
print(sys.version)

# 5.2 自定义模块（假设此文件名为 tutorial.py，可import自己部分）
# 注意：实际运行需分割文件，但这里演示语法

# 5.3 包（目录+__init__.py）

# =============================================================================
# 6. 输入输出
# 6.1 print和input
print("\n=== 6.1 print/input ===")
name = input("Enter name: ")  # 交互
print(f"Hello, {name}!")  # f-string (3.6+)

# 6.2 文件I/O
print("\n=== 6.2 文件I/O ===")
# 写文件
with open("test.txt", "w") as f:
    f.write("Hello File!\n")
# 读文件
with open("test.txt", "r") as f:
    content = f.read()
print(content)
# 清理：实际运行后删除test.txt

# 6.3 格式化
print("格式: {:.2f}".format(3.14159))  # 3.14
print(f"格式: {3.14159:.2f}")

# =============================================================================
# 7. 错误和异常
# 7.1 try-except
print("\n=== 7.1 try-except ===")
try:
    x = 1 / 0
except ZeroDivisionError:
    print("不能除零")
else:
    print("无异常")
finally:
    print("总是执行")

# 7.2 raise
print("\n=== 7.2 raise ===")
# raise ValueError("自定义错误")

# 7.3 断言
print("\n=== 7.3 assert ===")
assert 1 == 1, "断言失败"

# =============================================================================
# 8. 类（OOP）
# 8.1 定义类
print("\n=== 8.1 类 ===")
class Dog:
    species = "Canis familiaris"  # 类变量

    def __init__(self, name, age):  # 构造函数
        self.name = name  # 实例变量
        self.age = age

    def description(self):  # 方法
        return f"{self.name} is {self.age} years old"

    def speak(self, sound):
        return f"{self.name} says {sound}"

# 实例化
my_dog = Dog("Buddy", 3)
print(my_dog.description())
print(my_dog.speak("Woof!"))

# 8.2 继承
print("\n=== 8.2 继承 ===")
class Puppy(Dog):  # 子类
    def __init__(self, name, age):
        super().__init__(name, age)  # 调用父类
        self.playful = True

    def speak(self, sound):  # 重写
        return super().speak(sound) + " (puppy version)"

pup = Puppy("Tiny", 1)
print(pup.speak("Bark!"))

# 8.3 特殊方法（dunder）
print("\n=== 8.3 特殊方法 ===")
class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def __str__(self):  # str()
        return f"Point({self.x}, {self.y})"

    def __add__(self, other):  # +
        return Point(self.x + other.x, self.y + other.y)

p1 = Point(1, 2)
p2 = Point(3, 4)
print(p1 + p2)  # __str__触发

# 8.4 属性和装饰器
print("\n=== 8.4 属性/装饰器 ===")
class Circle:
    def __init__(self, radius):
        self._radius = radius  # 私有约定

    @property
    def radius(self):  # getter
        return self._radius

    @radius.setter
    def radius(self, value):
        if value < 0:
            raise ValueError("Radius不能负")
        self._radius = value

    @property
    def area(self):  # 只读
        return 3.14159 * self._radius ** 2

c = Circle(5)
print(c.radius)  # 5
print(c.area)  # ~78.5
# c.radius = -1  # 异常

# =============================================================================
# 9. 函数和lambda
# 9.1 定义函数
print("\n=== 9.1 函数 ===")
def greet(name="World"):  # 默认参数
    return f"Hello, {name}!"

print(greet())
print(greet("Alice"))

# 9.2 可变参数
print("\n=== 9.2 *args/**kwargs ===")
def func(*args, **kwargs):
    print("Args:", args)
    print("Kwargs:", kwargs)

func(1, 2, a=3, b=4)

# 9.3 lambda
print("\n=== 9.3 lambda ===")
square = lambda x: x**2
print(square(5))  # 25

# 9.4 闭包
print("\n=== 9.4 闭包 ===")
def outer(x):
    def inner(y):
        return x + y
    return inner

add5 = outer(5)
print(add5(3))  # 8

# 9.5 装饰器
import time
print("\n=== 9.5 装饰器 ===")
def timer(func):
    def wrapper(*args, **kwargs):
        start = time.time()
        result = func(*args, **kwargs)
        print(f"Time: {time.time() - start:.2f}s")
        return result
    return wrapper

@timer
def slow_func():
    time.sleep(0.1)
    return "Done"

print(slow_func())

# =============================================================================
# 10. 高级主题
# 10.1 生成器
print("\n=== 10.1 生成器 ===")
def gen():
    yield 1
    yield 2
    yield 3

for val in gen():
    print(val)

# 生成器表达式
g = (x**2 for x in range(3))
print(list(g))  # [0,1,4]

# 10.2 迭代器协议
print("\n=== 10.2 迭代器 ===")
class MyIter:
    def __init__(self, max):
        self.max = max
        self.current = 0

    def __iter__(self):
        return self

    def __next__(self):
        if self.current < self.max:
            self.current += 1
            return self.current
        raise StopIteration

for i in MyIter(3):
    print(i)

# 10.3 上下文管理器
print("\n=== 10.3 上下文管理器 ===")
class Managed:
    def __enter__(self):
        print("进入")
        return self

    def __exit__(self, exc_type, exc_val, exc_tb):
        print("退出")

with Managed():
    print("里面")

# 10.4 异常上下文
print("\n=== 10.4 异常 ===")
try:
    raise ValueError("Oops")
except Exception as e:
    print(f"捕获: {e}")
    raise  # 重新抛出

# 10.5 元编程（简单）
print("\n=== 10.5 元类 ===")
class Meta(type):
    def __new__(cls, name, bases, dct):
        dct['added'] = lambda self: print("Added by meta")
        return super().__new__(cls, name, bases, dct)

class MyClass(metaclass=Meta):
    pass

obj = MyClass()
obj.added()

# 10.6 类型提示（3.5+）
print("\n=== 10.6 类型提示 ===")
from typing import List

def func(items: List[int]) -> int:
    return sum(items)

print(func([1,2,3]))  # 6

# =============================================================================
# 11. 标准库简览（非核心语法，但常用）
print("\n=== 11. 标准库 ===")
import datetime
print(datetime.datetime.now())

import json
data = {"key": "value"}
print(json.dumps(data))

import os
print(os.getcwd())

# =============================================================================
# 12. 最佳实践和杂项
# 12.1 列表 vs 其他
print("\n=== 12.1 最佳实践 ===")
# 用collections
from collections import defaultdict, Counter
d = defaultdict(list)
d['key'].append(1)
print(d)

c = Counter("abcde")
print(c['a'])  # 1

# 12.2 字符串方法
print("\n=== 12.2 字符串 ===")
s = "hello world"
print(s.upper())
print(s.split())
print(s.format(name="Alice"))  # 旧式

# 12.3 枚举（3.4+）
print("\n=== 12.3 枚举 ===")
from enum import Enum

class Color(Enum):
    RED = 1
    GREEN = 2

print(Color.RED)

# 12.4 dataclass（3.7+）
print("\n=== 12.4 dataclass ===")
from dataclasses import dataclass

@dataclass
class Person:
    name: str
    age: int = 0

p = Person("Bob", 30)
print(p)

# =============================================================================
# 结束：运行此文件看所有输出
print("\n=== 结束：恭喜！你已见识Python核心语法 ===")
print("下一步：实践项目，读官方文档。")
# 清理文件（可选）
import os
if os.path.exists("test.txt"):
    os.remove("test.txt")