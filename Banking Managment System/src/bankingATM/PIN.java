package bankingATM;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.sql.*;

import javax.swing.*;


public class PIN extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4;
	JButton b1,b2;
	JPasswordField t1,t2,t3;
	String pin;
	
	PIN(String pin)
	{
		this.pin=pin;
		
		setLayout(null);
		
//		setFont(new Font("System",Font.BOLD,22));
//		Font f=getFont();
//		FontMetrics fm = getFontMetrics(f);
//		int x=fm.stringWidth("PIN CHANGE");
//		int y=fm.stringWidth(" ");
//		int z=getWidth()-x;
//		int w=z/y;
//		String pad="";
//		
//		//for (int i=0;i!=w; i++) pad+=" ";
//		pad=String.format("%"+w+"s",pad);
//		setTitle(pad+"Pin Change");
		setTitle("Pin Change");

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
		l1=new JLabel("Chanage your PIN");
		l1.setFont(new Font("Raleway",Font.BOLD,16));
		l1.setBounds(190, 270, 250, 30);
		l11.add(l1);
		
		l2=new JLabel("Current PIN: ");
		l2.setFont(new Font("Raleway",Font.BOLD,10));
		l2.setBounds(130, 310, 150, 40);
		l11.add(l2);
		
		l3=new JLabel("New PIN:");
		l3.setFont(new Font("Raleway",Font.BOLD,10));
		l3.setBounds(130, 340, 150, 40);
		l11.add(l3);
		
		l4=new JLabel("Re-Enter your new PIN:");
		l4.setFont(new Font("Raleway",Font.BOLD,10));
		l4.setBounds(130, 370, 200, 40);
		l11.add(l4);
		
//		TextFeilds
		t1=new JPasswordField();
		t1.setFont(new Font("Raleway",Font.BOLD,14));
		t1.setBounds(290, 320, 100, 20);
		add(t1);
		
		t2=new JPasswordField();
		t2.setFont(new Font("Raleway",Font.BOLD,14));
		t2.setBounds(290, 350, 100, 20);
		add(t2);
		
		t3=new JPasswordField();
		t3.setFont(new Font("Raleway",Font.BOLD,14));
		t3.setBounds(290, 380, 100, 20);
		add(t3);
		
//		BUTTON
		b1=new JButton("SAVE");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Raleway",Font.BOLD,14));
		b1.setBounds(290, 475, 100, 20);
		l11.add(b1);
		b1.addActionListener(this);
		
		b2=new JButton("BACK");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Raleway",Font.BOLD,14));
		b2.setBounds(130, 475, 100, 20);
		l11.add(b2);
		b2.addActionListener(this);
		
		getContentPane().setBackground(Color.WHITE);

		setSize(690,820);
		setLocation(500,0);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		try 
		{
			
			String npin=t2.getText();
			String rpin=t3.getText();
			
			if(e.getSource()==b1)
			{
				
				if(npin.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Fill the required Details");
					
				}
				if(rpin.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Fill the required Details");
					
				}
				if(npin.equals(rpin))
				{
					Connectionset c1=new Connectionset();
					
					String q1="update bank set pin='"+rpin+"' where pin='"+pin+"'";
					String q2="update login set pin='"+rpin+"' where pin='"+pin+"'";
					String q3="update signup3 set pin='"+rpin+"' where pin='"+pin+"'";
					
					c1.s.executeUpdate(q1);
					c1.s.executeUpdate(q2);
					c1.s.executeUpdate(q3);
					
					JOptionPane.showMessageDialog(null, "PIN changed successfully");
					
					setVisible(false);
					new Transactions(rpin).setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Enter same credentials");
				}
			}
			else if(e.getSource()==b2)
			{
				new Transactions(pin).setVisible(true);
				setVisible(false);
			}
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
			System.out.println("error: "+e1);
		}
	}
	
	public static void main(String[] args) {
		new PIN("").setVisible(true);
	}
}
