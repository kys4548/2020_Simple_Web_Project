package com.example.demo2;

public class AmountDefaultDiscountPolicy extends DefaultDiscountPolicy {
    private Money discountMount;

    public AmountDefaultDiscountPolicy(Money discountMount, DiscountCondition... conditions) {
        super(conditions);
        this.discountMount = discountMount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountMount;
    }
}
