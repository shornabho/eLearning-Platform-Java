# E-Learning Platform
### A Java based e-Learning Platform

Author:  
**Swarnava Ghosh**  

Under the guidance of:  
**Prof Prabu P**  
Department of Computer Science,  
CHRIST (Deemed to be University)

**Disclaimer: This application is currently under development.** 

## Code Guide:

* Code execution starts from `ELearningPlatform.java` and is responsible for taking menu-based input from user.  

* Enter any other integer apart from (1/2) in the menu to exit the menu and terminate execution.

* **Note:**  
    * The constructors of some classes have been temporarily used to hard code dummy data as the entire component wise implementation is still under development.  
    * `TestClass.java` has been used only for temporary data substitution.


## Concept-wise explanation:

### Association, Aggregation & Composition  

* There are two types of `User` (IS A relationship) : 
    * `Student`  
    * `Teacher`  
* Teachers own Courses (Composition : a Course cannot exist without at least one Teacher associated with it)    
* Students enroll for Courses (Aggregation / Association? : Students and Courses can exist independently, until a Student enrolls for a Course, then they are related)    
* Courses have Lessons, but a Lesson cannot exist without a Course (Composition)  


  

