package simpleAnnotations;

public class Testable {
	public void execute() {
		System.out.println("Execute..");
	}
	//@Test:���ע��
	@Test 
	public void testExecute() {
		execute();
	}
	@UseCase(id = 1,description = "�����Զ���ע��")
	public void testExecute2() {
		execute();
	}
	public static void main(String[] args) {
		Testable t = new Testable();
		t.testExecute();
		t.testExecute2();
	}
}
