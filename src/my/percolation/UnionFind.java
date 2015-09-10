package my.percolation;

/**
 * Created by Aleksandr_Kolesov on 9/10/2015.
 */
public class UnionFind {


    int[] id;
    int[] sz;



    UnionFind(int N) {
        id = new int[N];
        sz = new int[N];

        for (int i = 0; i < N; i++) {

            id[i] = i;

            sz[i] = 1;
        }
    }


    private int root(int i)

    {

        while (i != id[i]){

            id[i] = id[id[i]];
            i = id[i];
        }
        return i;

    }

    public int find(int i) {
        return id[i];
    }

    public void union(int p, int q) {
        int i = root(p);

        int j = root(q);

        if (i == j) return;

        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        }

        else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }

    public boolean conected(int p, int q) {
        return find(p) == find(q);


    }


}
