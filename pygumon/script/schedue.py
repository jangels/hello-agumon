import schedule
import os
import time

def remind():
    os.system('osascript -e \'display notification "记得总结今天的工作！" with title "总结提醒"\'')
    print("现在是下午5点，记得做总结！")

# 每天下午 5 点执行
schedule.every().day.at("17:00").do(remind)

while True:
    schedule.run_pending()
    time.sleep(1)
