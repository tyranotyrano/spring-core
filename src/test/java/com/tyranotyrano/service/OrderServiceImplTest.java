package com.tyranotyrano.service;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.tyranotyrano.domain.discount.FixDiscountPolicy;
import com.tyranotyrano.domain.member.Grade;
import com.tyranotyrano.domain.member.Member;
import com.tyranotyrano.domain.member.repository.MemberRepository;
import com.tyranotyrano.domain.member.repository.MemoryMemberRepository;
import com.tyranotyrano.domain.order.Order;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderService orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}