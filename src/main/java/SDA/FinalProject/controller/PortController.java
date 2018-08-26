package SDA.FinalProject.controller;

import SDA.FinalProject.model.Port;
import SDA.FinalProject.service.PortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ports")
public class PortController {

    @Autowired
    private PortService portService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Port createPort (@RequestBody @Valid Port port){
        return portService.create(port);
    }

//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public List<Port> searchPorts (@RequestParam(value = "name", required = false) String name){
//        return portService.search(name);
//    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Port getPortById (@PathVariable Long id){
        return portService.getById(id);
    }

    @GetMapping("/allPorts")
    @ResponseStatus(HttpStatus.OK)
    public List<Port> getAllPorts (){
        return portService.getAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePortById (@PathVariable Long id){
        portService.deleteById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Port updatePortById (@RequestBody @Valid Port port, @PathVariable Long id){
        port.setId(id);
        return portService.updateById(port, id);
    }
}
