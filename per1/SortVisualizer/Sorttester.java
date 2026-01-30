import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Sorttester {
    public static int pointer=0;
    public static int[] array={4,3,7,8,2,9,1,5,6,0};
    public static void main(String[] args) {
       System.out.println(Arrays.toString(array));
        sort2();
        
    }

    public static void sort2() {
        if(array[pointer]>pointer+1) {
            swapIndex(pointer, pointer+1);
             
        }
    }

    public static void swapIndex(int index1, int index2) {
    int temp=array[index1];
    array[index1]=array[index2];
    array[index2]=temp;
    }

}
