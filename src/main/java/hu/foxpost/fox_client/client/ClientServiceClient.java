package hu.foxpost.fox_client.client;

import hu.foxpost.fox_client.dto.shared.ClientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "parcel-handler-clients", url = "${parcel.handler.clients.url}")
public interface ClientServiceClient {

    @GetMapping
    List<ClientDto> getAllClients();

    @GetMapping("/{id}")
    ClientDto getClientById(@PathVariable("id") Integer id);

    @GetMapping("/search")
    List<ClientDto> searchClients(
            @RequestParam(required = false, value = "clientName") String clientName,
            @RequestParam(required = false, value = "address") String address,
            @RequestParam(required = false, value = "zipCode") String zipCode,
            @RequestParam(required = false, value = "city") String city,
            @RequestParam(required = false, value = "phone") String phone,
            @RequestParam(required = false, value = "email") String email);

}
