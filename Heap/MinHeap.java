package Marquee.BinarySearch.Heap;

public class MinHeap {
    int size;
    int[] arr = new int[size];

    MinHeap(int size){
        arr = new int[size+1];
    }

    public void display(){
        for(int i=1; i<=size; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public void peek(){
        System.out.println(size>1? arr[1]: -1);
    }

    public boolean isEmpty(){
        return size==0?true:false;
    }

    public boolean isFull(){
        return size==arr.length-1?true:false;
    }


    public void add(int val){
        if(isFull()) return;
        arr[++size] = val;
        heapfyButtonUp(size);
    }

    public void heapfyButtonUp(int index){
        if(index<=1) return;
        int parent = index/2;
        if(arr[parent]>arr[index]){
            int temp = arr[parent];
            arr[parent] = arr[index];
            arr[index] = temp;
        }
        heapfyButtonUp(parent);
    }

    public void delete(){
        if(isEmpty()){
            System.out.println("The array is empty!");
            return;
        }
        arr[1] = arr[size--];
        heapfyTopBottom(1);
    }

    public void heapfyTopBottom(int index){
        int l = index*2;
        int r = index*2+1;
        if(size<l) return;
        if(size==l&& arr[l]<arr[index]){
            int temp = arr[l];
            arr[l] = arr[index];
            arr[index] = temp;
        }
        else{
            int swap = arr[l]<arr[r]? l: r;
            if(arr[swap]<arr[index]){
                int temp = arr[swap];
                arr[swap] = arr[index];
                arr[index] = temp;
            }
            heapfyTopBottom(swap);
        }
    }


    public static void main(String args[]){
        MinHeap mh = new MinHeap(10);
        mh.add(10);
        mh.add(12);
        mh.add(9);
        mh.add(15);
        mh.add(7);
        mh.display();
        System.out.println();
        mh.peek();

        mh.delete();
        mh.display();
        System.out.println();
        mh.peek();
    }

}
