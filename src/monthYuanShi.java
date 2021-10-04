import java.util.Objects;
import java.util.Properties;
import java.util.Scanner;

public class monthYuanShi
{
    public static void main(String[] args)
    {
//        Scanner input = new Scanner(System.in);
//        String wuHu = input.next();
        System.out.println("欢迎使用嘴臭原石攒攒乐计算器，每次循环时第一次值输入exit跑路");
//        while (!input.next().equals("exit")) {
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("请输入能攒的月数");
            String firstInput = input.next();
//            if (input.next().equals("exit")) {
            if (firstInput.equals("exit")) {
                break;
            } else {
                int time = Integer.parseInt(firstInput);
//                System.out.println("请输入能攒的月数");
//                int time = input.nextInt();
                System.out.println("请输入现有的星尘");
                int jiuChan = input.nextInt();
//        int monthJiuChan = 5;
//        int jiuChanTimes = (jiuChan-(jiuChan % 75))/4;
                int AllJiuChan;
                if (time * 5 * 75 <= jiuChan) {
                    AllJiuChan = time * 5;
                } else {
                    AllJiuChan = jiuChan / 75;
                }
                int yuanShi = (90 + 10 * 4 + 20) * 30 + 300;
                int allYuanShi = yuanShi * time;
                int allChouKa = ((time * yuanShi) / 160) + AllJiuChan;
//        double possibility = 0.0006;
                if (allChouKa <= 5) {
                    System.out.println("就这么丁点抽你🐴呢？");
                } else if (allChouKa <= 80) {
                    System.out.println("就这点吃💩有你的份");
//            possibility = allChouKa * possibility;
                } else if (allChouKa < 180) {
                    System.out.println("有、希望出");
                } else {
                    System.out.println("芜湖起飞~");
                }
                System.out.println(time + "个月最多能攒" + allChouKa + "发,共计" + allYuanShi + "个原石和最多" + AllJiuChan + "个纠缠之缘");
                System.out.println();
            }

        }
    }
}