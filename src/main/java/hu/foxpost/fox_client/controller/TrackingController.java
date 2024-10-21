package hu.foxpost.fox_client.controller;

import hu.foxpost.fox_client.dto.ParcelWithTrackingEventsDto;
import hu.foxpost.fox_client.dto.shared.TrackingEventDto;
import hu.foxpost.fox_client.exception.ApiError;
import hu.foxpost.fox_client.service.TrackingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tracking")
public class TrackingController {
    @Autowired
    TrackingService trackingService;

    /**
     * ## Get TrackingEvents filtered by Parcel no
     * Returns a list which contains data of TrackingEvents - filtered by Parcel no </br>
     * - If Parcel not exists by parcelNo: returns 404 (Parcel not found)
     *
     * @param parcelNo filtering for exact match by parcel.parcelNo
     */
    @GetMapping("/events")
    @Operation(summary = "Get TrackingEvents filtered by Parcel no")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = TrackingEventDto.class)))}),
            @ApiResponse(responseCode = "404", description = "Parcel not found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))})
    })
    public List<TrackingEventDto> getAllTrackingEventsByParcelNo(@RequestParam("parcelNo") String parcelNo) {
        return trackingService.getAllTrackingEventsByParcelNo(parcelNo);
    }

    /**
     * ## Get TrackingEvents with Parcel details filtered by Parcel no
     * Returns an object which contains data of Parcel and list of TrackingEvents belongs to the Parcel </br>
     * - If Parcel not exists by ParcelNo: returns 404 (Parcel not found)
     *
     * @param parcelNo filtering for exact match by parcel.parcelNo
     */
    @GetMapping("/events/with-parcel-details")
    @Operation(summary = "Get TrackingEvents with Parcel details filtered by Parcel no")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ParcelWithTrackingEventsDto.class))}),
            @ApiResponse(responseCode = "404", description = "Parcel not found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))})
    })
    public ParcelWithTrackingEventsDto getParcelWithTrackingEventsByParcelNo(@RequestParam("parcelNo") String parcelNo) {
        return trackingService.getParcelWithTrackingEventsByParcelNo(parcelNo);
    }

}
