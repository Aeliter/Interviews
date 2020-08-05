package com.aeliter.ji;

public class ZuiDuanLuJing {

	/**
	 * 最短路径Floyd算法
	 * 
	 * @param graph 图的邻接矩阵
	 * @param n     顶点的个数
	 * @return
	 */
	public int[][] floyd(int[][] graph, int n) {
		int[][] edge = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				edge[i][j] = graph[i][j];
			}
		}
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (edge[i][j] > edge[i][k] + edge[k][j])
						edge[i][j] = edge[i][k] + edge[k][j];
				}
			}
		}
		return edge;
	}

	/**
	 * 单源最短路径Dijkstra
	 * 
	 * @param edge
	 * @return
	 */
	public int[] dijsktra(int[][] edge) {
		// 得到顶点个数
		int vartex = edge.length;
		// 标记
		int flag = 0;
		// 记录某个顶点有没有访问到
		int[] mark = new int[vartex];
		// 这里求的是从第一个顶点到其它顶点的最短距离
		mark[0] = 1;
		int[] distance = new int[vartex];
		// 最开始默认的都是边的值，这里传进来就得事先做好处理，比如两个顶点之间不可达，那么久应该赋值为一个很大的数
		for (int i = 0; i < vartex; i++) {
			distance[i] = edge[0][i];
		}
		// 核心代码
		for (int i = 1; i < vartex; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < vartex; j++) {
				if (mark[j] == 0 && distance[j] < min) {
					min = distance[j];
					flag = j;
				}
			}
			mark[flag] = 1;
			for (int k = 0; k < vartex; k++) {
				if (distance[k] > distance[flag] + edge[flag][k]) {
					distance[k] = distance[flag] + edge[flag][k];
				}
			}

		}
		return distance;
	}

}
