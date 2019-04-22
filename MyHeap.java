public class MyHeap{
    private static void pushDown(int[]data, int size, int index){
        while (!(isLeaf(size, index))){
            if (data[index] > data[getChild(1, index)] && data[index] > data[getChild(2, index)]){
                return;
            }
            if (getNumOfChildren(size, index) == 2){
                if (data[getChild(2, index)] < data[getChild(1, index)]){
                    int temp = data[index];
                    data[index] = data[getChild(1, index)];
                    data[getChild(1, index)] = temp;
                    index = getChild(1, index);
                }else{
                    int temp = data[index];
                    data[index] = data[getChild(2, index)];
                    data[getChild(2, index)] = temp;
                    index = getChild(2, index);
                }
            }else if (getNumOfChildren(size, index) == 1){
                int temp = data[index];
                data[index] = data[getChild(1, index)];
                data[getChild(1, index)] = temp;
                index = getChild(1, index);
            }
        }
    }

    private static boolean isLeaf(int size, int index){
        if ((2 * index) + 1 >= size){
            return true;
        }
        return false;
    }

    private static int getNumOfChildren(int size, int index){
        int counter = 0;
        if ((2 * index) + 1 < size){
            counter++;
        }
        if ((2 * index) + 2 < size){
            counter++;
        }
        return counter;
    }
    
    private static int getChild(int firstorsecond, int index){
        return (2 * index) + firstorsecond;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        System.out.println(HeapHelp.toString(arr));
        System.out.println("--------------------------------------------");
        pushDown(arr, arr.length, 0);
        System.out.println(HeapHelp.toString(arr));
    }
}