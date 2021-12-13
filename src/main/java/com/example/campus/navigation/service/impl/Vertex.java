package com.example.campus.navigation.service.impl;

import javax.el.CompositeELResolver;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Vertex<T> {
        private T label;

        private List<Edge> edgeList;

        private boolean visited;

        private Vertex previousVertex;

        private double cost;

        public Vertex(T label, double cost) {
            this.label = label;
            edgeList = new LinkedList<>();
            visited = false;
            previousVertex = null;
            this.cost = cost;
        }

        public T getLabel() {
            return label;
        }

        public Iterator<Edge> getEdgeIterator() {
            return edgeList.iterator();
        }

        public int getEdgeCount() {
            return edgeList.size();
        }

        public boolean connect(Vertex endVertex, double weight) {
            Iterator<Edge> iterator = getEdgeIterator();
            Edge edge = null;
            Vertex vertex = null;
            while (iterator.hasNext()) {
                edge = iterator.next();
                vertex = edge.getEndVertex();
                if (vertex.equals(endVertex)) {
                    edge.setWeight(weight);
                    return false;
                }
            }
            edge = new Edge(this,endVertex, weight);
            edgeList.add(edge);
            return true;
        }

        public boolean disConnect(Vertex endVertex) {
            Iterator<Edge> iterator = getEdgeIterator();
            Edge edge = null;
            Vertex vertex = null;
            while (iterator.hasNext()) {
                edge = iterator.next();
                vertex = edge.getEndVertex();
                if (vertex.equals(endVertex)) {
                    iterator.remove();
                    return true;
                }
            }
            return false;
        }

        public Edge hasNeighbourVertex(Vertex endVertex) {
            Iterator<Edge> iterator = getEdgeIterator();
            Edge edge = null;
            Vertex vertex = null;
            while (iterator.hasNext()) {
                edge = iterator.next();
                vertex = edge.getEndVertex();
                if (vertex.equals(endVertex)) {
                    return edge;
                }
            }
            return null;
        }

        public boolean isVisited() {
            return visited;
        }

        public void visit() {
            this.visited = true;
        }

        public void unVisit() {
            this.visited = false;
        }

        public Vertex getUnvisitedVertex() {
            Iterator<Edge> iterator = getEdgeIterator();
            Edge edge = null;
            Vertex vertex = null;
            while (iterator.hasNext()) {
                edge = iterator.next();
                vertex = edge.getEndVertex();
                if (vertex.isVisited() == false) {
                    return vertex;
                }
            }
            return null;
        }

        public Vertex getPreviousVertex() {
            return previousVertex;
        }

        public void setPreviousVertex(Vertex previousVertex) {
            this.previousVertex = previousVertex;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }
}
