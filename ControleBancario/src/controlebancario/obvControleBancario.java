/*
  Objeto Valor
*/
package controlebancario;

public class obvControleBancario {
  
  private String numeroConta;
  private String nomeCliente;
  private boolean contaComum;
  private boolean contaEspecial;
  private boolean contaPoupanca;
  private String limite;
  private String saldo;

  public String getNumeroConta() {
    return numeroConta;
  }
  public void setNumeroConta(String numeroConta) {
    this.numeroConta = numeroConta;
  }
  public String getNomeCliente() {
    return nomeCliente;
  }
  public void setNomeCliente(String nomeCliente) {
    this.nomeCliente = nomeCliente;
  }
  public boolean isContaComum() {
    return contaComum;
  }
  public void setContaComum(boolean contaComum) {
    this.contaComum = contaComum;
  }
  public boolean isContaEspecial() {
    return contaEspecial;
  }
  public void setContaEspecial(boolean contaEspecial) {
    this.contaEspecial = contaEspecial;
  }
  public boolean isContaPoupanca() {
    return contaPoupanca;
  }
  public void setContaPoupanca(boolean contaPoupanca) {
    this.contaPoupanca = contaPoupanca;
  }
  public String getLimite() {
    return limite;
  }
  public void setLimite(String limite) {
    this.limite = limite;
  }
  public String getSaldo() {
    return saldo;
  }
  public void setSaldo(String saldo) {
    this.saldo = saldo;
  }
  
  public void iniciarObjetoValor () {
    this.numeroConta = "0";
    this.numeroConta = "0";
    this.nomeCliente = "0";
    this.contaComum = false;
    this.contaEspecial = false;
    this.contaPoupanca = false;
    this.limite = "0";
    this.saldo = "0";
  }
  
}
