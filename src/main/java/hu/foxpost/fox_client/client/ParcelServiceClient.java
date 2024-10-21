package hu.foxpost.fox_client.client;

import hu.foxpost.fox_client.dto.shared.ParcelBaseDto;
import hu.foxpost.fox_client.dto.shared.ParcelDto;
import hu.foxpost.fox_client.dto.shared.ParcelsByReceiverDto;
import hu.foxpost.fox_client.dto.shared.ParcelsBySenderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "parcel-handler-parcels", url = "${parcel.handler.parcels.url}")
public interface ParcelServiceClient {

    @GetMapping("/detailed")
    List<ParcelDto> getParcelsByParams(
            @RequestParam(required = false, value = "senderId") Integer senderId,
            @RequestParam(required = false, value = "receiverId") Integer receiverId);

    @GetMapping("/detailed/all")
    List<ParcelDto> getAllParcels();

    @GetMapping("/detailed/by-parcel-no/{parcelNo}")
    ParcelDto getParcelByParcelNo(@PathVariable("parcelNo") String parcelNo);

    @GetMapping("/detailed/by-sender/{senderId}")
    List<ParcelDto> getParcelsBySenderId(@PathVariable("senderId") Integer senderId);

    @GetMapping("/detailed/by-receiver/{receiverId}")
    List<ParcelDto> getParcelsByReceiverId(@PathVariable("receiverId") Integer receiverId);

    @GetMapping("/base-data/{parcelNo}")
    ParcelBaseDto getParcelBaseByParcelNo(@PathVariable("parcelNo") String parcelNo);

    @GetMapping("/base-data/grouped-by-sender")
    List<ParcelsBySenderDto> getListOfParcelsBySender();

    @GetMapping("/base-data/grouped-by-receiver")
    List<ParcelsByReceiverDto> getListOfParcelsByReceiver();

}
