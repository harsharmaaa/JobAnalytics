package com.example.jobanalytic1.Util;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.example.jobanalytic1.entitiy.JobData;


public class CsvR {

    public static List<JobData> readJobsFromCSV(String filePath) throws IOException {
        List<JobData> jobs = new ArrayList<>();
        try (Reader
         reader = new FileReader(filePath);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader())) {

            for (CSVRecord record : csvParser) {
                JobData job = new JobData(
                    record.get("title"),
                    record.get("description"),
                    record.get("city"),
                    record.get("state"),
                    Integer.parseInt(record.get("population"))
                );
                jobs.add(job);
            }
        }
        return jobs;
    }
}
