import java.util.Arrays;

public class ArrSort {
    public static void main(String[] args) {
        int arr[] = new int[5];
        int i;
        int target = 8;

        arr[0] = 10;
        arr[1] = 20;
        arr[2] = -9;
        arr[3] = 8;
        arr[4] = 98;
        
        for (i = 0; i < 5; i++) {
            if (arr[i] == target) {
                System.out.println("找到了" + target + "，下标是：" + i);
                break;
            }
        }

        Arrays.sort(arr);

        System.out.println("排序后的数组：");
        for (i = 0; i < 5; i++) {
            System.out.println(arr[i]);
        }

    }
}