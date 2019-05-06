package annotationsTracker;
/**
 * 简单Bean的定义
 * @author Administrator
 *
 */
@DBTable(name = "MEMBER")
public class Member {
	//注解元素
	@SQLString(30)
	String firstName;
	@SQLString(50)
	String lastName;
	@SQLInteger
	Integer age;
	@SQLString(value = 30, constraints = @Constraints(primaryKey = true))
	String handle;
	static int memberCount;

	public String getHandle() {
		return handle;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String toString() {
		return handle;
	}

	public Integer getAge() {
		return age;
	}
}
