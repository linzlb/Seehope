package com.linzlb.labuladong.coreroutine;

import java.util.HashMap;
import java.util.Map;

/*
 * 可以说明动态规划的重叠子问题
 * f(0)=1;
 * f(1)=1;
 * f(n)=f(n-1)+f(n-2);
 */
public class Fibonacci {

	public static void main(String args[]){
//		int num = 6;
//		for(int i=0; i<num+1; i++){
//			System.out.println("f("+i+")="+ fibonacci(i));
//		}
		Fibonacci instance = new Fibonacci();
		//System.out.println("f(100)="+ instance.fibonacci(100));//半天都出不来
		System.out.println("f(30)="+ instance.fibonacci2(30));
		System.out.println("f(30)="+ instance.fibonacci3(30));
	}

	//直接递归，速度很慢，暴力递归 时间复杂度是2的n次方，指数级别
	private int fibonacci(int n){
		//digui
		if(n<=1) return 1;
		return fibonacci(n-1)+fibonacci(n-2);
	}

	//1.备忘录优化 自顶向下
	Map<Integer, Integer> memo = new HashMap();
	private int fibonacci2(int n){
		return helper(memo, n);
	}
	//借助备忘录存储数据
	private int helper(Map<Integer, Integer> memo, int n){
		if(n<=1) return 1;
		if(memo.containsKey(n)){
			return memo.get(n);
		}
		int result = fibonacci2(n-1)+fibonacci2(n-2);
		memo.put(n, result);
		return result;
	}

	//2.dp数组优化 自底向上
	private int fibonacci3(int n){
		if (n<2){
			return 1;
		}
		int dp[] = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++)
			dp[i] = dp[i - 1] + dp[i - 2];
		return dp[n];
	}


}
