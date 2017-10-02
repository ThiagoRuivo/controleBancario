/*
Controller para validar os dados
*/
package controlebancario;

import java.util.Random;
import javax.swing.JOptionPane;
import java.util.regex.Pattern;

public class ctrlControleBancario {
  
  public final String expReularDigitos = "^[0-9]*[.]{0,1}[0-9]*$";
  private boolean validos[];
  private ControleBancario meuControleBancario;
  private obvControleBancario objValor;
  private servControleBancario meuService;
  private int sequenciaContas;
  private int opcaoOperacaoValor;
  
  /*
      Espaço para gets e sets;
  */
  public ControleBancario getMeuControleBancario() {
    return meuControleBancario;
  }
  public void setMeuControleBancario(ControleBancario meuControleBancario) {
    this.meuControleBancario = meuControleBancario;
  }
  public void setObjValor (obvControleBancario novoObjValor) {
    this.objValor = novoObjValor;
  }
  public obvControleBancario getObjValor () {
    return this.objValor;
  }
  public void setSequenciaContas (int valor) {
    this.sequenciaContas = valor;
  }
  public int getSequenciaContas () {
    return this.sequenciaContas;
  }
  public void setServControleBancario (servControleBancario novoServiceControleBancario) {
    this.meuService = novoServiceControleBancario;
  }
  public servControleBancario getServControleBancario () {
    return this.meuService;
  }
  
  public void iniciarControleBancario () {
    this.meuControleBancario.centralizarJanela();
    this.meuControleBancario.removerTodosItensCombo();
    this.meuControleBancario.switchBotoesInferior(false, false, false, false, false);
    this.meuControleBancario.switchBotoesSuperior(true, true, false);
    this.meuControleBancario.setDisponivelCampos(false, false, false, false);
    this.meuControleBancario.setDisponivelContas(false, false, false);
    this.meuControleBancario.setVisivelVerificarCampos(false, false, false, false);
    this.meuControleBancario.setGrupoInformarQuantia(false, false, false, false, false);
    this.meuControleBancario.setLblNumeroClientes(Integer.toString(sequenciaContas - 1));
  }
  
  /*
      Eventos de botão da tela
  */
  public void btnSair () {
    System.exit(0);
  }
  
  public void cboCliente () {
    if (this.meuControleBancario.getIndexItemSelecionado() >= 0) {
      this.meuControleBancario.switchBotoesInferior(true, true, false, true, false);
      carregarDadosClienteSelecionado();
    }
  }
  
  public void btnNovo () {
    btnLimpar();
    this.meuControleBancario.switchBotoesSuperior(false, false, true);
    this.meuControleBancario.switchBotoesInferior(false, false, true, true, true);
    this.meuControleBancario.setDisponivelCampos(false, true, true, true);
    this.meuControleBancario.getTxtNome().requestFocus();
    this.meuControleBancario.setDisponivelCombo(false);
    this.meuControleBancario.setDisponivelContas(true, true, true);
    this.meuControleBancario.setTxtConta(gerarNumeroConta());
  }
  
  public void btnLimpar () {
    this.meuControleBancario.setTxtLimite("");
    this.meuControleBancario.setTxtSaldo("");
    this.meuControleBancario.setTxtnome("");
    this.meuControleBancario.getTxtNome().requestFocus();
  }
  
  public void btnCancelar () {
    btnLimpar();
    this.meuControleBancario.setTxtConta("");
    this.meuControleBancario.setTxtValor("");
    this.meuControleBancario.switchBotoesSuperior(true, true, false);
    this.meuControleBancario.switchBotoesInferior(false, false, false, false, false);
    this.meuControleBancario.setDisponivelCampos(false, false, false, false);
    this.meuControleBancario.setDisponivelCombo(true);
    this.meuControleBancario.setDisponivelContas(false, false, false);
    this.meuControleBancario.setVisivelVerificarCampos(false, false, false, false);
    this.meuControleBancario.setGrupoInformarQuantia(false, false, false, false, false);
  }
  
  public void btnGravar () {
    if (validarObjetoValor()) {
      obvControleBancario novoObjetoValor = new obvControleBancario();
      novoObjetoValor= this.objValor;
      this.meuService.setObjetoValorBanco(novoObjetoValor);
      this.meuService.adicionarObjetoValor();
      adicionarNomeClientes();
      
      //this.meuControleBancario.getCboSelecionar().addItem(this.meuControleBancario.getTxtnome());
      this.sequenciaContas++;
      this.meuControleBancario.setLblNumeroClientes(Integer.toString(sequenciaContas - 1));
      btnCancelar();
    } else {
      JOptionPane.showMessageDialog(null, "Valores informados não são válidos");
      this.meuControleBancario.setVisivelVerificarCampos(!validos[0], !validos[1], !validos[2], !validos[3]);
    }
  }
  
  public void btnDepositar () {
    this.meuControleBancario.setGrupoInformarQuantia(false, true, true, true, true);
    this.meuControleBancario.switchBotoesSuperior(true, true, true);
    this.meuControleBancario.getTxtValorObjeto().requestFocus();
    this.opcaoOperacaoValor = 0;
  }
  
  public void btnSaquar () {
    this.meuControleBancario.setGrupoInformarQuantia(false, true, true, true, true);
    this.meuControleBancario.switchBotoesSuperior(true, true, true);
    this.meuControleBancario.getTxtValorObjeto().requestFocus();
    this.opcaoOperacaoValor = 1;
  }
  
