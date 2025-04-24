package edu.canisius.csc213.complaints.storage;

import com.fasterxml.jackson.databind.ObjectMapper;

//import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.*;
import java.util.*;

public class EmbeddingLoader {
    Map<Long, double[]> embeddingsByID = new HashMap<>();
    /**
     * Loads complaint embeddings from a JSONL (newline-delimited JSON) file.
     * Each line must be a JSON object with:
     * {
     *   "complaintId": <long>,
     *   "embedding": [<double>, <double>, ...]
     * }
     *
     * @param jsonlStream InputStream to the JSONL file
     * @return A map from complaint ID to its embedding vector
     * @throws IOException if the file cannot be read or parsed
     */
    public static Map<Long, double[]> loadEmbeddings(InputStream jsonlStream) throws IOException {
        Map<Long, double[]> embeddingsByID = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(jsonlStream));

        String line;
        while ((line = reader.readLine()) != null){
            ParsedEntry entry = objectMapper.readValue(line, ParsedEntry.class);
            embeddingsByID.put(entry.id, entry.embedding);
        }

        return embeddingsByID;
    }
    
    static class ParsedEntry{
        public Long id;
        public double[] embedding;
    }

    public static void main(String[] args) {
        // InputStream jsonlStream = EmbeddingLoader.class.getResourceAsStream("/home/russel54@cyber.canisius.edu/Desktop/CSC213.SP25.Project2/src/main/resources/embeddings_sample_1_30.jsonl");
        InputStream jsonlStream = EmbeddingLoader.class.getResourceAsStream("/embeddings_test_1_30.jsonl");
        try {
            Map<Long, double[]> embeddings = EmbeddingLoader.loadEmbeddings(jsonlStream);
        } 
        catch (IOException e) {
        }
    }
}
