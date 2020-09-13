package info.practice.springzoo.domain.animal;

import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

@Data
@Validated
public class AnimalRequest {

    String id;

    @NotBlank
    @NotNull
    String name;

    @NotBlank
    @NotNull
    String species;

    Instant dateOfBirth;

    @Min(value = 0)
    @Max(value = 10000)
    Integer weightKilos;
    boolean dangerous;

    public AnimalDto toAnimalDto(){
        return new AnimalDto(null, name, species, dateOfBirth, weightKilos, dangerous);
    }
}
