package org.codecop.dependencies.subclass_and_override;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class MarketingCampaign {

    public boolean isActive() {
        return System.currentTimeMillis() % 2 == 0;
    }

    public boolean isCrazySalesDay() {
        return dayOfWeek().compareTo(DayOfWeek.FRIDAY) == 0;
    }

    private DayOfWeek dayOfWeek() {
        return LocalDateTime.now().getDayOfWeek();
    }
}
