package bot.estados;

import bot.dao.CervejaDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class EstadoCervejas extends Estado {

    @Autowired
    private CervejaDAO cervejaDAO;
    
    @Override
    public void processaTexto(String texto) {
        
        List<String> opcoes = cervejaDAO.recuperaOpcoesCervejas();
        
        try{
            int opcao = Integer.parseInt(texto) - 1;
            mensagemResposta = "legal, voce escolheu a cerveja " + opcoes.get(opcao) + "." + System.lineSeparator() +
                                "Quantas deseja?";
            proximoEstado = new EstadoQuantidade(opcoes.get(opcao));
        } catch (Exception e){
            mensagemResposta = "Por favor, escolha uma opção válida!";
            proximoEstado = this;
        }
        
    }
    
}
