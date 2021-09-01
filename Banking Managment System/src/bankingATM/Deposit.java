package bankingATM;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;


public class Deposit extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,t2;
	JTextField t1,t3;
	JButton b1,b2,b3;
	String pin;
	Deposit(String pin)
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
		setTitle("Deposite");
		

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
		l1=new JLabel("Enter the amount you want");
		l1.setFont(new Font("Raleway",Font.BOLD,12));
		l1.setBounds(180, 260, 700, 30);
		l11.add(l1);
		
		l2=new JLabel("to Deposite: ");
		l2.setFont(new Font("Raleway",Font.BOLD,12));
		l2.setBounds(220, 280, 800, 30);
		l11.add(l2);
		
		l3=new JLabel("Pin:");
		l3.setFont(new Font("Raleway",Font.BOLD,14));
		l3.setBounds(300, 300, 80, 20);
		l11.add(l3);
		
//		TextFeilds
		t1=new JTextField();
		t1.setFont(new Font("Raleway",Font.BOLD,14));
		t1.setBounds(170, 330, 200, 25);
		l11.add(t1);
		
		t2=new JLabel(pin);
		t2.setFont(new Font("Raleway",Font.BOLD,10));
		t2.setBounds(350, 300, 40, 20);
		l11.add(t2);
		
//		BUTTON
		b1=new JButton("DEPOSIT");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Raleway",Font.BOLD,10));
		b1.setBounds(116, 382, 140, 20);
		l11.add(b1);
		b1.addActionListener(this);
		
		b2=new JButton("BACK");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Raleway",Font.BOLD,10));
		b2.setBounds(260, 382, 140, 20);
		l11.add(b2);
		b2.addActionListener(this);
		
//		b3=new JButton("EXIT");
//		b3.setBackground(Color.BLACK);
//		b3.setForeground(Color.WHITE);
//		b3.setFont(new Font("Raleway",Font.BOLD,14));
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
			String amount=t1.getText();
			Date date=new Date();
			
			if(e.getSource()==b1)
			{
				if(t1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Fill all required details");
				}
				else
				{
					Connectionset c=new Connectionset();
					c.s.executeUpdate("insert into bank values('"+pin+"','"+date+"','Deposit','"+amount+"')");
					
//					double balance=0;
//					if(rs.next())
//					{
//						String pin=rs.getString("pinn");
//						
//						balance=rs.getDouble("balance");
//						
//						double d=Double.parseDouble(a);
//						balance+=d;
//						String q1="insert into bak values('"+pin+"','"+d+"',null,'"+balance+"')";
//						
//						c.s.executeUpdate(q1);
//					}
					JOptionPane.showMessageDialog(null,"Rs. "+amount+"Deposited Successfully");
					
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
		new Deposit("").setVisible(true);
		
	}
}
