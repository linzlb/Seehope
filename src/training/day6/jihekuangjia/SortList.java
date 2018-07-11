package training.day6.jihekuangjia;

public class SortList extends NormalList {
	public SortList(int step) {
		super(step);		
	}
	public SortList() {
		
	}
	
	public void add(Object o) {
		super.add(o);
		insertSort(this.getObjs());
	}
	
	private void insertSort(Object[] datas) {
		int i = 0;
		Object key = 0;
		for( int j = 1; j < this.getCursor()+1; j++) {
			key = datas[j];
			Comparable c = (Comparable) key;
			i = j - 1;
			while(i >= 0 && c.comparat(datas[i]) > 0) {
				 datas[i+1] = datas[i];
	             i--;
			}
			datas[i+1] = key;
		}
	}
}
