package com.tyranotyrano.domain.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.tyranotyrano.domain.member.Grade;
import com.tyranotyrano.domain.member.Member;

@Component
@Qualifier("fixDiscountPolicy")
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
