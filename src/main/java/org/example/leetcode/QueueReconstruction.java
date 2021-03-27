package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstruction {

  public static void main(String[] args) {
    reconstructQueue(new int[][]{ {7,0},{4,4},{7,1},{5,0},{6,1},{5,2}});
  }

  public static int[][] reconstructQueue(int[][] people) {
    List<int[]> queue = new ArrayList<>();
    int[][] answer = new int[people.length][2];
    Arrays.sort(people, (o1, o2) -> {
      if(o2[0] == o1[0])
        return o1[1] - o2[1];
      return o2[0]-o1[0];
    });
    queue.add(people[0]);
    for(int i = 1; i < people.length; i++) {
      //비교 후 put
      compareAndPut(queue, people[i][0], people[i][1]);
    }

    return queue.toArray(new int[queue.size()][]);
  }

  private static void compareAndPut(List<int[]> queue, int height, int frontPeopleCount) {
    int count = 0;
    for(int i = 0; i< queue.size(); i++) {
      if(queue.get(i)[0] >= height) {
        count++;
      }
      if(count > frontPeopleCount) {
        queue.add(i, new int[]{height, frontPeopleCount});
        break;
      }

      if(count == frontPeopleCount) {
        queue.add(i+1 ,new int[]{height, frontPeopleCount});
        break;
      }
    }
    if(count < frontPeopleCount) {
      queue.add(new int[]{height, frontPeopleCount});
    }


  }
}
