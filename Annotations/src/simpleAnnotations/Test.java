package simpleAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Ԫע�⣺����ע��ʱʹ�õ�ע��
 * @author Administrator
 *
 */
@Target(ElementType.METHOD)		//Ӧ����METHOD��������
@Retention(RetentionPolicy.RUNTIME)		//����ʱ����RUNTIME��
public @interface Test {
	//û��Ԫ�ص�ע���Ϊ���ע��
}
