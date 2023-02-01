import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import java.util.*;

public class AdminReport extends JFrame{

	
	private JTextField textField; //tracker input
	private JTextArea manilaContent;
	private JTextArea luzonContent;
	private JTextArea visayasContent;
	private JTextArea mindanaoContent; 
	private ArrayList<String> trackNums;
	private ArrayList<String> receipts;
	// this class acts as a database for parcels and their infos (accessible only by admin)
	public AdminReport() {
		trackNums = new ArrayList<String>();
		receipts = new ArrayList<String>();
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
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
		
	
		//scrolls and content
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
		JButton btnSearch = new JButton("Search");
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
	
	/** adminReport is an attribute in controller, which means that as parcels are created and delivered, their data is being updated 
	 * in this report class, only then that they (admin) ask to view the status of all parcels, (after inputting passworkd), do we show them 
	 * the report generation itself
	 */
	
    public void open()
    {
    	setVisible(true);
    }
	
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
	
	public void addMetroManilaContent(String s)
	{
		manilaContent.setText(s);
	}
	
	public void addLuzonContent(String s)
	{
		luzonContent.setText(s);
	}
	
	public void addVisayasContent(String s)
	{
		visayasContent.setText(s);
	}
	
	public void addMindanaoContent(String s)
	{
		mindanaoContent.setText(s);
	}
	
	public void addTrackNum(String t)
	{
		trackNums.add(t);
	}
	
	public void addReceipt(String r)
	{
		receipts.add(r);
	}
}
