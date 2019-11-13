# Lava Flow Exercise

In this exercise we are refactoring some legacy code.

The following diagram shows the classes to refactor. It's colors change with the progress of your solution.

@startuml
skinparam classAttributeIconSize 0

abstract class LightSwitchCommand #testsColor(testFields[Checking class LightSwitchCommand],testMethods[Checking class LightSwitchCommand])
class FlipDownCommand #testsColor(testFields[Checking class FlipDownCommand],testMethods[Checking class FlipDownCommand])
class FlipUpCommand #testsColor(testFields[Checking class FlipUpCommand],testMethods[Checking class FlipUpCommand])
class Switch #testsColor(testFields[Checking class Switch],testMethods[Checking class Switch])
class Driver #testsColor(testFields[Checking class Driver],testMethods[Checking class Driver])
class Light #testsColor(testFields[Checking class Light],testMethods[Checking class Light])

FlipUpCommand -up-|> LightSwitchCommand
FlipDownCommand -up-|> LightSwitchCommand

LightSwitchCommand -- Light
Switch -- FlipDownCommand
Switch -- FlipUpCommand

Driver -- FlipDownCommand
Driver -- FlipUpCommand
Driver -- Light
Driver -- Switch

@enduml

**You have the following tasks:**

1. Look for unused methods
2. Refactor the code to remove the Lava Flow