package tools;

import static java.lang.Math.*;
public class ResultFactory {

	public static boolean checkTheResult(String value1, String value2, String mathMethod, String pageResult) {

		double localValue1 = Integer.parseInt(value1);
		double localValue2 = Integer.parseInt(value2);
		double localPageResult = Float.parseFloat(pageResult);

		if (mathMethod.equals("ADD(+)")) {

			double result = localValue1 + localValue2;

			return (localPageResult == result);

		} else if (mathMethod.equals("SUBTRACT(-)")) {

			double result = localValue1 - localValue2;

			return (localPageResult == result);

		} else if (mathMethod.equals("MULTIPLY(*)")) {

			double result = localValue1 * localValue2;

			return (localPageResult == result);

		} else if (mathMethod.equals("DIVIDE(/)")) {

			double result = localValue1 / localValue2;

			return (localPageResult == result);

		} else if (mathMethod.equals("POWER(^)")) {

			double result = pow(localValue1, localValue2);

			return (localPageResult == result);
		}

		return true;
	}

}
