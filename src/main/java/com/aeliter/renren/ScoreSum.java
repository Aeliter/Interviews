package com.aeliter.renren;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ScoreSum {
	public static void main(String[] args) {
		String stuString = "[{\"id\":\"1\",\"name\":\"张三\"},{\"id\":\"2\",\"name\":\"李四\"},{\"id\":\"3\",\"name\":\"王五\"},{\"id\":\"4\",\"name\":\"李雷\"}]";
		String scoreString = "[{\"stuId\":\"1\", \"subjectId\":\"1\", \"subjectName\":\"英语\", \"score\":\"90\"},{\"stuId\":\"1\", \"subjectId\":\"2\", \"subjectName\":\"数学\", \"score\":\"80\"},{\"stuId\":\"1\", \"subjectId\":\"3\", \"subjectName\":\"语文\", \"score\":\"70\"},{\"stuId\":\"2\", \"subjectId\":\"1\", \"subjectName\":\"英语\", \"score\":\"85\"},{\"stuId\":\"2\", \"subjectId\":\"2\", \"subjectName\":\"数学\", \"score\":\"75\"},{\"stuId\":\"2\", \"subjectId\":\"3\", \"subjectName\":\"语文\", \"score\":\"90\"},{\"stuId\":\"3\", \"subjectId\":\"3\", \"subjectName\":\"语文\", \"score\":\"60\"}]";
		Gson gson = new Gson();

		// 初始化集合
		Stus[] stuArr = gson.fromJson(stuString, Stus[].class);
		List<Stus> stuList = Arrays.asList(stuArr);
		Scores[] scoArr = gson.fromJson(scoreString, Scores[].class);
		List<Scores> scoreList = Arrays.asList(scoArr);

		// 封装id+name
		HashMap<String, String> stuMap = new HashMap<>();
		HashMap<String, Double> scoMap = new HashMap<>();
		String stuName;
		for (Stus stu : stuList) {
			stuName = stu.getName();
			stuMap.put(stu.getId(), stuName);
			scoMap.put(stuName, 0.0);
		}

		// 求和
		double tempSco;
		for (Scores sco : scoreList) {
			stuName = stuMap.get(sco.getStuId());
			if (scoMap.get(stuName) == null)
				scoMap.put(stuName, sco.getScore());
			else {
				tempSco = scoMap.get(stuName);
				scoMap.put(stuName, sco.getScore() + tempSco);
			}
		}
		System.out.println(scoMap);

	}
}

class Stus {
	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

class Scores {
	private String stuId;
	private String subjectId;
	private String subjectName;
	private double score;

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Score{" + "stuId='" + stuId + '\'' + ", subjectId='" + subjectId + '\'' + ", subjectName='"
				+ subjectName + '\'' + ", score=" + score + '}';
	}
	
}
