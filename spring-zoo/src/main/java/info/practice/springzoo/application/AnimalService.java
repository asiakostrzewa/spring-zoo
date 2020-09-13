package info.practice.springzoo.application;

import info.practice.springzoo.domain.animal.AnimalDomainService;
import info.practice.springzoo.domain.animal.AnimalDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AnimalService {

    private AnimalDomainService animalDomainService;

    public AnimalService(AnimalDomainService animalDomainService) {
        this.animalDomainService = animalDomainService;
    }

    public List<AnimalDto> getAllAnimals(){
        return animalDomainService.getAllAnimals();
    }

    public void addAnimal(AnimalDto animalDto){
        animalDomainService.addAnimall(animalDto);
    }

    }
