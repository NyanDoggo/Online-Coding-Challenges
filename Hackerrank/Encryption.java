https://www.hackerrank.com/challenges/encryption/problem



import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the encryption function below.
         public static String stringPadding(String string, int paddingCount, String toPad) {
        String result = string;
        for (int i = 0; i < paddingCount; i++) {
            result += toPad;
        }
        return result;
    }
    
    public static ArrayList<String> parseString(String string, int rowLength, int colLength) {
        ArrayList<String> resultArray = new ArrayList<String>();
        int paddingCount = colLength - (string.length() % colLength);
        string = stringPadding(string, paddingCount, " ");
        for (int i = 0; i < rowLength * colLength; i+= colLength) {
            String temp = string.substring(i, i + colLength);
            System.out.println(temp);
            resultArray.add(temp);
        }
        return resultArray;
    }
        
    public static ArrayList<String> transposeString(ArrayList<String> parsedString, int colLength){
        ArrayList<String> resultArray = new ArrayList<String>();
        String resultString = "", tmp = "";
        for (int i = 0; i < colLength; i++) {
            for (int j = 0; j < parsedString.size(); j++) {
                tmp = parsedString.get(j);
                resultString += tmp.charAt(i);        
            }
            resultString = resultString.replace(" ", "");
            resultArray.add(resultString);
            resultString = "";
        }    
        return resultArray;
    }
    
    
    public static String ArrayListToString(ArrayList<String> arrayList) {
        String result = "";
        for (int i = 0; i < arrayList.size(); i++) {
            result += arrayList.get(i) + " "; //remove " " if necessary 
        }
        return result;
    }
    
    public static String encryption(String s) {
        int length = s.length();
        double squaredLength = Math.sqrt(length);
        int rows = (int)Math.floor(squaredLength);
        int col = (int)Math.ceil(squaredLength);
        if (rows * col < length) {
            rows += 1;
        }
        System.out.println(rows);
        System.out.println(col);
        ArrayList<String> parsedString = parseString(s, rows, col);
        ArrayList<String> ciphertext = transposeString(parsedString, col);
        return ArrayListToString(ciphertext);
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
