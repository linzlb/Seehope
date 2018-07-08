package day7.myStack;

public class MyStack2{
	private char data[] = new char[10];
	private int point = 0;
	void push(char c){
		/*data[point] = c;
		point++;*/
		//对上面原始版代码做同步
		synchronized (this) {
			data[point] = c;
			point++;
		}
	}
	char pop(){
		/*point--;
		return data[point];*/
		//对上面原始版代码做同步
		synchronized (this) {
			point--;
			return data[point];
		}
	}
	int len(){
		return point;
	}
	
	public static void main(String[] args) {
		MyStack2 ms = new MyStack2();
		ms.push('a');
		ms.push('b');
		ms.push('c');
		ms.push('d');
		ms.push('e');
		ms.push('f');
		ms.push('g');
		System.out.println("栈的长度为："+ms.len());
		int len = ms.len();
		for(int i = 0;i<len;i++){
			System.out.print(ms.pop()+"  ");
		}
	}

}
