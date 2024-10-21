package hu.foxpost.fox_client.client;

import hu.foxpost.fox_client.dto.shared.TrackingEventDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "parcel-handler-tracking", url = "${parcel.handler.tracking.url}")
public interface TrackingServiceClient {

    @GetMapping("/events/{parcelId}")
    List<TrackingEventDto> getAllTrackingEventsByParcelId(@PathVariable("parcelId") Integer parcelId);

}
