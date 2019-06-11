B Subclass and Override Method
==============================

What is the problem?
--------------------

Some logic in `MarketingCampaign` is nondeterministic.
We cannot create reliable tests.

Which option did you use?
-------------------------

* override `dayOfWeek()` and `millis()` in tests
  * almost no code change, fully automated refactoring
  * breaks encapsulation

* extract `Timer` interface with two methods
  * more work, more risk
  * design improvement: move design towards DI
  * design improvement: makes dependencies visible
  * no subclass of `Discount` needed in test

* PowerMock (stub `LocalDate`, stub `System`)
  * "tool of last resort"
  * magic
  * tests run slow, fragile, verbose
  * no pressure to improve code

Typical Mistakes
----------------

* tbd

Solution: Subclass and Override Method
--------------------------------------

Make two methods `protected` or package visible.
Comment or annotate as `visible for test`.

Further Steps
-------------

* Extract `Timer` interface while leaning on tests.
