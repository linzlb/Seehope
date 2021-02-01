package com.linzlb.javaguide.multithread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 10.Callable与Future的应用
 */
public class CallableAndFuture {

	public static void main(String[] args) {
        //callableAndFuture();
		callableAndFuture2();
	}
	
	//一个任务
	private static void callableAndFuture(){
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		//callable任务可能很长
		Callable<String> callable = new Callable<String>() {
			
			@Override
			public String call() throws Exception {
				Thread.sleep(2000);
				return "hello,linzlb";
			}
		};
		//callable任务完成了，future去取结果
		Future<String> future = threadPool.submit(callable);
		System.out.println("等待结果");
		try {
			System.out.println("拿到结果："+future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	//一组任务
	private static void callableAndFuture2(){
		ExecutorService threadPool2 =  Executors.newFixedThreadPool(10);
		CompletionService<Integer> completionService = 
				new ExecutorCompletionService<Integer>(threadPool2);
		//提交一组任务
		for(int i=1;i<=10;i++){
			final int seq = i;
			completionService.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					Thread.sleep(new Random().nextInt(5000));//不超过5秒
					return seq;
				}
			});
		}
		
		//最先执行完的就先打印出来，类似收麦子，哪片先熟先割哪个
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