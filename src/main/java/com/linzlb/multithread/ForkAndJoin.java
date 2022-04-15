package com.linzlb.multithread;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;//递归任务
import java.util.stream.LongStream;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/4/16 10:47
 * @Function: Fork and Join 工作窃取模式
 *
500000000500000000
for耗时：453毫秒
500000000500000000
fork/join耗时：270毫秒
500000000500000000
java8规约耗时：236毫秒

 */
public class ForkAndJoin extends RecursiveTask {

    public static final long THREADHOLD = 10000;
    private long start;
    private long end;

    public ForkAndJoin(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public ForkAndJoin() {
    }


    @Override
    protected Long compute() {
        long length = end - start;
        if (length <= THREADHOLD){
            long sum = 0;
            for (long i=start; i<=end; i++){
                sum += i;
            }
            return sum;
        }else {
            long middle = (start+end)/2;
            ForkAndJoin left = new ForkAndJoin(start, middle);
            left.fork();//拆分自认为，压入线程队列
            ForkAndJoin right = new ForkAndJoin(middle+1, end);
            right.fork();//拆分自认为，压入线程队列
            return (Long)left.join() + (Long)right.join();
        }
    }

    public void test1(){
        Instant start = Instant.now();
        long sum = 0L;
        for (int i=0; i<=1000000000L; i++){
            sum += i;
        }
        System.out.println(sum);
        System.out.println("for耗时："+ Duration.between(start, Instant.now()).toMillis()+"毫秒");
    }
    public void test2(){
        Instant start = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();
        ForkAndJoin c = new ForkAndJoin(0, 1000000000L);
        Long sum = (Long)pool.invoke(c);
        System.out.println(sum);
        System.out.println("fork/join耗时："+ Duration.between(start, Instant.now()).toMillis()+"毫秒");
    }
    public void test3(){
        Instant start = Instant.now();
        Long sum = LongStream.rangeClosed(0, 1000000000L)
                        .parallel().reduce(0, Long::sum);
        System.out.println(sum);
        System.out.println("java8规约耗时："+ Duration.between(start, Instant.now()).toMillis()+"毫秒");
    }
    public static void main(String[] args) {
        ForkAndJoin f = new ForkAndJoin();
        f.test1();
        f.test2();
        f.test3();
    }
}
