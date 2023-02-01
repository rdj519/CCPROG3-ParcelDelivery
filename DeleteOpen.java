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

	private JTextField txtNum;
	private JButton btnOk;
	private ActionListener ac;
	private boolean isInitialized;
	/**
	 * Create the application.
	 */
	public DeleteOpen() {
		isInitialized = false;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
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
	
	public void perform()
	{
		btnOk.addActionListener(ac);
		getContentPane().add(btnOk);
	}
	
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
