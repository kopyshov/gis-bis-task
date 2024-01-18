package com.kopyshov.renderservice.controller;

import com.kopyshov.renderservice.model.MetroLine;
import com.kopyshov.renderservice.service.MetroLineService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@Validated
@RequestMapping(value = "/api/v1/*")
public class MetroLineController {
    @Autowired
    private MetroLineService metroLineService;

    @CrossOrigin
    @GetMapping(value = "/{bbox}",
            produces = {MediaType.TEXT_EVENT_STREAM_VALUE})
    public Flux<MetroLine> getMetroLines(@PathVariable
                @Pattern(regexp = "([0-9]{2}.[0-9]+,[0-9]{2}.[0-9]+,[0-9]{2}.[0-9]+,[0-9]{2}.[0-9]+)",
                message = "Illegal Bounded box"
                )
                String bbox) {
        return metroLineService.getMetroLines(bbox);
    }
}
