package polymorphism;
/**
 * 继承和清理
 * @author XZR
 *
 */
class Characteristic{		//特征
	private String s;
	Characteristic(String s){
		this.s = s;
		System.out.println("创建Characteristic(特征)类："+s);
	}
	protected void dispose() {
		System.out.println("销毁Characteristic(特征)类"+s);
	}
}

class Description{			//描述
	private String s;
	Description(String s){
		this.s = s;
		System.out.println("创建Description(描述)类："+s);
	}
	protected void dispose() {
		System.out.println("销毁Description(描述)类"+s);
	}
}
class LivingCreature{		//生物
	private Characteristic p = new Characteristic("特征：is alive(是活着的)");
	private Description t = new Description("描述：Basic Living Creature(基础生物)");
	LivingCreature(){
		System.out.println("创建LivingCreature(生物)类");
	}
	protected void dispose() {
		System.out.println("销毁LivingCreature(生物)类");
		t.dispose();
		p.dispose();
	}
}
class Animal extends LivingCreature{	//动物继承生物
	private Characteristic p = new Characteristic("特征：has heart(拥有心脏)");
	private Description t = new Description("描述：Animal not vegetable(动物不是植物)");
	Animal(){System.out.println("创建Animal(动物)类");}
	protected void dispose() {
		System.out.println("销毁Animal(动物)类");
		t.dispose();
		p.dispose();
		super.dispose();
	}
}
class Amphibian extends Animal{		//两栖动物继承动物
	private Characteristic p = new Characteristic("特征：can live in water(能住在水里)");
	private Description t = new Description("描述：Both water and land(水和陆地都能生活)");
	Amphibian(){
		System.out.println("创建Amphibian(两栖动物)类");
	}
	protected void dispose() {
		System.out.println("销毁Amphibian(两栖动物)类");
		t.dispose();
		p.dispose();
		super.dispose();
	}
}
public class Frog extends Amphibian{	//青蛙继承两栖动物
	private Characteristic p = new Characteristic("特征：Croaks(呱呱地叫)");
	private Description t = new Description("描述：Eats Bugs(吃虫子)");
	public Frog(){
		System.out.println("创建Frog(青蛙)类");
	}
	protected void dispose() {
		System.out.println("销毁Frog(青蛙)类");
		t.dispose();
		p.dispose();
		super.dispose();
	}
	public static void main(String[] args) {
		Frog frog = new Frog();
		System.out.println("bye!(结束)");
		frog.dispose();
	}
}
