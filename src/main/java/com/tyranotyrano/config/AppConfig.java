package com.tyranotyrano.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tyranotyrano.domain.discount.DiscountPolicy;
import com.tyranotyrano.domain.discount.FixDiscountPolicy;
import com.tyranotyrano.domain.discount.RateDiscountPolicy;
import com.tyranotyrano.domain.member.repository.MemberRepository;
import com.tyranotyrano.domain.member.repository.MemoryMemberRepository;
import com.tyranotyrano.service.MemberService;
import com.tyranotyrano.service.MemberServiceImpl;
import com.tyranotyrano.service.OrderService;
import com.tyranotyrano.service.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        // 1. 정액 할인 정책
        //return new FixDiscountPolicy();

        // 2. 정률 할인 정책
        return new RateDiscountPolicy();
    }
}
