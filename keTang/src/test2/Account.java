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
		System.out.println("姓名："+name+"\n"+"身份证号："+personld+"\n"+"余额："+balance);
		System.out.println();
	}
	public double deposit(double mon1){
		balance+=mon1;
	    System.out.println("存:"+mon1+"元钱");
	    System.out.println("你的余额现在是:"+balance+"元钱");
		return 0;
	}
	public double withdraw(double mon2){
		balance-=mon2;
	    System.out.println("取:"+mon2+"元钱");
	    System.out.println("你的余额现在是:"+balance+"元钱");
		return 0;
	}
	public static void main(String[] args) {
		Account a = new Account("xzr","123456789",1000);
		a.deposit(100);
		a.withdraw(50);
	}
}
