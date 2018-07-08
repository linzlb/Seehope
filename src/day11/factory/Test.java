package day11.factory;

public class Test {

	/**
	 * @param args
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		Driver driver = 
			DriverFactory.createDriver("hp");
		Driver driver1 = 
			DriverFactory.createDriver("dell");
		driver.install();
		driver1.install();
	}

}
