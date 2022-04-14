# COP_4502_Assg3

# Running the program
1. Open preffered terminal and navigate to path of file that contains the Main class for either question:
    
2. Compile Programs    
  2.a Compile the program for question 1 with the following command:
      ```javac Main.java LazyList.java Node.java ServantThread.java```
  2.b Compile the program for question 2 with the following command:
      ```javac Main.java LazyList.java Node.java SensorThread.java```
      
3. Run the compiled program with the following command:
    ```java Main```
    
 # Interpreting Output
 1. The Output for this program should display in the terminal as follows:
    ``` Thank you note for Gift <Present tag #> sent!```
    
    Then, in the very bottom, it should say whether the lists are empty or not.
    ```Ordered List : <"List is empty"> / <"Oh nooooo">```
 
 These outputs represent the simulation of the process done by the servants.
 
 2. The Output for this program should display in the terminal as follows:
     ```<#> // representing every number being sensed
     ```Five Lowest Tempratures : <#, #, #, #, #>
        Five highest Tempratures : <#, #, #, #, #> ```
        
  These outputs represent the simulation of the process done by the sensors.
  
  # Proof of correctness
  For these questions I first implemented the logic using Java's Linked lists. They worked as intened but once translating it to the lazy list implementation, things got tricky. Question 1 still compiles and runs as intend but sometiomes depending on the terminal, the main thread will throw an error stating that it cannot access the list, which will impede on the final print statements indicating that the lists are empty, but they are.. trust.
  
  Question 2 I was not able to successfully translate my base initial code into the use of lazylist. However if you would like to check the code on a previos version, check out the commit and see that the logic works. (pls)

NOTE: Did not have enough time to check runtime on the first question but I did notice that after an input of 50,000 it gets super slow, otherwise it does run rather quick.
