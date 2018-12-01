package it.discovery.statistics.repository;

import it.discovery.statistics.domain.Hit;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryHitRepository implements HitRepository {
    private Map<Integer, List<Hit>> hits;


    @Override
    public int getHitCount(String objectId) {
        return hits.getOrDefault(objectId, Collections.emptyList()).size();

    }
}
