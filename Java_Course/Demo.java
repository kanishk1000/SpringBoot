import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Demo {

    public static void main(String[] args) {

        Comparator<String> comp = new Comparator<String>() {
            
            public int compare(String s1, String s2){

                if(s1.length() > s2.length()){
                    return 1;
                }else{
                    return -1;
                }
            }
        };


        ArrayList<String> arr = new ArrayList<>();

        arr.add("Hello");
        arr.add("Hey");
        arr.add("Hi");
        arr.add("H");

        Collections.sort(arr, comp);

        System.out.println(arr);
    }
}
