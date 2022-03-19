package com.nerjal.json.compat;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

/**
 * Conversions from  elements {@link com.nerjal.json}
 * to {@link com.google.gson}
 */
public abstract class JsonCompat {
    /**
     * Returns the {@link com.google.gson.JsonElement}
     * of the specified {@link com.nerjal.json.elements.JsonElement}
     * @param element the primitive to convert
     * @return the converted element of the specified element
     */
    public static JsonElement fromJsonElement(com.nerjal.json.elements.JsonElement element) {
        if (element == null) return null;
        if (element.isComment()) throw new UnsupportedOperationException("JsonComments unsupported by Gson");
        if (element.isBoolean()) return fromJsonBoolean((com.nerjal.json.elements.JsonBoolean) element);
        if (element.isNumber()) return fromJsonNumber((com.nerjal.json.elements.JsonNumber) element);
        if (element.isJsonArray()) return fromJsonArray((com.nerjal.json.elements.JsonArray) element);
        if (element.isJsonObject()) return fromJsonObject((com.nerjal.json.elements.JsonObject) element);
        if (element.isString()) return fromJsonString((com.nerjal.json.elements.JsonString) element);
        return null;
    }

    /**
     * Returns the {@link com.google.gson.JsonPrimitive}
     * of the specified {@link com.nerjal.json.elements.JsonNumber}
     * @param n the JsonNumber to convert
     * @return the converted element of the specified number
     */
    public static JsonPrimitive fromJsonNumber(com.nerjal.json.elements.JsonNumber n) {
        return new JsonPrimitive(n.getAsNumber());
    }

    /**
     * Returns the {@link com.google.gson.JsonPrimitive}
     * of the specified {@link com.nerjal.json.elements.JsonBoolean}
     * @param b the JsonBoolean to convert
     * @return the converted element of the specified boolean
     */
    public static JsonPrimitive fromJsonBoolean(com.nerjal.json.elements.JsonBoolean b) {
        return new JsonPrimitive(b.getAsBoolean());
    }

    /**
     * Returns the {@link com.google.gson.JsonPrimitive}
     * of the specified {@link com.nerjal.json.elements.JsonString}
     * @param str the JsonString to convert
     * @return the converted element of the specified string
     */
    public static JsonPrimitive fromJsonString(com.nerjal.json.elements.JsonString str) {
        return new JsonPrimitive(str.getAsString());
    }

    /**
     * Returns the {@link com.google.gson.JsonArray}
     * of the specified {@link com.nerjal.json.elements.JsonArray}
     * @param array the JsonArray to convert
     * @return the converted element of the specified array
     */
    public static JsonArray fromJsonArray(com.nerjal.json.elements.JsonArray array) {
        JsonArray arr = new JsonArray();
        array.forEach(e -> arr.add(fromJsonElement(e)));
        return arr;
    }

    /**
     * Returns the {@link com.google.gson.JsonObject}
     * of the specified {@link com.nerjal.json.elements.JsonObject}
     * @param object the JsonObject to convert
     * @return the converted element of the specified object
     */
    public static JsonObject fromJsonObject(com.nerjal.json.elements.JsonObject object) {
        JsonObject obj = new JsonObject();
        object.forEach((k,e) -> obj.add(k, fromJsonElement(e)));
        return obj;
    }
}
