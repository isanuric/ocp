package com.isanuric.ocp.supertest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

@Component
class A {
    public A() {
        System.out.println("Constructor A");
    }

    void a() {
        System.out.println("A a");
    }
}

@Component
class B extends A {

    B() {
        super();
        System.out.println("Constructor B");
    }

    void bm1() {
        System.out.println("Super bm1");
    }

    void a() {
        System.out.println("B a");
    }
}

@SpringBootTest
class SuperExampleTest {

    @Autowired
    private B b;

    @Test
    void b() {
        b.bm1();
    }

    @Test
    void b1() {

    }
}
