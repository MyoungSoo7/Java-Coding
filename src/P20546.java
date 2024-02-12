import java.io.*;
public class P20546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int moneyBNP = Integer.parseInt(br.readLine());
        int moneyTIMING = moneyBNP;
        int BNP = 0, TIMING = 0;
        int trackingUpDown = 0;
        String[] stock = br.readLine().split(" ");

        int today = Integer.parseInt(stock[0]);
        if (today <= moneyBNP) {
            int buying = moneyBNP / today;
            BNP += buying;
            moneyBNP -= buying * today;
        }

        for (int days = 1; days < 14; days++) {
            today = Integer.parseInt(stock[days]);
            if (today <= moneyBNP) {
                int buying = moneyBNP / today;
                BNP += buying;
                moneyBNP -= buying * today;
            }

            int yesterday = Integer.parseInt(stock[days - 1]);
            if ((today > yesterday)) {
                if (trackingUpDown < 0) {
                    trackingUpDown = 0;
                }
                trackingUpDown++;
            } else if ((today < yesterday)) {
                if (trackingUpDown > 0) {
                    trackingUpDown = 0;
                }
                trackingUpDown--;
            } else {
                trackingUpDown = 0;
            }

            if (trackingUpDown >= 3) {
                moneyTIMING += TIMING * today;
                TIMING = 0;
            } else if (trackingUpDown <= -3) {
                int buying = moneyTIMING / today;
                TIMING += buying;
                moneyTIMING -= buying * today;
            }
        }
        moneyBNP += today * BNP;
        moneyTIMING += today * TIMING;
        if (moneyBNP < moneyTIMING) {
            System.out.println("TIMING");
        } else if (moneyBNP > moneyTIMING) {
            System.out.println("BNP");
        } else {
            System.out.println("SAMESAME");
        }
    }
}
