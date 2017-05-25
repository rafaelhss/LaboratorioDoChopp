package bot.estados;

import bot.dao.CervejaDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

//TODO verificar se essa classe eh mesmo usada
class EstadoBebidasCervejas extends Estado {
    @Autowired
    private CervejaDAO cervejaDAO;

    public EstadoBebidasCervejas(ApplicationContext context) {
        super(context);
    }
    

    @Override
    public void processaTexto(String texto) {
        
        List<String> opcoes = cervejaDAO.recuperaOpcoesCervejas();
        
        try{
            int opcao = Integer.parseInt(texto);
            mensagemResposta = "legal, voce escolheu: " + opcoes.get(opcao);
        } catch (Exception e){
            mensagemResposta = "Escolha um numero, bro!";
            proximoEstado = this;
        }
        
    }
    
}
