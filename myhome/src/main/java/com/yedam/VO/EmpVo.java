package com.yedam.VO;

import java.util.Date;

import lombok.Data;
//lombok : 이클립에서 설치, 라이브러리 필요.
@Data

public class EmpVo { //오라클(emp_no) => 자바 empNO
	private int empNO;
	private String empName;
	private String empPhone;
	private String empEmail;
	private String  hireDate;
	private int salary;
}
