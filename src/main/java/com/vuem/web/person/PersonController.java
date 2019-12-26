package com.vuem.web.person;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vuem.web.util.Printer;

import ch.qos.logback.classic.Logger;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class PersonController {
	@Autowired
	private PersonRepository  personRepository;
	@Autowired
	private Printer printer;
	@Autowired
	private Person person;
	
	@RequestMapping("/")
	public String index() {
		Iterable<Person> all = personRepository.findAll();
		StringBuilder sb = new StringBuilder();
		all.forEach(p -> sb.append(p.getName()+""));
		return sb.toString();
	}
	@PostMapping("/login")
	public HashMap<String,Object> login(@RequestBody Person param) {
		HashMap<String, Object> map = new HashMap<>();
		printer.accept("로그인 진입");
		printer.accept(String.format("USERID: %s", person.getUserid()));
		printer.accept(String.format("PASSWORD: %s", person.getPasswd()));
		
		person = personRepository.findByUseridAndPasswd(
				param.getUserid(),
				param.getPasswd());
		if(person != null) {
			printer.accept("로그인 성공");
			map.put("result", "SUCCESS");
			map.put("person", person);
		} else {
			map.put("result", "FAIL");
			map.put("person", person);
		}
		return map;
	}
	
	@RequestMapping("/join")
	public void join(@RequestBody Person person){
		/* HashMap<String, Object> map = new HashMap<>(); */
		printer.accept("가입진입");
		printer.accept(person.toString());
		personRepository.save(person);
		/*
		 * if(person != null ) { System.out.println("가입 성공"); map.put("result",
		 * "SUCCESS"); }else { System.out.println("가입 실패"); map.put("result", "FAIL"); }
		 */
		
	}
	@DeleteMapping("/withdrawal/{userid}")
	public void withdrawal(@PathVariable String userid) {
		printer.accept("로그아웃 진입");  //들어왔는지 확인하는 코드
		printer.accept(String.format("USERID: %s", person.getUserid())); //들어온 정보 확인
		printer.accept(String.format("PASSWORD: %s", person.getPasswd())); //들어온 정보 확인
		person = personRepository.findByUserid(userid);  //레파지토리에서 아이디받아오기
		personRepository.delete(person); //레파지토리에서 들어온 정보 삭제
	}
	@PutMapping("/modify/{userid}")
	public HashMap<String, Object> modify(@RequestBody Person person) {
		HashMap<String, Object> map = new HashMap<>();
		printer.accept("수정 진입");
		personRepository.save(person);
		if(person != null ) {
			System.out.println("가입 성공");
			map.put("result", "SUCCESS");
		}else {
			System.out.println("가입 실패");
			map.put("result", "FAIL");
		}
		return map;
	}
}