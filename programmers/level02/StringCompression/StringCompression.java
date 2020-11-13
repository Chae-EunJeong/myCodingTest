/*
- 요구사항 : 문자열에서 같은 값이 연속해서 나타나면, 반복되는 만큼의 수로 표현하여 최대한 짧은 문자열로 줄여서 표현하라.
- 함수
    input : 문자열 String
    restriction : 입력된 문자열 길이는 1이상 1,000이하
                  입력된 문자열은 모두 소문자
    output : 압축된 문자열의 길이 int
- 손코딩
    1부터 (문자열의 길이/2+1)만큼 비교하는 문자 수 늘려가면서 반복
        비교 수 단위로 잘라가면서 문자열을 쭉 훑으면서 압축 가능한지 반복
            비교할 문자 단위가 마지막일 때는
                substring에 시작 인덱스만 넣어주고
            비교할 문자 단위가 마지막이 아닐 때는
                substring에 시작인덱스와 끝인덱스를 두 반복문의 변수를 사용해 자른다
            앞쪽잘린문자열과 다음 문자열이 
                같으면 
                    임의 count 변수 +1
                다르면,
                    count가 0이면 그냥 문자 그대로 추가
                    count가 1 이상이면 count, 문자 추가
- 헷갈림 포인트(문제 푸는데 정말 오래걸렸다..일주일..?조금씩 고민하긴 했지만..)
    1.반복문 변수를 이용해 substring으로 자르기 때문에 어쩔 수 없이 제일 마지막 잘리는 부분은 시작인덱스만 넣어줘야함
    2.반복문 변수 단위로 자르고 마지막에 남는 문자열을 처리해주는 조건문도 필요함
    3.substring을 미리 해서 압축하는 게 덜 복잡하더라
*/
public class StringCompression {
    public int stringCompression(String s) {
        int answer = 0;
        int count = 1;
        int minLen = s.length();
        String a = "";
        String b = "";
        StringBuilder compareStr = new StringBuilder();
        
        for(int j = 1; j < s.length()/2 + 1; j++) {
            for(int i = j; i < s.length(); i+=j) {
                a = s.substring(i-j, i);  
                //마지막 비교 substring을 할 때는 범위를 넘으면 안됨
                if(i+j >= s.length())
                    b = s.substring(i);
                else
                    b = s.substring(i, i+j);
                //a와 b가 압축이 되는지
                if(a.equals(b))
                    count++;
                else if(!a.equals(b) || (i+j >= s.length())) {
                    if(count==1) 
                        compareStr.append(a);
                    else{
                        compareStr.append(Integer.toString(count));
                        compareStr.append(a);
                    }
                    count = 1;
                }                   
            }
            
            //자르고 마지막에 남는 문자열은 그대로 붙여주기
            if (s.length() % j != 0)
                compareStr.append(s.substring(s.length()-(s.length() % j)));
            else {
                if(count != 1)
                    compareStr.append(Integer.toString(count));
                compareStr.append(s.substring(s.length()-j));
            }
            
            //최소 길이 문자열인지 비교하기
            if(compareStr.length() < minLen)
                minLen = compareStr.length();
            
            compareStr.setLength(0);
            count = 1;
        }      
        return minLen;
    }

    public static void main(String[] args) {
        StringCompression sc = new StringCompression();
        
        String test1 = "aabbaccc";
        String test2 = "ababcdcdababcdcd";
        String test3 = "abcabcdede";
        String test4 = "abcabcabcabcdededededede";
        String test5 = "xababcdcdababcdcd";

        System.out.println(sc.stringCompression(test1));
        System.out.println(sc.stringCompression(test2));
        System.out.println(sc.stringCompression(test3));
        System.out.println(sc.stringCompression(test4));
        System.out.println(sc.stringCompression(test5));
    }
}
