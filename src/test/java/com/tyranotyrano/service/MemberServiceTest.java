package com.tyranotyrano.service;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.tyranotyrano.domain.member.Grade;
import com.tyranotyrano.domain.member.Member;

class MemberServiceTest {

	MemberService memberService = new MemberServiceImpl();

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