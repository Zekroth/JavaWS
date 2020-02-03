package calcolo_date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CalcoloSecondi {
	
	private final static int[] incrementFactorArray = { 60, 60, 24, 365};
	private final static int[] getIncrementFactorArray(int length) {
		if(length != incrementFactorArray.length) {
			int[] newIncrementFactorArray = new int[length];
			
			if(length < incrementFactorArray.length)
				for(int i = 0; i < length; i++) {
					newIncrementFactorArray[i] = incrementFactorArray[i];
				}
			
			if(length > incrementFactorArray.length)
				for(int i = incrementFactorArray.length	; i < length; i++) {
					newIncrementFactorArray[i] = 1;
				}
			
			return newIncrementFactorArray;
		}else {
			return incrementFactorArray;
		}
	}
	private final static int getIncrementFactor(int index) {
		int factor = 1;
		int[] array = getIncrementFactorArray(index);
		for(int i = 0; i < index; i++) {
			factor *= array[i];
		}
		//System.out.println(factor);
		return factor;
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ParseException {
			
		Scanner input = new Scanner(System.in);
		String data = input.nextLine();
		StringTokenizer st = new StringTokenizer(data);
		Long result = 0l;
		
		ArrayList<Long> list = new ArrayList<Long>();
		int i = 0;
		while(st.hasMoreTokens()) {
			
			list.add(new Long(st.nextToken(",")));
			i++;
		}
		
		try {

			/*for (int n : getIncrementFactorArray(i)) {
				System.out.print(n + "\t");
			}*/
			//System.out.println(getIncrementFactor(2));
			for(int h = 0; i > 0; i--, h++) {
				//System.out.println(getIncrementFactor(h));
				result += list.get(i-1)*getIncrementFactor(h);
			}
			
		}
		catch(IndexOutOfBoundsException e) {
			System.out.println("Cipolle");
			e.printStackTrace();
		}
		
		System.out.println(result);
	}

}
