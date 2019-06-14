Assignment A
============

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
non deterministic behaviour. The collaborator is
initialised in the constructor.

Task
----

The given code calculates the discount for a purchase in
our online shop. The main logic is in `Discount`.

* Bring `Discount` under test. Make sure to cover all paths in the core logic.
* There is an existing `DiscountTest` with a first test case which might or might not work.
* You cannot change `MarketingCampaign` because it is used by other teams as well.

(This is a copied document - do not edit!)
