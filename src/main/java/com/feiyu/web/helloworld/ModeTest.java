package com.feiyu.web.helloworld;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModeTest {
    public static void bijiao(String s1,String s2){
        String regString = "+d";
        String regEx="['"+regString+"']";
        //可以在中括号内加上任何想要替换的字符，实际上是一个正则表达式
        String aa = "";//这里是将特殊字符换为aa字符串," "代表直接去掉
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher("56789abc+dd=fg");//这里把想要替换的字符串传进来
        String newString = m.replaceAll(aa).trim();
        System.out.println(newString);
    }
    public static void sayHello(Map m1) {
        String[] stringTest;
        String whiteString;
        String stringLength = String.valueOf(m1.get("长度"));
        String white = String.valueOf(m1.get("白名单"));
        String black = String.valueOf(m1.get("黑名单"));
        String first = String.valueOf(m1.get("必须以开头的字符"));
        String Notfirst = String.valueOf(m1.get("不能以开头的字符"));

        String[] sourceStrArray = stringLength.split("-");
//        for (int i = 0; i < sourceStrArray.length; i++) {
//            int min = Integer.getInteger(sourceStrArray[i]);
//        }
        int min = Integer.getInteger(sourceStrArray[0]) - 1;
        int max = Integer.getInteger(sourceStrArray[1]) + 1;
        int ok = Integer.getInteger(sourceStrArray[1]) + 1;

        if (white.equals(null)){
            whiteString = "abc";
        }
        else{

        }
    }

    public static Map readExcel(String name){
        Map m1 = new HashMap();
        try {
            //创建工作簿
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream("E:\\minieye\\E\\java\\IDEA\\hello-Maven\\1.xlsx"));
            System.out.println("xssfWorkbook对象：" + xssfWorkbook);
            //读取第一个工作表(这里的下标与list一样的，从0开始取，之后的也是如此)
            //XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
            XSSFSheet sheet = xssfWorkbook.getSheet("Customer");
            System.out.println("sheet对象：" + sheet);
            //获取第一行的数据
            //XSSFRow row = sheet.getRow(0);
            //sheet.getLastRowNum()获取最后一行行号
            int maxRow = sheet.getLastRowNum() + 1;
            System.out.println("maxRow:" + maxRow);
            for(int i=1;i < maxRow;i++) {
                XSSFRow row = sheet.getRow(i);
                //获取第一列属性名称数据
                XSSFCell cell0 = row.getCell(0);
                System.out.println("cello对象：" + cell0);
                String cell0_String = String.valueOf(cell0);
                System.out.println("cell0_String" + cell0);
                System.out.println("name:" + name);
                if (cell0_String.equals(name)){
                    System.out.println("match ok!");
                    m1.put("长度", row.getCell(1));
                    m1.put("白名单", row.getCell(2));
                    m1.put("黑名单", row.getCell(3));
                    m1.put("必须以xx开头", row.getCell(4));
                    m1.put("不能以xx开头", row.getCell(5));
                    m1.put("不能全是xx", row.getCell(6));
                }
            }
//            //获取最后一行的num，即总行数。此处从0开始计数
//            XSSFRow row = sheet.getRow(1);
//            //System.out.println("row对象：" + row);
//            //获取该行第一个单元格的数据
//            //XSSFCell cell0 = row.getCell(0);
//            XSSFCell cell0 = row.getCell(6);
//            System.out.println("cello对象：" + cell0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return m1;
    }
    public static void main(String[] args) {
        String name = "联系人";
        Map m1 = readExcel(name);
        String s1 = String.valueOf(m1.get("黑名单"));
        System.out.println(s1);

//        String s2 = "a";
//        String[] s3 = s2.split(" ");
//        System.out.println("长度:"+s3.length);
//        for(int i = 0; i < s3.length;i++){
//            System.out.println(s3[i]);
    }
}
