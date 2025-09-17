import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

# 创建示例数据
data = {
    'Date': pd.date_range(start='2023-01-01', periods=100),
    'Product': np.random.choice(['A', 'B', 'C'], 100),
    'Sales': np.random.randint(100, 1000, 100),
    'Price': np.random.uniform(10, 50, 100).round(2),
    'Rating': np.random.choice([3, 4, 5, np.nan], 100)
}

# 创建 DataFrame
df = pd.DataFrame(data)
print("原始数据示例：")
print(df.head(3))

# 数据清洗
# 处理缺失值
df['Rating'] = df['Rating'].fillna(df['Rating'].mean())
# 转换日期格式
df['Month'] = df['Date'].dt.month_name()

# 数据分析
# 基本统计
print("\n基本统计信息：")
print(df.describe())

# 按产品聚合
product_stats = df.groupby('Product').agg({
    'Sales': 'sum',
    'Price': 'mean',
    'Rating': 'mean'
}).reset_index()
print("\n产品统计：")
print(product_stats)

# 数据分析结果可视化
plt.figure(figsize=(12, 6))

# 销售额分布直方图
plt.subplot(1, 2, 1)
df['Sales'].plot(kind='hist', bins=15, color='skyblue', edgecolor='black')
plt.title('Sales Distribution')
plt.xlabel('Sales Amount')

# 产品销售额占比饼图
plt.subplot(1, 2, 2)
product_stats.set_index('Product')['Sales'].plot(
    kind='pie', 
    autopct='%1.1f%%',
    colors=['gold', 'lightcoral', 'lightskyblue']
)
plt.title('Sales by Product')
plt.ylabel('')

plt.tight_layout()
plt.show()

# 高级分析：计算移动平均
df['7D_Sales_MA'] = df['Sales'].rolling(window=7).mean()

# 保存处理后的数据
df.to_csv('processed_sales_data.csv', index=False)