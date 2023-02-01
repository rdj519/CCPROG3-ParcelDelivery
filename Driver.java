/** This is the driver.

 *  @author Delima, Reynaldo K. and Jatico II, Nilo Cantil K. S11A
 *  @version 1.00
 */

import java.util.*;

public class Driver
{
	public static void main (String[] args)
	{
	
			
			JMOpen open = new JMOpen (null, true);
			
			Customer customer = new Customer(open.getUserName());
			
			JMGUI gui = new JMGUI(customer.getName());
			JMController controller = new JMController (gui, customer);
			Timer time = new Timer();
			
			time.schedule(controller, 15000, 15000);
			controller.setTimer(15000, 15000);
			                                          

		
	}
}