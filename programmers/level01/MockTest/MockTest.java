/*
- 요구사항 : 1번, 2번, 3번 수포자가 찍는 방식에 따라, 정답 배열이 입력되었을 때 제일 많이 맞춘 사람을 배열로 반환하라
  - 1번 수포자 : 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
  - 2번 수포자 : 2, 1, 2, 3, 2, 4, 2, 5, ...
  - 3번 수포자 : 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
- 함수
    input : 정수 배열 
    restriction : 입력값 배열의 길이는 최대 10,000(문제)
                  문제에 대한 답은 5지선다형
                  최고 득점자가 여럿이면 오름차순 정렬
    output : 정수 배열 
- 손코딩
    정수 배열 answers 입력받기
    answers 배열 길이만큼 for 문 반복
        1번 수포자 5번씩 반복
            5개마다 일치하는 게 있으면 1번의 점수 +1
        2번 수포자 8번씩 반복
            8개마다 일치하는 게 있으면 2번의 점수 +1
        3번 수포자 10번씩 반복
            10개마다 일치하는 게 있으면 3번의 점수 +1
    1번의 점수, 2번의 점수, 3번의 점수를 비교해서 가장 높은 사람을 배열에 추가 후 반환
- 뭔가 될듯 말듯 해서, 완전 탐색이니까 노가다로 짰지만, 이중for문까지는 필요 없었다..
  - answers 길이만큼 반복하면서, 길이에서 각 수포자의 배열 길이를 나눈 나머지를 사용하면 계속 그 정답 배열을 반복할 수 있는데,,쉽게,,
- 최댓값을 Math.max 함수를 이용하는 방법도 있다.
- 마지막에 리스트에서 배열로 바꿀 때, 람다식 이용하는 것도 기억해두자
  - list.stream().mapToInt(i->i.intValue()).toArray();
*/

import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        int a = 0, b = 0, c = 0;
        int onelen = answers.length / one.length + 1;
        int twolen = answers.length / two.length + 1;
        int threelen = answers.length / three.length + 1;
        int max = 0, ans = 0;
        
        for(int i = 0; i < onelen; i++) {
            for(int j = 0; j < one.length; j++) {
                if(answers.length <= (j + (one.length * i)))
                    break;
                if(answers[(j + (one.length * i))] == one[j]) 
                    a += 1; 
            }
        }
        
        for(int i = 0; i < twolen; i++) {
            for(int j = 0; j < two.length; j++) {
                if(answers.length <= (j + (two.length * i)))
                    break;
                if(answers[(j + (two.length * i))] == two[j]) 
                    b += 1; 
            }
        }
        
        for(int i = 0; i < threelen; i++) {
            for(int j = 0; j < three.length; j++) {
                if(answers.length <= (j + (three.length * i)))
                    break;
                if(answers[(j + (three.length * i))] == three[j]) 
                    c += 1; 
            }
        }

        
        max = a > b ? (a > c ? a : c) : (b > c ? b : c);
        ArrayList<Integer> listAns = new ArrayList<>();
        
        if(max == a)
            listAns.add(1);
        if(max == b)
            listAns.add(2);
        if(max == c)
            listAns.add(3);
        
        answer = new int[listAns.size()];

        for(Integer i : listAns)
            answer[ans++] = i;
        
        return answer;
    }
}