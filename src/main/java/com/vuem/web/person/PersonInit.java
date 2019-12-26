package com.vuem.web.person;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.vuem.web.proxy.Proxy;

@Component
public class PersonInit extends Proxy implements ApplicationRunner{
	private PersonRepository PersonRepository;
	private static final DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
	@Autowired
	public PersonInit(PersonRepository PersonRepository) {
		this.PersonRepository = PersonRepository;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		long count = PersonRepository.count();
		if(count == 0) {
			Person person = null;
			String[][] mtx = {{"hong", "1", "홍길동", "1999-01-01","N","0","0","0","teacher"},
							  {"kim", "1", "김유신", "1981-08-05","W","0","0","0","manager"},
							  {"park", "1", "박지성", "1970-07-05","N","0","0","230","manager"},
							  {"you", "1", "유관순", "1985-09-09","W","3","2","220","student"},
							  {"lee", "1", "이은지", "1992-02-01","W","4","3","270","student"},
							  {"yang", "1", "양현미", "1993-06-05","W","2","1","280","student"},
							  {"jang", "1", "장해경", "1997-06-05","W","1","4","210","student"},
							  {"se", "1", "김세종", "1990-04-09","N","3","2","200","student"},
							  {"min", "1", "김민국", "1890-01-01","N","1","3","280","student"},
							  {"choi", "1", "최광진", "1970-05-05","N","4","1","290","student"},
							  {"jin", "1", "박형진", "1700-05-05","N","2","3","220","student"},
							  {"ho", "1", "박근호", "1999-09-09","N","4","4","210","student"},
							  {"na", "1", "나성", "1993-01-01","N","1","2","230","student"},
							  {"kwon", "1", "권혜령", "1999-05-05","W","1","3","250","student"},
							  {"bee", "1", "이은비", "2000-06-05","W","2","2","270","student"},
							  {"sin", "1", "신가람", "1999-09-09","W","3","1","240","student"},
							  {"jun", "1", "이준교", "1992-02-01","N","1","3","220","student"},
							  {"nado", "1", "나도욱", "1993-05-05","N","4","4","230","student"},
							  {"ye", "1", "김예지", "1988-06-05","W","1","2","280","student"},
							  {"ha", "1", "하정우", "1984-06-09","N","3","3","240","student"},
							  {"nam", "1", "김남길", "1985-04-01","N","2","1","280","student"},
							  {"vo", "1", "박보검", "1999-08-05","N","4","3","220","student"},
							  {"kang", "1", "강동원", "1997-06-05","N","2","2","290","student"},
							  {"jea", "1", "이정재", "1995-09-09","N","1","4","220","student"}
							  };
			/*Person p2 = new Person();
			String[] hong = {"hong", "1", "홍길동", "1980-01-01"};
			String[] kim = {"kim", "1", "김유신", "1980-05-05"};*/
			for(String[] arr : mtx) {
				person = new Person();
				person.setUserid(arr[0]);
				person.setPasswd(arr[1]);
				person.setName(arr[2]);
				person.setBirthday(df.parse(arr[3]));
				person.setGender(arr[4]);
				person.setHak(integer(arr[5]));
				person.setBan(integer(arr[6]));
				person.setScore(integer(arr[7]));
				person.setRoll(arr[8]);
				PersonRepository.save(person);
			}
			/*for(int i=0; i<mtx.length; i++) {
				person = new Person();
				person.setUserid(mtx[i][0]);
				person.setPasswd(mtx[i][1]);
				person.setName(mtx[i][2]);
				person.setBirthday(df.parse(mtx[i][3]));
				PersonRepository.save(person);
			}*/
		}
	}
}