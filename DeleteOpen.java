/** The class DeleteOpen is responsible if the user wants to delete an item.
 *  This window will pop if the user decides to delete an item from the list.
 * 
 * 	@author Reynaldo K. Delima and Nilo Cantil K. Jatico II S11A
 *  @version 1.00
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;


public class DeleteOpen extends JFrame implements ActionListener{
	
	/* Attributes */
	
	private JTextField txtNum;			/* JTextField: Item Number input */
	private JButton btnOk;				/* JButton: OK Button */
	private ActionListener ac;			/* ActionListener: Action variable */
	private boolean isInitialized;		/* boolean: detects when initialized */
	
	/* Constructor */
	
	/** This constructor is responsible for initializing DeleteOpen.
	 * 
	 */
	
	public DeleteOpen() {
		isInitialized = false;
		initialize();
	}

	/* Methods */
	
	/** This method initializes the contents of the frame.
	 * 
	 */

	private void initialize() {
		setBounds(100, 100, 259, 123);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblEnterItemNo = new JLabel("Enter Item No.");
		lblEnterItemNo.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblEnterItemNo.setBounds(12, 13, 115, 20);
		getContentPane().add(lblEnterItemNo);
		
		txtNum = new JTextField();
		txtNum.setBounds(11, 46, 116, 22);
		getContentPane().add(txtNum);
		txtNum.setColumns(10);
		
		btnOk = new JButton("Ok");
		btnOk.setBounds(139, 45, 97, 25);
		
	}
	
	/** This method acts when action is performed.
	 * 
	 */
	
	public void perform()
	{
		btnOk.addActionListener(ac);
		getContentPane().add(btnOk);
	}
	
	/** This method opens the window if user wants to delete.
	 * 
	 * 	@param controller JMController variable that is the controller of the program
	 * 
	 */
	
	public void open(JMController controller)
	{
		if(isInitialized == false)
		{
			initActionListener(controller);
			perform();
			isInitialized = true;
		}
		setVisible(true);
	}
	
	/** This method is responsible of what action will be done when
	 *  user inputs on the text field.
	 * 
	 * 	@param controller JMController variable that will interpret the data from the user
	 * 
	 */
	
	public void initActionListener(JMController controller)
	{
		ac = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try {
					if(txtNum.getText().equalsIgnoreCase(""))
						JOptionPane.showMessageDialog(null, "No input number");
					else
					{
						boolean b = controller.deleteItem(Integer.parseInt(txtNum.getText()));
						if(b)
						{
							JOptionPane.showMessageDialog(null,"Item deleted.");
							dispose();

						}
						else
							JOptionPane.showMessageDialog(null, "Item not found");
						txtNum.setText("");
					}
				}
				catch(Exception exc)
				{
					JOptionPane.showMessageDialog(null, "Error\n Invalid input/s");
				}
				
				
			}
		};
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
