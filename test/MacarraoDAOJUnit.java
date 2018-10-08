import dao.MacarraoDAO;
import bean.Macarrao;
import database.Conexao;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Alunos
 */
public class MacarraoDAOJUnit {
    
    @Test
    public void testarCadastro(){
        Macarrao nissin = new Macarrao();
        nissin.setMarca("Nissin");
        nissin.setPeso(100);
        nissin.setAldente(false);
        nissin.setTipo("Na hora");

        int identificador = new MacarraoDAO()
                .cadastrar(nissin);
        
        assertNotSame(identificador, -1);
        
        Macarrao macarraoBuscado = new MacarraoDAO()
                .obterPeloId(identificador);
        // verifica se o que foi guardado em um objeto java
        // foi o que realmente foi armazenado no banco, ou seja
        // consistir se as informações forem iguais
        assertEquals(nissin.getMarca(), macarraoBuscado.getMarca());
        assertEquals(nissin.getPeso(), macarraoBuscado.getPeso(),0);
        assertEquals(nissin.isAldente(), macarraoBuscado.isAldente());
        assertEquals(nissin.getTipo(), macarraoBuscado.getTipo());
        
    }
    
    @Test
    public void testarEditar(){
        Macarrao magali = new Macarrao();
        magali.setMarca("Magali");
        magali.setPeso(100);
        magali.setAldente(true);
        magali.setTipo("Na hora");

        int identificador = new MacarraoDAO()
                .cadastrar(magali);
        magali.setId(identificador);
        
        assertNotSame(identificador, -1);
        
        magali.setMarca("Monica");
        magali.setPeso(8001);
        magali.setAldente(false);
        magali.setTipo("Na hora");
        boolean alterado = new MacarraoDAO().alterar(magali);
        assertTrue(alterado);
        
        Macarrao macarraoBuscado = new MacarraoDAO()
                .obterPeloId(identificador);
        assertNotNull(macarraoBuscado);
        assertEquals(magali.getMarca(), macarraoBuscado.getMarca());
        assertEquals(magali.getPeso(), macarraoBuscado.getPeso(),0);
        assertEquals(magali.isAldente(), macarraoBuscado.isAldente());
        assertEquals(magali.getTipo(), macarraoBuscado.getTipo());
        
    }
    
    @Test
    public void testarExcluir(){
        Macarrao magali = new Macarrao();
        magali.setMarca("Magali");
        magali.setPeso(80);
        magali.setAldente(true);
        magali.setTipo("Na hora");
        
        int identificador = new MacarraoDAO().cadastrar(magali);
        magali.setId(identificador);
        
        boolean excluido = new MacarraoDAO().apagar(identificador);
        assertTrue(excluido);
        Macarrao macarraoBuscado = new MacarraoDAO().obterPeloId(identificador);
        assertNull(macarraoBuscado);
        
    }
     
}
