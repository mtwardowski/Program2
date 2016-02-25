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
	
	/**
	 *	The default constructor the window
	 */
	public Domino(int x, int y)
	{
		this.x = x;
		this.y = y;
		
	} // end default constructor

	/**
	 *	The paint method will 
	 */
	public void paint(Graphics domino)
	{
		drawBlank(domino);
		Die leftFace = new Die();
		Die rightFace = new Die();
	}
	
	/**   Draws the "blank" domino in a given frame. 
     */ 
    private void drawBlank (Graphics domino)
    {
    	int height = 50,
    	    width = 100,
    	    depth = 40;
    	domino.drawLine(x, y, 50, 50);
    }

}
