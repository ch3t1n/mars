#### Requirements
- JDK8
- Maven(mvn) 

#### External Libraries
- Junit

#### compile/package/run tests

`$ mvn clean package`

####  execute program

`$ mvn -q exec:java`

or

`java -jar target/mars-1.0.jar`

#### Example

```
$ java -jar target/mars-1.0.jar 
Press enter/return twice to signal an end of input:
5 5 
1 2 N
LMLMLMLMM

Output:
1 3 N

```
