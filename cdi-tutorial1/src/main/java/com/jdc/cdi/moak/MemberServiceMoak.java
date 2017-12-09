package com.jdc.cdi.moak;

import javax.enterprise.inject.Alternative;

import com.jdc.cdi.producers.Loggable;
import com.jdc.cdi.service.MemberService;

@Alternative
@Loggable
public class MemberServiceMoak implements MemberService {

	@Override
	public void create(String member) {
		System.out.println(member);
	}

}
