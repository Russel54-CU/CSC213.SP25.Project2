package edu.canisius.csc213.complaints.storage;

import edu.canisius.csc213.complaints.model.Complaint;

import com.opencsv.bean.CsvToBeanBuilder;

import java.util.*;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ComplaintMerger {

    /**
     * Matches complaints to their corresponding embedding vectors by complaint ID.
     *
     * @param complaints List of complaints (from CSV)
     * @param embeddings Map from complaintId to embedding vector (from JSONL)
     */
    public static void mergeEmbeddings(List<Complaint> complaints, Map<Long, double[]> embeddings) {
        // TODO: For each complaint, match the ID to an embedding and set it
        
    }

    public static void main(String[] args) {
        // InputStream jsonlStream = EmbeddingLoader.class.getResourceAsStream("/home/russel54@cyber.canisius.edu/Desktop/CSC213.SP25.Project2/src/main/resources/embeddings_sample_1_30.jsonl");
        InputStream csvStream = Complaint.class.getResourceAsStream("/complaints_sample_1_30.csv");
        List<Complaint> complaints = new CsvToBeanBuilder<Complaint>(
                new InputStreamReader(csvStream, StandardCharsets.UTF_8)
        ).withType(Complaint.class).build().parse();
     
        //InputStream jsonlStream = EmbeddingLoader.class.getResourceAsStream("/embeddings_test_1_30.jsonl");
        //Map<Long, double[]> embeddings;
        //try {
        //    embeddings = EmbeddingLoader.loadEmbeddings(jsonlStream);
        //    mergeEmbeddings(complaints, embeddings);
        //} 
        //catch (IOException e) {
            // TODO Auto-generated catch block
        //    e.printStackTrace();
        //}

    }
}
