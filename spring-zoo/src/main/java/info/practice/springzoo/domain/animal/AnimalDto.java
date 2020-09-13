package info.practice.springzoo.domain.animal;

import lombok.Value;

import java.time.Instant;

@Value
public class AnimalDto {
        String id;
        String name;
        String species;
        Instant dateOfBirth;
        Integer weight;
        boolean dangerous;

        public static AnimalDto convertFromRequest(AnimalRequest animalRequest){
                return new AnimalDto(
                        animalRequest.getId(),
                        animalRequest.getName(),
                        animalRequest.getSpecies(),
                        animalRequest.getDateOfBirth(),
                        animalRequest.getWeightKilos(),
                        animalRequest.isDangerous()
                );
        }
}