
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PassWord {
	public static final String pattern1 = "^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,20}$";
	private String password;
	Matcher match;
	Scanner sc = new Scanner(System.in);

	public boolean PasswordRegularExpressionCheck(String newPwd) {
		boolean check = false;

		match = Pattern.compile(pattern1).matcher(newPwd);
		if (match.find())
			check = true;

		return check;
	}
}

public class Manager {

	public Manager() {

	}

}
