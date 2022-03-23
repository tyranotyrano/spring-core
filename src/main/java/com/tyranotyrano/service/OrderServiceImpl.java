package com.tyranotyrano.service;

import com.tyranotyrano.domain.discount.DiscountPolicy;
import com.tyranotyrano.domain.discount.FixDiscountPolicy;
import com.tyranotyrano.domain.member.Member;
import com.tyranotyrano.domain.member.repository.MemberRepository;
import com.tyranotyrano.domain.member.repository.MemoryMemberRepository;
import com.tyranotyrano.domain.order.Order;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
