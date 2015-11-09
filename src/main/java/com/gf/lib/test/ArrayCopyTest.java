package com.gf.lib.test;

import java.util.ArrayList;
import java.util.Arrays;


    
public class ArrayCopyTest {

    /**
     * ArrayList底层数组初始大小为10，需要扩容时1.5倍增加（）。
     * 
     */
    public static void arrayListTest() {
        ArrayList<String> list = new ArrayList<String>(20);
        System.out.println(list.size());
        list.ensureCapacity(20);
        System.out.println(list.size());
        
        list.add("T");
    }
    
    public static void arrayCopyTest() {
        class MyClass{
            public int field;
            public MyClass(int field){
                this.field=field;
            }
        }
        
        MyClass a=new MyClass(1);
        MyClass b=new MyClass(2);
        MyClass c=new MyClass(3);
        MyClass[] s1={a,b,c};
        MyClass[] s2=new MyClass[3];
        
        // 都是浅拷贝
        MyClass[] s3=Arrays.copyOf(s1, s1.length);
        System.arraycopy(s1, 0, s2, 0, s1.length); 
        s2[0].field=8888;
        System.out.println(s1[0].field);// 8888
        System.out.println(s1[1]==s2[1]);// true
        System.out.println(s1==s2);// false
        
        System.out.println(s3[1].field);// 2
        s1[1].field = 1111;
        System.out.println(s3[1].field);// 1111
        
        System.out.println(s1[1]==s3[1]);// true
        System.out.println(s1==s3);// false
    }

    public static void main(String[] args) {
        arrayListTest();
        
//        arrayCopyTest();
    }
}
