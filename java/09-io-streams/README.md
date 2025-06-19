# Java I/O Streams

Java I/O (Input/Output) Streams provide a unified way to handle input and output operations on various sources and destinations, such as files, network connections, and memory. The Java I/O API is part of the `java.io` package.

## 1. Streams Overview

A stream is a sequence of data that flows from a source to a destination. In Java, streams are used to read from and write to various data sources and destinations.

### Types of Streams

1. **Byte Streams**: Handle I/O of binary data (8-bit bytes). Base classes: `InputStream` and `OutputStream`.
2. **Character Streams**: Handle I/O of character data (16-bit Unicode characters). Base classes: `Reader` and `Writer`.

### Stream Hierarchies

#### Byte Stream Classes:
- `InputStream` (abstract)
  - `FileInputStream`
  - `ByteArrayInputStream`
  - `BufferedInputStream`
  - `DataInputStream`
  - `ObjectInputStream`
  - Others...

- `OutputStream` (abstract)
  - `FileOutputStream`
  - `ByteArrayOutputStream`
  - `BufferedOutputStream`
  - `DataOutputStream`
  - `ObjectOutputStream`
  - Others...

#### Character Stream Classes:
- `Reader` (abstract)
  - `InputStreamReader`
    - `FileReader`
  - `BufferedReader`
  - `StringReader`
  - Others...

- `Writer` (abstract)
  - `OutputStreamWriter`
    - `FileWriter`
  - `BufferedWriter`
  - `StringWriter`
  - `PrintWriter`
  - Others...

## 2. Byte Streams

Byte streams are used for handling binary data (such as images, audio files, etc.).

### FileInputStream and FileOutputStream

```java
// Reading from a file using FileInputStream
try (FileInputStream fis = new FileInputStream("input.dat")) {
    int data;
    while ((data = fis.read()) != -1) {
        // Process each byte
        System.out.print(data + " ");
    }
} catch (IOException e) {
    e.printStackTrace();
}

// Writing to a file using FileOutputStream
try (FileOutputStream fos = new FileOutputStream("output.dat")) {
    byte[] data = {65, 66, 67, 68, 69}; // ASCII for ABCDE
    fos.write(data);
} catch (IOException e) {
    e.printStackTrace();
}
```

### BufferedInputStream and BufferedOutputStream

These provide buffering to improve performance.

```java
// Reading with buffering
try (FileInputStream fis = new FileInputStream("input.dat");
     BufferedInputStream bis = new BufferedInputStream(fis)) {
    
    int data;
    while ((data = bis.read()) != -1) {
        // Process each byte
        System.out.print(data + " ");
    }
} catch (IOException e) {
    e.printStackTrace();
}

// Writing with buffering
try (FileOutputStream fos = new FileOutputStream("output.dat");
     BufferedOutputStream bos = new BufferedOutputStream(fos)) {
    
    byte[] data = {65, 66, 67, 68, 69}; // ASCII for ABCDE
    bos.write(data);
} catch (IOException e) {
    e.printStackTrace();
}
```

### DataInputStream and DataOutputStream

These allow you to read and write primitive data types.

```java
// Writing primitive data types
try (FileOutputStream fos = new FileOutputStream("data.dat");
     DataOutputStream dos = new DataOutputStream(fos)) {
    
    dos.writeInt(42);
    dos.writeDouble(3.14159);
    dos.writeBoolean(true);
    dos.writeUTF("Hello, World!");
} catch (IOException e) {
    e.printStackTrace();
}

// Reading primitive data types
try (FileInputStream fis = new FileInputStream("data.dat");
     DataInputStream dis = new DataInputStream(fis)) {
    
    int intValue = dis.readInt();
    double doubleValue = dis.readDouble();
    boolean booleanValue = dis.readBoolean();
    String stringValue = dis.readUTF();
    
    System.out.println("Int: " + intValue);
    System.out.println("Double: " + doubleValue);
    System.out.println("Boolean: " + booleanValue);
    System.out.println("String: " + stringValue);
} catch (IOException e) {
    e.printStackTrace();
}
```

### ByteArrayInputStream and ByteArrayOutputStream

These allow you to read from and write to byte arrays.

