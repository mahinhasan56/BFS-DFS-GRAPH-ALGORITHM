package lab3;
public class ArrayQueue implements Queue {

    int size;
    int front;
    int rear;
    Object[] data;

    public ArrayQueue() {
        size = 0;
        front = -1;
        rear = -1;
        data = new Object[5];
    }

//TO DO
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        boolean empty = true;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                empty = false;
                break;
            }
        }
        return empty;
    }

    @Override
    public void enqueue(Object o) {
        if (size == data.length) {
            Object[] temp = new Object[data.length + 1];
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
            enqueue(o);
        } else {
            data[size] = o;
            rear = size;
            front = 0;
            size++;
        }
    }

    @Override
    public Object dequeue() throws QueueUnderflowException {
        Object dequeued = null;
        if (isEmpty() == true) {
            throw new QueueUnderflowException();
        } else {
            dequeued = data[front];
            data[front] = null;
            Object[] temp = new Object[data.length - 1];
            int j = 1;
            for (int i = 0; i < temp.length; i++) {
                temp[i] = data[j];
            }
            data = temp;
            size--;
            if(size==-1){
                size = 0;
            }
        }
        return dequeued;
    }

    @Override
    public Object peek() throws QueueUnderflowException {
        Object peeked = null;
        if (isEmpty() == true) {
            throw new QueueUnderflowException();
        } else {
            peeked = data[front];
        }
        return peeked;
    }

    @Override
    public Object[] toArray() {
        return data;
    }

    @Override
    public int search(Object o) {
          int offset = -1;
          for(int i = 0; i < data.length; i++){
               if(o.equals(data[i])){
                      offset = i;
                      break;
               }
          }
          return offset;
    }

    public String toString() {
        String s = "[ ";
        for (int i = 0; i < data.length; i++) {
            s += data[i] + " ";
        }
        s += " ]";
        return s;
    }

}
