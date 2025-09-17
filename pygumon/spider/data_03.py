import pandas as pd
import matplotlib.pyplot as plt
import numpy as np

# 生成模拟数据（100条记录）
np.random.seed(42)
data = {
    '日期': pd.date_range('2023-01-01', periods=100),
    '商品': np.random.choice(['苹果', '香蕉', '牛奶', '鸡蛋', '面包'], 100),
    '销量': np.random.randint(1, 20, 100),
    '单价': [5.0, 3.0, 8.0, 2.0, 4.0] * 20,  # 固定商品单价
    '是否促销': np.random.choice([0, 1], 100, p=[0.7, 0.3])
}

df = pd.DataFrame(data)
print("原始数据示例：")
print(df.head(3))

# 数据清洗
# 添加销售额列
df['销售额'] = df['销量'] * df['单价']

# 数据分析
# 1. 按商品统计总销量和销售额
product_stats = df.groupby('商品').agg({
    '销量': 'sum',
    '销售额': 'sum'
}).sort_values('销售额', ascending=False)

# 2. 促销效果分析
promo_stats = df.groupby('是否促销').agg({
    '销售额': 'mean'
}).rename(index={0:'非促销', 1:'促销'})

# 3. 每日销售趋势
daily_sales = df.groupby('日期')['销售额'].sum()

# 可视化分析
plt.figure(figsize=(15,4))

# 商品销售柱状图
plt.subplot(1,3,1)
product_stats['销售额'].plot(kind='bar', color='skyblue')
plt.title('商品销售额排名')
plt.xticks(rotation=45)

# 促销效果饼图
plt.subplot(1,3,2)
promo_stats['销售额'].plot(kind='pie', autopct='%1.1f%%', colors=['lightgreen', 'gold'])
plt.title('促销vs非促销销售额占比')

# 销售趋势折线图
plt.subplot(1,3,3)
daily_sales.plot(kind='line', color='coral')
plt.title('每日销售额趋势')

plt.tight_layout()
plt.show()

# 输出关键结论
print("\n核心结论：")
print(f"最畅销商品：{product_stats.index[0]}（{product_stats['销售额'].iloc[0]:.1f}元）")
print(f"促销期间平均销售额：{promo_stats.loc['促销', '销售额']:.1f}元/天")
print(f"最高单日销售额：{daily_sales.max():.1f}元")