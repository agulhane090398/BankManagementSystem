package bankingATM;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Date;
import java.sql.*;

import javax.swing.*;


public class FastCash extends JFrame implements ActionListener
{
	JLabel l1,l2;
	JButton b1,b2,b3,b4,b5,b6,b7,b8;
	JTextField t1;
	String pin;
	
	FastCash(String pin)
	{
		this.pin=pin;
		setLayout(null);
		
//		setFont(new Font("System",Font.BOLD,22));
//		Font f=getFont();
//		FontMetrics fm = getFontMetrics(f);
//		int x=fm.stringWidth("FASTCASH");
//		int y=fm.stringWidth(" ");
//		int z=getWidth()-x;
//		int w=z/y;
//		String pad="";
//		
//		//for (int i=0;i!=w; i++) pad+=" ";
//		pad=String.format("%"+w+"s",pad);
//		setTitle(pad+"Fast Cash");
		setTitle("Fast Cash");
		

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
		l1=new JLabel("Select withdrawal amount:");
		l1.setFont(new Font("Raleway",Font.BOLD,12));
		l1.setBounds(180, 260, 700, 30);
		l11.add(l1);
		
//		l2=new JLabel("Enter PIN: ");
//		l2.setFont(new Font("Raleway",Font.BOLD,12));
//		l2.setBounds(590, 10, 100, 40);
//		l11.add(l2);
//	
////		TextFeilds
//		t1=new JTextField();
//		t1.setFont(new Font("Raleway",Font.BOLD,12));
//		t1.setBounds(700, 10, 60, 40);
//		l11.add(t1);
		
//		BUTTON
		b1=new JButton("RS 100");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Raleway",Font.BOLD,10));
		b1.setBounds(116, 382, 140, 20);
		l11.add(b1);
		b1.addActionListener(this);
		
		b2=new JButton("Rs 500");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Raleway",Font.BOLD,10));
		b2.setBounds(260, 382, 140, 20);
		l11.add(b2);
		b2.addActionListener(this);
		
		b3=new JButton("Rs 1000");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setFont(new Font("Raleway",Font.BOLD,10));
		b3.setBounds(116, 415, 140, 20);
		l11.add(b3);
		b3.addActionListener(this);
		
		b4=new JButton("Rs 2000");
		b4.setBackground(Color.BLACK);
		b4.setForeground(Color.WHITE);
		b4.setFont(new Font("Raleway",Font.BOLD,10));
		b4.setBounds(260, 415, 140, 20);
		l11.add(b4);
		b4.addActionListener(this);
		
		b5=new JButton("Rs 5000");
		b5.setBackground(Color.BLACK);
		b5.setForeground(Color.WHITE);
		b5.setFont(new Font("Raleway",Font.BOLD,10));
		b5.setBounds(116, 447, 140, 20);
		l11.add(b5);
		b5.addActionListener(this);
		
		b6=new JButton("Rs 10000");
		b6.setBackground(Color.BLACK);
		b6.setForeground(Color.WHITE);
		b6.setFont(new Font("Raleway",Font.BOLD,10));
		b6.setBounds(260, 447, 140, 20);
		l11.add(b6);
		b6.addActionListener(this);
		
		b7=new JButton("BACK");
		b7.setBackground(Color.BLACK);
		b7.setForeground(Color.WHITE);
		b7.setFont(new Font("Raleway",Font.BOLD,16));
		b7.setBounds(116, 480, 140, 20);
		l11.add(b7);
		b7.addActionListener(this);
		
//		b8=new JButton("EXIT");
//		b8.setBackground(Color.BLACK);
//		b8.setForeground(Color.WHITE);
//		b8.setFont(new Font("Raleway",Font.BOLD,16));
//		b8.setBounds(260, 480, 140, 20);
//		l11.add(b8);
//		b8.addActionListener(this);
		
//		getContentPane().setBackground(Color.WHITE);
		setSize(690,820);
		setLocation(500,0);
		setVisible(true);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		try
		{
			String amount=((JButton)e.getSource()).getText().substring(3);
			
			Connectionset c=new Connectionset();
			
			ResultSet rs=c.s.executeQuery("SELECT * FROM BANK WHERE PIN='"+pin+"'");
			
			int balance=0;
			while(rs.next())
			{
//				System.out.println("in While");
				if(rs.getString("mode").equals("Deposit"))
				{
					balance+=Integer.parseInt(rs.getString("amount"));
//					System.out.println(balance);
				}
				else
				{
					balance-=Integer.parseInt(rs.getString("amount"));							
					System.out.println(balance);
				}
			}
			if(balance<Integer.parseInt(amount)) 
			{
				JOptionPane.showMessageDialog(null, "Insufficient Balance");
				return;
			}
					
			
			
			if (e.getSource()==b7)
			{
				this.setVisible(true);
				new Transactions(pin).setVisible(true);
			}	
			else
			{
				Date date=new Date();
				String q1="insert into bank values('"+pin+"','"+date+"','Withdrawal','"+amount+"')";
				
				c.s.executeUpdate(q1);
				JOptionPane.showMessageDialog(null,"Rs. "+amount+"Debeted Successfully");
				
				setVisible(false);
				new Transactions(pin).setVisible(true);
				
				
				
			}
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new FastCash("").setVisible(true);
	}
}
