package com.app.CSV;



import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class CsvController {

    private static final String CSV_FILE_NAME = "append.csv";

    @PostMapping("/json-to-csv")
    public ResponseEntity<String> jsonToCsv(@RequestBody List<Map<String, Object>> data) throws IOException {
        File file = new File(CSV_FILE_NAME);
        try (FileWriter outputfile = new FileWriter(file,true);
             CSVPrinter printer = file.exists() ?
             new CSVPrinter(outputfile, CSVFormat.DEFAULT.withDelimiter(';').withSkipHeaderRecord(true)):
                new CSVPrinter(outputfile, CSVFormat.DEFAULT.withDelimiter(';').withHeader("question", "answer"))) {
            for (Map<String, Object> map : data) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    printer.printRecord(entry.getKey(), entry.getValue());
                }
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body("CSV file created successfully!");
    }

}
