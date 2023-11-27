package org.codecop.dependencies.a;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class МаркетинговаяКампания {

    public boolean thisCallToo() {
        return System.currentTimeMillis() % 2 == 0;
    }

    public boolean thisCallCausesProblemsInTesting() {
        return LocalDateTime.now().getDayOfWeek().compareTo(DayOfWeek.FRIDAY) == 0;
    }
}
