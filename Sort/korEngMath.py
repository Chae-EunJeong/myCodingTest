'''
10825. 국영수
- 요구사항 : 학급을 구성하는 학생 N명의 이름과, 국어, 영어, 수학 점수가 주어질 때 
            아래의 조건으로 학생의 성적을 정렬하여 출력하라
            1) 국어 점수가 감소하는 순
            2) 국어 점수가 같으면 영어 점수가 증가하는 순
            3) 국어, 영어 점수가 같으면 수학 점수가 감소하는 순
            4) 모든 점수가 같으면 이름이 사전 순으로 증가하는 순
- 함수
    - 입력 : 첫째줄 ~ 반 학생 수 N
            둘째줄부터 N+1째줄 ~ 학생의 이름, 국어점수, 영어점수, 수학점수를 공백으로 구분하여 한줄에 하나씩 입력
    - 제약 : 아스키 코드에서 대문자 숫자가 소문자 숫자보다 작다는 것
            1 <= N <= 100,000
            1 <= 점수 <= 100
            학생 이름의 길이 < 10자리
            이름은 알파벳 대소문자로 이루어진 문자열
    - 출력 : 정렬 후 첫째줄부터 N째줄까지 학생의 이름 출력
- 손코딩
    학생의 수를 입력받는다.
    입력받은 학생 수만큼 반복문을 돌면서
        공백을 기준으로 이름, 국어점수, 영어점수, 수학점수를 입력받아 저장한다.
    저장한 학생 정보를 조건에 맞게 정렬한다.
    학생 수만큼 반복하면서
        정렬된 학생 순서대로 이름만 출력한다.
'''

import sys

n = int(input())
students = []
for i in range(n):
    name, kor, eng, math = map(str, sys.stdin.readline().split())
    kor = int(kor)
    eng = int(eng)
    math = int(math)
    students.append([name, kor, eng, math])

students.sort(key = lambda student : (-student[1], student[2], -student[3], student[0]))

for i in students:
    print(i[0])