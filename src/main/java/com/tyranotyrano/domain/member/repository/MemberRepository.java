package com.tyranotyrano.domain.member.repository;

import com.tyranotyrano.domain.member.Member;

public interface MemberRepository {

	void save(Member member);

	Member findById(Long memberId);
}
