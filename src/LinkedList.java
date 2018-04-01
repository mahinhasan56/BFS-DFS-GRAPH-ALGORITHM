package lab3;

public class LinkedList {

    public Node head;

    
    public LinkedList(Object[] a) {


        this.head = new Node(a[0], null);
        Node n = this.head;
        for (int i = 1; i < a.length; i++) {
            n.next = new Node(a[i], null);
            n = n.next;
        }
    }


    
    public LinkedList(Node h) {
        this.head = h;
    }

    

//    LinkedList() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    
    public int countNode() {
        int counter = 0;
        Node n = head;
        while (n != null) {
            counter++;
            n = n.next;
        }
        return counter;

    }

    
    public void printList() {
        Node n = this.head;
        while (n != null) {
            System.out.print(n.element + " ");
            n = n.next;
        }
        System.out.println();
    }

    
    public Node nodeAt(int idx) {
        Node result = null;
        if (idx < countNode() || idx >= 0) {
            Node n = this.head;
            int counter = 0;
            while (n.element != null) {
                if (counter == idx) {
                    result = n;
                    break;
                }
                counter++;
                n = n.next;
            }
        }

        return result; 
    }


    public Object get(int idx) {
        Object result = null;
        int counter = 0;
        if (idx < 0 || idx > countNode()) {
            result = null;
        } else {
            Node n = this.head;
            while (n != null) {
                if (counter == idx) {
                    result = n.element;
                    break;
                } else {
                    n = n.next;
                    counter++;
                }
            }
        }

        return result;
    }


    public Object set(int idx, Object elem) {
        Object result = null;
        int counter = 0;
        if (idx >= 0 || idx < countNode()) {
            Node temp = this.head;
            while (temp != null) {
                if (counter == idx) {
                    result = temp.element;
                    temp.element = elem;
                    break;
                } else {
                    temp = temp.next;
                    counter++;
                }
            }

        }
        return result;
    }


    public int indexOf(Object elem) {
        int result = -1;
        int counter = 0;
        Node temp = this.head;
        while (temp != null) {
            if (temp.element == elem) {
                result = counter;
                break;
            } else {
                counter++;
                temp = temp.next;
            }
        }

        return result;
    }


    public boolean contains(Object elem) {
        boolean result = false;
        Node temp = this.head;
        while (temp != null) {
            if (temp.element == elem) {
                result = true;
                break;
            } else {
                temp = temp.next;
            }
        }
        return result;
    }


    public Node copyList() {
        Node temp = this.head;
        Node copyHead = this.head;
        Node copyList = null;
        while (temp != null) {
            copyList = temp;
            temp = temp.next;
        }
        return copyHead;
    }


    public Node reverseList() {
        Node reverse = null;
        Node temp = this.head;
        Node reverseHead = null;
        Object[] array = new Object[countNode()];
        int counter = 0;
        while (temp != null) {
            array[counter] = temp.element;
            counter++;
            temp = temp.next;
        }

        for (int i = 0; i < array.length; i++) {
            reverse = new Node(array[i], reverse);

        }
        reverseHead = reverse;
        return reverseHead;
    }


    public void insert(Object elem, int idx) {
        if (idx < 0 || idx > countNode()) {
            System.out.println("Invalid Index");
        } else {
            Node temp = this.head;
            int counter = 0;
            while (temp != null) {
                if (counter == idx - 1) {
                    temp.next = new Node(elem, temp.next);
                } else if (idx == 0) {
                    temp = new Node(elem, this.head);
                    this.head = temp;
                    break;
                }
                counter++;
                temp = temp.next;
            }
        }
    }


    public Object remove(int index) {
        Object n = null;
        Node temp = null;
        if (index >= 0 || index < countNode()) {
            temp = this.head;
            int counter = 0;
            while (temp != null) {

                if (counter == index - 1) {
                    n = temp.next.element;
                    temp.next = temp.next.next;
                    break;
                } else if (index == 0) {
                    n = this.head.element;
                    this.head = temp.next;
                    break;
                } else {
                    counter++;
                    temp = temp.next;
                }

            }
        }
        return n;
    }


    public void rotateLeft() {
        Node tempHead = null;
        Node tail;
        Node temp = this.head;
        int counter = 0;
        while (temp != null) {
            if (counter == 1) {
                tempHead = temp;
            } else if (counter == countNode() - 1) {

                temp.next = this.head;
                temp.next.next = null;
            }
            counter++;
            temp = temp.next;
        }
        this.head = tempHead;
    }


    public void rotateRight() {
        Node temp = this.head;
        Node tempHead = null;
        Node tail;
        int counter = 0;
        while (temp != null) {
            if (counter == countNode() - 1) {
                tempHead = new Node(temp.element, this.head);
                break;
            }
            counter++;
            temp = temp.next;
        }
        counter = 0;
        temp = this.head;
        while (temp != null) {
            if (counter == countNode() - 2) {
                tail = new Node(temp.element, null);
                break;
            }
            counter++;
            temp = temp.next;
        }
        counter = 0;
        temp = tempHead;
        while (temp != null) {
            if (counter == countNode() - 1) {
                temp.next = null;
                this.head = tempHead;
                break;
            }

            counter++;
            temp = temp.next;
        }
    }

      public String toString(){
            String s = "";
            for(Node n = this.head; n != null; n=n.next){
                if(n.next == null){
                   s += n.element+" ";
                }else{
                   s += n.element+" --> ";
                }
                  
            }
            return s;
      }
}
