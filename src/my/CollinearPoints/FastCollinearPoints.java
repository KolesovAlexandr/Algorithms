package my.CollinearPoints;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Aleksandr_Kolesov on 10/16/2015.
 */
public class FastCollinearPoints {
    private int _countSegments = 0;
    private LineSegment[] _lineSegment;

    public FastCollinearPoints(Point[] points)     // finds all line segments containing 4 or more points
    {
        _lineSegment = new LineSegment[points.length];
        for (int p = 0; p < points.length; p++) {
            Arrays.sort(points, points[p].slopeOrder());
            for (int i = 0; i < points.length - 3; i++) {
//                if (points[i].compareTo(points[i + 1]) !=1) continue;
//                if (points[i].compareTo(points[i + 2]) !=1) continue;
//                if (points[i].compareTo(points[i + 3]) !=1) continue;
                if (points[i].slopeTo(points[i + 1]) != points[i].slopeTo(points[i + 2])) continue;
                if (points[i].slopeTo(points[i + 1]) != points[i].slopeTo(points[i + 3])) continue;
                _lineSegment[_countSegments++] = new LineSegment(points[i], points[i + 3]);

            }
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