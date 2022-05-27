package ca.sheridancollege.sin11368.beans;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {
	
	private int id;
	private String name;
	private String emp_id;
	private double su_hr;
	private double mo_hr;
	private double tu_hr;
	private double we_hr;
	private double th_hr;
	private double fr_hr;
	private double sa_hr;
	private double wage;
	
	public double getTotal() {
		double total = su_hr + mo_hr+ tu_hr + we_hr + th_hr + fr_hr + sa_hr ;
		return total;
	}
	
	public double getAverage() {
		double average = (su_hr + mo_hr+ tu_hr + we_hr + th_hr + fr_hr + sa_hr)/7.0;
		return average;
	}
	
	public double getPay() {
		double pay;
		if(getTotal()<=40) {
			pay = getTotal() * getWage();
		}else {
			pay = ((getTotal() - 40)*(getWage()*1.5)) + (40 * getWage());
		}
		return pay;
			
	}

}
