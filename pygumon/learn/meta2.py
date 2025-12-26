# -*- coding: utf-8 -*-
# 建议使用支持 UTF-8 的编辑器（如 VSCode, PyCharm）打开此文件

"""
================================================================================
            Python 终极学习脚本 (Learn Python in One File)
================================================================================

简介:
这个文件旨在全面、系统地介绍 Python 的核心语法和关键知识点。
它从最基础的变量、数据类型开始，一直延伸到函数、面向对象编程、异常处理、
模块、生成器、装饰器等高级主题。

如何使用:
1.  **顺序阅读**: 按照从上到下的顺序阅读和理解代码与注释。
2.  **动手实践**: 取消某些 print 语句的注释并运行此文件 (python learn_python_in_one_file.py)，
    观察输出结果。
3.  **修改和实验**: 尝试修改代码，创建新的变量和函数，看看会发生什么。编程是在实践中学习的。

目录:
1.  基础语法与变量 (Basic Syntax & Variables)
2.  数据类型与操作 (Data Types & Operations)
    -   数字 (Numbers)
    -   字符串 (Strings)
    -   布尔值 (Booleans)
    -   列表 (Lists)
    -   元组 (Tuples)
    -   字典 (Dictionaries)
    -   集合 (Sets)
3.  流程控制 (Control Flow)
    -   条件判断 (if, elif, else)
    -   for 循环 (for loop)
    -   while 循环 (while loop)
    -   break, continue, pass
4.  函数 (Functions)
    -   定义与调用 (Definition & Calling)
    -   参数 (Arguments: positional, keyword, default, *args, **kwargs)
    -   返回值 (Return Values)
    -   作用域 (Scope: LEGB rule)
    -   Lambda 表达式 (Lambda Expressions)
5.  面向对象编程 (Object-Oriented Programming - OOP)
    -   类与对象 (Classes & Objects)
    -   构造函数 `__init__` 与 `self`
    -   继承 (Inheritance)
    -   魔术方法 (Magic Methods like `__str__`)
6.  错误与异常处理 (Error & Exception Handling)
    -   try, except, else, finally
    -   raise
7.  文件操作 (File I/O)
    -   读取文件 (Reading Files)
    -   写入文件 (Writing Files)
    -   with 语句 (The 'with' Statement)
8.  模块与包 (Modules & Packages)
    -   import
    -   from ... import ...
    -   if __name__ == "__main__":
9.  高级主题 (Advanced Topics)
    -   列表/字典/集合推导式 (Comprehensions)
    -   生成器 (Generators) & yield
    -   装饰器 (Decorators)
    -   类型提示 (Type Hinting)

================================================================================
"""

# ================================================================================
# 1. 基础语法与变量 (Basic Syntax & Variables)
# ================================================================================

# Python 使用 # 来进行单行注释

"""
这是多行注释，
实际上是一个多行字符串，但通常被用作注释。
"""

print("你好, Python!")  # 这是我们的第一个程序

# 变量赋值：变量名 = 值。变量名不需要提前声明类型。
# 变量名建议使用蛇形命名法 (snake_case)。
message = "欢迎来到 Python 的世界"
user_count = 100
pi_approximation = 3.14159

# print() 函数可以输出一个或多个变量的值
# print("消息:", message)
# print("用户数:", user_count, "圆周率近似值:", pi_approximation)


# ================================================================================
# 2. 数据类型与操作 (Data Types & Operations)
# ================================================================================

# Python 有多种内置数据类型。可以使用 type() 函数查看变量的类型。

# ----- 2.1 数字 (Numbers) -----
integer_number = 10         # 整数 (int)
float_number = 3.14       # 浮点数 (float)
complex_number = 1 + 2j     # 复数 (complex)

# 算术运算
# print(f"10 + 3 = {10 + 3}")      # 加
# print(f"10 - 3 = {10 - 3}")      # 减
# print(f"10 * 3 = {10 * 3}")      # 乘
# print(f"10 / 3 = {10 / 3}")      # 除 (结果是浮点数)
# print(f"10 // 3 = {10 // 3}")     # 整除 (结果是整数)
# print(f"10 % 3 = {10 % 3}")      # 取余
# print(f"10 ** 3 = {10 ** 3}")    # 幂运算