```java
// Writing to a byte array
ByteArrayOutputStream baos = new ByteArrayOutputStream();
try {
    baos.write("Hello, World!".getBytes());
    byte[] bytes = baos.toByteArray();
    
    System.out.println("Bytes: " + Arrays.toString(bytes));
} catch (IOException e) {
    e.printStackTrace();
} finally {
    try {
        baos.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

// Reading from a byte array
byte[] data = "Hello, World!".getBytes();
try (ByteArrayInputStream bais = new ByteArrayInputStream(data)) {
    int byteData;
    while ((byteData = bais.read()) != -1) {
        System.out.print((char) byteData);
    }
} catch (IOException e) {
    e.printStackTrace();
}
```

## 3. Character Streams

Character streams are used for handling text data (Unicode characters).

### FileReader and FileWriter

```java
// Reading from a text file
try (FileReader fr = new FileReader("input.txt")) {
    int character;
    while ((character = fr.read()) != -1) {
        System.out.print((char) character);
    }
} catch (IOException e) {
    e.printStackTrace();
}

// Writing to a text file
try (FileWriter fw = new FileWriter("output.txt")) {
    fw.write("Hello, World!\nThis is a test.");
} catch (IOException e) {
    e.printStackTrace();
}
```

### BufferedReader and BufferedWriter

These provide buffering to improve performance and additional methods like `readLine()`.

```java
// Reading lines from a text file
try (FileReader fr = new FileReader("input.txt");
     BufferedReader br = new BufferedReader(fr)) {
    
    String line;
    while ((line = br.readLine()) != null) {
        System.out.println(line);
    }
} catch (IOException e) {
    e.printStackTrace();
}

// Writing lines to a text file
try (FileWriter fw = new FileWriter("output.txt");
     BufferedWriter bw = new BufferedWriter(fw)) {
    
    bw.write("Hello, World!");
    bw.newLine(); // Add a line separator
    bw.write("This is a test.");
} catch (IOException e) {
    e.printStackTrace();
}
```

### InputStreamReader and OutputStreamWriter

These bridge between byte streams and character streams.

```java
// Converting bytes to characters
try (FileInputStream fis = new FileInputStream("input.txt");
     InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
     BufferedReader br = new BufferedReader(isr)) {
    
    String line;
    while ((line = br.readLine()) != null) {
        System.out.println(line);
    }
} catch (IOException e) {
    e.printStackTrace();
}

// Converting characters to bytes
try (FileOutputStream fos = new FileOutputStream("output.txt");
     OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
     BufferedWriter bw = new BufferedWriter(osw)) {
    
    bw.write("Hello, World!");
    bw.newLine();
    bw.write("This is a test with UTF-8 encoding.");
} catch (IOException e) {
    e.printStackTrace();
}
```

### StringReader and StringWriter

These allow you to read from and write to strings.

```java
// Reading from a string
String input = "Hello, World!\nThis is a test.";
try (StringReader sr = new StringReader(input);
     BufferedReader br = new BufferedReader(sr)) {
    
    String line;
    while ((line = br.readLine()) != null) {
        System.out.println(line);
    }
} catch (IOException e) {
    e.printStackTrace();
}

// Writing to a string
try (StringWriter sw = new StringWriter();
     PrintWriter pw = new PrintWriter(sw)) {
    
    pw.println("Hello, World!");
    pw.println("This is a test.");
    
    String result = sw.toString();
    System.out.println(result);
} catch (IOException e) {
    e.printStackTrace();
}
```

### PrintWriter

Provides convenient methods for writing formatted text.

```java
try (FileWriter fw = new FileWriter("output.txt");
     PrintWriter pw = new PrintWriter(fw)) {
    
    pw.println("Hello, World!");
    pw.printf("Name: %s, Age: %d%n", "John", 25);
    pw.println("This is a test.");
} catch (IOException e) {
    e.printStackTrace();
}
```

## 4. Object Serialization

Serialization is the process of converting an object into a byte stream, which can be stored in a file or transmitted over a network. Deserialization is the reverse process.

### Serializing Objects

```java
// A serializable class
class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}

// Serializing an object
try (FileOutputStream fos = new FileOutputStream("person.ser");
     ObjectOutputStream oos = new ObjectOutputStream(fos)) {
    
    Person person = new Person("John", 25);
    oos.writeObject(person);
    System.out.println("Object serialized successfully.");
} catch (IOException e) {
    e.printStackTrace();
}

// Deserializing an object
try (FileInputStream fis = new FileInputStream("person.ser");
     ObjectInputStream ois = new ObjectInputStream(fis)) {
    
    Person person = (Person) ois.readObject();
    System.out.println("Deserialized object: " + person);
} catch (IOException | ClassNotFoundException e) {
    e.printStackTrace();
}
```

