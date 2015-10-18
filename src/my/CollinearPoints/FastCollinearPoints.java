package my.CollinearPoints;


import java.util.Arrays;


/**
 * Created by Aleksandr_Kolesov on 10/16/2015.
 */
public class FastCollinearPoints {
    private int _countSegments = 0;
    private LineSegment[] _lineSegment;

    public FastCollinearPoints(Point[] points)     // finds all line segments containing 4 or more points
    {
//        Arrays.copyOf(points, 10);
        _lineSegment = new LineSegment[points.length];
        Point[] tmpPoints = new Point[points.length - 1];
//        System.arraycopy(points, 0, tmpPoints, 0, points.length);
        for (int p = 0; p < points.length; p++) {
            System.arraycopy(points, 0, tmpPoints, 0, p);
            System.arraycopy(points, p + 1, tmpPoints, p, points.length - p - 1);
            Arrays.sort(tmpPoints, points[p].slopeOrder());
            if (points[p].slopeTo(tmpPoints[0]) != points[p].slopeTo(tmpPoints[1])) continue;
            if (points[p].slopeTo(tmpPoints[0]) != points[p].slopeTo(tmpPoints[2])) continue;
//            if (points[p].slopeTo(tmpPoints[0]) != points[p].slopeTo(tmpPoints[3])) continue;
            _lineSegment[_countSegments++] = new LineSegment(points[p],tmpPoints[2]);


        }


    }

    public int numberOfSegments()        // the number of line segments
    {

        return _countSegments;
    }

    public LineSegment[] segments()                // the line segments
    {

        return _lineSegment;
    }
}