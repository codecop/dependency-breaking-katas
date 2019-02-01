package org.codecop.dependencies.b;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.function.LongSupplier;

public class MarketingCampaign {

    private final LongSupplier systemTimeMillis;

    public MarketingCampaign() {
        systemTimeMillis = System::currentTimeMillis;
    }

    public boolean isActive() {
        return milliSeconds() % 2 == 0;
    }

    private long milliSeconds() {
        return systemTimeMillis.getAsLong();
    }

    public boolean isCrazySalesDay() {
        return dayOfWeek().compareTo(DayOfWeek.FRIDAY) == 0;
    }

    private DayOfWeek dayOfWeek() {
        return LocalDateTime.now().getDayOfWeek();
    }
}
