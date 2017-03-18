package testsqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * jdbc连接sqlite数据
 * @author Administrator
 *
 */
public class JavaSqliteConnection {
	public static void main(String[] args) {
		Connection con = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			//数据库地址,注意jdbc:sqlite:后面的所有字母必须小写，否则会抛异常，如果数据库不存在，会自动创建
			String url="jdbc:sqlite://e:/My software/salite/database/tim.db";
			//加载驱动
			Class.forName("org.sqlite.JDBC");
			//创建连接
			con = DriverManager.getConnection(url);
			//创建执行sql语句的对象
			stat = con.createStatement();
			//执行sql语句
			stat.executeUpdate("drop table if exists table1");
			stat.executeUpdate("create table if not exists table1(id varchar,name varchar)");//创建表
			stat.executeUpdate("insert into table1 values('0001','张三')");//插入表
			rs = stat.executeQuery("select * from table1");//查表，返回一个结果集
			while(rs.next()) {//遍历结果集
				System.out.println(rs.getString("id"));
				System.out.println(rs.getString("name"));
			}
		}catch(SQLException e) {
			System.out.println("数据库连接失败");
			
		}catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
		}
		finally {
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(stat != null)
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
