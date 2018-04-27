package cn.hl.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.hl.ioutput.OutputHelper;

public class App {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
		HelloSpring obj=(HelloSpring)context.getBean("helloBean");
		obj.printHello();
	}
}
