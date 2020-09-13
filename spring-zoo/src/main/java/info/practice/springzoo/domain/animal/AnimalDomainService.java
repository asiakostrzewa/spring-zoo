package info.practice.springzoo.domain.animal;

import java.util.List;

public interface AnimalDomainService {
    List<AnimalDto> getAllAnimals();
    void addAnimall(AnimalDto animalDto);
}
