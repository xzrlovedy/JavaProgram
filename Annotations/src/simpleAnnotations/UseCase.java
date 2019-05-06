package simpleAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
	/*
	 * ����ע������ԣ�ע�⣬�е�����ͨ��ķ������壬���ǲ�һ��
	 * ���±�ʾ��ע����������ԣ�id��description
	 */
	public int id();
	public String description() default "no description";
}
