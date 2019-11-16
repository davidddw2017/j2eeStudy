package org.cloud.ssm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.cloud.ssm.entity.Person;
import org.cloud.ssm.service.PersonService;
import org.cloud.ssm.utils.PageResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/lucky")
public class LuckyController {

	private static List<Person> allPersons;

	@Autowired
	private PersonService service;

	@GetMapping("/list")
	public @ResponseBody PageResultBean<Person> listEmployee(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit) {
		List<Person> emps = service.getAll(page, limit);
		long count = service.getCount(new Person());
		return new PageResultBean<Person>(count, emps);
	}

	@GetMapping
	public String lucky(ModelMap model) throws Exception {
		model.addAttribute("count", service.getCount(new Person()));
		allPersons = service.getAll();
		return "lucky";
	}

	@GetMapping("/all")
	public @ResponseBody List<Person> listAllEmployee() {
		return allPersons;
	}
	
	@GetMapping("/totalNum")
	public @ResponseBody int totalNum() {
		int sum = 0;
		for (Person person: allPersons) {
			if (!person.getLucky()) {
				sum ++;
			}
		}
		return sum;
	}

	@GetMapping("/luckyNum")
	public @ResponseBody List<Person> luckyNum(
			@RequestParam(value = "luckyNum", defaultValue = "1") int luckyNum,
			@RequestParam(value = "luckyPrize", defaultValue = "1") int luckyPrize) {
		List<Person> currentLuckyPerson = new ArrayList<>();
		for (int i = 0; i < luckyNum; i++) {
			Person showMember = getLuckyPerson(allPersons);
			showMember.setLevel(luckyPrize);
			currentLuckyPerson.add(showMember);
		}
		return currentLuckyPerson;
	}

	private Person getLuckyPerson(List<Person> personPools) {
		int size = personPools.size();
		Person showMember = personPools.get(getRandomMember(size));
		while (showMember.getLucky()) {
			showMember = personPools.get(getRandomMember(size));
		}
		showMember.setLucky(true);
		return showMember;
	}

	private int getRandomMember(int num) {
		Random ran = new Random(System.currentTimeMillis());
		return ran.nextInt(num);
	}

}
