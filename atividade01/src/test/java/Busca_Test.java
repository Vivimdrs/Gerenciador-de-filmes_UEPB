import schemas.Filme;
import utils.Busca;
import interfaces.Busca_IF;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Busca_Test {

    private final Filme[] filmesOrdenados = {
        new Filme("Filme A", 4, 2010),
        new Filme("Filme B", 4, 2011),
        new Filme("Filme C", 4, 2012),
        new Filme("Filme D", 2, 2013),
        new Filme("Filme E", 2, 2014)
    };

    private final Busca_IF busca = new Busca();

    @Test
    public void testChecaVetorOrdenado() {
        assertTrue(busca.checaVetorOrdenado(filmesOrdenados));
    }

    @Test
    public void testBuscaLinearIterativa() throws Exception {
        Filme resultado = busca.BuscaLinearIterativa(filmesOrdenados, 2);
        assertNotNull(resultado);
        assertEquals("Filme D", resultado.getNome());
    }
    
    @Test
    public void testBuscaLinearRecursiva() throws Exception {
        Filme resultado = busca.BuscaLinearIterativa(filmesOrdenados, 2);
        assertNotNull(resultado);
        assertEquals("Filme D", resultado.getNome());
    }
    
    @Test
    public void testBuscaBinariaIterativa() throws Exception {
        Filme resultado = busca.BuscaBinariaIterativa(filmesOrdenados, 4);
        assertNotNull(resultado);
        assertEquals("Filme C", resultado.getNome());
    }

    @Test
    public void testBuscaBinariaRecursiva() throws Exception {
        Filme resultado = busca.BuscaBinariaRecursiva(filmesOrdenados, 4);
        assertNotNull(resultado);
        assertEquals("Filme C", resultado.getNome());
    }

    @Test
    public void testBuscaLinearIterativa2Pontas() throws Exception {
        Filme resultado = busca.BuscaLinearIterativa(filmesOrdenados, 2);
        assertNotNull(resultado);
        assertEquals("Filme E", resultado.getNome());
    }
    
    @Test
    public void testBuscaLinearIterativa_semNota() throws Exception {
    	assertNull(busca.BuscaLinearIterativa(filmesOrdenados, 5));
    }
    
    @Test
    public void testBuscaLinearRecursiva_semNota() throws Exception {
    	assertNull(busca.BuscaLinearIterativa(filmesOrdenados, 5));
    }
    
    @Test
    public void testBuscaBinariaIterativa_semNota() throws Exception {
    	assertNull(busca.BuscaBinariaIterativa(filmesOrdenados, 5));
    }

    @Test
    public void testBuscaBinariaRecursiva_semNota() throws Exception {
    	assertNull(busca.BuscaBinariaRecursiva(filmesOrdenados, 5));
    }

    @Test
    public void testBuscaLinearIterativa2Pontas_semNota() throws Exception {
    	assertNull(busca.BuscaLinearIterativa(filmesOrdenados, 5));
    }
    
    @Test(expected = Exception.class)
    public void testNotaNegativa_BuscaLinearIterativa() throws Exception {
    	busca.BuscaLinearIterativa(filmesOrdenados, -1);
    }
    
    @Test(expected = Exception.class)
    public void testNotaNegativa_BuscaLinearRecursiva() throws Exception {
    	busca.BuscaLinearIterativa(filmesOrdenados, -1);
    }
    
    @Test(expected = Exception.class)
    public void testNotaNegativa_BuscaBinariaIterativa() throws Exception {
    	busca.BuscaBinariaIterativa(filmesOrdenados, -1);
    }
    
    @Test(expected = Exception.class)
    public void testNotaNegativa_BuscaBinariaRecursiva() throws Exception {
    	busca.BuscaBinariaRecursiva(filmesOrdenados, -1);
    }
    
    @Test(expected = Exception.class)
    public void testNotaNegativa_BuscaLinearIterativa2Pontas() throws Exception {
    	busca.BuscaLinearIterativa(filmesOrdenados, -1);
    }
}