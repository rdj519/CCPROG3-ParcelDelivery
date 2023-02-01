import java.awt.EventQueue;




import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ButtonGroup;
import java.awt.Color;

public class ItemOpen extends JFrame implements ActionListener, ItemListener{


	/* JTextFields */
	private JTextField txtLength;
	private JTextField txtWidth;
	private JTextField txtPages;
	private JTextField txtHeight;
	private JTextField txtWeight;
	private JTextField txtItemName;
	private JRadioButton rdbtnDocument;
	private JRadioButton rdbtnProduct;
	private JRadioButton rdbtnIrregularProduct;
	private ButtonGroup rdbtnGrp;
	
	/* Panels */
	private JPanel upperPanel;
	private JPanel lowerPanel;
	
	/* Labels */
	private JLabel lblIrregular;
	private JLabel lblPages;
	private JLabel lblHeight;
	private JLabel lblWeight;
	private JLabel lblLength;
	private JLabel lblWidth;
	private JButton btnOk;
	private boolean isInitialized;
	/* Item attributes */
	private Item item;
	private JLabel lblNoteWeightShould;

	private ItemListener iDocument;
	private ItemListener iProduct;
	private ItemListener iIrregular;
	private ActionListener aOk;
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
	}
	/**
	 * Create the application.
	 */
	//
	public ItemOpen() {
		isInitialized = false;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		getContentPane().setForeground(Color.WHITE);
		setBounds(100, 100, 621, 311);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		rdbtnGrp = new ButtonGroup();
		rdbtnDocument = new JRadioButton("Document");
		rdbtnProduct = new JRadioButton("Product");
		rdbtnIrregularProduct = new JRadioButton("Irregular Product");
		rdbtnGrp.add(rdbtnDocument);
		rdbtnGrp.add(rdbtnProduct);
		rdbtnGrp.add(rdbtnIrregularProduct);
		
		
		upperPanel = new JPanel();
		upperPanel.setBounds(22, 130, 569, 25);
		getContentPane().add(upperPanel);
		upperPanel.setLayout(new GridLayout(1, 1, 1, 1));
		
		lowerPanel = new JPanel();
		lowerPanel.setBounds(22, 168, 569, 25);
		getContentPane().add(lowerPanel);	
		lowerPanel.setLayout(new GridLayout(1, 1, 1, 1));
	
		rdbtnDocument.setBounds(50, 27, 127, 25);
		getContentPane().add(rdbtnDocument);
		rdbtnDocument.setActionCommand("document");
		
		rdbtnProduct.setBounds(220, 27, 127, 25);
		getContentPane().add(rdbtnProduct);
		rdbtnProduct.setActionCommand("product");
		
		
		rdbtnIrregularProduct.setBounds(380, 27, 127, 25);
		getContentPane().add(rdbtnIrregularProduct);
		rdbtnIrregularProduct.setActionCommand("irreg");

		lblLength = new JLabel("Length");
		lblWidth = new JLabel("Width");
		lblPages = new JLabel("Pages");
		lblHeight = new JLabel("Height");
		lblWeight = new JLabel("Weight");
		
		txtLength = new JTextField();
		txtWidth = new JTextField();
		txtPages = new JTextField();
		txtHeight = new JTextField();
		txtWeight = new JTextField();
		txtItemName = new JTextField();
		
	
		
		
		btnOk = new JButton("Ok");
		btnOk.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnOk.setBounds(241, 213, 97, 25);
	
		
		JPanel namePanel = new JPanel();
		namePanel.setBounds(22, 74, 569, 31);
		getContentPane().add(namePanel);
		namePanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		namePanel.add(lblItemName);
		namePanel.add(txtItemName);
		txtItemName.setColumns(10);
		
		lblNoteWeightShould = new JLabel("note: weight should be in grams");
		lblNoteWeightShould.setFont(new Font("Trebuchet MS", Font.ITALIC, 13));
		lblNoteWeightShould.setBounds(392, 235, 211, 16);
		getContentPane().add(lblNoteWeightShould);
		
		lblIrregular = new JLabel("Please input largest measures for length, width, height");
		lblIrregular.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblIrregular.setBounds(32, 106, 288, 16);
		lblIrregular.setVisible(false);
		getContentPane().add(lblIrregular);
	}
	
	
	//updates the panels depending on the radio button pushed.
	public void setContent(int type)
	{
			upperPanel.removeAll();
			lowerPanel.removeAll();

			if(type == 1)
			{
				
					upperPanel.add(lblLength);
					upperPanel.add(txtLength);
					upperPanel.add(lblWidth);
					upperPanel.add(txtWidth);
					upperPanel.add(lblPages);
					upperPanel.add(txtPages);
					lblIrregular.setVisible(false);
			}
			else if( type == 2)
			{
				
					upperPanel.add(lblLength);
					upperPanel.add(lblLength);
					upperPanel.add(txtLength);
					upperPanel.add(lblWidth);
					upperPanel.add(txtWidth);
					lowerPanel.add(lblWeight);
					lowerPanel.add(txtWeight);
					lowerPanel.add(lblHeight);
					lowerPanel.add(txtHeight);
					lblIrregular.setVisible(false);
			}
			else if( type == 3)	
			{
					upperPanel.add(lblLength);
					upperPanel.add(lblLength);
					upperPanel.add(txtLength);
					upperPanel.add(lblWidth);
					upperPanel.add(txtWidth);
					lowerPanel.add(lblWeight);
					lowerPanel.add(txtWeight);
					lowerPanel.add(lblHeight);
					lowerPanel.add(txtHeight);
					lblIrregular.setVisible(true);
			}
			upperPanel.revalidate();
			upperPanel.repaint();
			lowerPanel.revalidate();
			lowerPanel.repaint();
	}

	public void perform()
	{
		
		rdbtnDocument.addItemListener(iDocument);
		getContentPane().add(rdbtnDocument);
		
		rdbtnProduct.addItemListener(iProduct);
		getContentPane().add(rdbtnProduct);
		
		rdbtnIrregularProduct.addItemListener(iIrregular);
		getContentPane().add(rdbtnIrregularProduct);
		
		btnOk.addActionListener(aOk);
		getContentPane().add(btnOk);
		
	}
	
	public void open(JMController controller)
	{
		if(isInitialized == false)
		{
			
		initListeners(controller);
		perform();
		isInitialized = true;
		}
		setVisible(true);
		
	}
	public void initListeners(JMController controller)
	{

		iDocument = new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED)
					setContent(1);
				
			}
		};
		iProduct = new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED)
					setContent(2);
				
			}
		};
		iIrregular = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED)
					setContent(3);
				
			}
		};
		aOk = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try {
					
					String strName = txtItemName.getText();
					double dLength = Double.parseDouble(txtLength.getText());
					double dWidth = Double.parseDouble(txtWidth.getText());
					switch(rdbtnGrp.getSelection().getActionCommand())
						{
						case "document":
							int nPages = Integer.parseInt(txtPages.getText());
							item = new Document(strName, dLength, dWidth, nPages);
							break;
						case "product":
							double dHeight = Double.parseDouble(txtHeight.getText());
							double dWeight = Double.parseDouble(txtWeight.getText());
							item = new Product(strName, dLength, dWidth, dHeight, dWeight);
							break;
						case "irreg":
							dHeight = Double.parseDouble(txtHeight.getText());
							dWeight = Double.parseDouble(txtWeight.getText());
							item = new Irregular(strName, dLength, dWidth, dHeight, dWeight);
							break;
						}
					/* new code */
					controller.addItemCount();
					controller.addItem(item);
					controller.updateItemContent(false);
					
					/* end of new code */
					JOptionPane.showMessageDialog(null, "Inputting item successful!\n");
					dispose();
					
					/* reset text */
					txtLength.setText("");
					txtWidth.setText("");
					txtPages.setText("");
					txtHeight.setText("");
					txtWeight.setText("");
					txtItemName.setText(""); 
				}
				catch(Exception exc)
				{
					JOptionPane.showMessageDialog(null, "Error\n Invalid/Missing input/s");
				
					return;
				}
			}
		};
	}
}
