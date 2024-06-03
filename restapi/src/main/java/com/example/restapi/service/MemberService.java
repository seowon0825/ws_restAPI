package com.example.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restapi.entity.Member;
import com.example.restapi.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memRepository;
	
	public List<Member> findAllMember(){
		return memRepository.findAll();
	}
	
	public Optional<Member> findByIdMember(Long mno){
		return memRepository.findById(mno);
	}
	
	public Member saveMember(Member member) {
		return memRepository.save(member);
	}
	
	public void deleteMember(Long mno) {
		memRepository.deleteById(mno);
	}
	
	

}
