import java.util.*;

public class Main implements Function {
	Scanner scanner = new Scanner(System.in);

	final int MaxPrice = 5000;
	int num = 0;
	Ten ten = new Ten();
	Fifty fif = new Fifty();
	OneHundred oneHund = new OneHundred();
	FiveHundred fiveHund = new FiveHundred();
	OneThousand oneThous = new OneThousand();

	Water water = new Water();
	Coffe coffe = new Coffe();
	Ionic ionic = new Ionic();
	HighCoffe highcoffe = new HighCoffe();
	Soda soda = new Soda();

	AccumulationMoney money = new AccumulationMoney();

	public void insert_Coin() {
		int choice;

		System.out.println(" 돈을 넣어주세요.(지폐는 3000원까지, 총 금액 5000원 이하만 가능)");
		while (true) {
			System.out.print(" 1:10원, 2:50원, 3:100원, 4:500원, 5:1,000원");
			System.out.println(" / 종료 시 -1 입력");
			System.out.println(" 누적 투입 금액 : " + money.getAccu_Money());
			System.out.println();
			choice = scanner.nextInt();

			if (money.getAccu_Money() >= MaxPrice) {
				System.out.println(" 금액 초과");
				System.out.println(" 누적 투입 금액 : " + money.getAccu_Money());
				break;
			}

			if (num == 3) {
				if (choice == 5) {
					System.out.println("지폐는 3000원까지만 투입 가능합니다.");
					continue;
				}
			}
			switch (choice) {
			case 1:
				if (money.getAccu_Money() + ten.getPrice() > MaxPrice) {
					System.out.println("최대 5000원까지 투입 가능합니다.");
					break;
				}
				ten.setCoin(ten.getCoin() + 1);
				money.setAccu_Money(money.getAccu_Money() + ten.getPrice());
				System.out.println(ten.getCoin() + "개");
				break;

			case 2:
				if (money.getAccu_Money() + fif.getPrice() > MaxPrice) {
					System.out.println("최대 5000원까지 투입 가능합니다.");
					break;
				}
				fif.setCoin(fif.getCoin() + 1);
				money.setAccu_Money(money.getAccu_Money() + fif.getPrice());
				System.out.println(fif.getCoin() + "개");
				break;

			case 3:
				if (money.getAccu_Money() + oneHund.getPrice() > MaxPrice) {
					System.out.println("최대 5000원까지 투입 가능합니다.");
					break;
				}
				oneHund.setCoin(oneHund.getCoin() + 1);
				money.setAccu_Money(money.getAccu_Money() + oneHund.getPrice());
				System.out.println(oneHund.getCoin() + "개");
				break;

			case 4:
				if (money.getAccu_Money() + fiveHund.getPrice() > MaxPrice) {
					System.out.println("최대 5000원까지 투입 가능합니다.");
					break;
				}
				fiveHund.setCoin(fiveHund.getCoin() + 1);
				money.setAccu_Money(money.getAccu_Money() + fiveHund.getPrice());
				System.out.println(fiveHund.getCoin() + "개");
				break;

			case 5:
				if (money.getAccu_Money() + oneThous.getPrice() > MaxPrice) {
					System.out.println("최대 5000원까지 투입 가능합니다.");
					break;
				}
				oneThous.setCoin(oneThous.getCoin() + 1);
				money.setAccu_Money(money.getAccu_Money() + oneThous.getPrice());
				num++;
				System.out.println(oneThous.getCoin() + "개");
				break;

			case -1:
				System.out.println(" 누적 투입 금액 : " + money.getAccu_Money());
				return;
			}
		}
	}

