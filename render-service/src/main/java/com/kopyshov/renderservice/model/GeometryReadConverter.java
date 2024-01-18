package com.kopyshov.renderservice.model;

import lombok.NonNull;
import org.locationtech.jts.geom.Geometry;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Component;

@Component
@ReadingConverter
@ConfigurationPropertiesBinding
public class GeometryReadConverter implements Converter<Geometry, Geometry> {
    @Override
    public Geometry convert(@NonNull Geometry source) {
        return source;
    }
}
