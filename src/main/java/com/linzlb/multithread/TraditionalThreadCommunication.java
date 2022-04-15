package com.linzlb.multithread;

/**
 * 4.��ͳ�߳�ͬ��ͨ�ż��� wait/notify
 *
 * ���߳�ѭ��10�Σ����߳�ѭ��10�Σ����߳�ѭ��10�Σ����߳�ѭ��10�Σ����ѭ��10��
 * ���˼·��
 * 		1.���߳�ҵ��ѭ��10�Σ����߳�ҵ��ѭ��10�Σ�
 * 		2.Business������ʵ��ҵ��sub����ʵ�����߳�ҵ��main����ʵ�����߳�ҵ��
 * 		3.���ѭ��10�Σ����������ǲ������̵߳ı��subflag������Business����
 * 		4.���ѭ��10�Σ���ִ�е�ʱ��Ÿ���ѭ��
 */
public class TraditionalThreadCommunication {

    public static void main(String[] args) {
        final Business business = new Business();

        new Thread(new Runnable() {

            @Override
            public void run() {
                for(int i=1;i<=10;i++){
                    business.sub(i);
                }
            }
        }).start();

        for(int i=1;i<=10;i++){
            business.main(i);
        }
    }
}



class Business{
    private boolean subflag = true;
    public synchronized void sub(int i){
        if(subflag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int j=1;j<=10;j++){
            System.out.println("sub thread sequence of " + j + ",loop of " + i);
        }
        subflag = !subflag;
        this.notify();
    }
    public synchronized void main(int i){
        if(!subflag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int j=1;j<=10;j++){
            System.out.println("main thread sequence of " + j + ",loop of " + i);
        }
        subflag = !subflag;
        this.notify();
    }
}