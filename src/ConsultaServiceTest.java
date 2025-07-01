import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConsultaServiceTest {

    @Test
    public void deveCriarPacienteEAgendarConsulta() {
        // Cria o serviço
        ConsultaService service = new ConsultaService();

        // Agenda uma consulta
        service.agendarConsulta("12345678900", "João", "2025-07-01 10:00");

        // Busca o paciente pelo CPF
        Paciente paciente = service.buscarPacientePorCpf("12345678900");

        // Valida se o paciente foi criado
        assertNotNull(paciente);
        assertEquals("João", paciente.getNome());
        assertEquals("12345678900", paciente.getCpf());

        // Valida se a consulta foi adicionada corretamente
        assertEquals(1, paciente.getConsultas().size());
        assertEquals("2025-07-01 10:00", paciente.getConsultas().get(0).getDataHora());
    }
}
