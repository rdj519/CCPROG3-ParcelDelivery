/** The class ParcelOpen is responsible for the display of the parcels available to the user
 *  once the user is done adding items to the list. Also, the user can input the recipient of the
 *  said parcel, and checks if he wants the parcel insured or not.
 *  
 *  @author Reynaldo K. Delima and Nilo Cantil K. Jatico II S11A
 *  @version 1.00
 */

import java.awt.EventQueue;
 
 
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.*;
 

public class ParcelOpen extends JFrame implements ActionListener{
 
	/* Attributes */
	
    private JPanel listPanel;
    private JTextField txtRecipientName;
     
    private JRadioButton rdbtnManila;
    private JRadioButton rdbtnProvincialWithinLuzon;
    private JRadioButton rdbtnProvincialWithinVisayas;
    private JRadioButton rdbtnProvincialWithinMindanao;
    private ButtonGroup rdbtnGrp;
 
    private String strName;
    private String strRegion;
    private String strSize;
    private boolean isFlat; 
     
    private Parcel parcel; 
    private boolean bNone;
    private boolean bInsured;
    private ArrayList <Item> items = new ArrayList <Item> ();
     
    /* Radio buttons for parcel sizes */
    private JRadioButton rdbtnFlatSmall;
    private JRadioButton rdbtnFlatLarge;
    private JRadioButton rdbtnBoxSmall; 
    private JRadioButton rdbtnBoxMedium;
    private JRadioButton rdbtnBoxLarge;
    private JRadioButton rdbtnBoxXLarge;
    private ButtonGroup rdbtnGrpSize;
     
    /* Constructor */
    
    /** This constructor initializes ParcelOpen via controller.
     * 
     *  @param controller JMController responsible for the interpretation of data from the user
     */

    public ParcelOpen(JMController controller) {
        int i;
        for(i=0; i < controller.getItems().size(); i++)
            items.add(controller.getItems().get(i));
        initialize(controller);
    }
 
    /* Methods */
    
    /** This method initialize the contents of the frame.
     * 
     *  @param controller JMController coming from the constructor of ParcelOpen
     */
 
