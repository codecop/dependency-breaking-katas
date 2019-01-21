Replace Global Reference with Getter
====================================

Goal
----

We have some legacy code. We need to make changes.
To make changes we need to introduce tests first.
We might have to change some code to enable testing.
We need to introduce so-called Seams (see Michael
Feathers' Working Effectively with Legacy Code).
Changing code without test is risky, so we want to

* Only change as little code as possible.
* Rely on automated Refactoring tools as much as possible.
* You must not change the public API of the class.

Problem Category
----------------

The system under test depends on a collaborator with
slow behaviour via a http call. It is not guaranteed
that the REST server is available. The collaborator is
a Singleton and called multiple times.

Task
----

The given code calculates the shipping cost for a purchase
depending on the destination in our online shop. The main
logic is in `ShippingCost`.

* Bring `ShippingCost` under test. Make sure to cover all paths in the core logic.
* There is an existing `ShippingCostTest` with a first test case which might or might not work.
* You cannot change `RestCountriesAPI` because it is used by other teams as well.
