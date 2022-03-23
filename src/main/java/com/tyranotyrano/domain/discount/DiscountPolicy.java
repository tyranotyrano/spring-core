package com.tyranotyrano.domain.discount;

import com.tyranotyrano.domain.member.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액(할인한 금액)
     */
    int discount(Member member, int price);
}
