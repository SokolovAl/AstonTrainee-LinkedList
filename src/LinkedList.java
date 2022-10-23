public class LinkedList<E> {


    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size;

    public void addFirst(E e) {
        Node<E> first = firstNode;
        Node<E> newNode = new Node<E>(null, e, firstNode);
        firstNode = newNode;
        if (first == null) {
            lastNode = newNode;
        } else {
            first.setPrevElement(newNode);
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> last = lastNode;
        Node<E> newNode = new Node<E>(lastNode, e, null);
        lastNode = newNode;
        if (last == null) {
            firstNode = newNode;
        } else {
            last.setNextElement(newNode);
        }
        size++;
    }

    public void add(E e) {
        addLast(e);
    }

    public E getFirst() {
        Node<E> first = firstNode;
        if (first == null) {
            System.out.println("No such element");
        }
        return first.currentElement;
    }

    public E getLast() {
        Node<E> last = lastNode;
        if (last == null) {
            System.out.println("No such element");
        }
        return last.currentElement;
    }

    public E getElementByIndex(int index) {
        if (!(index >= 0 && index < size)) {
            throw new RuntimeException("No such element");
        } else {
            return node(index).currentElement;
        }
    }

    public Node<E> deleteFirst() {
        if (isEmpty()) {
            System.out.println("List is empty");
        }
        Node<E> temp = firstNode;
        firstNode = firstNode.nextElement;
        firstNode.prevElement = null;
        size--;
        return temp;
    }

    public Node<E> deleteLast() {
        Node<E> temp = lastNode;
        lastNode = temp.prevElement;
        lastNode.nextElement = null;
        size--;
        return temp;
    }

    public void deleteElement(E e) {
        if (e == null) {
            for (Node<E> node = firstNode; node != null; node = node.nextElement) {
                if (node.currentElement == null) {
                    delete(node);
                }
            }
        } else {
            for (Node<E> node = firstNode; node != null; node = node.nextElement) {
                if (e.equals(node.currentElement)) {
                    delete(node);
                }
            }
        }
    }

    public E deleteElementByIndex(int index) {
        if (!(index >= 0 && index < size)) {
            throw new RuntimeException("No such element");
        }
        return delete(node(index));
    }

    public void addElementByIndex(E e, int index) {
        if (!(index >= 0 && index < size)) {
            throw new RuntimeException("Out of bound");
        } else {
            if (index == size) {
                addLast(e);
            } else {
                addBefore(e, node(index));
            }
        }
    }

    private void addBefore(E e, Node<E> node) {
        Node<E> prevNode = node.prevElement;
        Node<E> newNode = new Node<>(prevNode, e, node);
        node.prevElement = newNode;
        if (prevNode == null) {
            firstNode = newNode;
        } else {
            prevNode.nextElement = newNode;
        }
        size++;
    }

    private Node<E> node(int index) {
        if (index <= size) {
            Node<E> node = firstNode;
            for (int i = 0; i < index; i++)
                node = node.nextElement;
            return node;
        } else {
            Node<E> node = lastNode;
            for (int i = size - 1; i > index; i--)
                node = node.prevElement;
            return node;
        }
    }

    private E delete(Node<E> node) {
        E e = node.currentElement;
        Node<E> next = node.nextElement;
        Node<E> prev = node.prevElement;

        if (prev == null) {
            firstNode = next;
        } else {
            prev.nextElement = next;
            node.prevElement = null;
        }

        if (next == null) {
            lastNode = prev;
        } else {
            next.prevElement = prev;
            node.nextElement = null;
        }

        node.currentElement = null;
        size--;
        return e;
    }

    public void printList() {
        Node<E> node = firstNode;
        while (node != null) {
            System.out.print(node.currentElement + " ");
            node = node.getNextElement();
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int indexOf(E e) {
        int index = 0;
        if (e == null) {
            for (Node<E> node = firstNode; node != null; node = node.nextElement) {
                if (node.currentElement == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> node = firstNode; node != null; node = node.nextElement) {
                if (e.equals(node.currentElement)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    public boolean contains(E e) {
        return indexOf(e) >= 0;
    }

    public void deleteAll() {
        while (firstNode != null) {
            Node<E> next = firstNode.nextElement;
            firstNode.currentElement = null;
            firstNode.nextElement = null;
            firstNode.prevElement = null;
            firstNode = next;
        }
        firstNode = null;
        lastNode = null;
        size = 0;
    }

    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<E> node = firstNode; node != null; node = node.nextElement) {
            result[i++] = node.currentElement;
        }
        return result;
    }

    private class Node<E> {
        private E currentElement;
        private Node<E> prevElement;
        private Node<E> nextElement;

        public Node(Node<E> prevElement, E currentElement, Node<E> nextElement) {
            this.currentElement = currentElement;
            this.prevElement = prevElement;
            this.nextElement = nextElement;
        }

        public E getCurrentElement() {
            return currentElement;
        }

        public void setCurrentElement(E currentElement) {
            this.currentElement = currentElement;
        }

        public Node<E> getPrevElement() {
            return prevElement;
        }

        public void setPrevElement(Node<E> prevElement) {
            this.prevElement = prevElement;
        }

        public Node<E> getNextElement() {
            return nextElement;
        }

        public void setNextElement(Node<E> nextElement) {
            this.nextElement = nextElement;
        }
    }
}

