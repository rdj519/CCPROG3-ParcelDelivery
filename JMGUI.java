/**

 * 
 */
import javax.swing.*;

import java.util.*;
import java.util.Timer;
import java.awt.*;
import java.awt.event.*;
import java.time.format.DateTimeFormatter;
public class JMGUI extends JFrame implements ActionListener
{

	private JTextField txtTrackingNum;
	
	private JButton btnConfirm;
	private JButton btnAddItem;
	private JButton btnOk;
	private JButton btnDelete;
	private JButton btnTrack;
	private JButton btnExitProgram;
	private JButton btnChangeParcel;
	private JButton btnReport;
	
	private JPanel timePanel;
	private JPanel pricePanel;
	private JPanel statusPanel;
	private JPanel itemsPanel;
	
	private JLabel lblStatus;
	private JLabel lblDate;
	
	private JTextArea txtItems;
	private JTextArea txtStatus;
	private JTextArea txtReceipt;
	
	public JMGUI(String strName) {
		
		super("Customer Name: " + strName );
		
		initGui();
		
		/*
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setSize(1200,1000);
    	setVisible(true); */
		setBounds(100, 100, 640, 600);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);
	}
	
    public void initGui ()
    {		
    	
		/* Panels */
		
		timePanel = new JPanel();
		timePanel.setBackground(Color.LIGHT_GRAY);
		timePanel.setBounds(0, 0, 622, 24);
		getContentPane().add(timePanel);
		
		itemsPanel = new JPanel();
		itemsPanel.setBounds(0, 50, 197, 503);
		getContentPane().add(itemsPanel);
		itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.X_AXIS));
		
		statusPanel = new JPanel();
		statusPanel.setBounds(196, 50, 419, 82);
		getContentPane().add(statusPanel);
		statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
		//pricePanel.add(textPrice);
		
		pricePanel = new JPanel();
		pricePanel.setBounds(196, 157, 419, 269);
		getContentPane().add(pricePanel);
		pricePanel.setLayout(new BoxLayout(pricePanel, BoxLayout.X_AXIS));
		
		/* Scrollbars */
		
		JScrollPane scrollBar = new JScrollPane();
		scrollBar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		statusPanel.add(scrollBar);
		
		
		JScrollPane scrollBar_1 = new JScrollPane();
		scrollBar_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollBar_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		pricePanel.add(scrollBar_1);
		
		
		JScrollPane scrollBar_2 = new JScrollPane();
		scrollBar_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollBar_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		itemsPanel.add(scrollBar_2);		
    	
		/* Labels */
		
		JLabel lblCurrentDay = new JLabel("Date: ");
		lblCurrentDay.setFont(new Font("Tahoma", Font.BOLD, 13));
		timePanel.add(lblCurrentDay);
		
		
		lblDate = new JLabel("");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		timePanel.add(lblDate);
		
		JLabel lblParcelList = new JLabel("Parcel List");
		lblParcelList.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblParcelList.setBounds(209, 28, 110, 16);
		getContentPane().add(lblParcelList);
		
		JLabel lblReceipt = new JLabel("Receipt");
		lblReceipt.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblReceipt.setBounds(209, 130, 136, 24);
		getContentPane().add(lblReceipt);
		
		JLabel lblTrackYourParcel = new JLabel("Track Your Parcel");
		lblTrackYourParcel.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblTrackYourParcel.setBounds(209, 455, 116, 24);
		getContentPane().add(lblTrackYourParcel);
		
		JLabel lblEnterParcelsTracking = new JLabel("Enter Parcel's Tracking Number");
		lblEnterParcelsTracking.setBounds(209, 482, 189, 16);
		this.getContentPane().add(lblEnterParcelsTracking);

		lblStatus = new JLabel("");
		lblStatus.setFont(new Font("Sylfaen", Font.BOLD, 30));
		lblStatus.setBounds(433, 461, 182, 79);
		getContentPane().add(lblStatus);
		
		/* Buttons */
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(76, 24, 74, 25);
		getContentPane().add(btnDelete);
		
		btnAddItem = new JButton("Add");
		btnAddItem.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));	
		//btnAddItem.setBounds(0, 24, 87, 25);
		btnAddItem.setBounds(0, 24, 77, 25);
		getContentPane().add(btnAddItem);
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnConfirm.setBounds(196, 423, 97, 25);
		getContentPane().add(btnConfirm);
		
		btnOk = new JButton("Ok");
		btnOk.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnOk.setBounds(149, 24, 50, 25);
		getContentPane().add(btnOk);
		
		btnChangeParcel = new JButton("Change Parcel");
		btnChangeParcel.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		btnChangeParcel.setBounds(291, 423, 130, 25);
		getContentPane().add(btnChangeParcel);
		
		btnReport = new JButton("Report");
		btnReport.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		btnReport.setBounds(453, 423, 97, 25);
		getContentPane().add(btnReport);
		
		btnExitProgram = new JButton("Exit");
		btnExitProgram.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		btnExitProgram.setBounds(549, 423, 66, 25);
		getContentPane().add(btnExitProgram);
		
		btnTrack = new JButton("Track");
		btnTrack.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnTrack.setBounds(337, 510, 84, 25);
		getContentPane().add(btnTrack);
		
		/* Text Fields/Areas */
		txtItems = new JTextArea();
		txtItems.setEditable(false);
		txtItems.setBounds(0, 50, 197, 503);
		scrollBar_2.setViewportView(txtItems);
		txtItems.setText("");
				
		txtStatus = new JTextArea();
		txtStatus.setEditable(false);
		scrollBar.setViewportView(txtStatus);
		txtStatus.setText("");
		
		txtReceipt = new JTextArea();
		txtStatus.setEditable(false);
		scrollBar_1.setViewportView(txtReceipt);
		txtReceipt.setText("");
		
		txtTrackingNum = new JTextField();
		txtTrackingNum.setBounds(209, 511, 116, 22);
		getContentPane().add(txtTrackingNum);
		txtTrackingNum.setColumns(10);
		

		
    }
    
    public void setDate(String date)
    {
    	lblDate.setText(date);
    }
    
    public void addListeners (ActionListener listener)
    {
    	btnConfirm.addActionListener(listener);
    	btnAddItem.addActionListener(listener);
    	btnOk.addActionListener(listener);
    	btnTrack.addActionListener(listener);
    	btnExitProgram.addActionListener(listener);
    	btnChangeParcel.addActionListener(listener);
    	btnDelete.addActionListener(listener);
    	btnReport.addActionListener(listener);
    }
    
    public void addItemContent(String itemContent)
    {
    	String currText = txtItems.getText() + itemContent;
    	txtItems.setText(currText);
    	txtItems.validate();
    	txtItems.repaint();
    	itemsPanel.validate();
    	itemsPanel.repaint();
    }
    
    public void resetItemContent()
    {
    	txtItems.setText("");
    	txtItems.validate();
    	txtItems.repaint();
    	itemsPanel.validate();
    	itemsPanel.repaint();
    }
    
    public void resetPriceContent()
    {
    	setReceipt("");
    }
    
    public void addParcelContent(String parcelContent)
    {
    	String currText = txtStatus.getText();
    	txtStatus.setText(currText + "\n" + parcelContent);
    }
    
    public void setReceipt(String receiptContent)
    {
    	txtReceipt.setText(receiptContent);
    }
    
    public void displayStatus(String statusContent)
    {
    	lblStatus.setText(statusContent);
    	lblStatus.validate();
    	lblStatus.repaint();
    }
    
    public void exit()
    {
    	System.exit(0);
    }

    public void addStatusContent(String statusContent)
    {
    	String currText = txtStatus.getText() + statusContent;
    	txtStatus.setText(currText);
    	txtStatus.validate();
    	txtStatus.repaint();
    	statusPanel.validate();
    	statusPanel.repaint();
    }
    
    public String getTrack()
    {
    	return txtTrackingNum.getText();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}