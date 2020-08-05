package com.aeliter.renren;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StudentScoreStat {
    public static void main(String[] args) {
        final String studentsStr = "[\n" +
                "  {\n" +
                "    \"id\": \"1\",\n" +
                "    \"name\": \"张三\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"2\",\n" +
                "    \"name\": \"李四\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"3\",\n" +
                "    \"name\": \"王五\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"4\",\n" +
                "    \"name\": \"李雷\"\n" +
                "  }\n" +
                "]";
        final String scoreStr = "[\n" +
                "  {\n" +
                "    \"stuId\": \"1\",\n" +
                "    \"subjectId\": \"1\",\n" +
                "    \"subjectName\": \"英语\",\n" +
                "    \"score\": \"90\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"stuId\": \"1\",\n" +
                "    \"subjectId\": \"2\",\n" +
                "    \"subjectName\": \"数学\",\n" +
                "    \"score\": \"80\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"stuId\": \"1\",\n" +
                "    \"subjectId\": \"3\",\n" +
                "    \"subjectName\": \"语文\",\n" +
                "    \"score\": \"70\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"stuId\": \"2\",\n" +
                "    \"subjectId\": \"1\",\n" +
                "    \"subjectName\": \"英语\",\n" +
                "    \"score\": \"85\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"stuId\": \"2\",\n" +
                "    \"subjectId\": \"2\",\n" +
                "    \"subjectName\": \"数学\",\n" +
                "    \"score\": \"75\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"stuId\": \"2\",\n" +
                "    \"subjectId\": \"3\",\n" +
                "    \"subjectName\": \"语文\",\n" +
                "    \"score\": \"90\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"stuId\": \"3\",\n" +
                "    \"subjectId\": \"3\",\n" +
                "    \"subjectName\": \"语文\",\n" +
                "    \"score\": \"60\"\n" +
                "  }\n" +
                "]";
        final List<Student> students = Arrays.stream(studentsStr.split("},"))
                .map(v -> new Student(Integer.parseInt(parseValue("id", v)), parseValue("name", v)))
                .collect(Collectors.toList());	

        final List<Score> testResults = Arrays.stream(scoreStr.split("},"))
                .map(v -> new Score(
                        Integer.parseInt(parseValue("stuId", v)),
                        Integer.parseInt(parseValue("subjectId", v)),
                        parseValue("subjectName", v),
                        Integer.parseInt(parseValue("score", v))
                ))
                .collect(Collectors.toList());
        
        final List<List<Score>> resultGroups = students.stream()
        		.map(Student :: getId)
        		.map(v -> testResults.stream().filter(t -> t.getStuId() == v).collect(Collectors.toList()))
        		.filter(v -> !v.isEmpty())
        		.collect(Collectors.toList());

        final Map<Student, List<Score>> studentTestResults = students.stream()
        		.collect(Collectors.toMap(
        				v -> v, 
        				v -> resultGroups.stream().filter(r -> r.get(0).getStuId() == v.getId()).findFirst().orElse(new ArrayList<>())));
        
        studentTestResults.forEach((k, v) -> {
            System.out.println(String.format("Name: %s", k.getName()));
            v.forEach(r -> System.out.println(String.format("%s:%s", r.subjectName, r.getScore())));
            System.out.println(String.format("Total:%s", (Integer) v.stream().mapToInt(Score::getScore).sum()));
            System.out.println();
        });
    }

    private static String parseValue(String prefix, String text) {
        final String regex = String.format("(?<=\"%s\": \").+(?=\")", prefix);
        final Matcher matcher = Pattern.compile(regex).matcher(text);
        if (matcher.find()) {
            return matcher.group(0);
        } else {
            throw new RuntimeException("Not match...");
        }
    }

    static class Student {
        private int id;
        private String name;

        Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        int getId() {
            return id;
        }

        String getName() {
            return name;
        }
    }

    static class Score {
        private int stuId;
        private int subjectId;
        private String subjectName;
        private int score;

        Score(int stuId, int subjectId, String subjectName, int score) {
            this.stuId = stuId;
            this.subjectId = subjectId;
            this.subjectName = subjectName;
            this.score = score;
        }

        int getStuId() {
            return stuId;
        }

        int getSubjectId() {
            return subjectId;
        }

        String getSubjectName() {
            return subjectName;
        }

        int getScore() {
            return score;
        }
    }
    
}
