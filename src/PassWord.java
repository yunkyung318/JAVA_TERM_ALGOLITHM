import java.util.Vector;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PassWord {// 8~20자리까지 설정 가능, 영문+숫자+특수문자 조합인지 체크 클래스
	public static final String pattern1 = "^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,20}$";// 영어,숫자,특수문자
	private String password;
	Matcher match;
	Scanner sc=new Scanner(System.in);
	
	public boolean PasswordRegularExpressionCheck(String newPwd) { // 정규식 확인
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
			System.out.println("특수 문자 및 숫자 1개 이상 포함하여 입력해주세요.");
			String rePwd=sc.next();
			SetPassWord(rePwd);
		}
	}
	public void Check(String pwd) {
		if(password.equals(pwd)==true) {
			System.out.println("관리자 메뉴 오픈");
		}
		else {
			System.out.println("비밀 번호 오류. 재입력해주세요.");
			String rePwd=sc.next();
			Check(rePwd);
		}
	}
}
