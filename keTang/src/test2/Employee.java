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
	 System.out.println("����Employee���play()������������Role��play()������");
	 System.out.println("������"+GetName()+"  ���䣺"+GetAge()+"  �Ա�"+GetSex()+"  ID:"+getID());
	 }

	 public final void sing(){
	 System.out.println("����Employee���sing()������");
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
