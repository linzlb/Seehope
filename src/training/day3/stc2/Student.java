package training.day3.stc2;

public class Student {
	private static int nums;

	public static int getNums() {
		return nums;
	}

	public static void setNums(int nums) {
		Student.nums = nums;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student(String name) {
		this.name = name;
		nums++;

	}

}
