import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_1427_소트인사이드 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] tempArr = br.readLine().toCharArray();
        Integer[] arr = new Integer[tempArr.length];
        for (int i = 0; i < tempArr.length; i++) {
            arr[i] = tempArr[i] - '0';
        }
        // Arrays.sort() 에 인자로 Comparator 넣어주기 - 이미 제공되는 메서드(Collections.reverseOrder())가 있으니 그걸 사용!
        // Collections는 기본 타입 사용 불가, 대신 기본형(Integer, Character,,)등을 사용해야 함
        Arrays.sort(arr, Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

    }

}