	public void return_Coin() {
		if (money.getAccu_Money() == 0)
			System.out.println("반환 금액이 없습니다.");
		else {
			if (num > 0 && (money.getAccu_Money() >= oneThous.getPrice())) {
				while (true) {
					System.out.println("화폐 반환을 원하시면 0을 입력해주세요.");
					int yes = scanner.nextInt();
					int count=0;
					if (yes == 0) {
						for(int i=0;i<num;i++) {
							if(num>0&&money.getAccu_Money()>=oneThous.getPrice()) {
								oneThous.setCoin(oneThous.getCoin() - 1);
								money.setAccu_Money(money.getAccu_Money() - oneThous.getPrice());
								num -= 1;
								count++;
							}
						}
					}
					System.out.print("1000원:"+count+" ");
					break;
				}
			}

			int RfifHund = money.getAccu_Money() / fiveHund.getPrice();
			fiveHund.setCoin(fiveHund.getCoin() - RfifHund);
			money.setAccu_Money(money.getAccu_Money() - (fiveHund.getPrice() * RfifHund));

			int RoneHund = money.getAccu_Money() / oneHund.getPrice();
			oneHund.setCoin(oneHund.getCoin() - RoneHund);
			money.setAccu_Money(money.getAccu_Money() - (oneHund.getPrice() * RoneHund));

			int Rfif = money.getAccu_Money() / fif.getPrice();
			fif.setCoin(fif.getCoin() - Rfif);
			money.setAccu_Money(money.getAccu_Money() - (fif.getPrice() * Rfif));

			int Rten = money.getAccu_Money() / ten.getPrice();
			ten.setCoin(ten.getCoin() - Rten);
			money.setAccu_Money(money.getAccu_Money() - (ten.getPrice() * Rten));

			System.out.println(
					"500원:" + RfifHund + "개, 100원:" + RoneHund + "개, 50원:" + Rfif + "개, 10원:" + Rten + "개 반환 완료");
		}
		System.out.println("총 " + money.getAccu_Money() + "원 반환 완료");

	}

	public void insert_menu() {
		// GUI 구현
	}

	public void delete_menu() {

	}

	public void manage_Stock() {

	}

	public void print_menu() {

	}

	public void choice_memu() {
		while (true) {
			System.out.print("원하는 음료를 선택해주세요. ");
			System.out.println("1.물:450원, 2.커피:500원, 3.이온음료:550원, 4.고급커피:700원, 5.탄산음료:750원");

			if (money.getAccu_Money() == 0) {
				System.out.println("잔돈이 없습니다.");
			}

			int drink = scanner.nextInt();

			switch (drink) {
			case 1:
				if (water.getDrink() == 0) {
					System.out.println("물 품절.");
					break;
				}
				if (money.getAccu_Money() < water.getPrice()) {
					System.out.println("잔돈이 부족합니다.");
					break;
				}
				money.setAccu_Money(money.getAccu_Money() - water.getPrice());
				water.setDrink(water.getDrink() - 1);
				System.out.println("물이 나왔습니다.");
				break;

			case 2:
				if (coffe.getDrink() == 0) {
					System.out.println("커피 품절.");
					break;
				}
				if (money.getAccu_Money() < coffe.getPrice()) {
					System.out.println("잔돈이 부족합니다.");
					break;
				}
				money.setAccu_Money(money.getAccu_Money() - coffe.getPrice());
				coffe.setDrink(coffe.getDrink() - 1);
				System.out.println("커피가 나왔습니다.");
				break;

			case 3:
				if (ionic.getDrink() == 0) {
					System.out.println("이온 음료 품절.");
					break;
				}
				if (money.getAccu_Money() < ionic.getPrice()) {
					System.out.println("잔돈이 부족합니다.");
					break;
				}
				money.setAccu_Money(money.getAccu_Money() - ionic.getPrice());
				ionic.setDrink(ionic.getDrink() - 1);
				System.out.println("이온 음료가 나왔습니다.");
				break;

			case 4:
				if (highcoffe.getDrink() == 0) {
					System.out.println("고급 커피 품절.");
					break;
				}
				if (money.getAccu_Money() < highcoffe.getPrice()) {
					System.out.println("잔돈이 부족합니다.");
					break;
				}
				money.setAccu_Money(money.getAccu_Money() - highcoffe.getPrice());
				highcoffe.setDrink(highcoffe.getDrink() - 1);
				System.out.println("고급 커피  나왔습니다.");
				break;

			case 5:

				if (soda.getDrink() == 0) {
					System.out.println("탄산 음료 품절.");
					break;
				}
				if (money.getAccu_Money() < soda.getPrice()) {
					System.out.println("잔돈이 부족합니다.");
					break;
				}
				money.setAccu_Money(money.getAccu_Money() - soda.getPrice());
				soda.setDrink(soda.getDrink() - 1);
				System.out.println("탄산 음료가 나왔습니다.");
				break;
			case -1:
				return;
			}
			System.out.println("잔돈 : " + money.getAccu_Money() + "원");
		}
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.insert_Coin();
		main.choice_memu();
		main.return_Coin();

		PassWord pwd = new PassWord();
		boolean bo = pwd.PasswordRegularExpressionCheck("dbs851285!");
		System.out.println(bo);
	}
}