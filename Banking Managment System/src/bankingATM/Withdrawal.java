package bankingATM;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;


public class Withdrawal extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4;
	JTextField t1,t2;
	JButton b1,b2,b3;
	String pin;
	
	Withdrawal(String pin)
	{
		this.pin=pin;
		setLayout(null);
		
//		setFont(new Font("System",Font.BOLD,22));
//		Font f=getFont();
//		FontMetrics fm = getFontMetrics(f);
//		int x=fm.stringWidth("DEPOSIT");
//		int y=fm.stringWidth(" ");
//		int z=getWidth()-x;
//		int w=z/y;
//		String pad="";
//		
//		//for (int i=0;i!=w; i++) pad+=" ";
//		pad=String.format("%"+w+"s",pad);
//		setTitle(pad+"Deposite");
		setTitle("Withdraw");
		
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
		l1=new JLabel("Maximum daily withdrawal is Rs. 10,000");
		l1.setFont(new Font("Raleway",Font.BOLD,12));
		l1.setBounds(140, 260, 700, 30);
		l11.add(l1);
		
//		l2=new JLabel("is Rs. 10,000");
//		l2.setFont(new Font("Raleway",Font.BOLD,12));
//		l2.setBounds(210, 275, 700, 30);
//		l11.add(l2);
		
		l3=new JLabel("Enter Amount");
		l3.setFont(new Font("Raleway",Font.BOLD,16));
		l3.setBounds(210, 290, 800, 25);
		l11.add(l3);
		
//		l4=new JLabel("Enter Pin");
//		l4.setFont(new Font("Raleway",Font.BOLD,12));
//		l4.setBounds(250, 360, 80, 20);
//		l11.add(l4);
		
//		TextFeilds
		t1=new JTextField();
		t1.setFont(new Font("Raleway",Font.BOLD,12));
		t1.setBounds(180, 320, 180, 20);
		l11.add(t1);
		
//		t2=new JTextField();
//		t2.setFont(new Font("Raleway",Font.BOLD,12));
//		t2.setBounds(320, 360, 40, 20);
//		l11.add(t2);
		
//		BUTTON
		b1=new JButton("WITHDRAW");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Raleway",Font.BOLD,10));
		b1.setBounds(260, 447, 140, 20);
		l11.add(b1);
		b1.addActionListener(this);
		
		b2=new JButton("BACK");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Raleway",Font.BOLD,10));
		b2.setBounds(116, 480, 140, 20);
		l11.add(b2);
		b2.addActionListener(this);
		
//		b3=new JButton("EXIT");
//		b3.setBackground(Color.BLACK);
//		b3.setForeground(Color.WHITE);
//		b3.setFont(new Font("Raleway",Font.BOLD,10));
//		b3.setBounds(260, 480, 140, 20);
//		l11.add(b3);
//		b3.addActionListener(this);
		
		getContentPane().setBackground(Color.white);
		
		setSize(690,820);
		setLocation(500,0);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		try
		{
			Date date=new Date();
			String amount=t1.getText();
//			String pin1=t2.getText();
			
			if(e.getSource()==b1)
			{
				if(t1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Fill all required details");
					
				}
				else
				{
					Connectionset c=new Connectionset();
					
					ResultSet rs=c.s.executeQuery("SELECT * FROM BANK WHERE PIN='"+pin+"'");
					
					int balance=0;
					while(rs.next())
					{
//						System.out.println("in While");
						if(rs.getString("mode").equals("Deposit"))
						{
							balance+=Integer.parseInt(rs.getString("amount"));
//							System.out.println(balance);
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
						
//						double d=Double.parseDouble(amount);
					String q1="insert into bank values('"+pin+"','"+date+"','Withdrawal','"+amount+"')";
						
					c.s.executeUpdate(q1);
					JOptionPane.showMessageDialog(null,"Rs. "+amount+"Debeted Successfully");
					
					setVisible(false);
					new Transactions(pin).setVisible(true);
				}
			}
			else if(e.getSource()==b2)
			{
				setVisible(false); 
				new Transactions(pin).setVisible(true);
			}
			
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
//			System.out.println("error: "+e1);
		}
	}
	
	public static void main(String[] args) {
		new Withdrawal("").setVisible(true);
		
	}
}
