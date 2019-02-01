# Dependency Breaking Katas #

Exercises to practice breaking dependencies in legacy
code to create tests for it.

## Goal ##

We have some legacy code. We need to make changes.
To make changes we need to introduce tests first.
We might have to change some code to enable testing.
We need to introduce so-called Seams (see [Michael
Feathers' Working Effectively with Legacy
Code](https://www.goodreads.com/book/show/44919.Working_Effectively_with_Legacy_Code)).

Changing code without test is risky, so we want to

* Only change as little code as possible.
* Rely on automated Refactoring tools as much as possible.
* You must not change the public API of the class.

### Assignments for Techniques ###

* Parameterise Constructor
* Subclass And Override Method
* Extract And Override Call

WIP

* Replace Global Reference With Getter
* Extract And Override Factory Method

PLANNED

* Extract Interface
* Adapt Parameter

### Task ###

Each task presents you with a class and some collaborators.

* Bring this class under test. Make sure to cover all paths in the core logic.
* There is an existing test class with a first test case which might or might not work.
* You cannot change collaborators because they are used by other teams as well.

### License ###

[New BSD License](http://opensource.org/licenses/bsd-license.php), see `license.txt` in repository.
