package training.day2;

public class TestArray{
	public static void main(String[] args){
		testArray3();	
	}

	public static void testClone(){
		byte[] arr1 = new byte[]{1,2,3,4,5};
		byte[] arr2 = arr1.clone();
		for(int i = 0; i < arr2.length; i++){
			System.out.print(arr2[i] + " ");
		}
		System.out.println(arr1==arr2);
	}
	
	public static void testArray1(){
		//����
		int[] arry = {1, 2, 3};
		System.out.println(arry[2]);
		for(int i = 0; i < arry.length; i++){
			System.out.print(arry[i] + " ");
		}	
		System.out.println();
	}

	public static void testArray2(){
		int[] arry = new int[3];
		for(int i = 0; i < arry.length; i++){
			arry[i] = i;
			System.out.print(arry[i] + " ");
		}	
		System.out.println();
	}

	public static void testArray3(){
		int[] arry = new int[]{1,2,3};
		System.out.println(arry[2]);
		for(int i = 0; i < arry.length; i++){
			arry[i] = i;
			System.out.print(arry[i] + " ");
		}	
		System.out.println();
	}

	public static void testArray4(){
		int[] arry = {0,0};
		System.out.println("��ʼ...");
		for(int i = 0; i < arry.length; i++){
			System.out.print(arry[i] + " ");
		}	
		System.out.println();
		arry = new int[3];
		System.out.println("���...");
		for(int i = 0; i < arry.length; i++){
			System.out.print(arry[i] + " ");
		}	
	}

	/**
	public static void arraycopy(Object src, int srcPos,
                             Object dest, int destPos, int length);  
	 */

	public static void testArray5(){
		int[] arraySrc = {18,19,20,30,100};
		int[] arrayDest = new int[8];
		
		System.arraycopy(arraySrc,2, arrayDest, 5, 3);//destpos��6�Ļ����±�Խ���ˡ�
		for(int i = 0; i < arrayDest.length; i++){
			System.out.print(arrayDest[i] + " ");
		}	
	}

	public static void testArray6(){
		//int[][] array = new int[3][5];
		//int[][] array = { {1,3,5,9,9}, {7, 8, 3},{1,2} };
		int[][] array = new int[3][];

		int[] a = null;
	       	a = new int[5];

		array[0] = new int[5];	
		array[1] = new int[3];	
		array[2] = new int[2];	
		for(int i = 0;i < array.length; i++){
			for(int y =0; y < array[i].length; y++){
				System.out.print(array[i][y] +" ");
			}
			System.out.println();
		}
	}
}
