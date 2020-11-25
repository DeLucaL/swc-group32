## Software Construction - Assignment 5 <br /> 
##### by Stefanie Krohmann, Loris De Luca and Samuele Walzer<br /> 

Exercise 1, Part 2 <br />

Classes CentralOffice, CityOffice and Bakery and the interface Hub together build the Composite pattern. Component Hub declares the interface for the composites CentralOffice and CityOffice and leaf Bakery. All override the method printInfo()  

Exercise 2, Part 2 <br /> 

The strategy pattern is implemented by the abstract class Vehicle, its subclasses and three interfaces that represent 
different attributes of the vehicles. The three interfaces are the driving mode, the available space for luggage and the speed. <br /> 
The strategy pattern is useful if additional vehicles or functionalities will be added later, because the code is well 
encapsulated. With implementing the strategy pattern we favoured composition over inheritance. This gives us a lot more flexibility. 