package test2;

public class Manager extends Employee{
	private String vehicle;

	public Manager(){
	super();
	}
	public void play(){
	System.out.println("����Manager���play()������������Employee��play()������");
	System.out.println("������"+GetName()+"  ���䣺"+GetAge()+"  �Ա�"+GetSex()+"  ID:"+getID()+"  vehicle:"+getVehicle());
	}
	
	public String getVehicle(){
	return vehicle;
	}
	public void setVehicle(String vehicle){
	this.vehicle = vehicle;
	}
}