# ----- 2.2 字符串 (Strings) -----
# 字符串是不可变的字符序列，可以用单引号或双引号创建。
single_quote_str = '这是一个字符串'
double_quote_str = "这也是一个字符串"

# f-string (格式化字符串字面值)，是现代 Python 中最推荐的字符串格式化方法。
name = "Alice"
age = 30
greeting = f"大家好，我叫 {name}，我今年 {age} 岁了。"
# print(greeting)

# 字符串常用方法
my_string = "  Hello, World!  "
# print(f"原始: '{my_string}'")
# print(f"转为大写: {my_string.upper()}")
# print(f"转为小写: {my_string.lower()}")
# print(f"去除两端空白: '{my_string.strip()}'")
# print(f"替换: {my_string.replace('World', 'Python')}")
# print(f"分割: {my_string.split(',')}")

# 字符串索引和切片
# 索引从 0 开始
# H e l l o
# 0 1 2 3 4
# -5 -4 -3 -2 -1
word = "Hello"
# print(f"第一个字符: {word[0]}")
# print(f"最后一个字符: {word[-1]}")
# print(f"从索引1到索引3 (不含3) 的子串: {word[1:3]}")  # el
# print(f"从头到索引3 (不含3): {word[:3]}")  # Hel
# print(f"从索引2到结尾: {word[2:]}")  # llo

# ----- 2.3 布尔值 (Booleans) -----
# 只有两个值：True 和 False (首字母大写)
is_learning = True
is_tired = False

# 逻辑运算: and, or, not
# print(f"学习中 AND 不累: {is_learning and not is_tired}")  # True
# print(f"学习中 OR 累了: {is_learning or is_tired}")      # True

# 在条件判断中，0, None, 空字符串"", 空列表[], 空字典{} 等都被视为 False。

# ----- 2.4 列表 (Lists) -----
# 列表是可变的、有序的元素集合。可以包含不同类型的元素。用 [] 定义。
fruits = ["苹果", "香蕉", "橙子", 100]

# 访问元素 (同字符串索引)
# print(f"第一个水果: {fruits[0]}")

# 修改元素
fruits[0] = "草莓"
# print(f"修改后的列表: {fruits}")

# 列表常用方法
fruits.append("芒果")        # 在末尾添加元素
# print(f"添加后: {fruits}")
fruits.insert(1, "葡萄")       # 在指定索引处插入元素
# print(f"插入后: {fruits}")
removed_fruit = fruits.pop() # 移除并返回最后一个元素
# print(f"移除 {removed_fruit} 后: {fruits}")
# del fruits[0]               # 删除指定索引的元素
# print(f"删除第一个元素后: {fruits}")
# print(f"列表长度: {len(fruits)}")

# ----- 2.5 元组 (Tuples) -----
# 元组是不可变的、有序的元素集合。用 () 定义。
# 不可变意味着一旦创建，就不能修改、添加或删除元素。
point = (10, 20)
# print(f"坐标点: {point}")
# print(f"x 坐标: {point[0]}")
# point[0] = 15  # 这行会报错! TypeError: 'tuple' object does not support item assignment

# 元组通常用于存储不会改变的数据，比如坐标、配置信息等。
# 元组解包 (Unpacking)
x, y = point
# print(f"x={x}, y={y}")

# ----- 2.6 字典 (Dictionaries) -----
# 字典是可变的、无序的键值对 (key-value) 集合。用 {} 定义。
# 在 Python 3.7+ 版本中，字典是有序的，但我们通常不依赖这个特性。
person = {
    "name": "张三",
    "age": 25,
    "city": "北京",
    "skills": ["Python", "JavaScript"]
}

# 访问值
# print(f"姓名: {person['name']}")
# print(f"年龄: {person.get('age')}") # .get() 方法更安全，如果键不存在，返回 None 而不是报错

# 修改和添加
person['age'] = 26
person['email'] = "zhangsan@example.com"
# print(f"更新后的个人信息: {person}")

