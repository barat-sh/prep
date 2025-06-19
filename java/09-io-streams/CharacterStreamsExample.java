import java.io.*;

/**
 * This class demonstrates the use of character streams in Java
 */
public class CharacterStreamsExample {
    public static void main(String[] args) {
        System.out.println("=== Character Streams in Java ===\n");
        
        // Create a temporary directory for our examples
        File tempDir = createTempDirectory();
        if (tempDir == null) {
            System.out.println("Could not create temporary directory. Exiting.");
            return;
        }
        
        // 1. FileReader and FileWriter
        System.out.println("1. FileReader and FileWriter:");
        File textFile1 = new File(tempDir, "text1.txt");
        
        // Writing text to a file
        try (FileWriter writer = new FileWriter(textFile1)) {
            writer.write("Hello, World!\n");
            writer.write("This is an example of FileWriter.\n");
            writer.write("It writes text to a file character by character.");
            System.out.println("Wrote text to " + textFile1.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        
        // Reading text from a file
        try (FileReader reader = new FileReader(textFile1)) {
            int character;
            System.out.println("\nReading text from file (character by character):");
            
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        
        // 2. BufferedReader and BufferedWriter
        System.out.println("\n\n2. BufferedReader and BufferedWriter:");
        File textFile2 = new File(tempDir, "text2.txt");
        
        // Writing text with buffering
        try (FileWriter writer = new FileWriter(textFile2);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            
            bufferedWriter.write("Line 1: BufferedWriter example");
            bufferedWriter.newLine(); // Add a platform-independent line separator
            bufferedWriter.write("Line 2: It provides buffering for efficient writing");
            bufferedWriter.newLine();
            bufferedWriter.write("Line 3: And convenient methods like newLine()");
            
            System.out.println("Wrote text to " + textFile2.getAbsolutePath() + " with buffering");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        
        // Reading text with buffering
        try (FileReader reader = new FileReader(textFile2);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            
            String line;
            System.out.println("\nReading text from file (line by line):");
            
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        
        // 3. Reading and writing with character arrays
        System.out.println("\n3. Reading and writing with character arrays:");
        File textFile3 = new File(tempDir, "text3.txt");
        
        // Writing a character array
        try (FileWriter writer = new FileWriter(textFile3)) {
            char[] charArray = {'J', 'a', 'v', 'a', ' ', 'i', 's', ' ', 'f', 'u', 'n', '!'};
            writer.write(charArray);
            writer.write("\nWriting a char array is easy.");
            
            System.out.println("Wrote character array to " + textFile3.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error writing character array: " + e.getMessage());
        }
        
        // Reading into a character array
        try (FileReader reader = new FileReader(textFile3)) {
            // Create a buffer for reading
            char[] buffer = new char[100];
            int charsRead = reader.read(buffer);
            
            System.out.println("\nRead " + charsRead + " characters into array");
            System.out.println("Content: " + new String(buffer, 0, charsRead));
        } catch (IOException e) {
            System.out.println("Error reading into character array: " + e.getMessage());
        }
        
        // 4. InputStreamReader and OutputStreamWriter (bridge between byte and character streams)
        System.out.println("\n4. InputStreamReader and OutputStreamWriter:");
        File textFile4 = new File(tempDir, "text4.txt");
        
        // Writing text using OutputStreamWriter with specific encoding
        try (FileOutputStream fos = new FileOutputStream(textFile4);
             OutputStreamWriter writer = new OutputStreamWriter(fos, "UTF-8")) {
            
            writer.write("This text is written using OutputStreamWriter with UTF-8 encoding.\n");
            writer.write("It can handle special characters like: ÄÖÜäöüñ€");
            
            System.out.println("Wrote text to " + textFile4.getAbsolutePath() + " using OutputStreamWriter");
        } catch (IOException e) {
            System.out.println("Error writing with OutputStreamWriter: " + e.getMessage());
        }
        
        // Reading text using InputStreamReader with specific encoding
        try (FileInputStream fis = new FileInputStream(textFile4);
             InputStreamReader reader = new InputStreamReader(fis, "UTF-8")) {
            
            char[] buffer = new char[100];
            int charsRead = reader.read(buffer);
            
            System.out.println("\nRead " + charsRead + " characters using InputStreamReader");
            System.out.println("Content: " + new String(buffer, 0, charsRead));
        } catch (IOException e) {
            System.out.println("Error reading with InputStreamReader: " + e.getMessage());
        }
        
        // 5. PrintWriter
        System.out.println("\n5. PrintWriter:");
        File textFile5 = new File(tempDir, "text5.txt");
        
        // Writing text using PrintWriter
        try (FileWriter writer = new FileWriter(textFile5);
             PrintWriter printWriter = new PrintWriter(writer)) {
            
            // PrintWriter provides convenient methods for formatted output
            printWriter.println("This is line 1");
            printWriter.println("This is line 2");
            
            printWriter.print("This text doesn't end with a newline");
            printWriter.print(" and this continues on the same line");
            printWriter.println();
            
            printWriter.printf("Formatted output: Name=%s, Age=%d, GPA=%.2f%n", "John", 25, 3.75);
            
            System.out.println("Wrote text to " + textFile5.getAbsolutePath() + " using PrintWriter");
        } catch (IOException e) {
            System.out.println("Error writing with PrintWriter: " + e.getMessage());
        }
        
        // Reading text from file written with PrintWriter
        try (FileReader reader = new FileReader(textFile5);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            
            String line;
            System.out.println("\nReading text from file written with PrintWriter:");
            
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        
        // 6. StringReader and StringWriter
        System.out.println("\n6. StringReader and StringWriter:");
        
        // Writing to a StringWriter
        try (StringWriter stringWriter = new StringWriter()) {
            stringWriter.write("This text is written to a StringWriter.\n");
            stringWriter.write("It stores the written data in an internal string buffer.");
            
            // Get the result as a string
            String result = stringWriter.toString();
            System.out.println("StringWriter content: " + result);
            
            // Reading from a StringReader
            try (StringReader stringReader = new StringReader(result)) {
                char[] buffer = new char[20];
                int charsRead;
                
                System.out.println("\nReading from StringReader in chunks:");
                while ((charsRead = stringReader.read(buffer)) != -1) {
                    System.out.print(new String(buffer, 0, charsRead));
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Error with StringReader/StringWriter: " + e.getMessage());
        }
        
        // 7. CharArrayReader and CharArrayWriter
        System.out.println("\n7. CharArrayReader and CharArrayWriter:");
        
        // Writing to a CharArrayWriter
        try (CharArrayWriter charArrayWriter = new CharArrayWriter()) {
            charArrayWriter.write("This text is written to a CharArrayWriter.\n");
            charArrayWriter.write("It stores the written data in an internal char array.");
            
            // Get the result as a char array
            char[] charArray = charArrayWriter.toCharArray();
            System.out.println("CharArrayWriter content as string: " + new String(charArray));
            
            // Get the result as a string
            String result = charArrayWriter.toString();
            System.out.println("CharArrayWriter toString(): " + result);
            
            // Reading from a CharArrayReader
            try (CharArrayReader charArrayReader = new CharArrayReader(charArray)) {
                int character;
                
                System.out.println("\nReading from CharArrayReader (first 20 characters):");
                for (int i = 0; i < 20 && (character = charArrayReader.read()) != -1; i++) {
                    System.out.print((char) character);
                }
                System.out.println("...");
            }
        } catch (IOException e) {
            System.out.println("Error with CharArrayReader/CharArrayWriter: " + e.getMessage());
        }
        
        // 8. Converting between byte streams and character streams
        System.out.println("\n8. Converting between byte streams and character streams:");
        File textFile6 = new File(tempDir, "text6.txt");
        
        // Writing bytes that represent characters
        try (FileOutputStream fos = new FileOutputStream(textFile6);
             OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
             BufferedWriter writer = new BufferedWriter(osw)) {
            
            writer.write("This is an example of converting between byte and character streams.\n");
            writer.write("OutputStreamWriter converts characters to bytes using the specified encoding.");
            
            System.out.println("Wrote text to " + textFile6.getAbsolutePath() + 
                               " using OutputStreamWriter with UTF-8 encoding");
        } catch (IOException e) {
            System.out.println("Error writing with conversion: " + e.getMessage());
        }
        
        // Reading bytes that represent characters
        try (FileInputStream fis = new FileInputStream(textFile6);
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
             BufferedReader reader = new BufferedReader(isr)) {
            
            String line;
            System.out.println("\nReading text using InputStreamReader with UTF-8 encoding:");
            
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading with conversion: " + e.getMessage());
        }
        
        // 9. Performance comparison
        System.out.println("\n9. Performance comparison:");
        File largeTextFile = new File(tempDir, "large_text.txt");
        
        // Create a large text file
        createLargeTextFile(largeTextFile, 100000); // 100,000 characters
        
        // Read character-by-character (slow)
        long startTime = System.currentTimeMillis();
        try (FileReader reader = new FileReader(largeTextFile)) {
            int totalChars = 0;
            while (reader.read() != -1) {
                totalChars++;
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Character-by-character read: " + totalChars + " characters in " + 
                               (endTime - startTime) + " ms");
        } catch (IOException e) {
            System.out.println("Error in character-by-character read: " + e.getMessage());
        }
        
        // Read using character buffer (faster)
        startTime = System.currentTimeMillis();
        try (FileReader reader = new FileReader(largeTextFile)) {
            char[] buffer = new char[4096]; // 4KB buffer
            int charsRead;
            int totalChars = 0;
            
            while ((charsRead = reader.read(buffer)) != -1) {
                totalChars += charsRead;
            }
            
            long endTime = System.currentTimeMillis();
            System.out.println("Buffered character read: " + totalChars + " characters in " + 
                               (endTime - startTime) + " ms");
        } catch (IOException e) {
            System.out.println("Error in buffered character read: " + e.getMessage());
        }
        
        // Read using BufferedReader (even faster)
        startTime = System.currentTimeMillis();
        try (FileReader reader = new FileReader(largeTextFile);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            
            char[] buffer = new char[4096]; // 4KB buffer
            int charsRead;
            int totalChars = 0;
            
            while ((charsRead = bufferedReader.read(buffer)) != -1) {
                totalChars += charsRead;
            }
            
            long endTime = System.currentTimeMillis();
            System.out.println("BufferedReader read: " + totalChars + " characters in " + 
                               (endTime - startTime) + " ms");
        } catch (IOException e) {
            System.out.println("Error in BufferedReader read: " + e.getMessage());
        }
        
        // Clean up temporary files
        cleanupTempFiles(tempDir);
    }
    
    /**
     * Creates a temporary directory for the examples
     */
    private static File createTempDirectory() {
        try {
            File tempDir = new File(System.getProperty("java.io.tmpdir"), "charstreams_example_" + System.currentTimeMillis());
            if (tempDir.mkdir()) {
                System.out.println("Created temporary directory: " + tempDir.getAbsolutePath());
                return tempDir;
            } else {
                System.out.println("Failed to create temporary directory");
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error creating temporary directory: " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Creates a large text file with random text
     */
    private static void createLargeTextFile(File file, int numChars) {
        try (FileWriter writer = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            
            // Sample text to repeat
            String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                               "Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                               "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris " +
                               "nisi ut aliquip ex ea commodo consequat. ";
            
            int charsWritten = 0;
            while (charsWritten < numChars) {
                bufferedWriter.write(loremIpsum);
                charsWritten += loremIpsum.length();
            }
            
            System.out.println("Created file: " + file.getAbsolutePath() + " (approximately " + 
                               numChars + " characters)");
        } catch (IOException e) {
            System.out.println("Error creating large text file: " + e.getMessage());
        }
    }
    
    /**
     * Recursively deletes a directory and all its contents
     */
    private static void cleanupTempFiles(File directory) {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        cleanupTempFiles(file);
                    } else {
                        file.delete();
                    }
                }
            }
        }
        
        if (directory.delete()) {
            System.out.println("\nCleaned up temporary directory: " + directory.getAbsolutePath());
        } else {
            System.out.println("\nFailed to delete temporary directory: " + directory.getAbsolutePath());
        }
    }
}