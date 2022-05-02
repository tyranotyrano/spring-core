package com.tyranotyrano.domain.discount;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.tyranotyrano.domain.member.Grade;
import com.tyranotyrano.domain.member.Member;

@Component
@Primary
public class RateDiscountPolicy implements DiscountPolicy {

    private static final int DISCOUNT_PERCENT = 10; // 10% 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * DISCOUNT_PERCENT / 100;
        }

        return 0;
    }
}
