from transformers import BertTokenizer, BertForSequenceClassification
import torch

# 加载预训练模型和 tokenizer
tokenizer = BertTokenizer.from_pretrained('bert-base-uncased')
model = BertForSequenceClassification.from_pretrained('bert-base-uncased', num_labels=2) # 2 分类

# 输入文本
text = "This is a positive example."

# 文本编码
inputs = tokenizer(text, return_tensors="pt")

# 推理
with torch.no_grad():
    outputs = model(**inputs)

# 预测结果
predictions = torch.argmax(outputs.logits, dim=-1)
print(predictions)