# 常用方法
# print(f"所有的键: {list(person.keys())}")
# print(f"所有的值: {list(person.values())}")
# print(f"所有的键值对: {list(person.items())}")

# ----- 2.7 集合 (Sets) -----
# 集合是可变的、无序的、不含重复元素的集合。用 {} 定义，但不能是空 {} (那是空字典)。
unique_numbers = {1, 2, 3, 2, 1, 4}
# print(f"集合 (自动去重): {unique_numbers}") # 输出 {1, 2, 3, 4}

# 创建空集合
empty_set = set()

# 集合操作
set_a = {1, 2, 3, 4}
set_b = {3, 4, 5, 6}
# print(f"交集: {set_a & set_b}")        # {3, 4}
# print(f"并集: {set_a | set_b}")        # {1, 2, 3, 4, 5, 6}
# print(f"差集 (A-B): {set_a - set_b}")   # {1, 2}
# print(f"对称差集: {set_a ^ set_b}")     # {1, 2, 5, 6}


# ================================================================================
# 3. 流程控制 (Control Flow)
# ================================================================================

# ----- 3.1 条件判断 (if, elif, else) -----
score = 85
# if score >= 90:
#     print("优秀")
# elif score >= 80:
#     print("良好")
# elif score >= 60:
#     print("及格")
# else:
#     print("不及格")

# ----- 3.2 for 循环 -----
# for 循环用于遍历任何可迭代对象（如列表、字符串、元组）。
# print("\n遍历列表:")
# for fruit in fruits:
#     print(fruit)
#
# print("\n遍历字符串:")
# for char in "Python":
#     print(char, end=" ") # end=" " 让 print 不换行
# print()

# 使用 range() 函数生成数字序列
# print("\n遍历 range(5):")
# for i in range(5): # 0, 1, 2, 3, 4
#     print(i)
#
# print("\n遍历 range(2, 6):")
# for i in range(2, 6): # 2, 3, 4, 5
#     print(i)
#
# print("\n遍历字典:")
# for key, value in person.items():
#     print(f"{key}: {value}")

# ----- 3.3 while 循环 -----
# 当条件为 True 时，while 循环会一直执行。
# count = 0
# while count < 5:
#     print(f"Count is: {count}")
#     count += 1 # 如果没有这句，会进入死循环！

# ----- 3.4 break, continue, pass -----
# break: 立即跳出整个循环。
# continue: 跳过当前这次循环，进入下一次循环。
# pass: 占位符，什么也不做。

# print("\nbreak, continue 示例:")
# for i in range(10):
#     if i == 3:
#         continue  # 当 i=3 时，跳过 print(i)，直接进入下一次循环 (i=4)
#     if i == 7:
#         break     # 当 i=7 时，终止整个循环
#     print(i)

# pass 的用例
def my_empty_function():
    pass # 以后再来实现这个函数


# ================================================================================
# 4. 函数 (Functions)
# ================================================================================

# 函数是可重用的代码块，用于执行特定任务。

# ----- 4.1 定义与调用 -----
def greet(name):
    """
    这是一个文档字符串 (docstring)，用于解释函数的功能。
    """
    print(f"你好, {name}!")

# 调用函数
# greet("世界")

# ----- 4.2 参数 -----
# 位置参数: 按顺序传递
def introduce(name, age):
    print(f"我叫 {name}, 今年 {age} 岁。")
# introduce("李四", 40)

# 关键字参数: 无需按顺序，通过参数名传递
# introduce(age=22, name="王五")

# 默认参数: 如果调用时不提供该参数，则使用默认值
def login(username, password="password123"):
    print(f"用户 {username} 正在使用密码 '{password}' 登录。")
# login("admin")
# login("user1", "my_secret")

# 可变参数 *args 和 **kwargs
# *args: 将多个位置参数打包成一个元组
def sum_all(*numbers):
    total = 0
    for num in numbers:
        total += num
    return total

# result = sum_all(1, 2, 3, 4, 5)
# print(f"总和是: {result}")

