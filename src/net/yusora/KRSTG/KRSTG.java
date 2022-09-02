package net.yusora.KRSTG;//import java.io.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
//import java.util.Scanner;

public class KRSTG {
    public static void main(String[] args) {

        String inputString = null;

        String path = System.getProperty("user.dir");
        File file = new File(path+"\\out\\output.txt");

        File inputFile = new File(path+"\\out\\input.txt");
        //read file
        try {
            FileInputStream inputStream = new FileInputStream(inputFile);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            inputString = bufferedReader.readLine();
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.print(inputString);

        while (true) {
            //a scanner can input text
//            Scanner input = new Scanner(System.in);
//            String inputString = input.nextLine();



//        for (int i = 0; i != 1; i++) {
            if (Objects.equals(inputString, "exit")) {
                break;
            }
            String outputString = null;
            String tempString = null;
            int jumpOut = 0;
            while (true) {


                if (jumpOut==1&tempString==null){
                    break;
                }
                if (!(tempString != null & jumpOut != 0)) {
                    tempString = inputString;
                    jumpOut++;
                }

                //Get the first line of the string from inputString and store the rest of the string in temp
                if (tempString.contains("\n")) {
//                if (tempString != null) {
                    outputString = tempString.substring(0, inputString.indexOf("\n"));
                    tempString = tempString.substring(inputString.indexOf("\n") + 1);
                }else {
                    outputString = tempString;
                }
//            tempString = inputString.substring(0, inputString.indexOf("\r\n"));
                outputString = outputString.replaceAll("-", "");
//            outputString = inputString.replaceAll("-", "");
                outputString = outputString.replaceAll("\"", "");
                outputString = outputString.replaceAll("\s", "");
                System.out.println("if(dnsDomainIs(host, " + outputString + ")){return 'DIRECT'}");
                //write outputString to file
                try {
                    FileOutputStream fos = null;
                    if (!file.exists()) {
                        file.createNewFile();//如果文件不存在，就创建该文件
                        fos = new FileOutputStream(file);//首次写入获取
                    } else {
                        //如果文件已存在，那么就在文件末尾追加写入
                        fos = new FileOutputStream(file, true);
                    }

                    OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);//指定以UTF-8格式写入文件
                    osw.write("if(dnsDomainIs(host, " + outputString + ")){return 'DIRECT'}");

                    osw.write("\r\n");
                    osw.close();
                } catch (Exception e) {

                    e.printStackTrace();
                }
            }
        }
    }
}
