import java.lang.*;
public class Main {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        DoubleLinkedList<Node<String>> list = new DoubleLinkedList<>();
        //New nodes
        Node<String> n1 = new Node<>("A",null,null);
        Node<String> n2 = new Node<>("B",null,null);
        Node<String> n3 = new Node<>("C",null,null);
        Node<String> n4 = new Node<>("D",null,null);
        Node<String> n5 = new Node<>("E",null,null);
        Node<String> n6 = new Node<>("F",null,null);
        list.addLast(n1);
        list.addLast(n2);
        list.addLast(n3);
        list.addLast(n4);
        list.addLast(n5);
        list.addLast(n6);
        for(int i = 1; i <= list.getSize(); i++){
            System.out.print(list.getNode(i).getElement().getElement());
        }
        System.out.print("\n");
        list.swap(list, 1,6);
        for(int i = 1; i <= list.getSize(); i++){
            System.out.print(list.getNode(i).getElement().getElement());
        }
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("\nTotal time (ns):"+ totalTime);



    }
}
