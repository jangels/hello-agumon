from selenium import webdriver
from selenium.webdriver.common.by import By
import time

# 1. 启动 Chrome 浏览器（需提前安装ChromeDriver）
driver = webdriver.Chrome()  # 如果驱动不在PATH，需指定路径：webdriver.Chrome(executable_path="驱动路径")

# 2. 打开百度首页
driver.get("https://www.baidu.com")

# 3. 定位搜索框并输入关键词
search_box = driver.find_element(By.ID, "kw")  # 百度搜索框的ID是"kw"
search_box.send_keys("Python教程")

# 4. 点击搜索按钮
driver.find_element(By.ID, "su").click()  # 百度搜索按钮的ID是"su"

# 5. 等待2秒查看结果
time.sleep(2)

# 6. 关闭浏览器
driver.quit()