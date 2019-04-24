public class MyHeap{
    private static void pushDown(int[] data, int size, int index){
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

    private static void pushUp(int[] data, int index){
        while (!(isRoot(index))){
            if (data[index] < data[getParent(index)]){
                return;
            }else{
                int temp = data[index];
                data[index] = data[getParent(index)];
                data[getParent(index)] = temp;
                index = getParent(index);
            }
        }
    }

    public static void heapify(int[] data){
        for (int i = data.length - 1; i > -1; i--){
            pushUp(data, i);
        }
        for (int i = data.length - 1; i > -1; i--){
            pushUp(data, i);
        }
    }

    private static boolean isRoot(int index){
        return index == 0;
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

    private static int getParent(int index){
        return (index - 1) / 2;
    }

    public static void main(String[] args){
        int[] arr1 = {67, 81, 36, 69, 71, 68, 13, 64, 44, 46, 75, 35, 32, 58, 25, 50, 49, 88, 21, 65};
        int[] arr = {76, 30, 56, 51, 48, 49, 8, 33, 72, 86, 95, 50, 14, 6, 44, 52, 91, 75, 3, 22};
        System.out.println(HeapHelp.toString(arr));
        System.out.println("--------------------------------------------");
        heapify(arr);
        System.out.println(HeapHelp.toString(arr));
    }
}