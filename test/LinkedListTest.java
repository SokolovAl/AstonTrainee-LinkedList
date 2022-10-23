import org.junit.jupiter.api.*;

class LinkedListTest {

    @Test
    void addFirstNodeShouldBecomeFirst() {
        LinkedList testList = new LinkedList<Integer>();

        for (int i = 1; i < 5; i++) {
            testList.addFirst(i);
        }

        Assertions.assertEquals(4, testList.getFirst());
    }

    @Test
    void addLastNodeShouldBecomeLast() {
        LinkedList testList = new LinkedList<Integer>();

        for (int i = 1; i < 5; i++) {
            testList.addLast(i);
        }

        Assertions.assertEquals(testList.getLast(), 4);
    }


    @Test
    void getElementByIndexShouldReturnExpectedElement() {
        LinkedList testList = new LinkedList<Integer>();
        int index = 2;

        for (int i = 1; i < 5; i++) {
            testList.add(i);
        }

        testList.getElementByIndex(index);

        Assertions.assertEquals(2, index);
    }

    @Test
    void deleteFirstNextNodeShouldBeFirst() {
        LinkedList testList = new LinkedList<Integer>();

        for (int i = 1; i < 5; i++) {
            testList.add(i);
        }

        testList.deleteFirst();

        Assertions.assertEquals(2, testList.getFirst());
    }

    @Test
    void deleteLastNextNodeShouldBeLast() {
        LinkedList testList = new LinkedList<Integer>();

        for (int i = 1; i < 5; i++) {
            testList.add(i);
        }

        testList.deleteLast();

        Assertions.assertEquals(3, testList.getLast());
    }

    @Test
    void deleteElement() {
        LinkedList testList = new LinkedList<Integer>();
        LinkedList expList = new LinkedList<Integer>();

        for (int i = 1; i < 5; i++) {
            testList.add(i);
        }

        for (int i = 1; i < 4; i++) {
            expList.add(i);
        }

        testList.deleteElement(4);

        Assertions.assertArrayEquals(expList.toArray(), testList.toArray());
    }

    @Test
    void deleteElementByIndex() {
        LinkedList testList = new LinkedList<Integer>();
        LinkedList expList = new LinkedList<Integer>();

        for (int i = 1; i < 5; i++) {
            testList.add(i);
        }

        for (int i = 2; i < 5; i++) {
            expList.add(i);
        }

        testList.deleteElementByIndex(0);

        Assertions.assertArrayEquals(expList.toArray(), testList.toArray());
    }

    @Test
    void addElementByIndexShouldSetElementToIndex() {
        LinkedList testList = new LinkedList<Integer>();
        LinkedList expList = new LinkedList<Integer>();

        for (int i = 1; i < 5; i++) {
            testList.add(i);
        }

        expList.add(1);
        expList.add(2);
        expList.add(3);
        expList.add(5);
        expList.add(4);

        testList.addElementByIndex(5, 3);

        Assertions.assertArrayEquals(expList.toArray(), testList.toArray());
    }

    @Test
    void getSize() {
        LinkedList testList = new LinkedList<Integer>();

        for (int i = 1; i < 5; i++) {
            testList.add(i);
        }

        int size = testList.getSize();

        Assertions.assertEquals(4, size);
    }

    @Test
    void isEmptyShouldReturnTrueIfEmpty() {
        LinkedList testList = new LinkedList<Integer>();

        Assertions.assertTrue(testList.isEmpty());
    }

    @Test
    void indexOfShouldReturnRightIndex() {
        LinkedList testList = new LinkedList<String>();

        testList.add("A");
        testList.add("B");
        testList.add("C");
        testList.add("D");

        int element = testList.indexOf("C");

        Assertions.assertEquals(2, element);
    }

    @Test
    void containsShouldReturnTrueIfListContainElementAndReturnFalseIfListNotContainElement() {
        LinkedList testList = new LinkedList<Integer>();

        for (int i = 1; i < 5; i++) {
            testList.add(i);
        }

        boolean isContain1 = testList.contains(2);
        boolean isContain2 = testList.contains("A");

        Assertions.assertTrue(isContain1);
        Assertions.assertFalse(isContain2);
    }

    @Test
    void deleteAllShouldReturnEmptyList() {
        LinkedList testList = new LinkedList<Integer>();

        for (int i = 1; i < 5; i++) {
            testList.add(i);
        }

        testList.deleteAll();

        Assertions.assertTrue(testList.isEmpty());
    }
}
