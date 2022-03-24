package com.ssafy.algoStudy0317;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 요구사항 : 단방향 컨베이어 벨트 길로 연결된 station들이 있을 때,
 * 		     다른 모든 station에서 특정 station으로 도착할 수 있는 최소 station의 번호를 구해라
 * @author chaeu
 *
 */
public class BOJ_17199_MilkFactory {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[][] stations = new boolean[N + 1][N + 1];
		
		for (int n = 0; n < N - 1; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			stations[i][j] = true;
		}
		
		// 경유지 k까지 포함해서 i에서 j로 길이 있다면 true로 바꾸기 
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (stations[i][k] && stations[k][j])
						stations[i][j] = true;
				}
			}
		}
		
		int answer = -1;
		for (int i = 1; i <= N; i++) {
			boolean flag = true;
			// 모든 station이 i로 도착하는 길이 있는지 확인
			for (int j = 1; j <= N; j++) {
				if (i == j) continue;
				if (!stations[j][i]) flag = false;
			}
			if (flag) {
				answer = i;
				break;
			}
		}
		
		System.out.println(answer);
	}

}
