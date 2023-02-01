import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;

/** this class acts as 
 * 
 * gateway/portal to different admin features of the program
 *
 */
public class AdminOpen extends JFrame implements ActionListener{

	private JPasswordField txtPass; 
	private JButton btnOkReport;
	private JButton btnOkExit;
	/**
	 * Create the application.
	 */
	public AdminOpen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 292, 125);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblEnterAdminPassword = new JLabel("Enter Admin Password");
		lblEnterAdminPassword.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblEnterAdminPassword.setBounds(12, 13, 186, 29);
		getContentPane().add(lblEnterAdminPassword);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(12, 43, 146, 22);
		getContentPane().add(txtPass);
		txtPass.setColumns(15);
			
		// adds a window listener so that when 'x' is clicked, it resets password text
		addWindowListener(new java.awt.event.WindowAdapter(){
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				txtPass.setText("");
			  }

		});
	}
	
	public void perform(JMController controller, String s)
	{
		
		if(s.equals("report"))
		{
		btnOkReport = new JButton("Ok");
		btnOkReport.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		btnOkReport.setBounds(170, 42, 97, 25);	
		btnOkReport.addActionListener(new ActionListener() 
		{
		
				@Override
				public void actionPerformed(ActionEvent e)
				{
					try {
						/* checks if the password is valid */
						boolean bPassMatch = true;
						int i;
						char[] pass = new char[controller.getPassKey().length()];
						pass = txtPass.getPassword();
						for(i=0; i < controller.getPassKey().length(); i++)
							if(pass[i] != controller.getPassKey().charAt(i))
								bPassMatch = false;
						txtPass.setText("");
						if(bPassMatch)
							{
								JOptionPane.showMessageDialog(null, "Successfully opened the generation report.");
								controller.getAdminReport().open();
								btnOkReport.setVisible(false);
								dispose(); 
							}
							else
								JOptionPane.showMessageDialog(null, "Incorrect input.");

						
						
						}
						
					
						catch(Exception exc)
						{
							JOptionPane.showMessageDialog(null, "Error\n Invalid/Missing input/s");
						
						}  
				}
		
			});
		getContentPane().add(btnOkReport); 
		}
		else if(s.equalsIgnoreCase("exit"))
		{
			btnOkExit = new JButton("Ok");
			btnOkExit.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
			btnOkExit.setBounds(170, 42, 97, 25);	
			btnOkExit.addActionListener(new ActionListener() 
			{
			
					@Override
					public void actionPerformed(ActionEvent e)
					{
						try {
							/* checks if the password is valid */
							boolean bPassMatch = true;
							int i;
							char[] pass = new char[controller.getPassKey().length()]; 
							pass = txtPass.getPassword();				
							for(i=0; i < controller.getPassKey().length(); i++)
								if(pass[i] != controller.getPassKey().charAt(i))
									bPassMatch = false;
							if(bPassMatch)
								{
								JOptionPane.showMessageDialog(null, "Successfully excited the program.");
								controller.getGui().exit();
								}
							else
								JOptionPane.showMessageDialog(null, "Incorrect input.");
												
							
							
							}
						
							catch(Exception exc)
							{
								JOptionPane.showMessageDialog(null, "Error\n Invalid/Missing input/s");
							
							}  
					}
			
				});
			getContentPane().add(btnOkExit);
		}
	}
	
	public void open(JMController controller, String s)
	{
		
		perform(controller, s);
		setVisible(true);
	}
	

	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

}
