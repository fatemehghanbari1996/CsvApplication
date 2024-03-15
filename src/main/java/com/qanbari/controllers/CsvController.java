package com.qanbari.controllers;

import com.qanbari.entities.CsvData;
import com.qanbari.repositories.CsvDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CsvController {
    @Autowired
    private CsvDataRepository csvDataRepository;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadCsvFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<>("Please select a file.", HttpStatus.BAD_REQUEST);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            boolean isFirstLine = true;
            List<CsvData> csvData = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // Skip the header line
                    continue;
                }

                String[] data = line.split(",");
                if (data.length >= 2) {
                    CsvData csvData1 = new CsvData();
                    csvData1.setCode(csvData1.getCode());
                    csvData1.setSource(csvData1.getSource());
                    csvData1.setCodeListCode(csvData1.getCodeListCode());
                    csvData1.setDisplayValue(csvData1.getDisplayValue());
                    csvData1.setFromDate(csvData1.getFromDate());
                    csvData1.setToDate(csvData1.getToDate());
                    csvData1.setLongDescription(csvData1.getLongDescription());
                    csvData1.setSortingPriority(csvData1.getSortingPriority());

                    csvData.add(csvData1);
                }
            }

            csvDataRepository.saveAll(csvData);
            return new ResponseEntity<>("File uploaded successfully.", HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to upload file: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/data")
    public List<CsvData> getAllData() {
        return csvDataRepository.findAll();
    }

    @GetMapping("/data/{code}")
    public ResponseEntity<CsvData> getDataByCode(@PathVariable String code) {
        Optional<CsvData> csvDataOptional = csvDataRepository.findByCode(code);
        return csvDataOptional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete")
    public void deleteAllData() {
        csvDataRepository.deleteAll();
    }
}
