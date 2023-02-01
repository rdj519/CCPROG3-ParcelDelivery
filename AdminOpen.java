/** The class AdminOpen acts as a gateway or portal to different admin
 *  features of the program. 
 *  
 *  @author Reynaldo K. Delima and Nilo Cantil K. Jatico II S11A
 *  @version 1.00
 */


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


public class AdminOpen extends JFrame implements ActionListener
{
	/* Attributes */
	
	private JPasswordField txtPass;			/* JPasswordField: Admin password textbox */ 
	private JButton btnOkReport;			/* JButton: OK button */
	private JButton btnOkExit;				/* JButton: Exit button */
	
	/* Constructor */
	
	/** This constructor creates the application.
	 *
	 */
	
	public AdminOpen()
	{
		initialize();
	}
	
	/* Methods */
	
	/** This method initialize the contents of the frame.
	 *
	 */
	
	private void initialize()
	{
		setBounds(100, 100, 292, 125);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblEnterAdminPassword = new JLabel("Enter Admin Password");			/* Note: Local variable to label - Enter Admin Password */
		lblEnterAdminPassword.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));	
		lblEnterAdminPassword.setBounds(12, 13, 186, 29);
		getContentPane().add(lblEnterAdminPassword);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(12, 43, 146, 22);
		getContentPane().add(txtPass);
		txtPass.setColumns(15);
			
		/* Note: Adds a window listener - when x is clicked, it will reset password text */
		addWindowListener(new java.awt.event.WindowAdapter(){
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				txtPass.setText("");
			  }
		});
	}
	
	/** This method performs when different actions are made. It highly
	 *  depends on whether the admin wants to go to report or exit program.
	 * 
	 *  @param controller JMController 
	 *  @param s String variable on different options
	 */
	
	public void perform(JMController controller, String s)
	{
		if(s.equals("report")) /* When admin wants to see the report generation */
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
						/* Note: Checks if the password matches */
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
		else if(s.equalsIgnoreCase("exit")) /* Note: If user wants to exit program but requires admin supervision */
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
							/* Note: Check if password is valid */
							boolean bPassMatch = true;
							int i;
							char[] pass = new char[controller.getPassKey().length()]; 
							pass = txtPass.getPassword();				
							for(i=0; i < controller.getPassKey().length(); i++)
								if(pass[i] != controller.getPassKey().charAt(i))
									bPassMatch = false;
							if(bPassMatch)
								{
								JOptionPane.showMessageDialog(null, "Successfully exited the program.");
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
	
	/** This method is for allowing the user/admin to do actions and let a new window display
	 * 
	 */
	
	public void open(JMController controller, String s)
	{
		
		perform(controller, s);
		setVisible(true);
	}
	
	/** This method is solely purposed for the ActionEvent.
	 *  
	 *  @param e ActionEvent in order for the program to react to actions
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

}
