## Software Construction - Assignment 1 <br /> 
##### by Loris De Luca, Samuele Walzer and Stefanie Krohmann<br /> 

Part 1 <br /> 
a)<br /> 
![image info](./Images/Task_1_architecture_2.png)

To draw the architecture of the system we took the class "age calculator" as our entry point. Because our main focus was to understand the architecture of the written program, we did not draw arrows, which indicate connections, to external libraries. The "age calculator class" imports mainly classes from the org.joda.time package. With our drawing it can quickly be detected that this has to be the most important package. It is well structured with 6 subpackages, each having a meaningful title such as "format", "convert" or "chrono". For our drawing of the architecture we went three steps into the system, meaning that we looked at the imports between the classes three steps deep. This is expressed by the three different colours used in the architecture drawing. As one can clearly see by looking at the architecture the arrows between classes go back and forth. There was need to dive further into the code, as the architecture gives a clear overview. There are many more classes in each package but it would only confuse the viewer if we would show all of them. They are indicated with three tiny blue dots. 

b)<br />
![image_info](./Images/Task_1b_callgraph.jpg)

Part 2

*if/else* statements:<br />
![org.joda.example.time.TimeZoneTable.ZoneData#compareTo](./Images/df_compareTo().jpg)

![org.joda.example.time.DateTimeBrowser#getDefaultTableView](./Images/df_getDefaultTableView().jpg)

![org.joda.time.tz.ZoneInfoCompiler.Rule#formatName](./Images/df_formatName().jpg)

*for* loops:<br />
![org.joda.example.time.DateTimePerformance#checkJodaConstructor1](./Images/df_checkJodaConstructor1().jpg)

![org.joda.time.tz.ZoneInfoCompiler#writeZoneInfoMap](./Images/df_writeZoneInfoMap.jpg)