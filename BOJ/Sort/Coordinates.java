/* 11650. 좌표 정렬하기
- 요구사항 : 2차원 평면 위의 점 N개가 주어졌을 때, 좌표를 
            x좌표가 증가하는 순으로, x좌표가 같다면 y좌표가 증가하는 순으로 정렬한 후 출력해라
- 함수
  - 입력 : 점의 개수 N(int)
           두번째줄부터 N+1번째 줄까지, 각 줄에는 i번 점의 위치 Xi와 Yi
  - 제약 : 1 <= N <= 100,000
          -100,000 <= Xi, Yi <= 100,000
          Xi, Yi는 정수이고, 위치가 같은 두 점은 없다.
  - 출력 : 첫째줄부터 N개의 줄에 점들을 정렬한 결과 출력
- 손코딩
	
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Comparator;

public class Coordinates {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n][2];
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return Integer.compare(o1[1], o2[1]);
                else
                    return Integer.compare(o1[0], o2[0]);
            }
        });

        for(int i = 0; i < n; i++) {
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
            //System.out.println(arr[i][0] + " " + arr[i][1]);
        }     
        System.out.println(sb); 
    }
}
