package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 삭제
	public int guestbookDelete(GuestbookVo guestbookVo){
		System.out.println("GuestbookDao.guestbookDelete()");
		
		int count = sqlSession.delete("guestbook.delete", guestbookVo);
		
		return count;
	}
	
	//글 저장 - SelectKey
	public int insertSelectKey(GuestbookVo guestVo) {
		System.out.println("GuestbookDao.insertSelectKey()");
		
		int count=sqlSession.insert("guestbook.insertSelectKey", guestVo);
		
		return count;
	}
	
	//글 1개 가져오기
	public GuestbookVo guestbookSelectOne(int no) {
		System.out.println("GuestbookDao.guestbookSelectOne()");
		
		GuestbookVo guestVo=sqlSession.selectOne("guestbook.selectOne", no);
		
		return guestVo;
	}
	
	//전체 리스트 가져오기
	public List<GuestbookVo> guestSelectList() {
		System.out.println("GuestbookDao.guestSelectList()");
		
		List<GuestbookVo> gList=sqlSession.selectList("guestbook.selectList");
		
		return gList;
	}

}
