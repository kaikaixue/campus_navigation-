package com.example.campus.navigation;

import com.example.campus.navigation.service.impl.PlaceServiceImpl;
import org.springframework.boot.test.context.SpringBootTest;

class MatGraphClass {

    final int MAXV=10;
    final int INF = 0x3f3f3f3f;
    int[][] edges;
    int n, e;//n是顶点数，e是边数
    String[] vexs;//存放顶点信息

    public MatGraphClass() {
        edges = new int[MAXV][MAXV];
        vexs = new String[MAXV];
        this.n=0;
        this.e=0;
    }
    public void insertEdges(int v1,int v2,int value) {
        edges[v1][v2] = value;
        edges[v2][v1] = value;
        this.e++;
    }


    public void CreateMatGraph(int[][] a, int n, int e) {
        this.n = n;
        this.e = e;
        for (int i = 0; i < n; i++) {
            edges[i] = new int[n];
            System.arraycopy(a[i], 0, edges[i], 0, n);
        }
    }

    public void DispMatGraph() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (edges[i][j] == INF) {
                    System.out.printf("%4s", "∞");
                } else {
                    System.out.printf("%4d", edges[i][j]);
                }
            }
            System.out.println();
        }
    }

}


class Test {
    public static void main(String[] args) {
//        final int N = new PlaceServiceImpl().getPlace().getTotal();//获取数据库中一共有多少个地址，即结点数
        int INF = 0x3f3f3f3f;
        int[][] a = {{INF, 4, 3, INF, INF,INF,INF,INF},
                {4, INF, 5, 5, 9,INF,INF,INF},
                {3, 5, INF, 5, INF,INF,INF,5},
                {INF, 5, 5, INF, 7,6,5,4},
                {INF, 9, INF, 7, INF,INF,INF,INF},
                {INF,INF,INF,6,3,INF,2,INF},
                {INF,INF,INF,5,INF,2,INF,6},
                {INF,INF,5,4,INF,INF,6,INF}};

        MatGraphClass ma = new MatGraphClass();

//        ma.insertEdges(0,1,2);
//        ma.insertEdges(0,3,3);
//        ma.insertEdges(1,2,2);
//        ma.insertEdges(1,3,1);
//        ma.insertEdges(3,4,4);

        ma.CreateMatGraph(a, 8, 14);
        ma.vexs= new String[]{"a","b","c","d","e","f","g","h"};

        ma.DispMatGraph();

        GraphTools.Dijkstral(ma,3);
    }
}

class GraphTools {
    //弗洛伊德算法
    public static void Floyd(MatGraphClass g) {
        int[][] A = new int[g.MAXV][g.MAXV];
        int[][] path = new int[g.MAXV][g.MAXV];
        for (int i = 0; i < g.n; i++)
            for (int j = 0; j < g.n; j++) {
                A[i][j] = g.edges[i][j];
                if (i != j && g.edges[i][j] < g.INF)
                    path[i][j] = i;
                else
                    path[i][j] = -1;
            }
        for (int k = 0; k < g.n; k++) {
            for (int i = 0; i < g.n; i++)
                for (int j = 0; j < g.n; j++)
                    if (A[i][j] > A[i][k] + A[k][j]) {
                        A[i][j] = A[i][k] + A[k][j];
                        path[i][j] = path[k][j];
                    }
        }

        Dispath(A, path, g);
    }

    public static void Dispath(int[][] A, int[][] path, MatGraphClass g) {
        int[] apath = new int[g.MAXV];
        int d;
        for (int i = 0; i < g.n; i++)
            for (int j = 0; j < g.n; j++) {
                if (A[i][j] != g.INF && i != j) {
                    System.out.print("  顶点" + i + "到" + j + "的最短路径长度:" +
                            A[i][j] + "\t路径:");
                    int k = path[i][j];
                    d = 0;
                    apath[d] = j;
                    while (k != -1 && k != i) {
                        d++;
                        apath[d] = k;
                        k = path[i][k];
                    }
                    d++;
                    apath[d] = i;
                    for (int s = d; s >= 0; s--)
                        System.out.print(" " + apath[s]);
                    System.out.println();
                }
            }
    }


    //狄卡特斯拉算法
    public static void Dijkstral(MatGraphClass g, int v) {
        int[] dist = new int[g.MAXV];
        int[] path = new int[g.MAXV];
        int[] S = new int[g.MAXV];
        for (int i = 0; i < g.n; i++) {
            dist[i] = g.edges[v][i];
            S[i] = 0;
            if (g.edges[v][i] < g.INF) {
                path[i] = v;
            } else {
                path[i] = -1;
            }
        }
        S[v] = 1;
        int u = -1;
        int mindis;
        for (int i = 0; i < g.n - 1; i++) {
            mindis = g.INF;
            for (int j = 0; j < g.n; j++) {
                if (S[j] == 0 && dist[j] < mindis) {
                    u = j;
                    mindis = dist[j];
                }
            }
            S[u] = 1;
            for (int j = 0; j < g.n; j++) {
                if (S[j] == 0) {
                    if (g.edges[u][j] < g.INF && dist[u] + g.edges[u][j] < dist[j]) {
                        dist[j] = dist[u] + g.edges[u][j];
                        path[j] = u;
                    }
                }
            }
        }
        DispAllPath(dist, path, S, v, g.n);
    }

    private static void DispAllPath(int[] dist, int[] path, int[] S, int v, int n) {
        int[] apath = new int[dist.length];
        int d;
        for (int i = 0; i < n; i++) {
            if (S[i] == 1 && i != v) {
                System.out.printf("  从%d到%d最短路径长度：%d\t路径：", v, i, dist[i]);
                d = 0;
                apath[d] = i;
                int k = path[i];
                if (k == -1) {
                    System.out.println("无路径");
                } else {
                    while (k != v) {
                        d++;
                        apath[d] = k;
                        k = path[k];
                    }
                    d++;
                    apath[d] = v;
                    for (int j = d; j >= 0; j--) {
                        System.out.print(apath[j] + " ");
                    }
                    System.out.println();
                }
            }
        }

    }
}
