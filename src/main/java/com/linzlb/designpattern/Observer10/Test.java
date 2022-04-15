package com.linzlb.designpattern.Observer10;

public class Test {
	public static void main(String[] args) {
        Policeman thPol = new TianHePoliceman();
        Policeman hpPol = new HuangPuPoliceman();
        Citizen citizen = new HuangPuCitizen(hpPol);
        citizen.sendMessage("unnormal");
        citizen.sendMessage("normal");
        System.out.println("===========");
        citizen = new TianHeCitizen(thPol);
        citizen.sendMessage("normal");
        citizen.sendMessage("unnormal");
    }
}
