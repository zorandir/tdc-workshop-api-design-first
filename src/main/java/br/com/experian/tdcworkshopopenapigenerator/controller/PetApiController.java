package br.com.experian.tdcworkshopopenapigenerator.controller;


import br.com.experian.petstore.api.PetApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@RestController
@RequestMapping("/v3")
public class PetApiController implements PetApi {

    @Autowired
    NativeWebRequest nativeWebRequest;
    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.of(nativeWebRequest);
    }

}
