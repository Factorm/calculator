package tools;

import static java.lang.Math.*;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ResultFactory {

	private static ExtentTest test = null;
	private double pageResult = 0.0; 
	private double value1 = 0.0;
	private double value2 = 0.0;

	public ResultFactory(ExtentTest oTest) {
		this.test = oTest;
	}

	public boolean checkTheResult(String sValue1, String sValue2, String sMathMethod, String sPageResult) {
		
		this.value1 = Integer.parseInt(sValue1);
		this.value2 = Integer.parseInt(sValue2);
		

		if (sPageResult.equals("Infinity") || sPageResult.equals("NaN")) {

			test.log(LogStatus.INFO, "pageResult is: " + sPageResult + " it's good");
			return true;

		} else {
			pageResult = Double.parseDouble(sPageResult);
		}

		if (sMathMethod.equals("ADD(+)")) {

			double result = round((value1 + value2));

			test.log(LogStatus.INFO, "pageResult is: " + sPageResult + " vs " + result + " is checkTheResult");

			return (pageResult == result);

		} else if (sMathMethod.equals("SUBTRACT(-)")) {

			double result = round((value1 - value2));

			test.log(LogStatus.INFO, "pageResult is: " + sPageResult + " vs " + result + " is checkTheResult");

			return (pageResult == result);

		} else if (sMathMethod.equals("MULTIPLY(*)")) {

			double result = round((value1 * value2));

			test.log(LogStatus.INFO, "pageResult is: " + sPageResult + " vs " + result + " is checkTheResult");

			return (pageResult == result);

		} else if (sMathMethod.equals("DIVIDE(/)")) {

			double result = round((value1 / value2));

			test.log(LogStatus.INFO, "pageResult is: " + sPageResult + " vs " + result + " is checkTheResult");

			return (pageResult == result);

		} else if (sMathMethod.equals("POWER(^)")) {

			double result = round((pow(value1, value2)));

			test.log(LogStatus.INFO, "pageResult is: " + sPageResult + " vs " + result + " is checkTheResult");

			return (pageResult == result);

		}

		test.log(LogStatus.WARNING, "Propably bad mathMethode");
		return false;
	}

	public boolean checkTheResultWord(String sPageResult) {

		if (sPageResult.equals("NaN")) {

			test.log(LogStatus.INFO, "pageResult is: " + sPageResult + " it's good");
			return true;

		} else {

			test.log(LogStatus.WARNING, "pageResult is: " + sPageResult + " it's bad!!!");
			return false;
		}
	}

	static public double round(double dValue) {
		java.text.NumberFormat onf = java.text.NumberFormat.getInstance();
		int ic = 18;
		onf.setMaximumFractionDigits(ic);
		onf.setMinimumFractionDigits(ic);
		return Double.parseDouble((onf.format(dValue)).replaceAll(",", ".").replaceAll(" ", ""));
	}

}
