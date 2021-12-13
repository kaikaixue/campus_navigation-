package com.example.campus.navigation.service.impl;

public class Edge {
    private Vertex beginVertex;

    private Vertex endVertex;

    private double weight;

    public Edge(Vertex beginVertex, Vertex endVertex, double weight) {
        this.beginVertex = beginVertex;
        this.endVertex = endVertex;
        this.weight = weight;
    }

    public Vertex getBeginVertex() {
        return beginVertex;
    }

    public Vertex getEndVertex() {
        return endVertex;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return this.weight;
    }
}
