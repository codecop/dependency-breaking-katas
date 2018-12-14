Parameterise Constructor
========================

What is the problem?
--------------------

All calls to `MarketingCampaign` are nondeterministic.
We cannot create reliable tests.

Which option did you use?
-------------------------

* pass dependency into constructor and stub `MarketingCampaign` in tests.
    * minimal code change, fully automated refactoring, no magic
    * design improvement: move design towards DI
    * design improvement: makes dependencies visible
    * no subclass of `Discount` needed in test
     
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

Solution
--------

Generate new constructor with selected field and manually chain constructors.

Introduce parameter on old constructor and keep old as delegate.
