# PokerHands

This is a simple application to compare two poker hands.

Currently the application is a standalone JAR which accepts input via command line. Each hand consists of 5 cards.
A card has a suite (**H**earts, **S**pades, **D**iamonds or **C**lubs) and a value (2, 3, 4, 5, 6, 7, 8, 9, 10, **J**ack, **Q**ueen, **K**ing or **A**ce).
The hand is inputted as one string containing the values for the five cards separated by a whitespace. 
Example Input:
H5 H6 DQ CJ C10

## Run the Program

Prerequisites: Maven and JDK 8

1) Clone the repository:
```
git clone https://github.com/mlauinger/PokerHands.git
```

2) Build via Maven:
```
mvn clean compile assembly:single
```
 
3) Run the program:
```
java -jar target/pokerhands-1.0-SNAPSHOT-jar-with-dependencies.jar
```
