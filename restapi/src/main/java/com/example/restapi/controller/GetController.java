package com.example.restapi.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.dto.MemberDto;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {
	
	//http://localhost:8091/api/v1/get-api/hello
	@GetMapping("/hello")
	public String getHello() {
		
		return "Hello RestApi~~";
	}
	
	//http://localhost:8091/api/v1/get-api/name
	@GetMapping("/name")
	public String getName() {
		
		return "HongGilDong";
	}
	
	//http://localhost:8091/api/v1/get-api/variable1/123
	//value=aaa
	@GetMapping("/variable1/{variable}")
	public String getVariable1(@PathVariable("variable") String variable) {
		
		return variable;
	}
	
	//http://localhost:8091/api/v1/get-api/variable2/aaa 
	//value=aaa
	@GetMapping("/variable2/{variable}")
	public String getVariable2(@PathVariable("variable") String var) {
		
		return var;
	}
	
	//http://localhost:8091/api/v1/get-api/request?name=배서원&email=bsw0825@naver.com&addr=부산광역시 금정구
	//value = 배서원, bsw0825@naver.com, 부산광역시 금정구
	@GetMapping("/request")
	public String getRequestParam1(
			@RequestParam("name") String name, 
			@RequestParam("email") String email,
			@RequestParam("addr") String addr
			) {
		
		return name + ", " + email + ", " + addr;
	}
	
	//http://localhost:8091/api/v1/get-api/request2?name=배서원&email=bsw0825@naver.com
	//name : 배서원
	//email : bsw0825@naver.com
	//ex)취미처럼 누군가는 입력하고 누군가는 입력안할수도 있는 곳에 사용
	@GetMapping("/request2")
	public String getRequestParam2(
			@RequestParam Map<String, String> param) {
		
		StringBuilder sb = new StringBuilder();
		param.entrySet().forEach(map -> {
			sb.append(map.getKey() + " : " + map.getValue() + "\n");
		});
		
		return sb.toString();
	}
	
	//http://localhost:8091/api/v1/get-api/request3?name=배서원&email=bsw0825@naver.com&addr=부산광역시 금정구
	//value = MemberDto(name=배서원, email=bsw0825@naver.com, addr=부산광역시 금정구)
	//커맨드객체 : model을 사용하지 않고도 view까지 전달해줌.
	@GetMapping("/request3")
	public String getRequestParam3(MemberDto memberDto) {
		
		return memberDto.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
