package it.discovery.statistics.repository;

import it.discovery.statistics.domain.Hit;

public interface HitRepository {

    int getHitCount(String objectId);

    void saveHit(Hit hit);
}
