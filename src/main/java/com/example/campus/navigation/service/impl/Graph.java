package com.example.campus.navigation.service.impl;

import java.util.*;

public class Graph<T> {
    /**
     * 用来存储顶点
     * T作为标识，vertex作为实际的顶点
     */
    private Map<T, Vertex<T>> vertexMap;

    private int edgeCount;

    boolean isDirect;

    public Graph(boolean isDirect) {
        vertexMap = new LinkedHashMap<>();
        edgeCount = 0;
        this.isDirect = isDirect;
    }

    public int getVertexCount() {
        return vertexMap.size();
    }

    public Iterator<Vertex<T>> getVertexIterator() {
        return vertexMap.values().iterator();
    }

    /**
     * 图中插入顶点
     *
     * @param label
     * @param cost
     * @return
     */
    public boolean addVertex(T label, double cost) {
        Vertex vertex = vertexMap.get(label);
        if (vertex != null) {
            // 如果已经存在，则更新权值，返回false
            vertex.setCost(cost);
            return false;
        }
        vertex = new Vertex<T>(label, cost);
        vertexMap.put(label, vertex);
        return true;
    }

    public int getEdgeCount() {
        Iterator<Vertex<T>> iterator = getVertexIterator();
        int count = 0;
        while (iterator.hasNext()) {
            Vertex<T> vertex = iterator.next();
            count = count + vertex.getEdgeCount();
        }
        return count;
    }

    /**
     * 返回图中标识为label的顶点作为出发点的边的个数
     *
     * @param label
     * @return
     */
    public int getEdgeCount(T label) {
        Vertex<T> vertex = vertexMap.get(label);
        if (vertex == null) {
            return -1;
        }
        return vertex.getEdgeCount();
    }

    /**
     * 返回图中标识为label为顶点的迭代器
     *
     * @param label
     * @return
     */
    public Iterator<Edge> getEdgeIterator(T label) {
        Vertex<T> vertex = vertexMap.get(label);
        if (vertex == null) {
            return null;
        }
        return vertex.getEdgeIterator();
    }

    /**
     * 添加边
     *
     * @param begin
     * @param end
     * @param weight
     * @return
     */
    public boolean addEdge(T begin, T end, double weight) {
        Vertex beginVertex = vertexMap.get(begin);
        Vertex endVertex = vertexMap.get(end);
        if (beginVertex == null || endVertex == null) {
            return false;
        }
        boolean result = beginVertex.connect(endVertex, weight);
        if (result) {
            edgeCount++;
        }
        if (!isDirect) {
            result = endVertex.connect(beginVertex, weight);
            if (result) {
                edgeCount++;
            }
        }
        return result;
    }

    /**
     * 删除边
     *
     * @param begin
     * @param end
     * @return
     */
    public boolean removeEdge(T begin, T end) {
        Vertex beginVertex = vertexMap.get(begin);
        Vertex endVertex = vertexMap.get(end);
        if (beginVertex == null || endVertex == null) {
            return false;
        }
        boolean result = beginVertex.disConnect(endVertex);
        if (result) {
            edgeCount--;
        }
        if (!isDirect) {
            result = endVertex.disConnect(beginVertex);
            if (result) {
                edgeCount--;
            }
        }
        return result;
    }

