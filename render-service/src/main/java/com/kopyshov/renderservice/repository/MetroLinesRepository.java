package com.kopyshov.renderservice.repository;

import com.kopyshov.renderservice.model.MetroLine;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface MetroLinesRepository extends ReactiveCrudRepository<MetroLine, Long> {
    @Query("select * from metro_line as lt " +
            "where ST_Intersects(lt.line_path , ST_MakeEnvelope(:minLon, :minLat, :maxLon, :maxLat, 4326))")
    Flux<MetroLine> getMetroLinesByBbox(Double minLon, Double minLat, Double maxLon, Double maxLat);
}
