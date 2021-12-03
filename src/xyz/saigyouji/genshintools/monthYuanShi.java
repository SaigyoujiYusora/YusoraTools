package xyz.saigyouji.genshintools;//import java.util.Objects;
//import java.util.Properties;
import java.util.Scanner;

public class monthYuanShi
{
    public static void main(String[] args)
    {
//        Scanner input = new Scanner(System.in);
//        String wuHu = input.next();
        System.out.println("欢迎使用嘴臭原石攒攒乐计算器");
        System.out.println("输入Y代表年，输入M代表月,输入D代表日，输入exit跑路");
//        while (!input.next().equals("exit")) {
        exitPosition:
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("请输入能攒的时间");
            String inputTime = input.next();
            int days = 0;//天数
            int year = 0;int month = 0;int day = 0;
            for (int i = 0; i == 0; ) {
                String tempTime;
                //时间解析
                if (inputTime.matches("exit")){
                    break exitPosition;
                } else if (inputTime.matches(".*[Yy].*")) {//年
                    if (inputTime.contains("Y")) {
                        tempTime = inputTime.substring(0, inputTime.indexOf("Y"));
                    } else {
                        tempTime = inputTime.substring(0, inputTime.indexOf("y"));
                    }
                    inputTime = inputTime.substring(tempTime.length() + 1);
                    days = days + 365 * Integer.parseInt(tempTime);
                    year = Integer.parseInt(tempTime);
                } else if (inputTime.matches(".*[Mm].*")) {//月
                    if (inputTime.contains("M")) {
                        tempTime = inputTime.substring(0, inputTime.indexOf("M"));
                    } else {
                        tempTime = inputTime.substring(0, inputTime.indexOf("m"));
                    }
                    inputTime = inputTime.substring(tempTime.length() + 1);
                    days = days + 30 * Integer.parseInt(tempTime);
                    month = Integer.parseInt(tempTime);
                } else if (inputTime.matches(".*[Dd].*")) {//日
                    if (inputTime.contains("D")) {
                        tempTime = inputTime.substring(0, inputTime.indexOf("D"));
                    } else {
                        tempTime = inputTime.substring(0, inputTime.indexOf("d"));
                    }
                    inputTime = inputTime.substring(tempTime.length() + 1);
                    days = days + Integer.parseInt(tempTime);
                    day = Integer.parseInt(tempTime);
                    i = 1;
                }else if(inputTime.matches("^[0-9]\\d*$")) {//纯数字天数
                    days = Integer.parseInt(inputTime);
                    for (int tempDate = days; tempDate >= 31; ) {
                        if (tempDate >= 365) {
                            year = tempDate / 365;
                            tempDate = tempDate % 365;
                        } else {
                            month = tempDate / 30;
                            tempDate = tempDate % 30;
                            day = tempDate;
                            break;
                        }
                    }
                    i = 1;
//                }else if(inputTime.matches("")){
                }else if(inputTime.isEmpty()){//跳出循环
                    i = 1;
                }else {
                    System.out.println("输入错误，请重新输入");
                    inputTime = input.next();
                }
            }
            System.out.println("是否购买了月卡");
            int monthCardDays = 0;//月卡剩余天数
            int monthCardExtra = 0;
            if (input.next().equals("Y")) {
                System.out.print("月卡剩余时间");
                String inputTemp = input.next();
                for (int i = 0; i <= 5; ) {
                    if (inputTemp.matches("^[0-9]\\d*$")) {
                        monthCardDays = Integer.parseInt(inputTemp);
                    } else {
                        System.out.println("输入错误，请重新输入");
                        i++;
                        System.out.print("月卡剩余时间");
                        inputTemp = input.next();
                    }
                    if (i == 5) {
                        System.out.println("耍👴玩呢？");
                        i--;
                    }
                }
            } else{
                System.out.println("月卡未购买");
            }
            System.out.println("是否自动购买月卡");
            if (input.next().matches(".*[Yy].*")){
                monthCardExtra = (days - monthCardDays) / 30 * 300;
            } else{
                System.out.println("您选择不购买月卡");
            }
            System.out.println("请输入现有的星尘");
            int xingChen = input.nextInt();
            int JiuChan;
            if ((days / 30) * 5 * 75 <= xingChen && xingChen >= 5 * 75) {
                System.out.println((days / 30) * 5 * 75);
                JiuChan = days * 5;
            } else {
                JiuChan = xingChen / 75;
            }
            int allYuanShi = (10 * 4 + 20) * days + monthCardDays * 90 + monthCardExtra;//总原石
            allYuanShi = allYuanShi + (days / 30 * 300);
//            int allYuanShi = allYuanShi * days;
            int allChouKa = (allYuanShi / 160) + JiuChan;
//        double possibility = 0.0006;
            if (allChouKa <= 5) {
                System.out.println("就这么丁点抽你🐴呢？");
            } else if (allChouKa <= 80) {
                System.out.println("阳寿消失了没准能出");
//            possibility = allChouKa * possibility;
            } else if (allChouKa < 180) {
                System.out.println("你又觉得你小保底能出了¿");
            } else {
                System.out.println("恰大保底啦!芜湖起飞~");
            }
            if(days<=31) {
                System.out.print(days);
            }else{
                if(year!=0){
                    System.out.print(year+"年");
                }
                if (month!=0){
                    System.out.print(month+"月");
                }
                if (day!=0){
                    System.out.print(day);
                }
            }
            System.out.println("天最多能攒" + allChouKa + "发,共计" + allYuanShi + "个原石和最多" + JiuChan + "个纠缠之缘");
            System.out.println();
        }
    }
}