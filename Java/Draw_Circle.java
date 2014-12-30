import java.util.HashSet;
import java.awt.Point;

/**
 * @author joe
 * Pure storage:
    Given a parameter r, where the equation x^2+y^2=r^2 holds.
    Return a list of points that 
        (1) x and y are both integers
        (2) fits the circle equation
 */

public class Draw_Circle {

	public static void main(String[] args) {
		final int radius = 30;
//		HashSet<Point> points = validPoints(radius);
		HashSet<Point> points = validPointsBiSearch(radius);
		
		for (Point p : points) {
			System.out.println(p);
		}
	}

	/**
	 * @param r the radius of the circle
	 * @return a list of Points (x,y) integers who satisfy x^2 + y^2 = r^2
	 */
	public static HashSet<Point> validPoints(int r) {
		HashSet<Point> circlePoints = new HashSet<Point>();

		// init at 0 degrees (first quadrant, far right)
		int x = 1, y = 0;		
		
		// now, let's move around the circle
		while ( x * x <= r * r ) {
			// only run up to y <= x because if y > x, then it is no longer a circle
			// i.e. not symmetric
			for (y = 0; y <= x; ++y) {
				if (x*x + y * y == r * r) {
					circlePoints.add(new Point(x,y));
					circlePoints.add(new Point(x,-y));
					circlePoints.add(new Point(-x,y));
					circlePoints.add(new Point(-x,-y));
					
					circlePoints.add(new Point(y, x));
					circlePoints.add(new Point(y, -x));
					circlePoints.add(new Point(-y, x));
					circlePoints.add(new Point(-y, -x));
				}
			}
			x++;
		}
		
		return circlePoints;
	}

		/**
		 * @param r the radius of the circle
		 * @return a list of Points (x,y) integers who satisfy x^2 + y^2 = r^2
		 */
		public static HashSet<Point> validPointsBiSearch(int r) {
			HashSet<Point> circlePoints = new HashSet<Point>();
			
			int x = 1, y = 0;
			int y_start, y_mid, y_end;
			while ( x * x <= r * r) {
				y_start = 0;
				y_end = x;
				
				// do the b search
				while ( y_start <= y_end ) {
					// find the mid
					y_mid = (y_start + y_end) / 2;
					
					// check if the number is in mid, otherwise, update the start and end to search from
					if ( x * x + y_mid * y_mid == r * r ) {
						circlePoints.add(new Point(x, y_mid));
						circlePoints.add(new Point(-x, y_mid));
						circlePoints.add(new Point(x, -y_mid));
						circlePoints.add(new Point(-x, -y_mid));
						
						circlePoints.add(new Point(y_mid, x));
						circlePoints.add(new Point(y_mid, -x));
						circlePoints.add(new Point(-y_mid, x));
						circlePoints.add(new Point(-y_mid, -x));
						break;
					}
					
					else if ( x * x + y_mid * y_mid < r * r ) {
						y_start = y_mid + 1;
					}
					else {
						y_end = y_mid - 1;
					}
				}
				x++;
			}
					
			return circlePoints;
		}
	
}
