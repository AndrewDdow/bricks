//package bricks;

import java.awt.Image;
import java.awt.Rectangle;

class HardBrick extends Brick {
	/*
	 * @_hitCount - количество допустимых ударов шайбой
	 *            кирпич разрушается, как только атрибут
	 * 			  будет равен нулю
	 * @_woundImg - изображение поврежденого кирпича
	 * 			  заменяет исходное изображение при первом
	 * 			  ударе шайбы
	 */
	 
	private int _hitCount = 200;
	private Image _woundImg;

	public HardBrick(
		PlayField pf,
		BrickPile bp,
		Rectangle p,
		Image img2,
		Image woundImg) {
			super(pf, bp, img2, p);
			_woundImg = woundImg;
		}
		
	/* Oбработка соударения с шайбой. Как только
	 * значение _hitCount становится равным нулю
	 * и будет удален с игрового поля
	 */
	 
	public void hitBy(Puck p) {
	/*	if (_hitCount > 0) {
			_img = _woundImg;
			_hitCount--;
		} else {
			_isDead = true;*/
			if (_bp.unbrokenCount() == 10) {
				_pf.getMatch().win();
			}
		//}
		
		p.getVelocity().reverseY();
	}
}
