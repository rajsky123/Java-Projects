import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Point;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;


public class Calulator {

	private JFrame frmCalulator;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JButton btnNewButton,btnNewButton_1,button,button_1,button_2,button_3,button_4,
	button_5,button_6,button_7,button_8,button_9,button_10,button_11,button_12,button_13,button_14,button_15;
	String s[];
	double ans,num;
	int cal,cnt=0,cnt1=0;

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
	IllegalAccessException, UnsupportedLookAndFeelException {
		
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calulator window = new Calulator();
					window.frmCalulator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calulator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void arithmetic_op()
	{   
		switch (cal) {
		
		case 1:ans=num + Double.parseDouble(textField.getText());
		      s= Double.toString(ans).split("\\.");
		 
	       if(s[s.length-1].equals("0"))
		      textField.setText(Integer.toString((int)ans));
	       else
	    	   textField.setText(Double.toString(ans));
			   break;

		case 2:ans=num - Double.parseDouble(textField.getText());
		    s= Double.toString(ans).split("\\.");
		 
	       if(s[s.length-1].equals("0"))
		      textField.setText(Integer.toString((int)ans));
	       else
	    	   textField.setText(Double.toString(ans));
			   break;
		   
		case 3:ans=num * Double.parseDouble(textField.getText());
		s= Double.toString(ans).split("\\.");
		 
	       if(s[s.length-1].equals("0"))
		      textField.setText(Integer.toString((int)ans));
	       else
	    	   textField.setText(Double.toString(ans));
			   break;  
		   
		case 4:
			if(Double.parseDouble(textField.getText())!=0)
			{
			ans=num / Double.parseDouble(textField.getText());
		    s= Double.toString(ans).split("\\.");
		 
	       if(s[s.length-1].equals("0"))
		      textField.setText(Integer.toString((int)ans));
	       else
	    	   textField.setText(Double.toString(ans));
			   break;  
			}
			else {
				textField.setText("can't divide by zero");
				cnt=1;
			}
		}
		
	}
	
	private void initialize() {
		frmCalulator = new JFrame();
		frmCalulator.setResizable(false);
		frmCalulator.setForeground(Color.WHITE);
		frmCalulator.setTitle("Calculator");
		frmCalulator.setLocation(new Point(500, 250));
		frmCalulator.setAlwaysOnTop(true);
		frmCalulator.setType(Type.UTILITY);
		frmCalulator.setBounds(100, 100, 330, 355);
		frmCalulator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalulator.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBackground(Color.WHITE);
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Tahoma", Font.BOLD, 22));
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBounds(10, 30, 305, 47);
		frmCalulator.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("backspace");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cnt==0 && textField.getText().length()!=0) {
				int length=textField.getText().length();
				int number=textField.getText().length()-1;
				int length1=lblNewLabel.getText().length();
				int number1=lblNewLabel.getText().length()-1;
				String store;
				
				if(length>0)
				{
					StringBuilder back=new StringBuilder(textField.getText());
					back.deleteCharAt(number);
					store=back.toString();
					textField.setText(store);
					StringBuilder back1=new StringBuilder(lblNewLabel.getText());
					back1.deleteCharAt(number1);
					store=back1.toString();
					lblNewLabel.setText(store); 
					
				}
				}
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnNewButton.setBounds(10, 103, 149, 31);
		frmCalulator.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				textField.setText("");
				lblNewLabel.setText("");
				cnt=0;
			    cnt1=1;
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnNewButton_1.setBounds(169, 103, 68, 31);
		frmCalulator.getContentPane().add(btnNewButton_1);
		
		button = new JButton("7");
		button.setFont(new Font("Arial Black", Font.BOLD, 15));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cnt==0)
				{   
					textField.setText(textField.getText()+"7");
					lblNewLabel.setText(lblNewLabel.getText()+"7");
					
				}
			}
		});
		button.setBounds(10, 145, 71, 31);
		frmCalulator.getContentPane().add(button);
		
		button_1 = new JButton("8");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cnt==0)
				{
					textField.setText(textField.getText()+"8");
					lblNewLabel.setText(lblNewLabel.getText()+"8");
				}
			}
		});
		button_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		button_1.setBounds(91, 145, 68, 31);
		frmCalulator.getContentPane().add(button_1);
		
		button_2 = new JButton("9");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cnt==0)
				{
					textField.setText(textField.getText()+"9");
					lblNewLabel.setText(lblNewLabel.getText()+"9");
				}
			}
		});
		button_2.setFont(new Font("Arial Black", Font.BOLD, 15));
		button_2.setBounds(169, 145, 68, 31);
		frmCalulator.getContentPane().add(button_2);
		
		button_3 = new JButton("-");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cnt==0 && cnt1==0) { 
					arithmetic_op();
					num=Double.parseDouble(textField.getText());
					
					String tt=textField.getText();
					cal=2;
					textField.setText("");
					lblNewLabel.setText(tt+"-");
					}
					else
						{
							num=Double.parseDouble(textField.getText());
							cnt1=0;
							String tt=textField.getText();
							cal=2;
							textField.setText("");
							lblNewLabel.setText(tt+"-");
							cnt=0;
							}
				}});
		button_3.setFont(new Font("Arial Black", Font.BOLD, 15));
		button_3.setBounds(247, 145, 68, 31);
		frmCalulator.getContentPane().add(button_3);
		
		button_4 = new JButton("4");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cnt==0) 
				{
					textField.setText(textField.getText()+"4");
					lblNewLabel.setText(lblNewLabel.getText()+"4");
				}
			}
		});
		button_4.setFont(new Font("Arial Black", Font.BOLD, 15));
		button_4.setBounds(10, 187, 71, 31);
		frmCalulator.getContentPane().add(button_4);
		
		button_5 = new JButton("5");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cnt==0) 
				{
					textField.setText(textField.getText()+"5");
					lblNewLabel.setText(lblNewLabel.getText()+"5");
				}
			}
		});
		button_5.setFont(new Font("Arial Black", Font.BOLD, 15));
		button_5.setBounds(91, 187, 68, 31);
		frmCalulator.getContentPane().add(button_5);
		
	    button_6 = new JButton("6");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cnt==0) 
				{
					textField.setText(textField.getText()+"6");
					lblNewLabel.setText(lblNewLabel.getText()+"6");
				}
			}
		});
		button_6.setFont(new Font("Arial Black", Font.BOLD, 15));
		button_6.setBounds(169, 187, 68, 31);
		frmCalulator.getContentPane().add(button_6);
		
		button_7 = new JButton("*");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cnt==0 && cnt1==0) { 
					arithmetic_op();
					num=Double.parseDouble(textField.getText());
					
					String tt=textField.getText();
					cal=3;
					textField.setText("");
					lblNewLabel.setText(tt+"*");
					}
					else
						{
							
							num=Double.parseDouble(textField.getText());
							cnt1=0;
							String tt=textField.getText();
							cal=3;
							textField.setText("");
							lblNewLabel.setText(tt+"*");
							cnt=0;
							}
				}});
		button_7.setFont(new Font("Arial Black", Font.BOLD, 15));
		button_7.setBounds(247, 187, 68, 31);
		frmCalulator.getContentPane().add(button_7);
		
		button_8 = new JButton("1");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cnt==0) 
				{
					textField.setText(textField.getText()+"1");
					lblNewLabel.setText(lblNewLabel.getText()+"1");
				}
			}
		});
		button_8.setFont(new Font("Arial Black", Font.BOLD, 15));
		button_8.setBounds(10, 229, 71, 31);
		frmCalulator.getContentPane().add(button_8);
		
		button_9 = new JButton("2");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cnt==0) 
				{
					textField.setText(textField.getText()+"2");
					lblNewLabel.setText(lblNewLabel.getText()+"2");
				}
			}
		});
		button_9.setFont(new Font("Arial Black", Font.BOLD, 15));
		button_9.setBounds(91, 229, 68, 31);
		frmCalulator.getContentPane().add(button_9);
		
		button_10 = new JButton("3");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cnt==0 )
				{
					textField.setText(textField.getText()+"3");
					lblNewLabel.setText(lblNewLabel.getText()+"3");
				}
			}
		});
		button_10.setFont(new Font("Arial Black", Font.BOLD, 15));
		button_10.setBounds(169, 229, 68, 31);
		frmCalulator.getContentPane().add(button_10);
		
		button_11 = new JButton("/");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cnt==0 && cnt1==0) { 
					arithmetic_op();
					num=Double.parseDouble(textField.getText());
					
					String tt=textField.getText();
					cal=4;
					textField.setText("");
					lblNewLabel.setText(tt+"/");
					}
				else
					 {
							
							num=Double.parseDouble(textField.getText());
							cnt1=0;
							String tt=textField.getText();
							cal=4;
							textField.setText("");
							lblNewLabel.setText(tt+"/");
							cnt=0;
							}
				}});
		button_11.setFont(new Font("Arial", Font.BOLD, 15));
		button_11.setBounds(247, 229, 68, 31);
		frmCalulator.getContentPane().add(button_11);
		
		button_12 = new JButton("0");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cnt==0) 
					 {
					textField.setText(textField.getText()+"0");
					lblNewLabel.setText(lblNewLabel.getText()+"0");
				    }
			}
		});
		button_12.setFont(new Font("Arial Black", Font.BOLD, 15));
		button_12.setBounds(10, 271, 71, 34);
		frmCalulator.getContentPane().add(button_12);
		
		button_13 = new JButton(".");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String temp=textField.getText();
				if(temp.indexOf(".")==-1)
				{
				if(cnt==0) 
				{
					textField.setText(textField.getText()+".");
					lblNewLabel.setText(lblNewLabel.getText()+".");
				}
				}
			}
		});
		button_13.setFont(new Font("Arial Black", Font.BOLD, 15));
		button_13.setBounds(91, 271, 68, 34);
		frmCalulator.getContentPane().add(button_13);
		
		button_14 = new JButton("=");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				arithmetic_op();
				lblNewLabel.setText("");
				cnt=1;
			}
		});
		button_14.setFont(new Font("Arial Black", Font.BOLD, 15));
		button_14.setBounds(169, 271, 146, 34);
		frmCalulator.getContentPane().add(button_14);
		
		button_15 = new JButton("+");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cnt==0 && cnt1==0) { 
				arithmetic_op();
				num=Double.parseDouble(textField.getText());
				

				String tt=textField.getText();
				cal=1;
				
				textField.setText("");
				lblNewLabel.setText(tt+"+");
				}
				else
					{
						
						num=Double.parseDouble(textField.getText());
						cnt1=0;
						String tt=textField.getText();
						cal=1;
						textField.setText("");
						lblNewLabel.setText(tt+"+");
						cnt=0;
						}
			}});
		button_15.setFont(new Font("Arial Black", Font.BOLD, 15));
		button_15.setBounds(247, 103, 68, 31);
		frmCalulator.getContentPane().add(button_15);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(225, 13, 90, 21);
		frmCalulator.getContentPane().add(lblNewLabel);
	}
}
