package com.isep.acme.services;

import com.isep.acme.model.Product;
import com.opencsv.CSVWriter;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCsvWriter {
    public void writeProductToCsv(Product product, String filePath) throws IOException {
        boolean fileExists = new File(filePath).exists();

        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath, true))) {

            // Se o arquivo não existe, escreva o cabeçalho
            if (!fileExists) {
                String[] header = {"SKU", "Designation", "Description"};
                csvWriter.writeNext(header);
            }

            // Escreva o produto no CSV
            String[] row = {product.getSku(), product.getDesignation(), product.getDescription()};
            csvWriter.writeNext(row);

            // Flush e feche o escritor
            csvWriter.flush();
        }
    }
}

