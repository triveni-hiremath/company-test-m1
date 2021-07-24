package com.company.rest.controller;

import com.company.rest.model.Owner;
import com.company.rest.model.SsnValid;
import com.company.rest.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    /* Api to Add an owner of the company */
    @PostMapping("/add")
    public Owner addOwner(@RequestBody Owner owner) {
        return ownerService.add(owner);
    }


    /* Api to  Check of Social Security Number */
    @PostMapping("/validate/ssn")
    public ResponseEntity<SsnValid> validate(@RequestBody Owner owner) {
        SsnValid ssnValid = ownerService.validateSsn(owner);
        if (!ssnValid.isValid()) {
            return ResponseEntity.badRequest().body(ssnValid);
        }
        return ResponseEntity.ok().body(ssnValid);
    }
}
