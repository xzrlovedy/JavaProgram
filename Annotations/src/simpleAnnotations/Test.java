package simpleAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 元注解：定义注解时使用的注解
 * @author Administrator
 *
 */
@Target(ElementType.METHOD)		//应用于METHOD（方法）
@Retention(RetentionPolicy.RUNTIME)		//运行时级别（RUNTIME）
public @interface Test {
	//没有元素的注解称为标记注解
}
