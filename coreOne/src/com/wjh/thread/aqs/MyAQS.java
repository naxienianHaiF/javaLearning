package com.wjh.thread.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by WJH on 2018年04月05日 11:38
 */
public class MyAQS implements Lock{

    private Helper helper = new Helper();

    protected class Helper extends AbstractQueuedSynchronizer{
        @Override
        protected boolean tryAcquire(int arg) {

            int state = getState();
            Thread c = Thread.currentThread();

            if (state == 0){
                if (compareAndSetState(0, arg)){
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
            }else if (getExclusiveOwnerThread() == c){
                setState(state+1);
                return true;
            }

            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            if (Thread.currentThread() != getExclusiveOwnerThread()){
                throw new RuntimeException();
            }

            int state = getState()-arg;
            boolean flag = false;

            if (getState() == 0){
                setExclusiveOwnerThread(null);
                flag = true;
            }
            setState(state);

            return flag;
        }

        protected Condition newCondition(){
            return new ConditionObject();
        }
    }

    @Override
    public void lock() {
        helper.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        helper.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return helper.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return helper.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        helper.release(1);
    }

    @Override
    public Condition newCondition() {
        return helper.newCondition();
    }
}
