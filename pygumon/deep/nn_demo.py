import numpy as np

# 定义激活函数（Sigmoid）和它的导数
def sigmoid(x):
    return 1 / (1 + np.exp(-x))

def sigmoid_derivative(x):
    return x * (1 - x)

# 创建训练数据（输入和对应的输出）
inputs = np.array([[0, 0],
                   [0, 1],
                   [1, 0],
                   [1, 1]])
# 输出目标
outputs = np.array([[0], [1], [1], [0]])  # XOR 问题

# 设置随机种子，方便结果复现
np.random.seed(42)

# 初始化权重和偏置
input_layer_neurons = inputs.shape[1]  # 输入层神经元数量
hidden_layer_neurons = 2  # 隐藏层神经元数量
output_layer_neurons = 1  # 输出层神经元数量

# 随机初始化权重和偏置
hidden_weights = np.random.uniform(size=(input_layer_neurons, hidden_layer_neurons))
hidden_bias = np.random.uniform(size=(1, hidden_layer_neurons))
output_weights = np.random.uniform(size=(hidden_layer_neurons, output_layer_neurons))
output_bias = np.random.uniform(size=(1, output_layer_neurons))

# 学习率
learning_rate = 0.1

# 训练神经网络
for epoch in range(10000):
    # 前向传播
    hidden_layer_input = np.dot(inputs, hidden_weights) + hidden_bias
    hidden_layer_output = sigmoid(hidden_layer_input)

    output_layer_input = np.dot(hidden_layer_output, output_weights) + output_bias
    predicted_output = sigmoid(output_layer_input)

    # 计算误差
    error = outputs - predicted_output

    # 反向传播
    d_predicted_output = error * sigmoid_derivative(predicted_output)
    error_hidden_layer = d_predicted_output.dot(output_weights.T)
    d_hidden_layer = error_hidden_layer * sigmoid_derivative(hidden_layer_output)

    # 更新权重和偏置
    output_weights += hidden_layer_output.T.dot(d_predicted_output) * learning_rate
    output_bias += np.sum(d_predicted_output, axis=0, keepdims=True) * learning_rate
    hidden_weights += inputs.T.dot(d_hidden_layer) * learning_rate
    hidden_bias += np.sum(d_hidden_layer, axis=0, keepdims=True) * learning_rate

    # 可选：打印误差
    if epoch % 1000 == 0:
        print(f"Epoch {epoch} Error: {np.mean(np.abs(error))}")

# 输出最终预测结果
print("Final Predicted Output:")
print(predicted_output)
print("Final weights and bias:")
print(output_weights)
print(output_bias)
print(hidden_weights)
print(hidden_bias)
