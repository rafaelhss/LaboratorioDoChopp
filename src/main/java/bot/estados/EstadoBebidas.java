package bot.estados;

import bot.CervejaRepository;
import bot.dao.CervejaDAO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class EstadoBebidas extends Estado{

    
    private CervejaDAO cervejaDAO = new CervejaDAO(context);
    

  

    public EstadoBebidas(ApplicationContext context) {
        super(context);
    }
    
    @Override
    public void processaTexto(String texto) {
       
        if(texto.trim().equals("1")){  
            
            List<String> opcoes = cervejaDAO.recuperaOpcoesCervejas();
            mensagemResposta = "Legal, temos as cervejas:";
            
            for(int i=0; i < opcoes.size() ; i++){
                mensagemResposta += System.lineSeparator() + (i+1) + " - " + opcoes.get(i);
            }            
            proximoEstado = new EstadoCervejas(context);
            
        } else if(texto.trim().equals("2")){
            mensagemResposta = "Desculpe, não temos drinks no momento!" + System.lineSeparator() +
                               "Escolha outra coisa!";
            proximoEstado = this;
            
        }else if(texto.trim().equals("3")){
            mensagemResposta = "Desculpe, não temos refrigerantes no momento!" + System.lineSeparator() +
                               "Escolha outra coisa!";
            proximoEstado = this;
            
        }else if(texto.trim().equals("4")){
            mensagemResposta = "Desculpe, não temos sucos no momento!" + System.lineSeparator() +
                               "Escolha outra coisa!";
            proximoEstado = this;
            
        }else if(texto.trim().equals("5")){
            mensagemResposta = "Desculpe, não temos agua no momento!" + System.lineSeparator() +
                               "Escolha outra coisa!";
            proximoEstado = this;
            
        } else {
            mensagemResposta = "Por favor, escolha uma opção válida!";
            proximoEstado = this;
            
        }
    }


    
}
