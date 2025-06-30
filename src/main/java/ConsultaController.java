// === ConsultaController.java (Spring Boot) ===
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class ConsultaController {

    private Map<String, Paciente> pacientes = new HashMap<>();

    @PostMapping("/consultas")
    public String agendarConsulta(@RequestParam String nome,
                                  @RequestParam String cpf,
                                  @RequestParam String dataHora) {
        Paciente paciente = pacientes.get(cpf);
        if (paciente == null) {
            paciente = new Paciente(nome, cpf);
            pacientes.put(cpf, paciente);
        }
        paciente.adicionarConsulta(new Consulta(dataHora));

        return "Consulta marcada para " + paciente.getNome() + " (CPF: " + paciente.getCpf() + ")";
    }

    @GetMapping("/consultas/{cpf}")
    public List<Consulta> listarConsultas(@PathVariable String cpf) {
        Paciente paciente = pacientes.get(cpf);
        if (paciente != null) {
            return paciente.getConsultas();
        }
        return Collections.emptyList();
    }
}