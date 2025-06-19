import java.io.*;

/**
 * This class demonstrates the use of byte streams in Java
 */
public class ByteStreamsExample {
    public static void main(String[] args) {
        System.out.println("=== Byte Streams in Java ===\n");
        
        // Create a temporary directory for our examples
        File tempDir = createTempDirectory();
        if (tempDir == null) {
            System.out.println("Could not create temporary directory. Exiting.");
            return;
        }
        
        // 1. FileInputStream and FileOutputStream
        System.out.println("1. FileInputStream and FileOutputStream:");
        File file1 = new File(tempDir, "file1.dat");
        
        // Writing bytes to a file
        try (FileOutputStream fos = new FileOutputStream(file1)) {
            byte[] data = {65, 66, 67, 68, 69, 70}; // ASCII for ABCDEF
            fos.write(data);
            System.out.println("Wrote " + data.length + " bytes to " + file1.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        
        // Reading bytes from a file
        try (FileInputStream fis = new FileInputStream(file1)) {
            int byteData;
            System.out.print("Read from file: ");
            while ((byteData = fis.read()) != -1) {
                System.out.print((char) byteData + " ");
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        
        // 2. BufferedInputStream and BufferedOutputStream
        System.out.println("\n2. BufferedInputStream and BufferedOutputStream:");
        File file2 = new File(tempDir, "file2.dat");
        
        // Writing bytes with buffering
        try (FileOutputStream fos = new FileOutputStream(file2);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            
            byte[] data = new byte[1000];
            for (int i = 0; i < data.length; i++) {
                data[i] = (byte)(i % 256);
            }
            
            bos.write(data);
            System.out.println("Wrote " + data.length + " bytes to " + file2.getAbsolutePath() + " with buffering");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        
        // Reading bytes with buffering
        try (FileInputStream fis = new FileInputStream(file2);
             BufferedInputStream bis = new BufferedInputStream(fis)) {
            
            byte[] buffer = new byte[100];
            int bytesRead;
            int totalBytesRead = 0;
            
            System.out.println("Reading with buffering (showing first few bytes):");
            bytesRead = bis.read(buffer);
            if (bytesRead != -1) {
                System.out.print("First " + bytesRead + " bytes: ");
                for (int i = 0; i < Math.min(10, bytesRead); i++) {
                    System.out.print(buffer[i] + " ");
                }
                System.out.println("...");
                totalBytesRead += bytesRead;
            }
            
            // Read the rest of the file
            while ((bytesRead = bis.read(buffer)) != -1) {
                totalBytesRead += bytesRead;
            }
            
            System.out.println("Total bytes read: " + totalBytesRead);
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        
        // 3. DataInputStream and DataOutputStream
        System.out.println("\n3. DataInputStream and DataOutputStream:");
        File file3 = new File(tempDir, "file3.dat");
        
        // Writing primitive data types
        try (FileOutputStream fos = new FileOutputStream(file3);
             DataOutputStream dos = new DataOutputStream(fos)) {
            
            dos.writeInt(42);
            dos.writeDouble(3.14159);
            dos.writeBoolean(true);
            dos.writeUTF("Hello, World!");
            
            System.out.println("Wrote primitive data types to " + file3.getAbsolutePath());
            System.out.println("File size: " + file3.length() + " bytes");
        } catch (IOException e) {
            System.out.println("Error writing primitive data: " + e.getMessage());
        }
        
        // Reading primitive data types
        try (FileInputStream fis = new FileInputStream(file3);
             DataInputStream dis = new DataInputStream(fis)) {
            
            int intValue = dis.readInt();
            double doubleValue = dis.readDouble();
            boolean booleanValue = dis.readBoolean();
            String stringValue = dis.readUTF();
            
            System.out.println("Read primitive data types:");
            System.out.println("Int: " + intValue);
            System.out.println("Double: " + doubleValue);
            System.out.println("Boolean: " + booleanValue);
            System.out.println("String: " + stringValue);
        } catch (IOException e) {
            System.out.println("Error reading primitive data: " + e.getMessage());
        }
        
        // 4. ByteArrayInputStream and ByteArrayOutputStream
        System.out.println("\n4. ByteArrayInputStream and ByteArrayOutputStream:");
        
        // Writing to a byte array
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            byte[] input = "ByteArrayOutputStream Example".getBytes();
            baos.write(input);
            
            // Get the resulting byte array
            byte[] bytes = baos.toByteArray();
            
            System.out.println("Wrote " + bytes.length + " bytes to byte array");
            System.out.print("First 10 bytes: ");
            for (int i = 0; i < Math.min(10, bytes.length); i++) {
                System.out.print(bytes[i] + " ");
            }
            System.out.println();
            
            // Convert to string
            String result = baos.toString();
            System.out.println("As string: " + result);
            
        } catch (IOException e) {
            System.out.println("Error writing to byte array: " + e.getMessage());
        } finally {
            try {
                baos.close();
            } catch (IOException e) {
                System.out.println("Error closing ByteArrayOutputStream: " + e.getMessage());
            }
        }
        
        // Reading from a byte array
        byte[] data = "ByteArrayInputStream Example".getBytes();
        try (ByteArrayInputStream bais = new ByteArrayInputStream(data)) {
            
            System.out.println("\nReading from byte array:");
            int byteData;
            while ((byteData = bais.read()) != -1) {
                System.out.print((char) byteData);
            }
            System.out.println();
            
        } catch (IOException e) {
            System.out.println("Error reading from byte array: " + e.getMessage());
        }
        
        // 5. Using read() and write() with byte arrays
        System.out.println("\n5. Reading and writing byte arrays:");
        File file4 = new File(tempDir, "file4.dat");
        
        // Writing an array of bytes
        try (FileOutputStream fos = new FileOutputStream(file4)) {
            byte[] dataToWrite = "This is a test of writing byte arrays.".getBytes();
            fos.write(dataToWrite);
            System.out.println("Wrote " + dataToWrite.length + " bytes to " + file4.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error writing byte array: " + e.getMessage());
        }
        
        // Reading into a byte array
        try (FileInputStream fis = new FileInputStream(file4)) {
            // Create a buffer with the file size
            byte[] buffer = new byte[(int) file4.length()];
            
            // Read all bytes into the buffer
            int bytesRead = fis.read(buffer);
            
            System.out.println("Read " + bytesRead + " bytes into buffer");
            System.out.println("Content: " + new String(buffer));
        } catch (IOException e) {
            System.out.println("Error reading into byte array: " + e.getMessage());
        }
        
        // 6. Copying files using byte streams
        System.out.println("\n6. Copying files using byte streams:");
        File sourceFile = file4;
        File targetFile = new File(tempDir, "file4_copy.dat");
        
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(targetFile)) {
            
            byte[] buffer = new byte[1024];
            int bytesRead;
            int totalBytesRead = 0;
            
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
                totalBytesRead += bytesRead;
            }
            
            System.out.println("Copied " + totalBytesRead + " bytes from " + sourceFile.getName() + 
                               " to " + targetFile.getName());
        } catch (IOException e) {
            System.out.println("Error copying file: " + e.getMessage());
        }
        
        // 7. Performance comparison
        System.out.println("\n7. Performance comparison:");
        
        // Create a large test file
        File largeFile = new File(tempDir, "large_file.dat");
        createLargeFile(largeFile, 1024 * 1024); // 1MB file
        
        // Read byte-by-byte (slow)
        long startTime = System.currentTimeMillis();
        try (FileInputStream fis = new FileInputStream(largeFile)) {
            int totalBytes = 0;
            while (fis.read() != -1) {
                totalBytes++;
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Byte-by-byte read: " + totalBytes + " bytes in " + 
                               (endTime - startTime) + " ms");
        } catch (IOException e) {
            System.out.println("Error in byte-by-byte read: " + e.getMessage());
        }
        
        // Read using buffer (faster)
        startTime = System.currentTimeMillis();
        try (FileInputStream fis = new FileInputStream(largeFile)) {
            byte[] buffer = new byte[8192]; // 8KB buffer
            int bytesRead;
            int totalBytes = 0;
            
            while ((bytesRead = fis.read(buffer)) != -1) {
                totalBytes += bytesRead;
            }
            
            long endTime = System.currentTimeMillis();
            System.out.println("Buffered read: " + totalBytes + " bytes in " + 
                               (endTime - startTime) + " ms");
        } catch (IOException e) {
            System.out.println("Error in buffered read: " + e.getMessage());
        }
        
        // Read using BufferedInputStream (even faster)
        startTime = System.currentTimeMillis();
        try (FileInputStream fis = new FileInputStream(largeFile);
             BufferedInputStream bis = new BufferedInputStream(fis)) {
            
            byte[] buffer = new byte[8192]; // 8KB buffer
            int bytesRead;
            int totalBytes = 0;
            
            while ((bytesRead = bis.read(buffer)) != -1) {
                totalBytes += bytesRead;
            }
            
            long endTime = System.currentTimeMillis();
            System.out.println("BufferedInputStream read: " + totalBytes + " bytes in " + 
                               (endTime - startTime) + " ms");
        } catch (IOException e) {
            System.out.println("Error in BufferedInputStream read: " + e.getMessage());
        }
        
        // Clean up temporary files
        cleanupTempFiles(tempDir);
    }
    
    /**
     * Creates a temporary directory for the examples
     */
    private static File createTempDirectory() {
        try {
            File tempDir = new File(System.getProperty("java.io.tmpdir"), "bytestreams_example_" + System.currentTimeMillis());
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
     * Creates a large test file with random data
     */
    private static void createLargeFile(File file, int sizeInBytes) {
        try (FileOutputStream fos = new FileOutputStream(file);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            
            byte[] buffer = new byte[8192]; // 8KB buffer
            int remainingBytes = sizeInBytes;
            
            // Fill the buffer with pseudo-random data
            for (int i = 0; i < buffer.length; i++) {
                buffer[i] = (byte)(i % 256);
            }
            
            // Write the buffer in chunks until we reach the desired size
            while (remainingBytes > 0) {
                int bytesToWrite = Math.min(buffer.length, remainingBytes);
                bos.write(buffer, 0, bytesToWrite);
                remainingBytes -= bytesToWrite;
            }
            
            System.out.println("Created file: " + file.getAbsolutePath() + " (" + sizeInBytes + " bytes)");
        } catch (IOException e) {
            System.out.println("Error creating large file: " + e.getMessage());
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