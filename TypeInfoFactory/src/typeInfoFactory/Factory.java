package typeInfoFactory;
/**
 * 使用工厂方法设计模式，将对象创建工作交给类自己完成
 * 工厂方法可以被多态调用，从而创建恰当的类型对象
 * @author Administrator
 *
 * @param <T>
 */
//工厂方法就是Factory接口的create()方法
public interface Factory<T>{
	T create();
}