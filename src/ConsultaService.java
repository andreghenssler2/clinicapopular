import java.util.HashMap;
import java.util.Map;

public class ConsultaService {

    private Map<String, Paciente> pacientes = new HashMap<>();

    public void agendarConsulta(String cpf, String nome, String dataHora) {
        Paciente paciente = pacientes.get(cpf);
        if (paciente == null) {
            paciente = new Paciente(nome, cpf);
            pacientes.put(cpf, paciente);
        }
        Consulta consulta = new Consulta(dataHora);
        paciente.adicionarConsulta(consulta);
    }

    public Paciente buscarPacientePorCpf(String cpf) {
        return pacientes.get(cpf);
    }
}
