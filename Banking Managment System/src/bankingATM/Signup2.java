package bankingATM;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Signup2 extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
	JTextField t1,t2,t3;
	JRadioButton r1,r2,r3,r4;
	JButton b;
	JComboBox c1,c2,c3,c4,c5;
	String formno;
	
	Signup2(String formno)
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
			l11.setBounds(150, 0, 100, 100);
			add(l11);

		}
		catch(Exception a)
		{
			a.printStackTrace();
		}
		
//		Labels
		l1=new JLabel("PAGE 2: ADDITIONAL DETAILS");
		l1.setFont(new Font("Raleway",Font.BOLD,22));
		l1.setBounds(280, 30, 600, 40);
		add(l1);
		
		l2=new JLabel("Religion: ");
		l2.setFont(new Font("Raleway",Font.BOLD,18));
		l2.setBounds(100, 120, 100, 30);
		add(l2);
		
		l3=new JLabel("Category: ");
		l3.setFont(new Font("Raleway",Font.BOLD,18));
		l3.setBounds(100, 170, 100, 30);
		add(l3);
		
		l4=new JLabel("Income: ");
		l4.setFont(new Font("Raleway",Font.BOLD,18));
		l4.setBounds(100, 220, 100, 30);
		add(l4);
		
		l5=new JLabel("Education ");
		l5.setFont(new Font("Raleway",Font.BOLD,20));
		l5.setBounds(100, 270, 250, 30);
		add(l5);
		
		l6=new JLabel("Occupation: ");
		l6.setFont(new Font("Raleway",Font.BOLD,20));
		l6.setBounds(100, 340, 150, 30);
		add(l6);
		
		l7=new JLabel("PAN Number: ");
		l7.setFont(new Font("Raleway",Font.BOLD,20));
		l7.setBounds(100, 390, 150, 30);
		add(l7);
		
		l8=new JLabel("Adhar Number: ");
		l8.setFont(new Font("Raleway",Font.BOLD,22));
		l8.setBounds(100, 440, 180, 30);
		add(l8);
		
		l9=new JLabel("Senior Citizen: ");
		l9.setFont(new Font("Raleway",Font.BOLD,20));
		l9.setBounds(100, 490, 150, 30);
		add(l9);
		
		l10=new JLabel("Existing Account: ");
		l10.setFont(new Font("Raleway",Font.BOLD,20));
		l10.setBounds(100, 540, 200, 30);
		add(l10);
		
		l11=new JLabel("Qualification: ");
		l11.setFont(new Font("Raleway",Font.BOLD,20));
		l11.setBounds(100, 295, 150, 30);
		add(l11);
		
		l12=new JLabel("Form No: ");
		l12.setFont(new Font("Raleway",Font.BOLD,20));
		l12.setBounds(630, 10, 120, 30);
		add(l12);
		
		l13=new JLabel(formno);
		l13.setFont(new Font("Raleway",Font.BOLD,20));
		l13.setBounds(720, 10, 60, 30);
		add(l13);
		
//		Button
		b=new JButton("Next");
		b.setBackground(Color.cyan);
		b.setForeground(Color.WHITE);
		b.setFont(new Font("Raleway",Font.BOLD,20));
		b.setBounds(570, 590, 100, 50);
		add(b);
		b.addActionListener(this);
		
//		TextFeilds
		t1=new JTextField();
		t1.setFont(new Font("Raleway",Font.BOLD,14));
		t1.setBounds(350, 390, 320, 30);
		add(t1);
		
		t2=new JTextField();
		t2.setFont(new Font("Raleway",Font.BOLD,14));
		t2.setBounds(350, 440, 320, 30);
		add(t2);
		
//		t3=new JTextField();
//		t3.setFont(new Font("Raleway",Font.BOLD,14));
//		t3.setBounds(720, 10, 60, 30);
//		add(t3);
		
//		Radio Button
		r1=new JRadioButton("Yes");
		r1.setBackground(Color.cyan);
		r1.setFont(new Font("Raleway",Font.BOLD,14));
		r1.setBounds(350, 490, 100, 30);
		add(r1);
		
		r2=new JRadioButton("No");
		r2.setBackground(Color.cyan);
		r2.setFont(new Font("Raleway",Font.BOLD,14));
		r2.setBounds(460, 490, 100, 30);
		add(r2);
		
//		Either select r1 or r2 or r5, try hidding below Buttongroup method
		ButtonGroup bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		
		r3=new JRadioButton("Yes");
		r3.setBackground(Color.cyan);
		r3.setFont(new Font("Raleway",Font.BOLD,14));
		r3.setBounds(350, 540, 100, 30);
		add(r3);
		
		r4=new JRadioButton("No");
		r4.setBackground(Color.cyan);
		r4.setFont(new Font("Raleway",Font.BOLD,14));
		r4.setBounds(460, 540, 100, 30);
		add(r4);
		
//		Either select r1 or r2 or r5, try hidding below Buttongroup method
		ButtonGroup bg1=new ButtonGroup();
		bg1.add(r3);
		bg1.add(r4);

		
//		Combo
		String religion[]= {"Hindu","Muslim","Sikh","Cristian","Other"};
		c1=new JComboBox(religion);
		c1.setBackground(Color.WHITE);
		c1.setBounds(350, 120, 320, 30);
		add(c1);
		
		String Category[]= {"General","OBC","SC","ST","Other"};
		c2=new JComboBox(Category);
		c2.setBackground(Color.WHITE);
		c2.setBounds(350, 170, 320, 30);
		add(c2);
		
		String income[]= {"NULL","<1,50,000","<2,50,000","<5,00,000",">=5,00,000"};
		c3=new JComboBox(income);
		c3.setBackground(Color.WHITE);
		c3.setBounds(350, 220, 320, 30);
		add(c3);
		
		String education[]= {"Non-Graduated","Graduated","PG","Phd","Other"};
		c4=new JComboBox(education);
		c4.setBackground(Color.WHITE);
		c4.setBounds(350, 270, 320, 30);
		add(c4);
		
		String Ocupation[]= {"Salaried","Self-Employed","Bussiness","Student","Other"};
		c5=new JComboBox(Ocupation);
		c5.setBackground(Color.WHITE);
		c5.setBounds(350, 340, 320, 30);
		add(c5);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(850,710);
		setLocation(400,60);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		String religion =(String)c1.getSelectedItem();
		String category =(String)c2.getSelectedItem();
		String income =(String)c3.getSelectedItem();
		String education =(String)c4.getSelectedItem();
		String occupation =(String)c5.getSelectedItem();
		
		String pan=t1.getText();
		String adhar=t2.getText();
		
		String scitizen="";
		
		if(r1.isSelected())
		{
			scitizen="Yes";
		}
		else if(r2.isSelected())
		{
			scitizen="No";
		}
		
		String eaccount="";
		if(r3.isSelected())
		{
			eaccount="Yes";
		}
		else if(r4.isSelected())
		{
			eaccount="No";
		}
		
//		String j=t3.getText();
		
		try
		{
			if(t2.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Fill all details");
			}
			else
			{
				Connectionset c1=new Connectionset();
				String q1="insert into signup2 values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+adhar+"','"+scitizen+"','"+eaccount+"')";
				c1.s.executeUpdate(q1);
				
				new Signup3(formno).setVisible(true);
				setVisible(false);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		new Signup2("").setVisible(true);
		
	}

}
