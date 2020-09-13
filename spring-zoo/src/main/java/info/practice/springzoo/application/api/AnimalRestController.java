package info.practice.springzoo.application.api;

import info.practice.springzoo.application.AnimalService;
import info.practice.springzoo.domain.animal.AnimalDto;
import info.practice.springzoo.domain.animal.AnimalRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//@Api
@RestController
@RequestMapping(path = "/zoo")
public class AnimalRestController {
    private final AnimalService animalService;
    public AnimalRestController(AnimalService animalService){
        this.animalService = animalService;
    }
    @GetMapping("/animals")
    ResponseEntity<AnimalListResponse> list(){
        return ResponseEntity.ok(AnimalListResponse.from(animalService.getAllAnimals()));
    }
    @PostMapping("/animals")
    void add(@Valid @RequestBody AnimalRequest animalRequest){
        animalService.addAnimal(animalRequest.toAnimalDto());
    }
}