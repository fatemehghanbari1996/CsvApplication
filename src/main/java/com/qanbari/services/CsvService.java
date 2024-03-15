package com.qanbari.services;

import com.qanbari.entities.CsvData;
import com.qanbari.repositories.CsvDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvService {

    @Autowired
    private CsvDataRepository csvDataRepository;

    public void processCsvFile(MultipartFile file) throws IOException {
        List<CsvData> dataList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // Skip the header line
                    continue;
                }

                String[] fields = line.split(","); // Assuming CSV fields are comma-separated

                if (fields.length >= 2) { // Assuming at least two fields: code and name
                    CsvData csvData = new CsvData();
                    csvData.setCode(fields[0]);
                    csvData.setSource(fields[1]);
                    csvData.setCodeListCode(fields[2]);
                    csvData.setDisplayValue(fields[3]);
                    csvData.setFromDate();
                    csvData.setToDate();
                    csvData.setLongDescription(csvData1.getLongDescription());
                    csvData.setSortingPriority();


                    // Map other fields as needed
                    dataList.add(csvData);
                }
            }
        }

        csvDataRepository.saveAll(dataList);
    }
}

