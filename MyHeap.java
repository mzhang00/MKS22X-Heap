public class MyHeap{
    private static void pushDown(int[]data,int size,int index){
        if (getChild(index) + 1 < size){

        }
    }
    
    private static int getChild(int index){
        return 2 * index;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4};
        System.out.println(HeapHelp.toString(arr));
    }
}