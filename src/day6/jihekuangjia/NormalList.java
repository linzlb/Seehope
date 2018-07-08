package day6.jihekuangjia;

import day6.jihekuangjia.List;

public class NormalList extends List {
	private Object[] objs;
	private int cursor;
	private int step;
	
	public NormalList(){
		this(10);
	}
	public NormalList(int step){
		this.step = step;
		this.objs = new Object[this.step];
		this.cursor = -1;
	}

	@Override
	public void add(Object o) {
		// TODO Auto-generated method stub
		if(cursor + 1 == objs.length){
			Object[] newObjs = new Object[objs.length + step];
			System.arraycopy(objs, 0, newObjs, 0, objs.length);
			this.objs = newObjs;
		}
		objs[++cursor] = o;
	}
	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		return objs[index];
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.cursor+1;
	}

	protected Object[] getObjs() {
		return objs;
	}
	protected int getCursor() {
		return cursor;
	}
}

