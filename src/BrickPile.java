//package bricks;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Enumeration;
import java.util.Vector;

public class BrickPile {
	private PlayField _pf;
	private Vector _bricks;
        private final int _rows2 = 1;
	private final int _rows = 3;
	private final int _cols = 10;

	public BrickPile(PlayField pf, Image img, Image img2) {
		_pf = pf;
		_bricks = new Vector();
		int startx = 80; 
		int x = startx, y = 10;
                
                for (int r = 0; r < _rows2; r++) {
			for (int c = 0; c < _cols; c++) {
				Rectangle pos = new Rectangle(x, y, img2.getWidth(null), img2.getHeight(null));
				
				HardBrick b = new HardBrick(_pf, this, pos,img2,img2);
				pf.addSprite(b);
				_bricks.addElement(b);
        
				x += img2.getWidth(null);
			}
			
			y += img.getHeight(null) + 2;
			x = startx;
		}
		for (int r = 0; r < _rows; r++) {
			for (int c = 0; c < _cols; c++) {
				Rectangle pos = new Rectangle(x, y, img.getWidth(null), img.getHeight(null));
				
				Brick b = new Brick(_pf, this, img, pos);
				pf.addSprite(b);
				_bricks.addElement(b);
        
				x += img.getWidth(null);
			}
			
			y += img.getHeight(null) + 2;
			x = startx;
		}
	}

	public int unbrokenCount() {
		int result = 0;
		
		for (int i = 0; i < _bricks.size(); i++) {
			if ( !((Brick) _bricks.elementAt(i)).isDead() ) 
				result++; 	
		}
		
		return result;
	}

	public int brokenCount() {
		return _bricks.size() - unbrokenCount();	
	}
}
