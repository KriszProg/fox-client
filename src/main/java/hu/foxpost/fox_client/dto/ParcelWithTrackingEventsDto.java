package hu.foxpost.fox_client.dto;

import hu.foxpost.fox_client.dto.shared.ParcelDto;
import hu.foxpost.fox_client.dto.shared.TrackingEventDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ParcelWithTrackingEventsDto {

    private ParcelDto parcel;
    private List<TrackingEventDto> events;


    public ParcelWithTrackingEventsDto parcel(ParcelDto parcel) {
        this.parcel = parcel;
        return this;
    }

    public ParcelWithTrackingEventsDto events(List<TrackingEventDto> events) {
        this.events = events;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ParcelWithTrackingEventsDto that = (ParcelWithTrackingEventsDto) object;
        return Objects.equals(parcel, that.parcel)
                && Objects.equals(events, that.events);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parcel, events);
    }

    @Override
    public String toString() {
        return "ParcelWithTrackingEventsDto{" +
                "parcel=" + parcel +
                ", events=" + events +
                '}';
    }

}
