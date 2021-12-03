package com.example.campus.navigation.service;



public class MatGraphClass {
    final int MAXV = 100;
    final int INF = 0x3f3f3f3f;
    int[][] edges;
    int n, e;//n是顶点数，e是边数
    String[] vexs;//存放顶点信息

    public MatGraphClass() {
        edges = new int[MAXV][MAXV];
        vexs = new String[MAXV];
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
        int INF = 0x3f3f3f3f;
        int[][] a = {{INF, 4, 3, INF, INF,INF,INF,INF},
                {4, INF, 5, 5, 9,INF,INF,INF},
                {3, 5, INF, 5, INF,INF,INF,5},
                {INF, 5, 5, INF, 7,6,5,4},
                {INF, 9, INF, 7, 3,INF,INF,INF},
                {INF,INF,INF,6,3,INF,2,INF},
                {INF,INF,INF,5,INF,2,INF,6},
                {INF,INF,5,4,INF,INF,6,INF}};

        MatGraphClass ma = new MatGraphClass();
        ma.CreateMatGraph(a, 8, 14);
        ma.vexs= new String[]{"a","b","c","d","e","f","g","h"};
        System.out.printf("    ");
        for(int i =0;i<ma.vexs.length;i++)
        System.out.print(ma.vexs[i]+" ");
        System.out.println();
        ma.DispMatGraph();

        GraphTools.Floyd(ma);
    }
}