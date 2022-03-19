package com.nerjal.json.compat;

import com.google.gson.JsonPrimitive;
import com.nerjal.json.elements.*;

/**
 * Conversions from {@link com.google.gson} elements
 * to {@link com.nerjal.json}
 */
public abstract class GsonCompat {
    /**
     * Returns the {@link com.nerjal.json.elements.JsonElement}
     * of the specified {@link com.google.gson.JsonElement}
     * @param element the primitive to convert
     * @return the converted element of the specified element
     */
    public static JsonElement fromGsonElement(com.google.gson.JsonElement element) {
        if (element == null) return null;
        if (element.isJsonArray()) return fromGsonArray(element.getAsJsonArray());
        if (element.isJsonPrimitive()) {
            JsonPrimitive primitive = element.getAsJsonPrimitive();
            if (primitive.isBoolean()) return fromGsonBoolean(primitive);
            if (primitive.isNumber()) return fromGsonNumber(primitive);
            return fromGsonString(primitive);
        }
        if (element.isJsonNull()) return new JsonString();
        if (element.isJsonArray()) return fromGsonArray(element.getAsJsonArray());
        if (element.isJsonObject()) return fromGsonObject(element.getAsJsonObject());
        return null;
    }

    /**
     * Returns the {@link com.nerjal.json.elements.JsonString}
     * of the specified {@link com.google.gson.JsonPrimitive}
     * @param str the primitive to convert
     * @return the converted element of the specified primitive
     */
    public static JsonString fromGsonString(com.google.gson.JsonPrimitive str) {
        return new JsonString(str.getAsString());
    }

    /**
     * Returns the {@link com.nerjal.json.elements.JsonNumber}
     * of the specified {@link com.google.gson.JsonPrimitive}
     * @param n the primitive to convert
     * @return the converted element of the specified primitive
     */
    public static JsonNumber fromGsonNumber(com.google.gson.JsonPrimitive n) {
        return new JsonNumber(n.getAsNumber());
    }

    /**
     * Returns the {@link com.nerjal.json.elements.JsonBoolean}
     * of the specified {@link com.google.gson.JsonPrimitive}
     * @param b the primitive to convert
     * @return the converted element of the specified primitive
     */
    public static JsonBoolean fromGsonBoolean(com.google.gson.JsonPrimitive b) {
        return new JsonBoolean(b.getAsBoolean());
    }

    /**
     * Returns the {@link com.nerjal.json.elements.JsonArray}
     * of the specified {@link com.google.gson.JsonArray}
     * @param array the array to convert
     * @return the converted element of the specified array
     */
    public static JsonArray fromGsonArray(com.google.gson.JsonArray array) {
        JsonArray arr = new JsonArray();
        array.iterator().forEachRemaining(e -> arr.add(fromGsonElement(e)));
        return arr;
    }

    /**
     * Returns the {@link com.nerjal.json.elements.JsonObject}
     * of the specified {@link com.google.gson.JsonObject}
     * @param object the primitive to convert
     * @return the converted element of the specified object
     */
    public static JsonObject fromGsonObject(com.google.gson.JsonObject object) {
        JsonObject obj = new JsonObject();
        object.entrySet().forEach(entry -> obj.add(entry.getKey(), fromGsonElement(entry.getValue())));
        return obj;
    }
}
