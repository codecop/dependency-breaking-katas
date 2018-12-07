package org.codecop.dependencies.parameterise_constructor;

import java.math.BigDecimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DiscountTest {

    @Test
    public void higher_discount_for_CrazySalesDay() {
        Discount discount = new Discount(new MarketingCampaign() {
            @Override
            public boolean isCrazySalesDay() {
                return true;
            }
        });
        
        Money net = new Money(1002);
        Money total = discount.discountFor(net);

        assertEquals(new Money(new BigDecimal("851.7")).describe(), total.describe());
    }

    @Test
    public void good_discount_for_huge_purchase() {
        Discount discount = new Discount(new MarketingCampaign() {
            @Override
            public boolean isCrazySalesDay() {
                return false;
            }
        });

        Money net = new Money(1002);
        Money total = discount.discountFor(net);

        assertEquals(new Money(new BigDecimal("901.8")).describe(), total.describe());
    }

    @Test
    public void some_discount_for_small_purchase() {
        Discount discount = new Discount(new MarketingCampaign() {
            @Override
            public boolean isCrazySalesDay() {
                return false;
            }

            @Override
            public boolean isActive() {
                return true;
            }
        });

        Money net = new Money(102);
        Money total = discount.discountFor(net);

        assertEquals(new Money(new BigDecimal("96.9")).describe(), total.describe());
    }

    @Test
    public void no_discount_for_small_purchase_when_campaign_not_active() {
        Discount discount = new Discount(new MarketingCampaign() {
            @Override
            public boolean isCrazySalesDay() {
                return false;
            }

            @Override
            public boolean isActive() {
                return false;
            }
        });

        Money net = new Money(102);
        Money total = discount.discountFor(net);

        assertEquals(new Money(new BigDecimal("102")).describe(), total.describe());
    }

    @Test
    public void no_discount_for_usual_day() {
        Discount discount = new Discount(new MarketingCampaign() {
            @Override
            public boolean isCrazySalesDay() {
                return false;
            }
        });

        Money net = new Money(10);
        Money total = discount.discountFor(net);

        assertEquals(new Money(new BigDecimal("10")).describe(), total.describe());
    }

    @Test
    public void no_discount_for_usual_day_mockito() {
        MarketingCampaign campaign = mock(MarketingCampaign.class);
        when(campaign.isCrazySalesDay()).thenReturn(false);
        Discount discount = new Discount(campaign);

        Money net = new Money(10);
        Money total = discount.discountFor(net);

        assertEquals(new Money(new BigDecimal("10")).describe(), total.describe());
    }
}

/*

1. run tests -> red or green
2. falls red -> was ist das Problem
3. ich sehe es nicht weil Money kein toString hat
   3.1. debuggen
        breakpoint, starten, 2x auffalten
        Problem: muss es jedes Mal machen, wenn test rot ist (mühsam)
        -> FUNKTIONIERT, aber mühsam
   3.2. add toString
        darf ich das mit einer Methode die polymorph aufgerufen wird. eigentlich nicht.
        Problem: ev. legacy code etwas böses tut (geringe Wahrscheinlichkeit)
        -> ist Java Standard, je nach Risk machbar oder nicht
        -> je nachdem muss eine andere Methode nehmen
   3.3. change assert to use money.value, make value package access (with comment * visible for test *)
        Problem: break encapsulation, lower abstraction of test
        -> aber es ist alles immutable, somit kein Problem
   3.4. matcher für Money. also needs access to value
        braucht auch das toString, aber das haben wir nicht
        Problem: break encapsulation
        // Assert.assertThat(total, CoreMatchers.is(new Money(new BigDecimal("901.8"))));
   3.5. introduce "describe" und verwende es im Test
        Problem: eine Methode nur für Test hinzugefügt.
        -> schönste Lösung für uns (wenn ToString nicht geht)
        !! wir haben Code geschrieben ohne Test

4. test anpassen? -> 851.7
   green
   run with coverage -> 3 von 4 branches rot.

5. add more test cases
   egal was wir machen, es geht nicht, weil crazy sales schluckt alles.
   5.1. dependency im ctor übergeben (stub Campaign)
   5.2. call in methode auslagern und überschreiben (subclass, "partial stub")

   5.3. mit (encapsulate) getter kapseln und überschreiben (subclass, stub Campaign)
   5.4. lazy create überschreiben (subclass, stub Campaign)

   5.5. power mock (stub Campaign)
   5.6. nach Instanzierung mit Refection tauschen (stub Campaign)

6. modify code via 5.1, only automatic?, minimal code change in production?
   6.1.a generate constructior with selected field, chain constructors (manually)
   6.1.b. introduce parameter and keep old method as delegate
      one existing test protects the no-args constructor
   6.2.a stub campaign via subclass
         Vorteil: sehr schnell gemacht, direkt, klar zu verstehen, nur Struktur
         Nachteil: wir executieren constructor von Campaign, das könnte schief gehen
         TODO überlegen...
   6.2.b stub with Mockito
         get dependency into Maven
         schreibe 2 Zeilen
         Vorteil: kann den stub für alle Tests benutzen
         Nachteil: magic, API, Learning Curve
   6.3. use same strategy for first existing tests. (MANDATORY)
        because it will fail tomorrow. Remember, it did fail when we started because of Friday.
        (Facilitator Hint. Change test so it fails on day of workshop first)
        because of we have a constructor for test, now use it in test (maybe) - other is not "stable"
        because of symmetry
        because of first test was not unit test, but integrated (need to get rid of dependency)

7. add more test cases
   7.1. add test for branch, run, take result as is (because of Legacy code)
        full line coverage, aber fehlt uns noch etwas?
        conditions!
   7.2. full coverage yeah!
   7.3. cleanup duplication
        . make factory methods for campaign with two boolean arguments
        . move mockito to field and use Rule
        . sort tests
        . rename tests/check names in the end
 */