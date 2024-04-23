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


