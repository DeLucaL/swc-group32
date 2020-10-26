#####New GameBoard's:
- PlayerOcean
- ComputerOcean: void placeAllShipsRandomly()

#####New Classes
- Hit: class likely equal to input
- Scoreboard: observer checking if boat isHit() + hitCount()
- UpdateBoard: updates both boards when boat is hit in specific format

#####Extend Subclasses of Ship
- boolean isHit(): 
- shootAt(): overwrites destroyed fields of boat with 'x'
or
- isSunk(): counts down from len(ship) how many fields are still intact -> if = 0: sunk
isGameOver()

##Add Patterns!