### Serialization Notes

1. Classes must implement the `Serializable` interface.
2. Fields marked as `transient` will not be serialized.
3. Static fields are not serialized.
4. It's recommended to define a `serialVersionUID` to maintain compatibility between different versions of the class.

## 5. File and Directory Operations

The `File` class in Java provides methods for working with files and directories.

### Creating and Manipulating Files

```java
// Creating a file
File file = new File("test.txt");
try {
    boolean created = file.createNewFile();
    System.out.println("File created: " + created);
} catch (IOException e) {
    e.printStackTrace();
}

// Checking file properties
System.out.println("File exists: " + file.exists());
System.out.println("Is directory: " + file.isDirectory());
System.out.println("Is file: " + file.isFile());
System.out.println("File size: " + file.length() + " bytes");
System.out.println("Can read: " + file.canRead());
System.out.println("Can write: " + file.canWrite());
System.out.println("Absolute path: " + file.getAbsolutePath());

// Renaming a file
File newFile = new File("renamed.txt");
boolean renamed = file.renameTo(newFile);
System.out.println("File renamed: " + renamed);

// Deleting a file
boolean deleted = newFile.delete();
System.out.println("File deleted: " + deleted);
```

### Working with Directories

```java
// Creating a directory
File dir = new File("mydir");
boolean dirCreated = dir.mkdir();
System.out.println("Directory created: " + dirCreated);

// Creating a directory path
File deepDir = new File("parent/child/grandchild");
boolean deepDirCreated = deepDir.mkdirs();
System.out.println("Directory path created: " + deepDirCreated);

// Listing files in a directory
File currentDir = new File(".");
File[] files = currentDir.listFiles();
System.out.println("Files in current directory:");
for (File f : files) {
    System.out.println(f.getName() + " - " + (f.isDirectory() ? "Directory" : "File"));
}

// Filtering files
File[] txtFiles = currentDir.listFiles(new FilenameFilter() {
    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(".txt");
    }
});
System.out.println("Text files in current directory:");
for (File f : txtFiles) {
    System.out.println(f.getName());
}
```

## 6. NIO.2 (Java 7+)

Java 7 introduced a new file I/O API called NIO.2 in the `java.nio.file` package, which provides more powerful and flexible file operations.

### Path Interface

```java
// Creating a Path
Path path = Paths.get("test.txt");
Path absolutePath = path.toAbsolutePath();
Path normalizedPath = path.normalize();

System.out.println("Path: " + path);
System.out.println("Absolute path: " + absolutePath);
System.out.println("Normalized path: " + normalizedPath);

// Path information
System.out.println("File name: " + path.getFileName());
System.out.println("Parent: " + path.getParent());
System.out.println("Root: " + path.getRoot());
System.out.println("Number of elements: " + path.getNameCount());
```

### Files Class

```java
// Creating a file
Path filePath = Paths.get("nio2test.txt");
try {
    Files.createFile(filePath);
    System.out.println("File created: " + filePath);
} catch (IOException e) {
    e.printStackTrace();
}

// Writing to a file
List<String> lines = Arrays.asList("Hello, World!", "This is NIO.2", "Testing...");
try {
    Files.write(filePath, lines, StandardCharsets.UTF_8);
    System.out.println("Data written to file");
} catch (IOException e) {
    e.printStackTrace();
}

// Reading from a file
try {
    List<String> readLines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
    System.out.println("File contents:");
    for (String line : readLines) {
        System.out.println(line);
    }
} catch (IOException e) {
    e.printStackTrace();
}

// Copying a file
Path targetPath = Paths.get("nio2copy.txt");
try {
    Files.copy(filePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
    System.out.println("File copied to: " + targetPath);
} catch (IOException e) {
    e.printStackTrace();
}

// Moving/renaming a file
Path movedPath = Paths.get("nio2moved.txt");
try {
    Files.move(targetPath, movedPath, StandardCopyOption.REPLACE_EXISTING);
    System.out.println("File moved/renamed to: " + movedPath);
} catch (IOException e) {
    e.printStackTrace();
}

// Deleting a file
try {
    Files.delete(filePath);
    System.out.println("File deleted: " + filePath);
} catch (IOException e) {
    e.printStackTrace();
}
```

### Directory Operations with NIO.2

