# Applying the Composite Pattern
- The composite pattern allows to model hierarchies
with arbitrary depth and width
- It lets a client treat individual objects and groups of
these objects uniformly
- The individual class is called **Leaf** , the group class
**Composite**. The super class is called **Component**

## Context
- You have to design the file system for an operating system

## Problem
- A file system consists of file system objects
- A file system object can be either a file or a directory
- A directory can itself contain other file system objects

## Solution
- The composite pattern has been used to model the problem in UML. Java source code has been written

## Your Task
- Apply the steps as described in the main [Readme file](https://github.com/togiberlin/java_design_pattern_koans#how-to-do-the-exercises)
- Fix the compile errors in the Java source code

## UML Model
![Composite Pattern](https://github.com/togiberlin/java_design_pattern_koans/raw/exercises/1_structural_patterns/1_composite_pattern/composite_pattern.png)