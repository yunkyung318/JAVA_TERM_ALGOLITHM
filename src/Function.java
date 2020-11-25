import java.util.Scanner;

public class Function{
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
		while (true) {
			System.out.print(" 1:10��, 2:50��, 3:100��, 4:500��, 5:1,000��");
			System.out.println(" / ���� �� -1 �Է�");
			System.out.println(" ���� ���� �ݾ� : " + money.getAccu_Money());
			System.out.println();
			choice = scanner.nextInt();

			if (money.getAccu_Money() >= MaxPrice) {
				System.out.println(" �ݾ� �ʰ�");
				System.out.println(" ���� ���� �ݾ� : " + money.getAccu_Money());
				break;
			}

			if (num == 3) {
				if (choice == 5) {
					System.out.println("����� 3000�������� ���� �����մϴ�.");
					continue;
				}
			}
			switch (choice) {
			case 1:
				if (money.getAccu_Money() + ten.getPrice() > MaxPrice) {
					System.out.println("�ִ� 5000������ ���� �����մϴ�.");
					break;
				}
				ten.setCoin(ten.getCoin() + 1);
				money.setAccu_Money(money.getAccu_Money() + ten.getPrice());
				System.out.println(ten.getCoin() + "��");
				break;

			case 2:
				if (money.getAccu_Money() + fif.getPrice() > MaxPrice) {
					System.out.println("�ִ� 5000������ ���� �����մϴ�.");
					break;
				}
				fif.setCoin(fif.getCoin() + 1);
				money.setAccu_Money(money.getAccu_Money() + fif.getPrice());
				System.out.println(fif.getCoin() + "��");
				break;

			case 3:
				if (money.getAccu_Money() + oneHund.getPrice() > MaxPrice) {
					System.out.println("�ִ� 5000������ ���� �����մϴ�.");
					break;
				}
				oneHund.setCoin(oneHund.getCoin() + 1);
				money.setAccu_Money(money.getAccu_Money() + oneHund.getPrice());
				System.out.println(oneHund.getCoin() + "��");
				break;

			case 4:
				if (money.getAccu_Money() + fiveHund.getPrice() > MaxPrice) {
					System.out.println("�ִ� 5000������ ���� �����մϴ�.");
					break;
				}
				fiveHund.setCoin(fiveHund.getCoin() + 1);
				money.setAccu_Money(money.getAccu_Money() + fiveHund.getPrice());
				System.out.println(fiveHund.getCoin() + "��");
				break;

			case 5:
				if (money.getAccu_Money() + oneThous.getPrice() > MaxPrice) {
					System.out.println("�ִ� 5000������ ���� �����մϴ�.");
					break;
				}
				oneThous.setCoin(oneThous.getCoin() + 1);
				money.setAccu_Money(money.getAccu_Money() + oneThous.getPrice());
				num++;
				System.out.println(oneThous.getCoin() + "��");
				break;

			case -1:
				System.out.println(" ���� ���� �ݾ� : " + money.getAccu_Money());
				return;
			}
		}
	}
	public void return_Coin() {
		if (money.getAccu_Money() == 0)
			System.out.println("��ȯ �ݾ��� �����ϴ�.");
		else {
			if (num > 0 && (money.getAccu_Money() >= oneThous.getPrice())) {
				while (true) {
					System.out.println("ȭ�� ��ȯ�� ���Ͻø� 0�� �Է����ּ���.");
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
					System.out.print("1000��:"+count+" ");
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
					"500��:" + RfifHund + "��, 100��:" + RoneHund + "��, 50��:" + Rfif + "��, 10��:" + Rten + "�� ��ȯ �Ϸ�");
		}
		System.out.println("�� " + money.getAccu_Money() + "�� ��ȯ �Ϸ�");
	}
	public void manage_Stock() {
		
	}
	public void print_menu() {
		
	}
	public void choice_memu() {
		while (true) {
			System.out.print("���ϴ� ���Ḧ �������ּ���. ");
			System.out.println("1.��:450��, 2.Ŀ��:500��, 3.�̿�����:550��, 4.���Ŀ��:700��, 5.ź������:750��");

			if (money.getAccu_Money() == 0) {
				System.out.println("�ܵ��� �����ϴ�.");
			}

			int drink = scanner.nextInt();

			switch (drink) {
			case 1:
				if (water.getDrink() == 0) {
					System.out.println("�� ǰ��.");
					break;
				}
				if (money.getAccu_Money() < water.getPrice()) {
					System.out.println("�ܵ��� �����մϴ�.");
					break;
				}
				money.setAccu_Money(money.getAccu_Money() - water.getPrice());
				water.setDrink(water.getDrink() - 1);
				System.out.println("���� ���Խ��ϴ�.");
				break;

			case 2:
				if (coffe.getDrink() == 0) {
					System.out.println("Ŀ�� ǰ��.");
					break;
				}
				if (money.getAccu_Money() < coffe.getPrice()) {
					System.out.println("�ܵ��� �����մϴ�.");
					break;
				}
				money.setAccu_Money(money.getAccu_Money() - coffe.getPrice());
				coffe.setDrink(coffe.getDrink() - 1);
				System.out.println("Ŀ�ǰ� ���Խ��ϴ�.");
				break;

			case 3:
				if (ionic.getDrink() == 0) {
					System.out.println("�̿� ���� ǰ��.");
					break;
				}
				if (money.getAccu_Money() < ionic.getPrice()) {
					System.out.println("�ܵ��� �����մϴ�.");
					break;
				}
				money.setAccu_Money(money.getAccu_Money() - ionic.getPrice());
				ionic.setDrink(ionic.getDrink() - 1);
				System.out.println("�̿� ���ᰡ ���Խ��ϴ�.");
				break;

			case 4:
				if (highcoffe.getDrink() == 0) {
					System.out.println("��� Ŀ�� ǰ��.");
					break;
				}
				if (money.getAccu_Money() < highcoffe.getPrice()) {
					System.out.println("�ܵ��� �����մϴ�.");
					break;
				}
				money.setAccu_Money(money.getAccu_Money() - highcoffe.getPrice());
				highcoffe.setDrink(highcoffe.getDrink() - 1);
				System.out.println("��� Ŀ��  ���Խ��ϴ�.");
				break;

			case 5:

				if (soda.getDrink() == 0) {
					System.out.println("ź�� ���� ǰ��.");
					break;
				}
				if (money.getAccu_Money() < soda.getPrice()) {
					System.out.println("�ܵ��� �����մϴ�.");
					break;
				}
				money.setAccu_Money(money.getAccu_Money() - soda.getPrice());
				soda.setDrink(soda.getDrink() - 1);
				System.out.println("ź�� ���ᰡ ���Խ��ϴ�.");
				break;
			case -1:
				return;
			}
			System.out.println("�ܵ� : " + money.getAccu_Money() + "��");
		}
	}
}
