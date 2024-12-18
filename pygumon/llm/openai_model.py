import openai # 导入OpenAI
openai.api_key = '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' # API Key

prompt_text = "您是一位专业的鲜花店文案撰写员。对于售价为{}元的{}，您能提供一个吸引人的简短描述吗？" # 设置提示

flowers = ["玫瑰", "百合", "康乃馨"]
prices = ["50", "30", "20"]

# 循环调用Text模型的Completion方法，生成文案
for flower, price in zip(flowers, prices):
    prompt = prompt_text.format(price, flower)
    response = openai.Completion.create(
        engine="text-davinci-003",
        prompt=prompt,
        max_tokens=100
    )
    print(response.choices[0].text.strip()) # 输出文案