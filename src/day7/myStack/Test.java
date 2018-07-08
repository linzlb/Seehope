package day7.myStack;

public class Test {
	public static void main(String[] args) {
		MyStack sk = new MyStack();
		sk.push(1);
		sk.push(2);
		sk.push(50);
		sk.push(22);
		int s = sk.size();
		System.out.println("sk 大小:" + sk.size());
		for(int i = 0; i < s; i++){
			//System.out.println("sk.peek()"+sk.peek());//查看栈顶对象而不移除它
			System.out.println(sk.pop());
			
		}
		System.out.println("sk 大小:" + sk.size());
		System.out.println("--------------------");
		MyQueue sq = new MyQueue();
		sq.push(1);
		sq.push(2);
		sq.push(50);
		sq.push(22);
		int s2 = sq.size();
		System.out.println("sq 大小:" + sq.size());
		for(int i = 0; i < s2; i++){
			//System.out.println(sk.peek());
			System.out.println(sq.pop());
			
		}
		System.out.println("sq 大小:" + sk.size());
	}

}
