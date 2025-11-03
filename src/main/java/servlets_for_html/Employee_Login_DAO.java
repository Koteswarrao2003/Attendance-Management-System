package servlets_for_html;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.Connection_Class;

public class Employee_Login_DAO
{
	public boolean getData(EmployeeLoginBean slb) {
	
		try {
			Connection_Class con=new Connection_Class();
			Connection c=con.connect();
			String query="select * from employee where id=? and password=?";
			PreparedStatement st = c.prepareStatement(query);
			st.setLong(1, slb.getId());
			st.setString(2, slb.getPassword());
			
			ResultSet rs=st.executeQuery();
			
			while(rs.next()) {
				slb.setName(rs.getString("name"));
				slb.setMnumber(rs.getLong("number"));
				slb.setEmail(rs.getString("email"));
				slb.setDob(rs.getDate("dob"));
				slb.setDes(rs.getString("des"));
				slb.setAddress(rs.getString("address"));
				return true;
			}
			rs.close();
			c.close();
			st.close();
			
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		return false;
			
	}
}