```java
// Creating a directory
Path dirPath = Paths.get("nio2dir");
try {
    Files.createDirectory(dirPath);
    System.out.println("Directory created: " + dirPath);
} catch (IOException e) {
    e.printStackTrace();
}

// Creating a directory tree
Path deepDirPath = Paths.get("nio2parent/child/grandchild");
try {
    Files.createDirectories(deepDirPath);
    System.out.println("Directory tree created: " + deepDirPath);
} catch (IOException e) {
    e.printStackTrace();
}

// Listing directory contents
try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("."))) {
    System.out.println("Contents of current directory:");
    for (Path entry : stream) {
        System.out.println(entry.getFileName());
    }
} catch (IOException e) {
    e.printStackTrace();
}

// Listing directory contents with a filter
try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("."), "*.txt")) {
    System.out.println("Text files in current directory:");
    for (Path entry : stream) {
        System.out.println(entry.getFileName());
    }
} catch (IOException e) {
    e.printStackTrace();
}
```

### File Attributes with NIO.2

```java
Path filePath = Paths.get("test.txt");
try {
    // Basic file attributes
    BasicFileAttributes attrs = Files.readAttributes(filePath, BasicFileAttributes.class);
    System.out.println("Creation time: " + attrs.creationTime());
    System.out.println("Last access time: " + attrs.lastAccessTime());
    System.out.println("Last modified time: " + attrs.lastModifiedTime());
    System.out.println("Is directory: " + attrs.isDirectory());
    System.out.println("Is regular file: " + attrs.isRegularFile());
    System.out.println("Is symbolic link: " + attrs.isSymbolicLink());
    System.out.println("Size: " + attrs.size() + " bytes");
    
    // Setting file attributes
    Files.setAttribute(filePath, "lastModifiedTime", FileTime.fromMillis(System.currentTimeMillis()));
    
    // DOS file attributes (Windows)
    try {
        DosFileAttributes dosAttrs = Files.readAttributes(filePath, DosFileAttributes.class);
        System.out.println("Is archive: " + dosAttrs.isArchive());
        System.out.println("Is hidden: " + dosAttrs.isHidden());
        System.out.println("Is readonly: " + dosAttrs.isReadOnly());
        System.out.println("Is system: " + dosAttrs.isSystem());
    } catch (UnsupportedOperationException e) {
        System.out.println("DOS attributes not supported on this system");
    }
    
    // POSIX file attributes (Unix/Linux)
    try {
        PosixFileAttributes posixAttrs = Files.readAttributes(filePath, PosixFileAttributes.class);
        System.out.println("Owner: " + posixAttrs.owner());
        System.out.println("Group: " + posixAttrs.group());
        System.out.println("Permissions: " + posixAttrs.permissions());
    } catch (UnsupportedOperationException e) {
        System.out.println("POSIX attributes not supported on this system");
    }
} catch (IOException e) {
    e.printStackTrace();
}
```

### Walking a File Tree with NIO.2

```java
Path startPath = Paths.get(".");
try {
    Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            System.out.println("File: " + file);
            return FileVisitResult.CONTINUE;
        }
        
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            System.out.println("Directory: " + dir);
            return FileVisitResult.CONTINUE;
        }
        
        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            System.err.println("Failed to visit file: " + file + " - " + exc);
            return FileVisitResult.CONTINUE;
        }
    });
} catch (IOException e) {
    e.printStackTrace();
}
```

## 7. Scanner Class

The `Scanner` class is a useful utility for parsing input.

```java
// Reading from console
Scanner scanner = new Scanner(System.in);
System.out.print("Enter your name: ");
String name = scanner.nextLine();
System.out.print("Enter your age: ");
int age = scanner.nextInt();
System.out.println("Hello, " + name + "! You are " + age + " years old.");

// Reading from a file
try (Scanner fileScanner = new Scanner(new File("data.txt"))) {
    while (fileScanner.hasNextLine()) {
        String line = fileScanner.nextLine();
        System.out.println(line);
    }
} catch (FileNotFoundException e) {
    e.printStackTrace();
}

// Parsing tokens
String data = "John 25 3.14";
Scanner dataScanner = new Scanner(data);
String parsedName = dataScanner.next();
int parsedAge = dataScanner.nextInt();
double parsedValue = dataScanner.nextDouble();
System.out.println("Name: " + parsedName);
System.out.println("Age: " + parsedAge);
System.out.println("Value: " + parsedValue);
dataScanner.close();

// Using delimiters
String csvData = "apple,banana,orange";
Scanner csvScanner = new Scanner(csvData);
csvScanner.useDelimiter(",");
while (csvScanner.hasNext()) {
    System.out.println("Fruit: " + csvScanner.next());
}
csvScanner.close();
```

