package com.company;

import java.util.Arrays;

public class Main2 {

    public static int solution(int n, int k) {
        if (k < 3 || k > 10 || n < 1 || n > 1000000) {
            return -1;
        }
        int answer = 0;
        String m = Integer.toString(Integer.parseInt(String.valueOf(n),10),k);
        String[] subStr = m.split("0");
        for (String s : subStr) {
            if (!s.isEmpty() && !s.isBlank()) {
                int p;
                boolean simpleNumb = true;
                for (int j = 2; j <= Integer.parseInt(s) / 2; j++) {
                    p = Integer.parseInt(s) % j;
                    if (p == 0) {
                        simpleNumb = false;
                        break;
                    }
                }
                if (simpleNumb && Integer.parseInt(s) > 1) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String m = "437674";
        String[] subStr = m.split("0");
        System.out.println(Arrays.asList(subStr));
  //  System.out.println(solution(	437674	, 3));
    }
}
