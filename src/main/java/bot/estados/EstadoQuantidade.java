package bot.estados;

import bot.dao.CervejaDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class EstadoQuantidade extends Estado{
    
    private String item;
    
    public EstadoQuantidade(String escolhido, ApplicationContext context){
        super(context);
        item = escolhido;
    }

   private CervejaDAO cervejaDAO = new CervejaDAO(context);
    
    @Override
    public void processaTexto(String texto) {
                
        List<String> opcoes = cervejaDAO.recuperaOpcoesCervejas();
        
        try{
            int quantidade = Integer.parseInt(texto.trim());
            
            if(quantidade == 1){
                mensagemResposta = "Anotei! " + quantidade + " unidade de " + item + " saindo!" + System.lineSeparator() + 
                                   "Posso confirmar ou deseja pedir algo a mais?" + System.lineSeparator() +
                                   "1 - Quero pedir algo a mais!" + System.lineSeparator() +
                                   "2 - Pode confirmar o pedido!";
                proximoEstado = null; //Provisório, falta implementar o estado "EstadoConfirma"
            //  proximoEstado = new EstadoConfirma(); //Precisa confirmar a cerveja ou um unico estado de confirmacao geral?
            }else if(quantidade > 1 && quantidade <= 20){
                mensagemResposta = "Anotei! " + quantidade + " unidades de " + item + " saindo!" + System.lineSeparator() + 
                                   "Posso confirmar ou deseja pedir algo a mais?" + System.lineSeparator() +
                                   "1 - Quero pedir algo a mais!" + System.lineSeparator() +
                                   "2 - Pode confirmar o pedido!";
                proximoEstado = null; //Provisório, falta implementar o estado "EstadoConfirma"
            //  proximoEstado = new EstadoConfirma(); //Precisa confirmar a cerveja ou um unico estado de confirmacao geral?
            }else if(quantidade > 20){
                mensagemResposta = "Desculpe, só posso trazer no máximo 20 unidades deste pedido!" + System.lineSeparator() +
                                   "Por favor, tente uma quantidade menor.";
                proximoEstado = this;
            }else{
                mensagemResposta = "Vamos lá, preciso de um número." + System.lineSeparator() + 
                                   "Por favor, tente de novo.";
                proximoEstado = this;
            }
        }catch (Exception e){
            mensagemResposta = "Por favor, escolha uma opção válida!";
            proximoEstado = this;
        }
     
    }
    
}
