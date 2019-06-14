B Subclass and Override Method
==============================

Preparation
-----------

Change value in `MarketingCampaignTest` so it will fail on day of workshop.
Currently the test fails each Friday.

What is the problem?
--------------------

Some logic in `MarketingCampaign` is non deterministic.
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

* first test not renamed
* first test not mocked

Solution: Subclass and Override Method
--------------------------------------

Make the two methods `protected` or package visible.
Comment or annotate as `visible for test`.
Use a test specific subclass to stub both methods.

Design Hint
-----------

`MarketingCampaign` violates SRP as it works with time and
contains the business rules for marketing campaigns.

Further Steps
-------------

* Extract `Timer` interface while leaning on tests.
