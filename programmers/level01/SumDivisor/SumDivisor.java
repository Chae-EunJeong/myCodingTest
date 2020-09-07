/*
- 요구사항 : 정수 n을 입력받아 n의 모든 약수를 더한 값을 반환하기
- 함수
    input : 정수 n
    restriction : 0 이상 3000 이하의 정수
    output : n의 모든 약수의 합
- 손코딩
    정수 n을 입력받기
    0이 입력되면 0을 반환하기
    1부터 n까지 반복문을 돌려서
        n이 반복변수로 나뉘었을 때 나머지가 없으면
            그 반복변수를 sum에 더해줌
    sum을 반환

- 다른 풀이
    1. 입력값의 절반까지만 반복문을 돌리고, 그 총 합의 입력값 자체를 더해주면 약수의 합이다! 
- 괜히 소인수분해를 해서 정식으로 약수를 구하고 다 더하려다가 시간만 끌음..이렇게 간단한 것을
*/

package programmers.level01.SumDivisor;

class SumDivisor {
    public int sumDivisor(int n) {
        int sum = 0;
    
        if (n == 0)
            return 0;
        for(int i = 1; i <= n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        
        return sum;
    }

    public static void main(String[] args) {
        SumDivisor c = new SumDivisor();
        System.out.println(c.sumDivisor(12));
    }
}