    private void initialize(JMController controller) {         
        setVisible(true);
        setBounds(100, 100, 398, 388);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
         
        JPanel panel = new JPanel();
        panel.setBounds(12, 0, 359, 32);
        getContentPane().add(panel);
         
        JLabel lblRecipientName = new JLabel("Recipient Name: ");
        lblRecipientName.setFont(new Font("Arial", Font.BOLD, 13));
        panel.add(lblRecipientName);
         
        txtRecipientName = new JTextField();
        txtRecipientName.setColumns(20);
        panel.add(txtRecipientName);
         
        rdbtnManila = new JRadioButton("Metro Manila");
        rdbtnManila.setBounds(12, 41, 127, 25);
        rdbtnManila.addActionListener(new ActionListener() {
             
            @Override
            public void actionPerformed(ActionEvent e)
            {
                strRegion = "Metro Manila";
            }
        });
        getContentPane().add(rdbtnManila);
         
        rdbtnProvincialWithinLuzon = new JRadioButton("Provincial within Luzon");
        rdbtnProvincialWithinLuzon.setBounds(12, 76, 168, 25);
        rdbtnProvincialWithinLuzon.addActionListener(new ActionListener() {
             
            @Override
            public void actionPerformed(ActionEvent e)
            {
                strRegion = "Luzon";
            }
        });
        getContentPane().add(rdbtnProvincialWithinLuzon);
         
        rdbtnProvincialWithinVisayas = new JRadioButton("Provincial within Visayas");
        rdbtnProvincialWithinVisayas.setBounds(179, 41, 179, 25);
        rdbtnProvincialWithinVisayas.addActionListener(new ActionListener() {
             
            @Override
            public void actionPerformed(ActionEvent e)
            {
                strRegion = "Visayas";
            }
        });
        getContentPane().add(rdbtnProvincialWithinVisayas);
         
        rdbtnProvincialWithinMindanao = new JRadioButton("Provincial within Mindanao");
        rdbtnProvincialWithinMindanao.setBounds(179, 76, 179, 25);
        rdbtnProvincialWithinMindanao.addActionListener(new ActionListener() {
             
            @Override
            public void actionPerformed(ActionEvent e)
            {
                strRegion = "Mindanao";
            }
        });
        getContentPane().add(rdbtnProvincialWithinMindanao);
         
        rdbtnGrp = new ButtonGroup();
        rdbtnGrp.add(rdbtnManila);
        rdbtnGrp.add(rdbtnProvincialWithinLuzon);
        rdbtnGrp.add(rdbtnProvincialWithinVisayas);
        rdbtnGrp.add(rdbtnProvincialWithinMindanao);
         
         
        listPanel = new JPanel();
        listPanel.setBounds(12, 135, 359, 164);
        getContentPane().add(listPanel);
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
     
        /* Conditional in the loops here */
         
        double dL = 0;
        double dW = 0;
        double dH = 0;
        int i;
        
        /* 3D OPTIMIZATION ALGORITHM */
        
        if(items.size() > 0)
        {
        	dL = items.get(0).getLength();
        	dW = items.get(0).getWidth();
        	dH = items.get(0).getHeight();
        	for(i=1; i < items.size(); i++)
        	{
        		double pL = items.get(i).getLength(), 
        				pW = items.get(i).getWidth(), 
        				pH = items.get(i).getHeight();
        	
        		if(pL <= dL && pW <= dL && pH <= dL && pL > pW && pL > pH)
        		{
        			dL = pL;
        			if(pW <= dW && pH <= dW && pW > pH)
        			{
        				dW = pW;
						dH = pH;
        			}
        			else if(pW <= dW && pH <= dW && pW < pH)
					{
        				if(pW <= dH)
        				{
        					dW = pH;
        					dH = pW;
        				}
        				else
        				{
        					dW = pW;
        					dH = pH;
        				}
					}
        			else
        			{
        				dW = pW;
        				dH = pH;
        			}
        		}
        		else if(pL <= dL && pW <= dL && pH <= dL && pH > pW && pH > pL)
        		{
        			dL = pH;
        			if(pW <= dW && pL <= dW && pW > pL)
        			{
        				dW = pW;
        				dH = pL;
        			}
        			else if(pW <= dW && pL <= dW && pW < pL)
        			{
        				if(pW <= dH)
        				{
        					dW = pL;
        					dH = pW;
        				}
        				else
        				{
        					dW = pW;
        					dH = pL;
        				}
        			}
        			else
        			{
        				dW = pW;
        				dH = pL;
        			}
        		}
        		else if(pL <= dL && pW <= dL && pH <= dL && pW > pH && pW > pL)
        		{
        			dL = pW;
        			if(pH <= dW && pL <= dW && pH > pL)
        			{
        				dW = pH;
        				dH = pL;
        			}
        			else if(pH <= dW && pL <= dW && pH < pL)
        			{
        				if(pH <= dH)
        				{
        					dW = pL;
        					dH = pH;
        				}
        				else
        				{
        					dW = pH;
        					dH = pL;
        				}
        			}
        			else
        			{
        				dW = pH;
        				dH = pL;
        			}
        		}
        	} 
        }
        rdbtnGrpSize = new ButtonGroup();
        rdbtnFlatSmall = new JRadioButton("FLAT - 9 x 14 x 1");     
        rdbtnFlatSmall.setBounds(179, 76, 179, 25);
        rdbtnFlatSmall.addActionListener(new ActionListener() {
             
            @Override
            public void actionPerformed(ActionEvent e)
            {
                isFlat = true;
                strSize = "Small";
            }
        });
        rdbtnFlatLarge = new JRadioButton("FLAT - 12 x 18 x 3");
        rdbtnFlatLarge.setBounds(179, 76, 179, 25);
        rdbtnFlatLarge.addActionListener(new ActionListener() {
             
            @Override
            public void actionPerformed(ActionEvent e)
            {
                isFlat = true;
                strSize = "Large";
            }
        });
        rdbtnBoxSmall = new JRadioButton("BOX - 12 x 10 x 5");
        rdbtnBoxSmall.setBounds(179, 76, 179, 25);
        rdbtnBoxSmall.addActionListener(new ActionListener() {
             
            @Override
            public void actionPerformed(ActionEvent e)
            {
                isFlat = false;
                strSize = "Small";
            }
        });
        rdbtnBoxMedium = new JRadioButton("BOX - 14 x 11 x 7"); 
        rdbtnBoxMedium.setBounds(179, 76, 179, 25);
        rdbtnBoxMedium.addActionListener(new ActionListener() {
             
            @Override
            public void actionPerformed(ActionEvent e)
            {
                isFlat = false;
                strSize = "Medium";
            }
        });
        rdbtnBoxLarge = new JRadioButton("BOX - 18 x 12 x 9");      
        rdbtnBoxLarge.setBounds(179, 76, 179, 25);
        rdbtnBoxLarge.addActionListener(new ActionListener() {
             
            @Override
            public void actionPerformed(ActionEvent e)
            {
                isFlat = false;
                strSize = "Large";
            }
        });
        rdbtnBoxXLarge = new JRadioButton("BOX - 20 x 16 x 12");
        rdbtnBoxXLarge.setBounds(179, 76, 179, 25);
        rdbtnBoxXLarge.addActionListener(new ActionListener() {
             
            @Override
            public void actionPerformed(ActionEvent e)
            {
                isFlat = false;
                strSize = "XLarge";
            }
        });
        rdbtnGrpSize.add(rdbtnFlatSmall);
        rdbtnGrpSize.add(rdbtnFlatLarge);
        rdbtnGrpSize.add(rdbtnBoxSmall);
        rdbtnGrpSize.add(rdbtnBoxMedium);
        rdbtnGrpSize.add(rdbtnBoxLarge);
        rdbtnGrpSize.add(rdbtnBoxXLarge);
         
        boolean bFSmall = true,
                bFLarge = true,
                bBSmall = true,
                bBMedium = true,
                bBLarge = true ,
                bBXLarge= true;
         
        bNone = false; 
        /* Rotation algorithm */
        if(!(dL <= 9 && dW <= 14 && dH <= 1))
            if(!(dW <= 9 && dL <= 14 && dH <= 1))
                if(!(dL <= 9 && dH <= 14 && dW <= 1))
                    if(!(dH <= 9 && dW <= 14 && dL <=1))
                        if(!(dW <= 9 && dH <= 14 && dL <= 1))
                            if(!(dH <= 9 && dL <= 14 && dW <=1))
                                bFSmall = false;
            if(bFSmall)
                listPanel.add(rdbtnFlatSmall); 
        if(!(dL <= 12 && dW <= 18 && dH <= 3)) 
            if(!(dW <= 12 && dL <= 18 && dH <= 3))
                if(!(dL <= 12 && dH <= 18 && dW <= 3)) 
                    if(!(dH <= 12 && dW <= 18 && dL <= 3))
                        if(!(dW <= 12 && dH <= 18 && dL <= 3))
                            if(!(dH <= 12 && dL <= 18 && dW <= 3))
                                bFLarge = false;
            if(bFLarge)
                listPanel.add(rdbtnFlatLarge); 
        if(!(dL <= 12 && dW <= 10 && dH <= 5)) 
            if(!(dW <= 12 && dL <= 10 && dH <= 5))
                if(!(dL <= 12 && dH <= 10 && dW <= 5))     
                    if(!(dH <= 12 && dW <= 10 && dL <= 5))
                        if(!(dW <= 12 && dH <= 10 && dL <= 5))
                            if(!(dH <= 12 && dL <= 10 && dW <= 5))
                                bBSmall = false;
            if(bBSmall)
                listPanel.add(rdbtnBoxSmall); 
        if(!(dL <= 14 && dW <= 11 && dH <= 7))     
            if(!(dW <= 14 && dL <= 11 && dH <= 7))
                if(!(dL <= 14 && dH <= 11 && dW <= 7))     
                    if(!(dH <= 14 && dW <= 11 && dL <= 7))
                        if(!(dW <= 14 && dH <= 11 && dL <= 7))
                            if(!(dH <= 14 && dL <= 11 && dW <= 7))
                                bBMedium = false;
            if(bBMedium)
                listPanel.add(rdbtnBoxMedium); 
        if(!(dL <= 18 && dW <= 12 && dH <= 9)) 
            if(!(dW <= 18 && dL <= 12 && dH <= 9))
                if(!(dL <= 18 && dH <= 12 && dW <= 9))     
                    if(!(dH <= 18 && dW <= 12 && dL <= 9))
                        if(!(dW <= 18 && dH <= 12 && dL <= 9))
                            if(!(dH <= 18 && dL <= 12 && dW <= 9))
                                bBLarge = false;
            if(bBLarge)
                listPanel.add(rdbtnBoxLarge); 
        if(!(dL <= 20 && dW <= 16 && dH <= 12)) 
            if(!(dW <= 20 && dL <= 16 && dH <= 12))    
                if(!(dL <= 20 && dH <= 16 && dW <= 12))        
                    if(!(dH <= 20 && dW <= 16 && dL <= 12))
                        if(!(dW <= 20 && dH <= 16 && dL <= 12))
                            if(!(dH <= 20 && dL <= 16 && dW <= 12))
                                bBXLarge = false;
            if(bBXLarge)
                listPanel.add(rdbtnBoxXLarge);
         
        if(bFSmall == false && bFLarge == false && bBSmall == false && bBMedium == false && bBLarge == false && bBXLarge == false)
            bNone = true;
         
        bInsured = false;
        JToggleButton tglbtnInsured = new JToggleButton("Insured");
        tglbtnInsured.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
        tglbtnInsured.setBounds(268, 110, 103, 25);
        tglbtnInsured.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try {
                    bInsured = true;
                }
                catch(Exception exc)
                {
                     
                }
            }
        });
        getContentPane().add(tglbtnInsured);
         
        JLabel lblAvailableParcels = new JLabel("Available Parcels: ");
        lblAvailableParcels.setFont(new Font("Arial", Font.BOLD, 13));
        lblAvailableParcels.setBounds(12, 110, 150, 25);
        getContentPane().add(lblAvailableParcels);
         
        /* sets error message if no parcel is available */
        if(bNone)
        {
            JOptionPane.showMessageDialog(null, "No applicable parcel for items.\nAtleast one of the items exceed the capacity size.");
            dispose();
        }
         
        JButton btnOk = new JButton("Ok");
        btnOk.setFont(new Font("Arial", Font.BOLD, 13));
        btnOk.setBounds(140, 312, 97, 25);
         
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                /* if none is applicable */
                try {
                	
                    if(txtRecipientName.getText().equalsIgnoreCase(""))
                        JOptionPane.showMessageDialog(null, "No name");
                    else
                    {
                    strName = txtRecipientName.getText();
                    if(isFlat)
                    {
                        parcel = new Flat(items.size(), strRegion, strName);
                        switch(strSize) 
                        {
                            case "Small": 
                            	((Flat)parcel).setSize("small");
                                break;
                            case "Large":
                                ((Flat)parcel).setSize("large");
                                break;
                        }
                    }
                    else
                    {
                        parcel = new Box(items.size(), strRegion, strName);
                        switch(strSize)
                        {
                            case "Small":
                                ((Box)parcel).setSize("small");
                                break;
                            case "Medium":
                                ((Box)parcel).setSize("medium");
                                break;
                            case "Large":
                                ((Box)parcel).setSize("large");
                                break;
                            case "XLarge":
                                ((Box)parcel).setSize("enormous");
                                break;
                        }
                    }
                    int i;
                    for(i=0; i < items.size(); i++)
                    {
                    	parcel.inputItem(items.get(i));
                    }
                    parcel.setInsured(bInsured);
                    Pricer pricer = new Pricer(parcel, parcel.getRegionIndex());
                    controller.getGui().setReceipt(pricer.getReceipt());
                    controller.setOneReceipt(pricer.getReceipt());
                    controller.addParcelCount();
                    controller.setParcel(parcel);
                    controller.okClicked();
                     
                    JOptionPane.showMessageDialog(null, "Packing parcel successful!\nName : " + parcel.getRecipient() +"\nDest: "+ parcel.getRegion() +"\nItems: "+ Integer.toString(parcel.getCurrItems()));
                    
                    close();
                    }
                }
                catch(Exception exc)
                {
                    JOptionPane.showMessageDialog(null, "Error\n Invalid/Missing input/s");
                //  MessageDialog.OpenError(shell,"Error", "Invalid/Missing input/s");
                    return;
                }
            }
        });
        getContentPane().add(btnOk);
         
    }
    
    /** This method closes the program
     * 
     */
    
    public void close()
    {
    	 this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
    
    /* Override method of actionPerformed */
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
         
    }
}