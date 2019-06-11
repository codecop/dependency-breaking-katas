D Replace Global Reference with Getter
======================================

What is the problem?
--------------------

All calls to `RestCountriesAPI` perform HTTP calls which are very slow and unreliable.

Which option did you use?
-------------------------

* replace (static) global data with getter call
  * minimal code change, fully automated refactoring, no magic
  * subclass of `ShippingCost` needed in test

* extract and override (static) calls
  * works well, need to override three calls
  * subclass of `ShippingCost` needed in test

* wrap the `RestCountriesAPI` singleton in a class and inject into `ShippingCost`.
  * more work, higher risk
  * might want to change all call sites
  * design improvement: move design towards DI
  * design improvement: makes dependencies visible

* use WireMock to simulate the HTTP calls
  * much work
  * actual HTTP and JSON is hidden behind framework
  * we have no schema files

* set up local HTTP server with stub responses
  * much work
  * actual HTTP and JSON is hidden behind framework
  * we have no schema files, need to replay recorded responses
  * slow, fragile, no detailed feedback
  * full integration test, more confidence that REST code works as well

* use PowerMock/JMockit/TypeMock Isolator to stub `RestCountriesAPI`'s methods in tests.
  * "tool of last resort"
  * magic
  * tests run slow, fragile, verbose
  * no pressure to improve code

Typical Mistakes
----------------

* tbd

Solution: Replace Global Reference with Getter
----------------------------------------------

Extract a getter method for `RestCountriesAPI.getInstance()` and widen access to `protected`
or package visibility. Override the call in the test.

Further Steps
-------------

* Extract a `RestCountriesAPI` wrapper and inject into `ShippingCost` while leaning on tests.
