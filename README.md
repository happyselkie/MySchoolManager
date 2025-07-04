
<h1 align="center" style="font-weight: bold;">School Manager 💻</h1>

<p align="center">
<a href="#tech">Technologies</a>
<a href="#started">Getting Started</a>
<a href="#routes">API Endpoints</a>
</p>


<p align="center">This is a classroom application for managing students and teachers in classroom with a micro-service architecture.</p>


<h2 id="technologies">💻 Technologies</h2>

- JAVA JDK 21
- Spring Boot
- Spring Cloud
- Spring Data JPA
- Eureka server and discovery Client
- Rest Template
- JDBC API
- MysSQL databases

<h2 id="started">🚀 Getting started</h2>

You'll need postman to test this application

<h3>Prerequisites</h3>

- [Postman](https://www.postman.com/)

<h3>Cloning</h3>

```bash
git clone https://github.com/happyselkie/MySchoolManager.git
```

<h3>Config variables</h2>

Use this `application.properties` as reference to create your configuration file `application.properties`

```yaml
spring.application.name=micro_service_name

server.port=micro_service_port

spring.datasource.url=DATABASE_URL
spring.datasource.username=DATABASE_USERNAME
spring.datasource.password=DATABASE_PASSWORD
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

eureka.client.service-url.defaultZone = URL_EUREKA_SERVER
eureka.instance.prefer-ip-address=true
```

<h2 id="routes">📍 API Endpoints</h2>

<ul>
<li><a href="#api-teacher">Teacher</a></li>
<li><a href="#api-student">Student</a></li>
<li><a href="#api-class">Classroom</a></li>
</ul>

<h3 id="api-teacher">TEACHER</h3>
​
| route               | description                                          
|----------------------|-----------------------------------------------------<br/>
| <kbd>GET /teacher/api</kbd>     | retrieves all teachers info see [response details](#get-teacher)<br/>
| <kbd>GET /teacher/api/{id}</kbd>     | retrieves teacher info by Id see [request details](#get-teacher)<br/>
| <kbd>POST /teacher/api</kbd>     | Create teacher info [request details](#post-teacher)<br/>
| <kbd>PUT /teacher/api/{id}</kbd>     | Update teacher by id info [request details](#post-teacher)<br/>
| <kbd>DELETE /teacher/api/{id}</kbd>     | Delete teacher by id

<h3 id="get-teacher">GET /api/teacher</h3>

**RESPONSE**
```json
{
  "id" : "1",
  "lastName": "Doe",
  "firstName": "Jane",
  "birthDate": "05-05-1985"
}
```

<h3 id="post-teacher">POST /teacher/api/ & PUT /teacher/api/{id}<h3>

**REQUEST**
```json
{
  "lastName": "Doe",
  "firstName": "Jane",
  "birthDate": "05-05-1985"
}
```

**RESPONSE**
```json
{
  "id" : "1",
  "lastName": "Doe",
  "firstName": "Jane",
  "birthDate": "05-05-1985"
}
```

<h3 id="api-student">STUDENT</h3>
​
| route               | description                                          
|----------------------|-----------------------------------------------------<br/>
| <kbd>GET /student/api</kbd>     | retrieves all students info see [response details](#get-student)<br/>
| <kbd>GET /student/api/{id}</kbd>     | retrieves student info by Id see [request details](#get-student)<br/>
| <kbd>POST /student/api</kbd>     | Create student info [request details](#post-student)<br/>
| <kbd>PUT /student/api/{id}</kbd>     | Update student by id info [request details](#post-student)<br/>
| <kbd>DELETE /student/api/{id}</kbd>     | Delete student by id

<h3 id="get-student">GET /api/student</h3>

**RESPONSE**
```json
{
  "id" : "1",
  "lastName": "Joe",
  "firstName": "Little",
  "birthDate": "06-06-1996"
}
```

<h3 id="post-student">POST /student/api/ & PUT /student/api/{id}<h3>

**REQUEST**
```json
{
  "lastName": "Joe",
  "firstName": "Little",
  "birthDate": "06-06-1996"
}
```

**RESPONSE**
```json
{
  "id" : "1",
  "lastName": "Joe",
  "firstName": "Little",
  "birthDate": "06-06-1996"
}
```

<h3 id="api-student">CLASSROOM</h3>
​
| route               | description                                          
|----------------------|-----------------------------------------------------<br/>
| <kbd>GET /classroom/api</kbd>     | retrieves all classrooms info see [response details](#get-classroom)<br/>
| <kbd>GET /classroom/api/{id}</kbd>     | retrieves classroom info by Id see [request details](#get-classroom)<br/>
| <kbd>POST /classroom/api</kbd>     | Create classroom info [request details](#post-classroom)<br/>
| <kbd>PUT /classroom/api/{id}</kbd>     | Update classroom by id info [request details](#post-classroom)<br/>
| <kbd>DELETE /classroom/api/{id}</kbd>     | Delete classroom by id

<h3 id="get-classroom">GET /api/classroom</h3>

**RESPONSE**
```json
{
  "students": [
    {
      "id": 1,
      "lastName": "Joe",
      "firstName": "Little",
      "birthDate": "05-05-1985"
    },
    {
      "id": 2,
      "lastName": "Doe",
      "firstName": "Jane",
      "birthDate": "06-06-1986"
    }
  ],
  "teacher": {
    "id": 1,
    "firstName": "Mister",
    "lastName": "Toto",
    "birthDate": "01-01-1981"
  }
}
```

<h3 id="post-classroom">POST /classroom/api/ & PUT /classroom/api/{id}<h3>

**REQUEST**
```json
{
  "studentId" : [3,4],
  "teacherId" : "2"
}
```

**RESPONSE**
```json
{
  "students": [
    {
      "id": 3,
      "lastName": "Astley",
      "firstName": "Rick",
      "birthDate": "07-07-1987"
    },
    {
      "id": 4,
      "lastName": "Tourloupe",
      "firstName": "Byron",
      "birthDate": "09-09-1999"
    }
  ],
  "teacher": {
    "id": 2,
    "firstName": "Miss",
    "lastName": "Tata",
    "birthDate": "02-02-1982"
  }
}
```
