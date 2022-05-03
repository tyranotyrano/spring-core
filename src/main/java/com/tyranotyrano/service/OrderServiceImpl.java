package com.tyranotyrano.service;

import org.springframework.stereotype.Component;

import com.tyranotyrano.annotation.MainDiscountPolicy;
import com.tyranotyrano.domain.discount.DiscountPolicy;
import com.tyranotyrano.domain.member.Member;
import com.tyranotyrano.domain.member.repository.MemberRepository;
import com.tyranotyrano.domain.order.Order;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository,
                            @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    /**
     * 테스트 용도!
     * */
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
