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

public class TableTop extends Frame
{
	
	private Domino domino;
	
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
		
		domino = new Domino();
		
		domino.setDominoLocation();
		domino.setDominoValue(true);
		domino.setDominoValue(false);
		
		setVisible(true);				//	makes the window visible
	} // end default constructor

	/**
	 *	The paint method will 
	 */
	public void paint(Graphics pane)
	{
			domino.paint(pane);
	}

}
