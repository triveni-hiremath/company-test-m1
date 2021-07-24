package com.company.rest.service.impl;

import com.company.rest.constants.SsnConstant;
import com.company.rest.model.Owner;
import com.company.rest.model.SsnValid;
import com.company.rest.proxy.SsnProxy;
import com.company.rest.repository.OwnerRepository;
import com.company.rest.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService {

  @Autowired OwnerRepository ownerRepository;

  @Autowired SsnProxy ssnProxy;

  @Override
  public Owner add(Owner owner) {
    return ownerRepository.save(owner);
  }

  @Override
  public SsnValid validateSsn(Owner owner) {
    /*String ssn = owner.getSsn();
    AtomicBoolean valid = new AtomicBoolean(false);
    if (ssn.length() != 11) return invalid();
    else {
      String[] ssnArr = ssn.split("-");
      if ((ssnArr.length != 3)
          || (ssnArr[0].length() != 3)
          || (ssnArr[1].length() != 2)
          || (ssnArr[2].length() != 4)) return invalid();
      Arrays.stream(ssnArr)
          .sequential()
          .forEach(
              s -> {
                try {
                  valid.set(true);
                } catch (NumberFormatException e) {
                  valid.set(false);
                }
              });
    }
    if (valid.get()) return valid();*/

    String response = ssnProxy.validate(owner.getSsn());
    if (response.equals("valid")) return valid();
    return invalid();
  }

  public SsnValid invalid() {
    SsnValid ssnValid = new SsnValid();
    ssnValid.setValid(false);
    ssnValid.setMessage(SsnConstant.SSN_INVALID);
    return ssnValid;
  }

  private SsnValid valid() {
    SsnValid ssnValid = new SsnValid();
    ssnValid.setValid(true);
    ssnValid.setMessage(SsnConstant.SSN_VALID);
    return ssnValid;
  }
}
