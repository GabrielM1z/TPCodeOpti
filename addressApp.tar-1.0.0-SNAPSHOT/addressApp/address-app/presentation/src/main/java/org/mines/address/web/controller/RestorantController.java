package org.mines.address.web.controller;

import org.mines.address.api.controller.RestorantApi;
import org.mines.address.api.controller.TownApi;
import org.mines.address.api.model.Restorant;
import org.mines.address.port.driving.RestorantUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping
public class RestorantController implements RestorantApi {

    private RestorantUseCase restorantUseCase;

    @Autowired
    public RestorantController(RestorantUseCase restorantUseCase) {
        this.restorantUseCase = restorantUseCase;
    }

    @Override
    public ResponseEntity<Restorant> createRestorant(Restorant restorant) {
        return RestorantApi.super.createRestorant(restorant);
    }

    @Override
    public ResponseEntity<List<Restorant>> listRestorants() {
        return RestorantApi.super.listRestorants();
    }
}
