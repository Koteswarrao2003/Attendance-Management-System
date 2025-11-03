package servlets_for_html;

import java.sql.Statement;


public class Employee_Table_Creation {
	
	public static void main(String[] args) {
		
		Connection_Class conn=new Connection_Class();
		try
		{
			Statement st=conn.connect().createStatement();
			String TableCreation="create table employee(id bigint primary key,name varchar(50) not null,number bigint,email varchar(50) unique,password varchar(10),dob date,des varchar(50),address varchar(50))";
			st.execute(TableCreation);
			System.out.println("Table created Successfully");
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
