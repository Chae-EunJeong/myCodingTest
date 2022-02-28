package com.ssafy.algoStudy0224;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_19236_청소년상어 {
	static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Fish[] fishes = new Fish[16];
		int[][] map = new int[4][4];
		answer = 0;
		
		int idx = 0;
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				fishes[idx++] = new Fish(i, j, num, dir - 1, false);
			}
		}
		// (0,0)의 물고기 먹고, (0, 0)에 있던 물고기의 방향과 같게 만들기
		Shark shark = new Shark(0, 0, fishes[0].dir, map[0][0]);
		fishes[0].dead = true;
		map[0][0] = -1;
		
		Arrays.sort(fishes);
		dfs(map, shark, fishes);
		System.out.println(answer);
	}
	
	private static void dfs(int[][] map, Shark shark, Fish[] fishes) {

		if (answer < shark.total) {
			answer = shark.total;
		}
		
		// 1. 물고기의 이동
		moveFishes(map, fishes);
		
		// 2. 상어 이동 dfs
		for (int i = 1; i < 4; i++) {
			int nx = shark.x + dx[shark.dir] * i;
			int ny = shark.y + dy[shark.dir] * i;
			
			if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4) continue;
			if (map[nx][ny] > 0) {
				int[][] newMap = cloneMap(map);
				Fish[] newFishes = cloneFish(fishes);
				
				newMap[shark.x][shark.y] = 0;	// 상어가 떠난 자리는 빈칸 
				newFishes[newMap[nx][ny] - 1].dead = true;	// 상어가 물고기 잡아 먹음
				Shark newShark = new Shark(nx, ny, newFishes[newMap[nx][ny] - 1].dir, shark.total + newFishes[newMap[nx][ny] - 1].num);
				newMap[nx][ny] = -1;	// 그 자리에 상어 위치
				dfs(newMap, newShark, newFishes);
			}
		}
	}
	
	private static Fish[] cloneFish(Fish[] fishes) {
		Fish[] newFishes = new Fish[16];
		int idx = 0;
		for (int i = 0; i < fishes.length; i++) {
			Fish f = fishes[i];
			newFishes[idx++] = new Fish(f.x, f.y, f.num, f.dir, f.dead);
		}
		return newFishes;
	}
	
	// 순서대로 상, 좌상, 좌, 좌하, 하, 우하, 우, 우상
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
	private static void moveFishes(int[][] map, Fish[] fishes) {
		
		// 번호가 작은 물고기부터 순서대로 이동
		for (int i = 0; i < fishes.length; i++) {
			Fish curFish = fishes[i];
			if (curFish.dead) continue;
			for (int d = 0; d < 8; d++) {
				int nx = dx[curFish.dir] + curFish.x;
				int ny = dy[curFish.dir] + curFish.y;
				if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4 || map[nx][ny] == -1) {
					curFish.dir = (curFish.dir + 1) % 8;
					continue;
				}
				if (map[nx][ny] == 0) {
					map[curFish.x][curFish.y] = 0;
					curFish.x = nx;
					curFish.y = ny;
					map[nx][ny] = curFish.num;
					break;
				}
				if (map[nx][ny] > 0) {	// 물고기 이동 가능할 때 (빈 칸과 다른 물고기가 있는 칸)
					int temp = map[nx][ny];
					map[nx][ny] = map[curFish.x][curFish.y];
					map[curFish.x][curFish.y] = temp;
					fishes[map[curFish.x][curFish.y] - 1].x = curFish.x;
					fishes[map[curFish.x][curFish.y] - 1].y = curFish.y;
					curFish.x = nx;
					curFish.y = ny;
					break;
				}
			}
		}
	}
	
	private static int[][] cloneMap(int[][] map) {
		int[][] newMap = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				newMap[i][j] = map[i][j];
			}
		}
		return newMap;
	}
	
	public static class Fish implements Comparable<Fish> {
		int x, y, num, dir;
		boolean dead;
		public Fish(int x, int y, int num, int dir, boolean dead) {
			this.x = x;
			this.y = y;
			this.num = num;
			this.dir = dir;
			this.dead = dead;
		}
		
		@Override
		public int compareTo(Fish o) {
			return this.num - o.num;
		}
	}
	public static class Shark {
		int x, y, dir, total;
		public Shark(int x, int y, int dir, int total) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.total = total;
		}
	}
}
