package annotationsTracker;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import simpleAnnotations.UseCase;
/**
 * ��дע�⴦����
 * ע����û�д���������ע��ûʲô����
 * ע�⴦������������ȡע��Ĺ���
 * @author Administrator
 *
 */
public class UseCaseTracker {
	public static void trackUseCases(List<Integer> useCases,Class<?> cl) {
		for(Method m:cl.getDeclaredMethods()) {
			//���䷽��:getDeclaredMethods(),getAnnotation()
			UseCase uc = m.getAnnotation(UseCase.class);
			if(uc !=null) {
				System.out.println("Found UseCase - "+uc.id()+" "+uc.description());
				useCases.remove(new Integer(uc.id()));
			}
		}
		for(int i : useCases) {
			System.err.println("Warning:Missing UseCase - "+i);
		}
	}
	public static void main(String[] args) {
		List<Integer> useCases = new ArrayList<Integer>();
		Collections.addAll(useCases, 1,2,3,4);
		trackUseCases(useCases,PasswordUtils.class);
	}
}
/*
 * �����
 * Found UseCase - 1 Passwords must contain at least one numeric
 * Found UseCase - 2 no description
 * Found UseCase - 3 New passwords can't equal previously used ones
 * Warning:Missing UseCase - 4
 */
