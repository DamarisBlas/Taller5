import org.example.Elevator;
import org.example.Person;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class ElevatorTest {


    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void personaDeberiaEstarEnPisoAleatorio() {
        Person persona = new Person();
        int pisoOrigen = persona.getPisoOrigen();

        assertTrue(pisoOrigen >= 1 && pisoOrigen <= 3);
    }

    @Test
    public void personaDeberiaTenerPisoDestinoDistinto() {
        Person persona = new Person();
        int pisoOrigen = persona.getPisoOrigen();
        int pisoDestino = persona.getPisoDestino();

        assertNotEquals(pisoOrigen, pisoDestino);
    }

    @Test
    public void ascensorDeberiaEstarEnPrimerPisoInicialmente() {
        Elevator ascensor = new Elevator();
        assertEquals(1, ascensor.getPisoActual());
    }

    @Test
    public void ascensorDeberiaResponderALaLlamada() {
        Elevator ascensor = new Elevator();
        Person persona = new Person();
        int pisoOrigen = persona.getPisoOrigen();

        ascensor.llamarAscensor(pisoOrigen);

        assertTrue(ascensor.isEnMovimiento());
        assertEquals(pisoOrigen, ascensor.getPisoDestino());
    }

    @Test
    public void ascensorDeberiaRecogerYTransportarPersona() {
        Elevator ascensor = new Elevator();
        Person persona = new Person();
        int pisoOrigen = persona.getPisoOrigen();
        int pisoDestino = persona.getPisoDestino();

        ascensor.llamarAscensor(pisoOrigen);
        ascensor.recogerPersona(pisoDestino);

        assertTrue(ascensor.isLleno());
        assertEquals(pisoDestino, ascensor.getPisoDestino());
    }

    @Test
    public void ascensorDeberiaDejarPersonaYCambiarDeDestino() {
        Elevator ascensor = new Elevator();
        Person persona = new Person();
        int pisoDestino = persona.getPisoDestino();

        ascensor.llamarAscensor(pisoDestino);
        ascensor.recogerPersona(pisoDestino);
        ascensor.dejarPersona();

        assertFalse(ascensor.isLleno());
        assertEquals(pisoDestino, ascensor.getPisoActual());
    }
}
