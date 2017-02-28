# ISEN LAB : Checkers game  [![Build Status](https://travis-ci.org/quentinroeland/isenlab-checkers.svg?branch=master)](https://travis-ci.org/quentinroeland/isenlab-checkers)

## Getting started

### Requis

* Java 8
* Maven
* Glassfish plugin (optional)

### Content

* checkers-parents
** checkers-core
** checkers-jpa
** checkers-rest
** checkers-web


## How to

### Get source

Sources are available on our git repository

	https://github.com/quentinroeland/isenlab-checkers


### Lauch

In a command prompt :

cd checkers-parents
mvn clean install
cd checkers-web
mvn glassfish:run

It launches a Glassfish server on port 9090, the application can be browsed at : 

	http://localhost:9090/checkers-web/

### Play

To move a pawn click on the pawn to move, then click on the destination case.
Then click on the play button.

Only the simple rules have been implemented :

* Move pawn
* Take neighbor
* The game is won when one pawn get to the other side 

Note : **Player** with **yellow** pawns **starts** to play
