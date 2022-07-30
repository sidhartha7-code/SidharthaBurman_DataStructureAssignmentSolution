import java.util.Scanner;
import java.util.Stack;

public class FloorConstruction {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the total no of floors in the building");
        int totalFloor=sc.nextInt();
        int[] floorsize=new int[totalFloor];

        for (int i = 0; i < totalFloor; i++) {
            System.out.println("Enter the floor size on day "+(i+1));
            floorsize[i]=sc.nextInt();
        }

        for (int i = 0; i < floorsize.length; i++) {
            System.out.print(floorsize[i]+" ");
        }

        System.out.println(" ");

        Stack<Integer> stack=new Stack<>();
        int maxFloor=totalFloor;
        int minFloor=1;
        stack.push(maxFloor);
        for (int i = 0; i < floorsize.length; i++) {
            System.out.println("Day: "+(i+1));
            stack.push(floorsize[i]);
            if (maxFloor==floorsize[i]){
                while (!stack.isEmpty() && maxFloor==(int)stack.peek()){
                    int element= (int) stack.pop();
                    System.out.print(element+" ");
                    maxFloor=maxFloor-1;
                }
                System.out.println(" ");

            }
            else{
                System.out.println(" ");
            }
        }
    }
}
