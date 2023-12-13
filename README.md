# Smart Employee Manager


Build the Application in Spring Boot using STS.

Using NoSQL Database i.e.- MongoDB

Request and Response for all APIs are in JSON format

1. Firstly Download any application that can run the Spring Boot Project. I have done using STS
2. Secondly download any NoSQL Database. I have done using MongoDB.
3. Configure your MongoDB by adding path in Environment Variable.
4. Download Postman for end point API testing.
5. Add dependencies that are required in the project.
6. The employee database have the fields EmployeeName, PhoneNumber, Email, ReportsTo (which refers to the Employee ID of the reporting manager), and ProfileImage.
7. Connecting the database from application.properties. 
8. In STS create a project and create required class i.e. - Controller,Service,Repository,Model
9. EndPoint for each API
   a.@PostMapping("/generate")           -->   Add Employee to the Database    
   b.@GetMapping("/getAll")              -->   Get All Employees from the Database / Get Employees with 
                                               Pagination and Sorting 
   c.@DeleteMapping("/delete/{id}")      -->   Delete Employee by ID:
   d.@PutMapping("/update/{id}")         -->   Update Employee by ID
   e.@GetMapping("/getNthLevelManager") -->   Get nth Level Manager of an Employee 
10
    a.Add Employee to a Database
    b.Get All Employees
    c.Delete Employee by ID
    d.Update Employee by ID
    a.Get nth Level Manager of an Employee
    b.Get Employees with Pagination and Sorting

11. For the API that require JSON file mentioning below- 
    a.@PostMapping("/generate")

      http://localhost:8080/employees/generate

     {
        "employeeName": "Anish",
        "phoneNumber": "7845126398",
        "email": "anish@gmail.com",
        "reportsTo": "378ef1f6-9cfb-4a9e-8b6b-e052a2398189",
        "profileImage": "https://media.istockphoto.com/id/1358918776/photo/water-drops-on-the-stalks-of-the-
                         field-grass-natural-plant- texture-in-green-natural-tones.jpg?s=2048x2048&w=is&k=20&
     }

    b. @PutMapping("/update/{id}") 

	http://localhost:8080/employees/update/{id}

      {
        "employeeName": "Sarthak",
        "phoneNumber": "1234567890",
        "email": "abcd@gmail.com",
        "reportsTo": "920942bc-7c74-449d-9951-50059675f0c3",
        "profileImage": "https://media.istockphoto.com/id/1358918776/photo/water-drops-on-the-stalks-of-the-field-grass-natural-plant-
                         texture-in-green-natural-tones.jpg?s=2048x2048&w=is&k=20&c=fRXpeCYnVGJo7GxB49CYb7nlnOsw8Qzizap5epLQNfg="
     }

     c.@GetMapping("/getNthLevelManager")
 
	http://localhost:8080/employees/getNthLevelManager?id={id}&level=1

	 {
        "employeeName": "Jayat",
        "phoneNumber": "55225515245",
        "email": "jayat@gmail.com",
        "reportsTo": "0fb66de1-ab8a-48ab-9138-c31bad880ead",
        "profileImage": "https://media.istockphoto.com/id/1358918776/photo/water-drops-on-the-stalks-of-the-field-grass-natural-plant-
                         texture-in-green-natural-tones.jpg?s=2048x2048&w=is&k=20&c=fRXpeCYnVGJo7GxB49CYb7nlnOsw8Qzizap5epLQNfg="
}

