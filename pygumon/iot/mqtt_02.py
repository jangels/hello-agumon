import paho.mqtt.client as mqtt

BROKER = "123.57.243.92"
PORT = 1883
TOPIC = "test/topic"
CLIENT_ID = "python_sub"

def on_connect(client, userdata, flags, rc):
    print("Connected with code: " + str(rc))
    client.subscribe(TOPIC, qos=1)  

def on_message(client, userdata, msg):
    print("Received:" + msg.payload.decode('utf-8'))

client = mqtt.Client(client_id=CLIENT_ID)
client.on_connect = on_connect
client.on_message = on_message

client.connect(BROKER, PORT)
client.loop_forever()  