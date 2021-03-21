package org.example.leetcode;

public class DailyTemperature {

  public static void main(String[] args) {
    int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
    int[] answers = dailyTemperatures(T);

    for (int answer : answers) {
      System.out.print(answer+" ");
    }
  }

  public static int[] dailyTemperatures(int[] T) {
    int[] answer = new int[T.length];
    for(int i = 0; i < T.length; i++) {
      for(int j = i+1; j < T.length; j++) {
        if(T[i] < T[j]) {
          answer[i] = j - i;
          break;
        }
        if(j == T.length)
          answer[i] = 0;
      }
    }
    return answer;
  }

}
