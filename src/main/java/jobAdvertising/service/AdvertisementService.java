package jobAdvertising.service;
import jobAdvertising.domain.Advertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdvertisementService {
    private List<Advertisement> advertisements = new ArrayList<>();

    public void addAdvertisement(Advertisement advertisement) {
        advertisements.add(advertisement);
    }
}
