import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns
from datetime import datetime
import kagglehub

# Download latest version
path = kagglehub.dataset_download("olistbr/brazilian-ecommerce")

print("Path to dataset files:", path)

# 加载数据集
orders = pd.read_csv('data/ecom/olist_orders_dataset.csv')
order_items = pd.read_csv('data/ecom/olist_order_items_dataset.csv')
customers = pd.read_csv('data/ecom/olist_customers_dataset.csv')
products = pd.read_csv('data/ecom/olist_products_dataset.csv')

# 合并订单主表与明细表
merged = pd.merge(
    orders[['order_id', 'customer_id', 'order_purchase_timestamp']],
    order_items[['order_id', 'product_id', 'price', 'freight_value']],
    on='order_id'
)

# 合并客户信息
merged = pd.merge(merged, customers[['customer_id', 'customer_state']], on='customer_id')

# 日期处理
merged['purchase_date'] = pd.to_datetime(merged['order_purchase_timestamp']).dt.date
merged['purchase_month'] = pd.to_datetime(merged['order_purchase_timestamp']).dt.to_period('M')

# 删除重复值
merged = merged.drop_duplicates(subset=['order_id', 'product_id'])

# 处理异常价格（过滤价格<10或>5000的异常记录）
merged = merged[(merged['price'] >= 10) & (merged['price'] <= 5000)]

print("清洗后数据维度:", merged.shape)

# 创建总金额字段
merged['total_amount'] = merged['price'] + merged['freight_value']

# 每月销售分析
monthly_sales = merged.groupby('purchase_month').agg({
    'order_id': 'nunique',
    'total_amount': 'sum',
    'price': 'mean'
}).reset_index()
monthly_sales.columns = ['Month', 'Order_Count', 'GMV', 'Avg_Price']

# 客户分层（RFM模型）
last_date = merged['purchase_date'].max()
rfm = merged.groupby('customer_id').agg({
    'purchase_date': lambda x: (last_date - x.max()).days,
    'order_id': 'nunique',
    'total_amount': 'sum'
})
rfm.columns = ['Recency', 'Frequency', 'Monetary']
rfm['RFM_Score'] = rfm['Recency'].rank(ascending=False) + \
                   rfm['Frequency'].rank(ascending=True) + \
                   rfm['Monetary'].rank(ascending=True)
# 地理分布分析
geo_analysis = merged.groupby('customer_state').agg({
    'order_id': 'nunique',
    'total_amount': 'sum'
}).sort_values('total_amount', ascending=False)

# 商品关联分析（使用Apriori算法）
from mlxtend.frequent_patterns import apriori

# 创建订单-商品矩阵
order_product = pd.crosstab(
    merged['order_id'], 
    merged['product_id']
).applymap(lambda x: 1 if x > 0 else 0)

# 找出频繁项集
frequent_itemsets = apriori(order_product, min_support=0.01, use_colnames=True)

plt.figure(figsize=(18, 12))

# 时间趋势分析
plt.subplot(2,2,1)
sns.lineplot(x='Month', y='GMV', data=monthly_sales)
plt.title('Monthly GMV Trend')
plt.xticks(rotation=45)

# 地理分布热力图
plt.subplot(2,2,2)
sns.heatmap(
    geo_analysis[['total_amount']].sort_values('total_amount', ascending=False).head(10),
    annot=True, 
    fmt=".0f",
    cmap="YlGnBu"
)
plt.title('Top 10 States by Revenue')

# 价格分布箱线图
plt.subplot(2,2,3)
sns.boxplot(x='customer_state', y='price', 
           data=merged[merged['customer_state'].isin(['SP', 'RJ', 'MG'])])
plt.ylim(0, 500)
plt.title('Price Distribution by State')

# RFM客户分群
plt.subplot(2,2,4)
sns.scatterplot(x='Recency', y='Monetary', 
               size='Frequency', 
               data=rfm.sample(1000),
               alpha=0.6)
plt.title('RFM Customer Segmentation')

plt.tight_layout()
plt.show()