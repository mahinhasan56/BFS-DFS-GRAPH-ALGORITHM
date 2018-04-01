package lab3;

import java.util.EmptyStackException;
import java.util.Stack;

public class DFS {

    public static int count(int[][] matrix) {
        int count = 0;
//        int nodeCount = 1;
        Stack s = new Stack();
//        int testLineNumber = 1;
        String[] array = new String[matrix.length];
//        System.out.println(matrix.length);
        for(int h = 0; h < matrix.length; h++){
//            System.out.println(h);
            s.push(h);
            array[h] = "visited";
            for (int i = h; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
//                    System.out.println(testLineNumber + ") i=" + i);
//                    System.out.println("    j=" + j);
//                    System.out.println("---------------");
//                    testLineNumber++;
                    if (matrix[i][j] == 1) {
                        if (array[j] != "visited") {
                            s.push(j);
                            array[j] = "visited";
//                            nodeCount++;
                            i = j;
                            j = -1;
                        }

                    }
                    if (j == matrix.length - 1) {
                        try {
//                            System.out.println("Inside try");
//                            System.err.println(s);
//                            System.out.println("j- "+j);
                            j = (int) s.pop();
                            j--;
//                              System.out.println("j- "+j);
                            i = (int) s.peek();
                        } catch (EmptyStackException e) {
//                            System.out.println("Inside catch");
                            count++;
                            break;
                            

                        }

                    }
                }
             break;   
            }
            boolean b = false;
            
            for(int i = 0; i < array.length; i++){
//                System.out.println(array[i]);
                if(array[i] != "visited"){
                       h = i-1;
//                       System.out.println("h = "+h);
//                       System.out.println(s);
                       b = false;
                       break;
                }else{
                   b = true;
                }
            }
            if(b == true){
                break;
            }
    }
        
        return count;
    }
}
