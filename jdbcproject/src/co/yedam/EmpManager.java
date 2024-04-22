package co.yedam;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class EmpManager {

   public static void main(String[] args) {
      //Scanner
      Scanner sc = new Scanner(System.in);
      
      boolean run = true;
      EmpDAO dao = new EmpDAO();
      
      while(run) {
         System.out.println("1.사원목록 2.사원등록 3.정보수정 4.사원삭제 5.종료");
         System.out.print("선택 > ");
         int menu = Integer.parseInt(sc.nextLine());
         
         switch(menu) {
         case 1:
            dao.empList();
            break;
         case 2:
        	 System.out.println("사원명>>");
        	 String name = sc.nextLine();
        	 System.out.println("연락처>>");
        	 String phone = sc.nextLine();
        	 System.out.println("이메일>>");
        	 String email = sc.nextLine();
        	 System.out.println("급여>>");
        	 String salary = sc.nextLine();
        	 System.out.println("입사일자>>");
        	 String hdate = sc.nextLine();
//        	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        	 
        	 Employee emp = new Employee();
        	 emp.setEmpName(name);
        	 emp.setPhone(phone);
        	 emp.setEmail(email);
        	 emp.setSalary(Integer.parseInt(salary));
        	 emp.setHireDate(hdate);
        	 
        	 if(dao.insertEmp(emp)) {
        		 System.out.println("정상등록");
        	 }else {
        		 System.out.println("예외발생.");
        	 };
            break;
         case 3:
        	 System.out.println("사원번호>>");
        	 String eno = sc.nextLine();
        	 System.out.println("이메일>>");
        	  email = sc.nextLine();
        	 System.out.println("급여>>");
        	  salary = sc.nextLine();
        	  
        	  emp = new Employee();
        	  emp.setEmpNo(Integer.parseInt(eno));
        	  emp.setEmail(email);
        	  emp.setSalary(Integer.parseInt(salary));
        	  
        	  if(dao.updateEmp(emp)) {
        		  System.out.println("수정 완료");
        	  }else {
        		  System.out.println("수정 실패");
        	  }
            break;
         case 4:
            System.out.println("삭제할 사원번호 >>");
            eno = sc.nextLine();
            
            if(dao.deleteEmp(Integer.parseInt(eno))) {
      		  System.out.println("수정 완료");
      	  }else {
      		  System.out.println("수정 실패");
      	  }
            break;
         case 5:
            System.out.println("종료");
            run = false;
            break;
         }
      
      }
      

      System.out.println("end of prog.");
   }

}









