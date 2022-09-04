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
/*
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
*/

            //read file V2
            Long fileLength = inputFile.length(); // 获取文件长度
            byte[] fileContent = new byte[fileLength.intValue()];
            try
            {
                FileInputStream in = new FileInputStream(inputFile);
                in.read(fileContent);
                in.close();
            } catch (FileNotFoundException e)
            {
                e.printStackTrace();
            } catch (IOException e)
            {
                e.printStackTrace();
            }

            String[] fileContentArr = new String(fileContent).split("\r\n");
            int arrCount=0;
            inputString = fileContentArr[arrCount];
//            int arrLength = fileContentArr.length;
            int arrLength = fileContentArr.length;

//        System.out.print(inputString);
        int jumpOut = 0;
        while (true) {
            //a scanner can input text
//            Scanner input = new Scanner(System.in);
//            String inputString = input.nextLine();

            if (jumpOut==1) {
                break;
            }
            String outputString = "";

            while (true) {

                if (!(inputString.contains("#"))) {
                    if (arrCount == arrLength & jumpOut == 1) {
                        break;
                    }

                    outputString = inputString;
                    outputString = outputString.replaceAll("-", "");
                    outputString = outputString.replaceAll("\"", "");
                    outputString = outputString.replaceAll("\s", "");
//                    System.out.println("if(dnsDomainIs(host, " + outputString + ")){return 'DIRECT'}");
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
                        osw.write("if(dnsDomainIs(host, " + outputString + ")){return 'DIRECT'}");//写入的字符串

                        osw.write("\r\n");
                        osw.close();
                    } catch (Exception e) {

                        e.printStackTrace();
                    }
                } else {
                    inputString = inputString.replaceAll("#" , "//");
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
                        osw.write(inputString);//写入的字符串

                        osw.write("\r\n");
                        osw.close();
                    } catch (Exception e) {

                        e.printStackTrace();
                    }
                }
                arrCount++;
                if (arrCount == arrLength) {
                    jumpOut++;
                    break;
                }
                inputString = fileContentArr[arrCount];

            }
        }
    }
}
