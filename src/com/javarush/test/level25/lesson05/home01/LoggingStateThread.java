package com.javarush.test.level25.lesson05.home01;

/**
 * Created by M.E.R.lin on 02.12.2015.
 */
public class LoggingStateThread extends Thread{
    Thread thread;
    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        this.setDaemon(true);
        //System.out.println(thread.getState());
    }

    @Override
    public void run() {
        State state=thread.getState();
        System.out.println(state);
        while (state!=State.TERMINATED){
            if (state!=thread.getState()){
                state=thread.getState();
                System.out.println(state);
            }
        }
    }
}
