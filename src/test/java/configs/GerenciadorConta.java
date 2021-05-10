package configs;

import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class GerenciadorConta {
    public List<Conta> criar() throws IOException {
        //Recuperando o arquivo
        FileInputStream file = new FileInputStream("MassaDeDados.xlsx");
        Workbook workbook = new HSSFWorkbook(file);
        //Setando a aba
        Sheet sheet = workbook.getSheetAt(0);
        //Setando as linhas
        List<Row> rows = (List<Row>) toList(sheet.iterator());
        Conta conta = new Conta();

        rows.remove(0);

        rows.forEach(row->{
            //Setando as celulas
            List<Cell> cells = (List<Cell>) toList(row.cellIterator());
            conta.setNome(cells.get(0).getStringCellValue());
            conta.setEmail(cells.get(1).getStringCellValue());
            conta.setSenha(cells.get(2).getStringCellValue());
            conta.setEndereco(cells.get(3).getStringCellValue());
            conta.setEstado(cells.get(4).getStringCellValue());
            conta.setCidade(cells.get(5).getStringCellValue());
            conta.setCep((long) cells.get(6).getNumericCellValue());
            conta.setData(cells.get(7).getDateCellValue());
            conta.setTelefone((long) cells.get(8).getNumericCellValue());
        });

        file.close();
        return null;
    }

    public List<?> toList(Iterator<?> iterator){
        return IteratorUtils.toList(iterator);
    }
}
