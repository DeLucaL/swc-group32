## Software Construction - Assignment 5 <br /> 
##### by Stefanie Krohmann, Loris De Luca and Samuele Walzer<br /> 

Exercise 1, Part 2 <br />

Classes CentralOffice, CityOffice and Bakery and the interface Hub together build the Composite pattern. Component Hub declares the interface for the composites CentralOffice and CityOffice and leaf Bakery. All override the method printInfo(). We use this design pattern to mirror the hierarchical structure of the different offices/bakeries. If the chain were to grow in size the Composite pattern allows adding different components or leaves. Additionally, we use the Singleton design pattern for CentralOffice to ensure, that only a single instance is created. <br /> 
The Decorator Pattern is implemented by the bakeries. A bakery can be decorated by a SweetsBakery and / or a BreadBakery. Using decorators to change the type of bakery opens up the possibility for new kinds of bakeries with new products or prices, without changing the composite pattern, as in essence they would remain bakeries. <br />
Also, a Sandwich can be decorated with different fillings, and a cake can be decorated with different toppings, allowing for simple future additions and changes in the offers.

Exercise 2, Part 2 <br /> 

The strategy pattern is implemented by the abstract class Vehicle, its subclasses and three interfaces that represent 
different attributes of the vehicles. The three interfaces are the driving mode, the available space for luggage and the speed. <br /> 
The strategy pattern is useful if additional vehicles or functionalities will be added later, because the code is well 
encapsulated. With implementing the strategy pattern we favoured composition over inheritance. This gives us a lot more flexibility. 