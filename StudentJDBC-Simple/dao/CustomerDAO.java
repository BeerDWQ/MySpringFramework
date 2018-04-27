package cn.hl.dao;
/*
 * 操作Customer的方法接口
 */
import cn.hl.modle.Customer;

public interface CustomerDAO {
	public void insert(Customer customer);
	public Customer findByCustomerId(int custId);
}
