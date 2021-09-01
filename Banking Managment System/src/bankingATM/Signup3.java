package bankingATM;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.sql.*;

import javax.swing.*;


public class Signup3 extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	JTextField t1;
	JRadioButton r1,r2,r3,r4;
	JButton b1,b2;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	String formno;
	Signup3(String formno)
	{
		this.formno=formno;
		setLayout(null);
		
//		setFont(new Font("System",Font.BOLD,22));
//		Font f=getFont();
//		FontMetrics fm = getFontMetrics(f);
//		int x=fm.stringWidth("NEW ACCOUNT APPLICATION FORM");
//		int y=fm.stringWidth(" ");
//		int z=getWidth()-x;
//		int w=z/y;
//		String pad="";
//		
//		//for (int i=0;i!=w; i++) pad+=" ";
//		pad=String.format("%"+w+"s",pad);
//		setTitle(pad+"NEW USER PORTAL");
		setTitle("NEW USER PORTAL");
		
		try {
			ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("bankingATM/img/logo.JPG"));
			Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
			ImageIcon i3=new ImageIcon(i2);
			JLabel l11=new JLabel(i3);
			l11.setBounds(20, 0, 100, 100);
			add(l11);

		}
		catch(Exception a)
		{
			a.printStackTrace();
		}
		
//		Labels
		l1=new JLabel("PAGE 3: ACCOUNT DETAILS");
		l1.setFont(new Font("Raleway",Font.BOLD,22));
		l1.setBounds(280, 50, 400, 40);
		add(l1);
		
		l2=new JLabel("Account Type: ");
		l2.setFont(new Font("Raleway",Font.BOLD,18));
		l2.setBounds(100, 140, 200, 30);
		add(l2);
		
		l3=new JLabel("Card no: ");
		l3.setFont(new Font("Raleway",Font.BOLD,18));
		l3.setBounds(100, 300, 200, 30);
		add(l3);
		
		l4=new JLabel("XXXX-XXXX-XXXX-4184: ");
		l4.setFont(new Font("Raleway",Font.BOLD,18));
		l4.setBounds(330, 300, 250, 30);
		add(l4);
		
		l5=new JLabel("(Your 16-digit Card No: )");
		l5.setFont(new Font("Raleway",Font.BOLD,12));
		l5.setBounds(100, 320, 200, 30);
		add(l5);
		
		l6=new JLabel("(It would appear on ATM card/Cheque: )");
		l6.setFont(new Font("Raleway",Font.BOLD,12));
		l6.setBounds(330, 320, 500, 30);
		add(l6);
		
		l7=new JLabel("PIN: ");
		l7.setFont(new Font("Raleway",Font.BOLD,20));
		l7.setBounds(100, 370, 200, 30);
		add(l7);
		
		l8=new JLabel("XXXX");
		l8.setFont(new Font("Raleway",Font.BOLD,22));
		l8.setBounds(330, 370, 200, 30);
		add(l8);
		
		l9=new JLabel("(4-digit password)");
		l9.setFont(new Font("Raleway",Font.BOLD,12));
		l9.setBounds(100, 400, 200, 30);
		add(l9);
		
		l10=new JLabel("Services Required: ");
		l10.setFont(new Font("Raleway",Font.BOLD,20));
		l10.setBounds(100, 450, 200, 30);
		add(l10);
		
		l11=new JLabel("Form no: ");
		l11.setFont(new Font("Raleway",Font.BOLD,20));
		l11.setBounds(680, 10, 240, 30);
		add(l11);
		
		l12=new JLabel(formno);
		l12.setFont(new Font("Raleway",Font.BOLD,20));
		l12.setBounds(770, 10, 40, 30);
		add(l12);
		
//		Button
		b1=new JButton("SUBMIT");
		b1.setBackground(Color.cyan);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Raleway",Font.BOLD,14));
		b1.setBounds(250, 720, 100, 30);
		add(b1);
		b1.addActionListener(this);
		
		
		b2=new JButton("CANCEL");
		b2.setBackground(Color.cyan);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Raleway",Font.BOLD,14));
		b2.setBounds(420, 720, 100, 30);
		add(b2);
		b2.addActionListener(this);

