
//UPI: amur758 
//ID : 539504212
// Amith Raghavendra Murthy
//The assignment took around 12 hours to do. Stage 2 was the easiest. Stage 1D was the most difficult. Classes helped me understand.
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

class MovingRectangle extends MovingShape{
	private java.awt.Rectangle rect;
	
	public MovingRectangle(){
		rect = new Rectangle();
	}
	public MovingRectangle(int x, int y, int mw, int mh, Color bd, Color fc, int cp, int h, int w){
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		this.borderColor = bd;
		this.fillColor = fc;
		this.marginWidth = mw;
		this.marginHeight = mh;
		setPath(cp);
	}
	
	public void draw(Graphics g){
		g.setColor(borderColor);
		g.drawRect(super.getX()-1, super.getY()-1, super.getWidth(), super.getHeight());
		g.setColor(fillColor);
		g.fillRect(super.getX(), super.getY(), super.getWidth()-1, super.getHeight()-1);
		drawHandles(g);
	}
	
	public boolean contains(Point p){
		rect = new Rectangle(x,y,width,height);
		if(rect.contains(p)){
			return true;
		} else{
			return false;
		}
	}
}