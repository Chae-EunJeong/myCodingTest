import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Data structure - Queue
 * 참가자들이 피자 한조각을 받기 위해 큐 구조로 줄을 서고, 더 먹기 위해선 하나 받고 또 큐의 맨 뒤로 줄선다.
 * 요구사항 : 각 학생들이 먹어야 할 피자 조각 수가 주어졌을 때, 각 학생들이 기다려야하는 시간을 구해라.
 * 
 * 풀이
 * 	- 참가자 클래스는 먹어야할 피자 조각 수, 걸린 시간 수 를 저장함
 * 	- 큐는 1초씩 증가함
 * 		- 현재 참가자의 걸린 시간을 (전체 초 - 저장된 시간 초) 한 만큼을 더한다.
 * 		- 현재 참가자가 먹어야하는 피자 조각 수를 하나 뺀다.
 * 		- 현재 참가자가 먹어야하는 피자 조각 수가 0이 아니면 큐에 다시 넣는다.
 * @author chaeu
 *
 */
public class BOJ_15235_OlympiadPizza {

	static class Contestant {
		int time;
		int slice;
		
		public Contestant (int time, int slice) {
			this.time = time;
			this.slice = slice;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// the number of contestants
		String[] data = br.readLine().split(" ");
		Contestant[] contestants = new Contestant[N];
		Queue<Contestant> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			contestants[i] = new Contestant(0, Integer.parseInt(data[i]));
			queue.offer(contestants[i]);
		}
		
		int totalTime = 1;
		while(!queue.isEmpty()) {
			Contestant curC = queue.poll();
			curC.time += (totalTime - curC.time);
			curC.slice -= 1;
			if (curC.slice != 0) {
				queue.offer(curC);
			} 
			totalTime++;
		}
		for (int i = 0; i < N; i++) {
			System.out.print(contestants[i].time + " ");
		}
	}
}
