package test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;


public class ApplicationTest {
	
	
	@Before
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		
		final String dbDriver="com.mysql.cj.jdbc.Driver";
		final String dbUrl="jdbc:mysql://localhost:3306/sistemi";
		final String dbUser="root";
		final String dbPass="";
		
		Class.forName(dbDriver);
		
		return DriverManager.getConnection(dbUrl,dbUser,dbPass);
		
	}
	
	/*
	@Test
	public void addCompany() throws ClassNotFoundException, SQLException {
		
		String sqlInsert = "insert into company(vat_number,business_name,address_location,employees_number) values(?,?,?,?)";
		PreparedStatement ps = getConnection().prepareStatement(sqlInsert);
		ps.setString(1, "10278890022");
		ps.setString(2, "countryZ");
		ps.setString(3, "addressZ");
		ps.setInt(4, 32);
		
		int nRows = ps.executeUpdate();
		
		assertEquals(nRows,1);
		
		
	}
	
	@Test
	public void updateCompany() throws ClassNotFoundException, SQLException {
		
		String sqlUpdate = "update company set employees_number=? where vat_number=?";
		PreparedStatement ps = getConnection().prepareStatement(sqlUpdate);
		ps.setInt(1, 45);
		ps.setString(2, "10283771004");
		
		int nRows = ps.executeUpdate();
		
		assertEquals(nRows,1);
		
		
	}
	
	*/
	
	/*
	@Test
	public void removeCompany() throws ClassNotFoundException, SQLException {
		
		String sqlDelete = "delete from company where vat_number=?";
		PreparedStatement ps = getConnection().prepareStatement(sqlDelete);
		ps.setString(1, "10283771002");
		
		int nRows = ps.executeUpdate();
		
		assertEquals(nRows,1);
		
		
	}
	*/
	
	
	@Test
	public void findCountCompanyByEmployeesNumber() throws ClassNotFoundException, SQLException {
		
		int cont = 0;
		 
		String sqlSelect = "select count(*) from company where employees_number >58";
		Statement st = getConnection().createStatement();
		ResultSet rs = st.executeQuery(sqlSelect);
		
		
		while (rs.next()) {
			
			cont = rs.getInt(1);
			
			
		}
		
		
		assertEquals(cont,1);
		
		
	}
	
	
	

}
