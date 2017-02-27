# Puissance4

[![Build Status](https://travis-ci.org/dmetzler/puissance4.png?branch=master)](https://travis-ci.org/dmetzler/puissance4)
[![Coverage Status](https://coveralls.io/repos/dmetzler/puissance4/badge.svg)](https://coveralls.io/r/dmetzler/puissance4)

This is a simple JEE6 power4 game made to illustrate various aspects of JEE :

 * TDD thru with Junit and AssertJ
 * Servlet, JSP 
 * CDI
 * JPA
 * JAX-RS
 

## How to launch

	$ mvn clean install
	$ cd puissance4-web
	$ mvn glassfish:run

It launches a Glassfish server on port 9090, so your application can be browsed at : 

	http://localhost:9090/puissance4-web/

Or copy the `puissance4-web/target/puissance4.war` in your application server's webapp directory.


## How to play

To move a pawn click on the pawn to move, then click on the destination case.
Then click on the play button.

Only the simple rules have been implemented :
	* Move pawn
	* Take neighbor
	* The game is won when one pawn get to the other side 