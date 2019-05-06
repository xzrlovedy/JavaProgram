package simpleAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
	/*
	 * 定义注解的属性，注意，有点像普通类的方法定义，但是不一样
	 * 以下表示此注解的两个属性：id和description
	 */
	public int id();
	public String description() default "no description";
}
