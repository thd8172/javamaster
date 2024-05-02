package com.yedam.dao;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yedam.VO.EmpVo;
import com.yedam.common.DAO;

public class EmpDAO extends DAO {
	
	
	public List<Map<String , Object>> empList(){
	List<Map<String , Object>> list = new ArrayList<Map<String,Object>>();
	conn();
	
	try {
		psmt = conn.prepareStatement("select * from emp");
		rs = psmt.executeQuery ();
		while(rs.next()) {
			Map<String, Object> map = new HashMap<>();
			map.put("사원번호",rs.getString("emp_number"));
			map.put("사원명", rs.getString("emp_name"));
			map.put("연락처", rs.getString("emp_phone"));
			map.put("이메일", rs.getString("emp_email"));
		
			list.add(map);
		}
	}catch (SQLException e) {
		e.printStackTrace();
	}finally {
		disCon();
	}
	return list;
	}
	
	//목록 가져오기 List<EmpVo> selectList(); 
	public List<EmpVo> selectList() {
		conn();
		List<EmpVo> list = new ArrayList<EmpVo>();
		
		 String sql = "select * from emp";
		 try {
	         psmt = conn.prepareStatement(sql);
	         rs = psmt.executeQuery();	        	   
	         while(rs.next()) {
	        	 EmpVo evo = new EmpVo();
	        	 evo.setEmpNO(rs.getInt("emp_number"));
	        	 evo.setEmpName(rs.getString("emp_name"));
	        	 evo.setEmpPhone(rs.getString("emp_phone"));
	        	 evo.setEmpEmail(rs.getString("emp_email"));
	        	 evo.setHireDate(rs.getString("hire_date"));
	        	 evo.setSalary(rs.getInt("salary"));
	        	 list.add(evo);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return list;
	   }
	
	
	//등록 boolean insertEmp(EmpVO evo);
	public boolean  insertEmp(EmpVo evo) {
		conn();
	
		 String sql =  "insert into emp(emp_number,emp_name,emp_phone,emp_email,salary,hire_date)"
				   + "values(emp_seq.nextval,?,?,?,?,?)";
				  try {
						psmt = conn.prepareStatement(sql);
						psmt.setString(1, evo.getEmpName());
						psmt.setString(2, evo.getEmpPhone());
						psmt.setString(3, evo.getEmpEmail());
						psmt.setInt(4, evo.getSalary());
						psmt.setString(5, evo.getHireDate());
						
						
					int r =	psmt.executeUpdate(); //처리된 건수 반환
					if(r> 0) {
						return true;
					}
					} catch(SQLException e) {
						e.printStackTrace();
					}
					return false;
				}
				 
	//수정 boolean updateEmp(int empNo); 이메일 , 급여 변경
	public boolean updateEmp(EmpVo evo) {
		conn();
		String sql  = "update emp ";
		sql += "set salary = ? ";
		sql += ",emp_email = ? ";
		sql += " where emp_number = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, evo.getSalary());
			psmt.setString(2, evo.getEmpEmail());
			psmt.setInt(3, evo.getEmpNO());
			
	
			
		int r =	psmt.executeUpdate(); //처리된 건수 반환
		if(r> 0) {
			return true;
		}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
		
	
	//삭제 boolean deleteEmp(int empNo);
	public boolean deleteEmp(int empNo) {
		conn();
		String sql = "delete from emp";//
		sql += "      where emp_number=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empNo);
			int r = psmt.executeUpdate();
			if (r > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disCon();
		}
		return false;
	}
	
}
