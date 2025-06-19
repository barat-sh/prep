import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.Date;

/**
 * This class demonstrates file and directory operations in Java
 */
public class FileOperationsExample {
    public static void main(String[] args) {
        System.out.println("=== File and Directory Operations in Java ===\n");
        
        // Create a temporary directory for our examples
        File tempDir = createTempDirectory();
        if (tempDir == null) {
            System.out.println("Could not create temporary directory. Exiting.");
            return;
        }
        
        // 1. File Class - Basic Operations
        System.out.println("1. File Class - Basic Operations:");
        
        // Creating a new file
        File newFile = new File(tempDir, "test.txt");
        try {
            boolean created = newFile.createNewFile();
            System.out.println("File created: " + created + " - " + newFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
        
        // Getting file information
        System.out.println("\nFile information:");
        System.out.println("Exists: " + newFile.exists());
        System.out.println("Is file: " + newFile.isFile());
        System.out.println("Is directory: " + newFile.isDirectory());
        System.out.println("Absolute path: " + newFile.getAbsolutePath());
        System.out.println("Name: " + newFile.getName());
        System.out.println("Parent: " + newFile.getParent());
        System.out.println("Path: " + newFile.getPath());
        System.out.println("Length: " + newFile.length() + " bytes");
        System.out.println("Last modified: " + new Date(newFile.lastModified()));
        System.out.println("Can read: " + newFile.canRead());
        System.out.println("Can write: " + newFile.canWrite());
        System.out.println("Can execute: " + newFile.canExecute());
        
        // Writing some data to the file
        try (FileWriter writer = new FileWriter(newFile)) {
            writer.write("This is a test file.\nCreated for file operations demonstration.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        
        // Check file size after writing
        System.out.println("\nFile size after writing: " + newFile.length() + " bytes");
        
        // Renaming a file
        File renamedFile = new File(tempDir, "renamed.txt");
        boolean renamed = newFile.renameTo(renamedFile);
        System.out.println("File renamed: " + renamed + " - New name: " + renamedFile.getName());
        
        // 2. Directory Operations
        System.out.println("\n2. Directory Operations:");
        
        // Creating a single directory
        File singleDir = new File(tempDir, "singleDir");
        boolean dirCreated = singleDir.mkdir();
        System.out.println("Single directory created: " + dirCreated + " - " + singleDir.getAbsolutePath());
        
        // Creating a directory tree
        File nestedDir = new File(tempDir, "parent/child/grandchild");
        boolean dirsCreated = nestedDir.mkdirs();
        System.out.println("Directory tree created: " + dirsCreated + " - " + nestedDir.getAbsolutePath());
        
        // Creating some files in the directories
        createTestFile(new File(singleDir, "file1.txt"), "File in single directory");
        createTestFile(new File(nestedDir, "file2.txt"), "File in nested directory");
        
        // Listing directory contents
        System.out.println("\nListing contents of the temporary directory:");
        File[] files = tempDir.listFiles();
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName() + " - " + (file.isDirectory() ? "Directory" : "File"));
            }
        }
        
        // Filtering files by extension
        System.out.println("\nListing only .txt files:");
        FilenameFilter txtFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        };
        
        File[] txtFiles = tempDir.listFiles(txtFilter);
        if (txtFiles != null) {
            for (File file : txtFiles) {
                System.out.println(file.getName());
            }
        }
        
        // 3. NIO.2 Path and Files (Java 7+)
        System.out.println("\n3. NIO.2 Path and Files (Java 7+):");
        
        // Creating a Path
        Path path = Paths.get(tempDir.getAbsolutePath(), "nio2_test.txt");
        System.out.println("Created path: " + path);
        
        // Creating a file using NIO.2
        try {
            Files.createFile(path);
            System.out.println("File created using Files.createFile()");
        } catch (FileAlreadyExistsException e) {
            System.out.println("File already exists");
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
        
        // Writing to a file using NIO.2
        try {
            Files.write(path, "This file was created and written using NIO.2".getBytes());
            System.out.println("Data written to file using Files.write()");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        
        // Reading from a file using NIO.2
        try {
            byte[] data = Files.readAllBytes(path);
            System.out.println("File content read using Files.readAllBytes(): " + new String(data));
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        
        // File attributes using NIO.2
        try {
            System.out.println("\nFile attributes using NIO.2:");
            
            // Basic file attributes
            BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.println("Creation time: " + attrs.creationTime());
            System.out.println("Last access time: " + attrs.lastAccessTime());
            System.out.println("Last modified time: " + attrs.lastModifiedTime());
            System.out.println("Is regular file: " + attrs.isRegularFile());
            System.out.println("Is directory: " + attrs.isDirectory());
            System.out.println("Is symbolic link: " + attrs.isSymbolicLink());
            System.out.println("Size: " + attrs.size() + " bytes");
            
            // Checking specific attributes
            System.out.println("\nChecking specific attributes:");
            System.out.println("Is hidden: " + Files.isHidden(path));
            System.out.println("Is readable: " + Files.isReadable(path));
            System.out.println("Is writable: " + Files.isWritable(path));
            System.out.println("Is executable: " + Files.isExecutable(path));
            
        } catch (IOException e) {
            System.out.println("Error reading file attributes: " + e.getMessage());
        }
        
        // Creating a directory using NIO.2
        Path nio2DirPath = Paths.get(tempDir.getAbsolutePath(), "nio2_directory");
        try {
            Files.createDirectory(nio2DirPath);
            System.out.println("\nDirectory created using Files.createDirectory(): " + nio2DirPath);
        } catch (IOException e) {
            System.out.println("Error creating directory: " + e.getMessage());
        }
        
        // Copying a file using NIO.2
        Path targetPath = Paths.get(nio2DirPath.toString(), "copied_file.txt");
        try {
            Files.copy(path, targetPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied using Files.copy(): " + targetPath);
        } catch (IOException e) {
            System.out.println("Error copying file: " + e.getMessage());
        }
        
        // Moving a file using NIO.2
        Path movedPath = Paths.get(nio2DirPath.toString(), "moved_file.txt");
        try {
            Files.move(targetPath, movedPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File moved using Files.move(): " + movedPath);
        } catch (IOException e) {
            System.out.println("Error moving file: " + e.getMessage());
        }
        
        // 4. File Walking and Directory Tree
        System.out.println("\n4. File Walking and Directory Tree:");
        
        // Creating a more complex directory structure for demonstration
        createDirectoryStructure(tempDir);
        
        // Walking the file tree
        System.out.println("\nWalking the file tree:");
        try {
            Files.walkFileTree(Paths.get(tempDir.getAbsolutePath()), new SimpleFileVisitor<Path>() {
                private int indent = 0;
                
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    printIndented(dir.getFileName() + "/", indent);
                    indent += 2;
                    return FileVisitResult.CONTINUE;
                }
                
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    printIndented(file.getFileName().toString(), indent);
                    return FileVisitResult.CONTINUE;
                }
                
                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    indent -= 2;
                    return FileVisitResult.CONTINUE;
                }
                
                private void printIndented(String text, int indent) {
                    for (int i = 0; i < indent; i++) {
                        System.out.print(" ");
                    }
                    System.out.println(text);
                }
            });
        } catch (IOException e) {
            System.out.println("Error walking file tree: " + e.getMessage());
        }
        
        // 5. Finding and Filtering Files
        System.out.println("\n5. Finding and Filtering Files:");
        
        // Finding all .txt files using DirectoryStream
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(
                Paths.get(tempDir.getAbsolutePath()), "*.txt")) {
            
            System.out.println("\nAll .txt files in the temporary directory:");
            for (Path entry : stream) {
                System.out.println(entry.getFileName());
            }
        } catch (IOException e) {
            System.out.println("Error listing .txt files: " + e.getMessage());
        }
        
        // Finding files with custom filter
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(
                Paths.get(tempDir.getAbsolutePath()), new DirectoryStream.Filter<Path>() {
                    @Override
                    public boolean accept(Path entry) throws IOException {
                        return Files.isRegularFile(entry) && 
                               Files.size(entry) > 20; // Files larger than 20 bytes
                    }
                })) {
            
            System.out.println("\nFiles larger than 20 bytes:");
            for (Path entry : stream) {
                System.out.println(entry.getFileName() + " - " + Files.size(entry) + " bytes");
            }
        } catch (IOException e) {
            System.out.println("Error filtering files: " + e.getMessage());
        }
        
        // 6. Temporary Files and Directories
        System.out.println("\n6. Temporary Files and Directories:");
        
        // Creating a temporary file
        try {
            Path tempFile = Files.createTempFile("prefix_", "_suffix.txt");
            System.out.println("Temporary file created: " + tempFile);
            
            // Write something to the file
            Files.write(tempFile, "This is a temporary file content".getBytes());
            
            // Delete the file when the JVM exits
            tempFile.toFile().deleteOnExit();
        } catch (IOException e) {
            System.out.println("Error creating temporary file: " + e.getMessage());
        }
        
        // Creating a temporary directory
        try {
            Path tempDirectory = Files.createTempDirectory("tempDir_");
            System.out.println("Temporary directory created: " + tempDirectory);
            
            // Delete the directory when the JVM exits
            tempDirectory.toFile().deleteOnExit();
        } catch (IOException e) {
            System.out.println("Error creating temporary directory: " + e.getMessage());
        }
        
        // 7. File Locks (demonstration only)
        System.out.println("\n7. File Locks (demonstration only):");
        
        Path lockFilePath = Paths.get(tempDir.getAbsolutePath(), "lock_file.txt");
        try {
            // Create a file for locking demonstration
            Files.write(lockFilePath, "File for lock demonstration".getBytes());
            
            // Open a channel for file locking
            try (FileChannel channel = FileChannel.open(lockFilePath, StandardOpenOption.WRITE)) {
                
                // Try to acquire an exclusive lock on the file
                FileLock lock = channel.tryLock();
                
                if (lock != null) {
                    try {
                        System.out.println("Exclusive lock acquired on: " + lockFilePath);
                        System.out.println("Lock is shared: " + lock.isShared());
                        
                        // Do some work with the locked file
                        System.out.println("Working with the locked file...");
                        Thread.sleep(1000); // Simulate work
                        
                    } finally {
                        // Release the lock
                        lock.release();
                        System.out.println("Lock released");
                    }
                } else {
                    System.out.println("Could not acquire lock (file is locked by another process)");
                }
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Error with file locking: " + e.getMessage());
        }
        
        // Clean up
        System.out.println("\nCleaning up...");
        cleanupTempFiles(tempDir);
    }
    
    /**
     * Creates a temporary directory for the examples
     */
    private static File createTempDirectory() {
        try {
            File tempDir = new File(System.getProperty("java.io.tmpdir"), 
                                    "fileops_example_" + System.currentTimeMillis());
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
     * Creates a test file with the specified content
     */
    private static void createTestFile(File file, String content) {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
        } catch (IOException e) {
            System.out.println("Error creating test file: " + e.getMessage());
        }
    }
    
    /**
     * Creates a more complex directory structure for demonstration
     */
    private static void createDirectoryStructure(File baseDir) {
        try {
            // Create directories
            File dir1 = new File(baseDir, "dir1");
            File dir2 = new File(baseDir, "dir2");
            File subdir1 = new File(dir1, "subdir1");
            File subdir2 = new File(dir2, "subdir2");
            
            dir1.mkdir();
            dir2.mkdir();
            subdir1.mkdir();
            subdir2.mkdir();
            
            // Create some files
            createTestFile(new File(dir1, "file1.txt"), "File 1 in dir1");
            createTestFile(new File(dir1, "file2.log"), "File 2 in dir1");
            createTestFile(new File(subdir1, "file3.txt"), "File 3 in subdir1");
            createTestFile(new File(dir2, "file4.txt"), "File 4 in dir2");
            createTestFile(new File(subdir2, "file5.log"), "File 5 in subdir2");
            createTestFile(new File(subdir2, "file6.txt"), "File 6 in subdir2");
            
            System.out.println("Created complex directory structure for demonstration");
        } catch (Exception e) {
            System.out.println("Error creating directory structure: " + e.getMessage());
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
            System.out.println("Cleaned up temporary directory: " + directory.getAbsolutePath());
        } else {
            System.out.println("Failed to delete temporary directory: " + directory.getAbsolutePath());
        }
    }
}