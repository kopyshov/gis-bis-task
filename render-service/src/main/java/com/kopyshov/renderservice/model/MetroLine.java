package com.kopyshov.renderservice.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.NonNull;
import org.locationtech.jts.geom.Geometry;
import org.n52.jackson.datatype.jts.GeometryDeserializer;
import org.n52.jackson.datatype.jts.GeometrySerializer;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

@Table(name = "metro_line", schema = "public")
@Data
public class MetroLine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column("id")
    private Long id;

    @Column("line_path")
    @NonNull
    @JsonSerialize(using = GeometrySerializer.class)
    @JsonDeserialize(using = GeometryDeserializer.class)
    private Geometry linePath;

    @Column("line_color")
    @NonNull
    private String lineColor;
}
