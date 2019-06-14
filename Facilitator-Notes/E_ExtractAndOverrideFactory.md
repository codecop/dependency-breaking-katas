E Extract and Override Factory Method
=====================================

What is the problem?
--------------------

`UserConfirmation` is a user interface component which requires manual
interaction. A manual step is necessary to run the test.

Which option did you use?
-------------------------

* replace constructor with factory method call
  * minimal code change, fully automated refactoring, no magic
  * subclass of `Checkout` needed in test

* use lightweight UI testing tool like `java.awt.Robot` or Windows Input Simulator to operate the UI
  * fragile, depends on mouse position

* use PowerMock/JMockit/TypeMock Isolator to stub `JOptionPane`/`MessageBox`'s methods in tests.
  * "tool of last resort"
  * magic
  * tests run slow, fragile, verbose
  * no pressure to improve code

Typical Mistakes
----------------

* first test not renamed
* passing dependency into constructor is not working
  * confirmation must not start earlier

Solution: Extract and Override Factory Method
---------------------------------------------

Extract a factory method for `new UserConfirmation()` and widen access to `protected`
or package visibility. Comment or annotate as `visible for test`.
Override the factory method in the test.

IDE support: Extract method, include all duplicates.
In weak IDEs extract `UserConfirmation` constructor arguments to
local variables first and inline them after extraction.

Design Hint
-----------

The `new` operator in the constructor violates OCP.
The concrete type of `UserConfirmation` violates DIP.

Further Steps
-------------

* Extract a `Confirmation` interface which is independent of the user interface.
* Extract a `ConfirmationFactory` and inject into `Checkout` while leaning on tests.
