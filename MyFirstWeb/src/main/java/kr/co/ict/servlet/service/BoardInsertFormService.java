package kr.co.ict.servlet.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BoardInsertFormService implements IBoardService {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// session생성
		HttpSession session = request.getSession();
		String sId = (String)session.getAttribute("session_id");
		System.out.println("insertForm.do : " + sId);
		
		// 글쓰기 창에 아이디를 보내서 로그인 사용자 명이 곧 아이디로 쓰이도록 처리
		request.setAttribute("sId", sId);
		
			
			}
		
	} 

