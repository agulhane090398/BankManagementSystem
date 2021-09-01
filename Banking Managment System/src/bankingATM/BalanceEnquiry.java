package bankingATM;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BalanceEnquiry extends JFrame implements ActionListener {
	String pin;
	int balance = 0;

	BalanceEnquiry(String pin) {
		this.pin = pin;

		setLayout(null);
//		try {
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bankingATM/img/atm.JPG"));
		Image i2 = i1.getImage().getScaledInstance(690, 820, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l11 = new JLabel(i3);
		l11.setBounds(0, 0, 690, 820);
		add(l11);

//		}
//		catch(Exception a)
////		{
//			a.printStackTrace();
//		}

		JLabel l1 = new JLabel();
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Raleway", Font.BOLD, 12));
		l1.setBounds(140, 260, 700, 30);
		try {

			Connectionset c = new Connectionset();

			ResultSet rs = c.s.executeQuery("SELECT * FROM BANK WHERE PIN='" + pin + "'");

			
			while (rs.next()) {
//				System.out.println("in While");
				if (rs.getString("mode").equals("Deposit")) {
					balance += Integer.parseInt(rs.getString("amount"));
//					System.out.println(balance);
				} else {
					balance -= Integer.parseInt(rs.getString("amount"));
					System.out.println(balance);
				}
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		l1.setText("Your current Balance is Rs. "+balance);
		l11.add(l1);

		JButton b1 = new JButton("Back");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Raleway", Font.BOLD, 10));
		b1.setBounds(260, 480, 140, 20);
		l11.add(b1);
		b1.addActionListener(this);

		setSize(690, 820);
		setLocation(500, 0);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
			setVisible(false);
			new Transactions(pin).setVisible(true);
		

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BalanceEnquiry("").setVisible(true);
	}

}
