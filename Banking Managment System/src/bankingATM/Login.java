package bankingATM;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
import javax.sql.*;

public class Login extends JFrame implements ActionListener
{
	JLabel l1,l2,l3;
	JTextField tf1;
	JPasswordField pf2;
	JButton b1,b2,b3;
	
	Login()
	{
		setLayout(null);
//		setFont(new Font("System",Font.BOLD,22));
//		Font f=getFont();
//		FontMetrics fm = getFontMetrics(f);
//		int x=fm.stringWidth("AUTOMATED TELLER MACHINE");
//		int y=fm.stringWidth(" ");
//		int z=getWidth()-x;
//		int w=z/y;
//		String pad="";
//		
//		//for (int i=0;i!=w; i++) pad+=" ";
//		pad=String.format("%"+w+"s",pad);
//		setTitle(pad+"AUTOMATED TELLER MACHINE");
		setTitle("AUTOMATED TELLER MACHINE");
		
//		try {
			ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("bankingATM/img/logo.JPG"));
			Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
			ImageIcon i3=new ImageIcon(i2);
			JLabel l11=new JLabel(i3);
			l11.setBounds(70, 0, 100, 100);
			add(l11);

//		}
//		catch(Exception a)
//		{
//			a.printStackTrace();
//		}
//		
//		Labels
		l1=new JLabel("Welcame to ATM");
		l1.setFont(new Font("Osward",Font.BOLD,38));
		
		l2=new JLabel("Card No: ");
		l2.setFont(new Font("Raleway",Font.BOLD,28));
		
		l3=new JLabel("PIN: ");
		l3.setFont(new Font("Raleway",Font.BOLD,28));
		
//		TextFeilds
		tf1=new JTextField(15);
		pf2=new JPasswordField(15);
		
//		Button
		b1=new JButton("SIGN IN");
		b1.setBackground(Color.cyan);
		b1.setForeground(Color.WHITE);
		
		b2=new JButton("CLEAR");
		b2.setBackground(Color.cyan);
		b2.setForeground(Color.WHITE);

		b3=new JButton("SIGN UP");
		b3.setBackground(Color.cyan);
		b3.setForeground(Color.WHITE);
		
//		Coordinate position of all types of labels
		
		l1.setBounds(175, -35, 450, 200);
		add(l1);
		
		l2.setBounds(125, 70, 375, 200);		
		add(l2);
		
		l3.setBounds(125, 120, 375, 200);
		add(l3);
		
		tf1.setFont(new Font("Arial",Font.BOLD,14));
		tf1.setBounds(300, 160, 230, 30);
		add(tf1);
		
		pf2.setFont(new Font("Arial",Font.BOLD,14));
		pf2.setBounds(300, 210, 230, 30);
		add(pf2);
		
		b1.setFont(new Font("Arial",Font.BOLD,14));
		b1.setBounds(300, 270, 100, 30);
		add(b1);
		
		b2.setFont(new Font("Arial",Font.BOLD,14));
		b2.setBounds(430, 270, 100, 30);
		add(b2);
		
		b3.setFont(new Font("Arial",Font.BOLD,14));
		b3.setBounds(300, 320, 230, 30);
		add(b3);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(600,450);
		setLocation(400,120);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
		try
		{
			Connectionset c=new Connectionset();
			String cardno=tf1.getText();
			String pin=pf2.getText();
			String query="select * from login where cardno = '"+cardno+"' and pin = '"+pin+"'";
			ResultSet rs=c.s.executeQuery(query);	//to retrive any data form sql
			
			if(e.getSource()==b1)
			{
				if(rs.next())
				{
					setVisible(false);
					new Transactions(pin).setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Incorrect username or password");
				}
			}
			else if(e.getSource()==b2)
			{
				tf1.setText("");
				pf2.setText("");
			}
			else if(e.getSource()==b3)
			{
				setVisible(false);
				new Signup().setVisible(true);
			}
		}
		catch(Exception ea)
		{
			ea.printStackTrace();
			System.out.println("error: "+e);
		}
		
	}
	
	public static void main(String[] args) 
	{
		new Login().setVisible(true);
	}
	
}
