package mediaalpha;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class RemoveUnnesessaryParenthesis {

	public static final Map<Character, Integer> PRECEDENCE = new HashMap<>();

	public static final List<Character> OPERATOR = new ArrayList<>();

	public static final List<Character> BRACKETS = new ArrayList<>();


	public static void main(String[] args) {

		String[] arr = {
				"1*(2+(3*(4+5)))",
				"2 + (3 / -5)",
				"(1 + 2 + 3)",
				"4 + (3 * 5)",
				"(2 + 4) + 6",
				"2 + (6 / (5 * 4 + 5))",
				"(((((((((( 1 + 2))))))))))",
				"(2 + 5) / 4",
				"2 + 3 + (-5)",
				"(1 + ((2 * 4) * 9 + 7) * 9)",
			    "x+(y+z)+(t+(v+w))",
			    "1+(2+3)+4",
			    "4 - (4 - 2 + 1)",
			    "4 - (4 - 2) * 9",
			    "4 - (4 - 2) / 2",
			    "2 * (4 - (4 - 2))",
			    "6-(4-2)",
			    "8/(4/2)",
			    "(8/4)/2",
			    "(-1)+1",
			    "1+(-1)",
			    "34*(-1)",
			    "34/(-1)",
			    "(-1)/2",
			    "1*(1-(2*(-1)))",
			    "1*(1-(2/(-1)))",
				"(-1)/2",
				"-1/(+2)"
		};


		for(String expression : arr) {

			//System.out.println("Original Expression :" + expression);

			initialise();

			expression  = sanitize(expression);

			//System.out.println("Sanitized Expression :" + expression);

			List<String> tokenList = tokenize(expression);

			//System.out.println(tokenList);

			tokenList = removeExtraParenthesis(tokenList);

			String compressed = reconstructExression(tokenList);

			//System.out.println(outputExpression);
			
			System.out.println("is Orginal Expression : " +  expression + 
					" equal to compressed expression : " + compressed + "? "  + 
					eval(expression, compressed));
		}
	}

	public static void initialise() {

		PRECEDENCE.put(Character.valueOf('*'),2);
		PRECEDENCE.put(Character.valueOf('/'),3	);
		PRECEDENCE.put(Character.valueOf('+'),1);
		PRECEDENCE.put(Character.valueOf('-'),1);

		OPERATOR.add(Character.valueOf('+'));
		OPERATOR.add(Character.valueOf('-'));
		OPERATOR.add(Character.valueOf('*'));
		OPERATOR.add(Character.valueOf('/'));

		BRACKETS.add(Character.valueOf('('));
		BRACKETS.add(Character.valueOf(')'));

	}

	public static String sanitize(String expression) {
		return expression.replaceAll(" ", "");
	}

	public static List<String> tokenize(String expression){

		List<String> tokenList = new ArrayList<String>();

		int indexOfLastDigit = -2;
		int indexOfLastOperator = -2;

		boolean mergeOperators = false;

		char firstCharacter = expression.charAt(0);
		tokenList.add(Character.valueOf(firstCharacter).toString());

		if(OPERATOR.contains(firstCharacter)) {
			indexOfLastOperator = 0;
			mergeOperators = true;
		}
		else if((Character.isLetter(firstCharacter) || Character.isDigit(firstCharacter)) && !BRACKETS.contains(firstCharacter)) {
			indexOfLastDigit = 0;
		}

		for(int index=1; index<expression.length(); index++) {

			char currChar = expression.charAt(index);

			if(BRACKETS.contains(currChar)) {
				tokenList.add(Character.valueOf(currChar).toString());
			}
			else if(OPERATOR.contains(currChar)) {
				tokenList.add(Character.valueOf(currChar).toString());
				if((index - indexOfLastOperator) == 1 || indexOfLastDigit == -2 || expression.charAt(index-1) == BRACKETS.get(0)) {
					mergeOperators = true;
				}
				indexOfLastOperator = index;
			}
			else if(Character.isDigit(currChar) || Character.isLetter(currChar)) {
				//.out.println(index);
				//System.out.println(indexOfLastDigit);
				//System.out.println(mergeOperators);
				if((index - indexOfLastDigit) == 1) {
					String lastToken = tokenList.remove(tokenList.size()-1);
					tokenList.add(lastToken + currChar); 
				}
				else if(mergeOperators) {
					String lastToken = tokenList.remove(tokenList.size()-1);
					tokenList.add(lastToken + currChar); 
					mergeOperators = false;
				}
				else {
					tokenList.add(Character.valueOf(currChar).toString());
				}
				indexOfLastDigit = index;
			}
			else {
				tokenList.add(Character.valueOf(currChar).toString());
			}

		}
		//System.out.println(tokenList.toString());
		return tokenList;
	}

	public static List<String> removeExtraParenthesis(List<String> tokenList){

		for(int index=0; index<tokenList.size(); index++) {

			String currToken = tokenList.get(index);

			if(currToken.charAt(0) == BRACKETS.get(0)) {
				int openingBracketIndex = index;
				int closingBarcketIndex = getMatchingClosingBracketIndex(openingBracketIndex, tokenList);
				boolean removeLeftBracket = isRedundantBracket(openingBracketIndex, tokenList);
				boolean removeRightBracket = isRedundantBracket(closingBarcketIndex, tokenList);
				//System.out.println("removeLeftBracket : " + removeLeftBracket);
				//System.out.println("removeRightBracket : " + removeRightBracket);
				if(removeLeftBracket && removeRightBracket) {
					tokenList.set(openingBracketIndex, ";");
					tokenList.set(closingBarcketIndex, ";");
				}
			}
		}
		return tokenList;
	}

	public static int getMatchingClosingBracketIndex(int openingBracketIndex, List<String> tokenList) {

		Stack<String> stack = new Stack<>();
		stack.push(tokenList.get(openingBracketIndex));

		int index = openingBracketIndex + 1;

		while(!stack.isEmpty()) {
			String currToken = tokenList.get(index);
			if(currToken.charAt(0) == BRACKETS.get(0)) {
				stack.push(currToken);
			}
			else if(currToken.charAt(0) == BRACKETS.get(1)) {
				stack.pop();
			}
			index += 1;
		}
		return index-1;
	}

	public static boolean isNumeric(String str) { 
		try {  
		  Integer.parseInt(str);  
		  return true;
		} catch(NumberFormatException e){  
		  return false;  
		}  
	  }

	public static boolean isRedundantBracket(int bracketIndex,  List<String> tokenList) {

		String previousToken = null;
		String nextToken = null;

		int index = bracketIndex;
		String token = null;
		
		if(index > 0 ) {
			token = tokenList.get(index-1);
			while(index > 0) {

				if(OPERATOR.contains(token.charAt(0))) {
					previousToken = token;
					break;
				}
				else if(BRACKETS.contains(token.charAt(0))) {
					break;
				}
				index -= 1;
				token = tokenList.get(index);
			}
		}

		index = bracketIndex;
		if(index+1 < tokenList.size()) {
			token = tokenList.get(index+1);

			while(index+1 < tokenList.size()) {
				if(OPERATOR.contains(token.charAt(0))) {
					nextToken = token;
					break;
				}
				else if(BRACKETS.contains(token.charAt(0))) {
					break;
				}
				index += 1;
				token = tokenList.get(index);
			}
		}
		//.out.println("previousToken : " + previousToken);
		//System.out.println("nextToken : "  + nextToken);
		if(isNumeric(previousToken) || isNumeric(nextToken)){
			return true;
		}
		if(tokenList.get(bracketIndex).charAt(0) == BRACKETS.get(0) ) {

			if(previousToken == null || nextToken == null) {
				return true;
			}
			else if( PRECEDENCE.get(previousToken.charAt(0)) == PRECEDENCE.get(nextToken.charAt(0))) {
				//System.out.println(PRECEDENCE.get(previousToken.charAt(0)) % 2);
				if(OPERATOR.indexOf(previousToken.charAt(0)) % 2 == 0 && OPERATOR.indexOf(nextToken.charAt(0)) % 2 == 0) {
					return true;
				}
				else {
					return false;
				}
					
			}
			else if( PRECEDENCE.get(previousToken.charAt(0)) < PRECEDENCE.get(nextToken.charAt(0))) {
				return true;
			}
			else if( PRECEDENCE.get(previousToken.charAt(0)) > PRECEDENCE.get(nextToken.charAt(0))) {
				return false;
			}

		}
		
		else if(tokenList.get(bracketIndex).charAt(0) == BRACKETS.get(1) ) {
			if(previousToken == null || nextToken == null) {
				return true;
			}
			else if( PRECEDENCE.get(previousToken.charAt(0)) == PRECEDENCE.get(nextToken.charAt(0))) {
				return true;
			}
			else if( PRECEDENCE.get(previousToken.charAt(0)) < PRECEDENCE.get(nextToken.charAt(0))) {
				return false;
			}
			else if( PRECEDENCE.get(previousToken.charAt(0)) >= PRECEDENCE.get(nextToken.charAt(0))) {
				return true;
			}
		}
		return false;
	}

	public static String reconstructExression(List<String> tokenList) {
		String res = "";
		for(String token : tokenList) {
			res += token;
		}
		return res.replaceAll(";", "");
	}

	public static boolean eval(String original, String compressed) {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		Number resultOriginal = null;
		Number resultCompressed = null;
		try {
			resultOriginal = (Number)engine.eval(original);
			resultCompressed = (Number)engine.eval(compressed);
			assert resultOriginal.intValue() == resultCompressed.intValue();
		} catch (ScriptException e) {
			//e.printStackTrace();
		}
		return true;
		
	}
}
