# JsonLight Gson Compatibility tool

### Presentation

A simple library aiming to make conversion between the
[JsonLight](https://github.com/NerjalNosk/JsonLight) and
[Gson](thhps://github.com/google/gson) APIs easier, through a
few little functions.

Use `com.nerjal.json.compat.GsonCompat` in order to
convert Gson elements to JsonLight ones.<br>
Just as well, use `com.nerjal.json.compat.JsonCompat`
to convert from JsonLight to Gson.

### Example

```java
import com.json.nerjal.compat.*;

public abstract class Main {
    public static void main(String[] args) {
        com.google.gson.JsonObject object = new com.google.gson.JsonObject();
        object.add("key", new com.google.gson.JsonPrimitive("string"));
        com.nerjal.json.elements.JsonObject object2 = GsonCompat.fromGsonObject(object);
        System.out.println(object2.stringify());
        // prints '{\n  "key": "string"\n}'
        
        com.nerjal.json.elements.JsonArray array = new com.nerjal.json.elements.JsonArray();
        array.add(new com.nerjal.json.elements.JsonNumber(2.5d));
        com.google.gson.JsonArray array2 = JsonCompat.fromJsonArray(array);
        System.out.println(array2.toString());
        // prints '[2.5]'
    }
}
```

### Import

Use [Jitpack](https://jitpack.io) in order to import the library
into your own project.

#### With Maven

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>...</groupId>
    <artifactId>...</artifactId>
    <version>...</version>
    
    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
            <snapshots>
                <enabled>true</enabled>
                <updatePolicy>always</updatePolicy>
            </snapshots>
        </repository>
    </repositories>
    
    <dependencies>
        <dependency>
            <groupId>com.github.NerjalNosk</groupId>
            <artifactId>JsonLight-Gson-Compat</artifactId>
            <version>1.0.2</version>
        </dependency>
    </dependencies>
</project>
```

#### With Gradle

```groovy
repositories {
    maven { url "https://jitpack.io" }
}

dependencies {
    implementation "com.github.NerjalNosk:JsonLight-Gson-Compat:1.0.2"
}
```