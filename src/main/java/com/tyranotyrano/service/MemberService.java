package com.tyranotyrano.service;

import com.tyranotyrano.domain.member.Member;

public interface MemberService {

	void join(Member member);

	Member findMember(Long memberId);
}
