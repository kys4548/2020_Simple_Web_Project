package com.example.demo03;

import java.time.Duration;

public class NightDiscountPolicy extends BasicRatePolicy {
    private static final int LATE_NIGHT_HOUR = 22;

    private Money nightlyAmount;
    private Money regularAmount;
    private Duration duration;

    public NightDiscountPolicy(Money nightlyAmount, Money regularAmount, Duration duration) {
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.duration = duration;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        if(call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
            return this.nightlyAmount.time(call.getDuration().getSeconds() / this.duration.getSeconds());
        }
        return this.regularAmount.time(call.getDuration().getSeconds() / this.duration.getSeconds());
    }
}
