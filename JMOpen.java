import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class JMOpen extends JDialog implements ActionListener
{
	private JTextField tfName;
	private JButton btnOk;
	// this only takes the name of the owner, and acts as an opening window.
	public JMOpen (JFrame owner, boolean modal)
	{
		super (owner, modal);
		init ();
		
		setDefaultCloseOperation (WindowConstants.DISPOSE_ON_CLOSE);
		setSize (400, 250);
		setVisible (true);
	}
	
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
	
	public void actionPerformed (ActionEvent event)
	{
		if (event.getActionCommand ().equals ("Start"))
		{
			dispose ();
		}
	}
	
	public String getUserName ()
	{
		return tfName.getText ();
	}
}
	
