<h1 align="center" id="title">Bus Routing Scheduler</h1>

<p id="description">Java project for Bus CRUD Routes CRUD with user authentication.</p>

<h2>🚀 Demo</h2>

[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

<h2>🧐 Features</h2>
Here're some of the project's best features:
User Authentication via JWT
Buses CRUD with validations
Route CRUD with validations
Mongo DB as primary DB with buses routes locations and user data
Admin and Standard users with create/update restrictions on non admin users
<h2>🛠️ Installation Steps:</h2>
<p>1. Initiate mongo db server on local at localhost:27017</p>
<p>2. Maven clean and install to run the tomcat server.</p>
<p>3. Admin user username and password both "admin"</p>

<p>
curl -X 'POST' \
  'http://localhost:8080/api/v1/authenticate' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "username": "admin",
  "password": "admin"
}'
</p>

<p>4. Standard user username and password both "user"</p>


<p>curl -X 'POST' \
  'http://localhost:8080/api/v1/authenticate' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "username": "user",
  "password": "user"
}'
</p>


<p>5. Bus Create :</p>
<p>curl -X 'POST' \
  'http://localhost:8080/api/v1/bus' \
  -H 'accept: */*' \
  -H 'Authorization: eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTcwMjM2NzE0OSwiZXhwIjoxNzAyNDUzNTQ5fQ.7yrCRRemsIFpd6xsO3xD0VESaRlH4Yxy93t2Rowv6KV8KE7Rn38loQUQzci6GLmA74KYO8QWUdEr8xBqRTP0aQ' \
  -H 'Content-Type: application/json' \
  -d '{
  "busRegNumber": "UP16 AZ 2134",
  "busName": "travel 1",
  "busType": "DELUXE"
}'
</p>
<p>6. Fetch available locations:</p>


<p>curl -X 'GET' \
  'http://localhost:8080/api/v1/locations' \
  -H 'accept: */*' \
  -H 'Authorization: eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTcwMjM2NzE0OSwiZXhwIjoxNzAyNDUzNTQ5fQ.7yrCRRemsIFpd6xsO3xD0VESaRlH4Yxy93t2Rowv6KV8KE7Rn38loQUQzci6GLmA74KYO8QWUdEr8xBqRTP0aQ'
</p>
<p>7. Route create : </p>
<p>curl -X 'POST' \
  'http://localhost:8080/api/v1/route' \
  -H 'accept: */*' \
  -H 'Authorization: eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTcwMjM2NzE0OSwiZXhwIjoxNzAyNDUzNTQ5fQ.7yrCRRemsIFpd6xsO3xD0VESaRlH4Yxy93t2Rowv6KV8KE7Rn38loQUQzci6GLmA74KYO8QWUdEr8xBqRTP0aQ' \
  -H 'Content-Type: application/json' \
  -d '{
  "busId": "65780ef39f904f2303867043",
  "source": "Agra",
  "destination": "Delhi",
  "startTime": "08:30:00",
  "endTime": "17:00:00",
  "weekday": "MONDAY"
}'
  </p>
<p>8. To fetch all routes of a bus by reg number:</p>

<p>curl -X 'GET' \
  'http://localhost:8080/api/v1/route?busRegNumber=UP16%20AZ%202134' \
  -H 'accept: */*' \
  -H 'Authorization: eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTcwMjM2NzY3MCwiZXhwIjoxNzAyNDU0MDcwfQ.HMyDJYwCRbfZuB-_e1S_PpnZZinxDCi2mJLSZ6yovO6YYhXbecVxK_CafddGaI4WxY3hRK6Xr_pXyrkvos1rDQ'
</p>