# **kwargs: 将多个关键字参数打包成一个字典
def display_info(**kwargs):
    for key, value in kwargs.items():
        print(f"{key}: {value}")

# display_info(name="小明", age=10, city="上海")

# ----- 4.3 返回值 -----
# 函数可以使用 return 语句返回一个值。如果没有 return，默认返回 None。
def add(a, b):
    return a + b

# sum_result = add(5, 3)
# print(f"5 + 3 = {sum_result}")

# ----- 4.4 作用域 (Scope) -----
# LEGB 规则: Local -> Enclosing -> Global -> Built-in
x = 10  # Global scope

def my_func():
    y = 20  # Local scope
    # print(f"函数内部: x={x}, y={y}")

# my_func()
# print(f"函数外部: x={x}")
# print(y) # 这行会报错! NameError: name 'y' is not defined

# ----- 4.5 Lambda 表达式 -----
# 一种创建小型匿名函数的方式。语法: lambda arguments: expression
# add_lambda = lambda a, b: a + b
# print(f"Lambda 函数结果: {add_lambda(10, 20)}")

# 通常用于需要一个简单函数的地方，比如排序的 key
points = [(1, 5), (4, 2), (2, 8)]
# 按每个元组的第二个元素排序
points.sort(key=lambda point: point[1])
# print(f"排序后的点: {points}")


# ================================================================================
# 5. 面向对象编程 (Object-Oriented Programming - OOP)
# ================================================================================

# OOP 是一种将数据和操作数据的方法捆绑在一起的编程范式。

# ----- 5.1 类与对象 -----
# 类 (Class): 创建对象的蓝图或模板。
# 对象 (Object): 类的实例。

class Dog:
    # 类属性 (Class Attribute)，所有实例共享
    species = "Canis familiaris"

    # 构造函数 (Initializer/Constructor)，在创建新对象时自动调用
    def __init__(self, name, age):
        # 实例属性 (Instance Attribute)，每个实例独有
        self.name = name
        self.age = age

    # 实例方法 (Instance Method)
    def bark(self):
        return "汪汪!"

    def describe(self):
        return f"{self.name} is {self.age} years old."

# 创建对象 (实例化)
my_dog = Dog("旺财", 3)
your_dog = Dog("小黑", 5)

# 访问属性和调用方法
# print(f"{my_dog.name} 的种类是 {my_dog.species}")
# print(my_dog.describe())
# print(f"{my_dog.name} 在叫: {my_dog.bark()}")

# ----- 5.2 继承 (Inheritance) -----
# 继承允许我们定义一个继承另一个类所有方法和属性的类。
# 父类 (Parent Class) / 基类 (Base Class)
# 子类 (Child Class) / 派生类 (Derived Class)

class GoldenRetriever(Dog): # GoldenRetriever 继承自 Dog
    def __init__(self, name, age, skill):
        # 使用 super() 调用父类的构造函数
        super().__init__(name, age)
        self.skill = skill

    # 重写 (Override) 父类的方法
    def bark(self):
        return "嗷呜~"

    # 添加新方法
    def fetch(self):
        return f"{self.name} is fetching the ball with skill: {self.skill}!"

my_golden = GoldenRetriever("金宝", 2, "飞盘")
# print(my_golden.describe())  # 调用从父类继承的方法
# print(my_golden.bark())      # 调用子类重写的方法
# print(my_golden.fetch())     # 调用子类自己的方法

# ----- 5.3 魔术方法 (Magic Methods) -----
# 以双下划线开头和结尾的方法，如 `__init__`, `__str__`。
# 它们在特定情况下会自动被 Python 调用。

class Car:
    def __init__(self, brand, model):
        self.brand = brand
        self.model = model

    def __str__(self):
        # 当我们 print(一个对象) 时，__str__ 方法会被调用
        return f"A {self.brand} {self.model}"

    def __repr__(self):
        # 开发者友好的表示，通常用于调试
        return f"Car('{self.brand}', '{self.model}')"

my_car = Car("Toyota", "Camry")
# print(my_car) # 会自动调用 __str__
# print(repr(my_car)) # 会调用 __repr__

