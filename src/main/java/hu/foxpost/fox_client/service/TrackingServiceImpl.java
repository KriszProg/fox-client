package hu.foxpost.fox_client.service;

import hu.foxpost.fox_client.client.ParcelServiceClient;
import hu.foxpost.fox_client.client.TrackingServiceClient;
import hu.foxpost.fox_client.dto.shared.ParcelBaseDto;
import hu.foxpost.fox_client.dto.shared.ParcelDto;
import hu.foxpost.fox_client.dto.ParcelWithTrackingEventsDto;
import hu.foxpost.fox_client.dto.shared.TrackingEventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackingServiceImpl implements TrackingService {

    @Autowired
    ParcelServiceClient parcelServiceClient;

    @Autowired
    TrackingServiceClient trackingServiceClient;

    @Override
    public List<TrackingEventDto> getAllTrackingEventsByParcelNo(String parcelNo) {
        ParcelBaseDto parcelBase = parcelServiceClient.getParcelBaseByParcelNo(parcelNo);
        return trackingServiceClient.getAllTrackingEventsByParcelId(parcelBase.getId());
    }

    @Override
    public ParcelWithTrackingEventsDto getParcelWithTrackingEventsByParcelNo(String parcelNo) {
        ParcelDto parcel = parcelServiceClient.getParcelByParcelNo(parcelNo);
        List<TrackingEventDto> events = trackingServiceClient.getAllTrackingEventsByParcelId(parcel.getId());
        return new ParcelWithTrackingEventsDto(parcel, events);
    }

}
