import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 요구사항 : 1번부터 N번까지의 카드가 차례로 쌓여서 놓여져있을 때,
 * 			제일 위에 있는 카드를 버리고, 그다음 제일 위의 카드를 제일 아래로 옮기는 과정을 카드가 한장 남을 때까지 반복한 후
 * 			제일 마지막에 남게 되는 카드를 구해라
 * 입력 : 카드의 개수 N
 * 출력 : 제일 마지막에 남은 카드 번호 answer
 * 제약 : 1 <= N <= 500000
 * 
 * @author chaeu
 *
 */
public class BOJ_2164_카드2 {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		for (int n = 1; n <= N; n++) {
			queue.offer(n);
		}
		
		while (queue.size() > 1) {
			queue.poll();
			int back = queue.poll();
			queue.offer(back);
		}
		System.out.println(queue.poll());
	}

}
