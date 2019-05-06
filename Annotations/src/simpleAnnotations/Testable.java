package simpleAnnotations;

public class Testable {
	public void execute() {
		System.out.println("Execute..");
	}
	//@Test:标记注解
	@Test 
	public void testExecute() {
		execute();
	}
	@UseCase(id = 1,description = "测试自定义注解")
	public void testExecute2() {
		execute();
	}
	public static void main(String[] args) {
		Testable t = new Testable();
		t.testExecute();
		t.testExecute2();
	}
}
