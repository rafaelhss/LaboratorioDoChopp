package bot.estados;

import bot.dao.CervejaDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class EstadoQuantidadeCervejas extends Estado{
    
    private String cerveja;
    
    public EstadoQuantidadeCervejas(String escolhida){
        cerveja = escolhida;
    }
    @Autowired
    private CervejaDAO cervejaDAO;
    
    
    @Override
    public void processaTexto(String texto) {
                
        List<String> opcoes = cervejaDAO.recuperaOpcoesCervejas();
        
        try{
            int quantidade = Integer.parseInt(texto.trim());
            
            if(quantidade == 1){
                mensagemResposta = "Certo, " + quantidade + " " + cerveja + " geladinha saindo!" + System.lineSeparator() + 
                                   "Posso confirmar ou deseja pedir algo a mais?" + System.lineSeparator() +
                                   "1 - Quero pedir algo a mais!" + System.lineSeparator() +
                                   "2 - Pode confirmar o pedido!";
                proximoEstado = null; //Provisório, falta implementar o estado "EstadoConfirma"
            //  proximoEstado = new EstadoConfirma(); //Precisa confirmar a cerveja ou um unico estado de confirmacao geral?
            }else if(quantidade > 1 && quantidade <= 20){
                mensagemResposta = "Certo, " + quantidade + " " + cerveja + "s geladinhas saindo!" + System.lineSeparator() + 
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
                mensagemResposta = "Não entendi a quantidade." + System.lineSeparator() + 
                                   "Por favor, tente de novo.";
                proximoEstado = this;
            }
        }catch (Exception e){
            mensagemResposta = "Por favor, escolha uma opção válida!";
            proximoEstado = this;
        }
     
    }
    
}
