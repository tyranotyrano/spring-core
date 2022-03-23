package com.tyranotyrano.domain.discount;

import com.tyranotyrano.domain.member.Grade;
import com.tyranotyrano.domain.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private static final int DISCOUNT_FIX_AMOUNT = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return DISCOUNT_FIX_AMOUNT;
        }

        return 0;
    }
}
