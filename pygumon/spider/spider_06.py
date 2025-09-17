from selenium import webdriver
import time
import smtplib
from email.mime.text import MIMEText

def price_monitor(url, target_price):
    driver = webdriver.Chrome()
    driver.get(url)
    
    while True:
        price = driver.find_element(By.CSS_SELECTOR, ".product-price").text
        price_num = float(price.replace('¥', ''))
        
        if price_num < target_price:
            send_email(f"价格提醒：当前价 {price}，低于目标价 {target_price}")
            break
        
        time.sleep(3600)  # 每小时检查一次
        driver.refresh()

def send_email(content):
    msg = MIMEText(content)
    msg['Subject'] = '价格监控提醒'
    msg['From'] = 'sender@example.com'
    msg['To'] = 'receiver@example.com'
    
    with smtplib.SMTP('smtp.example.com', 587) as server:
        server.starttls()
        server.login('user', 'password')
        server.send_message(msg)

# 使用示例
price_monitor("https://item.jd.com/123456.html", 999)