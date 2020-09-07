package codesignal;

import java.util.HashMap;
import java.util.List;

public class ExcelLoad {
    public static void main(String[] args){} /*{
        try {
            String excelPath = "D:/Tools/lgvelvet_050817.xlsx";
            FileInputStream file = new FileInputStream(excelPath); //파일을 찾아온다.
            XSSFWorkbook workbook = new XSSFWorkbook(file); //파일을 엑셀방식으로 로딩한다.
            List<HashMap<String, String>> result = new ArrayList<>();
            HashMap<String, String> data;
            String[] key = new String[0];

            int rowIndex = 0;
            int columnIndex = 0;
            int fristRow = -1;
            boolean keyFlag = false;
            //시트 수 (첫번째에만 존재하므로 0을 준다.)
            //만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다.

            XSSFSheet sheet = workbook.getSheetAt(0); //첫번째 시트를 가져온다. 여러개의 시트가 있다면 for문
            int rows = sheet.getPhysicalNumberOfRows();
            for (rowIndex = 0; rowIndex < rows; rowIndex++) {
                //행을 읽는다.
                XSSFRow row = sheet.getRow(rowIndex);
                if (row != null) {
                    if (fristRow < 0) {
                        fristRow = rowIndex;
                        keyFlag = true;
                    } else {
                        keyFlag = false;
                    }

                    //셀의 수
                    int cells = row.getPhysicalNumberOfCells();
                    if (key.length == 0) {
                        key = new String[cells];
                    }
                    data = new HashMap<>();
                    for (columnIndex = 0; columnIndex < cells; columnIndex++) {

                        //셀값을 읽는다.
                        XSSFCell cell = row.getCell(columnIndex);
                        String value = "";
                        if (cell == null) {
                            continue;
                        } else {
                            //타입별로 내용 읽기
                            if (cell.getCellTypeEnum() == CellType.FORMULA) {
                                value = cell.getCellFormula() + "";
                            } else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
                                value = cell.getNumericCellValue() + "";
                            } else if (cell.getCellTypeEnum() == CellType.STRING) {
                                value = cell.getStringCellValue() + "";
                            } else if (cell.getCellTypeEnum() == CellType.BLANK) {
                                value = cell.getBooleanCellValue() + "";
                            } else if (cell.getCellTypeEnum() == CellType.ERROR) {
                                value = cell.getErrorCellString() + "";
                            }
                        }
                        //System.out.println(rowIndex + "번 행 : " + columnIndex + "번 열 값은 : " + value);
                        if (keyFlag) {//초기 해더 세팅
                            key[columnIndex] = value;
                        }

                        if (key.length > 0) { //해더가 아닌경우 멥에 저장
                            data.put(key[columnIndex], value);
                        }
                    }
                    result.add(data);//해더가 아닌경우 멥에 저장
                }
            }

            int[] intResult = getRandomInt(3, result, key);
            System.out.println(Arrays.toString(intResult));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    private static int[] getRandomInt(int size, List<HashMap<String, String>> list, String[] key) {
        int[] randomInt = new int[size];
        if (list.size() > 0) {
            for (int i = 0; i < randomInt.length; i++) {
                int index = (int) (Math.random() * list.size());
                randomInt[i] = Integer.valueOf(list.get(index).get(key[0]));
                for (int j = 0; j < i; j++) {
                    if (randomInt[i] == randomInt[j]) {
                        i--;
                        break;
                    }
                }
            }
        }
        return randomInt;
    }
}
