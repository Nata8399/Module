package com.alevel.module;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.PriorityQueue;

public class Huffman {

    class Node implements Comparable<Node> {
        final int sum;

        public Node(int sum) {
            this.sum = sum;
        }

        public int compareTo(Node o) {
            final int compare = Integer.compare(sum, o.sum);
            int i = compare;
            return i;
        }
    }

    class InternalNode extends Node {
        Node left;
        Node right;

        public InternalNode(Node left, Node right) {
            super(left.sum + right.sum);
            this.left = left;
            this.right = right;
        }
    }

    class LeafNode extends Node {
        char symbol;

        public LeafNode(char symbol, int count) {
            super(count);
            this.symbol = symbol;
        }
    }

    public void write(String fileName, String text) {
        File file = new File(fileName);
        try {
            if (!file.exists()) {
                if (!file.createNewFile()) {
                    throw new RuntimeException("Where my fuckin' file?");
                }
            }
            try (PrintWriter out = new PrintWriter(file.getAbsoluteFile())) {
                out.print(text);
            }
        } catch (IOException ololo) {
            throw new RuntimeException(ololo);
        }

        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>();
    }

    public static void main(String[] args){


        long startTime = System.currentTimeMillis();
        new Huffman();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");

    }



}



