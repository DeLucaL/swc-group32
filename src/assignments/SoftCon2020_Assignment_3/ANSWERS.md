## Software Construction - Assignment 3 <br /> 
##### By Loris De Luca, Samuele Walzer and Stefanie Krohmann<br /> 

In our game only one scoreboard should exist, therefore we used the Singleton Pattern to make sure the scoreboard has only one Instance. 
To make it globally accessible we used the getter function getInstance().

We used the Observer Pattern to notify the scoreboard whenever a boat sunk. When the player sinks an enemy (computer) boat, "Enemy boats destroyed" increases by one and on the other hand "Player remaining boats" decreases by one.  

Because a ship has multiple parts, we implemented the Iterator Pattern to iterate over the different parts of the ship. Thus, we could check whether the whole ship sunk, by checking if all parts had been hit.    

