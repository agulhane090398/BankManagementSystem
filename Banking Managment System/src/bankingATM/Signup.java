package bankingATM;

import java.awt.event.*;
import java.util.Random;
import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

public class Signup extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JRadioButton r1,r2,r3,r4,r5;
	JButton b;
//	JComboBox c1,c2,c3;
	JDateChooser date;
	
	Random ran=new Random();
	long first4=(ran.nextLong()%9000L)+1000L;
	String first=""+Math.abs(first4);
	
	Signup()
	{
		setLayout(null);
		
//		setFont(new Font("System",Font.BOLD,22));
//		Font f=getFont();
//		FontMetrics fm = getFontMetrics(f);
//		int x=fm.stringWidth("NEW ACCOUNT APPLICATION FORM");
//		int y=fm.stringWidth(" ");
//		int z=getWidth()-x;
//		int w=z/y;
//		String pad="";
		
		//for (int i=0;i!=w; i++) pad+=" ";
//		pad=String.format("%"+w+"s",pad);
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
		l1=new JLabel("APPLICATION FORM NO. "+first);
		l1.setFont(new Font("Raleway",Font.BOLD,38));
		l1.setBounds(140, 20, 600, 40);
		add(l1);
		
		l2=new JLabel("PAGE 1: PERSONAL DETAILS ");
		l2.setFont(new Font("Raleway",Font.BOLD,22));
		l2.setBounds(290, 70, 600, 30);
		add(l2);
		
		l3=new JLabel("Name: ");
		l3.setFont(new Font("Raleway",Font.BOLD,20));
		l3.setBounds(100, 140, 100, 30);
		add(l3);
		
		l4=new JLabel("Father's Name: ");
		l4.setFont(new Font("Raleway",Font.BOLD,20));
		l4.setBounds(100, 190, 200, 30);
		add(l4);
		
		l5=new JLabel("Date of Birth: ");
		l5.setFont(new Font("Raleway",Font.BOLD,20));
		l5.setBounds(100, 240, 200, 30);
		add(l5);
		
		l6=new JLabel("Gender: ");
		l6.setFont(new Font("Raleway",Font.BOLD,20));
		l6.setBounds(100, 290, 200, 30);
		add(l6);
		
		l7=new JLabel("Email Address: ");
		l7.setFont(new Font("Raleway",Font.BOLD,20));
		l7.setBounds(100, 340, 200, 30);
		add(l7);
		
		l8=new JLabel("Marital Status: ");
		l8.setFont(new Font("Raleway",Font.BOLD,22));
		l8.setBounds(100, 390, 200, 30);
		add(l8);
		
		l9=new JLabel("Address: ");
		l9.setFont(new Font("Raleway",Font.BOLD,20));
		l9.setBounds(100, 440, 200, 30);
		add(l9);
		
		l10=new JLabel("City: ");
		l10.setFont(new Font("Raleway",Font.BOLD,20));
		l10.setBounds(100, 490, 200, 30);
		add(l10);
		
		l11=new JLabel("Pin Code: ");
		l11.setFont(new Font("Raleway",Font.BOLD,20));
		l11.setBounds(100, 540, 200, 30);
		add(l11);
		
		l12=new JLabel("State: ");
		l12.setFont(new Font("Raleway",Font.BOLD,20));
		l12.setBounds(100, 590, 200, 30);
		add(l12);
		
//		date
		date=new JDateChooser();
		date.setForeground(new Color(115,115,115));
		date.setBounds(300, 240, 400, 30);
		add(date);
		
//		OR
		
//		l13=new JLabel("Date: ");
//		l13.setFont(new Font("Raleway",Font.BOLD,14));
//		l13.setBounds(300, 240, 40, 30);
//		add(l13);
//		
//		l14=new JLabel("Month: ");
//		l14.setFont(new Font("Raleway",Font.BOLD,14));
//		l14.setBounds(410, 240, 50, 30);
//		add(l14);
//		
//		l15=new JLabel("Year: ");
//		l15.setFont(new Font("Raleway",Font.BOLD,14));
//		l15.setBounds(570, 240, 40, 30);
//		add(l15);
		
//		TextFeilds
		t1=new JTextField();
		t1.setFont(new Font("Raleway",Font.BOLD,14));
		t1.setBounds(300, 140, 400, 30);
		add(t1);
		
		t2=new JTextField();
		t2.setFont(new Font("Raleway",Font.BOLD,14));
		t2.setBounds(300, 190, 400, 30);
		add(t2);
		
		t3=new JTextField();
		t3.setFont(new Font("Raleway",Font.BOLD,14));
		t3.setBounds(300, 340, 400, 30);
		add(t3);
		
		t4=new JTextField();
		t4.setFont(new Font("Raleway",Font.BOLD,14));
		t4.setBounds(300, 440, 400, 30);
		add(t4);
		
		t5=new JTextField();
		t5.setFont(new Font("Raleway",Font.BOLD,14));
		t5.setBounds(300, 490, 400, 30);
		add(t5);
		
		t6=new JTextField();
		t6.setFont(new Font("Raleway",Font.BOLD,14));
		t6.setBounds(300, 540, 400, 30);
		add(t6);
		
		t7=new JTextField();
		t7.setFont(new Font("Raleway",Font.BOLD,14));
		t7.setBounds(300, 590, 400, 30);
		add(t7);
		
//		Button
		b=new JButton("Next");
		b.setBackground(Color.cyan);
		b.setFont(new Font("Raleway",Font.BOLD,14));
		b.setForeground(Color.WHITE);
		b.setBounds(620, 660, 80, 30);
		add(b);
		
		r1=new JRadioButton("Male");
		r1.setBackground(Color.cyan);
		r1.setFont(new Font("Raleway",Font.BOLD,14));
		r1.setBounds(300, 290, 60, 30);
		add(r1);
		
		r2=new JRadioButton("Female");
		r2.setBackground(Color.cyan);
		r2.setFont(new Font("Raleway",Font.BOLD,14));
		r2.setBounds(450, 290, 90, 30);
		add(r2);
		
		r5=new JRadioButton("Other");
		r5.setBackground(Color.cyan);
		r5.setFont(new Font("Raleway",Font.BOLD,14));
		r5.setBounds(620, 290, 80, 30);
		add(r5);
		
//		Either select r1 or r2 or r5, try hidding below Buttongroup method
		ButtonGroup bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		bg.add(r5);
		
		r3=new JRadioButton("Married");
		r3.setBackground(Color.cyan);
		r3.setFont(new Font("Raleway",Font.BOLD,14));
		r3.setBounds(300, 390, 100, 30);
		add(r3);
		
		r4=new JRadioButton("Unmarried");
		r4.setBackground(Color.cyan);
		r4.setFont(new Font("Raleway",Font.BOLD,14));
		r4.setBounds(450, 390, 100, 30);
		add(r4);
		
//		Either select r3 or r4, try hidding below Buttongroup method
		ButtonGroup bm=new ButtonGroup();
		bm.add(r3);
		bm.add(r4);
		
//		String date[]= {"1","2","3","4","5","6","7","8","9","10","11"};
//		c1=new JComboBox(date);
//		c1.setBackground(Color.WHITE);
//		c1.setBounds(340, 240, 60, 30);
//		add(c1);
//		
//		String month[]= {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEPT","OCT","NOV","DEC"};
//		c2=new JComboBox(month);
//		c2.setBackground(Color.WHITE);
//		c2.setBounds(460, 240, 100, 30);
//		add(c2);
//		
//		String year[]= {"1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001"};
//		c3=new JComboBox(year);
//		c3.setBackground(Color.WHITE);
//		c3.setBounds(610, 240, 90, 30);
//		add(c3);
//		
		
		b.addActionListener(this);
		
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(850,850);
		setLocation(500,90);
		setVisible(true);


	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		String formno=first;
		String name=t1.getText();
		String fathername=t2.getText();
		String dob=((JTextField)date.getDateEditor().getUiComponent()).getText();
		
//		String ac=(String)c1.getSelectedItem();
//		String bc=(String)c2.getSelectedItem();
//		String cc=(String)c3.getSelectedItem();
//		
		String gender=null;
		
		if(r1.isSelected())
		{
			gender="Male";
		}
		else if(r1.isSelected())
		{
			gender="Female";
		}
		
		String email=t3.getText();
		String marital=null;
		
		if(r3.isSelected())
		{
			marital="Married";
		}
		else if(r4.isSelected())
		{
			marital="Unmarried";
		}
		else if(r5.isSelected())
		{
			marital="Other";
		}
		
		String address=t4.getText();
		String city=t5.getText();
		String pincode=t6.getText();
		String state=t7.getText();
		
		try
		{
			if(t6.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Fill all the details");
			}
			else
			{
				Connectionset c1=new Connectionset();
				String q1="insert into signup values('"+formno+"','"+name+"','"+fathername+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
				c1.s.executeUpdate(q1);
				
				new Signup2(formno).setVisible(true);
				setVisible(false);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println("Error occured");
		}
		
	}
	
	public static void main(String[] args) {
		new Signup().setVisible(true);
	}

}
