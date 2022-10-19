import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        QuickSort quickSort = new QuickSort();



        list.add("A");
        list.addLast("B");
        list.addFirst("C");
        list.addFirst("E");
        list.add("F");
        list.addFirst("G");
        list.add("H");

        list.printList();
        System.out.println();

        Object[] arrayList = list.toArray();

        quickSort.sort(arrayList, Comparator.reverseOrder());

        for (Object o : arrayList ) {
            System.out.print(o + " ");
        }




    }
}
