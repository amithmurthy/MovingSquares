
//UPI: amur758 
//ID : 539504212
// Amith Raghavendra Murthy
//The assignment took around 12 hours to do. Stage 2 was the easiest. Stage 1D was the most difficult. Classes helped me understand.
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Point;


public class MovingSquare extends MovingRectangle {
	private java.awt.Rectangle square;
	int min1;
	public MovingSquare(){
		square = new Rectangle();
	}
	public MovingSquare(int x, int y, int mw, int mh, Color bd, Color fc, int cp, int h, int w){
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		this.borderColor = bd;
		this.fillColor = fc;
		this.marginWidth = mw;
		this.marginHeight = mh;
		setPath(cp);
		min1 = Math.min(width, height);
		super.width = min1;
		super.height = min1;
	}
	//public void setHeight(int h1){ this.height = h1;}
	
	//public void setWidth(int w1) {this.width = w1;}
	public void draw(Graphics g){
		g.setColor(borderColor);
		g.drawRect(super.getX()-1, super.getY()-1,width,height);
		g.setColor(fillColor);
		g.fillRect(super.getX(), super.getY(), width-1, height-1);
		drawHandles(g);
	}
	public boolean contains(Point p){
		
		square = new Rectangle(x,y,min1,min1);
		if(square.contains(p)){
			return true;
		} else {
			return false;
		}
	}
}
