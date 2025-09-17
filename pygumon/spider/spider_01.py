
import requests
from bs4 import BeautifulSoup

url = "https://www.baidu.com"  # 以百度为例
headers = {
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"
}

response = requests.get(url, headers=headers)
response.encoding = "UTF-8"  # 百度使用 UTF-8 编码

soup = BeautifulSoup(response.text, "html.parser")
title = soup.find("title").text
print(title)  # 应输出 "百度一下，你就知道"

paragraphs = soup.find_all("p")
    
print("\n段落内容:")
for idx, p in enumerate(paragraphs, 1):
    print(f"{idx}. {p.text.strip()}")

# 写入文件（无乱码）
with open("baidu_title.txt", "w", encoding="utf-8") as f:
    f.write(title)