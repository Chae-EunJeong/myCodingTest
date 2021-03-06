'''
10814. 나이순 정렬
- 요구사항 : 온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어질 때,
            회원들의 나이가 증가하는 순으로, 나이가 같다면 먼저 가입한 순으로 회원들을 정렬하여 출력하라.
- 함수
    - 입력 : 첫째줄 ~ 회원의 수 N
            둘째줄부터 N+1째줄 ~ 각 회원의 나이와 이름
    - 제약 : 1 <= N <= 100,000
            1 <= 나이 <= 200
            이름은 알파벳 대소문자
            이름의 길이 <= 100
    - 출력 : 첫째줄부터 N째줄 ~ (한 줄에 한 명씩 정렬된) 회원의 나이와 이름
- 손코딩 
    회원의 수 입력받는다.
    입력받은 회원 수만큼 반복문을 돌면서
        나이와 이름을 공백을 기준으로 입력받는다.
    나이를 기준으로, 나이가 같다면 회원을 입력받은 순(가입한 순)대로 정렬한다.
    N만큼 반복하면서
        정렬된 회원의 나이와 이름을 공백을 두어 한줄에 한명씩 출력한다.
'''

import sys

n = int(input())
members = []
for i in range(n):
    age, name = map(str, sys.stdin.readline().split())
    age = int(age)
    members.append((age, name))

members.sort(key = lambda member : (member[0]))

for member in members:
    print(member[0], member[1])