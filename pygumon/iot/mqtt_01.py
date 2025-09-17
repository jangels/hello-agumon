# coding=utf-8
import paho.mqtt.client as mqtt
import time

BROKER = "123.57.243.92"
PORT = 1883
TOPIC = "test/topic"
CLIENT_ID = "python_pub"

def on_connect(client, userdata, flags, rc):
    print("Connected with code: " + str(rc))

client = mqtt.Client(client_id=CLIENT_ID)
client.on_connect = on_connect

client.connect(BROKER, PORT, keepalive=60)
client.loop_start() 

try:
    count = 0
    while True:
        msg = f"Fuck 丁哥 塔斯订购! {count}"
        client.publish(TOPIC, msg.encode('utf-8'), qos=1, retain=True)
        print(f"Published: {msg}")
        count += 1
        time.sleep(3)
except KeyboardInterrupt:
    client.disconnect()