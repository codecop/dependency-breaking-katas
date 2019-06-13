Facilitator Notes
=================

Understand the goal for participants:

* I want to bring the given class under unit test.
* How do I do that? Probably I have to change some code.
* See the difference between (risky) refactoring without tests vs. a minimal risk refactor and write tests first.
* See how simple it is to reach the solution.

Each Exercise (around 1 hour)
-----------------------------

1. What is the concrete problem which blocks me from writing a unit test here?
    * See *Problem Category* of each assignment.
1. Briefly explain the assignment
    * domain and source code
    * Maybe show critical pieces of code.
1. What needs to be done and what are we allowed to change?
    * Class `xy` needs to be unit tested.
    * Class `z` must not be changed.
    * No breaking changes on any public API.
    * See *Task* of each assignment.
    * Hide the name of the technique used. Do not tell how the change should be made.
1. Let them code in pairs (for 30 minutes)
    * Do not tell how the change should be made.
1. Stop coding and discuss possible solutions (for 10 minutes)
    * possible solutions
    * cost and risk of each solution
    * Make all agree that the proposed solution is the least risky.
    * Maybe explain solution as described in Michael Feathers' book.
    * Maybe explain solution with a drawing
1. Continue coding (for 30 minutes)
    * Implement proposed solution.
    * Add more tests, double collaborators.
    * Get to full code coverage.
1. Debrief (for 10 minutes)
    * Show a sample solution of a participant.
    * Maybe show sample solution.
    * Discuss pros and cons of this solution. Usually the solution is super simple.
    * Maybe show a demo how simple it is to reach the solution (e.g. 4 short cuts)
    * Maybe propose further changes to the code to improve its design.
1. Short break

Available Exercises
-------------------

SPOILER ALERT! Do not read these notes at least after you tried to solve the assignments.

* A) [ParameteriseConstructor](A_ParameteriseConstructor.md)
* B) [SubclassAndOverride](B_SubclassAndOverride.md)
* C) [ExtractAndOverrideCall](C_ExtractAndOverrideCall.md)
* D) [ReplaceGlobalReference](D_ReplaceGlobalReference.md)

WIP

* E) [ExtractAndOverrideFactory](E_ExtractAndOverrideFactory.md)
  * TODO assignment
  * TODO facilitator notes

PLANNED

* F) [ExtractInterface](F_ExtractInterface.md)
* G) [AdaptParameter](G_AdaptParameter.md)
