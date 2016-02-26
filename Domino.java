/**
	@Author Michael Twardowski
	
					       Domino Class
					=============================

	Purpose:	To
	
*/
import java.awt.Color;						
import java.awt.Graphics;
import java.awt.Point;
import java.util.Scanner;

public class Domino
{
	
	private int x,
		        y,
		        leftValue,
		        rightValue;
	
    private final int DOT_DIAMETER = 20,
    				  HEIGHT = 100,
    				  WIDTH = 200,
    				  DEPTH = 10;

	/**
	 *	The default constructor the window
	 */
	public Domino()
	{
	} // end default constructor
	

	/**
	 *	The paint method will 
	 */
	public void paint(Graphics pane)
	{
		drawBlank(pane);
		
		pane.setColor(Color.blue);
		
		boolean side[] = {true, false};
		int value[] = {leftValue, rightValue};
		for(int i = 0; i<2; i++)
		{
			switch(value[i])
			{
				case 1:
					drawOne(pane, side[i]);
					break;
				case 2:
					drawTwo(pane, side[i]);
					break;
				case 3:
					drawThree(pane, side[i]);
					break;
				case 4:
					drawFour(pane, side[i]);
					break;
				case 5:
					drawFive(pane, side[i]);
					break;
			}
		}
		
	}
	
	/**   Draws the "blank" domino in a given frame. 
     */ 
    private void drawBlank(Graphics pane)
    {
    	int topX[] = {x , x - DEPTH, x + WIDTH - DEPTH, x + WIDTH},
        	topY[] = {y , y - DEPTH, y - DEPTH, y},
			sideX[] = {x , x - DEPTH, x - DEPTH, x},
        	sideY[] = {y , y - DEPTH, y + HEIGHT - DEPTH, y + HEIGHT},
        	faceTotalPoints = 4;
    	
    	// Draw 
    	pane.setColor(Color.white);
    	pane.fillRect(x, y, WIDTH, HEIGHT);
    	
    	pane.setColor(Color.gray);
    	pane.fillPolygon(topX, topY, faceTotalPoints);
    	pane.fillPolygon(sideX, sideY, faceTotalPoints);
    	
    	pane.setColor(Color.black);
    	pane.drawRect(x, y, WIDTH, HEIGHT);
    	pane.drawPolygon(topX, topY, faceTotalPoints);
    	pane.drawPolygon(sideX, sideY, faceTotalPoints);
    	pane.drawLine(x + WIDTH/2, y, x + WIDTH/2, y + HEIGHT);
    	pane.drawLine(x + WIDTH/2, y, x + WIDTH/2 - DEPTH, y - DEPTH);
    }
    
    public void setDominoLocation()
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter a X and Y coordinate for the domino: ");
		x = keyboard.nextInt();
		y = keyboard.nextInt();
	}
	
	public void setDominoValue(boolean isLeft)
	{
		boolean isValidNumber = false;
		int faceValue = 0;
		
		Scanner keyboard = new Scanner(System.in);
		
		String side = "right";
		if(isLeft)
		{
			side = "left";
		}
		
		while(!isValidNumber)
		{
			System.out.println("Enter an integer between 1-5 for the " + side + " face of a domino: ");
			faceValue= keyboard.nextInt();
			isValidNumber = validateFaceValue(faceValue);
		}
		
		if(isLeft)
		{
			leftValue = faceValue;
		}
		else
		{
			rightValue = faceValue;
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
    
	/**   Draws one dot, centered at given location. 
     */ 
    private void drawDot(Graphics pane, int centerX, int centerY)
	{
    	pane.fillOval(centerX - DOT_DIAMETER/2, centerY - DOT_DIAMETER/2, DOT_DIAMETER, DOT_DIAMETER);
	}
	
	/**   The following methods draw the right number 
     *       of dots on the face of one of the sides of the domino. 
     */ 
    private void drawOne (Graphics pane, boolean isLeft)
    {
    	int centerX,
    	    centerY;
    	
    	if(isLeft)
    	{
    		 centerX = x + WIDTH/4;
    		 centerY = y + HEIGHT/2;
    	}
    	else
    	{
    		centerX = x + WIDTH*3/4;
   		 	centerY = y + HEIGHT/2;
    	}
    	
    	drawDot(pane, centerX, centerY);
    }
    
    private void drawTwo (Graphics pane, boolean isLeft) 
    {
    	int centerX,
        centerY,
        centerX2,
        centerY2;

		if(isLeft)
		{
			 centerX = x + WIDTH/8;
			 centerY = y + HEIGHT/4;
			 centerX2 = x + WIDTH*3/8;
			 centerY2 = y + HEIGHT*3/4;
		}
		else
		{
			centerX = x + WIDTH*5/8;
			centerY = y + HEIGHT/4;
			centerX2 = x + WIDTH*7/8;
			centerY2 = y + HEIGHT*3/4;
		}
		
		drawDot(pane, centerX, centerY);
		drawDot(pane, centerX2, centerY2);
    }
    
    private void drawThree (Graphics pane, boolean isLeft)
    {
		drawOne(pane, isLeft);
		drawTwo(pane, isLeft);
    }
    
    private void drawFour (Graphics pane, boolean isLeft)
    {
    	int centerX,
        centerY,
        centerX2,
        centerY2;

		if(isLeft)
		{
			 centerX = x + WIDTH/8;
			 centerY = y + HEIGHT*3/4;
			 centerX2 = x + WIDTH*3/8;
			 centerY2 = y + HEIGHT/4;
		}
		else
		{
			centerX = x + WIDTH*5/8;
			centerY = y + HEIGHT*3/4;
			centerX2 = x + WIDTH*7/8;
			centerY2 = y + HEIGHT/4;
		}
    	
		drawDot(pane, centerX, centerY);
		drawDot(pane, centerX2, centerY2);
		
    	drawTwo(pane, isLeft);
    }
    
    private void drawFive (Graphics pane, boolean isLeft)
    {
    	drawFour(pane, isLeft);
    	drawOne(pane, isLeft);
    }

}
