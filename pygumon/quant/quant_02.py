import yfinance as yf
import pandas as pd
import matplotlib.pyplot as plt

# 获取股票数据
#symbol = "TSLA"
#symbol = "1810.HK"
symbol = "600519.SS"  # 茅台
start_date = "2023-01-01"
end_date = "2025-04-01"

data = yf.download(symbol, start=start_date, end=end_date)
# 简单的数据分析
print(data.describe())

# 绘制股价走势图
data['Close'].plot(figsize=(10, 6), label=symbol)
plt.title(f"{symbol} Stock Price")
plt.xlabel("Date")
plt.ylabel("Price")
plt.legend()
plt.show()