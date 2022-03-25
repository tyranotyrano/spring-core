package com.tyranotyrano.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.tyranotyrano.config.AppConfig;
import com.tyranotyrano.domain.member.Grade;
import com.tyranotyrano.domain.member.Member;

class MemberServiceTest {

	MemberService memberService;

	@BeforeEach
	public void beforeEach() {
		AppConfig appConfig = new AppConfig();
		memberService = appConfig.memberService();
	}

	@Test
	void join() {
		// given
		Member member = new Member(1L, "memberA", Grade.VIP);

		// when
		memberService.join(member);

		// then
		Member findMember = memberService.findMember(1L);
		Assertions.assertThat(member).isEqualTo(findMember);
	}
}