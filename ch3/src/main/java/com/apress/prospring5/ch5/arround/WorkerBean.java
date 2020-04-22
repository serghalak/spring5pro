package com.apress.prospring5.ch5.arround;

public class WorkerBean {
    public void doSomeWork(int noOftimes){
        for (int i = 0; i < noOftimes; i++) {
            work();
        }
    }

    private void work(){
        System.out.print("");
    }
}
