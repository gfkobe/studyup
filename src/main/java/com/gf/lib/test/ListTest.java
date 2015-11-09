package com.gf.lib.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

//import def.B;

public class ListTest {
    
    public Integer[] randomTable = new Integer[1000];
    
    public ListTest() {
        Random rand = new Random(1000000);
//        for (int i = 0; i < 1000; i++) {
//            randomTable[i] = rand.nextInt(1001);
////            randomTable[i] = (Integer)i;
//            System.out.print(randomTable[i] + " ");
//        }
//        System.out.println();
        
        for (int i = 0; i < 800; i++) {
            // 真正的随机数LinkedList比ArrayList慢
//            randomTable[i] = rand.nextInt();
            // LinkedList删除非常快，4.06E-4
            randomTable[i] = (Integer)(i);
        }
        for (int i = 800; i < 1000; i++) {
            // 真正的随机数LinkedList比ArrayList慢
            randomTable[i] = rand.nextInt(); 
            // LinkedList删除非常快，4.06E-4
//            randomTable[i] = (Integer)(i + 10000);
        }
    }

    public void listTest(List<Integer> list) {
//        final List<Integer> list = new LinkedList<Integer>();
        final int count = 1000000;
        long start=System.nanoTime();
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
        System.out.println((System.nanoTime()-start)/Math.pow(10, 9));
        
        start=System.nanoTime();
        for(int i=999;i>=0;i--){
        //这里要强制转型为Integer，否则调用的是remove(int)
        list.remove(randomTable[i]);
//            list.remove((Integer)i);
        }
//        for(int i=999;i>=500;i--){
//            //这里要强制转型为Integer，否则调用的是remove(int)
//            list.remove(randomTable[i]);
////            list.remove((Integer)i);
//        }
        System.out.println((System.nanoTime()-start)/Math.pow(10, 9));
    }
    
    public void arrayListTest() {
        listTest(new ArrayList<Integer>());
    }
    
    public void linkedListTest() {
        listTest(new LinkedList<Integer>());
    }
    
    public static void main(String[] args) {
        ListTest lt = new ListTest();
        /**
         * TODO 
         * ArrayList的(顺序)插入、(随机)删除性能比LinkedList好(有可能是缓存的原因，数组具有很好的空间局部性。)
         * 
         * 参见博客:http://jm-blog.aliapp.com/?p=322
         */
        lt.arrayListTest();//  0.036018  0.763265
        lt.linkedListTest();// 0.218565  2.837398
       
//        B b = new B(); 
    }
}
