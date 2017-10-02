
package controlebancario;

import java.util.ArrayList;

public class mainControleBancario {
  
  public static void main(String args[]) {
    ControleBancario frmControle = new ControleBancario();
    ctrlControleBancario novoControle = new ctrlControleBancario();
    servControleBancario novoService = new servControleBancario();
    
    novoControle.setSequenciaContas(1);
    frmControle.setController(novoControle);
    
    ArrayList <obvControleBancario> novaListaObjetos = new ArrayList <obvControleBancario>();
    novoService.setVetorObetos(novaListaObjetos);
    
    novoControle.setServControleBancario(novoService);
    novoControle.setMeuControleBancario(frmControle);
    novoControle.iniciarControleBancario();
    
    frmControle.setVisible(true);
  }

}
