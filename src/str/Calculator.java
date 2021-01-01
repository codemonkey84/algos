/**
 * 
 */
package str;

/**
 * @author amishra
 *
 */
public class Calculator {

	private static final String[] operators = new String[] {"+", "-", "*", "/"};

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Calculator().calculate("1 + 1"));
		System.out.println(new Calculator().calculate("5 - 1 - 1"));
		System.out.println(new Calculator().calculate("84 / 1 / 2"));
		System.out.println(new Calculator().calculate("5/2 - 2*3"));

	}

	private float calculate(String expression) {
		for (String operator: operators) {
			if (expression.contains(operator)) {
				String leftExpression = expression.substring(0, expression.lastIndexOf(operator));
				String rightExpression = expression.substring(expression.lastIndexOf(operator) + 1);
				switch (operator) {
					case "+":
						return calculate(leftExpression) + calculate(rightExpression);
					case "-":
						return calculate(leftExpression) - calculate(rightExpression);
					case "*":
						return calculate(leftExpression) * calculate(rightExpression);
					case "/":
						return calculate(leftExpression) / calculate(rightExpression);
				}
			}
		}
		return Float.valueOf(expression);
	}
}