# ================================================================================
# 6. 错误与异常处理 (Error & Exception Handling)
# ================================================================================

# ----- 6.1 try, except, else, finally -----
# try: 包含可能出错的代码。
# except: 如果 try 块中发生特定类型的错误，执行这里的代码。
# else: 如果 try 块中没有发生错误，执行这里的代码。
# finally: 无论是否发生错误，总是执行这里的代码（通常用于清理工作）。

try:
    numerator = 10
    denominator = 0 # 尝试改为 2 看看效果
    result = numerator / denominator
except ZeroDivisionError:
    print("错误：除数不能为零！")
except TypeError:
    print("错误：发生了类型错误！")
else:
    print(f"结果是: {result}")
finally:
    print("计算结束。")

# ----- 6.2 raise -----
# 我们可以使用 raise 关键字主动抛出一个异常。
def set_age(age):
    if age < 0:
        raise ValueError("年龄不能是负数！")
    print(f"年龄设置为: {age}")

# try:
#     set_age(-5)
# except ValueError as e:
#     print(f"捕获到异常: {e}")


# ================================================================================
# 7. 文件操作 (File I/O)
# ================================================================================

# ----- 7.3 with 语句 (The 'with' Statement) -----
# `with` 语句是处理文件的最佳方式，因为它能确保文件在操作完成后被自动关闭，
# 即使在操作过程中发生异常。

# ----- 7.2 写入文件 (Writing Files) -----
# 'w' 模式: 写入 (会覆盖已有内容)
# 'a' 模式: 追加 (在文件末尾添加内容)
# try:
#     with open("my_file.txt", "w", encoding="utf-8") as f:
#         f.write("这是第一行。\n")
#         f.write("这是第二行。\n")
#     print("文件写入成功。")
# except Exception as e:
#     print(f"文件写入失败: {e}")

# ----- 7.1 读取文件 (Reading Files) -----
# 'r' 模式: 读取 (默认模式)
# try:
#     with open("my_file.txt", "r", encoding="utf-8") as f:
#         # content = f.read() # 一次性读取所有内容
#         # print("文件内容:\n", content)
#
#         # 逐行读取
#         for line in f:
#             print(line.strip()) # strip() 去除行尾的换行符
# except FileNotFoundError:
#     print("错误：文件未找到！")
# except Exception as e:
#     print(f"读取文件时发生错误: {e}")


# ================================================================================
# 8. 模块与包 (Modules & Packages)
# ================================================================================
# 模块是一个包含 Python 定义和语句的文件 (即 .py 文件)。
# 包是模块的集合，通过文件夹和 `__init__.py` 文件来组织。

# ----- 8.1 import -----
# 导入整个模块
import math
import random

# print(f"圆周率: {math.pi}")
# print(f"16 的平方根: {math.sqrt(16)}")
# print(f"0到100的随机整数: {random.randint(0, 100)}")

# ----- 8.2 from ... import ... -----
# 从模块中导入特定的函数或变量
from collections import Counter

# word_counts = Counter("hello world")
# print(f"字母统计: {word_counts}")
# print(f"字母 'l' 出现了 {word_counts['l']} 次")

# ----- 8.3 if __name__ == "__main__": -----
# 这是一个非常重要的代码块。
# 当你直接运行这个 .py 文件时, `__name__` 的值是 `"__main__"`。
# 当你把这个文件作为一个模块导入到另一个文件中时, `__name__` 的值是模块名 (文件名)。
# 所以，这个代码块里的代码只在直接运行此文件时执行，导入时不执行。
# 这使得我们可以把可执行代码和可导入的函数/类放在同一个文件中。

def main_function():
    print("这是一个主要的功能函数。")

if __name__ == "__main__":
    print(f"\n当前文件 `__name__` 是 '{__name__}'，所以我会执行这里的代码。")
    main_function()
    print("脚本执行完毕。")


# ================================================================================
# 9. 高级主题 (Advanced Topics)
# ================================================================================

# ----- 9.1 列表/字典/集合推导式 (Comprehensions) -----
# 一种用非常简洁和可读的方式创建列表、字典或集合的语法。

