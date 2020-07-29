package kits.atmmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Find_Minimum_number_Coins {
    /*
        Solution: Greedy Approach.

        Approach: A common intuition would be to take coins with greater value first. This can reduce the total number of coins needed.
        Start from the largest possible denomination and keep adding denominations while the remaining value is greater than 0.

        Algorithm:
        1.Sort the array of coins in decreasing order.
        2.Initialize result as empty.
        3.Find the largest denomination that is smaller than current amount.
        4.Add found denomination to result. Subtract value of found denomination from amount.
        5.If amount becomes 0, then print result.
        6.Else repeat steps 3 and 4 for new value of V.
    */
//    static int priceTag[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};

    //Greedy Algorithm
    public static int findMininumNumberCoins(int value) {
        int priceTag[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000,5000};
        // sort array increasing
        Arrays.sort(priceTag);
        int start = 0;
        int end = priceTag.length - 1;
        int temp;

        // 1.Sort the array of coins in decreasing order.
        // Chỉ swap dc khi mảng tăng dần
        while (start <= end) {
            temp = priceTag[start];
            priceTag[start] = priceTag[end];
            priceTag[end] = temp;
            start++;
            end--;
        }

        // 2.Initialize result as empty.
        List<Integer> listResult = new ArrayList<Integer>();

        int count = 0;
        boolean isOK = true;
        int max_current;
        while (isOK == true) {
            // 3.Find the largest denomination that is smaller than current amount.
            max_current = Integer.MIN_VALUE;
            for (int i = 0; i < priceTag.length; i++) {

                if (max_current <= priceTag[i] && priceTag[i] <= value) {
                    max_current = priceTag[i];
                }
            }
//        System.out.println(max_current);

            // 4.Add found denomination to result. Subtract value of found denomination from amount.
            listResult.add(max_current);
            value = value - max_current;

            // 5.If amount becomes 0, then print result.

            if (value == 0) {
                for (int i = 0; i < listResult.size(); i++) {
                    System.out.print(listResult.get(i) + " ");
                    count++;
                }
                isOK = false;
            } else {
                // 6.Else repeat steps 3 and 4 for new value of V.
                isOK = true;
            }
        }
        return count;
    }

    // Cùng thuật toán nhưng thay đổi code
    public static int findMininumNumberCoins2(int value) {
        int priceTag[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000,5000};
        List<Integer> list = new ArrayList<Integer>();
        int n = priceTag.length;

        int count=0;
        // Duyệt ngược đi từ giá trị 1000 xuống => rút gọn dc bước đảo ngược chuỗi
        for (int i = n - 1; i >= 0; i--) {
            // Nếu priceTag[i] vẫn nhỏ hơn value thì tiếp tục vòng while(tiếp tục add vào list kết quả)
            while(priceTag[i]<=value){
                list.add(priceTag[i]);
                value-=priceTag[i];
                count++;
            }
        }

        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }

        return count;
    }


    public static void main(String[] args) {
        findMininumNumberCoins(93);
        System.out.println();
        findMininumNumberCoins2(93);
        System.out.println();
        findMininumNumberCoins(9122);
        System.out.println();
        findMininumNumberCoins2(9122);
    }


}
