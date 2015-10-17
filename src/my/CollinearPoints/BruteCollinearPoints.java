package my.CollinearPoints;

/**
 * Created by Aleksandr_Kolesov on 10/16/2015.
 */
public class BruteCollinearPoints {

    private LineSegment[] _lineSegment;
    private int _countSegments = 0;

    public BruteCollinearPoints(Point[] points)    // finds all line segments containing 4 points
    {
        if (points == null) throw new NullPointerException();

        _lineSegment = new LineSegment[points.length];
        int i = 0;
        for (int p = 0; p < points.length; p++) {
            if (points[p] == null) throw new NullPointerException();
            for (int q = 0; q < points.length; q++) {
                if (p == q) continue;
                if (points[p].compareTo(points[q]) == 0) throw new IllegalArgumentException();
                if (points[p].compareTo(points[q]) != 1) continue;
                for (int r = 0; r < points.length; r++) {
                    if (q == r || p == r) continue;
                    if (points[q].compareTo(points[r]) != 1) continue;
                    if (points[p].slopeTo(points[q]) != points[p].slopeTo(points[r])) continue;
                    for (int s = 0; s < points.length; s++) {
                        if (r == s || p == s || q == s) continue;
                        if (points[r].compareTo(points[s]) != 1) continue;
                        if (points[p].slopeTo(points[q]) != points[p].slopeTo(points[s])) continue;
                        _lineSegment[_countSegments++] = new LineSegment(points[p], points[s]);
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