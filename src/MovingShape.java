/*
 *    ===============================================================================
 *    MovingShape.java : The superclass of all shapes.
 *    A shape has a top-left corner (x,y).
 *    A shape defines various properties, including selected, fill colour, border color, width and height.
 *    ===============================================================================
 */
//UPI: amur758 
//ID : 539504212
// Amith Raghavendra Murthy
//The assignment took around 12 hours to do. Stage 2 was the easiest. Stage 1D was the most difficult. Classes helped me understand.
import java.awt.*;
public abstract class MovingShape {

    public int marginWidth, marginHeight; // the margin of the animation panel area
    protected int x, y;                 // the top left coner of shapes
    protected MovingPath path;            // the moving path of shapes
    protected Color borderColor, fillColor;   // the border colour and fill colour of shapes
    protected boolean selected = false;    // draw handles if selected
    protected int height;				//height property
    protected int width;				//width property
    
    /** constuctor to create a shape with default values
     */
    public MovingShape() {
        this(10, 20, 800, 500, Color.black, Color.blue, 0, 20,10); // the default properties
    }

    /** constuctor to create a shape
     * @param x         the x-coordinate of the new shape
     * @param y        the y-coordinate of the new shape
     * @param mw         the margin width of the animation panel
     * @param mh        the margin height of the animation panel
     * @param c        the colour of the new shape
     * @param typeOfPath         the path of the new shape
     */
    public MovingShape(int x, int y, int mw, int mh, Color c, Color fc, int pathType, int h, int w) {
        this.x = x;
        this.y = y;
        marginWidth = mw;
        marginHeight = mh;
        borderColor = c;
        fillColor = fc;
        setPath (pathType);
        height = h;
        width = w;
    }
    /** Return the x-coordinate of the shape.
     * @return the x coordinate
     */
    public int getX() { return x; }

    /** Set the x-coordinate of the shape.
     * @param x     the x value
     */
    public void setX(int x) { this.x = x; }

    /** Return the y-coordinate of the shape.
     * @return the y coordinate
     */
    public int getY() { return y;}

    /** Set the y-coordinate of the shape.
     * @param y     the y value
     */
    public void setY(int y) { this.y = y; }

    /** Return the selected property of the shape.
     * @return the selected property
     */
    public boolean isSelected() { return selected; }

    /** Set the selected property of the shape.
     *    When the shape is selected, its handles are shown.
     * @param s     the selected value
     */
    public void setSelected(boolean s) { selected = s; }

    /** Return the border colour of the shape.
     * @return the border colour
     */
    public Color getBorderColor() { return borderColor;}

    /** Set the border colour of the shape.
     * @param c     the border colour
     */
    public void setBorderColor(Color c) { borderColor = c; }

    /** Return the fill colour of the shape.
     * @return the fill colour
     */
    public Color getFillColor() { return fillColor;}

    /** Set the fill colour of the shape.
     * @param fc     the fill colour
     */
    public void setFillColor(Color fc) { fillColor = fc; }
    
    public int getHeight(){return height;}
    
    public int getWidth(){return width;}
    
    public void setHeight(int heightvalue){height = heightvalue;}
    
    public void setWidth(int widthvalue){width = widthvalue;}
    /**
     * Return a string representation of the shape, containing
     * the String representation of each element.
     */
    public String toString() {
        return "[" + this.getClass().getName() + "," + x + "," + y + ", Height: "+height+", Width: "+width+"]";
    }

   /** Draw the handles of the shape
     * @param g     the Graphics control
     */
    public void drawHandles(Graphics g) {
        if (isSelected()) {
        	g.setColor(Color.black);
            g.fillRect(x-2,y-2, 4, 4);
            g.fillRect(x+width-2, y-2, 4, 4);
            g.fillRect(x-2,y+height-2, 4, 4);
            g.fillRect(x+width-2, y+height-2, 4, 4);
        	//complete this
        }
    }

    /** Reset the margin for the shape
     * @param w     the margin width
     * @param h     the margin height
     */
    public void setMarginSize(int w, int h) {
        marginWidth = w;
        marginHeight = h;
    }

    /** abstract contains method
     * Returns whether the point p is inside the shape or not.
     * @param p    the mouse point
     */
    public abstract boolean contains(Point p);

    /** abstract draw method
     * draw the shape
     * @param g     the Graphics control
     */
    public abstract void draw(Graphics g);

    /** Set the path of the shape.
     * @param pathID     the integer value of the path
     *    MovingPath.FALLING is the falling path
     */
    public void setPath(int pathID) {
        switch (pathID) {
            case MovingPath.FALLING : {
                path = new FallingPath();
                break;
            }
            case MovingPath.BOUNCING :{
            	path = new BouncingPath();
            	break;
            }
        }
    }

    /** move the shape by the path
     */
    public void move() {
        path.move();
    }

    // Inner class ===================================================================== Inner class
    /*
     *    ===============================================================================
     *    MovingPath : The superclass of all paths. It is an inner class.
     *    A path can change the current position of the shape.
     *    ===============================================================================
     */

    public abstract class MovingPath {
        public static final int FALLING = 0; // The Id of the moving path
        public static final int BOUNCING = 1; // The Id of the moving path
        protected int deltaX, deltaY; // moving distance

        /** constructor
         */
        public MovingPath() { }

        /** abstract move method
        * move the shape according to the path
        */
        public abstract void move();
    }

    /*
     *  ===============================================================================
     *  FallingPath : A falling path.
     *  ===============================================================================
     */
    public class FallingPath extends MovingPath {
        private double am = 0, stx =0, sinDeltax = 0;

        /** constructor to initialise values for a falling path
        */
        public FallingPath() {
            am = Math.random() * 20; //set amplitude variables
            stx = 0.5; //set step variables
            deltaY = 5;
            sinDeltax = 0;
       }

       /** move the shape
       */
       public void move() {
           sinDeltax = sinDeltax + stx;
           x = (int) Math.round(x + am * Math.sin(sinDeltax));
           y = y + deltaY;
           if (y > marginHeight) // if it reaches the bottom of the frame, start again from the top
               y = 0;
       }
    }
    /*
     *  ===============================================================================
     *  BouncingPath : A Bouncing path.
     *  ===============================================================================
     */
     //complete this
    public class BouncingPath extends MovingPath {
		private int xDelta, yDelta;
	public BouncingPath() {
		xDelta  = 8;
		yDelta = 8;
	}
	public void move() {
		x += xDelta;
		y += yDelta;
		
		if (y <0){
			yDelta = yDelta * -1;
			y += yDelta;
		}
		if (y + height>marginHeight){
			yDelta = yDelta * -1;
			y += yDelta;
		}
		if (x + width>marginWidth) {
			xDelta = xDelta * -1;
			x += xDelta;
		}
		if (x<0) {
			xDelta = xDelta * -1;
			x += xDelta;
		}
	}
}
}