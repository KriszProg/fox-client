package hu.foxpost.fox_client.service;

import hu.foxpost.fox_client.dto.ParcelWithTrackingEventsDto;
import hu.foxpost.fox_client.dto.shared.TrackingEventDto;

import java.util.List;

public interface TrackingService {

    List<TrackingEventDto> getAllTrackingEventsByParcelNo(String parcelNo);

    ParcelWithTrackingEventsDto getParcelWithTrackingEventsByParcelNo(String parcelNo);

}
