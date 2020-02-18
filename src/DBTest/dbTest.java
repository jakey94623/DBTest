package DBTest;
import java.sql.*;
import java.util.*;
public class dbTest {
	
	public static void main(String[] args) throws SQLException {
		
		//localhost指本機，也可以用本地ip地址代替，3306為MySQL資料庫的預設埠號，“user”為要連線的資料庫名
					System.out.print("嗨請選擇你要的功能\n");
					System.out.print("1查詢  2插入 3修改 4刪除  0離開");
					int input=0;	
					Scanner sc=new Scanner(System.in);
					input=sc.nextInt();
					do{
					input=sc.nextInt();
					
					
				switch(input){
					case 1: search();
					break;
					case 2: Insert();
					break;
					case 3: search();
					break;
					case 4: search();
					break;
				}
				}while(input!=0);
					
				
				
				
				
				
					}
		
	

static void search() {
	 String url = "jdbc:mysql://localhost:3306/dbtest?serverTimezone=UTC";
		String username = "root";
		String password = "";
		String sql = "select * from dbtest";//編寫要執行的sql語句，此處為從user表中查詢所有使用者的資訊 
		
	try {
		Connection con = DriverManager.getConnection(url,username,password);//建立連線物件
		Statement st = con.createStatement();//建立sql執行物件
		ResultSet rs = st.executeQuery(sql);//執行sql語句並返回結果集
		 while(rs.next()) 
	      { 
	        System.out.println(rs.getInt("number")+"\t\t"+ 
	            rs.getString("name")+"\t\t"+rs.getString("password")+"\t\t"+rs.getInt("Test")); 
	      } 
	
	} catch (SQLException e) {
		
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
	String se="select * from dbtest";
	
	
	
	
	
	 
	Connection con = DriverManager.getConnection(url,username,password);
	Statement stmt = con.createStatement();
	String sql = "INSERT INTO `dbtest`(`number`,`name`,`password`,`Test`) "
            + "VALUES ( "+"null,\""+name+"\""+","+password2+","+Test+")" ;
	System.out.print(sql);

	stmt.execute(sql);
	
}
}
