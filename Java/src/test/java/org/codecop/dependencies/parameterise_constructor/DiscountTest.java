package org.codecop.dependencies.parameterise_constructor;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class DiscountTest {

    @Test
    public void test1() {
        final Discount discount = new Discount();

        final Money net = new Money(1002);
        final Money total = discount.discountFor(net);

        // Assert.assertThat(total, CoreMatchers.is(new Money(new BigDecimal("901.8"))));
        Assert.assertEquals(new Money(new BigDecimal("851.7")).describe(), total.describe());
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
   3.5. introduce "describe" und verwende es im Test
        Problem: eine Methode nur für Test hinzugefügt.
        -> schönste Lösung für uns (wenn ToString nicht geht)

4. test anpassen? -> 851.7
   green
   run with coverage -> 3 von 4 branches rot.
 */