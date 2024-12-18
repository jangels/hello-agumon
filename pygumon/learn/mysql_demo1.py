import mysql.connector
# add db config
mydb = mysql.connector.connect(
  host="",
  user="",
  password="",
  database=""
)
print(mydb)

mycursor = mydb.cursor()

mycursor.execute("SELECT * FROM batch_price_job")

myresult = mycursor.fetchall()

for x in myresult:
  print(x)