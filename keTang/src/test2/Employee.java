package test2;

public class Employee extends Role{
	 private String salary;
	 private String ID;
	 
	 public Employee(){
	 super();
	 }

	 public Employee(String salary,String ID){
	 super();
	 this.salary = salary;
	 this.ID = ID;
	 }

	 public void play(){
	 System.out.println("这是Employee类的play()方法，覆盖了Role类play()方法。");
	 System.out.println("姓名："+GetName()+"  年龄："+GetAge()+"  性别："+GetSex()+"  ID:"+getID());
	 }

	 public final void sing(){
	 System.out.println("这是Employee类的sing()方法。");
	 }
	 public String getSalary(){
	 return salary;
	 }
	 public void setSalary(String salary){
	 this.salary = salary;
	 }
	 public String getID(){
	 return ID;
	 }
	 public void setID(String ID){
	 this.ID = ID;
	 }  
}
