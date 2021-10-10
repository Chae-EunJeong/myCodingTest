/*
- 요구사항 : 초단위로 기록된 주식 가격이 담긴 배열이 주어졌을 때,
            각 가격이 떨어지지 않은 기간은 몇 초 인지를 배열로 반환해라
- 함수
    input : int[] 배열
    restriction : input 배열의 각 가격은 1 이상 10,000 이하인 자연수
                input 배열의 길이는 2이상 100,000 이하
    output : int[] 배열
- 손코딩
    들어온 입력 배열의 요소 수만큼 반복문을 돌면서
        뒤의 인덱스에 있는 요소들 중 해당 요소보다 작은 요소를 만날 때 까지 반복문을 돌면서
            만나면
                만난 요스의 index - 해당 요소의 index
            안 만나면
                제일 끝 요소 - 해당 요소의 index
- 진짜 왜 스택/큐 문제인지 모르겠다. 괜히 ArrayList 써보려다가 더 복잡해지고 오래걸렸다.
- LinkedList로 했을 때는 효율성 부분에서 모두 실패를 했지만,
  ArrayList로 바꾸니까 효율성 부분에서도 바로 성공했다.
  LinkedList와 ArrayList는 왜이렇게 성능 차이가 많이 나는가?!
*/

package programmers.level02.StackPrice;
import java.util.ArrayList;

public class StackPrice {
    
    public int[] stackPrice(int[] prices) {
        int[] answer = new int[prices.length];
        ArrayList<Integer> que = new ArrayList<Integer>();
        int a; 

        for(int i = 0; i < prices.length; i++)
            que.add(prices[i]);
        
        for(int j = 0; j < que.size(); j++) {
            for (int k = j+1; k < que.size(); k++) {
                a = 0;
                answer[j] = k - j;
                if(que.get(j) > que.get(k)){
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        StackPrice sp = new StackPrice();
        int[] prices = {1, 2, 3, 2, 3};

        int[] secList = sp.stackPrice(prices);

        for(int sec : secList) {
            System.out.print(sec + " ");
        }
    }
}
