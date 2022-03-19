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