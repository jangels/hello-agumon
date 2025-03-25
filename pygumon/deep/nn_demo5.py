import tensorflow as tf
import matplotlib.pyplot as plt
import numpy as np

# 生成随机数据
x = np.random.rand(100, 1)
y = 2 * x + 1 + 0.1*np.random.randn(100, 1)

# 定义模型
model = tf.keras.Sequential([
    tf.keras.layers.Dense(units=1, input_shape=[1])
])

# 编译模型
model.compile(optimizer='sgd', loss='mean_squared_error')

# 训练模型
model.fit(x, y, epochs=1000)

# 预测新数据
x_test = np.array([[0.1], [0.5]])
y_pred = model.predict(x_test)
print(y_pred)

# 可视化
plt.scatter(x, y, label='Original data')
plt.plot(x_test, y_pred, color='red', label='Prediction')
plt.legend()
plt.show()

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