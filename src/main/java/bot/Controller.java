package bot;

import bot.cliente.Cliente;
import bot.cliente.ClienteRepository;
import bot.estados.Estado;
import bot.estados.EstadoInicial;
import bot.model.Update;
import bot.sender.Sender;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller{
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private ApplicationContext context;
    
    @Autowired
    private CervejaRepository cervejaRepository;
    
    
    public Map<Integer, Estado> estados = new HashMap<Integer, Estado>();
    private static final String BOT_ID = "374481790:AAHgscpBDG2zs4VsDbeg140VmSVZZeItPEw";
    
    
    @RequestMapping(method=RequestMethod.POST, value="/update")
    public Result ReceberUpdate(@RequestBody Update update){
        
        //TESTE
        preencheBanco();
        
        
        Cliente c = buscarCliente(update);
        
        
        
        //System.out.println("TEXTO = " + update.getMessage().getText());
        String mensagem = update.getMessage().getText();
        int user_id = update.getMessage().getFrom().getId();
        
        


        
        Estado e = estados.get(user_id);
        if (e == null){
            e = new EstadoInicial(context, c);
        }
        e.processaTexto(mensagem);
        
        estados.put(user_id, e.getProximoEstado());

        try {
            new Sender(BOT_ID).sendResponse(user_id, e.getMensagemResposta());
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new Result(e.getMensagemResposta());
    }

    private void preencheBanco() {
        Cerveja c1 = new Cerveja();
        c1.setNome("Antartica");
        c1.setValor(10);
        
        cervejaRepository.save(c1);
        
        
        Cerveja c2 = new Cerveja();
        c2.setNome("Skol");
        c2.setValor(9);
        
        cervejaRepository.save(c2);
        
        
        Cerveja c3 = new Cerveja();
        c3.setNome("Bohemia");
        c3.setValor(13);
        
        cervejaRepository.save(c3);
        
        
        
        
    }

    private Cliente buscarCliente(Update update) {
        
        Integer idCliente = update.getMessage().getFrom().getId();
        
        Cliente c = clienteRepository.findOne(idCliente);
        
        if(c == null){
            Cliente novo = new Cliente();
            novo.setFirst_name(update.getMessage().getFrom().getFirst_name());
            novo.setLast_name(update.getMessage().getFrom().getLast_name());
            novo.setId(idCliente);
            novo.setStatus("Baby");
            
            c = clienteRepository.save(novo);
        }
        
        
        //Teste apagar iusso
        for(Cliente cli : clienteRepository.findAll()){
            System.out.println("Cli:" + cli.first_name + " " + cli.id + "  status:" + cli.getStatus());
        }
        
        
        return c;
        
    }
}