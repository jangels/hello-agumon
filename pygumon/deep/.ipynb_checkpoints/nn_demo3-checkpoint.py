import tensorflow as tf
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense
from tensorflow.keras.optimizers import Adam
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
import numpy as np

# 创建训练数据（XOR 问题）
X = np.array([[0, 0],
              [0, 1],
              [1, 0],
              [1, 1]])

y = np.array([[0], [1], [1], [0]])

# 数据标准化：将输入特征进行归一化/标准化处理
scaler = StandardScaler()
X_scaled = scaler.fit_transform(X)

# 划分训练集和测试集（这里使用全部数据进行训练，实际中会有更多数据）
X_train, X_test, y_train, y_test = train_test_split(X_scaled, y, test_size=0.2, random_state=42)

# 构建神经网络模型
model = Sequential()

# 第一层隐藏层，包含 8 个神经元，激活函数为 ReLU
model.add(Dense(8, input_dim=2, activation='relu'))

# 第二层隐藏层，包含 4 个神经元，激活函数为 ReLU
model.add(Dense(4, activation='relu'))

# 输出层，包含一个神经元，激活函数为 Sigmoid（二分类问题）
model.add(Dense(1, activation='sigmoid'))

# 编译模型，选择 Adam 优化器，损失函数使用二分类交叉熵，评估指标选择准确率
model.compile(optimizer=Adam(learning_rate=0.001), loss='binary_crossentropy', metrics=['accuracy'])

# 训练模型，使用 1000 次迭代，并设置验证集来防止过拟合
history = model.fit(X_train, y_train, epochs=1000, batch_size=4, validation_data=(X_test, y_test), verbose=1)

# 打印最终的训练结果
print("Training finished")

# 在测试集上评估模型表现
loss, accuracy = model.evaluate(X_test, y_test)
print(f"Test Loss: {loss:.4f}, Test Accuracy: {accuracy:.4f}")

# 进行预测
predictions = model.predict(X_test)
print("Predictions on test data:")
print(predictions)
print("test:")
print(X_test)
print(y_test)

weights = model.get_weights()

# 输出权重
for i, weight in enumerate(weights):
    print(f"Weight {i}:")
    print(weight)

for layer in model.layers:
    weights = layer.get_weights()
    print(f"Layer: {layer.name}")
    for w in weights:
        print(w.shape)

