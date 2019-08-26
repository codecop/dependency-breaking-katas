package org.codecop.dependencies.b

import java.time.DayOfWeek
import java.time.LocalDateTime

class MarketingCampaign {
    fun isActive(): Boolean {
        return milliSeconds() % 2 == 0L
    }

    private fun milliSeconds(): Long {
        return System.currentTimeMillis()
    }

    fun isCrazySalesDay(): Boolean {
        return dayOfWeek().compareTo(DayOfWeek.FRIDAY) == 0
    }

    protected fun dayOfWeek(): DayOfWeek {
        return LocalDateTime.now().dayOfWeek
    }
}