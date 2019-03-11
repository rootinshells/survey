package com.hellokoding.springboot.service;

import org.springframework.web.multipart.MultipartFile;
import com.hellokoding.springboot.repository.Error;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;
import java.util.*;
import java.util.regex.*;

public class CSV {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private static final String COMMA_DELIMITER = ",";
    private static final String FILE_FORMAT = "text/csv";
    private String fileName;
    private String originalFileName;
    private String fileType;
    private long fileSize;
    private Error error;
    int lineNumber = 1;
    MultipartFile fileCSV;
    HashMap<Integer, List<String>> lines;

    public CSV(MultipartFile fileCSV) {
        this.fileCSV = fileCSV;
        this.lines = new HashMap<Integer, List<String>>();
        this.fileName = fileCSV.getName();
        this.originalFileName = fileCSV.getOriginalFilename();
        this.fileType = fileCSV.getContentType();
        this.fileSize = fileCSV.getSize();
    }

    public boolean checkExtension () {
        if (this.fileType.trim().toLowerCase().equals(FILE_FORMAT)) {
            return true;
        } else
            return false;
    }

    public boolean checkFileSize () {
        return true;
    }

    public String parseCSV () throws IOException {
        if (this.checkExtension()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(this.fileCSV.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (!this.checkSpecialChar(line)) {
                    List<String> ll = new ArrayList<String>();
                    String[] values = line.split(COMMA_DELIMITER);
                    for (String val : values) {
                        ll.add(val);
                    }
                    this.lines.put(lineNumber, ll);
                    logger.info(Integer.toString(lineNumber));
                    logger.info(values[0]);
                    lineNumber++;

                } else {
                    error = Error.FILE_CONTAINS_SPECIAL_CHARS;
                    return error.toString();
                }

            }
        } else {
            error = Error.FILE_EXTENSION_ERROR;
            return error.toString();
        }

        return Integer.toString(Error.FILE_SUCCESSFULLY_PARSED.getCode());
    }

    public HashMap<Integer, List<String>> getParsed () {
        return this.lines;
    }

    public boolean checkSpecialChar (String s) {
        Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>{}\\[\\]~-]");
        Matcher match = special.matcher(s);
        boolean check = match.find();
        if (check)
            return true;
        return false;
    }
}
