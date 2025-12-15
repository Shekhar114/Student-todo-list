# Student TODO List — Spring Boot + Thymeleaf

A simple CRUD web application to manage a student TODO list using Spring Boot, Spring Data JPA, Thymeleaf and H2 (in-memory) database.  
This project demonstrates how to create, read, update and delete student TODO items with server-side rendered HTML using Thymeleaf.

## Features
- List all student TODO items
- Add a new TODO item
- Edit an existing TODO item
- Delete a TODO item
- Persist data using Spring Data JPA (H2 by default)
- Server-side rendering with Thymeleaf templates
- Simple, minimal code structure suitable for learning and extension

## Tech stack
- Java 17+ (or Java 11)
- Spring Boot 3.x
- Spring Data JPA
- Thymeleaf
- H2 Database (default, file or other RDBMS possible)
- Maven (or Gradle)

## Quick start

1. Clone the repository (or create a new Spring Boot project and add files described below).
2. Build and run:

Using Maven wrapper:
./mvnw spring-boot:run

Or with Maven:
mvn spring-boot:run

Or build a jar then run:
mvn clean package
java -jar target/student-todo-0.0.1-SNAPSHOT.jar

3. Open in browser:
http://localhost:8080/students

## Default URLs and Endpoints (convention)
- GET  /students               — list all TODOs (index page)
- GET  /students/new           — form to create a new TODO
- POST /students               — create a new TODO
- GET  /students/{id}/edit     — form to edit TODO with id
- POST /students/{id}/update   — update TODO with id (or use PUT)
- POST /students/{id}/delete   — delete TODO with id (or use DELETE)

Notes:
- You can adapt the controller to use RESTful verbs (PUT/DELETE) if you prefer API-only interactions.

## Recommended Project Structure
- src/main/java/com/example/studenttodo
  - StudentTodoApplication.java        (Spring Boot main)
  - model/Student.java                 (JPA entity)
  - repository/StudentRepository.java  (Spring Data JPA)
  - service/StudentService.java        (optional service layer)
  - controller/StudentController.java  (Thymeleaf controller)
- src/main/resources/templates
  - students/list.html
  - students/form.html
- src/main/resources/application.yml (or application.properties)

## Example entity (Student)
Fields you might include:
- id (Long) — primary key
- name (String)
- email (String)
- todo (String) — task description
- done (boolean) — completed flag
- createdAt (LocalDateTime)

Example (Java / JPA):
```java
@Entity
public class Student {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String email;
  private String todo;
  private boolean done;
  // getters/setters, constructors
}
```

## Example Controller (high level)
- GET `/students` — fetch all from repository, add to model `"students"`, return `students/list`
- GET `/students/new` — return `students/form` with empty Student
- POST `/students` — save new Student, redirect to `/students`
- GET `/students/{id}/edit` — load Student and pass to `students/form`
- POST `/students/{id}/update` — save updated Student, redirect to `/students`
- POST `/students/{id}/delete` — delete and redirect

Thymeleaf templates use th:action and th:object for binding.

## application.properties (example)
```properties
spring.datasource.url=jdbc:h2:mem:studentdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.jpa.hibernate.ddl-auto=update
server.port=8080
```

Access H2 console: http://localhost:8080/h2-console  
JDBC URL (for above): jdbc:h2:mem:studentdb

## Thymeleaf template hints
- list.html: iterate over `${students}` to display rows, provide links/buttons for edit and delete.
- form.html: use `<form th:action="@{...}" th:object="${student}" method="post">` and `th:field="*{name}"`.

Example list action in template:
```html
<a th:href="@{/students/{id}/edit(id=${s.id})}">Edit</a>
<form th:action="@{/students/{id}/delete(id=${s.id})}" method="post">
  <button type="submit">Delete</button>
</form>
```

## Sample curl commands
- Create:
curl -X POST -d "name=Alice&email=alice@example.com&todo=Finish assignment" http://localhost:8080/students
- Delete:
curl -X POST http://localhost:8080/students/1/delete

(Adapt to your form encoding or use JSON if creating REST endpoints.)

## Switching to a real database
To use a production-grade DB (Postgres/MySQL):
- Change datasource URL, username, password in application.properties
- Add the JDBC driver dependency
- Update spring.jpa.hibernate.ddl-auto to `validate` or `none` for production

## Tests
- Add Spring Boot tests for controller/service/repository.
- Use @WebMvcTest for template controller tests or @SpringBootTest for full integration.

## Extending the app
- Add pagination and sorting
- Add authentication (Spring Security) — restrict create/update/delete
- Add REST API endpoints separate from Thymeleaf web controllers
- Add file upload for attachments to TODOs

## Troubleshooting
- Templates not found: ensure Thymeleaf templates are under `src/main/resources/templates` and return logical view names (e.g., `students/list`).
- H2 console 404: ensure `spring.h2.console.enabled=true` and correct path configured.
- 404 on endpoints: confirm controller mappings and that application is running on the expected port.

## License
This example is provided for learning and demonstration purposes. Use and adapt freely.

---

If you'd like, I can also:
- generate the full Spring Boot project skeleton with example files (entity, repository, controller, Thymeleaf templates, application.properties), or
- provide ready-to-paste code for each file (Student, StudentRepository, StudentService, StudentController, templates).

Tell me which option you prefer and whether you want Maven or Gradle.
