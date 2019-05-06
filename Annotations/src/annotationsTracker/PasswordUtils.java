package annotationsTracker;

import java.util.List;

import simpleAnnotations.UseCase;

/**
 * ²âÊÔUseCase×¢½â
 * 
 * @author Administrator
 *
 */
public class PasswordUtils {
	@UseCase(id = 1, description = "Passwords must contain at least one numeric")
	public boolean validatePassword(String password) {
		return (password.matches("\\w*\\d\\w*"));
	}

	@UseCase(id = 2)
	public String encryptPassword(String password) {
		return new StringBuilder(password).reverse().toString();
	}

	@UseCase(id = 3, description = "New passwords can't equal previously used ones")
	public boolean checkForNewPassword(List<String> prevPasswords, String password) {
		return !prevPasswords.contains(password);
	}
}
