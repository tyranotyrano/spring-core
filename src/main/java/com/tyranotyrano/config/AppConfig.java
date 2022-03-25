package com.tyranotyrano.config;

import com.tyranotyrano.domain.discount.FixDiscountPolicy;
import com.tyranotyrano.domain.member.repository.MemoryMemberRepository;
import com.tyranotyrano.service.MemberService;
import com.tyranotyrano.service.MemberServiceImpl;
import com.tyranotyrano.service.OrderService;
import com.tyranotyrano.service.OrderServiceImpl;

public class AppConfig {
    
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
