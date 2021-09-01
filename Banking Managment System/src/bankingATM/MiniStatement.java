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

public class MiniStatement extends JFrame implements ActionListener {
	String pin;
	float balance = 0f;
	JLabel l1;
	JButton b1;

	MiniStatement(String pin) {

		super("Mini Statement");
		this.pin = pin;

		setLayout(null);
//		
		getContentPane().setBackground(Color.WHITE);
		
		JLabel l3 = new JLabel("Indian Bank");
		l3.setForeground(Color.BLACK);
		l3.setFont(new Font("Raleway", Font.BOLD, 25));
		l3.setBounds(260, 100, 700, 30);
		add(l3);
		
		JLabel l1 = new JLabel("hvbjbh");//card no
		l1.setForeground(Color.BLACK);
		l1.setFont(new Font("Raleway", Font.BOLD, 25));
		l1.setBounds(120, 670, 500, 30);
		add(l1);
		
		JLabel l2 = new JLabel();	//detailed transaction
		l2.setForeground(Color.BLACK);
		l2.setFont(new Font("Raleway", Font.BOLD, 12));
		l2.setBounds(140, 130, 900, 600);
		add(l2);
		
		JLabel l4 = new JLabel();	//balance
		l4.setForeground(Color.BLACK);
		l4.setFont(new Font("Raleway", Font.BOLD, 16));
		l4.setBounds(160, 700, 500, 30);
		add(l4);
		
		
		try {
			Connectionset c = new Connectionset();
			ResultSet rs = c.s.executeQuery("select * from login where pin='" + pin + "'");
			System.out.println(rs);
			System.out.println("in while");
//			while(rs.next()) {
			rs.next();
				l1.setText("Card Number:     "+ rs.getString("cardno").substring(0, 4) + "-XXXX-XXXX-" + rs.getString("cardno").substring(12));
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
//		set printing values
				
		try {
			Connectionset c = new Connectionset();
			ResultSet rs = c.s.executeQuery("select * from bank where pin='" + pin + "'");
			while (rs.next()) 
			{
				l2.setText(l2.getText() +"<html> "  + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("mode") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount")+"<br><br><html>");
				
				if(rs.getString("mode").equals("Deposit"))
				{
					balance+=Float.parseFloat(rs.getString("amount"));
//					System.out.println(balance);
				}
				else
				{
					balance-=Float.parseFloat(rs.getString("amount"));							
//					System.out.println(balance);
				}
			}
			l4.setText("Your current Account Balance is: "+balance);
		} 
		catch (Exception ae) 
		{
			ae.printStackTrace();
		}
		
		JButton b1 = new JButton("Back");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Raleway", Font.BOLD, 18));
		b1.setBounds(260, 750, 140, 30);
		add(b1);
		b1.addActionListener(this);

		getContentPane().setBackground(Color.WHITE);

		setSize(690, 820);
		setLocation(500, 0);
		setVisible(true);
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		setVisible(false);

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MiniStatement("").setVisible(true);
	}

}
