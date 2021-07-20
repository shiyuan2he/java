package org.hsy.java.juc.cyclicbarrier;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author heshiyuan
 * @date 2021/6/7 20:06
 */
public class C_CyclicBarrierTest {
    C_CyclicBarrier barrier = new C_CyclicBarrier();
    @Test
    public void cyclicBarrier() {
        barrier.cyclicBarrier();
    }
}