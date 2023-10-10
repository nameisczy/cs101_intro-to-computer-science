---
title: Exam 3 Review
permalink: /slides/exam-3-review/
---

class: center, middle

# Exam 3 Review

Intro to Computer Science

---

# Agenda

1. [Exam Structure](#structure)
1. [Prior Knowledge](#prior-knowledge)
1. [Inheritance](#inheritance)
1. [Polymorphism](#polymorphism)
1. [Interfaces](#interfaces)
1. [Abstract Classes](#abstract-classes)
1. [Exceptions and Errors](#exceptions)
1. [Recursion](#recursion)
1. [Conclusions](#conclusions)

---

name: structure

# Structure

--

## Overview

The exam will take place during class time. It will be composed of two parts:

1. Google Form Quiz (40%)
1. GitHub Assignment (60%)

---

template: structure

## Accepting the Exam

Students **must** accept the exam by...

1. Clicking the link provided by the instructor to the Google Form.
1. Clicking the link provided by the instructor to the GitHub Assignment, and following the instructions therein to "accept" the assignment.

---

template: structure

## Submitting the Exam

Students **must** submit the exam by the end of the exam period.

1. Click the Submit button on the Google Form.
1. `push` the GitHub Assignment code to GitHub.

---

template: structure

## Verifying Your Submission

Students **must** verify on your own that you have actually submitted the exam.

1. See the confirmation message on the Google Quiz after clicking submit.
1. Click the link provided by the instructor to the GitHub Assignment, and verifying that your code has been pushed to the repository.

---

name: prior-knowledge

# Prior Knowledge

--

## Cumulative by nature

By nature of the material, the exam will include what was tested previously. So you would be wise to brush up:

- Java Exam 1 Review
- Java Exam 2 Review

---

name: inheritance

# Inheritance

--

## Overview

We now know there are multiple types of inheritance in Java:

- inheritance from a class
  - concrete classes
  - abstract classes
- inheritance via interfaces
  - a class can implement more than one interface
  - interfaces can pass on both abstract and default methods

---

name: polymorphism

# Polymorphism

--

## Overview

The reference to an object is of a different type than the object's declared type.

```java
Mammal barstein = new Human("Foo", "Barstein");
```

---

template: polymorphism

## Reference types

Polymorphic references can be of:

- an ancestor class type
- an interface type

Polymorphic references can not be of:

- a child class type

---

template: polymorphism

## In practice

In many cases, polymorophism is practically applied when it is convenient to do batch processes on a bunch of objects that share a common ancestor. In such situations, we place those various objects into some sort of collection (array, ArrayList, etc) that is typed as the ancestor class or interface that all the objects share in common.

```java
//say you have a bunch of Mammals
Mammal[] mammals = {
    new Human("Foo", "Barstein"),
    new Dog("Fido"),
    new Mouse("Minnie")
};

//do some kind of batch process on all these Mammals
for (Mammal mammie : mammals) {
//do some things all Mammals can do, regardless of their declared type
mammie.tickle();

    //do some things only a particular declared sub-type of Mammal can do
    if (mammie instanceof Dog) {
        ((Dog) mammie).bark();
    }

}
```

---

name: interfaces

# Interfaces

--

## Overview

Interfaces are a reference type that provide a form of inheritance, similar to classes, but with some key differences in purpose and implementation. Interfaces are often named with words ending in the [https://en.wiktionary.org/wiki/-able#Suffix suffix, "able"]].

---

template: interfaces

## Raison d'être

Interfaces are used to impose a contractual obligation on classes that they implement a particular set of methods with specific signatures. Why might this be useful?

---

template: interfaces

## Limitations

Interfaces can contain only:

- static constants
- static methods
- abstract methods
- default methods

All methods and properties in an interface are public.

In what case are default methods useful?

---

name: abstract-classes

# Abstract classes

--

## Overview

Like interfaces, abstract classes can contain abstract methods and provide a form of inheritance. In what cases are abstract classes preferable to interfaces? To concrete classes?

---

template: abstract-classes

## Raison d'être

In what case are abstract classes preferable to interfaces?

---

template: abstract-classes

## Limitations

Unlike interfaces, abstract classes can contain any sorts of properties and methods. Thus, they are in many ways similar to concrete classes. However...

--

Unlike concrete classes, abstract classes...

- can contain abstract methods
- can not be instantiated

---

name: exceptions

# Exceptions and Errors

--

## Errors

Errors are irremediable failures that are usually due to external factors outside the scope of your code

- stack overflow
- running out of memory
- hard drive problems
- database problems

---

template: exceptions

## Exceptions

Exceptions represent known problematic situations that can potentially be handled in code by one of two means:

- `throws` declaration
- `try`/`catch`

Exceptions are represented in code as objects of various classes that extend Exception class.

---

name: recursion

# Recursion

--

## Overview

Methods that invoke themselves. A form of iteration, but different from loops.

---

template: recursion

## Classic examples

The classic pattern: handle the base case, and then recurse on the remainder. Examples:

- Fibonacci numbers
- Computing powers
- Counting digits
- Flipping strings backwards
- Linear search
- Fractal images

---

template: recursion

## Termination

The recursion must terminate somehow in order not to trigger a stack overflow error. How does it stop recursing?

---

name: conclusions

# Conclusions

Thank you. Good luck!
