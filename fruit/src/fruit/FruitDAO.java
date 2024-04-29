package fruit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FruitDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	private void getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "jsp", "jsp");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

//목록출력
	List<Fruit> fruitList() {
		getConn();
		List<Fruit> list = new ArrayList<>();
<<<<<<< HEAD
		String sql = "select * from fruit order by Fruit_number";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				Fruit fr = new Fruit();
				fr.setFruitName(rs.getString("Fruit_Name"));
				fr.setFruitNumber(rs.getInt("Fruit_number"));
				fr.setFruitPrice(rs.getInt("Fruit_price"));
				fr.setFruitSurplus(rs.getInt("fruit_surplus"));
				list.add(fr);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	};

	// 등록 기능
	boolean insertfruit(Fruit fruit) {
		getConn();
		String sql = "insert into fruit(fruit_number,fruit_name,fruit_price,fruit_surplus)"
				+ "values(fruit_seq.nextval,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, fruit.getFruitName());
			psmt.setInt(2, fruit.getFruitPrice());
			psmt.setInt(3, fruit.getFruitSurplus());

			int r = psmt.executeUpdate(); // 처리된 건수 반환
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	// 탈퇴 기능
	boolean deleteCustomer(String custid) {
	    try {
	        getConn();
	        String sql = "DELETE FROM customer WHERE cust_id = ?";
	        psmt = conn.prepareStatement(sql);
	        psmt.setString(1, custid);

	        int rowsDeleted = psmt.executeUpdate();
	        if (rowsDeleted > 0) {
	            System.out.println("아이디가 탈퇴되었습니다.");
	            return true;
	        } else {
	            System.out.println("탈퇴할 아이디가 없습니다.");
	            return false;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    } finally {
	        try {
	            if (psmt != null) psmt.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	//수정기능
	boolean updatefruit(Fruit fruit) {
		getConn();
		String sql = "update fruit_ ";
		sql += "set fruit = ? ";
		sql += ",fruit_price = ?";
		sql +=  " where  fruit_number = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, fruit.getFruitName());
			psmt.setInt(2, fruit.getFruitPrice());
			psmt.setInt(3, fruit.getFruitSurplus());

			int r = psmt.executeUpdate(); // 처리된 건수 반환
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//사원삭제기능
	boolean deletefruit(int fruit) {
		 getConn();
		    String sql = "DELETE FROM fruit WHERE fruit_number = ?";
		    try {
		        psmt = conn.prepareStatement(sql);
		        psmt.setInt(1, fruit);

		        int deletefruit = psmt.executeUpdate();
		        if (deletefruit > 0) {
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
	//회원가입 기능
	boolean insertCustomer(Customer customer) {
		getConn();
		String sql = "insert into customer(cust_id,cust_pw,cust_name)"
				+ "values(?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, customer.getCustid());
			psmt.setString(2, customer.getCustpw());
			psmt.setString(3, customer.getCustName());

			int r = psmt.executeUpdate(); // 처리된 건수 반환
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
		
		}
	//로그인 기능
	 boolean loginCustomer(Customer customer) {
	    getConn();
	    String sql = "SELECT * FROM customer WHERE cust_id = ? AND cust_pw = ?";
	    try {
	        psmt = conn.prepareStatement(sql);
	        psmt.setString(1, customer.getCustid());
	        psmt.setString(2, customer.getCustpw());
	    

	        ResultSet rs = psmt.executeQuery(); // 쿼리 실행하여 결과셋 받기
	        if (rs.next()) {
	            // 사용자가 인증되면 (해당 ID와 비밀번호를 가진 행이 존재하면) true를 반환
	            return true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (psmt != null) psmt.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return false;
	}	
	 //상품구매 기능 
	  //상품 구매 메서드
	 boolean purchaseinfo(PurchaseInfo pur) {
		    try {
		        getConn();
		        // 상품 구매 쿼리 작성
		        String sql = "INSERT INTO PurchaseInfo(pur_no, cust_id, fruit_number) VALUES (?, ?, ?)";
		        psmt = conn.prepareStatement(sql);
		        psmt.setInt(1, pur.getPurNo());
		        psmt.setString(2, pur.getCustId());
		        psmt.setInt(3, pur.getFruitNumber());     
		        // 쿼리 실행
		        int purchaseinfo = psmt.executeUpdate();
		        // 삽입된 행이 있으면 성공
		        return purchaseinfo > 0;
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return false;
		    }
		}
	 String getFruitInfo(int fruitNumber) {
		    try {
		        getConn();

		        // 과일 정보 가져오는 쿼리 작성
		        String sql = "SELECT fruit_name, fruit_price FROM fruit WHERE fruit_number = ?";
		        psmt = conn.prepareStatement(sql);
		        psmt.setInt(1, fruitNumber);
		        ResultSet rs = psmt.executeQuery();
		  
		        if (rs.next()) {
		            String fruitName = rs.getString("fruit_name");
		            double fruitPrice = rs.getDouble("fruit_price");
		            return "과일 이름: " + fruitName + ", 가격: " + fruitPrice;
		        } else {
		            return null; // 상품 번호에 해당하는 상품이 없을 경우
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return null;
		    }
		}
	 
	 public boolean purschaseinfo(PurchaseInfo pur) {
		    try {
		        getConn();
		        // 상품 구매 쿼리 작성
		        String sql = "INSERT INTO PurchaseInfo(pur_no, cust_id, fruit_number) VALUES (?, ?, ?)";
		        psmt = conn.prepareStatement(sql);
		        psmt.setInt(1, pur.getPurNo());
		        psmt.setString(2, pur.getCustId()); // 수정된 부분
		        psmt.setInt(3, pur.getFruitNumber());     
		        // 쿼리 실행
		        int purchaseinfo = psmt.executeUpdate();
		        // 삽입된 행이 있으면 성공
		        return purchaseinfo > 0;
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return false;
		    }
		}

		String getFruitInfo(int fruitNumber, int quantity) {
		    try {
		        getConn();

		        // 과일 정보 가져오는 쿼리 작성
		        String sql = "SELECT fruit_name, fruit_price FROM fruit WHERE fruit_number = ?";
		        psmt = conn.prepareStatement(sql);
		        psmt.setInt(1, fruitNumber);
		        ResultSet rs = psmt.executeQuery();
		  
		        if (rs.next()) {
		            String fruitName = rs.getString("fruit_name");
		            double fruitPrice = rs.getDouble("fruit_price");
		            double totalPrice = fruitPrice * quantity;
		            return "과일 이름: " + fruitName + ", 가격: " + fruitPrice + "원, 총 가격: " + totalPrice + "원";
		        } else {
		            return null; // 상품 번호에 해당하는 상품이 없을 경우
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return null;
		    }
		}


}
=======
		String sql = "select * from fruit";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				Fruit fr = new Fruit();
				fr.setFruitName(rs.getString("Fruit_Name"));
				fr.setFruitNumber(rs.getInt("Fruit_number"));
				fr.setFruitPrice(rs.getInt("Fruit_price"));
				fr.setFruitSurplus(rs.getInt("fruit_surplus"));
				list.add(fr);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	};

	// 사원등록 기능
	boolean insertfruit(Fruit fruit) {
		getConn();
		String sql = "insert into fruit(fruit_number,fruit_name,fruit_price,fruit_surplus)"
				+ "values(fruit_seq.nextval,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, fruit.getFruitName());
			psmt.setInt(2, fruit.getFruitPrice());
			psmt.setInt(3, fruit.getFruitSurplus());

			int r = psmt.executeUpdate(); // 처리된 건수 반환
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//update 기능
	boolean updatefruit(Fruit fruit) {
		getConn();
		String sql = "update fruit_ ";
		sql += "set fruit = ? ";
		sql += ",fruit_price = ?";
		sql +=  " where  fruit_number = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, fruit.getFruitName());
			psmt.setInt(2, fruit.getFruitPrice());
			psmt.setInt(3, fruit.getFruitSurplus());

			int r = psmt.executeUpdate(); // 처리된 건수 반환
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}

>>>>>>> branch 'master' of https://github.com/thd8172/javamaster.git

