package com.company;

import java.util.*;


public class Main {

    public static int[]  solution(String[] id_list, String[] report, int k) {
        int[] answer = new int [id_list.length];
        List <String> nameList = Arrays.asList(id_list);
        HashMap <String, Set <String>> map = new HashMap<>();
        for (int i = 0; i < report.length; i++) {
            String[] subStr = report[i].split(" ");
            Set<String> set = map.get(subStr[1]);
            if (set != null) {
                set.add(subStr[0]);
            } else {
                set = new HashSet<>();
                set.add(subStr[0]);
                map.put(subStr[1], set);
            }
        }
        map.forEach((key, value) -> {
            System.out.println(key + " " + value);
            if (value.size() >= k) {
                value.forEach(v -> {
                    System.out.println(nameList.indexOf(v));
                    answer[nameList.indexOf(v)]++;
                });
            }
        });
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[] {
                "muzi", "frodo", "apeach", "neo"
        }, new String []{
                "muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"
        }, 2)));
    }
}
