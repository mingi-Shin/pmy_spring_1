package kr.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.mingicom.entity.AllMixedVO;
import kr.mingicom.entity.Member;
import kr.mingicom.mapper.MemberMapper;

@Controller
public class MainController {

	@Autowired
	private MemberMapper memMapper;
	
	@RequestMapping("/")
	public String  index() {
		
		return "index";
	}
	
	//내편의를 위해: 회원목록 조회 
	@RequestMapping("/getMemberList.do")
	public String showMemberList(AllMixedVO vo, Model model) {
		
		List<Member> memList = memMapper.getMemberList();
		System.out.println("멤버리스트: " + memList);
		
		model.addAttribute("memberList", memList);
		return "admin/showMemberList";
	}
	
	//내편의를 위해: MVC04 부가설명 
	@RequestMapping("/showDescription.do")
	public String showDescription() {
		return "admin/description";
	}
}
