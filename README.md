# Async recruitment task


### How to run 🔨
---

### From console:

- **Be sure you computer has Docker installed!**
- Download repository 
- Open projec directory
- Open console in directory and type:    *docker-compose up*

# PASSWORDS & PORTS

MYSQLDB_USER=root</br>
MYSQLDB_ROOT_PASSWORD=admin
</br></br>
MYSQLDB_LOCAL_PORT=3307</br>
MYSQLDB_DOCKER_PORT=3306
</br></br>
SPRING_LOCAL_PORT=6868</br>
SPRING_DOCKER_PORT=8080


# END POINTS 

CREATE TASK: [POST METHOD] http://localhost:6868/api/tasks/ </br>
JSON Body:
```
{
    "base":"5",
    "exponent":"5"
}
```
</br>

GET ALL TASK: [GET METHOD] http://localhost:6868/api/tasks/ </br>
</br>
GET TASK WITH ID 10: [GET METHOD] http://localhost:6868/api/tasks/10 </br>
