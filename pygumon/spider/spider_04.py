from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

# 自动查找环境变量中的驱动
driver = webdriver.Chrome()  

# 手动指定驱动路径
# driver = webdriver.Chrome(executable_path=r"D:\drivers\chromedriver.exe")

driver.get("https://www.shapefire.cn")

