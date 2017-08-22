package com.thinkinjava.myjava.chap21.bookexc.session03;

/**
 * Created by zhangzhibo-dell on 17-8-19.
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;
    public abstract int next();
    public void cancel(){
        canceled = true;
    }
    public boolean isCanceled(){
        return canceled;
    }
}
