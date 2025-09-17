from selenium import webdriver
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

def health_check(site_config):
    driver = webdriver.Chrome()
    results = []
    
    for check in site_config:
        try:
            driver.get(check['url'])
            WebDriverWait(driver, 10).until(
                EC.presence_of_element_located((By.CSS_SELECTOR, check['element']))
            )
            results.append({"name": check['name'], "status": "正常"})
        except Exception as e:
            results.append({"name": check['name'], "status": f"故障: {str(e)}"})
    
    driver.quit()
    return results

# 配置示例
config = [
    {"name": "首页加载", "url": "https://www.shapefire.cn", "element": ".header"}
]

print(health_check(config))