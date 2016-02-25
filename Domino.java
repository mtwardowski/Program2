/**
	@Author Michael Twardowski
	
					       Domino Class
					=============================

	Purpose:	To
	
*/
import java.awt.Color;						
import java.awt.Graphics;
import java.awt.Point;

public class Domino
{
	
	private int x,
		        y;
	
	private Die leftFace,
				rightFace;
	
	/**
	 *	The default constructor the window
	 */
	public Domino(int x, int y)
	{
		this.x = x;
		this.y = y;
		
	} // end default constructor
	
	public void setFaceValue(int faceValue, boolean isLeft)
	{
		if(isLeft)
		{
			leftFace = new Die(faceValue, isLeft);
		}
		else
		{
			rightFace = new Die(faceValue, isLeft);
		}
	}

	/**
	 *	The paint method will 
	 */
	public void paint(Graphics pane)
	{
		drawBlank(pane);
		//leftFace.paint(pane);
		//rightFace.paint(pane);
	}
	
	/**   Draws the "blank" domino in a given frame. 
     */ 
    private void drawBlank (Graphics pane)
    {
    	int height = 100,
    	    width = 200,
    	    depth = 15,
    		topX[] = {x , x - depth, x + width - depth, x + width},
        	topY[] = {y , y - depth, y - depth, y},
			sideX[] = {x , x - depth, x - depth, x},
        	sideY[] = {y , y - depth, y + height - depth, y + height},
        	faceTotalPoints = 4;
    	
    	// Draw 
    	pane.setColor(Color.white);
    	pane.fillRect(x, y, width, height);
    	
    	pane.setColor(Color.orange);
    	pane.fillPolygon(topX, topY, faceTotalPoints);
    	pane.fillPolygon(sideX, sideY, faceTotalPoints);
    	
    	pane.setColor(Color.black);
    	pane.drawRect(x, y, width, height);
    	pane.drawPolygon(topX, topY, faceTotalPoints);
    	pane.drawPolygon(sideX, sideY, faceTotalPoints);
    	pane.drawLine(x + width/2, y, x + width/2, y + height);
    	pane.drawLine(x + width/2, y, x + wi dth/2 - depth, y - depth);
    	
    	
    }

}
