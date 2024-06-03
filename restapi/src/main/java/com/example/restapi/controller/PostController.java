package com.example.restapi.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.dto.MemberDto;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {
	
	//http://localhost:8091/api/v1/post-api/domain
	@PostMapping("/domain")
	//@RequestMapping(value = "/domain", method=RequestMethod.POST)
	public String postExample() {
		return "Hello Post Api~~~";
	}
	
	//http://localhost:8091/api/v1/post-api/member0
	@PostMapping("/member0")
	public String postMember0(
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("addr") String addr) {
		return "name:" + name + ", email: " + email + ", addr: " + addr;
	}
	
	//http://localhost:8091/api/v1/post-api/member
	/*body = {
  	"name": "이현진",
  	"email": "jindoring@naver.com",
  	"addr": "Busan"
	}*/
	/*value = name : 이현진
	email : jindoring@naver.com
	addr : Busan*/
	@PostMapping("/member")
	public String postMember(@RequestBody Map<String, Object> postData) {
		StringBuilder sb = new StringBuilder();
		postData.entrySet().forEach(map -> {
			sb.append(map.getKey() + " : " + map.getValue() + "\n");
		});
		
		return sb.toString();
	}
	
	//http://localhost:8091/api/v1/post-api/member2
	//value = MemberDto(name=이현진, email=jindoring@naver.com, addr=Busan)
	@PostMapping("/member2")
	public String postMemberDto(@RequestBody MemberDto memberDto) {
		
		return memberDto.toString();
	}
	
	//http://localhost:8091/api/v1/post-api/member2
	/*value = {
	"name": "이현진",
	"email": "jindoring@naver.com",
	"addr": "Busan"
	}*/
	@PostMapping("/member3")
	public MemberDto postMemberDto2(@RequestBody MemberDto memberDto) {
		
		return memberDto;
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
}
