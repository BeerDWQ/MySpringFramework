package cn.hl.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.hl.dao.CustomerDAO;
import cn.hl.modle.Customer;

public class App {
	public static void main(String[] args) {
		//加载配置文件
		ApplicationContext context=new ClassPathXmlApplicationContext("Spring-Module.xml");
		//利用Spring注入对象，实现实例化接口(面向接口编程，编写同一接口不同的具体实现类)
		CustomerDAO customerDAO=(CustomerDAO)context.getBean("customerDAO");
		Customer customer=new Customer(1,"Beer",24);
		customerDAO.insert(customer);
		Customer customer1=customerDAO.findByCustomerId(1);
		customer1.display();
	}
}
