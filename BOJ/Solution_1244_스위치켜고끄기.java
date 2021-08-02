import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1244_스위치켜고끄기 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int button = Integer.parseInt(br.readLine());
		int[] switchState = new int[button + 1];	// 처음 스위치의 상태를 저장할 배열
		int bc = 0;									// 스위치 상태를 정수형 배열로 저장할 때 증가하는 변수
		String[] str = br.readLine().split(" ");	// 공백을 기준으로 입력받은 문자열을 나누어 하나씩 배열에 저장한다.
		// 스위치 개수만큼 반복하여 String[]에서 int[]로 변환
		while(bc < button) {		
			switchState[bc+1] = Integer.parseInt(str[bc]);
			bc++;
		}
		
		int snum = Integer.parseInt(br.readLine());	// 학생수
		
		// 학생 수만큼 학생의 성별과 학생이 받은 수를 받는 반복문
		for (int j = 0; j < snum; j++) {
			String[] stu = br.readLine().split(" ");	// 한 학생 당 성별과 받은 수를 한 줄에 입력받아서 공백으로 나눈다.
			int gen = Integer.parseInt(stu[0]);			// 학생 성별
			int studentGet = Integer.parseInt(stu[1]);	// 학생이 받은 수
			
			int cnt = 1;	// 조건별 스위치 상태 번호를 체크할 때 사용할 변수
			if (gen == 1) {
				// 남학생일때 스위치 상태 바꾸기
				while (studentGet * cnt <= button) {	// 학생이 받은 수의 배수 스위치들의 상태를 변경한다.
					if (switchState[studentGet * cnt] == 0) switchState[studentGet * cnt] = 1;		// 스위치 상태가 0이면 1로 바꾼다.
					else if (switchState[studentGet * cnt] == 1) switchState[studentGet * cnt] = 0;	// 스위치 상태가 1이면 0으로 바꾼다.
					cnt++;		
				}
			} else if (gen == 2) {
				// 여학생일 때 스위치 상태 바꾸기
				cnt = 0;
				// 좌우 대칭 위치에 있는 스위치를 비교하는데, 스위치 개수의 범위를 넘어가지 않으면서, 스위치의 좌우 상태값이 같을 때 반복
				while ((studentGet - cnt > 0) && (studentGet + cnt <= button) && switchState[studentGet - cnt] == switchState[studentGet + cnt]) {
						// 좌우 상태값이 0이면 1로 바꾼다.
						if (switchState[studentGet - cnt] == 0) {
							switchState[studentGet - cnt] = 1;
							switchState[studentGet + cnt] = 1;
						}
						// 좌우 상태값이 1이면 0으로 바꾼다.
						else if (switchState[studentGet - cnt] == 1) {
							switchState[studentGet - cnt] = 0;
							switchState[studentGet + cnt] = 0;
						}
						cnt++;
				}		
			}
		}
		
		/* 스위치 상태 한 줄에 20개씩 공백으로 구분하여 출력하기*/
		for (int k = 1; k <= button; k++) {
			System.out.print(switchState[k] + " ");
			if (k % 20 == 0) System.out.println();
		}
	}
}
