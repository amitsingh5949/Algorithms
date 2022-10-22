package test;


public class Test1 {

	public static void main(String[] args) {
		/*System.out.println(Integer.compare(5,6));
		System.out.println(new Integer(5).compareTo(5));
		System.out.println(new Integer(5).doubleValue());
		System.out.println(Integer.toBinaryString(5));
		System.out.println(Integer.toString(1));*/
		
		
		
		System.out.println(new Character('c').charValue());
		System.out.println(Character.compare('5','6'));
		
		System.out.println(Character.getNumericValue('A'));
		System.out.println(Character.isDigit('A'));
		System.out.println(Character.isDigit('0'));
		
		
		
		
		System.out.println(Character.isDefined('A'));
		
		System.out.println(Character.isLowerCase('A'));
		System.out.println(Character.isLowerCase('a'));
		System.out.println(Character.isLowerCase('1'));
		System.out.println(Character.isLowerCase('@'));
		
		System.out.println(Character.isLetter('@'));
		System.out.println(Character.isLetter('a'));
		System.out.println(Character.isLetter('A'));
		System.out.println(Character.isLetter(64));
	}

}

