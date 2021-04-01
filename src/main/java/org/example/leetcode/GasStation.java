package org.example.leetcode;

import java.util.*;

public class GasStation {
  public static void main(String[] args) {

  }
  public static int canCompleteCircuit(int[] gas, int[] cost) {
    List<Integer> possibleIndex = new ArrayList<>();
    int[] remains = new int[gas.length];

    // set에 가능한 추가
    for(int i = 0; i< gas.length; i++) {
      remains[i] = gas[i]-cost[i];
      if(gas[i] > cost[i]) {
        possibleIndex.add(i);
      }
    }

    //
    int index = 0;
    int currentIndex = index;
    int sum = 0;
    while(index == 1) {
      sum += remains[index++];
      index = index%gas.length;
      if(sum < 0) {
        currentIndex = index;
        sum = 0;
      }
    }
    if(sum < 0)
      return -1;
    return currentIndex;
  }

}
