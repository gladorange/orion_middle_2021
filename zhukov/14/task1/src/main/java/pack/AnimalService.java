package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalService{

    @Autowired
    final DogRepository dogRepository;

    public AnimalService(DogRepository dogRepository){
        this.dogRepository = dogRepository;
        System.out.println(findLoudestDogs() );
    }

    List<Dog> findLoudestDogs(){
        return this.dogRepository.findAllInstances()
                .stream().sorted(Comparator.comparingInt(Dog::getBarkingVol))
        .collect(Collectors.toList());
    }
}
