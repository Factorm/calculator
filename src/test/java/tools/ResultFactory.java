package tools;

import static java.lang.Math.*;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ResultFactory {

	public static ExtentTest test;

	public ResultFactory(ExtentTest test) {
		this.test = test;
	}

	public boolean checkTheResult(String value1, String value2, String mathMethod, String pageResult) {

		double localValue1 = Integer.parseInt(value1);
		double localValue2 = Integer.parseInt(value2);
		double localPageResult = 0;

		if (pageResult.equals("Infinity") || pageResult.equals("NaN")) {

			test.log(LogStatus.INFO, "pageResult is: " + pageResult + " it's good");
			return true;

		} else {
			localPageResult = Double.parseDouble(pageResult);
		}

		if (mathMethod.equals("ADD(+)")) {

			double result = round((localValue1 + localValue2));

			test.log(LogStatus.INFO, "pageResult is: " + localPageResult + " vs " + result + " is checkTheResult");

			return (localPageResult == result);

		} else if (mathMethod.equals("SUBTRACT(-)")) {

			double result = round((localValue1 - localValue2));

			test.log(LogStatus.INFO, "pageResult is: " + localPageResult + " vs " + result + " is checkTheResult");

			return (localPageResult == result);

		} else if (mathMethod.equals("MULTIPLY(*)")) {

			double result = round((localValue1 * localValue2));

			test.log(LogStatus.INFO, "pageResult is: " + localPageResult + " vs " + result + " is checkTheResult");

			return (localPageResult == result);

		} else if (mathMethod.equals("DIVIDE(/)")) {

			double result = round((localValue1 / localValue2));

			test.log(LogStatus.INFO, "pageResult is: " + localPageResult + " vs " + result + " is checkTheResult");

			return (localPageResult == result);

		} else if (mathMethod.equals("POWER(^)")) {

			double result = round((pow(localValue1, localValue2)));

			test.log(LogStatus.INFO, "pageResult is: " + localPageResult + " vs " + result + " is checkTheResult");

			return (localPageResult == result);

		}

		test.log(LogStatus.WARNING, "Propably bad mathMethode");
		return false;
	}

	public boolean checkTheResultWord(String pageResult) {

			if (pageResult.equals("NaN")) {

				test.log(LogStatus.INFO, "pageResult is: " + pageResult + " it's good");
				return true;

			} else {
				
				test.log(LogStatus.WARNING, "pageResult is: " + pageResult + " it's bad!!!");
				return false;
			}
	}

	static public double round(double d) {
		java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
		int ic = 18;
		nf.setMaximumFractionDigits(ic);
		nf.setMinimumFractionDigits(ic);
		return Double.parseDouble((nf.format(d)).replaceAll(",", ".").replaceAll(" ", ""));
	}

}
