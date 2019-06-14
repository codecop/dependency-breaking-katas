A Parametrise Constructor
=========================

Preparation
-----------

Change value in `DiscountTest` so it will fail on day of workshop.
Currently the test fails each Friday.

What is the problem?
--------------------

All calls to `MarketingCampaign` are non deterministic.
We cannot create reliable tests.

Which option did you use?
-------------------------

* pass dependency into constructor and stub `MarketingCampaign` in tests.
  * minimal code change, fully automated refactoring, no magic
  * design improvement: move design towards DI
  * design improvement: makes dependencies visible
  * no subclass of `Discount` needed in test
  * might want to change all call sites

* extract factory method for `new MarketingCampaign()`, override `Discount` and stub in tests.
  * need to subclass and stub `Discount` in addition to `MarketingCampaign`

* extract calls to both `MarketingCampaign` methods, override `Discount` and stub in tests.
  * needs two Seams

* encapsulate field of `MarketingCampaign` with getter, override `Discount` and stub in tests.
  * no guarantee the getter is used for all field access

* use PowerMock/JMockit/TypeMock Isolator to stub `MarketingCampaign`'s methods in tests.
  * "tool of last resort"
  * magic
  * tests run slow, fragile, verbose
  * no pressure to improve code

* use Reflection to replace `MarketingCampaign` instance in `Discount` for tests.
  * magic
  * fragile, verbose

* introduce a global debug class or System Property `unit-test` or similar in `MarketingCampaign`
  * pollute production code with test code
  * increase complexity (another if, in potentially many places)
  * implicit dependency/surprise in code (violate POLS)

Typical Mistakes
----------------

* first test not renamed
* first test not mocked

Solution: Parametrise Constructor
---------------------------------

Generate new constructor with selected field and manually chain constructors.

IDE support: Introduce parameter on old constructor and keep old as delegate.

Design Hint
-----------

The `new` operator in the constructor violates OCP and DIP.
