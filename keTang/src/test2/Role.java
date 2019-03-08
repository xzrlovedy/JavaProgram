package test2;

public class Role {
	static String name;
	static int age;
	static String sex;
	
	public Role(){

	}
	public Role(String name,int age,String sex){
		this.name=name;
		this.age=age;
		this.sex=sex;
	}
	
	public void play(){
		System.out.println("这是Role类的play()方法。");
	}
	
	public String GetName(){
		return name;
	}
	public void SetName(String name){
		this.name = name;
	}
	public int GetAge(){
		return age;
	}
	public void SetAge(int age){
		this.age=age;
	}
	public String GetSex(){
		return sex;
	}
	public void SetSex(String sex){
		this.sex=sex;
	}
	
}