    public void printGraph() {
        Iterator<Vertex<T>> iteratorVertex = getVertexIterator();
        Iterator<Edge> iteratorEdge;
        Vertex<T> vertex;
        Edge edge;
        T label;
        System.out.println("图是否为有向图：" + isDirect + ",图的顶点数: " + getVertexCount() + "，图的总边个数： " + getEdgeCount());
        while (iteratorVertex.hasNext()) {
            vertex = iteratorVertex.next();
            label = vertex.getLabel();
            iteratorEdge = vertex.getEdgeIterator();
            System.out.println("顶点：" + label + ",以这个顶点为出发点的边的个数: " + getEdgeCount(label) + ", 该顶点的权值: " + vertex.getCost());
            while (iteratorEdge.hasNext()) {
                edge = iteratorEdge.next();
                System.out.println("边: 从" + label + "到" + edge.getEndVertex().getLabel() + "，权值: " + edge.getWeight() + "    ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public Object getSmallestDistance(String first, String end) {
        Set<Vertex<T>> open = new HashSet<>();
        Set<Vertex<T>> close = new HashSet<>();
        HashMap<Vertex<T>, Vertex<T>> path = new HashMap<>();
        HashMap<Vertex<T>, Double> distance = new HashMap<>();
        Set<Vertex<T>> set = getVertexSet();
        Vertex<T> firstVertex = vertexMap.get(first);
        Edge edge;

        // 第一个点不存在
        if (firstVertex == null) {
            return null;
        }

        // 初始阶段，把所有节点放入open，distance里面先初始为doubleMax，Path先初始为vertex自己
        for (Vertex<T> vertex : set) {
            open.add(vertex);
            distance.put(vertex, Double.MAX_VALUE);
            path.put(vertex, vertex);
        }

        // 将起始点放入open，distance里面先初始为doubleMax，Path先初始为vertex自己
        open.remove(firstVertex);
        close.add(firstVertex);
        distance.put(firstVertex, 0.0);
        path.put(firstVertex, firstVertex);
        Iterator<Edge> edgeIterator = firstVertex.getEdgeIterator();
        while (edgeIterator.hasNext()) {
            edge = edgeIterator.next();
            Vertex<T> endVertex = edge.getEndVertex();
            distance.put(endVertex, edge.getWeight());
            path.put(endVertex, firstVertex);
        }
        // 以初始节点为中心向外一层层遍历，获取离指定节点最近的子节点（遍历open中的vertex，找到distance最小的vertex）
        // 放入close并重新计算路径，直至close包含所有节点
        while (!open.isEmpty()) {
            Double minDistance = Double.MAX_VALUE;
            Vertex<T> minVertex = null;
            for (Vertex<T> vertex : open) {
                if (minDistance > distance.get(vertex)) {
                    // 遍历open中的vertex，找到distance最小的vertex
                    minDistance = distance.get(vertex);
                    minVertex = vertex;
                }
            }
            // 放入close并重新计算路径，直至close包含所有子节点（或者open为空）
            open.remove(minVertex);
            close.add(minVertex);
//            System.out.println("加入节点：" + minVertex.getLabel());
            edgeIterator = minVertex.getEdgeIterator();
            while (edgeIterator.hasNext()) {
                edge = edgeIterator.next();
                Vertex<T> endVertex = edge.getEndVertex();
                Double weight = edge.getWeight();
                // 如果之前的距离 > 初始到 minVertex + minVertex 到 endVertex,就替换
                if (distance.get(endVertex) > distance.get(minVertex) + weight) {
                    distance.put(endVertex, distance.get(minVertex) + weight);
                    path.put(endVertex, minVertex);
                }
            }
        }

        Vertex<T> endVertex = null;

        for (Vertex<T> vertex : set) {
            if (vertex.getLabel().equals(end)) {
                endVertex = vertex;
                break;
            }
        }

        List<T> pathList = new ArrayList<>();
        pathList.add(endVertex.getLabel());
        System.out.println("到顶点： " + endVertex.getLabel() + ", 最短距离为： " + distance.get(endVertex) + ",最后的中转点为：" + path.get(endVertex).getLabel());
        Vertex<T> vertex1 = path.get(endVertex);
        while (vertex1 != firstVertex) {
            pathList.add(path.get(vertex1).getLabel());
            System.out.println(path.get(vertex1).getLabel());
            vertex1 = path.get(vertex1);
        }

        Map<String, Object> map = new HashMap<>();

        map.put("pathList", pathList);
        map.put("minDistance", distance.get(endVertex));

        return map;
    }


    public Set<Vertex<T>> getVertexSet() {
        Set<Vertex<T>> set = new HashSet<>();
        Iterator<Vertex<T>> iteratorVertex = getVertexIterator();
        while (iteratorVertex.hasNext()) {
            set.add(iteratorVertex.next());
        }
        return set;
    }
}
