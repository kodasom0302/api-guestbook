package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.GuestbookSrevice;
import com.javaex.vo.GuestbookVo;

//@Controller
@RestController
public class GuestbookController {
	
	@Autowired
	private GuestbookSrevice guestService;
	
	//삭제
	//@ResponseBody
	@DeleteMapping(value="/api/guests/{no}")
	public String remove(@RequestBody GuestbookVo guestVo,
						 @PathVariable(value="no") int no) {
		System.out.println("GuestbookController.remove()");
		
		guestVo.setNo(no);
		System.out.println(guestVo);
		
		int count=guestService.exeRemove(guestVo);
		
		String result="{\"count\":"+count+"}";
		System.out.println(result);
		
		return result;
	}
	
	//저장
	//@ResponseBody
	@PostMapping(value="/api/guests")
	public GuestbookVo add(@RequestBody GuestbookVo guestbookVo) {
		System.out.println("GuestbookController.add()");
		
		GuestbookVo guestVo=guestService.exeAddandGuest(guestbookVo);
		System.out.println(guestVo);
		
		return guestVo;
	}
	
	//리스트
	//@ResponseBody
	@GetMapping(value="/api/guests")
	public List<GuestbookVo> list() {
		System.out.println("GuestbookController.list()");
		
		List<GuestbookVo> gList=guestService.exeGuestList();
		
		return gList;
	}

}
