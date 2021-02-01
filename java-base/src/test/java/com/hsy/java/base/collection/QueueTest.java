package com.hsy.java.base.collection;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.Queue;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.java.base.collection
 * @date 2018/7/4 11:37
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class QueueTest {
    private static final Logger logger = LoggerFactory.getLogger(QueueTest.class);
    /**
     * @description <p>
     *     队列是一种特殊的线性表，它只允许在表的前端进行删除操作，而在表的后端进行插入操作。
           LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用。
     * </p>
     * @param
     * @return
     * @author heshiyuan
     * @date 2018/7/4 13:31
     */
    @Test
    public void queueTest(){
        //add()和remove()方法在失败的时候会抛出异常(不推荐)
        Queue<String> queue = new LinkedList<String>();
        //添加元素
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
        for(String q : queue){
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("poll="+queue.poll()); //返回第一个元素，并在队列中删除
        for(String q : queue){
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("element="+queue.element()); //返回第一个元素
        for(String q : queue){
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("peek="+queue.peek()); //返回第一个元素
        for(String q : queue){
            System.out.println(q);
        }
    }

    @Test
    public void testPriorityQueue1(){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i=0;i<20;i++){
            priorityQueue.offer(new Random().nextInt(100));
        }
        for(Integer q : priorityQueue){
            System.out.print(q);
            System.out.print(" ");
        }

        System.out.println();
        for(int i=0;i<20;i++){
            System.out.print(priorityQueue.poll());
            System.out.print(" ");
        }
    }
    @Test
    public void testPriorityQueue2(){
        Comparator<User> comparator = Comparator.comparing(User::getId);
        PriorityQueue<User> priorityQueue = new PriorityQueue<>(comparator.reversed());
        for(int i=0;i<20;i++){
            User user = new User();
            user.setId(new Random().nextInt(100));
            user.setName("sss"+i);
            priorityQueue.offer(user);
        }
        for(User q : priorityQueue){
            System.out.print(q.toString());
            System.out.print(" ");
        }

        System.out.println();
        for(int i=0;i<20;i++){
            System.out.print(priorityQueue.poll());
            System.out.print(" ");
        }
    }
    class User{
        private Integer id;
        private String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}