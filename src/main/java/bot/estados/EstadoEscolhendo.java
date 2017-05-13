package bot.estados;

import bot.dao.EspetinhoDAO;
import bot.dao.PorcoesDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoEscolhendo extends Estado {

    @Autowired
    private EstadoBebidas estadoBebidas;
    
    
    @Override
    public void processaTexto(String texto) {
        if(texto.trim().equals("1")){
            mensagemResposta = "BEBIDAS" + System.lineSeparator() + 
                               "Certo, temos no cardápio:" + System.lineSeparator() +
                               "1 - CERVEJAS," + System.lineSeparator() +
                               "2 - DRINKS," + System.lineSeparator() +
                               "3 - REFRIGERANTES," + System.lineSeparator() +
                               "4 - SUCOS" + System.lineSeparator() +
                               "5 - AGUA";
            proximoEstado = estadoBebidas;
            
        } else if(texto.trim().equals("2")){
            List<String> opcoes = new EspetinhoDAO().recuperaOpcoesEspetinhos();
            mensagemResposta = "Legal, temos:";
            
            for(int i=0; i < opcoes.size() ; i++){
                mensagemResposta += System.lineSeparator() + (i+1) + " - " + opcoes.get(i);
            }            
            proximoEstado = new EstadoEspetinho();
            
        } else if(texto.trim().equals("3")){
            List<String> opcoes = new PorcoesDAO().recuperaOpcoesPorcoes();
            mensagemResposta = "Legal, temos as porções de:";
            
            for(int i=0; i < opcoes.size() ; i++){
                mensagemResposta += System.lineSeparator() + (i+1) + " - " + opcoes.get(i);
            }            
            proximoEstado = new EstadoPorcoes();
            
        } else {
            mensagemResposta = "Por favor, escolha as opções entre 1, 2 ou 3!";
            proximoEstado = this;
        }
    }
    
}
