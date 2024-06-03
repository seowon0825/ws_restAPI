package com.example.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restapi.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

}
