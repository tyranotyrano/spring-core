package com.tyranotyrano.domain.member.repository;

import java.util.HashMap;
import java.util.Map;

import com.tyranotyrano.domain.member.Member;

public class MemoryMemberRepository implements MemberRepository {

	private static Map<Long, Member> store = new HashMap<>();

	@Override
	public void save(Member member) {
		store.put(member.getId(), member);
	}

	@Override
	public Member findById(Long memberId) {
		return store.get(memberId);
	}
}
