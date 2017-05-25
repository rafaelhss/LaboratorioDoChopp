package bot.estados;

import org.springframework.context.ApplicationContext;

//TODO verificar se essa classe eh mesmo usada
public class EstadoConfirma extends Estado{

    public EstadoConfirma(ApplicationContext context) {
        super(context);
    }

    @Override
    public void processaTexto(String texto) {
        
    }
    
}
