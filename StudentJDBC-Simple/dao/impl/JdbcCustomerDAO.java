package cn.hl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import cn.hl.dao.CustomerDAO;
import cn.hl.modle.Customer;
/*
 * CustomerDAO的具体实现类
 * 使用JDBC发送简单的insert和select语句
 */
public class JdbcCustomerDAO implements CustomerDAO{
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	public void insert(Customer customer) {
		String sql="INSERT INTO CUSTOMER"+"(CUST_ID,NAME,AGE) VALUES (?,?,?)";
		//建立数据库连接
		Connection conn=null;
		try {
			conn =dataSource.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			//拼接sql语句
			ps.setInt(1,customer.getCustId());
			ps.setString(2, customer.getName());
			ps.setInt(3, customer.getAge());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
				
		}
	}
	public Customer findByCustomerId(int custId) {
		String sql="SELECT * FROM CUSTOMER WHERE CUST_ID=?";
		Connection conn=null;
		try {
			conn=dataSource.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,custId);
			Customer customer=null;
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				customer=new Customer(
						rs.getInt("CUST_ID"),
						rs.getString("NAME"),
						rs.getInt("AGE")
						); 
			}
			rs.close();
			ps.close();
			return customer;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}		
		}
		return null;
	}
}
