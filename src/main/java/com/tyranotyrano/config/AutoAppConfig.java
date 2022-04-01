package com.tyranotyrano.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.tyranotyrano.domain.member.repository.MemberRepository;
import com.tyranotyrano.domain.member.repository.MemoryMemberRepository;

@Configuration
@ComponentScan(
    basePackages = "com.tyranotyrano",
    // basePackageClasses = AutoAppConfig.class,
    // @Configuration 이 붙은 클래스는 빈 등록 대상에서 제외
    excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    // 중복 이름으로 빈 생성을 위해 임시로 넣음
    /*@Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }*/
}
