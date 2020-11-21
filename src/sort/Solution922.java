package sort;

import java.util.*;

class Solution922 {
    //1, 2,3 4
    public int[] sortArrayByParityII2(int[] A) {
        for (int i = 0; i < A.length; i++){
            if (i % 2 == 0) {
                if (A[i] % 2 != 0) {
                    int nextEvenPosition = -1;
                    for (int k = i + 1; k < A.length; k++) {
                        if (A[k] % 2 == 0) {
                            nextEvenPosition = k;
                            break;
                        }
                    }
                    if (nextEvenPosition != -1) {
                        int temp = A[i];
                        A[i] = A[nextEvenPosition];
                        A[nextEvenPosition] = temp;
                    }
                }
            } else {
                if (A[i] % 2 == 0) {
                    int nextOddPosition = -1;
                    for (int k = i + 1; k < A.length; k++) {
                        if (A[k] % 2 != 0) {
                            nextOddPosition = k;
                            break;
                        }
                    }
                    if (nextOddPosition != -1) {
                        int temp = A[i];
                        A[i] = A[nextOddPosition];
                        A[nextOddPosition] = temp;
                    }
                }
            }
        }
        return A;
    }

    public int[] sortArrayByParityII(int[] A) {
        LinkedList<Integer> evenData = new LinkedList<>();
        LinkedList<Integer> oddData =  new LinkedList<>();
        for (int i = 0; i< A.length; i++) {
            if (A[i] % 2 == 0) {
                evenData.add(A[i]);
            } else {
                oddData.add(A[i]);
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) {
                A[i] = evenData.removeFirst();
            } else {
                A[i] = oddData.removeFirst();
            }
        }
        return A;
    }
    public static void main(String[] args) {
    }
}