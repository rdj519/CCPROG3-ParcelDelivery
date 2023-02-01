/** This class is responsible for the tracking of the parcel object.
 * 
 *  @author Reynaldo K. Delima and Nilo Cantil K. Jatico II S11A
 *  @version 1.00
 */

import java.util.TimerTask;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
 

public class Tracker extends TimerTask
{
    /* Constructor */
     
    /** The constructor initializes the tracker with the information from the parcel, date, sequence and location.
     * 
     *  @param parcel Parcel object holding the information of the parcel
     *  @param nIndex integer variable holding the index of the location
     *  @param nSeq integer variable holding the value of the sequence
     *  @param date LocalDate variable holding the current date of the simulation
     */
     
    public Tracker (Parcel parcel, int nIndex, int nSeq, LocalDate date)
    {
        dtfFormat = DateTimeFormatter.ofPattern("MMdd");
        nTriggerTime = 0;
    	initializeDelivery(nIndex);
        initializeDates(nDeliveryDays, date);
        initializePackage(parcel);
        this.pParcel = parcel;
        strSequence = String.format("%03d", nSeq);
        strStartingDay = formatDate(ldStartingDay);
    }
     
    /* Methods */
     
    /** This method will initialize the destination code and the delivery time of the designated parcel.
     * 
     *  @param nIndex an integer representing the index corresponding to the region
     */
     
    public void initializeDelivery (int nIndex)
    {
        if(nIndex == 0)      //Index 0 designates Metro Manila
        {
            nDeliveryDays = 2;
            strDestCode = "MML";
        }
        else if(nIndex == 1) //Index 1 designates Luzon
        {
            nDeliveryDays = 3;
            strDestCode = "LUZ";
        }
        else if(nIndex == 2) //Index 2 designates Visayas
        {
            nDeliveryDays = 5;
            strDestCode = "VIS";
        }
        else if(nIndex == 3) //Index 3 designates Mindanao
        {
            nDeliveryDays = 8;
            strDestCode = "MIN";
        }
    }
     
    /** This method initializes the starting, current and expected dates of the delivery of the parcel.
     * 
     *  @param n an integer variable responsible for the number of days until the package delivers
     *  @param d a LocalDate variable holding the current date of the machine
     */
     
    public void initializeDates (int n, LocalDate d)
    {
        ldStartingDay = d;
        ldCurrentDay = d;
        ldExpectedDay = ldStartingDay.plusDays(n);
    }
     
    /** This method determines if the parcel is a flat type or a box type.
     * 
     *  @param p a Parcel object that holds the information of the parcel
     */
     
    public void initializePackage (Parcel p)
    {
        if(p instanceof Flat)
            strPackageType = "FLT";
        else if (p instanceof Box)
            strPackageType = "BOX";
    }
     
    /** This methods formats the date and returns a String variable
     * 
     *  @param d a LocalDate variable holding the date of simulation
     *  @return String of the formatted date
     */
     
    public String formatDate (LocalDate d)
    {
        return d.format(dtfFormat);
    }
    
    /** This method returns the tracking number of the tracker of the parcel.
     * 
     *  @return the tracking number of the parcel
     */
    
    public String toString ()
    {
        strStatement = strPackageType + strStartingDay + strDestCode + Integer.toString(pParcel.getCurrItems()) + strSequence;
        return strStatement;
    }
     
    /** This method returns the status of the delivery of the parcel.
     * 
     *  @return String of the status
     */
     
    public String getStatus ()
    {
        String strStatus;
        if(nTriggerTime == 0)
            strStatus = "Preparing";
        else if(nTriggerTime >= nDeliveryDays)
            strStatus = "Delivered";
        else
            strStatus = "Shipping";
        return strStatus;
    }
     
    /** This method is an optional function where it will return a String variable of the start and arrival dates.
     * 
     *  @return String variable of the start and arrival dates
     */
     
    public String getExpectedDates ()
    {
        String strStatus;
        String strExpectedDay;
        strStatus = "Date: " + strStartingDay + "\n";
        strExpectedDay = formatDate(ldExpectedDay);
        strStatus = "Arrival: " + strExpectedDay + "\n";
        return strStatus;
    }
     
    /** This method is a run method. Responsible by TimerTask.
     * 
     */
     
    public void run ()
    {
        ldCurrentDay = ldCurrentDay.plusDays(1);
        nTriggerTime = nTriggerTime + 1;
    }
    
    /* Attributes */
     
    private DateTimeFormatter dtfFormat;    									   /* DateTimeFormatter: Formats the date to numerical month and day */
    private int nDeliveryDays;													   /* int: Determines the number of days of the delivery time */
    private int nTriggerTime;	  											       /* int: To determine the tracking of the tracker */
    private LocalDate ldCurrentDay;												   /* LocalDate: Determine the current day of the tracker while it's being delivered */
    private LocalDate ldExpectedDay;											   /* LocalDate: Determine the expected day of arrival of the parcel */
    private LocalDate ldStartingDay;											   /* LocalDate: Determine the starting day of the parcel */
    private Parcel pParcel;														   /* Parcel: Holds the Parcel object of the tracker */
    private String strDestCode;													   /* String: Holds the destination code for the tracker name */
    private String strPackageType;												   /* String: Holds the package type for the tracker name */
    private String strSequence;													   /* String: Holds the sequence number for the tracker name */
    private String strStartingDay;												   /* String: Holds the starting day for the tracker name */
    private String strStatement;												   /* String: The tracker name of the tracker for the parcel */
}