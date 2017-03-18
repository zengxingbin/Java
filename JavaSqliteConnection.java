package testsqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * jdbc����sqlite����
 * @author Administrator
 *
 */
public class JavaSqliteConnection {
	public static void main(String[] args) {
		Connection con = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			//���ݿ��ַ,ע��jdbc:sqlite:�����������ĸ����Сд����������쳣��������ݿⲻ���ڣ����Զ�����
			String url="jdbc:sqlite://e:/My software/salite/database/tim.db";
			//��������
			Class.forName("org.sqlite.JDBC");
			//��������
			con = DriverManager.getConnection(url);
			//����ִ��sql���Ķ���
			stat = con.createStatement();
			//ִ��sql���
			stat.executeUpdate("drop table if exists table1");
			stat.executeUpdate("create table if not exists table1(id varchar,name varchar)");//������
			stat.executeUpdate("insert into table1 values('0001','����')");//�����
			rs = stat.executeQuery("select * from table1");//�������һ�������
			while(rs.next()) {//���������
				System.out.println(rs.getString("id"));
				System.out.println(rs.getString("name"));
			}
		}catch(SQLException e) {
			System.out.println("���ݿ�����ʧ��");
			
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
