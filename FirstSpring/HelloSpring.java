package cn.hl.spring;

public class HelloSpring {
	private String name;
	public void setName(String name) {
		this.name=name;
	}
	public void printHello() {
		System.out.println("Hello"+name);
	}
}
