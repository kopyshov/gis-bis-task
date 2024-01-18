package com.kopyshov.renderservice.service;

import com.kopyshov.renderservice.model.MetroLine;
import com.kopyshov.renderservice.repository.MetroLinesRepository;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import reactor.core.publisher.Flux;

@Service
@Validated
public class MetroLineService {
    @Autowired
    private MetroLinesRepository repository;
    public Flux<MetroLine> getMetroLines(String bbox) {
        String[] latLanCorners = bbox.split(",");
        Double minLon = Double.parseDouble(latLanCorners[0]);
        Double minLat = Double.parseDouble(latLanCorners[1]);
        Double maxLon = Double.parseDouble(latLanCorners[2]);
        Double maxLat = Double.parseDouble(latLanCorners[3]);
        return repository.getMetroLinesByBbox(minLon, minLat, maxLon, maxLat).log();
    }

}
