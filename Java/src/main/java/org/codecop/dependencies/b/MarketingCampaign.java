package org.codecop.dependencies.b;

import java.time.DayOfWeek;
import java.util.function.Supplier;

public class MarketingCampaign {

    private final Supplier<DayOfWeek> clockSupplier;
    private final Supplier<Long> systemMsSupplier;

    public MarketingCampaign(Supplier<DayOfWeek> dayOfWeekSupplier, Supplier<Long> currentTimeInMsSupplier) {
        clockSupplier = dayOfWeekSupplier;
        systemMsSupplier = currentTimeInMsSupplier;
    }

    public boolean isActive() {
        return milliSeconds() % 2 == 0;
    }

    protected long milliSeconds() {
        return systemMsSupplier.get();
    }

    public boolean isCrazySalesDay() {
        return dayOfWeek().compareTo(DayOfWeek.FRIDAY) == 0;
    }

    protected DayOfWeek dayOfWeek() {
        return clockSupplier.get();
    }
}
