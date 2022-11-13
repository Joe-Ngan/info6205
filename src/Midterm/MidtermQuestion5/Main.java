package Midterm.MidtermQuestion5;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] arr = {0,0,0,0,0,1,1,1,1,2,2,5,5,5,8,9,10,11};
        int[] values = {1,4,5,10};
        for(int a : getStartOfEachValues(arr, values)) System.out.println(a);
    }


    // arr = [0,0,0,0,0,1,1,1,1,2,2,5,5,5,8,9,10,11]
    // values = [1,4,5,10]
    // output = [5, -1, 11, 16]
    private static int[] getStartOfEachValues(int[] arr, int[] values){
        int[] indexes = new int[values.length];
        for(int i=0; i<values.length; i++){
            int value = values[i];
            int l = 0, r = arr.length-1;
            while(l<r){
                int mid = l+(r-l)/2;
                if(arr[mid]>=value){
                    r = mid;
                }else{
                    l = mid+1;
                }
            }
            if(arr[l]==value){
                indexes[i] = l;
            }else{
                indexes[i] = -1;
            }
        }
        return indexes;
    }
}