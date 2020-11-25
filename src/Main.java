import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Main extends JFrame {

	final int MaxPrice = 5000;
	int num = 0;

	Ten ten;
	Fifty fif;
	OneHundred oneHund;
	FiveHundred fifHund;
	OneThousand oneThous;

	Water water;
	Coffe coffe;
	Ionic ionic;
	HighCoffe highcoffe;
	Soda soda;

	JButton bwater;
	JButton bcoffe;
	JButton bionic;
	JButton bhighcoffe;
	JButton bsoda;

	JButton bten;
	JButton bfif;
	JButton boneHund;
	JButton bfifHund;
	JButton boneThous;
	
	AccumulationMoney money = new AccumulationMoney();
	Scanner sc = new Scanner(System.in);

	public Main() {
		setTitle("Vending Machine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		ten = new Ten();
		fif = new Fifty();
		oneHund = new OneHundred();
		fifHund = new FiveHundred();
		oneThous = new OneThousand();

		water = new Water();
		coffe = new Coffe();
		ionic = new Ionic();
		highcoffe = new HighCoffe();
		soda = new Soda();

		ImageIcon iwater = new ImageIcon("C:/JAVA/pic/Water.jpg");
		ImageIcon icoffe = new ImageIcon("C:/JAVA/pic/Coffe.jpg");
		ImageIcon iionic = new ImageIcon("C:/JAVA/pic/Ionic.jpg");
		ImageIcon ihighcoffe = new ImageIcon("C:/JAVA/pic/HighCoffe.jpg");
		ImageIcon isoda = new ImageIcon("C:/JAVA/pic/Soda.jpg");

		ImageIcon iten = new ImageIcon("C:/JAVA/pic/10won.png");
		ImageIcon ifif = new ImageIcon("C:/JAVA/pic/50won.png");
		ImageIcon ioneHund = new ImageIcon("C:/JAVA/pic/100won.png");
		ImageIcon ififHund = new ImageIcon("C:/JAVA/pic/500won.png");
		ImageIcon ioneThous = new ImageIcon("C:/JAVA/pic/1000won.png");

		bwater = new JButton("물", iwater);
		bcoffe = new JButton("커피", icoffe);
		bionic = new JButton("이온음료", iionic);
		bhighcoffe = new JButton("고급커피", ihighcoffe);
		bsoda = new JButton("탄산음료", isoda);

		bten = new JButton(iten);
		bfif = new JButton(ifif);
		boneHund = new JButton(ioneHund);
		bfifHund = new JButton(ififHund);
		boneThous = new JButton(ioneThous);
		
		bwater.setBackground(new Color(255, 234, 234));
		bcoffe.setBackground(new Color(255, 234, 234));
		bionic.setBackground(new Color(255, 234, 234));
		bhighcoffe.setBackground(new Color(255, 234, 234));
		bsoda.setBackground(new Color(255, 234, 234));

		if (money.getAccu_Money() > MaxPrice) {
			bten.setEnabled(false);
			bfif.setEnabled(false);
			boneHund.setEnabled(false);
			bfifHund.setEnabled(false);
			boneThous.setEnabled(false);
		}

		bten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (money.getAccu_Money() + ten.getPrice() > MaxPrice)
					bten.setEnabled(false);
				ten.setCoin(ten.getCoin() + 1);
				money.setAccu_Money(money.getAccu_Money() + ten.getPrice());
			}
		});
		
		bfif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (money.getAccu_Money() + fif.getPrice() > MaxPrice)
					bfif.setEnabled(false);
				fif.setCoin(fif.getCoin() + 1);
				money.setAccu_Money(money.getAccu_Money() + fif.getPrice());
			}
		});
		
		boneHund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (money.getAccu_Money() + oneHund.getPrice() > MaxPrice)
					boneHund.setEnabled(false);
				oneHund.setCoin(oneHund.getCoin() + 1);
				money.setAccu_Money(money.getAccu_Money() + oneHund.getPrice());
			}
		});
		
		bfifHund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (money.getAccu_Money() + fifHund.getPrice() > MaxPrice)
					bfifHund.setEnabled(false);
				fifHund.setCoin(fifHund.getCoin() + 1);
				money.setAccu_Money(money.getAccu_Money() + fifHund.getPrice());
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
			}
		});
		
		c.add(bwater);
		c.add(bcoffe);
		c.add(bionic);
		c.add(bhighcoffe);
		c.add(bsoda);
		c.add(bten);

		c.add(bfif);
		c.add(boneHund);
		c.add(bfifHund);
		c.add(boneThous);

		setSize(450, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Main();
	}
}