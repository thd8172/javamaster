package com.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.VO.EmpVo;
import com.yedam.dao.EmpDAO;

@WebServlet("/empJson.json")
public class EmpListJsonServ extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//사원목록 json문자열로 출력.
		//Gson 라이브러리 활용해서 json 생성.
		resp.setContentType("text/json;charset=utf-8");
		EmpDAO edao = new EmpDAO();
		List<EmpVo> elist = edao.selectList();
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(elist);
		
		System.out.println(json);
		resp.getWriter().println(json); //웹브라우저 출력.
	}
}
