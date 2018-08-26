package SDA.FinalProject.controller;

import SDA.FinalProject.model.Carrier;
import SDA.FinalProject.service.CarrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/carriers")
public class CarrierController {

    @Autowired
    private CarrierService carrierService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carrier createCarrier(@RequestBody @Valid Carrier carrier) {
        return carrierService.create(carrier);
    }

//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public List<Carrier> searchCarriers (@RequestParam(value = "name", required = false) String name){
//        return carrierService.search(name);
//    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Carrier getCarrierById(@PathVariable Long id) {
        return carrierService.getOneById(id);
    }

    @GetMapping("/allCarriers")
    @ResponseStatus(HttpStatus.OK)
    public List<Carrier> getAllCarriers() {
        return carrierService.getAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCarrier(@PathVariable Long id) {
        carrierService.deleteById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Carrier updateCarrier(@RequestBody @Valid Carrier carrier, @PathVariable Long id) {
        return carrierService.updateById(carrier, id);
    }
}
