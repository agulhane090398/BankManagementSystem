package bankingATM;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.sql.*;

import javax.swing.*;


public class Transactions extends JFrame implements ActionListener
{
	JLabel l1,l11;
	JButton b1,b2,b3,b4,b5,b6,b7;
	String pin;
	
	Transactions(String pin)
	{
		this.pin=pin;
		setLayout(null);
		
//		setFont(new Font("System",Font.BOLD,22));
//		Font f=getFont();
//		FontMetrics fm = getFontMetrics(f);
//		int x=fm.stringWidth("TRANSACTION");
//		int y=fm.stringWidth(" ");
//		int z=getWidth()-x;
//		int w=z/y;
//		String pad="";
//		
//		//for (int i=0;i!=w; i++) pad+=" ";
//		pad=String.format("%"+w+"s",pad);
//		setTitle(pad+"Transaction");
		setTitle("Transaction");
		
//		try {
			ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("bankingATM/img/atm.JPG"));
			Image i2=i1.getImage().getScaledInstance(690, 820, Image.SCALE_DEFAULT);
			ImageIcon i3=new ImageIcon(i2);
			JLabel l11=new JLabel(i3);
			l11.setBounds(0, 0, 690, 820);
			add(l11);

//		}
//		catch(Exception a)
////		{
//			a.printStackTrace();
//		}
		
		
//		Labels
		l1=new JLabel("Please Select Your Transaction");
		l1.setFont(new Font("System",Font.BOLD,12));
		l1.setBounds(180, 260, 700, 30);
		l1.setForeground(Color.WHITE);
		l11.add(l1);
		
//		BUTTON
		b1=new JButton("DEPOSIT");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Raleway",Font.BOLD,10));
		b1.setBounds(116, 382, 140, 20);
		l11.add(b1);
		b1.addActionListener(this);
		
		b2=new JButton("CASH WITHDRAWAL");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Raleway",Font.BOLD,10));
		b2.setBounds(260, 382, 140, 20);
		l11.add(b2);
		b2.addActionListener(this);
		
		b3=new JButton("FAST CASH");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setFont(new Font("Raleway",Font.BOLD,10));
		b3.setBounds(116, 415, 140, 20);
		l11.add(b3);
		b3.addActionListener(this);
		
		b4=new JButton("MINI-STATEMENT");
		b4.setBackground(Color.BLACK);
		b4.setForeground(Color.WHITE);
		b4.setFont(new Font("Raleway",Font.BOLD,10));
		b4.setBounds(260, 415, 140, 20);
		l11.add(b4);
		b4.addActionListener(this);
		
		b5=new JButton("PIN CHANGE");
		b5.setBackground(Color.BLACK);
		b5.setForeground(Color.WHITE);
		b5.setFont(new Font("Raleway",Font.BOLD,10));
		b5.setBounds(116, 447, 120, 20);
		l11.add(b5);
		b5.addActionListener(this);
		
		b6=new JButton("BALANCE ENQUERY");
		b6.setBackground(Color.BLACK);
		b6.setForeground(Color.WHITE);
		b6.setFont(new Font("Raleway",Font.BOLD,10));
		b6.setBounds(260, 447, 140, 20);
		l11.add(b6);
		b6.addActionListener(this);
		
		b7=new JButton("EXIT");
		b7.setBackground(Color.BLACK);
		b7.setForeground(Color.WHITE);
		b7.setFont(new Font("Raleway",Font.BOLD,10));
		b7.setBounds(116, 480, 120, 20);
		l11.add(b7);
		b7.addActionListener(this);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(690,820);
		setLocation(500,0);
		setVisible(true);
//		setUdecorated(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
		if(e.getSource()==b1)
		{
			setVisible(false);
			new Deposit(pin).setVisible(true);
		}
		else if(e.getSource()==b2)
		{
			setVisible(false);
			new Withdrawal(pin).setVisible(true);
		}
		else if(e.getSource()==b3)
		{
			setVisible(false);
			new FastCash(pin).setVisible(true);
		}
		else if(e.getSource()==b4)
		{
			new MiniStatement(pin).setVisible(true);
		}
		else if(e.getSource()==b5)
		{
			setVisible(false);
			new PIN(pin).setVisible(true);
		}
		else if(e.getSource()==b6)
		{
			setVisible(false);
			new BalanceEnquiry(pin).setVisible(true);
		}
		else if(e.getSource()==b7)
		{
			System.exit(0);
		}
		
	}
	public static void main(String[] args) 
	{
		new Transactions("").setVisible(true);
	}
}
