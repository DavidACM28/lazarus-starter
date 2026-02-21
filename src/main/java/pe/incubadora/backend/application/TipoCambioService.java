package pe.incubadora.backend.application;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import pe.incubadora.backend.api.TipoCambioResponse;

import java.time.LocalDate;
import java.util.Map;

@Service
public class TipoCambioService {
    Map<LocalDate, TipoCambioResponse> mapa() {
        return Map.of(
            LocalDate.of(2026, 2, 15), new TipoCambioResponse("15/02/2026", "SUNAT", 3.358d, 3.348d),
            LocalDate.of(2026, 2, 16), new TipoCambioResponse("16/02/2026", "SUNAT", 3.358d, 3.348d),
            LocalDate.of(2026, 2, 17), new TipoCambioResponse("17/02/2026", "SUNAT", 3.356d, 3.344d),
            LocalDate.of(2026, 2, 18), new TipoCambioResponse("18/02/2026", "SUNAT", 3.358d, 3.358d),
            LocalDate.of(2026, 2, 19), new TipoCambioResponse("19/02/2026", "SBS", 3.366d, 3.36d),
            LocalDate.of(2026, 2, 20), new TipoCambioResponse("20/02/2026", "SBS", 3.36d, 3.353d));
    }

    public TipoCambioResponse getByFecha(String fecha) {
        return mapa().get(LocalDate.parse(fecha));
    }
}
