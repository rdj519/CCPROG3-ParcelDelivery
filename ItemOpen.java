/** The class ItemOpen is responsible for the window display
 *  for the user to input the item they want to add.
 * 
 * 	@author Reynaldo K. Delima and Nilo Cantil K. Jatico II S11A
 *  @version 1.00
 */

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

	/* Attributes */
	
	/* JTextFields */
	private JTextField txtLength;					/* Length textfield */
	private JTextField txtWidth;					/* Width textfield */
	private JTextField txtPages;					/* Pages textfield */
	private JTextField txtHeight;					/* Height textfield */
	private JTextField txtWeight;					/* Weight textfield */
	private JTextField txtItemName;					/* Item Name textfield */
	private JRadioButton rdbtnDocument;				/* Radio Button Document option */
	private JRadioButton rdbtnProduct;				/* Radio Button Product option */
	private JRadioButton rdbtnIrregularProduct;		/* Radio Button Irregular option */
	private ButtonGroup rdbtnGrp;					/* Button Group */
	
	/* Panels */
	private JPanel upperPanel;						/* Upper panel */
	private JPanel lowerPanel;						/* Lower panel */
	
	/* Labels */
	private JLabel lblIrregular;					/* Irregular label */
	private JLabel lblPages;						/* Pages label */
	private JLabel lblHeight;						/* Height label */
	private JLabel lblWeight;						/* Weight label */
	private JLabel lblLength;						/* Length label */
	private JLabel lblWidth;						/* Width label */
	private JButton btnOk;							/* Button OK */
	private boolean isInitialized;					/* boolean init */
	
	/* Item attributes */
	private Item item;
	private JLabel lblNoteWeightShould;

	private ItemListener iDocument;
	private ItemListener iProduct;
	private ItemListener iIrregular;
	private ActionListener aOk;
	
	/* Override method actionPerformed via ActionEvent */
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
	}

	/* Override method itemStateChanged via ItemEvent */
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
	}
	
	/* Constuctor */
	
	/** This constructor initializes the ItemOpen.
	 * 
	 */
	
	public ItemOpen() {
		isInitialized = false;
		initialize();
	}

	/* Methods */
	
	/** This method initializes the content of the frame.
	 * 
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
		lblIrregular.setBounds(22, 105, 288, 16);
		lblIrregular.setVisible(false);
		getContentPane().add(lblIrregular);
	}
	
	/** This method updates the panels depending on the radio button clicked.
	 * 
	 */
	
	public void setContent(int type)
	{
			upperPanel.removeAll();
			lowerPanel.removeAll();

			if(type == 1) /* Document */
			{
				
					upperPanel.add(lblLength);
					upperPanel.add(txtLength);
					upperPanel.add(lblWidth);
					upperPanel.add(txtWidth);
					upperPanel.add(lblPages);
					upperPanel.add(txtPages);
					lblIrregular.setVisible(false);
			}
			else if( type == 2) /* Regular */
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
			else if( type == 3)	/* Irregular */
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
	
	/** This method performs actions when user clicks on the radio buttons.
	 * 
	 */
	
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
	
	/** This method opens the window when user wants to add item.
	 * 
	 */
	
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
	
	/** This method initializes listeners.
	 * 
	 *  @param controller JMController interpret data from user
	 */
	
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
