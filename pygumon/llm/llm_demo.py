from langchain.llms import OpenAI
from langchain.chat_models import ChatOpenAI
import os

os.environ['OPENAI_API_KEY'] = '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'

llm = OpenAI()
chat_model = ChatOpenAI()

text = "What would be a good company name for a company that makes colorful socks?"

result = llm.predict(text)
# >> Feetful of Fun
print(result)

result2 = chat_model.predict(text)
# >> Socks O'Color
print(result2)

