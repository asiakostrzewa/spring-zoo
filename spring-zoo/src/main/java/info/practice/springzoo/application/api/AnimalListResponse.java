package info.practice.springzoo.application.api;

import info.practice.springzoo.domain.animal.AnimalDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import java.util.List;

@Data
@AllArgsConstructor
//@Value
public class AnimalListResponse {
    List<AnimalDto> animals;

    public static AnimalListResponse from(List<AnimalDto> animals) {
        return new AnimalListResponse(animals);
    }
}