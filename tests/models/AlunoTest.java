package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * Cria uma classe de teste para aluno.
 * @author Marta Lais de Macedo Dantas.
 *
 */

public class AlunoTest {
	private Aluno aluno1;
	private Aluno aluno2;
	
	@Before
	public void setup() {
		aluno1 = new Aluno("Florence", "123123", "florence@maquina.com", "6543-2123", 14);
		aluno2 = new Aluno("Aurora", "321321", "aurora@fada.com", "1234-8765", 18);
	}
	
	@Test
	public void testaConstructor() {
		assertEquals(aluno1.getNome(), "Florence");
		assertEquals(aluno1.getMatricula(), "123123");
		assertEquals(aluno1.getEmail(), "florence@maquina.com");
		assertEquals(aluno1.getTelefone(), "6543-2123");
		assertEquals(aluno1.getCodigoCurso(), 14);
	}
	
	@Test
	public void testaNullVazioNome() {
		try {
			new Aluno(null, "123123", "florence@maquina.com", "6543-2123", 14);
			fail("aluno com nome null cadastrado");
		} catch (NullPointerException e) {
			//funcionando
		}
		
		try {
			new Aluno("   ", "123123", "florence@maquina.com", "6543-2123", 14);
			fail("aluno com nome vazio cadastrado");
		} catch (IllegalArgumentException e) {
			//funcionando
		}
	}
	
	@Test
	public void testaNullVazioMatricula() {
		try {
			new Aluno("Florence", null, "florence@maquina.com", "6543-2123", 14);
			fail("aluno com matricula null cadastrado");
		} catch (NullPointerException e) {
			//funcionando
		}
		
		try {
			new Aluno("Florence", " ", "florence@maquina.com", "6543-2123", 14);
			fail("aluno com matricula vazio cadastrado");
		} catch (IllegalArgumentException e) {
			//funcionando
		}
	}
	
	@Test
	public void testaNullVazioEmail() {
		try {
			new Aluno("Florence", "123123", null, "6543-2123", 14);
			fail("aluno com email null cadastrado");
		} catch (NullPointerException e) {
			//funcionando
		}
		
		try {
			new Aluno("Florence", "123123", " ", "6543-2123", 14);
			fail("aluno com email vazio cadastrado");
		} catch (IllegalArgumentException e) {
			//funcionando
		}
	}
	
	@Test
	public void testaInvalidoEmail() {
		//TODO
	}
	
	@Test
	public void testaNullVazioTelefone() {
		try {
			new Aluno("Florence", "123123", "florence@maquina.com", null, 14);
			fail("aluno com telefone null cadastrado");
		} catch (NullPointerException e) {
			//funcionando
		}
		
		try {
			new Aluno("Florence", "123123", "florence@maquina.com", " ", 14);
			fail("aluno com nome vazio cadastrado");
		} catch (IllegalArgumentException e) {
			//funcionando
		}
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testaCodigoNegativo() {
		new Aluno("Florence", "123123", "florence@maquina.com", "6543-2123", -23);
	}
	
	@Test
	public void testaIsTutor() {
		assertFalse(aluno1.isTutor());
		aluno1.tornaTutor("p2", 3);
		assertTrue(aluno1.isTutor());
	}
	
	@Test
	public void testaDoar() {
		aluno1.tornaTutor("p2", 3);
		aluno1.doar(6);
		assertEquals(6, aluno1.totalDinheiroTutor());
		aluno1.doar(6);
		assertEquals(12, aluno1.totalDinheiroTutor());
	}
	
	
	@Test
	public void testaDoarAluno() {
		try {
			aluno1.doar(11);
			fail("Doacao para aluno que nao eh tutor");
		} catch (Exception e) {
			//funcionando
		}
	}
	
	@Test
	public void testaDoarNulo() {
		aluno1.tornaTutor("p2", 3);
		aluno1.doar(6);
		try {
			aluno1.doar(0);
			fail("Tutor recebeu doacao nula");
		} catch (Exception e) {
			//funcionando
		}
	}
	
	@Test
	public void testaDoarNegativo() {
		aluno1.tornaTutor("p2", 3);
		aluno1.doar(6);
		try {
			aluno1.doar(-3);
			fail("Tutor recebeu doacao negativa");
		} catch (Exception e) {
			//funcionando
		}
	}
	
}