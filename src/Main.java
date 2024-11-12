import java.util.Scanner;

public class Main {

	public static void main(String[] args) {


		Scanner scanner = new Scanner(System.in);

		System.out.println("Введите первое число, арифметическую операцию и второе число через пробел");
		String input = scanner.nextLine();
		try{
			if(input.length() < 3){
				System.out.println("Cтрока не является математической операцией");
			}
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e);
		}
		System.out.println(calc(input));

		scanner.close();
	}
	static String calc(String input) {
		String result = "";
		String[] args = input.split(" ");
		String num1 = args[0];
		String operation = args[1];
		String num2 = args[2];
		int TempResult = 0;
		int num1Int = 0;
		int num2Int = 0;


		if(args.length > 3 ){
			System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)"
			);
			throw new RuntimeException();
		}
		if (Validator.validateInput(num1, num2, operation) == "roman") {
			num1Int = ConversionRoman.RomanToArabic(num1);
			num2Int = ConversionRoman.RomanToArabic(num2);
			TempResult = makeCalculation(operation, num1Int, num2Int);
			result = ConversionRoman.ArabicToRomanNum(TempResult);

		}

		else {
			num1Int = Integer.valueOf(num1);
			num2Int = Integer.valueOf(num2);
			TempResult = makeCalculation(operation, num1Int, num2Int);
			result = Integer.toString(TempResult);
		}
		return result;

	}
	static int makeCalculation(String operation, int num1Int, int num2Int){
		int temp = 0;
		switch(operation){
			case "+": temp = num1Int + num2Int;
				break;
			case "-": temp = num1Int - num2Int;
				break;
			case "/": temp = num1Int / num2Int;
				break;
			case "*": temp = num1Int * num2Int;

		}
		return temp;
	}
}