/** The class AdminReport acts as a database for parcels and their information.
 *  This is only accessible by the admin only.
 *  
 *  @author Reynaldo K. Delima and Nilo Cantil K. Jatico II S11A
 *  @version 1.00
 */

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import java.util.*;


public class AdminReport extends JFrame
{
	/* Attributes */
	
	private JTextField textField;				/* JTextField: Tracker Input */
	private JTextArea manilaContent;			/* JTextArea: Display Metro Manila content */
	private JTextArea luzonContent;				/* JTextArea: Display Luzon content */
	private JTextArea visayasContent;			/* JTextArea: Display Visayas content */
	private JTextArea mindanaoContent; 			/* JTextArea: Display Mindanao content */
	private ArrayList<String> trackNums;		/* ArrayList: Holds String of tracking numbers */
	private ArrayList<String> receipts;			/* ArrayList: Holds String of receipts */
	
	/* Constructor */
	
	/** This constructor initializes the ArrayList and the upcoming display of
	 *  the report.
	 * 
	 */
	
	public AdminReport()
	{
		trackNums = new ArrayList<String>();
		receipts = new ArrayList<String>();
		initialize();
	}
	
	/* Methods */
	
	/** This method initializes the report only seen by the admin.
	 * 
	 */
	
	private void initialize() 
	{
		setBounds(100, 100, 885, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		manilaContent = new JTextArea();
		manilaContent.setEditable(false);
		luzonContent = new JTextArea();
		luzonContent.setEditable(false);
		visayasContent = new JTextArea();
		visayasContent.setEditable(false);
		mindanaoContent = new JTextArea();
		mindanaoContent.setEditable(false);
		
		JLabel lblGenerationReport = new JLabel("Metro Manila");
		lblGenerationReport.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblGenerationReport.setBounds(12, 0, 134, 29);
		getContentPane().add(lblGenerationReport);
		
		JPanel mmPanel = new JPanel();
		mmPanel.setBounds(5, 30, 210, 250);
		getContentPane().add(mmPanel);
		mmPanel.setLayout(new BoxLayout(mmPanel, BoxLayout.X_AXIS));
		
		JLabel lblProvincialWithinLuzon = new JLabel("Provincial within Luzon");
		lblProvincialWithinLuzon.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblProvincialWithinLuzon.setBounds(220, 6, 156, 16);
		getContentPane().add(lblProvincialWithinLuzon);
		
		JPanel lPanel = new JPanel();
		lPanel.setBounds(220, 30, 210, 250);
		getContentPane().add(lPanel);
		lPanel.setLayout(new BoxLayout(lPanel, BoxLayout.X_AXIS));
		
		JLabel lblProvincialWithinVisayas = new JLabel("Provincial within Visayas");
		lblProvincialWithinVisayas.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblProvincialWithinVisayas.setBounds(447, 3, 175, 23);
		getContentPane().add(lblProvincialWithinVisayas);
		
		JPanel vPanel = new JPanel();
		vPanel.setBounds(435, 30, 210, 250);
		getContentPane().add(vPanel);
		vPanel.setLayout(new BoxLayout(vPanel, BoxLayout.X_AXIS));

		JLabel lblProvincialWithinMindanao = new JLabel("Provincial within Mindanao");
		lblProvincialWithinMindanao.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblProvincialWithinMindanao.setBounds(653, 6, 187, 16);
		getContentPane().add(lblProvincialWithinMindanao);
		
		JPanel mPanel = new JPanel();
		mPanel.setBounds(650, 30, 210, 250);
		getContentPane().add(mPanel);
		mPanel.setLayout(new BoxLayout(mPanel, BoxLayout.X_AXIS));
	
		/* Note: Scrolls and content of Metro Manila to Mindanao */
		JScrollPane mmScroll = new JScrollPane(manilaContent);
		mmPanel.add(mmScroll);
		
		JScrollPane lScroll = new JScrollPane(luzonContent);
		lPanel.add(lScroll);
				
		JScrollPane vScroll = new JScrollPane(visayasContent);
		vPanel.add(vScroll);
		
		JScrollPane mScroll = new JScrollPane(mindanaoContent);
		mPanel.add(mScroll);
		
		manilaContent.setText("");
		luzonContent.setText("");
		visayasContent.setText("");
		mindanaoContent.setText("");
		
		textField = new JTextField();
		textField.setBounds(29, 316, 150, 22);
		getContentPane().add(textField);
		textField.setColumns(20);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(743, 315, 97, 25);
		getContentPane().add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		JButton btnSearch = new JButton("Search");				/* Note: Search tracking number */
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					int i;
					for(i=0; i < trackNums.size(); i++)
					{
						if(textField.getText().equals(trackNums.get(i)))
						{
							showPriceWindow(receipts.get(i));
						}
					}
				}
				catch(Exception exc)
				{
					JOptionPane.showMessageDialog(null, "Could not identify track number.\n");
				}
				

			}
		});
		btnSearch.setBounds(182, 315, 97, 25);
		getContentPane().add(btnSearch);
		
		
		JLabel lblSearchTransactionenter = new JLabel("Search Transaction (Enter parcel's tracking number): ");
		lblSearchTransactionenter.setBounds(12, 291, 319, 23);
		getContentPane().add(lblSearchTransactionenter);
		
		
	}
	
	/** This method makes the visibility of the screen.
	 * 
	 */
	
    public void open()
    {
    	setVisible(true);
    }
	
    /** This method shows the price of the chosen parcel.
     * 
     *  @param s String variable to set the text
     */
    
	private void showPriceWindow(String s) {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 316);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 432, 236);
		frame.getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JTextArea txtPrice = new JTextArea();
		JScrollPane priceScroll = new JScrollPane(txtPrice);
		panel.add(priceScroll);
		
		txtPrice.setText(s);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(168, 237, 97, 25);
		btnClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnClose);
		
		

		
	}
	
	/** This method add tracker to Metro Manila
	 * 
	 * 	@param s String variable to be placed in text field
	 */
	
	public void addMetroManilaContent(String s)
	{
		manilaContent.setText(s);
	}
	
	/** This method add tracker to Luzon
	 * 
	 * 	@param s String variable to be placed in text field
	 */
	
	public void addLuzonContent(String s)
	{
		luzonContent.setText(s);
	}
	
	/** This method add tracker to Visayas
	 * 
	 * 	@param s String variable to be placed in text field
	 */
	
	public void addVisayasContent(String s)
	{
		visayasContent.setText(s);
	}
	
	/** This method add tracker to Mindanao
	 * 
	 * 	@param s String variable to be placed in text field
	 */
	
	public void addMindanaoContent(String s)
	{
		mindanaoContent.setText(s);
	}
	
	/** This method adds tracking number to ArrayList
	 * 
	 * 	@param t String variable to add the tracking number
	 */
	
	public void addTrackNum(String t)
	{
		trackNums.add(t);
	}
	
	/** This method adds a receipt to ArrayList
	 * 
	 * 	@param r String variable to add the receipt
	 */
	
	public void addReceipt(String r)
	{
		receipts.add(r);
	}
}
