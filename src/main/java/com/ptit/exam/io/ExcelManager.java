package com.ptit.exam.io;

import com.ptit.exam.persistence.entity.Student;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.*;
import java.util.*;

/**
 * User: thuongntt
 * Date: 11/26/13
 * Time: 9:15 AM
 */
public class ExcelManager {
    public static List<Student> readData(String path) {
        try {
            FileInputStream file = new FileInputStream(new File(path));

            //Get the workbook instance for XLS file
            HSSFWorkbook workbook = new HSSFWorkbook(file);

            //Get first sheet from the workbook
            HSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows from first sheet
            Iterator<Row> rowIterator = sheet.iterator();
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }
            List<Student> studentList = new ArrayList<Student>();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                //For each row, iterate through each columns
                Iterator<Cell> cellIterator = row.cellIterator();
                Student student = new Student();
                Cell cell = cellIterator.next();
                String firstName = cell.getStringCellValue();
                student.setFirstName(firstName);
                cell = cellIterator.next();
                String lastName = cell.getStringCellValue();
                student.setLastName(lastName);
                cell = cellIterator.next();
                student.setGender(cell.getStringCellValue());
                cell = cellIterator.next();
                student.setDateOfBirth(cell.getStringCellValue());
                cell = cellIterator.next();
                student.setStudentCode(cell.getStringCellValue());
                cell = cellIterator.next();
                student.setClassRoom(cell.getStringCellValue());
                cell = cellIterator.next();
                student.setFaculty(cell.getStringCellValue());
                cell = cellIterator.next();
                student.setCourse(cell.getStringCellValue());
                cell = cellIterator.next();
                student.setTrainingType(cell.getStringCellValue());

                String shortLastName = "";
                String[] subLastNames = lastName.trim().split(" ");
                for (int i = 0; i < subLastNames.length; i++) {
                    shortLastName = shortLastName.concat(subLastNames[i].substring(0, 1));
                }
                String key = firstName.trim().concat(shortLastName);
                student.setUserName(key);
                student.setPassWord(key);

                studentList.add(student);
            }
            file.close();
            return studentList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeData() {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Sample sheet");

        Map<String, Object[]> data = new HashMap<String, Object[]>();
        data.put("1", new Object[]{"Emp No.", "Name", "Salary"});
        data.put("2", new Object[]{1d, "John", 1500000d});
        data.put("3", new Object[]{2d, "Sam", 800000d});
        data.put("4", new Object[]{3d, "Dean", 700000d});

        SortedSet<String> keyset = new TreeSet<String>(data.keySet());
        int rownum = 0;
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof Date)
                    cell.setCellValue((Date) obj);
                else if (obj instanceof Boolean)
                    cell.setCellValue((Boolean) obj);
                else if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Double)
                    cell.setCellValue((Double) obj);
            }
        }

        try {
            FileOutputStream out = new FileOutputStream(new File("E:\\test.xls"));
            workbook.write(out);
            out.close();
            System.out.println("Excel written successfully..");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        try {
            FileInputStream file = new FileInputStream(new File("C:\\update.xls"));

            HSSFWorkbook workbook = new HSSFWorkbook(file);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Cell cell = null;

            //Update the value of cell
            cell = sheet.getRow(1).getCell(2);
            cell.setCellValue(cell.getNumericCellValue() * 2);
            cell = sheet.getRow(2).getCell(2);
            cell.setCellValue(cell.getNumericCellValue() * 2);
            cell = sheet.getRow(3).getCell(2);
            cell.setCellValue(cell.getNumericCellValue() * 2);

            file.close();

            FileOutputStream outFile = new FileOutputStream(new File("C:\\update.xls"));
            workbook.write(outFile);
            outFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
