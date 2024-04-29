package co.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//   data access object
public class EmpDAO {
   Connection conn;
   PreparedStatement psmt;
   ResultSet rs;

   //DB 접속 후 Connection.
   private void getConn() {
      String url = "jdbc:oracle:thin:@192.168.0.14:1521:xe";      
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         conn = DriverManager.getConnection(url, "jsp", "jsp");
      
      } catch (Exception e) {
         e.printStackTrace();
         return;
      }
      
   } // end of getConn()
   
   
   
   
  
   //사원목록 기능.
   void empList() {
      getConn();
      String sql = "select * from emp order by emp_no";
      try {
         psmt = conn.prepareStatement(sql);
         rs = psmt.executeQuery();
         System.out.println("사원번호  사원명    연락처    급여");
         System.out.println("-------------------------------------");
         
         while(rs.next()) {
         System.out.println(rs.getInt("emp_no") + " " + rs.getString("emp_name") 
          + rs.getString("emp_phone") + " " + rs.getString("salary"));
         }
            
      } catch (SQLException e) {
         e.printStackTrace();
      }
      
   }

       
   
   
   //사원등록 기능.
   boolean insertEmp(Employee emp) {
	   getConn();
	  String sql =  "insert into emp(emp_number,emp_name,emp_phone,emp_email,salary,hire_date)"
	   + "values(emp_seq.nextval,?,?,?,?,?)";
	  try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, emp.getEmpName());
			psmt.setString(2, emp.getPhone());
			psmt.setString(3, emp.getEmail());
			psmt.setInt(4, emp.getSalary());
			psmt.setString(5, emp.getHireDate());
			
			
		int r =	psmt.executeUpdate(); //처리된 건수 반환
		if(r> 0) {
			return true;
		}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
   
 //수정기능
boolean updateEmp(Employee emp) {
	getConn();
	String sql = "update emp ";
	sql += "set salary = ? ";
	sql += ",emp_email = "+ "?";
	sql += " where emp_number = ?";
	
	try {
		psmt = conn.prepareStatement(sql);
		psmt.setInt(1,  emp.getSalary());
		psmt.setString(2, emp.getEmail());
		psmt.setInt(3, emp.getEmpNo());
		
		int r = psmt.executeUpdate();
		if(r >  0) {
			return true;
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return false;}

//삭제기능
boolean deleteEmp(int eno) {
	//boolean deleteEmp(int empNumber) {
	    getConn();
	    String sql = "DELETE FROM emp WHERE emp_number = ?";
	    try {
	        psmt = conn.prepareStatement(sql);
	        psmt.setInt(1, eno);

	        int rowsDeleted = psmt.executeUpdate();
	        if (rowsDeleted > 0) {
	            System.out.println("직원 정보가 성공적으로 삭제되었습니다.");
	            return true;
	        } else {
	            System.out.println("삭제할 직원 정보가 없습니다.");
	            return false;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    		}
			}		


   	}

   
   























