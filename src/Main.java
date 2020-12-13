import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.table.*;

public class Main extends JFrame {
	private JPanel MainPanel;
	private Mypanel panel;
	private JScrollPane choicePane;
	private Manager manager = new Manager();
	private JLabel ment = new JLabel("[ 갱갱이 자판기 ]");

	private ImageIcon iwater = new ImageIcon("C:/JAVA/pic/Water.jpg");
	private ImageIcon icoffe = new ImageIcon("C:/JAVA/pic/Coffe.jpg");
	private ImageIcon iionic = new ImageIcon("C:/JAVA/pic/Ionic.jpg");
	private ImageIcon ihighcoffe = new ImageIcon("C:/JAVA/pic/HighCoffe.jpg");
	private ImageIcon isoda = new ImageIcon("C:/JAVA/pic/Soda.jpg");

	private ImageIcon iten = new ImageIcon("C:/JAVA/pic/10won.png");
	private ImageIcon ifif = new ImageIcon("C:/JAVA/pic/50won.png");
	private ImageIcon ioneHund = new ImageIcon("C:/JAVA/pic/100won.png");
	private ImageIcon ififHund = new ImageIcon("C:/JAVA/pic/500won.png");
	private ImageIcon ioneThous = new ImageIcon("C:/JAVA/pic/1000won.png");

	private Ten ten = new Ten();
	private Fifty fif = new Fifty();
	private OneHundred oneHund = new OneHundred();
	private FiveHundred fifHund = new FiveHundred();
	private OneThousand oneThous = new OneThousand();

	private Water water = new Water();
	private Coffe coffe = new Coffe();
	private Ionic ionic = new Ionic();
	private HighCoffe highcoffe = new HighCoffe();
	private Soda soda = new Soda();

	private JButton bwater;
	private JButton bcoffe;
	private JButton bionic;
	private JButton bhighcoffe;
	private JButton bsoda;

	private JButton bten;
	private JButton bfif;
	private JButton boneHund;
	private JButton bfifHund;
	private JButton boneThous;

	private JButton returnMoney;
	private JButton totalMoney;
	private JButton Bexit;

	private JLabel resultTalk;
	private JButton resultWater;
	private JButton resultCoffe;
	private JButton resultIonic;
	private JButton resultHighCoffe;
	private JButton resultSoda;
	private JButton Manager;

	private MyDialog ShowReturn;
	private loginDialog ShowLogin;

	final int MaxPrice = 5000;
	private int num = 0;
	private int Wnum = 0;
	private int Cnum = 0;
	private int Inum = 0;
	private int Hnum = 0;
	private int Snum = 0;

	static AccumulationMoney money = new AccumulationMoney();
	Scanner sc = new Scanner(System.in);

