package core;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Context extends Op{
	
	public static final Pattern numbers = Pattern.compile("/([0-9])/");

	public String Source;
	public List<Op> OperationList;
	public Number ExpressionValue;
	
	private boolean debug = true;
	
	public Context(String source) {
		Source = source;
		int index = 0;
		char current = source.charAt(index);
		ExpressionValue.Assign(0d);
		
		source = source.replaceAll(",", ".");
		
		while (index != source.length()) {
			switch (current) {
			case '(':
				OperationList.add(new Context(source.substring(index, source.indexOf(')'))).ExpressionValue);
				break;
			}
			
			if(((new String())+current).matches("/([0-9])/")){
				OperationList.add(numberParser(source,index));
			}
			
			
			
		}

	}
	
	private Number numberParser(String s, int index) throws IllegalArgumentException{
		
		Matcher pattern = numbers.matcher(s.substring(index));
		int numberEndIndex = pattern.end(0) + index;
		
		String n = s.substring(index,numberEndIndex);
		Double d = 0d;
		
		if(numberEndIndex+1< s.length()) {
			if (s.charAt(numberEndIndex + 1)== '.') {
				try {
					numberEndIndex = pattern.end(1);
				}catch(IndexOutOfBoundsException e) {
					n += '0';
				}
			}
		}
		
		d = Double.parseDouble(n);
		
		return null;
	}

	@Override
	public Object Solve() {
		// TODO Auto-generated method stub
		return ExpressionValue;
	}

}
