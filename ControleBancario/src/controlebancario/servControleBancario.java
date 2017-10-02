/*
Serviço de permanencia dos dados no banco
*/
package controlebancario;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class servControleBancario {
  
  private ArrayList <obvControleBancario> vetorObjetos;
  private obvControleBancario objetoValorBanco;

  public ArrayList <obvControleBancario> getVetorObetos() {
    return vetorObjetos;
  }
  public void setVetorObetos(ArrayList <obvControleBancario> vetorObetos) {
    this.vetorObjetos = vetorObetos;
  }
  public obvControleBancario getObjetoValorBanco() {
    return objetoValorBanco;
  }
  public void setObjetoValorBanco(obvControleBancario objetoValorBanco) {
    this.objetoValorBanco = objetoValorBanco;
  }
  
  public void adicionarObjetoValor () {
    vetorObjetos.add(this.objetoValorBanco);
  }
  
  public String[] obterVetorNomes () {
    String vetorNomes[] = new String[this.vetorObjetos.size()];
    for (int i = 0; i < this.vetorObjetos.size(); i++) {
      vetorNomes[i] = this.vetorObjetos.get(i).getNomeCliente();
    }
    return vetorNomes;
  }
  
  public obvControleBancario obterClienteSelecionado (int index) {
    return this.vetorObjetos.get(index);
  }
  
  public String obterSaldoConta (int index) {
    return this.vetorObjetos.get(index).getSaldo();
  }
  
  public String obterLimiteConta (int index) {
    return this.vetorObjetos.get(index).getLimite();
  }
  
  public void setNovoValorSaldo (int index, String valor) {
    this.vetorObjetos.get(index).setSaldo(valor);
  }
  
  public void removerCliente(int index) {
    this.vetorObjetos.remove(index);
  }
  
}
