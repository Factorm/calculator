package tools;

public class ResultFactory {

	public static boolean checkTheResult(String value1, String value2, String mathMethod, String pageResult) {

		int localValue1 = Integer.parseInt(value1);
		int localValue2 = Integer.parseInt(value2);
		float localPageResult = Float.parseFloat(pageResult);

		if (mathMethod.equals("ADD(+)")) {

			int result = localValue1 + localValue2;

			return (localPageResult == result);

		} else if (mathMethod.equals("SUBTRACT(-)")) {

			int result = localValue1 - localValue2;

			return (localPageResult == result);

		} else if (mathMethod.equals("MULTIPLY(*)")) {

			int result = localValue1 * localValue2;

			return (localPageResult == result);

		} else if (mathMethod.equals("DIVIDE(/)")) {

			int result = localValue1 / localValue2;

			return (localPageResult == result);

		} else if (mathMethod.equals("POWER(^)")) {

			int result = localValue1 + localValue2;

			return (localPageResult == result);
		}

		return true;
	}

}
