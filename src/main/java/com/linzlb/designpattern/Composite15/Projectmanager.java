package com.linzlb.designpattern.Composite15;

import java.util.ArrayList;

public class Projectmanager extends Employer {
    public Projectmanager(String name) {
    	setName(name);
		employers = new ArrayList();
	}
	public void add(Employer employer) {
        employers.add(employer);
    }
    public void delete(Employer employer) {
        employers.remove(employer);
    }
}
