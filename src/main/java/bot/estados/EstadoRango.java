package bot.estados;

import org.springframework.context.ApplicationContext;

class EstadoRango extends Estado {

    public EstadoRango(ApplicationContext context) {
        super(context);
    }

    @Override
    public void processaTexto(String texto) {
        mensagemResposta = "Legal, vc esta com fome!!";
        proximoEstado = this;
    }  
    
}
