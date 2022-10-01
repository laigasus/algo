package day04;

public class ZeroFinderStr {
    
    public static void main(String[] args) {
        int[] arr={6,0,8,2,3,0,4,0,1};
        
        int j=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]!=0){
                arr[j]=arr[i];
                j++;
            }
        }
        for(int i=j; i<arr.length;i++){
            arr[i]=0;
        }

        for(var i: arr){
            System.out.printf("%d ", i);
        }
    }
}
