package com.company.rest.service;

import com.company.rest.model.Owner;
import com.company.rest.model.SsnValid;

public interface OwnerService {

    Owner add(Owner owner);

    SsnValid validateSsn(Owner owner);
}