## 8. Console Class (Java 6+)

The `Console` class provides methods for reading from and writing to the console.

```java
Console console = System.console();
if (console != null) {
    // Reading a line
    String name = console.readLine("Enter your name: ");
    
    // Reading a password (characters are not echoed)
    char[] passwordChars = console.readPassword("Enter your password: ");
    String password = new String(passwordChars);
    
    // Clearing the password from memory (security best practice)
    Arrays.fill(passwordChars, ' ');
    
    console.printf("Hello, %s! Your password has %d characters.%n", name, password.length());
} else {
    System.out.println("Console not available. Run this from a terminal.");
}
```

## 9. Memory-Mapped Files (NIO)

Memory-mapped files allow you to map a file directly into memory for faster I/O operations.

```java
// Writing to a memory-mapped file
try (RandomAccessFile file = new RandomAccessFile("mapped.dat", "rw");
     FileChannel channel = file.getChannel()) {
    
    // Create a buffer of size 1KB
    ByteBuffer buffer = ByteBuffer.allocate(1024);
    
    // Write data to the buffer
    buffer.put("Hello, Memory-Mapped File!".getBytes());
    buffer.flip();
    
    // Write buffer to the file
    channel.write(buffer);
    
} catch (IOException e) {
    e.printStackTrace();
}

// Reading from a memory-mapped file
try (RandomAccessFile file = new RandomAccessFile("mapped.dat", "r");
     FileChannel channel = file.getChannel()) {
    
    // Map the file into memory
    MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
    
    // Read data from the buffer
    byte[] data = new byte[(int) channel.size()];
    buffer.get(data);
    
    System.out.println("Read from memory-mapped file: " + new String(data));
    
} catch (IOException e) {
    e.printStackTrace();
}
```

## 10. Asynchronous I/O (NIO.2)

NIO.2 provides support for asynchronous I/O operations.

```java
// Asynchronous file reading
Path filePath = Paths.get("async.txt");

// Create some test data
try {
    Files.write(filePath, "Asynchronous I/O test data.".getBytes());
} catch (IOException e) {
    e.printStackTrace();
}

// Asynchronous read
try {
    AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(filePath, StandardOpenOption.READ);
    
    ByteBuffer buffer = ByteBuffer.allocate(1024);
    
    // Read operation
    Future<Integer> operation = fileChannel.read(buffer, 0);
    
    // Do some other work while reading
    System.out.println("Doing some other work while reading...");
    
    // Wait for the read operation to complete
    int bytesRead = operation.get();
    
    buffer.flip();
    byte[] data = new byte[bytesRead];
    buffer.get(data);
    System.out.println("Asynchronously read: " + new String(data));
    
    fileChannel.close();
} catch (IOException | InterruptedException | ExecutionException e) {
    e.printStackTrace();
}

// Asynchronous write with CompletionHandler
try {
    AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(
            Paths.get("async_write.txt"),
            StandardOpenOption.WRITE,
            StandardOpenOption.CREATE);
    
    ByteBuffer buffer = ByteBuffer.wrap("Asynchronous write test.".getBytes());
    
    fileChannel.write(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
        @Override
        public void completed(Integer result, ByteBuffer attachment) {
            System.out.println("Write completed, " + result + " bytes written");
        }
        
        @Override
        public void failed(Throwable exc, ByteBuffer attachment) {
            System.err.println("Write failed: " + exc);
        }
    });
    
    // Give some time for the operation to complete
    Thread.sleep(1000);
    
    fileChannel.close();
} catch (IOException | InterruptedException e) {
    e.printStackTrace();
}
```

## 11. Best Practices for I/O Operations

1. **Always close resources**: Use try-with-resources to ensure that streams are properly closed.
2. **Use buffered streams**: Buffered streams can significantly improve performance.
3. **Choose the right stream type**: Use byte streams for binary data and character streams for text data.
4. **Handle exceptions properly**: I/O operations can throw various exceptions that should be handled appropriately.
5. **Use NIO.2 for modern applications**: NIO.2 provides more powerful and flexible I/O operations.
6. **Avoid reading large files into memory**: Use streaming or memory-mapped files for large files.
7. **Use character encoding properly**: Specify the correct character encoding when working with text files.
8. **Consider thread safety**: When multiple threads access the same file, use proper synchronization or separate file handles.