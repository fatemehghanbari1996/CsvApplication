package models;

import com.qanbari.entities.CsvData;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {

    public List<CsvData> parseCsv(MultipartFile file) throws IOException {
        List<CsvData> csvDataList = new ArrayList<>();

        // Create a BufferedReader to read the CSV file
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            // Skip the first line (header)
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                CsvData csvData = new CsvData();
                csvData.setCode(fields[0]);
                csvData.setCodeListCode(fields[1]);
                csvDataList.add(csvData);
                csvData.setFromDate();


            }
        }

        return csvDataList;
    }
}
