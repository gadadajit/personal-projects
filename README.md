# personal-projects

Assmptions made:
1. Parking slots will not be recreated.
2. When do we search parking data, use Camel case or Upper case for car colour or Registration number as it is mentioned while parking the car.
3. Input commands string pattern will not be changed.
4. Application will not persist parking data permently

How data is stored:
- Using an instance of Singleton class 

Scope of data availibity:
- Till application restarts.

Dependcency:
- Used Junit-4 framework for development

How to run the application:
- Import application source code into Eclipse IDE
- Add Junit to Eclipse library, if Junit is not added
- Create .jar file using Eclipse IDE or through Java commands
- Run app using "java -jar example.jar commands.txt" command through command prompt, inside folder where example.jar and commands.txt files are placed
- Or using "java -jar example.jar" command
