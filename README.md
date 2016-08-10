# drawing-program

### Prerequisities
- [Apache Maven](https://maven.apache.org/index.html)

## Built with
- Java 1.8
- Maven 3.2.1
- Spring Boot 

## Installation
- Clone the project

- Go to folder where you can see the pom.xml
- run `mvn spring-boot:run`

### How to use
When you see on your terminal `Welcome to Drawing Program.` just follow the instructions on console 

```
Please select one option: 
#	C w h 				- Create a new canvas of width w and height h.
#	L x1 y1 x2 y2 			- Create a new line from (x1,y1) to (x2,y2).
#	R x1 y1 x2 y2 			- Create a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2).
#	B x y c 			- Fill the entire area connected to (x,y) with "colour"
#	Q 				- Quit the program.
```
