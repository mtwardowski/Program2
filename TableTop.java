/**
	@Author Michael Twardowski
	
					  TableTop Class
					=============================

	Purpose:	To
	
*/
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Frame;
import java.awt.Color;						
import java.awt.Graphics;
import java.awt.Point;
import java.util.Scanner;

public class TableTop extends Frame
{
	
	Domino domino;
	
	/**
	 *	The default constructor for the window
	 */
	public TableTop()
	{
		setTitle("Dominos");
		setLocation(50, 50);			
		setSize(1000, 1000);
		setBackground(Color.lightGray);

		//this is an anonymous class to be able to close the window.
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
        
		// prompt for user input
		Point point = gamePieceLocation();
		
		domino = new Domino((int)point.getX(),(int)point.getY());
		
		gamePieceValue();
		
		
		
		setVisible(true);				//	makes the window visible
	} // end default constructor

	/**
	 *	The paint method will 
	 */
	public void paint(Graphics pane)
	{
		domino.paint(pane);
	}
	
	private Point gamePieceLocation()
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter a X and Y coordinate for the domino: ");
		int x = keyboard.nextInt();
		int y = keyboard.nextInt();
		
		Point point = new Point (x, y);
		return point;
	}
	
	private void gamePieceValue()
	{
		boolean isValidNumberLeft = false,
				isValidNumberRight = false;
		
		Scanner keyboard = new Scanner(System.in);
		
		while(!isValidNumberLeft)
		{
			System.out.println("Enter an integer between 1-5 for the left face of a domino: ");
			int leftFaceValue = keyboard.nextInt();
			isValidNumberLeft = validateFaceValue(leftFaceValue);
		}
		
		while(!isValidNumberRight)
		{
			System.out.println("Enter an integer between 1-5 for the right face of a domino: ");
			int rightFaceValue = (int)keyboard.nextInt();
			isValidNumberRight = validateFaceValue(rightFaceValue);
		}
		
	}
	
	private boolean validateFaceValue(int faceValue)
	{
	    if((faceValue >= 1)&&(faceValue <=5))
	    {
	    	return true;
	    }
	    else
	    {
	    	return false;
	    }
		 
	}

}
