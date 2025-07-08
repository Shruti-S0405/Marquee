package Marquee.BinarySearch.programs;

public class Biscuit implements Comparable{
    String brand;
    String expDate;
    String location;

    Biscuit(String brand, String location, String expDate){
        this.brand = brand;
        this.location = location;
        this.expDate = expDate;
    }

    public String toString(){
        return "[Brand = "+this.brand+", Location = "+this.location+", ExpDate = "+this.expDate+" ]";
    }

    public int compareTo(Object o){
//        Biscuit b = null;
//        if(o instanceof b){
//            b = (Biscuit) o;
//        }
//        if(b==null) return 0;
        return -(this.expDate.compareTo(((Biscuit)o).expDate));
    }
}
