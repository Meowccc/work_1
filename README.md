# Demo Project

### Reference Documentation

![Spring Boot 2.7.4](https://img.shields.io/badge/Spring%20Boot-2.7.4-brightgreen.svg)
![JDK 11](https://img.shields.io/badge/JDK-11-brightgreen.svg)
![Maven](https://img.shields.io/badge/Maven-3.6.2-yellowgreen.svg)
![Vultr](https://img.shields.io/badge/Vultr-yellowgreen.svg)

## 環境需求

- [Intellij IDEA](https://www.jetbrains.com/idea/)
    - Ultimate
    - Community
- [Docker](https://www.docker.com/)
- [jdk 11 +](https://www.oracle.com/tw/java/technologies/javase/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/)

---


|Driver | JDBC URL|帳號 | 密碼 |
|----|----|----|----|
|org.h2.Driver|jdbc:h2:mem:demo|root|1234|

---

## Hello API
> ### get member detail
> ```shell
> curl -X GET "http://<ip>:<port>/api/hello" 
> ```


---

## Member API


> ### get member detail
> ```shell
> curl -X GET "http://<ip>:<port>/api/members/{id}" 
> ```

> ### list members
> ```shell
> curl -X GET "http://<ip>:<port>/api/members" 
> ```

> ### create member
> ```shell
> curl -X POST -H 'Content-type: application/json' --data '{"name":"Meow"}' "http://<ip>:<port>/api/members" 
> ```

> ### update member
> ```shell
> curl -X PUT -H 'Content-type: application/json' --data '{"name":"Meow_1"}' "http://<ip>:<port>/api/members/{id}" 
> ```

> ### delete member
> ```shell
> curl -X DELETE  "http://<ip>:<port>/api/members/{id}" 
> ```
 

---

## Order API

> ### list orders
> ```shell
> curl -X GET  "http://<ip>:<port>/api/members/{id}?keyword=&startDate=&endDate=" 
> ```

> ### create order
> ```shell
> curl -X POST "http://<ip>:<port>/api/orders/product/{id}" 
> ```

