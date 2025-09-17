from selenium import webdriver
driver = webdriver.Chrome()
driver.get("https://www.zhihu.com/question/1893377741723775811")
html = driver.page_source