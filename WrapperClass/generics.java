package Marquee.BinarySearch.WrapperClass;

public class generics {
    public static void main(String[] args){
        // Whenever obj created of the generic class don't have placeholder then Object type is added
        Demo demo = new Demo("Hola");
        Demo<String> d = new Demo<String>("Shruti");

        //Example of how autoboxing occurs in the generic classes
        Demo<Integer> demo1 = new Demo<Integer>(12);
        System.out.println(demo1.getValue()*10);


        System.out.println(d.getValue());
        System.out.println(demo.getValue());
    }
}

class Demo<E>{
    E value;
    Demo(E value){
        this.value = value;
    }
    public void setValue(E value){
        this.value = value;
    }

    public E getValue(){
        return value;
    }
}