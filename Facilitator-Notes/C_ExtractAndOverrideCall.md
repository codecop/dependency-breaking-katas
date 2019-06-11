C Extract and Override Call
===========================

What is the problem?
--------------------

All calls to `ReceiptRepository` access the database
which is not available.

Which option did you use?
-------------------------

* extract and override (static) call
  * minimal code change, fully automated refactoring, no magic
  * subclass of `Discount` needed in test

* introduce global debug class with global flag `debug`
  * pollute production code with test code
  * introduce coupling to debug class
  * increase complexity (another if, in potentially many places)
  * surprise in code (violate POLS)
  * risk to disable code in production

* introduce a System Property `unit-test`
  * pollute production code with test code
  * increase complexity (another if, in potentially many places)
  * implicit dependency/surprise in code (violate POLS)
  * extra setup for environment variable needed

* use PowerMock/JMockit/TypeMock Isolator to stub `ReceiptRepository`'s method in tests.
  * "tool of last resort"
  * magic
  * tests run slow, fragile, verbose
  * no pressure to improve code

* wrap the `ReceiptRepository` singleton in a class and inject into `Checkout`.
  * more work, higher risk
  * might want to change all call sites
  * design improvement: move design towards DI
  * design improvement: makes dependencies visible

* set up HSQLDB
  * much work, unless in Spring application
  * we have no schema file
  * slow, fragile, no detailed feedback
  * full integration test, more confidence that database code works as well

Typical Mistakes
----------------

* tbd

Solution: Extract and Override Call
-----------------------------------

Extract method and widen access to `protected` or package visibility.

Further Steps
-------------

* Extract `ReceiptRepository` wrapper and inject into `Checkout` while leaning on tests.
