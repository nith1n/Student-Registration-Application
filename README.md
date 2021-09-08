## Student Registation Application


A web application for new student registration and existing student data retrieval. 


' server ' directory - Contains the spring boot backend project <br>
' front-end ' directiory - Contains the react frontend project

The project is developed using spring boot as the backend service, react.js as the frontend technology and mongodb as the database.

In order to run the project, the user needs to have a mongodb installed locally. The instructions to install mongodb can be found below. After that follow the sequence :

## Usage

Run mongodb ( Windows )

	mongod

or <br>

Run mongodb ( Linux )

	sudo systemctl start mongod

Run Springboot App - from 'server' directory

	mvn clean spring-boot:run

Run React App - from 'front-end' directory

	npm install
	npm start

Front End URL

	http://localhost:3000/

Back End URL

	http://localhost:8080/


<br>

### REST API End Points <br>

#### - GET request to return all student's details.<br>

URL :  /all <br>
method : `GET` <br>
success response : <br>
code : 200 <br>
content-type : application/json <br>
content : <br>
		[
		  {
			"id": 1,
			"name": "John Doe",
			"dateOfBirth": "08/07/1991",
			"dobDay": "08",
			"dobMonth": "07",
			"dobYear": "2014",
			"grade": "II",
			"division": "B",
			"gender": "Male",
			"rollNumber": "R-001"
		  },
		  ]


#### - POST request to create new student <br>

URL : /create <br>
method:`POST` <br>
content-type : application/json <br>
request body : <br>
		{
			"name" :" John Doe ",
			"dobDay":"08",
			"dobMonth":"07",
			"dobYear":"2014",
			"dateOfBirth":"08/07/2014",
			"grade" : "II",
			"division":"B",
			"gender":"Male"
		}<br>
success response  : <br>
    code : 200 <br>
    content-type : text/plain <br>
		content : New Student 'John Doe' has been Added <br>



### End
