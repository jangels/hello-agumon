'''
Author: 刘振华2 liuzhenhua3@songguo7.com
Date: 2025-10-09 19:55:18
LastEditors: 刘振华2 liuzhenhua3@songguo7.com
LastEditTime: 2025-10-09 19:55:25
FilePath: /pygumon/tools/cn_his.py
Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
'''
import json

with open("../data/china_emperors.json", "r", encoding="utf-8") as f:
    records = json.load(f)

def lookup_emperor(year):
    return [r for r in records if r["start"] <= year <= r["end"]]

# 示例：查询 1405 年是谁在位
# print(lookup_emperor(1405))

if __name__ == "__main__":
        try:
            input_year_str = input("请输入年份 (輸入 'q' 退出): ")
            
            if input_year_str.lower() == 'q':
                print("程式已退出。")

            input_year = int(input_year_str)
            print(lookup_emperor(input_year))

        except ValueError:
            print("無效輸入，請輸入一個純數字年份。")
        except KeyboardInterrupt:
            print("\n程式已退出。")
