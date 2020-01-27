package com.examples;

public class FunzioniMatematiche {
	
	public double sqrt(double x) throws Exception {
		
		
		if(x==0) {
			return 0;
		}else if(x<0) {
			throw new Exception("Negative numbers not accepted");
		}		
		double y = 0;
		double z = 0;
		do{
			y++;
		}while(y*y<=x);
		
		z=x/y; //

		y= (z+y)/2; //
		
		z = x/y; //
		
		x = (z+y)/2; //
		
		return x;
		
	}
}