	public Main() {
		setTitle("Vending Machine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new Mypanel();
		panel.setBackground(new Color(255, 126, 126));

		choicePane = new JScrollPane(panel);
		choicePane.setBounds(10, 10, 600, 710);

		ment.setBounds(110, 20, 400, 50);
		ment.setFont(new Font("고딕", Font.BOLD, 50));

		bwater = new JButton("물 450원", iwater);
		bwater.setBounds(40, 110, 150, 60);
		bwater.setBackground(Color.WHITE);

		bcoffe = new JButton("커피 500원", icoffe);
		bcoffe.setBounds(200, 110, 170, 60);
		bcoffe.setBackground(Color.WHITE);

		bionic = new JButton("이온음료 550원", iionic);
		bionic.setBounds(380, 110, 200, 60);
		bionic.setBackground(Color.WHITE);

		bhighcoffe = new JButton("고급커피 700원", ihighcoffe);
		bhighcoffe.setBounds(100, 190, 200, 60);
		bhighcoffe.setBackground(Color.WHITE);

		bsoda = new JButton("탄산음료 750원", isoda);
		bsoda.setBounds(320, 190, 200, 60);
		bsoda.setBackground(Color.WHITE);

		bten = new JButton(iten);
		bten.setBounds(45, 290, 85, 50);
		bten.setBackground(Color.WHITE);

		bfif = new JButton(ifif);
		bfif.setBounds(150, 290, 90, 50);
		bfif.setBackground(Color.WHITE);

		boneHund = new JButton(ioneHund);
		boneHund.setBounds(260, 290, 90, 50);
		boneHund.setBackground(Color.WHITE);

		bfifHund = new JButton(ififHund);
		bfifHund.setBounds(370, 290, 90, 50);
		bfifHund.setBackground(Color.WHITE);

		boneThous = new JButton(ioneThous);
		boneThous.setBounds(480, 290, 90, 50);
		boneThous.setBackground(Color.WHITE);

		bwater.setEnabled(false);
		bcoffe.setEnabled(false);
		bionic.setEnabled(false);
		bhighcoffe.setEnabled(false);
		bsoda.setEnabled(false);

		returnMoney = new JButton("잔돈 반환");
		returnMoney.setBounds(307, 360, 90, 40);
		returnMoney.setBackground(new Color(230, 255, 255));

		totalMoney = new JButton(money.getAccu_Money() + "원");
		totalMoney.setBounds(407, 360, 80, 40);
		totalMoney.setBackground(new Color(230, 255, 255));

		Bexit = new JButton("이용 종료");
		Bexit.setBounds(497, 360, 90, 40);
		Bexit.setBackground(new Color(230, 255, 255));

		resultTalk = new JLabel("[뽑은 음료의 리스트]");
		resultTalk.setForeground(new Color(255, 130, 36));
		resultTalk.setFont(new Font("곧음", Font.BOLD, 20));
		resultTalk.setBounds(200, 410, 200, 50);

		resultWater = new JButton("X" + Wnum + "개", iwater);
		resultWater.setBounds(75, 470, 130, 60);
		resultWater.setBackground(Color.WHITE);

		resultCoffe = new JButton("X" + Cnum + "개", icoffe);
		resultCoffe.setBounds(245, 470, 130, 60);
		resultCoffe.setBackground(Color.WHITE);

		resultIonic = new JButton("X" + Inum + "개", iionic);
		resultIonic.setBounds(415, 470, 130, 60);
		resultIonic.setBackground(Color.WHITE);

		resultHighCoffe = new JButton("X" + Hnum + "개", ihighcoffe);
		resultHighCoffe.setBounds(160, 560, 130, 60);
		resultHighCoffe.setBackground(Color.WHITE);

		resultSoda = new JButton("X" + Snum + "개", isoda);
		resultSoda.setBounds(350, 560, 130, 60);
		resultSoda.setBackground(Color.WHITE);

		Manager = new JButton("관리자 메뉴");
		Manager.setBounds(467, 655, 120, 50);
		Manager.setBackground(new Color(230, 255, 255));

		bten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (money.getAccu_Money() + ten.getPrice() > MaxPrice) {
					bten.setEnabled(false);
					bfif.setEnabled(false);
					boneHund.setEnabled(false);
					bfifHund.setEnabled(false);
					boneThous.setEnabled(false);
				}

				else {
					ten.setCoin(ten.getCoin() + 1);
					money.setAccu_Money(money.getAccu_Money() + ten.getPrice());
					totalMoney.setText(money.getAccu_Money() + "원");
				}

				if (money.getAccu_Money() >= water.getPrice())
					bwater.setEnabled(true);
				if (money.getAccu_Money() >= coffe.getPrice())
					bcoffe.setEnabled(true);
				if (money.getAccu_Money() >= ionic.getPrice())
					bionic.setEnabled(true);
				if (money.getAccu_Money() >= highcoffe.getPrice())
					bhighcoffe.setEnabled(true);
				if (money.getAccu_Money() >= soda.getPrice())
					bsoda.setEnabled(true);
				if (money.getAccu_Money() != 0)
					returnMoney.setEnabled(true);
			}
		});

		bfif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (money.getAccu_Money() + fif.getPrice() > MaxPrice) {
					bfif.setEnabled(false);
					boneHund.setEnabled(false);
					bfifHund.setEnabled(false);
					boneThous.setEnabled(false);
				}

				else {
					fif.setCoin(fif.getCoin() + 1);
					money.setAccu_Money(money.getAccu_Money() + fif.getPrice());
					totalMoney.setText(money.getAccu_Money() + "원");
				}

				if (money.getAccu_Money() >= water.getPrice())
					bwater.setEnabled(true);
				if (money.getAccu_Money() >= coffe.getPrice())
					bcoffe.setEnabled(true);
				if (money.getAccu_Money() >= ionic.getPrice())
					bionic.setEnabled(true);
				if (money.getAccu_Money() >= highcoffe.getPrice())
					bhighcoffe.setEnabled(true);
				if (money.getAccu_Money() >= soda.getPrice())
					bsoda.setEnabled(true);
				if (money.getAccu_Money() != 0)
					returnMoney.setEnabled(true);
			}
		});

		boneHund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (money.getAccu_Money() + oneHund.getPrice() > MaxPrice) {
					boneHund.setEnabled(false);
					bfifHund.setEnabled(false);
					boneThous.setEnabled(false);
				} else {
					oneHund.setCoin(oneHund.getCoin() + 1);
					money.setAccu_Money(money.getAccu_Money() + oneHund.getPrice());
					totalMoney.setText(money.getAccu_Money() + "원");
				}
				if (money.getAccu_Money() >= water.getPrice())
					bwater.setEnabled(true);
				if (money.getAccu_Money() >= coffe.getPrice())
					bcoffe.setEnabled(true);
				if (money.getAccu_Money() >= ionic.getPrice())
					bionic.setEnabled(true);
				if (money.getAccu_Money() >= highcoffe.getPrice())
					bhighcoffe.setEnabled(true);
				if (money.getAccu_Money() >= soda.getPrice())
					bsoda.setEnabled(true);
				if (money.getAccu_Money() != 0)
					returnMoney.setEnabled(true);
			}
		});

		bfifHund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (money.getAccu_Money() + fifHund.getPrice() > MaxPrice) {
					bfifHund.setEnabled(false);
					boneThous.setEnabled(false);
				} else {
					fifHund.setCoin(fifHund.getCoin() + 1);
					money.setAccu_Money(money.getAccu_Money() + fifHund.getPrice());
					totalMoney.setText(money.getAccu_Money() + "원");
				}

				if (money.getAccu_Money() >= water.getPrice())
					bwater.setEnabled(true);
				if (money.getAccu_Money() >= coffe.getPrice())
					bcoffe.setEnabled(true);
				if (money.getAccu_Money() >= ionic.getPrice())
					bionic.setEnabled(true);
				if (money.getAccu_Money() >= highcoffe.getPrice())
					bhighcoffe.setEnabled(true);
				if (money.getAccu_Money() >= soda.getPrice())
					bsoda.setEnabled(true);
				if (money.getAccu_Money() != 0)
					returnMoney.setEnabled(true);
			}
		});

		boneThous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				++num;
				if (num == 3)
					boneThous.setEnabled(false);
				if (money.getAccu_Money() + oneThous.getPrice() > MaxPrice)
					boneThous.setEnabled(false);
				oneThous.setCoin(oneThous.getCoin() + 1);
				money.setAccu_Money(money.getAccu_Money() + oneThous.getPrice());
				totalMoney.setText(money.getAccu_Money() + "원");

				if (money.getAccu_Money() >= water.getPrice())
					bwater.setEnabled(true);
				if (money.getAccu_Money() >= coffe.getPrice())
					bcoffe.setEnabled(true);
				if (money.getAccu_Money() >= ionic.getPrice())
					bionic.setEnabled(true);
				if (money.getAccu_Money() >= highcoffe.getPrice())
					bhighcoffe.setEnabled(true);
				if (money.getAccu_Money() >= soda.getPrice())
					bsoda.setEnabled(true);
				if (money.getAccu_Money() != 0)
					returnMoney.setEnabled(true);
			}
		});

		bwater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (money.getAccu_Money() >= water.getPrice()) {
					if (water.getDrink() == 0)
						bwater.setEnabled(false);
					else {
						Wnum++;
						money.setAccu_Money(money.getAccu_Money() - water.getPrice());
						water.setDrink(water.getDrink() - 1);
						totalMoney.setText(money.getAccu_Money() + "원");
						resultWater.setText("X" + Wnum + "개");
					}
				}
				if (money.getAccu_Money() < water.getPrice()) {
					bwater.setEnabled(false);
					bcoffe.setEnabled(false);
					bionic.setEnabled(false);
					bhighcoffe.setEnabled(false);
					bsoda.setEnabled(false);
				}
				if (money.getAccu_Money() != 0)
					returnMoney.setEnabled(true);
			}
		});

		bcoffe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (money.getAccu_Money() >= coffe.getPrice()) {
					if (coffe.getDrink() == 0)
						bcoffe.setEnabled(false);
					else {
						Cnum++;
						money.setAccu_Money(money.getAccu_Money() - coffe.getPrice());
						coffe.setDrink(coffe.getDrink() - 1);
						totalMoney.setText(money.getAccu_Money() + "원");
						resultCoffe.setText("X" + Cnum + "개");
					}
				}
				if (money.getAccu_Money() < coffe.getPrice()) {
					bcoffe.setEnabled(false);
					bionic.setEnabled(false);
					bhighcoffe.setEnabled(false);
					bsoda.setEnabled(false);
				}
				if (money.getAccu_Money() != 0)
					returnMoney.setEnabled(true);
			}
		});

		bionic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (money.getAccu_Money() >= ionic.getPrice()) {
					if (ionic.getDrink() == 0)
						bionic.setEnabled(false);
					else {
						Inum++;
						money.setAccu_Money(money.getAccu_Money() - ionic.getPrice());
						ionic.setDrink(ionic.getDrink() - 1);
						totalMoney.setText(money.getAccu_Money() + "원");
						resultIonic.setText("X" + Hnum + "개");
					}
				}
				if (money.getAccu_Money() < ionic.getPrice()) {
					bionic.setEnabled(false);
					bhighcoffe.setEnabled(false);
					bsoda.setEnabled(false);
				}
				if (money.getAccu_Money() != 0)
					returnMoney.setEnabled(true);
			}
		});

		bhighcoffe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (money.getAccu_Money() >= highcoffe.getPrice()) {
					if (highcoffe.getDrink() == 0)
						bhighcoffe.setEnabled(false);
					else {
						Hnum++;
						money.setAccu_Money(money.getAccu_Money() - highcoffe.getPrice());
						highcoffe.setDrink(highcoffe.getDrink() - 1);
						totalMoney.setText(money.getAccu_Money() + "원");
						resultHighCoffe.setText("X" + Hnum + "개");
					}
				}
				if (money.getAccu_Money() < highcoffe.getPrice()) {
					bhighcoffe.setEnabled(false);
					bsoda.setEnabled(false);
				}
				if (money.getAccu_Money() != 0)
					returnMoney.setEnabled(true);
			}
		});

		bsoda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (money.getAccu_Money() >= soda.getPrice()) {
					if (soda.getDrink() == 0)
						bsoda.setEnabled(false);
					else {
						Snum++;
						money.setAccu_Money(money.getAccu_Money() - soda.getPrice());
						soda.setDrink(soda.getDrink() - 1);
						totalMoney.setText(money.getAccu_Money() + "원");
						resultSoda.setText("X" + Snum + "개");
					}
				}
				if (money.getAccu_Money() < soda.getPrice())
					bsoda.setEnabled(false);
				if (money.getAccu_Money() != 0)
					returnMoney.setEnabled(true);
			}
		});

		returnMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowReturn = new MyDialog(Main.this, "잔돈 반환");
				ShowReturn.setVisible(true);
			}
		});

		Bexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		Manager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowLogin = new loginDialog(Main.this, "로그인 창");
				ShowLogin.setVisible(true);
			}
		});

		MainPanel = new JPanel(null);

		MainPanel.add(ment);
		MainPanel.add(bwater);
		MainPanel.add(bcoffe);
		MainPanel.add(bionic);
		MainPanel.add(bhighcoffe);
		MainPanel.add(bsoda);

		MainPanel.add(bten);
		MainPanel.add(bfif);
		MainPanel.add(boneHund);
		MainPanel.add(bfifHund);
		MainPanel.add(boneThous);

		MainPanel.add(totalMoney);
		MainPanel.add(returnMoney);
		MainPanel.add(Bexit);

		MainPanel.add(resultTalk);
		MainPanel.add(resultWater);
		MainPanel.add(resultCoffe);
		MainPanel.add(resultIonic);
		MainPanel.add(resultHighCoffe);
		MainPanel.add(resultSoda);

		MainPanel.add(Manager);
		MainPanel.add(choicePane);
		MainPanel.setBackground(new Color(255, 234, 234));

		setVisible(true);
		setBounds(200, 30, 635, 770);
		add(MainPanel);
	}

	class MyDialog extends JDialog {
		private JLabel ReoneThous;
		private JLabel RefifHund;
		private JLabel ReoneHund;
		private JLabel ReFif;
		private JLabel ReTen;
		private JLabel Talk = new JLabel("[동전이 반환되었습니다.]");
		private JButton Ok = new JButton("OK");

		public MyDialog(JFrame frame, String title) {
			super(frame, title);
			setLayout(null);

			if (oneThous.getCoin() == 0) {
				RefifHund = new JLabel("1000원 지폐가 없습니다.");
			} else {
				int NoneThous = Main.money.getAccu_Money() / oneThous.getPrice();
				ReoneThous = new JLabel("1000원 : " + NoneThous + "개");
				money.setAccu_Money(money.getAccu_Money() - (NoneThous * oneThous.getPrice()));
				oneThous.setCoin(oneThous.getCoin() - NoneThous);
			}

			if (fifHund.getCoin() == 0) {
				RefifHund = new JLabel("500원 동전이 없습니다.");
			} else {
				int NfifHund = money.getAccu_Money() / fifHund.getPrice();
				RefifHund = new JLabel(" 500원  : " + Integer.toString(NfifHund) + "개");
				money.setAccu_Money(money.getAccu_Money() - (NfifHund * fifHund.getPrice()));
				fifHund.setCoin(fifHund.getCoin() - NfifHund);
			}

			if (oneHund.getCoin() == 0) {
				ReoneHund = new JLabel("100원 동전이 없습니다.");
			} else {
				int NoneHund = money.getAccu_Money() / oneHund.getPrice();
				ReoneHund = new JLabel(" 100원  : " + Integer.toString(NoneHund) + "개");
				money.setAccu_Money(money.getAccu_Money() - (NoneHund * oneHund.getPrice()));
				oneHund.setCoin(oneHund.getCoin() - NoneHund);
			}

			if (fif.getCoin() == 0) {
				ReFif = new JLabel("50원 동전이 없습니다.");
			} else {
				int Nfif = (int) (money.getAccu_Money() / fif.getPrice());
				ReFif = new JLabel("  50원  : " + Integer.toString(Nfif) + "개");
				money.setAccu_Money(money.getAccu_Money() - (Nfif * fif.getPrice()));
				fif.setCoin(fif.getCoin() - Nfif);
			}

			if (ten.getCoin() == 0) {
				ReTen = new JLabel("10원 동전이 없습니다.");
			} else {
				int Nten = money.getAccu_Money() / ten.getPrice();
				ReTen = new JLabel("  10원  : " + Integer.toString(Nten) + "개");
				money.setAccu_Money(money.getAccu_Money() - (Nten * ten.getPrice()));
				ten.setCoin(ten.getCoin() - Nten);
			}

			Talk.setBounds(10, 10, 140, 30);
			ReoneThous.setBounds(40, 50, 80, 20);
			RefifHund.setBounds(40, 80, 80, 20);
			ReoneHund.setBounds(40, 110, 80, 20);
			ReFif.setBounds(40, 140, 80, 20);
			ReTen.setBounds(40, 170, 80, 20);
			Ok.setBounds(100, 200, 60, 30);

			add(Talk);
			add(ReoneThous);
			add(RefifHund);
			add(ReoneHund);
			add(ReFif);
			add(ReTen);
			add(Ok);

			setBounds(300, 200, 180, 270);

			Ok.setForeground(Color.WHITE);
			Ok.setBackground(Color.BLACK);
			Ok.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					returnMoney.setEnabled(false);
					totalMoney.setText(money.getAccu_Money() + "원");
					num = 0;
					Wnum = 0;
					Cnum = 0;
					Inum = 0;
					Hnum = 0;
					Snum = 0;
					resultWater.setText("X" + Wnum + "개");
					resultCoffe.setText("X" + Cnum + "개");
					resultIonic.setText("X" + Inum + "개");
					resultHighCoffe.setText("X" + Hnum + "개");
					resultSoda.setText("X" + Snum + "개");
					boneThous.setEnabled(true);
				}
			});

		}
	}

	class Mypanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.WHITE);
			g.drawRect(20, 80, 555, 180);
			g.fillRect(20, 80, 555, 180);
			g.drawRect(20, 270, 555, 70);
			g.fillRect(20, 270, 555, 70);
			g.drawRect(20, 400, 555, 230);
			g.fillRect(20, 400, 555, 230);
		}
	}

	class loginDialog extends JDialog {
		private JLabel id = new JLabel("                           ID ");
		private JTextField putId = new JTextField(10);
		private JLabel password = new JLabel("              PassWord ");
		private JTextField putPw = new JTextField(10);
		private JButton BLogin = new JButton("로그인");

		public loginDialog(JFrame frame, String title) {
			super(frame, title);
			setLayout(null);

			id.setBounds(0, 30, 120, 30);
			putId.setBounds(120, 30, 130, 30);

			password.setBounds(0, 70, 120, 30);
			putPw.setBounds(120, 70, 130, 30);

			BLogin.setBounds(170, 110, 80, 30);
			BLogin.setForeground(Color.WHITE);
			BLogin.setBackground(Color.BLACK);

			add(id);
			add(putId);
			add(password);
			add(putPw);
			add(BLogin);

			setBounds(400, 300, 300, 200);

			BLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					manager.setVisible(true);
				}
			});
		}
	}

	class Manager extends JFrame {
		ManagerDialog collection;
		RSDrinkDialog Rename;
		private JLabel plusTalk = new JLabel("[음료 재고 추가 메뉴]");
		private JButton plusWater = new JButton("물 재고 +1", iwater);
		private JButton plusCoffe = new JButton("커피 재고 +1", icoffe);
		private JButton plusIonic = new JButton("이온음료 재고 +1", iionic);
		private JButton plusHighCoffe = new JButton("고급커피 재고 +1", ihighcoffe);
		private JButton plusSoda = new JButton("탄산음료 재고 +1", isoda);

		private JPanel Mpanel = new JPanel(null);
		private Managerpanel panel = new Managerpanel();
		private JScrollPane jscroll = new JScrollPane(panel);

		private String[] Dchoice = { "전체 매출", "물", "커피", "이온음료", "고급커피", "탄산음료" };
		private String[] Month = { "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월" };

		private JLabel DayTalk = new JLabel("<일매출>");
		private JComboBox<String> DayDrink = new JComboBox<String>(Dchoice);
		private JTextField DayChoice = new JTextField("날짜 입력(X월 X일)", 10);
		private JTextField DayResult = new JTextField(30);

		private JLabel MonthTalk = new JLabel("<월매출>");
		private JComboBox<String> MonthDrink = new JComboBox<String>(Dchoice);
		private JComboBox MonthChoice = new JComboBox<String>(Month);
		private JTextField MonthResult = new JTextField(30);

		private JButton ResetPw = new JButton("비밀 번호 변경");
		private JButton ResetDrink = new JButton("판매 가격/이름 변경");
		private JButton Collection = new JButton("수금");
		private JButton ManagerExit = new JButton("관리자 메뉴 종료");
		private JButton ReCoin = new JButton("동전 재고 조회");
		private JButton ReDrink = new JButton("음료 재고 조회");

		private JLabel StockTalk = new JLabel("[화폐/음료 재고 현황]");
		private String coinTalk[] = { "10원", "50원", "100원", "500원", "100원" };
		private DefaultTableModel coin = new DefaultTableModel(coinTalk, 1);
		private JTable coinStock = new JTable(coin);
		private JScrollPane jc = new JScrollPane(coinStock);

		private String drinkTalk[] = { "물", "커피", "이온음료", "고급커피", "탄산음료" };
		private DefaultTableModel drink = new DefaultTableModel(drinkTalk, 1);
		private JTable drinkStock = new JTable(drink);
		private JScrollPane jd = new JScrollPane(drinkStock);

		public Manager() {
			setTitle("관리자 메뉴");

			panel.setBackground(Color.WHITE);
			jscroll.setBounds(0, 0, 900, 500);
			jscroll.setBackground(Color.WHITE);

			plusTalk.setBounds(22, 20, 200, 30);
			plusTalk.setFont(new Font("곧음", Font.BOLD, 20));

			plusWater.setBounds(20, 60, 200, 50);
			plusWater.setBackground(new Color(206, 255, 199));

			plusCoffe.setBounds(20, 120, 200, 50);
			plusCoffe.setBackground(new Color(206, 255, 199));

			plusIonic.setBounds(20, 180, 200, 50);
			plusIonic.setBackground(new Color(206, 255, 199));

			plusHighCoffe.setBounds(20, 240, 200, 50);
			plusHighCoffe.setBackground(new Color(206, 255, 199));

			plusSoda.setBounds(20, 300, 200, 50);
			plusSoda.setBackground(new Color(206, 255, 199));

			DayTalk.setBounds(265, 20, 60, 30);
			DayDrink.setBounds(330, 20, 100, 30);
			DayChoice.setBounds(440, 20, 100, 30);
			DayResult.setBounds(275, 60, 255, 40);

			MonthTalk.setBounds(575, 20, 60, 30);
			MonthDrink.setBounds(640, 20, 100, 30);
			MonthChoice.setBounds(750, 20, 100, 30);
			MonthResult.setBounds(585, 60, 255, 40);

			StockTalk.setBounds(375, 130, 400, 40);
			StockTalk.setFont(new Font("곧음", Font.BOLD, 20));

			jc.setBounds(270, 180, 400, 40);
			coinStock.setFillsViewportHeight(true);

			ReCoin.setBounds(520, 225, 150, 40);
			ReCoin.setBackground(new Color(206, 255, 199));

			jd.setBounds(270, 275, 400, 40);
			drinkStock.setFillsViewportHeight(true);

			ReDrink.setBounds(520, 320, 150, 40);
			ReDrink.setBackground(new Color(206, 255, 199));

			ResetPw.setBounds(710, 132, 150, 45);
			ResetPw.setBackground(new Color(206, 255, 199));

			ResetDrink.setBounds(710, 195, 150, 45);
			ResetDrink.setBackground(new Color(206, 255, 199));

			Collection.setBounds(710, 260, 150, 45);
			Collection.setBackground(new Color(206, 255, 199));

			ManagerExit.setBounds(710, 325, 150, 45);
			ManagerExit.setBackground(new Color(206, 255, 199));

			plusWater.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					water.setDrink(water.getDrink() + 1);
				}
			});

			plusCoffe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					coffe.setDrink(coffe.getDrink() + 1);
				}
			});

			plusIonic.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ionic.setDrink(ionic.getDrink() + 1);
				}
			});

			plusHighCoffe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					highcoffe.setDrink(highcoffe.getDrink() + 1);
				}
			});

			plusSoda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					soda.setDrink(soda.getDrink() + 1);
				}
			});

			DayChoice.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JTextField tp = (JTextField) e.getSource();
					String day = tp.getText();
					DayResult.setText(day + " 매출 :  원");
				}
			});

			MonthChoice.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JComboBox tp = (JComboBox) e.getSource();
					String month = (String) tp.getSelectedItem();
					MonthResult.setText(month + " 매출 : 원");
				}
			});

			ReCoin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					coin.setValueAt("  " + ten.getCoin() + "개", 0, 0);
					coin.setValueAt("  " + fif.getCoin() + "개", 0, 1);
					coin.setValueAt("  " + oneHund.getCoin() + "개", 0, 2);
					coin.setValueAt("  " + fifHund.getCoin() + "개", 0, 3);
					coin.setValueAt("  " + oneThous.getCoin() + "개", 0, 4);
				}
			});

			ReDrink.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					drink.setValueAt("  " + water.getDrink() + "개", 0, 0);
					drink.setValueAt("  " + coffe.getDrink() + "개", 0, 1);
					drink.setValueAt("  " + ionic.getDrink() + "개", 0, 2);
					drink.setValueAt("  " + highcoffe.getDrink() + "개", 0, 3);
					drink.setValueAt("  " + soda.getDrink() + "개", 0, 4);
				}
			});

			ResetDrink.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Rename = new RSDrinkDialog(Manager.this, "판매 가격/이름 변경");
					Rename.setVisible(true);
				}
			});

			Collection.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					collection = new ManagerDialog(Manager.this, "수금");
					collection.setVisible(true);
				}
			});

			ManagerExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					manager.setVisible(false);
				}
			});

			Mpanel.add(plusTalk);
			Mpanel.add(plusWater);
			Mpanel.add(plusCoffe);
			Mpanel.add(plusIonic);
			Mpanel.add(plusHighCoffe);
			Mpanel.add(plusSoda);

			Mpanel.add(DayTalk);
			Mpanel.add(DayDrink);
			Mpanel.add(DayChoice);
			Mpanel.add(DayResult);

			Mpanel.add(MonthTalk);
			Mpanel.add(MonthDrink);
			Mpanel.add(MonthChoice);
			Mpanel.add(MonthResult);

			Mpanel.add(StockTalk);
			Mpanel.add(jc);
			Mpanel.add(ReCoin);
			Mpanel.add(jd);
			Mpanel.add(ReDrink);

			Mpanel.add(ResetPw);
			Mpanel.add(ResetDrink);
			Mpanel.add(Collection);
			Mpanel.add(ManagerExit);

			Mpanel.add(jscroll);

			Mpanel.setBackground(Color.WHITE);
			setBounds(300, 200, 900, 450);
			add(Mpanel);
		}
	}

	class Managerpanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.LIGHT_GRAY);

			g.drawRect(10, 10, 220, 360);
			g.fillRect(10, 10, 220, 360);

			g.drawRect(255, 10, 295, 100);
			g.fillRect(255, 10, 295, 100);

			g.drawRect(565, 10, 295, 100);
			g.fillRect(565, 10, 295, 100);

			g.drawRect(255, 130, 430, 240);
			g.fillRect(255, 130, 430, 240);
		}
	}

	class RSDrinkDialog extends JDialog {
		private JLabel Dtalk = new JLabel("[판매 가격 / 이름 변경]");
		private JComboBox choice = new JComboBox(
				new String[] { "물 450원", "커피 500원", "이온음료 550원", "고급커피 700원", "탄산음료 750원" });
		private JTextField setRename = new JTextField(10);
		private JTextField setReprice = new JTextField(10);
		private JButton DOk = new JButton("변경");
		private JButton DExit = new JButton("종료");

		public RSDrinkDialog(Frame frame, String title) {
			super(frame, title);
			setLayout(null);

			Dtalk.setFont(new Font("곧음", Font.BOLD, 20));
			DOk.setForeground(Color.WHITE);
			DOk.setBackground(Color.BLACK);
			DExit.setForeground(Color.WHITE);
			DExit.setBackground(Color.BLACK);
			
			DOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int num = (int) choice.getSelectedIndex();
					if (setRename.getText() != null || setReprice.getText() != null) {
						switch (num) {
						case 0:
							String Wname = (String) setRename.getText();
							String Wprice = (String) setReprice.getText();
							bwater.setText(Wname + " " + Wprice + "원");
							water.setPrice(Integer.parseInt(Wprice));
							break;
						case 1:
							String Cname = (String) setRename.getText();
							String Cprice = (String) setReprice.getText();
							bcoffe.setText(Cname + " " + Cprice + "원");
							coffe.setPrice(Integer.parseInt(Cprice));
							break;
						case 2:
							String Iname = (String) setRename.getText();
							String Iprice = (String) setReprice.getText();
							bionic.setText(Iname + " " + Iprice + "원");
							ionic.setPrice(Integer.parseInt(Iprice));
							break;
						case 3:
							String Hname = (String) setRename.getText();
							String Hprice = (String) setReprice.getText();
							bhighcoffe.setText(Hname + " " + Hprice + "원");
							highcoffe.setPrice(Integer.parseInt(Hprice));
							break;
						case 4:
							String Sname = (String) setRename.getText();
							String Sprice = (String) setReprice.getText();
							bsoda.setText(Sname + " " + Sprice + "원");
							soda.setPrice(Integer.parseInt(Sprice));
							break;
						}
					}
				}
			});
			
			Dtalk.setBounds(30, 10, 300, 50);
			choice.setBounds(25, 70, 85, 35);
			setRename.setBounds(120, 70, 70, 35);
			setReprice.setBounds(200, 70, 70, 35);
			DOk.setBounds(120, 120, 70, 30);
			DExit.setBounds(200, 120, 70, 30);
			
			add(Dtalk);
			add(choice);
			add(setRename);
			add(setReprice);
			add(DOk);
			add(DExit);

			setBounds(500, 200, 300, 200);
			DExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
		}
	}

	class ManagerDialog extends JDialog {
		private JLabel Ctalk = new JLabel("[수금 목록]");
		private JLabel Cten;
		private JLabel Cfif;
		private JLabel ConeHund;
		private JLabel CfifHund;
		private JLabel ConeThous;
		private JButton Cok = new JButton("OK");

		public ManagerDialog(Frame frame, String title) {
			super(frame, title);
			setLayout(null);

			if (ten.getCoin() <= 5) {
				Cten = new JLabel("  10원 : 0개");
			} else {
				int Tnum = ten.getCoin() - 5;
				Cten = new JLabel("  10원 : " + Tnum + "개");
				ten.setCoin(ten.getCoin() - Tnum);
			}

			if (fif.getCoin() <= 5) {
				Cfif = new JLabel("  50원 : 0개");
			} else {
				int Fnum = fif.getCoin() - 5;
				Cfif = new JLabel("  50원 : " + Fnum + "개");
				fif.setCoin(fif.getCoin() - Fnum);
			}

			if (oneHund.getCoin() <= 5) {
				ConeHund = new JLabel(" 100원 : 0개");
			} else {
				int OHnum = oneHund.getCoin() - 5;
				ConeHund = new JLabel(" 100원 : " + OHnum + "개");
				oneHund.setCoin(oneHund.getCoin() - OHnum);
			}

			if (fifHund.getCoin() <= 5) {
				CfifHund = new JLabel(" 500원 : 0개");
			} else {
				int FHnum = fifHund.getCoin() - 5;
				CfifHund = new JLabel(" 500원 : " + FHnum + "개");
				fifHund.setCoin(fifHund.getCoin() - FHnum);
			}

			if (oneThous.getCoin() <= 5) {
				ConeThous = new JLabel("1000원 : 0개");
			} else {
				int OTnum = oneThous.getCoin() - 5;
				ConeThous = new JLabel("1000원 : " + OTnum + "개");
				oneThous.setCoin(oneThous.getCoin() - OTnum);
			}

			Ctalk.setFont(new Font("곧음", Font.BOLD, 20));
			Cok.setForeground(Color.WHITE);
			Cok.setBackground(Color.BLACK);

			Ctalk.setBounds(30, 10, 140, 30);
			Cten.setBounds(40, 50, 80, 20);
			Cfif.setBounds(40, 80, 80, 20);
			ConeHund.setBounds(40, 110, 80, 20);
			CfifHund.setBounds(40, 140, 80, 20);
			ConeThous.setBounds(40, 170, 80, 20);
			Cok.setBounds(100, 200, 60, 30);

			add(Ctalk);
			add(Cten);
			add(Cfif);
			add(ConeHund);
			add(CfifHund);
			add(ConeThous);
			add(Cok);

			setBounds(500, 200, 180, 270);

			Cok.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
		}
	}

	public static void main(String[] args) {
		new Main();
	}
}