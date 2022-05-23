public class Queue {
    private int front;
    private int back;
    private int size;
    private int capacity;
    public int[] array;

    public Queue(int capacity){
        this.capacity = capacity;
        if(capacity <= 0){
            this.capacity = 10;
        }
        else{
            this.capacity = capacity;
        }
        array = new int[capacity];
        front = 0;
        back = capacity - 1;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public boolean isFull(Queue queue){
        return queue.size == queue.capacity;
    }

    public boolean addQueue(int item){
        if(size == capacity){
            System.out.println("Queue is full");
            return false;
        }
        else{
            back = (back+1) % capacity;
            size++;
            array[back] = item;
            return true;

        }
    }

    public int removeQueue(){
        if(isEmpty()){
            System.out.println("Nothing to delete.");
            return 0;
        }
        else{
            int frontOld = this.front;
            size--;
            front = (front+1) % capacity;
            return frontOld;
        }
    }

    public int getFront(){
        assert (isEmpty());
        return front;
    }
    public int getBack(){
        assert (isEmpty());
        return back;
    }

    public void outputQueue(){
        if(size != 0){
            for (int i = front; i <= back; i++) {
                System.out.println(array[i]);
            }
        }

    }
    public int[] getArray(){
        return array;
    }


}
