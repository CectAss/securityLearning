package Cectus4.services;

import Cectus4.model.Application;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class AppService {

    private List<Application> apps;

    @PostConstruct
    public void loadAppInDB() {
        Faker faker = new Faker();
        apps = IntStream.rangeClosed(1, 100).mapToObj(el -> Application.builder()
                        .id(el)
                        .name(faker.app().name())
                        .author(faker.app().author())
                        .version(faker.app().version())
                        .build())
                .toList();
    }

    public List<Application> getApps() {
        return apps;
    }

    public Application getAppById(int id) {
        return apps.stream().filter(app -> app.getId() == id).findFirst().orElse(null);
    }

}
