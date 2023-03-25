# Task_Planner 

![Logo](https://www.linkpicture.com/q/task-planner-image.png)

## About


This application is a Restfull web service. Here User should be able to register themselves after that they can create a Sprint, add a task to Sprint, change an assignee or status of the task, show all tasks of a particular Sprint and show all tasks assigned to a user.
 


## Author
- [Abhishek Das](https://github.com/abhidas0810)

## User Features

- Register as user
- Add Sprint
- Add task to sprint
- Get sprint by id
- Update sprint
- Delete sprint by id
- Get all sprint

## Tech Stack

- Java
- Spring Boot
- Hibernate
- MySQL
- Swagger


## Run Locally

Clone the project

```bash
  git clone https://github.com/abhidas0810/Task_Planner.git
```

Go to the project resources


-  src/main/resources and change the MySQL credentials.


Run the main file

- src/main/java/com/taskPlanner/TaskPlannerApplication.java

Start the server

 - http://localhost:8888/swagger-ui/index.html
 - ![Logo](https://www.linkpicture.com/q/img1_22.png) 

**REST API End-Points:**

* http://localhost:8888/user/registration - Register User
* http://localhost:8888/user/updateTask/{task} - Update the task
* http://localhost:8888/user/updateSprint - Update the sprint
* http://localhost:8888/user/addTaskToSprint/{sprintId} - Add task to the sprint using sprintId
* http://localhost:8888/user/addTask/{sprintId} - Add task using sprintId
* http://localhost:8888/user/addSprint/{emailId} - Add sprint with emailId
* http://localhost:8888/user/getTasks/{emailId} - Get tasks using emailId
* http://localhost:8888/user/getTask/{taskId} - Get task using taskId
* http://localhost:8888/user/getSprints/{emailId} - Get sprints using emailId
* http://localhost:8888/user/getSprint/{sprintId} - Get sprint using sprintId
* http://localhost:8888/user/deleteSprint/{sprintId} - Delete sprint using sprintId
* http://localhost:8888/user/deleteTask/{taskId} - Delete task using taskId

- ![Logo](https://www.linkpicture.com/q/img2_18.png)
