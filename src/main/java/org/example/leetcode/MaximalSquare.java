package org.example.leetcode;

public class MaximalSquare {
  public static void main(String[] args) {
    System.out.println();
  }
  public static int maximalSquare(char[][] matrix) {
    int maxVal = 0;
    for(int i = 0; i < matrix.length; i++) {
      for(int j = 0; j < matrix[i].length; j++) {
        if(matrix[i][j] == '1')
          maxVal = Math.max(maxVal, findSquare(i, j, matrix, maxVal));
      }
    }

    return maxVal;
  }

  private static int findSquare(int i, int j, char[][] matrix, int maxVal) {
    int currentI = i+maxVal;
    int currentJ = j+maxVal;
    

    while(currentI < matrix.length && currentJ < matrix[i].length) {

      if(matrix[currentI][currentJ] == '0') { //0이면 브레이크
        break;
      }

      for(int tempI = currentI; tempI >= i; tempI--) {
        if(matrix[tempI][currentJ] == '0')
          break;
      }

      for(int tempJ = currentJ; tempJ >= j; tempJ--) {
        if(matrix[currentI][tempJ] == '0')
          break;
      }
      currentI++;
      currentJ++;

    }

    return (currentI-i+1)*(currentI-i+1);

  }
}
