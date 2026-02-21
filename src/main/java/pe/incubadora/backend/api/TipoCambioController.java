package pe.incubadora.backend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.incubadora.backend.application.TipoCambioService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class TipoCambioController {

    @Autowired
    private TipoCambioService tipoCambioService;

    @GetMapping("tipo-cambio/{fecha}")
    public ResponseEntity<Object> getTipoCambioByFecha(@PathVariable String fecha) {
        try{
            LocalDate.parse(fecha);

        }catch(DateTimeParseException e){
            Map<String, String> data = new HashMap<>();
            data.put("code", "VALIDATION_ERROR");
            data.put("message", "Fecha inválida. Use formato yyyy-MM-dd");
            return new ResponseEntity<>(data ,HttpStatus.BAD_REQUEST);
        }
        if(tipoCambioService.getByFecha(fecha) == null){
            Map<String, String> data = new HashMap<>();
            data.put("code", "TC_NOT_FOUND");
            data.put("message", "No existe tipo de cambio para la fecha " + fecha);
            return new ResponseEntity<>(data ,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tipoCambioService.getByFecha(fecha) , HttpStatus.OK);
    }

}
