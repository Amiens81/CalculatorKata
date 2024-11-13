import java.util.*;

class Validator {
	static boolean isRoman(String inputStr){
		return inputStr.matches("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");

	}

	static boolean isStringInt(String s)
	{
		try
		{
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException ex)
		{
			return false;
		}
	}

	static String validateInput(String input1, String input2, String operator)  {
		String result = "";

		if (!operator.matches("[-+*/]{1}")) {
			throw new RuntimeException("Операция не подходит под заданый тип [+,-,*,/]");
		}
		if (isRoman(input1) != isRoman(input2)){
			System.out.println("Используются одновременно разные системы счисления");
			throw new RuntimeException();
		}
		if (!isRoman(input1) && !isRoman(input2) && (!isStringInt(input1) || !isStringInt(input1))) {
			throw new RuntimeException("Римские цифры выходят за рамки или числа не имеют типа int");
		}

		int num1 = 0;
		int num2 = 0;

		if(isRoman(input1)) {
			ConversionRoman romanOperation = new ConversionRoman();
			num1 = romanOperation.RomanToArabic(input1);
			num2 = romanOperation.RomanToArabic(input2);
		}
		else {
			num1 = Integer.parseInt(String.valueOf(input1));
			num2 = Integer.parseInt(String.valueOf(input2));
		}

		if (((num1 < 0) || (num1 > 10)) || ((num2 < 0) || (num2 > 10))) {
			System.out.println("Число вне числового интервала! Используйте числа от 1 до 10");
			throw new RuntimeException();

		}



		if (isRoman(input1)) {
			result = "roman";
		}
		else {
			result = "decimal";
		}

		return result;
	}


}