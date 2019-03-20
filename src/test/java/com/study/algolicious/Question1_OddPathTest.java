package com.study.algolicious;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.skiena.chapter5.graph.Graph;

class Question1_OddPathTest {

    @Test
    void isThereAnOddPath() throws IOException {
        Graph g = TestGraphSource.oddPath();
        Question1_OddPath alg = new Question1_OddPath();
        alg.isThereAnOddPath(g, g.getVertex(1), g.getVertex(5));
    }

    @Test
    void isThereAnOddPath_1() throws IOException {
        Graph g = TestGraphSource.oddPath_1();
        Question1_OddPath alg = new Question1_OddPath();
        alg.isThereAnOddPath(g, g.getVertex(1), g.getVertex(5));
    }

}