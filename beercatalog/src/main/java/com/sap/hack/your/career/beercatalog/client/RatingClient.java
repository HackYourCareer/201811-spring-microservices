package com.sap.hack.your.career.beercatalog.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("beer-rating")
public interface RatingClient {

	@DeleteMapping("/beer/{beerId}")
	void deleteRatings(@PathVariable("beerId") Long beerId);

}