# 列表推导式
squares = [x**2 for x in range(10)]
# print(f"0-9的平方数: {squares}")

# 字典推导式
square_dict = {x: x**2 for x in range(5)}
# print(f"数字及其平方的字典: {square_dict}")

# 集合推导式
even_numbers_set = {x for x in range(10) if x % 2 == 0}
# print(f"0-9中的偶数集合: {even_numbers_set}")

# ----- 9.2 生成器 (Generators) & yield -----
# 生成器是一种特殊的迭代器，它不会一次性把所有值都加载到内存中，
# 而是在你每次请求时才生成下一个值。这在处理大数据集时非常节省内存。
# 使用 yield 关键字的函数就是一个生成器函数。

def count_up_to(max_val):
    count = 1
    while count <= max_val:
        yield count
        count += 1

# counter = count_up_to(5)
# print("使用生成器:")
# print(next(counter)) # 1
# print(next(counter)) # 2
# for num in counter:  # 会从上次停止的地方继续
#     print(num)     # 3, 4, 5

# ----- 9.3 装饰器 (Decorators) -----
# 装饰器本质上是一个函数，它允许我们不修改原函数代码的情况下，为该函数添加额外的功能。
# 它是 Python 中一个非常强大的特性，广泛用于日志、性能测试、事务处理等。

import time

def timing_decorator(func):
    def wrapper(*args, **kwargs):
        start_time = time.time()
        result = func(*args, **kwargs)
        end_time = time.time()
        print(f"函数 {func.__name__} 运行耗时: {end_time - start_time:.4f} 秒")
        return result
    return wrapper

@timing_decorator
def slow_function(delay):
    print(f"正在执行一个慢速任务...")
    time.sleep(delay)
    print("任务完成！")
    return "OK"

# result = slow_function(2)
# print(f"慢速函数返回: {result}")

# ----- 9.4 类型提示 (Type Hinting) -----
# 从 Python 3.5 开始引入，它允许我们为变量、函数参数和返回值添加类型信息。
# 这不会影响程序的运行，但可以极大地提高代码的可读性，并帮助静态代码分析工具（如 MyPy）和 IDE 发现潜在的错误。

def greet_with_type(name: str, repeat: int = 1) -> str:
    """
    一个带有类型提示的函数。
    :param name: 姓名 (字符串)
    :param repeat: 重复次数 (整数)
    :return: 问候语 (字符串)
    """
    return f"你好, {name}! " * repeat

# greeting_message = greet_with_type("开发者", 3)
# print(greeting_message)

# 即使你传递了错误的类型，代码仍然会运行（但可能会在运行时报错）
# greet_with_type(123) # IDE 可能会在这里给你一个警告

"""
================================================================================
                                学习路径建议
================================================================================

你已经完成了 Python 核心语法的概览！但这只是一个开始。

下一步该做什么？

1.  **深入标准库**:
    -   `os`: 与操作系统交互
    -   `sys`: 与 Python 解释器交互
    -   `datetime`:处理日期和时间
    -   `re`: 正则表达式
    -   `json`: 处理 JSON 数据
    -   `collections`: 更多高级数据结构 (Counter, defaultdict, etc.)

2.  **学习包管理**:
    -   了解 `pip`，Python 的包安装器，用于安装第三方库。
    -   了解虚拟环境 (`venv`)，为不同项目隔离依赖。

3.  **选择一个方向并深入**:
    -   **Web 开发**: 学习 Django 或 Flask 框架。
    -   **数据科学/机器学习**: 学习 NumPy, Pandas, Scikit-learn, TensorFlow, PyTorch。
    -   **自动化脚本**: 学习如何使用 Python 自动化日常任务。
    -   **桌面应用**: 学习 PyQt 或 Tkinter。

4.  **持续实践**:
    -   在 LeetCode, HackerRank 等网站上解决编程问题。
    -   为你自己或朋友做一个小项目。
    -   参与开源项目。

编程是一门手艺，需要不断练习才能精通。祝你学习愉快！
================================================================================
"""