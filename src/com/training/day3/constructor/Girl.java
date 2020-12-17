package com.training.day3.constructor;

public class Girl {
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	//���û��д���췽����ϵͳ���ṩһ��Ĭ�ϵ��޲ι��췽��
	//ϵͳ�ṩ��Ĭ�ϵ��޲������췽���ȼ�������������췽��
	/**
		public Girl(){
			
		}
	*/
	/*���д�ˣ�ϵͳ�������ṩĬ�ϵĹ��췽��,�������ṩ��һ��
	 * �вι��췽��
	 */
	public Girl(String name){
		this();
		this.name = name;
		System.out.println("Girl(String name)");
	}
	
	 //���淶�ֶ��ṩһ���޲ι��췽��
	public Girl(){
		//this("aaa");
		System.out.println("Girl()");
	}
	
}
