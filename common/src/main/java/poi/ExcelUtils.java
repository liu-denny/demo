package poi;

import lombok.Data;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Excel工具类
 * @auther denny
 * @create 2019-12-10 14:32
 */
@Data
public class ExcelUtils {
    private static int num;

    public ExcelUtils(int num) {
        this.num = num;
    }

    public ExcelUtils() {
        this.num = 0;
    }


    /**
     * 创建文件，写入
     */
    public static void createExcel(String fileName,String sheetName,String[] title,Object[][] values) {
        if (num == 0) {
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(new File(fileName)); // 若文件不存在则自动创建
                XSSFWorkbook workbook = new XSSFWorkbook();

                XSSFSheet sheet = workbook.createSheet(sheetName);
                XSSFRow row = sheet.createRow(num);  // 创建行，第一行

                //写入标题
                if(title != null){
                    for(int i=0;i<title.length;i++){
                        XSSFCell cell = row.createCell(i);
                        cell.setCellValue(title[i]);
                    }
                }else {
                    num = num -1;
                }

                //写入数据
                if(values != null){
                    for(int i=0;i<values.length;i++) {
                        num++;
                        XSSFRow row1 = sheet.createRow(num);
                        for (int j = 0; j < values[i].length; j++) {
                            //将内容按顺序赋给对应的列对象
                            String v = String.valueOf(values[i][j]).equals("null")? " ":String.valueOf(values[i][j]);
                            row1.createCell(j).setCellValue(v);

                        }

                    }
                }
                workbook.write(fos);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fos != null) {
                        fos.close();
                    }
                } catch (IOException e) {
                    //ignore
                }
            }
        }
    }



    /**
     * 追加写入
     */
    public static void appendToExcel(String fileName,String sheetName,String[][] values) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(fileName);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);

            XSSFSheet sheet = workbook.getSheet(sheetName);
            if(sheet == null){
                sheet = workbook.createSheet(sheetName);
            }
            if (sheet != null) {
                for(int i=0;i<values.length;i++) {
                    num++;
                    XSSFRow row = sheet.createRow(num);
                    if (values[i] != null) {
                        for (int j = 0; j < values[i].length; j++) {
                            //将内容按顺序赋给对应的列对象
                            row.createCell(j).setCellValue(values[i][j]);
                        }
                    } else {
                        continue;
                    }
                }

            }
            fos = new FileOutputStream(fileName);
            workbook.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                //ignore
            }
        }
    }
}
