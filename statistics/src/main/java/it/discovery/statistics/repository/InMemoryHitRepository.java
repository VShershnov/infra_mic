package it.discovery.statistics.repository;

import it.discovery.statistics.domain.Hit;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryHitRepository implements HitRepository {
    private Map<String, List<Hit>> hits;


    @Override
    public int getHitCount(String objectId) {
        return hits.getOrDefault(objectId, Collections.emptyList()).size();

    }

    @Override
    public void saveHit(Hit hit) {
        List<Hit> items = hits.get(hit.getObjectId());
        if(items == null) {
            items = new ArrayList<>();
            hits.put(hit.getObjectId(), items);
        }
        items.add(hit);

    }
}