  public void btnOkay () {
    if (verificarCampoValor()) {
      operacaoValores(this.opcaoOperacaoValor);
      this.meuControleBancario.setTxtValor("");
      this.meuControleBancario.setGrupoInformarQuantia(false, false, false, false, false);
      this.meuControleBancario.switchBotoesSuperior(true, true, false);
    }
  }
  
  public void btnExcluir () {
    int index = this.meuControleBancario.getIndexItemSelecionado();
    if (index >= 0) {
      this.meuService.removerCliente(index);
      adicionarNomeClientes();
      this.sequenciaContas--;
      this.meuControleBancario.setLblNumeroClientes(Integer.toString(sequenciaContas - 1));
      this.meuControleBancario.setTxtConta("");
      this.meuControleBancario.setTxtnome("");
      this.meuControleBancario.setTxtSaldo("");
      this.meuControleBancario.setTxtLimite("");
    }
  }
  
  /*
      Demais funcionalidades do sistema
  */
  public int gerarNumeroAleatorio (int limInf, int limSup) {
    Random gerador = new Random();
    return gerador.nextInt((limSup - limInf) + 1) + limInf;
  }
  public String gerarNumeroConta () {
    return String.format("%d - %d", gerarNumeroAleatorio(10000, 99999), this.sequenciaContas);
  }
  public boolean validarObjetoValor () {
    boolean novoVetor[] = new boolean[4];
    this.validos = novoVetor;
    for (int i = 0; i < this.validos.length; i++) {
      boolean novo = false;
      this.validos[i] = novo;
    }
    if ("".equals(this.objValor.getNomeCliente())) {
      this.validos[0] = false;
    } else if (Pattern.matches(expReularDigitos, this.objValor.getNomeCliente())){
      validos[0] = false;
    } else {
      validos[0] = true;
    }
    
    if (this.objValor.isContaComum() || this.objValor.isContaEspecial() || this.objValor.isContaPoupanca()) {
      validos[1] = true;
    } else {
      validos[1] = false;
    }
    
    if ("".equals(this.objValor.getLimite())) {
      validos[2] = false;
    } else if (!Pattern.matches(expReularDigitos, this.objValor.getLimite())){
      validos[2] = false;
    } else {
      validos[2] = true;
    }
    
    if ("".equals(this.objValor.getSaldo())) {
      validos[3] = false;
    } else if (!Pattern.matches(expReularDigitos, this.objValor.getSaldo())){
      validos[3] = false;
    } else {
      validos[3] = true;
    }
    
    for (int i = 0; i < validos.length; i++) {
      if (!validos[i]) {
        return false;
      }
    }
    return true;
  }
  
  public void adicionarNomeClientes () {
    String nomes[] = meuService.obterVetorNomes();
    this.meuControleBancario.removerTodosItensCombo();
    for (int i = 0; i < nomes.length; i++) {
      this.meuControleBancario.getCboSelecionar().addItem(nomes[i]);
    }
  }
  
  public int getIndexNomeSeleionado () {
    return this.meuControleBancario.getCboSelecionar().getSelectedIndex();
  }
  
  public void carregarDadosClienteSelecionado () {
    obvControleBancario objetoValorRetornado = new obvControleBancario();
    int index = 0;
    index = getIndexNomeSeleionado();
    objetoValorRetornado = this.meuService.obterClienteSelecionado(index);
    this.meuControleBancario.setTxtConta(objetoValorRetornado.getNumeroConta());
    this.meuControleBancario.setTxtnome(objetoValorRetornado.getNomeCliente());
    this.meuControleBancario.setTxtLimite(objetoValorRetornado.getLimite());
    this.meuControleBancario.setTxtSaldo(objetoValorRetornado.getSaldo());
    if (objetoValorRetornado.isContaComum()) {
      this.meuControleBancario.setRbtContaComum(true);
    } else if (objetoValorRetornado.isContaEspecial()) {
      this.meuControleBancario.setRbtContaEspecial(true);
    } else {
      this.meuControleBancario.setRbtContaPoupanca(true);
    }
  }
  
  public boolean verificarCampoValor () {
    boolean valido = false;
    if ("".equals(this.meuControleBancario.getTxtValorObjeto().getText())) {
      valido = false;
      this.meuControleBancario.setVisivelVerificarQuantia(true);
    } else if (!Pattern.matches(expReularDigitos, this.meuControleBancario.getTxtValorObjeto().getText())){
      valido = false;
      this.meuControleBancario.setVisivelVerificarQuantia(true);
    } else {
      valido = true;
      this.meuControleBancario.setVisivelVerificarQuantia(false);
    }
    return valido;
  }
  
  public void operacaoValores (int opcao) {
    int index;
    double valor, saldo, limite;
    index = this.meuControleBancario.getIndexItemSelecionado();
    valor = Double.parseDouble(this.meuControleBancario.getTxtValor());
    saldo = Double.parseDouble(this.meuService.obterSaldoConta(index));
    limite = Double.parseDouble(this.meuService.obterLimiteConta(index));
    if (opcao == 0) {
      // depositar
      saldo = saldo + valor;
      this.meuService.setNovoValorSaldo(index, Double.toString(saldo));
    } else if (opcao == 1) {
      //sacar
      if ((saldo + limite) >= valor) {
        saldo = saldo - valor;
        this.meuService.setNovoValorSaldo(index, Double.toString(saldo));
      } else {
        JOptionPane.showMessageDialog(null, "Saque não pode ser realizado");
      }
    }
    this.meuControleBancario.setTxtSaldo(this.meuService.obterSaldoConta(index));
  }
}
