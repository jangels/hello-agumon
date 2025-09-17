import requests
import json
import time

# 配置信息
question_id = "1893377741723775811"  # 目标问题ID
headers = {
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36",
    "Referer": f"https://www.zhihu.com/question/{question_id}",
    # 登录后可从浏览器获取Cookie（非必须，但可提高成功率）
    "Cookie": "83ae8c7588354090bc6371972e65ff3b|1744200808|1744200808"
}

# 知乎API参数
params = {
    "include": "data[*].is_normal,admin_closed_comment,reward_info,is_collapsed,annotation_action...",  # 可简化此参数
    "offset": 0,  # 分页起始位置
    "limit": 20,   # 每页数量
    "sort_by": "updated",
}

def fetch_answers(question_id, max_count=20):
    url = f"https://www.zhihu.com/api/v4/questions/{question_id}/feeds"
    answers = []
    
    while params["offset"] < max_count:
        response = requests.get(url, headers=headers, params=params)
        if response.status_code != 200:
            print(f"请求失败，状态码: {response.status_code}")
            break
        
        data = response.json()
        for item in data.get("data", []):
            if "target" in item:
                answer = item["target"]
                content = answer.get("content", "")
                author = answer["author"]["name"]
                created_time = answer["created_time"]
                answers.append({
                    "author": author,
                    "content": content,
                    "time": time.strftime("%Y-%m-%d %H:%M:%S", time.localtime(created_time))
                })
        
        # 判断是否还有下一页
        if data.get("paging", {}).get("is_end", True):
            break
        params["offset"] += params["limit"]
        time.sleep(2)  # 降低请求频率
        
    return answers

# 执行爬取
answers = fetch_answers(question_id)
print(f"共爬取到 {len(answers)} 条回答")
for idx, ans in enumerate(answers, 1):
    print(f"\n=== 回答 {idx} ===")
    print(f"作者: {ans['author']}")
    print(f"时间: {ans['time']}")
    print(f"内容: {ans['content'][:100]}...")  # 截取前100字符