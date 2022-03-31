public class Search {

    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        System.out.println("is element found? "+ (reverseBinarySearch(arr,1,1,130) ? "yes" :" no"));

    }

    public static boolean reverseBinarySearch(int[] arr,int start, int end, int ele){

        if(start > arr.length)
            return false;
        if(end > arr.length)

        /*
        if(arr[start-1] > ele){
            return false;
        }

        if(arr[end-1] < ele){
            return false;
        }
        *
         */

        if(arr[start-1] < ele && arr[end-1] > ele  ){
            for (int i=start;i<end;i++){
                if(arr[i] == ele) {
                    return true;
                }
            }
        }

        int newStart = 2*start;
        int newEnd = 2*end+1;

        return reverseBinarySearch(arr,newStart,newEnd,ele);

    }
}
