package test2;

public class Account {
	long id;
	String password;
	String name;
	String personld;
	String email;
	double balance;
	public Account(){
		
	}
	public Account(String name,String personld,double balance){
		this.name = name;
		this.personld = personld;
		this.balance = balance;
		System.out.println("������"+name+"\n"+"���֤�ţ�"+personld+"\n"+"��"+balance);
		System.out.println();
	}
	public double deposit(double mon1){
		balance+=mon1;
	    System.out.println("��:"+mon1+"ԪǮ");
	    System.out.println("������������:"+balance+"ԪǮ");
		return 0;
	}
	public double withdraw(double mon2){
		balance-=mon2;
	    System.out.println("ȡ:"+mon2+"ԪǮ");
	    System.out.println("������������:"+balance+"ԪǮ");
		return 0;
	}
	public static void main(String[] args) {
		Account a = new Account("xzr","123456789",1000);
		a.deposit(100);
		a.withdraw(50);
	}
}
