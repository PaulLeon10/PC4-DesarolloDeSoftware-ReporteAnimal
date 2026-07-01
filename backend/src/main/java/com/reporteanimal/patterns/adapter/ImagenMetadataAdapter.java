package com.reporteanimal.patterns.adapter;

import java.util.HashMap;
import java.util.Map;

public class ImagenMetadataAdapter {

    public Map<String, String> adaptar(ImagenMetadata metadata) {

        Map<String, String> json = new HashMap<>();

        json.put("etiqueta", metadata.getEtiqueta());
        json.put("descripcion", metadata.getDescripcion());

        return json;
    }
}