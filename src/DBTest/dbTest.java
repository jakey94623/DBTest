package DBTest;
import java.sql.*;
import java.util.*;
public class dbTest {
	public static void main(String[] args) throws SQLException {
					System.out.print("嗨請選擇你要的功能\n");
					System.out.print("1查詢  2插入 3修改 4刪除5清空  0離開");
					int input=0;	
					Scanner sc=new Scanner(System.in);
					input=sc.nextInt();
					do{
						System.out.print("嗨請選擇你要的功能\n");
						System.out.print("1查詢  2插入 3修改 4刪除5清空  0離開");
						input=sc.nextInt();	
						switch(input){
							case 1: search();
							break;
							case 2: Insert();
							break;
							case 3: Update();
							break;
							case 4: Delete();
							break;
							case 5: Drop();
							break;
									}
				   }while(input!=0);
					
					}
static void search() {
	 	String url = "jdbc:mysql://localhost:3306/dbtest?serverTimezone=UTC";
		String username = "root";
		String password = "";
		String sql = "select * from dbtest"; 
		try {
			Connection con = DriverManager.getConnection(url,username,password);//建立連線物件
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
				 while(rs.next()){ 
			        System.out.println(rs.getInt("number")+"\t\t"+ 
			        rs.getString("name")+"\t\t"+rs.getString("password")+"\t\t"+rs.getInt("Test")); 
			      }
		}catch (SQLException e) {
			e.printStackTrace();
	}
}
static void Insert() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/dbtest?serverTimezone=UTC";
		String username = "root";
		String password = "";
		Scanner sc=new Scanner(System.in);
		System.out.print("請輸入想加入資料庫的資料");
		System.out.print("name:?");
		String name=sc.next();
		System.out.print("password:?");
		String password2=sc.next();
		System.out.print("Test:?");
		String Test=sc.next();
		Connection con = DriverManager.getConnection(url,username,password);
		Statement stmt = con.createStatement();
		String sql = "INSERT INTO `dbtest`(`number`,`name`,`password`,`Test`) "+ "VALUES ( "+"null,\""+name+"\""+","+password2+","+Test+")" ;
		stmt.execute(sql);
	
}
static void Update() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/dbtest?serverTimezone=UTC";
		String username = "root";
		String password = "";
		Scanner sc=new Scanner(System.in);
		System.out.print("請輸入要修改的人名");
		String name=sc.next();
		System.out.print("請輸入要修改的密碼");
		String password2=sc.next();
		System.out.print("Test:?");
		String Test=sc.next();
		System.out.print("修改之後的人名是?");
		String name2=sc.next();
		String sql="UPDATE `dbtest` SET `password`="+password2+",`Test`="+Test+",`name`="+"\""+name2+"\""+" WHERE `name`=\""+name+"\"";			
		Connection con = DriverManager.getConnection(url,username,password);
		Statement stmt = con.createStatement(); //與資料庫互動
		stmt.execute(sql);
		
}
static void Delete() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/dbtest?serverTimezone=UTC";
		String username = "root";
		String password = "";
		Scanner sc=new Scanner(System.in);
		System.out.print("請輸入要刪除的人名");
		String name=sc.next();
		String sql="DELETE FROM `dbtest` WHERE `name`="+"\""+name+"\"";
		Connection con = DriverManager.getConnection(url,username,password);
		Statement stmt = con.createStatement();
		stmt.execute(sql);
		
}
static void Drop() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/dbtest?serverTimezone=UTC";
		String username = "root";
		String password = "";
		String sql="truncate table dbtest";
		Connection con = DriverManager.getConnection(url,username,password);
		Statement stmt = con.createStatement();
		stmt.execute(sql);
}
}
