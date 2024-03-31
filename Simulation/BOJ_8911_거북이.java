import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 요구사항 : 2차원 평면 위에서 거북이가 지나간 영역을 모두 포함하는 가장 작은 직사각형의 넓이를 구해라
 * 컨트롤 프로그램 F: 한 눈금 앞으로
 *              B: 한 눈금 뒤로
 *              L: 왼쪽으로 90도 회전
 *              R: 오른쪽으로 90도 회전
 * 규칙 : 시작점은 (0,0)이고 북쪽을 쳐다보고 있다.
 *       직사각형을 만들지 않는 경우 (선분) 넓이는 0이다
 * 입력 : 테스트케이스의 개수 T / 각줄엔 네가지 명령으로 이루어진 컨트롤 프로그램이 한 줄로 주어짐
 * 제약 : 컨트롤 프로그램의 길이 < 500
 * 출력 : 각 테케에 대해 거북이가 이동한 영역을 모두 포함하는 가장 작은 직사각형의 넓이
 *
 */

public class BOJ_8911_거북이 {

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int curDir = 0; // 거북이가 바라보는 방향
            int curX = 0, curY = 0; // 현재 좌표
            int maxX = 0, minX = 0, maxY = 0, minY = 0;
            char[] controlProgram = br.readLine().toCharArray();
            for (int i = 0; i < controlProgram.length; i++) {
                if (controlProgram[i] == 'F' || controlProgram[i] == 'B') {
                    // 이동
                    if (controlProgram[i] == 'F') {
                        curX += dx[curDir];
                        curY += dy[curDir];
                    } else {    // B
                        curX -= dx[curDir];
                        curY -= dy[curDir];
                    }

                    // 최대 좌표 비교
                    if (curX > maxX) maxX = curX;
                    if (curY > maxY) maxY = curY;

                    // 최소 좌표 비교
                    if (curX < minX) minX = curX;
                    if (curY < minY) minY = curY;

                } else {    // L or R
                    // 회전
                    if (controlProgram[i] == 'L') {
                        curDir = (curDir + 5) % 4;
                    } else {    // R
                        curDir = (curDir + 3) % 4;
                    }
                }

            }
            System.out.println((maxX - minX) * (maxY - minY));
        }
    }
}
