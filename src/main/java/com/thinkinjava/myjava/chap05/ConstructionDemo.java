package com.thinkinjava.myjava.chap05;
/**
 * Created by zhangzhibo-dell on 17-10-07.
 */
class father{
    public father(int a){}
}
class son extends father{
    int i;
    public  son(){
        super(1);
    }
    public son(int w){
//        super(2);
        this();
        this.i=w;
    }
}
public class ConstructionDemo {

}
