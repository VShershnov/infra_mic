package it.discovery.book.client;

import it.discovery.book.domain.Hit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("statistics")
public interface StatisticsClient {

    @GetMapping("hit/{objectId}")
    int getHitCount(@PathVariable int objectId);

    @PostMapping("hit")
    void saveHit(@RequestBody Hit hit);
}
