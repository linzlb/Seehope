package com.linzlb.multithread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 10.Callable��Future��Ӧ��
 */
public class CallableAndFuture {

	public static void main(String[] args) {
        //callableAndFuture();
		callableAndFuture2();
	}
	
	//һ������
	private static void callableAndFuture(){
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		//callable������ܺܳ�
		Callable<String> callable = new Callable<String>() {
			
			@Override
			public String call() throws Exception {
				Thread.sleep(2000);
				return "hello,linzlb";
			}
		};
		//callable��������ˣ�futureȥȡ���
		Future<String> future = threadPool.submit(callable);
		System.out.println("�ȴ����");
		try {
			System.out.println("�õ������"+future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	//һ������
	private static void callableAndFuture2(){
		ExecutorService threadPool2 =  Executors.newFixedThreadPool(10);
		CompletionService<Integer> completionService = 
				new ExecutorCompletionService<Integer>(threadPool2);
		//�ύһ������
		for(int i=1;i<=10;i++){
			final int seq = i;
			completionService.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					Thread.sleep(new Random().nextInt(5000));//������5��
					return seq;
				}
			});
		}
		
		//����ִ����ľ��ȴ�ӡ���������������ӣ���Ƭ�����ȸ��ĸ�
		for(int i=0;i<10;i++){
			try {
				System.out.println(
						completionService.take().get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
}