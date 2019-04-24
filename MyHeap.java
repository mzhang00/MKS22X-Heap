import java.util.Arrays;

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

    //THIS WORKS BUT IS O(nlogn)
    public static void heapify(int[] data){
        int size = data.length;
        while (size > 0){
            for (int i = data.length - 1; i > -1; i--){
                pushUp(data, i);
            }
            size = size / 2;
        }
    }

    //public static void heapify(int[] data){
    //}

    public static void heapsort(int[] data){
        if (data.length <= 1){
            return;
        }
        int size = data.length - 1;
        heapify(data);
        while (size >= 0){
            int temp = data[0];
            data[0] = data[size];
            data[size] = temp;    
            pushDown(data, size, 0);
            size--;
        }
        if (data[0] > data[1]){
            int temp = data[0];
            data[0] = data[1];
            data[1] = temp;    
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
        int[] arr2 = {12, 23, 3, 45, 1, 2, 6, 4};
        int[] arr3 = {8, 6, 44, 52, 91, 75, 3};
        int[] arr4 = {1};
        int[] arr5 = {};
        int[] arr6 = {2993536, 6693945, 1193949, 4172304, 5869904, 3895615, 5219638, 2580467, 861059, 6521467, 7682276, 8499675, 193961, 4880936, 7329034, 6615093, 2245677, 3892264, 8952947, 1254224, 3719254, 5901205, 718206, 1193834, 645117, 5470890, 1574705, 3295808, 6205671, 2016870, 7369106, 2228194, 5191338, 6912940, 6844802, 5637363, 2826161, 2418829, 6505528, 6364368, 7288698, 7345152, 6003491, 5927353, 143844, 7746271, 3253931, 4888096, 2551921, 8725098, 3262965, 1543705, 6148019, 6107366, 6246941, 3515643, 8327852, 6317233, 4035750, 2738222, 9943827, 1367529, 9460975, 8852545, 8657640, 5032440, 6121382, 7761218, 3616102, 9856396, 4524578, 3227506, 3228092, 2465934, 9288196, 5654512, 6422426, 9622665, 6144961, 6618212, 2212790, 7234331, 75234, 5576231, 8792849, 9819551, 4426721, 3356411, 2732967, 1226163, 1635256, 4627155, 7563187, 731499, 6523532, 6987989, 2055704, 5861602, 6063858, 3275425};
        int[] arr7 = {2993536, 6693945, 1193949, 4172304, 5869904, 3895615, 5219638, 2580467, 861059, 6521467, 7682276, 8499675, 193961, 4880936, 7329034, 6615093, 2245677, 3892264, 8952947, 1254224, 3719254, 5901205, 718206, 1193834, 645117, 5470890, 1574705, 3295808, 6205671, 2016870, 7369106, 2228194, 5191338, 6912940, 6844802, 5637363, 2826161, 2418829, 6505528, 6364368, 7288698, 7345152, 6003491, 5927353, 143844, 7746271, 3253931, 4888096, 2551921, 8725098, 3262965, 1543705, 6148019, 6107366, 6246941, 3515643, 8327852, 6317233, 4035750, 2738222, 9943827, 1367529, 9460975, 8852545, 8657640, 5032440, 6121382, 7761218, 3616102, 9856396, 4524578, 3227506, 3228092, 2465934, 9288196, 5654512, 6422426, 9622665, 6144961, 6618212, 2212790, 7234331, 75234, 5576231, 8792849, 9819551, 4426721, 3356411, 2732967, 1226163, 1635256, 4627155, 7563187, 731499, 6523532, 6987989, 2055704, 5861602, 6063858, 3275425};
        int[] arr8 = {1,1,1,1,1,1,1,1,2,1,1,1,1,1};
        /*System.out.println(HeapHelp.toString(arr));
        System.out.println("--------------------------------------------");
        */
        /*System.out.println(HeapHelp.toString(arr1));
        System.out.println("--------------------------------------------");
        heapify(arr1);
        for (int i : arr1){
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(HeapHelp.toString(arr1));
        System.out.println("--------------------------------------------");
        */

        /*heapsort(arr8);
        for (int i : arr8){
            System.out.print(i + " ");
        }
        System.out.println();*/

        //Arrays.sort(arr7);
        //System.out.println(Arrays.equals(arr6,arr7));
    //*///}
        
        System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
        int[]MAX_LIST = {1000000000,500,10};
        for(int MAX : MAX_LIST){
            for(int size = 31250; size < 2000001; size*=2){
                long qtime=0;
                long btime=0;
                //average of 5 sorts.
                for(int trial = 0 ; trial <=5; trial++){
                    int []data1 = new int[size];
                    int []data2 = new int[size];
                    for(int i = 0; i < data1.length; i++){
                        data1[i] = (int)(Math.random()*MAX);
                        data2[i] = data1[i];
                    }
                    long t1,t2;
                    t1 = System.currentTimeMillis();
                    heapsort(data2);
                    t2 = System.currentTimeMillis();
                    qtime += t2 - t1;
                    t1 = System.currentTimeMillis();
                    Arrays.sort(data1);
                    t2 = System.currentTimeMillis();
                    btime+= t2 - t1;
                    if(!Arrays.equals(data1,data2)){
                        System.out.println("FAIL TO SORT!");
                        System.exit(0);
                    }
                }
            System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
            }   
            System.out.println();
        }
    }
}