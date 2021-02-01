package com.linzlb.javaguide.threadpool;

import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {

    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 2;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {

        //ʹ�ð���Ͱ��Ƽ��Ĵ����̳߳صķ�ʽ
        //ͨ��ThreadPoolExecutor���캯���Զ����������
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());
//�����ǰͬʱ���е��߳������ﵽ����߳��������Ҷ���Ҳ�Ѿ�����������ʱ��ThreadPoolTaskExecutor ����һЩ����:
//**ThreadPoolExecutor.AbortPolicy**���׳� RejectedExecutionException���ܾ�������Ĵ���
//**ThreadPoolExecutor.CallerRunsPolicy**������ִ���Լ����߳���������Ҳ����ֱ���ڵ���execute�������߳�������(run)���ܾ����������ִ�г����ѹرգ���ᶪ��������������ֲ��Իή�Ͷ����������ύ�ٶȣ�Ӱ�������������ܡ��������Ӧ�ó�����Գ��ܴ��ӳٲ�����Ҫ���κ�һ����������Ҫ��ִ�еĻ��������ѡ��������ԡ�
//ThreadPoolExecutor.DiscardPolicy�� ������������ֱ�Ӷ�������
//ThreadPoolExecutor.DiscardOldestPolicy�� �˲��Խ����������δ�������������

        printThreadPoolStatus(executor);
        for (int i = 0; i < 100; i++) {
            //����WorkerThread����WorkerThread��ʵ����Runnable �ӿڣ�
            Runnable worker = new MyRunnable("" + i);
            //ִ��Runnable
            executor.execute(worker);
        }
        //��ֹ�̳߳�
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }

    /**
     * ��ӡ�̳߳ص�״̬
     * ÿ��1s��ӡ
     * @param threadPool �̳߳ض���
     */
    public static void printThreadPoolStatus(ThreadPoolExecutor threadPool) {
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println("=========================");
            System.out.println("ThreadPool Size: "+threadPool.getPoolSize());
            System.out.println("Active Threads: "+threadPool.getActiveCount());
            System.out.println("Number of Tasks : "+ threadPool.getCompletedTaskCount());
            System.out.println("Number of Tasks in Queue: "+ threadPool.getQueue().size());
            System.out.println("=========================");
        }, 0, 1, TimeUnit.SECONDS);
    }
}
