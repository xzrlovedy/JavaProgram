package test2;

public class Manager extends Employee{
	private String vehicle;

	public Manager(){
	super();
	}
	public void play(){
	System.out.println("这是Manager类的play()方法，覆盖了Employee类play()方法。");
	System.out.println("姓名："+GetName()+"  年龄："+GetAge()+"  性别："+GetSex()+"  ID:"+getID()+"  vehicle:"+getVehicle());
	}
	
	public String getVehicle(){
	return vehicle;
	}
	public void setVehicle(String vehicle){
	this.vehicle = vehicle;
	}
}
