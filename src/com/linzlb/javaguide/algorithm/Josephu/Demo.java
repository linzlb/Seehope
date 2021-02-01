package com.linzlb.javaguide.algorithm.Josephu;

/**
 * ���������⣬Լɪ������
 * 1 ����һ�������࣬����������ĸ�����������
   2 ������������������k(�ӵڼ���С����ʼ����)��m ��ÿ��������С����
   3 �������play()��������temp��Ϊָ�룬���ڶ���nextChileChild���ɵ�һ��nextChileChild
 */
public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CycLink cycLink = new CycLink();
		cycLink.setLen(5);
		cycLink.createLink();//��ʼ����������
		cycLink.setK(2);
		cycLink.setM(2);
		//cycLink.show();
		cycLink.play();
	}

}

class Child{
	int no;//���
	Child nextChild = null;//ָ���¸�С��
	public Child(int no){
		//��С�������
		this.no = no;
	}
}

//��������
class CycLink{
	//�ȶ���һ��ָ������,��һ��С��������
	//ָ���һ��С�������ò��ܶ�
	Child firstChild = null;
	Child temp = null;//������α�,һֱָ����һ��С��
	int len = 0;//��ʾ���м���С��
	int k = 0;//�ӵڼ�����ʼ����
	int m = 0;//��m��
	
	//���������С
	public void setLen(int len){
		this.len = len;
	}
	//���ôӵڼ����˿�ʼ����
	public void setK(int k){
		this.k = k;
	}
	//������m��
	public void setM(int m){
		this.m = m;
	}
	
	//��ʼplay
	public void play(){
		Child temp = this.firstChild;
		
		//1.���ҵ���ʼ��������,�Լ�Ҳ��һ�¡�����-1
		for(int i=1; i<=k-1; i++){
			temp = temp.nextChild;
		}
		
		
		  while(this.len!=1){
			//2.��m��,Ҳ���ܴ��Ⱥ�
			for(int j=1; j<m; j++){
				temp = temp.nextChild;
			}
			
			
			Child temp2 = temp;//�ҵ�Ҫ��Ȧ��ǰһ��С��
			System.out.println("Ҫ��Ȧ��С����"+(temp2.no));
			while(temp2.nextChild!=temp){
				temp2 = temp2.nextChild;
			}
			//3.������m��С���˳�Ȧ,������nextChildָ�����¸�
			temp2.nextChild = temp.nextChild;
			//��tempָ����һ��������С��
			temp = temp.nextChild;
			
			         
		   
			//this.show();
			this.len--;
		}
		
		
		//���һ��С��
		System.out.println("���һ��С��:"+temp.no);
	}
	
	
	//��ʼ����������
	public void createLink(){
		//��С��ѭ��
		for(int i=1;i<=len;i++){
			if(i == 1){
				//������һ��С��
				Child ch = new Child(i);
				this.firstChild =ch;//ָ���һ��С��������
				this.temp = ch;//�����α�
			}else{
				if(i == len){
					//�������һ��С��
					Child ch = new Child(i);
					temp.nextChild = ch;
					temp = ch;
					temp.nextChild = this.firstChild;
				}else{
					//��������С��
					Child ch = new Child(i);
					temp.nextChild = ch;
					temp=ch;
				}
				
			}
			
		}
	}
	
	//��ӡ�û�������
	public void show(){
		//����һ�������׵�
		Child temp = this.firstChild;
		do{
			System.err.print(temp.no+"---");
			temp = temp.nextChild;
		}while(temp!=this.firstChild);
	}
}
