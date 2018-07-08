package day5.inter2;

public class LenovoComputer extends Computer implements IUsb{
	private IUsb usb;
	
	public LenovoComputer(IUsb usb){
		super();
		this.usb = usb;
	}
	
	public void calculate(){
		System.out.println("计算。。。。。。。");
		
	}
	public void usb(){
		//这个忘了？？？？？？？？？？？？？？？？
		this.usb.usb();
	}
}
