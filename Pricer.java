/** The class Pricer is responsible for the calculation of the given parcel.
 * 
 *  @author Reynaldo K. Delima and Nilo Cantil K. Jatico II S11A
 *  @version 1.00
 *
 */
  
public class Pricer
{
    /* Constructor */
     
    /** This constructor receives the Parcel object and the
     *  intended region of the parcel via index integer. Also,
     *  certain variables are initialized to acquire the price of the parcel.
     *
     *  @param pParcel a Parcel object
     *  @param nIndex an integer number that is the index of an array of location
     */
     
    public Pricer (Parcel pParcel, int nIndex)
    {
        this.nIndex = nIndex;
        this.dTotalPrice = 0;
        this.dTotalWeight = 0;
        this.strReceipt = "RECEIPT\n\n";
        this.dTotalPrice = getPrice(pParcel);
    }
     
    /* Methods */
     
    /** This method calculates the total price of the parcel.
     * 
     *  @param pParcel a Parcel object that will be needed to determine the price
     *  @return total price of the parcel
     */
     
    public double getPrice(Parcel pParcel)
    {
        double dTotV = 0;       /* Local double variable to get the volunmetric weight of the parcel */
        double dTotL = 0;       /* Local double variable to get the length of the parcel */
        double dTotWi = 0;      /* Local double variable to get the width of the parcel */
        double dTotH = 0;       /* Local double variable to get the height of the parcel */
        double dRegP = 0;       /* Local double variable to get the price of regular/document items */
        double dIrregP = 0;     /* Local double variable to get the price of irregular items */
        double dRegW = 0;       /* Local double variable to get the weight of regular/document items */
        double dIrregW = 0;     /* Local double variable to get the weight of irregular items */
        double dIrregL = 0;     /* Local double variable to get the length of irregular items */
        double dIrregWi = 0;    /* Local double variable to get the width of irregular items */
        double dIrregH = 0;     /* Local double variable to get the height of irregular items */
        double dIrregW2 = 0;    /* Local double variable to get the volunmetric weight of irregular items */
        int i;              /* Iteration variable */
         
        if(pParcel instanceof Flat)
        {   
            /* Determining if the flat parcel is a small flat parcel or big flat parcel. */
             if(pParcel.getLength() == 9 && pParcel.getWidth() == 14)
             {
                 this.strReceipt += "Parcel Type: Flat (Small)\n";
                  
                 for(i=0; i < pParcel.getCurrItems(); i++)
                 {
                     this.dTotalWeight += pParcel.getItem(i).getWeight();    /* Add up all the weight of the items. */
                 }
                  
                 this.dTotalWeight = this.dTotalWeight / 1000;               /* Convert grams to kilograms */
                 this.dTotalWeight = Math.ceil(this.dTotalWeight);           /* Round up the kilograms */
                 this.dTotalPrice = 30 * this.dTotalWeight;                  /* Multiply Php 30.00 per kilo */
                  
                 this.strReceipt += "Total Weight: " +  Double.toString(dTotalWeight * 1000) + " grams (" + Double.toString(dTotalWeight) + " kilos)\n";
                 this.strReceipt += "Weight Price: " + Double.toString(dTotalPrice) + " Php\n";
             }
             else if(pParcel.getLength() == 12 && pParcel.getWidth() == 18)
             {
                 this.strReceipt += "Parcel Type: Flat (Large)\n"; 
                  
                 for(i=0; i < pParcel.getCurrItems(); i++)
                 {
                     this.dTotalWeight += pParcel.getItem(i).getWeight();    /* Add up all the weight of the items */
                 }
                  
                 this.dTotalWeight = this.dTotalWeight / 1000;               /* Convert grams to kilograms */
                 this.dTotalWeight = Math.ceil(this.dTotalWeight);           /* Round up the kilograms */
                 this.dTotalPrice = 50 * this.dTotalWeight;                  /* Multiply Php 50.00 per kilo */
                  
                 this.strReceipt += "Total Weight: " +  Double.toString(dTotalWeight * 1000) + " grams (" + Double.toString(dTotalWeight) + " kilos)\n";
                 this.strReceipt += "Weight Price: " + Double.toString(dTotalPrice) + " Php\n";
             }
        }
        else if(pParcel instanceof Box)
        {
            if(((Box)pParcel).getSize().equalsIgnoreCase("Small"))
                this.strReceipt += "Parcel Type: Box (Small)\n"; 
            else if(((Box)pParcel).getSize().equalsIgnoreCase("Medium"))
                this.strReceipt += "Parcel Type: Box (Medium)\n";
            else if(((Box)pParcel).getSize().equalsIgnoreCase("Large"))
                this.strReceipt += "Parcel Type: Box (Large)\n";
            else if(((Box)pParcel).getSize().equalsIgnoreCase("Enormous"))
                this.strReceipt += "Parcel Type: Box (Enormous)\n";
             
            for(i=0; i < pParcel.getCurrItems(); i++)
            {
                if(!(pParcel.getItem(i) instanceof Irregular)) /* Document items and Regular product items */
                {   
                    dRegW = dRegW + pParcel.getItem(i).getWeight();
                    dTotL += pParcel.getItem(i).getLength();
                    dTotWi += pParcel.getItem(i).getWidth();
                    dTotH += pParcel.getItem(i).getHeight();
                }
                else /* Irregular items */
                {
                    dIrregW = dIrregW + pParcel.getItem(i).getWeight();      /* Actual weight */
                    dIrregL = dIrregL + pParcel.getItem(i).getLength();      /* Total length */
                    dIrregWi = dIrregWi + pParcel.getItem(i).getWidth();     /* Total width */
                    dIrregH = dIrregH + pParcel.getItem(i).getHeight();      /* Total height */
                }
            }
             
            dTotL += dIrregL;
            dTotWi += dIrregWi;
            dTotH += dIrregH;
            dTotV = Math.ceil((dIrregL * dIrregWi * dIrregH) / 305);
             
            dRegW = dRegW / 1000;                                     /* Convert grams to kilograms */
            dRegW = Math.ceil(dRegW);                                 /* Round up the kilograms */
            dRegP = dRegW * 40;                                       /* Multiply Php 40.00 per kilo */
             
            dTotalPrice = dRegP;
            dTotalWeight = dRegW;
             
            dIrregW = dIrregW / 1000;                                 /* Convert grams to kilograms */
            dIrregW = Math.ceil(dIrregW);                             /* Round up the kilograms */
            dIrregP = dIrregW * 40;                                   /* Multiply Php 40.00 per kilo */
            dSumAmount1 = dIrregP;                                    /* Price of actual weight */
             
            dIrregW2 = (dIrregL * dIrregWi * dIrregH) / 305;          /* Calculate volunmetric weight */
            dIrregW2 = Math.ceil(dIrregW2);                           /* Round up the volunmetric weight */
            dIrregP = dIrregW2 * 30;                                  /* Multiply Php 30.00 per volun kilo */
            dSumAmount2 = dIrregP;                                    /* Price of volunmetric weight */
             
            if(dSumAmount1 < dSumAmount2)                             /* If volunmetric beats actual */
            {
                dTotalPrice = dTotalPrice + dSumAmount2;
                dTotalWeight += dIrregW2;
            }
            else                                                      /* If actual beats volunmetric */
            {
                dTotalPrice = dTotalPrice + dSumAmount1;
                dTotalWeight += dIrregW;
            }
             
             this.strReceipt += "Total Weight: " +  Double.toString(dTotalWeight * 1000) + " grams (" + Double.toString(dTotalWeight) + " kilos)\n";
             this.strReceipt += "Weight Price: " + Double.toString(dTotalPrice) + " Php\n";
        }
         
        if(pParcel.isInsured()) /* If parcel is insured */
        {
            this.strReceipt += "Insurance fee: " + Double.toString(pParcel.getCurrItems() * 5) + " Php\n";
            dTotalPrice = dTotalPrice + (pParcel.getCurrItems() * 5);
        }
        else
        {
            this.strReceipt += "Insurance fee: 0.0 Php (NOT INSURED)\n";
        }
         
        if(nIndex == 0)       /* If location is in Metro Manila */
        {
            this.strReceipt += "Base Location Fee (Metro Manila): " + Double.toString(dTotalPrice) + " Php\n";
            dTotalPrice += 50;
        }
             
        else if(nIndex == 1)  /* If location is in Provincial Luzon */
        {
            this.strReceipt += "Base Location Fee (Provincial within Luzon): " + Double.toString(dTotalPrice) + " Php\n";
            dTotalPrice += 100;
        }
        else if(nIndex == 2 || nIndex == 3) 
        {
            if(nIndex == 2) /* If location is in Provincial Visayas */
            {
                this.strReceipt += "Base Location Fee (Provincial within Visayas): ";
                dSumAmount1 = 1000;
                dSumAmount2 = 0.10 * dTotV;
                dSumAmount3 = 0.10 * this.dTotalWeight;
            }
            else            /* If location is in Provincial Mindanao */
            {
                this.strReceipt += "Base Location Fee (Provincial within Mindanao): ";
                dSumAmount1 = 3000;
                dSumAmount2 = 0.25 * dTotV;
                dSumAmount3 = 0.25 * this.dTotalWeight;
            }
             
            if(dSumAmount1 > dSumAmount2)
            {
                if(dSumAmount1 > dSumAmount3)
                {
                    this.strReceipt += Double.toString(dSumAmount1) + " Php\n";
                    dTotalPrice += dSumAmount1;
                }
                else
                {
                    this.strReceipt += Double.toString(dSumAmount3) + " Php\n";
                    dTotalPrice += dSumAmount3;
                }
                     
            }
            else if(dSumAmount2 > dSumAmount3)
            {
                if(dSumAmount2 > dSumAmount1)
                {
                    this.strReceipt += Double.toString(dSumAmount2) + " Php\n";
                    dTotalPrice += dSumAmount2;
                }
                else
                {
                    this.strReceipt += Double.toString(dSumAmount1) + " Php\n";
                    dTotalPrice += dSumAmount1;
                }
                     
            }
            else if(dSumAmount3 > dSumAmount2)
            {
                if(dSumAmount3 > dSumAmount1)
                {
                    this.strReceipt += Double.toString(dSumAmount3) + " Php\n";
                    dTotalPrice += dSumAmount3;
                }
                else
                {
                    this.strReceipt += Double.toString(dSumAmount1) + " Php\n";
                    dTotalPrice += dSumAmount1;
                }
                     
            }
        }   
        this.strReceipt += "\nRecipient: " + pParcel.getRecipient() + "\n";
        this.strReceipt += "\n\nTotal Price: " + Double.toString(dTotalPrice) + "\n";
        return dTotalPrice;
    }
     
    /** This method returns a String variable containing the breakdown
     *  and the total fee of the given parcel.
     * 
     *  @return String breakdown and total fee of given parcel
     */
     
    public String getReceipt()
    {
        return strReceipt;
    }
     
    /* Attributes */
     
    private String strReceipt;                                      /* String variable: Breakdown and total fee display */
    private double dTotalWeight;                                    /* double variable: Total weight of parcel */
    private double dTotalPrice;                                     /* double variable: Total price of parcel */
    private int nIndex;                                             /* int variable: Location of intended parcel */
    private double dSumAmount1, dSumAmount2, dSumAmount3;           /* double variable: Comparing prices which is higher */
}