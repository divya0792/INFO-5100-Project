package m4.Team1.controller;

import m4.Team1.RequestForm;
import m4.Team1.database.dao.DealerTableDao;
import m4.Team1.database.dao.CustomerRequestTableDao;
import m4.Team1.database.dao.VehicleTableDao;
import m4.Team1.database.model.CustomerInfo;
import m4.Team1.database.model.CustomerRequest;
import m4.Team1.database.model.DealerDetails;
import m4.Team1.database.model.VehicleDetails;

import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

public class RequestFormController {
    private static final Logger log = Logger.getLogger(RequestFormController.class.getSimpleName());

    private final VehicleTableDao vehicleTableDao;
    private final DealerTableDao dealerTableDao;
    private final CustomerRequestTableDao customerRequestTableDao;
    private static VehicleDetails vehicleDetails;
    private static DealerDetails dealerDetails;

    public RequestFormController(VehicleTableDao vehicleTableDao, DealerTableDao dealerTableDao, CustomerRequestTableDao customerRequestTableDao) {
        this.vehicleTableDao = vehicleTableDao;
        this.dealerTableDao = dealerTableDao;
        this.customerRequestTableDao = customerRequestTableDao;
    }


    public RequestForm createRequestForm(String carId, String dealerId) {
        vehicleDetails = vehicleTableDao.getVehicleDetails(carId);
        dealerDetails = dealerTableDao.getDealerDetails(dealerId);

        return new RequestForm.RequestFormBuilder()
                .withCarDetails(vehicleDetails)
                .withDealerDetails(dealerDetails)
                .withInterestedPeopleCount(vehicleDetails.getInterestedPeopleCount())
                .withRequestFormController(this)
                .build();
    }

    public Optional<CustomerInfo> getCustomerInfo(String phoneNumber) {
        if (phoneNumber == null) {
            return Optional.empty();
        }

        String phoneNumberCleaned = phoneNumber.trim();
        return Optional.ofNullable(customerRequestTableDao.getCustomerInfo(phoneNumberCleaned));
    }

    public void writeCustomerRequest(RequestForm requestForm) {
        CustomerRequest customerRequest = new CustomerRequest();
        try {
            String customerId = UUID.randomUUID().toString();
            customerRequest.setCustomerId(customerId);
            customerRequest.setVehicleId(requestForm.getCarDetails().getId());
            customerRequest.setDealerId(requestForm.getDealerDetails().getId());
            customerRequest.setFirstName(requestForm.getFirstNameField().getText());
            customerRequest.setLastName(requestForm.getLastNameField().getText());
            customerRequest.setEmail(requestForm.getEmailField().getText());
            customerRequest.setContactNo(requestForm.getPhoneNumField().getText());
            customerRequest.setComment(requestForm.getMessageArea().getText());
        } catch (NullPointerException e) {
            throw new RuntimeException("Some fields have null text.", e);
        }

        customerRequestTableDao.writeCustomerRequest(customerRequest);
        log.info("Successfully wrote customer request into table.");
    }
    
    public void updateInterestedPeopleCount() {
    	vehicleTableDao.updateInterestedPeopleCount(vehicleDetails.getId(), vehicleDetails.getInterestedPeopleCount());
    }
}
