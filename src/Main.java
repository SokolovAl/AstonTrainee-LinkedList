
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        System.out.println(list.getSize());
        list.printList();
        System.out.println();

        list.deleteElement(3);
        list.printList();
        System.out.println();

        list.deleteElement(1);
        list.addLast(99);
        list.addLast(44);
        list.addFirst(17);
        list.printList();
        System.out.println();

        list.deleteElementByIndex(3);
        list.printList();

    }
}
