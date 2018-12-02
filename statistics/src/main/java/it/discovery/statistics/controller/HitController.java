package it.discovery.statistics.controller;

import it.discovery.statistics.domain.Hit;
import it.discovery.statistics.repository.HitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hit")
@RequiredArgsConstructor
public class HitController {

    private final HitRepository hitRepository;

    @GetMapping("/{entityId}")
    public int getHitCount(@PathVariable String objectId) {
        return hitRepository.getHitCount(objectId);
    }

    @GetMapping
    public int getHits() {
        return 0;
    }

    @PostMapping
    public void saveHit(@RequestBody Hit hit) {
        hitRepository.saveHit(hit);
    }
}