//		Combo
		c1=new JCheckBox("ATM CARD");
		c1.setBackground(Color.WHITE);
		c1.setFont(new Font("Raleway",Font.BOLD,14));
		c1.setBounds(100, 500, 200, 30);
		add(c1);
		
		c2=new JCheckBox("Internet Banking");
		c2.setBackground(Color.WHITE);
		c2.setFont(new Font("Raleway",Font.BOLD,14));
		c2.setBounds(350, 500, 200, 30);
		add(c2);
		
		c3=new JCheckBox("Mobile Banking");
		c3.setBackground(Color.WHITE);	
		c3.setFont(new Font("Raleway",Font.BOLD,14));
		c3.setBounds(100, 550, 200, 30);
		add(c3);
		
		c4=new JCheckBox("Email Alert");
		c4.setBackground(Color.WHITE);
		c4.setFont(new Font("Raleway",Font.BOLD,14));
		c4.setBounds(350, 550, 200, 30);
		add(c4);
		
		c5=new JCheckBox("Cheque Book");
		c5.setBackground(Color.WHITE);
		c5.setFont(new Font("Raleway",Font.BOLD,14));
		c5.setBounds(100, 600, 200, 30);
		add(c5);
		
		c6=new JCheckBox("E=Statement");
		c6.setBackground(Color.WHITE);
		c6.setFont(new Font("Raleway",Font.BOLD,14));
		c6.setBounds(350, 600, 200, 30);
		add(c6);
		
		c7=new JCheckBox("I hereby declares that the above entered details is correct to the best of my knowledge.",true);
		c7.setBackground(Color.WHITE);
		c7.setFont(new Font("Raleway",Font.BOLD,12));
		c7.setBounds(100, 680, 600, 20);
		add(c7);

//		Radio Button
		r1=new JRadioButton("Savings Account");
		r1.setBackground(Color.cyan);
		r1.setFont(new Font("Raleway",Font.BOLD,16));
		r1.setBounds(100, 180, 200, 30);
		add(r1);
		
		r2=new JRadioButton("Fixed Deposite Account");
		r2.setBackground(Color.cyan);
		r2.setFont(new Font("Raleway",Font.BOLD,16));
		r2.setBounds(350, 180, 250, 30);
		add(r2);
		
		r3=new JRadioButton("Current Acount");
		r3.setBackground(Color.cyan);
		r3.setFont(new Font("Raleway",Font.BOLD,16));
		r3.setBounds(100, 220, 200, 30);
		add(r3);
		
		r4=new JRadioButton("Recurring Deposit Amount");
		r4.setBackground(Color.cyan);
		r4.setFont(new Font("Raleway",Font.BOLD,16));
		r4.setBounds(350, 220, 250, 30);
		add(r4);
		
//		Either select r1 or r2 or r5, try hidding below Buttongroup method
		ButtonGroup bg1=new ButtonGroup();
		bg1.add(r1);
		bg1.add(r2);
		bg1.add(r3);
		bg1.add(r4);
		
//		t1=new JTextField();
//		t1.setFont(new Font("Raleway",Font.BOLD,12));
//		t1.setBounds(770, 10, 40, 30);
//		add(t1);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(850,800);
		setLocation(400,30);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		String account_type=null;
		if(r1.isSelected())
		{
			account_type="Saving Account";
		}
		else if(r2.isSelected())
		{
			account_type="Fixed Deposit Account";
		}
		else if(r3.isSelected())
		{
			account_type="Current Account";
		}
		else if(r4.isSelected())
		{
			account_type="Recurring Deposit Amount";
		}
		
		Random ran=new Random();
		long first7=(ran.nextLong()%90000000L)+504036900000000L;
		String cardno=""+Math.abs(first7);
		
		long first3=(ran.nextLong()%9000L)+1000L;
		String pin=""+Math.abs(first3);
		
		String facility="";
		if(c1.isSelected())
		{
			facility+="ATM Card";
		}
		if(c2.isSelected())
		{
			facility+=" Internet Banking";
		}
		if(c3.isSelected())
		{
			facility+=" Mobile Banking";
		}
		if(c4.isSelected())
		{
			facility+=" Email Alert";
		}
		if(c5.isSelected())
		{
			facility+=" Cheque Book";
		}
		if(c6.isSelected())
		{
			facility+=" E-Statement";
		}
		
//		String c=t1.getText();
		
		try
		{
			if(ae.getSource()==b1)
			{
				if(facility.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Fill all details");
				}
				else
				{
					Connectionset c1=new Connectionset();
					String q1="insert into signup3 values('"+formno+"','"+account_type+"','"+cardno+"','"+pin+"','"+facility+"')";
					String q2="insert into login values('"+formno+"','"+cardno+"','"+pin+"')";
					c1.s.executeUpdate(q1);
					c1.s.executeUpdate(q2);
					
					JOptionPane.showMessageDialog(null, "Card Number: "+cardno+"\n Pin: "+pin);
					
					new Deposit(pin).setVisible(true);
					setVisible(false);
				}
			}
			else if(ae.getSource()==b2)
			{
				System.exit(0);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		new Signup3("").setVisible(true);
	}
}
