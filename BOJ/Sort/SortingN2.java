/* 2751. 수 정렬하기 2
- 요구사항 : N개의 수를 입력받아 오름차순으로 정렬해라
- 함수
  - 입력 : 입력받을 수의 개수 N(int)
           N개의 수(arr[N])
  - 제약 : 1 <= N <= 1,000,000
          arr[i] 수들은 중복되지 않으며,
          절댓값이 1,000,000 보다 작거나 같다.
  - 출력 : N개의 수(한 줄에 하나씩)가 오름차순으로 정렬된 결과
- 손코딩
	첫 번째로 입력받은 값 n을 저장한다.
	n 크기의 리스트을 생성한다.
	엔터를 기준으로 나누어 생성한 리스트에 숫자를 저장한다.
	Collections.sort를 이용해 리스트를 오름차순으로 정렬한다.
	0부터 1씩 증가하면서 n보다 작을 때까지 반복
		리스트의 수를 버퍼에 모두 모은다.
	버퍼를 출력한다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class SortingN2 {
    public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			int n = Integer.parseInt(br.readLine());
			ArrayList<Integer> arr = new ArrayList<Integer>();

			for(int i = 0; i < n; i++) {
				arr.add(Integer.parseInt(br.readLine()));
			}

			Collections.sort(arr);
			
			for(int i = 0; i < n; i++) {
				sb.append(arr.get(i)).append('\n');
			}
			System.out.println(sb);
    }
  
}
