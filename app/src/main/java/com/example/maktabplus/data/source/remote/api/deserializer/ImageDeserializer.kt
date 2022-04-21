package com.example.maktabplus.data.source.remote.api.deserializer

import com.example.maktabplus.data.model.Image
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class ImageDeserializer : JsonDeserializer<Image?> {

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Image? {
        return json?.asJsonObject?.run {
            Image(
                id = get("id").asString,
                downloadUrl = get("download_url").asString,
                height = get("height").asInt,
                width = get("width").asInt
            )
        }
    }
}