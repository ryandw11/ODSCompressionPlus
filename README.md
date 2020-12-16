# ODSCompressionPlus
ODSCompressionPlus is an addon for the [Object Data Structure](https://github.com/ryandw11/ODS) file format.
ODSCompressionPlus adds extra compression formats for use. ODSCompressionPlus exists to keep the main ODS jar as small and leight wieght as possible. As of right
now there is only one format. Feel free to contribute existing formats by using a pull request.

## Usage
```xml
<repositories>
    <repository>
        <id>Ryandw11-Repo-Snapshots</id>
        <url>https://repo.ryandw11.com/repository/maven-releases/</url>
    </repository>
</repositories>

<dependency>
    <groupId>me.ryandw11</groupId>
    <artifactId>ODSCompressionPlus</artifactId>
    <version>1.0.1</version>
</dependency>
```

## Compression Formts
### Zstd
The Zstd format is located in the `ZSTDCompression` class.  
The implementation is provided by [zstd-jni](https://github.com/luben/zstd-jni) which is liscensed under BSD.  
```java
ObjectDataStructure ods = new ObjectDataStructure(new File("file.ods"), new ZSTDCompression());
```
