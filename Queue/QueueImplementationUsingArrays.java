package Marquee.BinarySearch.Queue;

public class QueueImplementationUsingArrays {

    int rear = -1;
    int front = -1;
    int[] queue = new int[5];

    public boolean isEmpty(){
        return front==-1 || rear==-1;
    }

    public boolean isFull(){
        return rear+1%queue.length==front;
    }

    public boolean enqueue(int val){
        if(isFull()) return false;
        if(isEmpty()){
            rear++;
            front++;
        }
        else{
            rear = (rear+1)%queue.length;
        }
        queue[rear] = val;
        return true;
    }

    public boolean dequeue(){
        if(isEmpty()) return false;
        if(front==rear) front = rear = -1;
        else front = (front+1)%queue.length;
        return true;
    }
    // Sir's display logic
//    public void display(){
//        int i = front;
//        do{
//            System.out.println(queue[i]+" ");
//            i = (i+1)%queue.length;
//        }while(i!=((rear+1)%queue.length));
//        System.out.println();
//    }

      // Alternate approach based on the size
//    public void display(){
//        int k = front;
//        for(int i=size; i>=1; i--){
//            System.out.print(queue[k]);
//            k = (k+1)%queue.length;
//        }
//    }

//    public boolean isEmpty(){
//        if(front==rear) return true;
//        if(front!=rear){
//            front = (front+1)%queue.length;
//        }
//        else{
//            front=rear=-1;
//        }
//        return false;
//    }

//    public boolean isFull(){
//        if(isEmpty()) return false;
//        if(front==rear){
//            return true;
//        }
//        return false;
//    }
//
//    public boolean enqueue(int val){
//        if(isFull()){
//            return false;
//        }
//        if(isEmpty()){
//            front++;
//            queue[front] = val;
//            rear++;
//        }
//        else{
//            queue[++rear] = val;
//        }
//        return true;
//    }
//
//    public boolean dequeue(){
//        if(isEmpty()) return false;
//        else{
//            front++;
//        }
//        return true;
//    }
//
    public void display(){
        System.out.print("[ " + queue[front]);
        if(rear<front){
            for(int i=front+1; i<queue.length; i++){
                System.out.print(", "+queue[i]);
            }
            for(int i=0; i<=rear; i++){
                System.out.print(", "+queue[i]);
            }
        }
        else if(rear==front){
            for(int i=front+1; i<queue.length; i++){
                System.out.print(", "+queue[i]);
            }
            for(int i=0; i<rear; i++){
                System.out.print(", "+queue[i]);
            }
        }
        else{
            for(int i=front+1; i<=rear; i++){
                System.out.print(", "+queue[i]);
            }
        }
        System.out.println(" ]");
    }

    public static void main(String[] args){
        QueueImplementationUsingArrays qi = new QueueImplementationUsingArrays();
        System.out.println("The value of rear and front: "+qi.rear+ " "+qi.front);
        qi.enqueue(30);
        System.out.println("The value of rear and front: "+qi.rear+ " "+qi.front);
        qi.enqueue(40);
        System.out.println("The value of rear and front: "+qi.rear+ " "+qi.front);
        qi.enqueue(90);
        System.out.println("The value of rear and front: "+qi.rear+ " "+qi.front);
        qi.enqueue(40);
        System.out.println("The value of rear and front: "+qi.rear+ " "+qi.front);
        qi.enqueue(90);
        System.out.println("The value of rear and front: "+qi.rear+ " "+qi.front);
        qi.dequeue();
        System.out.println("The value of rear and front: "+qi.rear+ " "+qi.front);
        qi.dequeue();
        System.out.println("The value of rear and front: "+qi.rear+ " "+qi.front);
        qi.enqueue(90);
        System.out.println("The value of rear and front: "+qi.rear+ " "+qi.front);
        qi.enqueue(40);
        System.out.println("The value of rear and front: "+qi.rear+ " "+qi.front);
        System.out.println(qi.enqueue(90));
        System.out.println("The value of rear and front: "+qi.rear+ " "+qi.front);
        qi.display();
    }

}
