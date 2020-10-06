/*
- 요구사항 : 중요도가 높은 문서를 먼저 인쇄하는 프린터가 있을 때, 인쇄를 요청한 문서가 몇번째로 인쇄되는지를 반환해라.
            (프린터는 현재 대기목록의 첫번째 문서보다 우선순위가 더 높은 문서가 존재하면,
            첫번째 문서를 대기목록의 가장 뒤로 보낸다.)
- 함수
    input : 우선순위가 담긴 정수형 배열, 인쇄를 요청한 문서의 위치
    restriction : 현재 대기목록의 문서는 1개 이상 100개 이하
                인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요함
                문서의 위치는 0이상, 대기목록의 문서의 수 -1 이하
    output : 인쇄를 요청한 문서가 인쇄될 순서(int)
- 손코딩
    list의 0번째보다 큰 요소가 있는지 검사
    있으면
        list에 0번째 요소를 새로 추가 후 0번재 요소 제거
        location이 0이면 
            location += list의 길이
        location이 0이 아니면 
            location -= 1
    없으면
        list에서 제거
        인쇄수(answer + 1)
        location이 0이면
            return 인쇄수(answer)
        location이 0이 아니면
            location -= 1
- 다른 풀이

    
*/

package programmers.level02.Printer;
import java.util.Arrays;
import java.util.ArrayList;

public class Printer {
    public int printer(int[] priorities, int location) {
        int answer = 0;
        boolean check = false;
        ArrayList<Integer> priorityList = new ArrayList<>();
        
        for(int i = 0; i < priorities.length; i++)
            priorityList.add(priorities[i]);
        
        for(int j = 0; j < priorityList.size(); ){
            check = false;
            for (int k = priorityList.size()-1; k > 0; k--){
                if(priorityList.get(k) > priorityList.get(j)){
                    check = true;
                    if(j == location)
                        location = priorityList.size() -1;
                    else
                        location -= 1;
                    priorityList.add(priorityList.get(j));
                    priorityList.remove(j);
  
                    break;
                }
            }
            if(!check){
                priorityList.remove(j);
                answer += 1;
                if(j == location)
                    return answer;
                else
                    location -= 1;
            }          
        }
        return answer;
    }

    public static void main(String[] args) {
        Printer print = new Printer();
        int[] test1priorities = {2, 1, 3, 2};
        int test1location = 2;
        int[] test2priorities = {1, 1, 9, 1, 1, 1};
        int test2location = 0;
        int[] test3priorities = {1, 2, 3};
        int test3location = 3;
        System.out.println(print.printer(test1priorities, test1location));
        System.out.println(print.printer(test2priorities, test2location));
        System.out.println(print.printer(test3priorities, test3location));
    }
}
