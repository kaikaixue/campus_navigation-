package com.example.campus.navigation.service;

public class GraphTools {
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
                    System.out.print("  顶点" + g.vexs[i] + "到" + g.vexs[j] + "的最短路径长度:" +
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
