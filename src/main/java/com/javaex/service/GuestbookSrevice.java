package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Service
public class GuestbookSrevice {
	
	@Autowired
	private GuestbookDao guestDao;
	
	// 삭제
	public int exeRemove(GuestbookVo guestbookVo) {
		System.out.println("GuestbookService.exeRemove()");

		int count = guestDao.guestbookDelete(guestbookVo);
		return count;
	}
	
	//저장+1개 가져오기
	public GuestbookVo exeAddandGuest(GuestbookVo guestVo) {
		System.out.println("GuestbookService.exeAddandGuest()");
		
		//등록
		guestDao.insertSelectKey(guestVo);
		
		//no의 데이터 가져오기
		//no 값 확인
		int no=guestVo.getNo();
		
		//no 데이터 가져오기
		GuestbookVo gVo=guestDao.guestbookSelectOne(no);
		
		return gVo;
	}
	
	//리스트 가져오기
	public List<GuestbookVo> exeGuestList() {
		System.out.println("GuestbookService.exeGuestList()");
		
		List<GuestbookVo> gList=guestDao.guestSelectList();
		
		return gList;
	}

}
