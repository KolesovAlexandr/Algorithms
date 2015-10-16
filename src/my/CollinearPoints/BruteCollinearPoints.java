package my.CollinearPoints;

/**
 * Created by Aleksandr_Kolesov on 10/16/2015.
 */
public class BruteCollinearPoints {

    private    LineSegment[] _lineSegment;
    private int _countSegments = 0;

    public BruteCollinearPoints(Point[] points)    // finds all line segments containing 4 points
    {
        _lineSegment = new LineSegment[points.length];
        for (int p = 0; p < points.length; p++) {
            for (int q = 0; q < points.length; q++) {
                if (p == q) continue;
                for (int r = 0; r < points.length; r++) {
                    if (q == r) continue;
                    for (int s = 0; s < points.length; s++) {
                        if (r == s) continue;
                        if (points[p].slopeTo(points[q]) != points[p].slopeTo(points[r])) continue;
                        if (points[p].slopeTo(points[q]) != points[p].slopeTo(points[s])) continue;
                        _lineSegment[p]=new LineSegment(points[p],points[s]);
                        _countSegments++;
                    }
                }

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