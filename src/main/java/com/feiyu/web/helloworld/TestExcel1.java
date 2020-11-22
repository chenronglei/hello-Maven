package com.feiyu.web.helloworld;

import org.apache.poi.xssf.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Auther: zjk
 * @Date: 2019/8/30
 * @Description:
 */
public class TestExcel1 {
    public static void main(String[] args) {
        try {
            //创建工作簿
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream("E:\\minieye\\E\\java\\IDEA\\hello-Maven\\1.xlsx"));
            System.out.println("xssfWorkbook对象：" + xssfWorkbook);
            //读取第一个工作表(这里的下标与list一样的，从0开始取，之后的也是如此)
            XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
            System.out.println("sheet对象：" + sheet);
            //获取第一行的数据
            XSSFRow row = sheet.getRow(0);
            System.out.println("row对象：" + row);
            //获取该行第一个单元格的数据
            XSSFCell cell0 = row.getCell(0);
            System.out.println("cello对象：" + cell0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
