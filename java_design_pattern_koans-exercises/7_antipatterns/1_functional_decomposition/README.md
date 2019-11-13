# Functional Decomposition Antipattern Exercise

In this exercise we are refactoring some legacy code.

The following diagram shows the target architecture. It's colors change with the progress of your solution.

@startuml
skinparam classAttributeIconSize 0

abstract class Shape {
    <color:testsColor(testFields[Checking class draw.Shape])>#id: UUID</color>
    <color:testsColor(testFields[Checking class draw.Shape])>#width: int</color>
    <color:testsColor(testFields[Checking class draw.Shape])>#height:int</color>
    <color:testsColor(testFields[Checking class draw.Shape])>#x: int</color>
    <color:testsColor(testFields[Checking class draw.Shape])>#y: int</color>
    <color:testsColor(testConstructors[Checking class draw.Shape])>+Shape(int,int,int,int): Shape</color>
    <color:testsColor(testMethods[Checking class draw.Shape])>+{abstract} draw(): void</color>
}

class Oval {
    <color:testsColor(testConstructors[Checking class draw.Oval])>+Oval(int,int,int,int): Oval</color>
    <color:green>+draw(): void</color>
    <color:green>+toString(): void</color>
    <color:testsColor(testMethods[Checking class draw.Oval],testOvalChangeForm)>+{static} changeForm(Shape): Oval</color>
}
class Rectangle {
    <color:testsColor(testConstructors[Checking class draw.Rectangle])>+Rectangle(int,int,int,int): Rectangle</color>
    <color:green>+draw(): void</color>
    <color:green>+toString(): void</color>
    <color:testsColor(testMethods[Checking class draw.Rectangle],testRectangleChangeForm)>+{static} changeForm(Shape): Rectangle</color>
}
class Circle {
    <color:testsColor(testConstructors[Checking class draw.Circle])>+Circle(int,int,int,int): Circle</color>
    <color:testsColor(testMethods[Checking class draw.Circle])>+draw(): void</color>
    <color:testsColor(testMethods[Checking class draw.Circle])>+toString(): void</color>
    <color:testsColor(testMethods[Checking class draw.Circle],testCircleChangeForm)>+{static} changeForm(Shape): Circle</color>
}

Oval -up-|> Shape #testsColor(testHierarchy[Checking class draw.Oval])
Rectangle -up-|> Shape #testsColor(testHierarchy[Checking class draw.Rectangle])
Circle -up-|> Shape #testsColor(testHierarchy[Checking class draw.Circle])

@enduml

**You have the following tasks:**

1. ✅[Abstract Shape Class](testHierarchy[Checking class draw.Shape],testFields[Checking class draw.Shape],testConstructors[Checking class draw.Shape],testMethods[Checking class draw.Shape])
Introduce an abstract `Shape` class. 
2. ✅[Refactor Oval and Rectangle](testHierarchy[Checking class draw.Oval],testFields[Checking class draw.Oval],testConstructors[Checking class draw.Oval],testHierarchy[Checking class draw.Rectangle],testFields[Checking class draw.Rectangle],testConstructors[Checking class draw.Rectangle])
Make `Oval` and `Rectangle` implement the new `Shape` Class
3. ✅[Build changeForm()](testMethods[Checking class draw.Oval],testMethods[Checking class draw.Rectangle],testOvalChangeForm,testRectangleChangeForm)
Introduce a static method `changeForm(Shape)` that transforms one shape into another.
4. ✅[Deprecate ShapeChanger](testIfChangeRectangleToOvalThrowsDeprecatedException,testIfChangeOvalToRectangleThrowsDeprecatedException)
The new solution does not use the `ShapeChanger` class anymore. Therefore deprecate both methods of `ShapeChanger`. Instead of doing anything, they should just throw a `DeprecatedException` from now on.
5. ✅[Add Circle](testHierarchy[Checking class draw.Circle],testFields[Checking class draw.Circle],testConstructors[Checking class draw.Circle],testMethods[Checking class draw.Circle],testCircleChangeForm)
Add a new shape `Circle` and implement the `changeForm` method for `Circle`.