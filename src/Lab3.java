package lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab3 {

//    public static String arraySize = null;
//    public static String edges = "null";
//    public static LinkedList[] list;
//    public static String destination;
//    public static String fileName;
//    public static int[][] matrix;
    public static void main(String[] args) {
        String fileName = "";
        String destination;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("copy the link of the folder of the file and paste it");
        destination = keyboard.nextLine();
        try {
            //For sample input 1
            System.out.println();
            System.out.println("Sample Output 1: ");
            fileName = "Task1_SampleInput1.txt";
            DFS d = new DFS();
            int graph = d.count(readFile(fileName, destination));
            System.out.println("Connected Components: " + graph);
            //For sample input 2
            System.out.println();
            System.out.println("Sample Output 2: ");
            fileName = "Task1_SampleInput2.txt";
            DFS d1 = new DFS();
            graph = d1.count(readFile(fileName, destination));
            System.out.println("Connected Components: " + graph);
            //For sample input 3
            System.out.println();
            System.out.println("Sample Output 2: ");
            fileName = "Task1_SampleInput3.txt";
            DFS d2 = new DFS();
            graph = d2.count(readFile(fileName, destination));
            System.out.println("Connected Components: " + graph);
            //for Task 2 sample input 1
            fileName = "Task2_SampleInput1.txt";
            LinkedList[] array = adjacencyList(fileName, destination);
            BFS b = new BFS();
            int[] shortPathArray = b.lengths(0, array);
            System.out.println("BFS output 1");
            System.out.print("Set 1: ");
            System.out.println("Taking 0 as source Node");
            for (int i = 0; i < shortPathArray.length; i++) {
                System.out.print(shortPathArray[i] + " ");
            }
            System.out.println();
            System.out.print("Set 2 ");

            fileName = "Task2_SampleInput2.txt";
            LinkedList[] array1 = adjacencyList(fileName, destination);
            BFS b1 = new BFS();
            int[] shortPathArray1 = b1.lengths(0, array1);
            System.out.println("Taking 0 as source Node");
            for (int i = 0; i < shortPathArray1.length; i++) {
                System.out.print(shortPathArray1[i] + " ");
            }
            System.out.println();

            shortPathArray = b.lengths(4, array);
            System.out.println("BFS output 2");
            System.out.print("Set 1: ");
            System.out.println("Taking 4 as source Node");
            for (int i = 0; i < shortPathArray.length; i++) {
                System.out.print(shortPathArray[i] + " ");
            }
            System.out.println();
            //set2 for 4
            fileName = "Task2_SampleInput2.txt";
             array1 = adjacencyList(fileName, destination);
            BFS b2 = new BFS();
            shortPathArray1 = b2.lengths(4, array1);
            System.out.println("Taking 4 as source Node");
            for (int i = 0; i < shortPathArray1.length; i++) {
                System.out.print(shortPathArray1[i] + " ");
            }
            System.out.println();
            //set2 for 4
//            //For task 2 sample input 2
//            fileName = "Task2_SampleInput2.txt";
//            LinkedList[] array1 = adjacencyList(fileName, destination);
//            BFS b1 = new BFS();
//            int[] shortPathArray1 = b1.lengths(0, array1);
//            System.out.println("BFS Output 2");
//            for (int i = 0; i < shortPathArray1.length; i++) {
//                System.out.print(shortPathArray1[i] + " ");
//            }

//            writeFile();
        } catch (Exception ex) {
            Logger.getLogger(Lab3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static int[][] readFile(String fileName, String destination) {
        String arraySize = null;
        String edges = "null";
//    LinkedList[] list = null;

        int[][] matrix = null;
        Scanner x = null;
        try {
            x = new Scanner(new File(destination + "\\" + fileName));
        } catch (FileNotFoundException ex) {
            System.err.println("File Not Found !");
        }
        boolean b = false;
        while (x.hasNext()) {
            if (b == false) {
                arraySize = x.next();
                edges = x.next();
//                list = new LinkedList[Integer.parseInt(arraySize)];
                matrix = new int[Integer.parseInt(arraySize)][Integer.parseInt(arraySize)];
                b = true;
            } else {
                for (int t = 0; t < Integer.parseInt(edges); t++) {
                    int m = Integer.parseInt(x.next());
                    int n = Integer.parseInt(x.next());
                    for (int i = 0; i < Integer.parseInt(arraySize); i++) {
                        for (int j = 0; j < Integer.parseInt(arraySize); j++) {
                            if (((i == m) && (j == n)) || ((i == n) && j == m)) {
                                matrix[i][j] = 1;
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        return matrix;
    }

    public static LinkedList[] adjacencyList(String fileName, String destination) {

        Scanner x = null;
        String edges = null;
        String arraySize = "";
        try {
            x = new Scanner(new File(destination + "\\" + fileName));
        } catch (FileNotFoundException ex) {
            System.err.println("File Not Found!");
        }
        arraySize = x.next();
        edges = x.next();
        LinkedList[] list = new LinkedList[Integer.parseInt(arraySize)];
//        int m = Integer.parseInt(x.next());
        int m = 0;
//        int n = Integer.parseInt(x.next());
        int n = 0;
//        System.out.println("m= "+m);
//        System.out.println("n= "+n);
        for (int i = 0; i < Integer.parseInt(arraySize); i++) {
            list[i] = new LinkedList(new Node(i, null));
        }
        while (x.hasNext()) {
            m = Integer.parseInt(x.next());
            n = Integer.parseInt(x.next());
            list[m].insert(n, list[m].countNode());
            list[n].insert(m, list[n].countNode());

        }
//        System.out.println("------test------");
//        for (int i = 0; i < Integer.parseInt(arraySize); i++) {
//            System.out.println(list[i]);
//        }
//        System.out.println("------test------");
        return list;
    }
}
//        try {
//            x = new Scanner(new File(destination + "\\cities.txt"));
//        } catch (FileNotFoundException ex) {
//            System.err.println("File Not Found!");
//        }
//        int m = Integer.parseInt(x.next());
//        int n = Integer.parseInt(x.next());
//        for (int i = 0; i < Integer.parseInt(arraySize); i++) {
//            list[i] = new LinkedList(new Node(i, null));
//        }
//        while (x.hasNext()) {
//            m = Integer.parseInt(x.next());
//            n = Integer.parseInt(x.next());
//            list[m].insert(n, list[m].countNode());
//            list[n].insert(m, list[n].countNode());
//        }
//    }

//    public static void writeFile() throws FileNotFoundException, IOException {
//        File file = new File("D:\\Brac uni\\Summer'15\\CSE 221 (sec - 2)\\Lab\\Lab1\\Main\\src\\main\\optimisedCityRoutes.txt");
//        FileOutputStream fos = new FileOutputStream(file);
//        if (!file.exists()) {
//            file.createNewFile();
//        }
//        byte[] b;
//        String s;
//        s = print();
//        b = s.getBytes();
//        fos.write(b);
//        fos.flush();
//        fos.close();
//    }
//    public static String print() {
//        String s = "";
//        s += "Adjacency Matrix: " + System.getProperty("line.separator");
//        for (int i = 0; i < list.length; i++) {
//            for (int j = 0; j < list.length; j++) {
//                s += matrix[i][j] + " ";
//            }
//            s += System.getProperty("line.separator");
//        }
//        s += System.getProperty("line.separator");
//        s += "Adjacency List: " + System.getProperty("line.separator");
//        for (int i = 0; i < list.length; i++) {
//            s += list[i].toString() + System.getProperty("line.separator");
//        }
//        return s;
//    }

