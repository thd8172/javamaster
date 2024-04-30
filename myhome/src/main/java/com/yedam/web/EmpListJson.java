package com.yedam.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.EmpDAO;

@WebServlet("/empList.json")
public class EmpListJson extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		//{"name":"홍길동","age":20};
		//String json = "{\"name\":\"박길동\",\"age\":21};";
		EmpDAO edao = new EmpDAO();
		List<Map<String,Object>> list = edao.empList();
		
		String json = "[";
		for(int i = 0; i < list.size();i++) {
			Map<String, Object> map = list.get(i);
			json += "{\"empNO\":"+map.get("사원번호") // 
			+ ",\"EmpName\" : \"" + map.get("사원명")
			+ ",\"EmpPhone\" : \"" + map.get("전화번호")
			+ ",\"EmpEmail\" : \"" + map.get("이메일")
			+ "\"}";
			if((i+1) ==list.size()) {
					json += ",";
			}
		}
		json = "]";
		resp.getWriter().print(json);		
	}
}
