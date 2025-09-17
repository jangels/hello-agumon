import torch

# 设置数据类型和设备
dtype = torch.float  # 张量数据类型为浮点型
device = torch.device("cpu")  # 本次计算在 CPU 上进行

# 创建并打印两个随机张量 a 和 b
a = torch.randn(2, 3, device=device, dtype=dtype)  # 创建一个 2x3 的随机张量
b = torch.randn(2, 3, device=device, dtype=dtype)  # 创建另一个 2x3 的随机张量

print("张量 a:")
print(a)

print("张量 b:")
print(b)

# 逐元素相乘并输出结果
print("a 和 b 的逐元素乘积:")
print(a * b)

# 输出张量 a 所有元素的总和
print("张量 a 所有元素的总和:")
print(a.sum())

# 输出张量 a 中第 2 行第 3 列的元素（注意索引从 0 开始）
print("张量 a 第 2 行第 3 列的元素:")
print(a[1, 2])

# 输出张量 a 中的最大值
print("张量 a 中的最大值:")
print(a.max())