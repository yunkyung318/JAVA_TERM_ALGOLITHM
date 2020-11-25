import java.util.Vector;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PassWord {
	public static final String pattern1 = "^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,20}$";// ����,����,Ư������
	private String password;
	Matcher match;
	Scanner sc=new Scanner(System.in);
	
	public boolean PasswordRegularExpressionCheck(String newPwd) {
		boolean check = false;
		
		match = Pattern.compile(pattern1).matcher(newPwd);
		if (match.find())
			check = true;
		
		return check;
	}
	
	public void SetPassWord(String newPwd) {
		boolean check= PasswordRegularExpressionCheck(newPwd);
		if(check==true) {
			this.password=newPwd;
		}
		else {
			System.out.println("Ư�� ���� �� ���� 1�� �̻� �����Ͽ� �Է����ּ���.");
			String rePwd=sc.next();
			SetPassWord(rePwd);
		}
	}
	public void Check(String pwd) {
		if(password.equals(pwd)==true) {
			System.out.println("������ �޴� ����");
		}
		else {
			System.out.println("��� ��ȣ ����. ���Է����ּ���.");
			String rePwd=sc.next();
			Check(rePwd);
		}
	}
}
