package com.vuem.web.person;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/join")
	public Map<?,?> join(@RequestParam("userid")String userid, @RequestParam("passwd")String passwd){
		Map<String, String> map = new HashMap<>();
		System.out.println("뷰가 보낸 아이디" + userid + "," + passwd);
		map.put("userid", userid);
		return map;
		
	}
}
