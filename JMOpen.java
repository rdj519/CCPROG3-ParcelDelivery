/** The class JMOpen is responsible as an opening window. It
 *  will greet the user and will ask for his/her name.
 *  
 *  @author Reynaldo K. Delima and Nilo Cantil K. Jatico II S11A
 *  @version 1.00
 */

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class JMOpen extends JDialog implements ActionListener
{
	/* Attributes */
	
	private JTextField tfName;			/* JTextField: Field to input name */
	private JButton btnOk;				/* JButton: OK Button */

	/* Constructor */
	
	/** This constructor receives the frame type customer and the boolean modality.
	 * 
	 */
	
	public JMOpen (JFrame customer, boolean modal)
	{
		super (customer, modal);
		init ();
		
		setDefaultCloseOperation (WindowConstants.DISPOSE_ON_CLOSE);
		setSize (400, 250);
		setVisible (true);
	}
	
	/* Methods */
	
	/** This method initializes the window greeting.
	 * 
	 */
	
	public void init ()
	{
		setLayout (new GridLayout (3, 1));
				
		JPanel panel = new JPanel ();
		panel.setLayout (new FlowLayout ());
		
		panel.add(new JLabel("Welcome to Johnny Moves!"));
		add(panel);

		
			
		panel = new JPanel ();
		panel.setLayout (new FlowLayout ());
		panel.add (new JLabel ("Name: "));
		tfName = new JTextField (20);
		btnOk = new JButton ("Start");
		panel.add (tfName);
		add (panel);
		
		panel = new JPanel ();
		panel.setLayout (new FlowLayout ());
		
		panel.add (btnOk);
		btnOk.addActionListener (this);
		
		add (panel);

	}
	
	/** This method is responsible for the reaction of the program if the user hits a button.
	 * 
	 *  @param event ActionEvent variable responsible for the event to happen once user clicks something
	 */
	
	public void actionPerformed (ActionEvent event)
	{
		if (event.getActionCommand ().equals ("Start"))
		{
			dispose ();
		}
	}
	
	/** This method returns the name of the customer.
	 * 
	 * 	@return name of customer
	 */
	
	public String getUserName ()
	{
		return tfName.getText ();
	}
}
	
