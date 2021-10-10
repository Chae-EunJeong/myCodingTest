/* 10818. 최소, 최대
- 요구사항 : N개의 정수를 입력 받으면 그 중 최솟값과 최댓값을 출력해라
- 함수 
    - input : 정수의 개수 N
              N개의 정수
    - restriction : 1 <= n <= 1000000
                    -1000000 <= 각 정수 <= 1000000
    - output : 최솟값 a 최댓값 b
- split 대신 StringTokenizer도 있다는거.
    - 그러면 처음 max, min 초기화를 못시키는데, 이때 Integer 클래스의 MIN_VALUE, MAX_VALUE를 사용하면
    - 정수의 최대값(2,147,483,647)과 최소값(-2,147,483,648)로 설정 가능하다.
- 최솟값, 최댓값을 일일히 비교하지 않아도 Math 라이브러리의 함수를 사용할 수 있다.
    - Math.max(max, n_arr[i])
    - Math.max(min, n_arr[i])
*/

package BOJ.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinAndMax {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] n_arr = new int[n];
        for (int i = 0; i < n; i++) {
            n_arr[i] = Integer.parseInt(str[i]);
        }
        int max = n_arr[0];
        int min = n_arr[0];

        for(int i = 1; i < n; i++) {
            if(max < n_arr[i]) {
                max = n_arr[i];
            }

            if(min > n_arr[i]) {
                min = n_arr[i];
            }
        }

        System.out.println(min + " " + max);

        br.close();
    }
}
