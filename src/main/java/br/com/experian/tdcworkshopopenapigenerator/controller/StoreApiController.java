package br.com.experian.tdcworkshopopenapigenerator.controller;


import br.com.experian.petstore.api.StoreApi;
import br.com.experian.petstore.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/v3")
public class StoreApiController implements StoreApi {

    @Autowired
    NativeWebRequest nativeWebRequest;
    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.of(nativeWebRequest);
    }

    @Override
    public ResponseEntity<Order> placeOrder(Order order) {
        Order returnOrder = new Order()
                .id(order.getId())
                .petId(order.getPetId())
                .quantity(order.getQuantity())
                .shipDate(order.getShipDate())
                .status(order.getStatus())
                .complete(true);
        return new ResponseEntity<>(returnOrder, CREATED);
    }
}
