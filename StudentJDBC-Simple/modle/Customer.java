package cn.hl.modle;
import java.sql.Timestamp;
public class Customer {
	 String name;
	 int age;
	 int custId;
	public Customer(int custId, String name, int age) {
		this.custId=custId;
		this.name=name;
		this.age=age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	 public void display() {
		 System.out.println("[custId:"+custId+"//name:"+name+"//age:"+age+"]");
	 }
}
