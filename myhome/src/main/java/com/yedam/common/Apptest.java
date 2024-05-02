package com.yedam.common;

import java.util.List;

import com.yedam.VO.EmpVo;
import com.yedam.dao.EmpDAO;

public class Apptest {
	
	public static void main(String[] args) {
	EmpDAO edao = new EmpDAO();
	List<EmpVo> list = edao.selectList();
		for(EmpVo vo:list) {
			System.out.println(vo.toString());
		}
	EmpVo evo = new EmpVo();
	
	evo.setEmpEmail("test@gmail.com");
	evo.setEmpName("송혁");
	evo.setEmpPhone("01000000000");
	evo.setHireDate("2014-4-4");
	evo.setSalary(500);
	evo.setEmpNO(42);
	
	
	edao.selectList();
	
	//updateEmp
//    evo.setEmpEmail("sdfdf@mail");
//    evo.setSalary(80000);
//    evo.setEmpNO(3);
//    if(edao.updateEmp(evo)) {
//       System.out.println("성공");
//    }else {
//       System.out.println("처리실패");
//    }
    
    //deleteEmp
    if(edao.deleteEmp(2)) {
       System.out.println("성공");
    }else {
       System.out.println("처리실패");
    }


	}
}
