package Stocks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stocks {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numDay = Integer.parseInt(reader.readLine());
        while (true) {
            if (numDay >= 1 && numDay <= Math.pow(10, 5)) {
                break;
            }
            numDay = Integer.parseInt(reader.readLine());
        }
        String str = reader.readLine();
        String[] strCheck = str.split(" ");
        while (true) {
            if (numDay != strCheck.length) {
                str = reader.readLine();
                strCheck = str.split(" ");
            } else break;
        }
        for (String s : strCheck) {
            if (Integer.parseInt(s) < 0 || Integer.parseInt(s) > Math.pow(10, 4)) {
                str = reader.readLine();
                strCheck = str.split(" ");
            }
        }
        int[] price = new int[numDay];
        for (int i = 0; i < numDay; i++) {
            price[i] = Integer.parseInt(strCheck[i]);
        }

        int res = 0;
        for (int i = 0; i < price.length; ) {
            int left = price[i];
            while (++i < price.length && price[i] >= price[i - 1])
                ;
            if (price[i - 1] > left)
                res += price[i - 1] - left;
        }
        System.out.print(res);

    }
}
