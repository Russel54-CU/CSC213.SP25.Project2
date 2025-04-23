package edu.canisius.csc213.complaints.storage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

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
        // TODO: Implement parsing of JSONL to extract complaintId and embedding
        Map<Long, double[]> embeddingsByID = new HashMap<>();

        Scanner scnr = new Scanner(jsonlStream);
        ArrayList<String> keys = new ArrayList<>();
        while(scnr.hasNextLine()){
            key.add(scnr.nextLine());
        }

        for(String s : lines){
            System.out.println(s);
        }

        return embeddingsByID;
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
