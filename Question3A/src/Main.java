import java.lang.*;
public class Main {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        LinkedList list = new LinkedList();
        for (int count = 1; count <= 10; count ++){
            list.append(count);
        }
        list.printList();
        System.out.println("\n");
        list.swapNodes(1,5);
        list.printList();
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("\nTotal time (ns):"+ totalTime);
    }
}
