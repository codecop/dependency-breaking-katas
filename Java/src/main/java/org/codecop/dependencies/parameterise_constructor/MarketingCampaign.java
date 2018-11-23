package org.codecop.dependencies.parameterise_constructor;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class MarketingCampaign {

    public boolean isActive() {
        return System.currentTimeMillis() % 2 == 0;
    }

    public boolean isCrazySalesDay() {
        return LocalDateTime.now().getDayOfWeek().compareTo(DayOfWeek.FRIDAY) == 0;
    }
}
