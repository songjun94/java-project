package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class UserDAO {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String id;

	public UserDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/";
			String dbName = "userInfo";
			String dbID = "root";
			String dbPassword = "1234";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL + dbName, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int login(String userID, String userPassword) {
		String SQL = "SELECT userPassword FROM USER WHERE userID= ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if ((rs.getString(1)).equals(userPassword)) 
					return 1; // 로그인 성공
				 else 
					return 0; // 비밀번호 불일치
				}
			return -1; // 아이디 존재 X
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2; // 데이터베이스 오류
	}
	
	public int join(User user) {
		String SQL = "INSERT INTO USER VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserAge());
			pstmt.setString(5, user.getUserGender());
			pstmt.setString(6, user.getUserAddress());
			pstmt.setString(7, user.getUserPhone());
			
			return pstmt.executeUpdate(); // INSERT / DELETE / UPDATE 관련 구문에서 반영된 레코드의 건수를 반환
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1 ;
	}
	
	// user의 ID정보를 불러오는 메서드
	public User getUser(String userID) {
		String SQL = "SELECT * FROM USER WHERE userID='"+userID+"'";
		try {
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery(SQL);
			User user = new User();
			
			if(rs.next()) {
				user.setUserID(rs.getString("userID"));
				System.out.println(user.getUserID());
				return user;
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	
	// modify 수정 
	public int modify(User user) {
		String SQL = "UPDATE user SET userID='" + user.getUserID() 
		+ "'"+", userPassword='" + user.getUserPassword() 
		+ "'"+", userName='" + user.getUserName() 
		+ "'"+", userGender='" + user.getUserGender()
		+ "'"+", userAge="+ "'" + user.getUserAge()
		+ "'"+", userAddress="+ "'" + user.getUserAddress()
		+ "'"+", userPhone="+ "'" + user.getUserPhone()
		+ "' WHERE userID='"+ user.getUserID() +"'";
		try {
			stmt = conn.createStatement();
			System.out.println("executeupdate_before");
			return stmt.executeUpdate(SQL);
		}catch(Exception e){
			System.out.println("exeption");
			e.printStackTrace();
		}
		System.out.println("return: -1");
		return -1;
	} 
		
	}

