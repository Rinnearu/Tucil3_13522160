import java.util.InputMismatchException;
import java.util.Scanner;

public class wordladder {
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[]) {
        printWelcome();
        System.out.print(" Start word: ");
        String start_string = sc.nextLine().trim().toUpperCase();
        System.out.print(" Target word: ");
        String end_string = sc.nextLine().trim().toUpperCase();

        long startTime = System.currentTimeMillis();
        if (englishWords.validWords(start_string, end_string)) {
            int method_select = methodSelector();
            startTime = System.currentTimeMillis();
            switch (method_select) {
                case 1:
                    System.out.println("+----------------------------------------------------------+");      
                    System.out.println("| Solving using Uniform-Cost Search                        |");
                    System.out.println("+----------------------------------------------------------+");    
                    UCS UCSWordLadder = new UCS(start_string, end_string);
                    UCSWordLadder.findSolution();
                    UCSWordLadder.printResult();
                    break;
                case 2:
                    System.out.println("+----------------------------------------------------------+");      
                    System.out.println("| Solving using Greedy Best First Search                   |");
                    System.out.println("+----------------------------------------------------------+");    
                    GBFS GBFSWordLadder = new GBFS(start_string, end_string);
                    GBFSWordLadder.findSolution();
                    GBFSWordLadder.printResult();
                    break;
                case 3:
                    System.out.println("+----------------------------------------------------------+");      
                    System.out.println("| Solving using A*                                         |");
                    System.out.println("+----------------------------------------------------------+");
                    ASTAR ASTARWordLadder = new ASTAR(start_string, end_string);
                    ASTARWordLadder.findSolution();
                    ASTARWordLadder.printResult();
                    break;
                default:
                    break;
            }
            
        } else {
            System.out.println(" The strings you have chosen are not eligible");
        }
        long elapsed_time = System.currentTimeMillis() - startTime;
        System.out.println("\n The program took " + elapsed_time + " ms");
        sc.close();
    }

    private static void printWelcome() {
        System.out.println("+----------------------------------------------------------+");      
        System.out.println("| Welcome to word ladder solver (Using SOWPODS dictionary) |");
        System.out.println("+----------------------------------------------------------+");                                                 
    }

    private static void printSelection() {
        System.out.println("+--------------------- SELECT METHODS ---------------------+");      
        System.out.println("| 1. Uniform-Cost Search algorithm                         |");
        System.out.println("| 2. Greedy Best First Search algorithm                    |");
        System.out.println("| 3. A* algorithm                                          |");
        System.out.println("+----------------------------------------------------------+");     
    }

    private static int methodSelector() {
        int input = 0;

        printSelection();

        while (input < 1 || input > 3) {
            System.out.print(" Please select the method's number: ");
            try {
                input = sc.nextInt();
                if (input < 1 || input > 3) {
                    System.out.println("\n There's no such option, please try again!\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n Please input an integer!\n");
                sc.next();
            }
        }

    return input;
    }
}
