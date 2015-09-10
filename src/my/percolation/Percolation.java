package my.percolation;

import java.util.Random;

/**
 * Created by Aleksandr_Kolesov on 9/10/2015.
 */
public class Percolation {

    private final int size;
    UnionFind unionFind;
    boolean[] isOpen;
    Random random;
    double count;

    public Percolation(int N) {
        unionFind = new UnionFind(N * N + 2);
        isOpen = new boolean[N * N];
        size = N;
        random = new Random(N * N);
        count = 0;
    }

    static public void main(String[] args) {

        Percolation percolation = new Percolation(10000);
//        double count = 0;

        while (!percolation.isPercolation()) {
            percolation.randOpen();

        }
        double p = percolation.count / (percolation.size * percolation.size);
        System.out.println(p);

    }

    public void randOpen() {
        open(random.nextInt(size * size));
    }

    public void open(int i) {
        if (isOpen[i] == true) {
            return;
        }
        count++;
        isOpen[i] = true;
        int qSize = size * size;

        if (i - 1 > 0 && isOpen[i - 1]) {
            unionFind.union(i, i - 1);
        }
        if (i + 1 < size * size - 2 && isOpen[i + 1]) {
            unionFind.union(i, i + 1);
        }
        if (i - size > 0 && isOpen[i - size]) {
            unionFind.union(i, i - size);
        }
        if (i + size < size * size && isOpen[i + size]) {
            unionFind.union(i, i + size);
        }

        if (i >= 0 & i < size) {
            unionFind.union(i, qSize);
        }
        if (i >= qSize - size & i < qSize) {
            unionFind.union(i, qSize + 1);
        }

    }

    public boolean isPercolation() {
        int qSize = size * size;
        return unionFind.conected(qSize, qSize + 1);
    }


}
