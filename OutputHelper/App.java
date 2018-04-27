package cn.hl.ioutput;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context1=new ClassPathXmlApplicationContext(new String[] {"Spring-Common.xml"}) ;
		OutputHelper output=(OutputHelper)context1.getBean("outputHelper");
		output.generateOutput();
	}
}
