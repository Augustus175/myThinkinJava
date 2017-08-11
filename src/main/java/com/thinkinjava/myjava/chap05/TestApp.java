package com.thinkinjava.myjava.chap05;

/**
 * Created by zhangzhibo on 17-7-28.
 */
public class TestApp {
    public static void main(String[] args) {
        while (true){
            Book novel = new Book(true);
        }
//        System.gc();
    }

}

class Book {
    boolean checkout = false;
    Book(boolean checkout){
        this.checkout = checkout;
    }
    void  checkin(){
        this.checkout = false;
    }
    protected void finalize(){
        if (checkout){
            System.out.println(" Error");
        }
    }
}
