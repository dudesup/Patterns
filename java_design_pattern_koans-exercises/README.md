# Java Design Pattern Koans
Classic GoF design pattern exercises! In order to see the exercises or solutions, simply switch between branches.

## What are Design Patterns?
Design patterns are architectural, high-level templates for solving recurring problems. The Gang of Four (GoF) distinguishes between 3 categories of patterns:
- **Creational Patterns**: are used for creating objects. It decouples the creation of an object from it's representation. The object creation is encapsulated and swapped out, to make the object creation independent from it's implementation.
- **Structural Patterns**: provides templates for classes and it's relationships, which makes the design of software much easier.
- **Behavioral Patterns**: models complex behavior of software. Makes the behavior of software more flexible.

## Why Patterns are Essential
Because software engineers shouldn't reinvent the wheel, it is general best practice to reuse templates which are battle-tested, mature and time-proven.
Patterns are essential, because they:
- solve one or more problems
- offer a battle-tested concept
- are based on real designs
- go way beyond the obvious
- include the user into the design process
- crystallize relations, structures and mechanisms of a system
- are standardized; all standard patterns have a name - this makes it easier to communicate with fellow developers about abstract problems

## Overview of Covered Patterns

### Classic Design Patterns
Classification done by the Gamma et al. (1995)
![Design Patterns by the Gang of Four](https://raw.githubusercontent.com/togiberlin/java_design_pattern_koans/exercises/design_patterns.png)

### Architectural Patterns
Classification done by Buschmann (1996)
![Architectural Patterns by Buschmann](https://raw.githubusercontent.com/togiberlin/java_design_pattern_koans/exercises/architectural_patterns.png)

### Antipatterns
Classification done by Brown et al. (1998)
![Antipatterns by ](https://raw.githubusercontent.com/togiberlin/java_design_pattern_koans/exercises/anti_patterns.png)

## Prerequisites
- First of all, make sure that you have Eclipse with Maven installed.
- For these exercises, a fundamental understanding of [Object-Orientation (OO)](https://docs.oracle.com/javase/tutorial/java/concepts/) and [Java](https://www.tutorialspoint.com/java/index.htm) is required.
- Furthermore, you should be able to read and understand [UML](https://www.tutorialspoint.com/uml/), especially UML class diagrams.

## How to Get Started
- Fork this repository
- Go to your forked project page, and clone it to your computer via ```git clone link-to-your-forked-repo-here```
- Type ```git remote -v``` to make sure that ```origin``` is there and pointing to your forked, remote repository
- Then, enter ```git remote add upstream git@github.com:togiberlin/java_design_pattern_koans.git```
- Check again via ```git remote -v```. Both ```origin``` and ```upstream``` should be there.
- Open now Eclipse, right-click on some whitespace inside the Package Explorer and select ```Import```
- In the upcoming dialog, select ```Existing Maven project```
- Browse to the exercise folder, select the project and click ```Finish```

## How to Do the Exercises
- Read the Problem Statement (usually in natural language)
- Start programming
- Fix compile errors
- Add missing associations and fields
- See the object model
- Make sure to name the identifiers exactly according to the diagram
- Open the Eclipse Task View (Window > Show View > Tasks) to see the TODOs
- Run the Unit Test by right-clicking on the Java file, then Run As > jUnit Test
- Make sure the build is successful

## Recommended Reading
- **Gamma, Helm, Johnson, Vlissides (1995)**: "Design Patterns - Elements of Reusable Object-Oriented Software", Addison-Wesley, Boston (MA), USA
- **Buschmann, Meunier, Rohnert, Sommerlad, Stal (1996)**: "Pattern-Oriented Software Architecture - a System of Patterns", John Wiley & Sons Ltd, Hoboken (NJ), USA
- **Brown, Malveau, McCormick III, Mowbray (1998)**: "Anti-Patterns - Refactoring Software, Architecture and Projects in Crisis", John Wiley & Sons, New York City (NY), USA

_Optional Reading:_
- **Alexander, Silverstein, Ishikawa (1977)**: "A Pattern Language - Towns, Buildings, Construction", Oxford University Press, Oxford, UK