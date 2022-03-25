import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 요구사항 : 피연산자의 개수와 후위표기식이 주어지고, 피연산자에 대응하는 수가 차례로 주어졌을 때, 
 * 			계산 결과를 소수 둘째자리까지 출력해라.
 * 
 * @author chaeu
 *
 */
public class BOJ_1935_후위표기식2 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 1부터 N까지
		char[] data = br.readLine().toCharArray();
		double[] numbers = new double[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = Double.parseDouble(br.readLine());
		}
		
		Stack<Double> stack = new Stack<>();
		
		for (int i = 0; i < data.length; i++) {
			// 영대문자일 때 해당 수를 스택에 넣기
			if (data[i] >= 'A' && data[i] <= 'Z') {
				stack.push(numbers[data[i] - 'A']);
			} else {
				double b = stack.pop();
				double a = stack.pop();
				double c = calculate(data[i], a, b);
				
				stack.push(c);
			}
		}
		
		System.out.printf("%.2f", stack.peek());
	}

	private static double calculate(char c, double a, double b) {
		double result = 0;
		switch (c) {
		case '+':
			result = a + b;
			break;
		case '-':
			result = a - b;
			break;
		case '/':
			result = a / b;
			break;
		case '*':
			result = a * b;
			break;
		}
		return result;
	}

}
