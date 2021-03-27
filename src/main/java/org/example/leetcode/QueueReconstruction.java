package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstruction {

  public static void main(String[] args) {
    Arrays.stream(reconstructQueue(new int[][]{ {7,0},{4,4},{7,1},{5,0},{6,1},{5,2}})).forEach(i -> System.out.println(i[0]+" "+i[1]));
  }

  public static int[][] reconstructQueue(int[][] people) {
    List<int[]> queue = new ArrayList<>();
    Arrays.sort(people, (o1, o2) -> o2[0]==o1[0] ? o1[1]-o2[1] : o2[0]-o1[0]);

    for (int[] person : people) {
      queue.add(person[1],person);
    }

    return queue.toArray(new int[queue.size()][]);
  }
}
