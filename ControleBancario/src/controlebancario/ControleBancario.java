
package controlebancario;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ControleBancario extends javax.swing.JFrame {
  
  private ctrlControleBancario controller;
  private obvControleBancario objValor;
  
  /*
      Espaço para gets e sets;
  */
  public void setController (ctrlControleBancario novoController) {
    this.controller = novoController;
  }
  public ctrlControleBancario getController () {
    return this.controller;
  }
  public void setObjValor (obvControleBancario novoObjValor) {
    this.objValor = novoObjValor;
  }
  public obvControleBancario getObjValor () {
    return this.objValor;
  }

  public ControleBancario () {
    initComponents();
    adicionarRadioBotao();
  }
  
  public final void adicionarRadioBotao () {
    buttonGroup1.add(rbtContaComum);
    buttonGroup1.add(rbtContaEspecial);
    buttonGroup1.add(rbtContaPoupança);
  }
  
  public void centralizarJanela () {
    setLocationRelativeTo(null);
  }
  public void switchBotoesSuperior (boolean consultar, boolean novo, boolean cancelar) {
    btnConsultar.setEnabled(consultar);
    btnNovo.setEnabled(novo);
    btnCancelar.setEnabled(cancelar);
  }
  public void switchBotoesInferior (boolean depositar, boolean sacar, boolean gravar, boolean excluir, boolean limpar) {
    btnDepositar.setEnabled(depositar);
    btnSacar.setEnabled(sacar);
    btnGravar.setEnabled(gravar);
    btnExcluir.setEnabled(excluir);
    btnLimpar.setEnabled(limpar);
  }
  
  public void setDisponivelCampos (boolean conta, boolean cliente, boolean limite, boolean saldo) {
    txtConta.setEnabled(conta);
    txtNomeCliente.setEnabled(cliente);
    txtLimite.setEnabled(limite);
    txtSaldo.setEnabled(saldo);
  }
  public void setEditavelCampos (boolean conta, boolean cliente, boolean limite, boolean saldo) {
    txtConta.setEditable(conta);
    txtNomeCliente.setEditable(cliente);
    txtLimite.setEditable(limite);
    txtSaldo.setEditable(saldo);
  }
  
  public void setDisponivelContas (boolean comum, boolean especial, boolean poupanca) {
    rbtContaComum.setEnabled(comum);
    rbtContaEspecial.setEnabled(especial);
    rbtContaPoupança.setEnabled(poupanca);
  }
  
  public void setVisivelVerificarCampos (boolean nome, boolean conta, boolean limite, boolean saldo) {
    lblVerificarNome.setVisible(nome);
    lblVerificarConta.setVisible(conta);
    lblVerificarLimite.setVisible(limite);
    lblVerificarSaldo.setVisible(saldo);
  }
  public void setVisivelVerificarQuantia (boolean verificar) {
    lblVerificarValor.setVisible(verificar);
  }
  
  public void setDisponivelCombo (boolean combo) {
    cboCliente.setEnabled(combo);
  }
  public void setEditavelCombo (boolean combo) {
    cboCliente.setEditable(combo);
  }
  
  public void setRbtContaComum (boolean selecionado) {
    rbtContaComum.setSelected(selecionado);
  }
  public void setRbtContaEspecial (boolean selecionado) {
    rbtContaEspecial.setSelected(selecionado);
  }
  public void setRbtContaPoupanca (boolean selecionado) {
    rbtContaPoupança.setSelected(selecionado);
  }
  
  public void setTxtConta (String valor) {
    txtConta.setText(valor);
  }
  public void setTxtnome (String nome) {
    txtNomeCliente.setText(nome);
  }
  public void setTxtLimite (String limite) {
    txtLimite.setText(limite);
  }
  public void setTxtSaldo (String saldo) {
    txtSaldo.setText(saldo);
  }
  public void setLblNumeroClientes (String valor) {
    lblNumeroClientes.setText(valor);
  }
  public void setTxtValor (String valor) {
    txtValor.setText(valor);
  }
  
  public String getTxtConta () {
    return txtConta.getText();
  }
  public String getTxtnome () {
    return txtNomeCliente.getText();
  }
  public String getTxtLimite () {
    return txtLimite.getText();
  }
  public String getTxtSaldo () {
    return txtSaldo.getText();
  }
  public String getLblNumeroClientes () {
    return lblNumeroClientes.getText();
  }
  public String getTxtValor () {
    return txtValor.getText();
  }
  
  public void removerTodosItensCombo () {
    cboCliente.removeAllItems();
  }
  public void adicionarItensCombo (String item) {
    cboCliente.addItem(item);
  }
  public void removerItemComvo (int index) {
    cboCliente.removeItemAt(index);
  }
  
  public boolean contaComumSelecionada () {
    return rbtContaComum.isSelected();
  }
  public boolean contaEspecialSelecionada () {
    return rbtContaEspecial.isSelected();
  }
  public boolean contaPoupancaSelecionada () {
    return rbtContaPoupança.isSelected();
  }
  
  public int getIndexItemSelecionado () {
    return cboCliente.getSelectedIndex();
  }
  public String getConteudoItemSelecionado () {
    return (String) cboCliente.getSelectedItem();
  }
  
  public JTextField getTxtNome () {
    return txtNomeCliente;
  }
  public JComboBox<String> getCboSelecionar () {
    return cboCliente;
  }
  public JTextField getTxtValorObjeto () {
    return txtValor;
  }
  
  public obvControleBancario criarObjetoValor () {
    obvControleBancario novoObjValor = new obvControleBancario();
    novoObjValor.iniciarObjetoValor();
    novoObjValor.setNumeroConta(txtConta.getText());
    novoObjValor.setNomeCliente(txtNomeCliente.getText());
    novoObjValor.setContaComum(rbtContaComum.isSelected());
    novoObjValor.setContaEspecial(rbtContaEspecial.isSelected());
    novoObjValor.setContaPoupanca(rbtContaPoupança.isSelected());
    novoObjValor.setLimite(txtLimite.getText());
    novoObjValor.setSaldo(txtSaldo.getText());
    return novoObjValor;
  }
  
  public void setGrupoInformarQuantia (boolean verificar, boolean texto, boolean cifrao, boolean valor, boolean okay) {
    lblVerificarValor.setVisible(verificar);
    lblInformeQuantia.setVisible(texto);
    lblCifrao.setVisible(cifrao);
    txtValor.setVisible(valor);
    btnOkay.setVisible(okay);
    lblVerificarValor.setEnabled(verificar);
    lblInformeQuantia.setEnabled(texto);
    lblCifrao.setEnabled(cifrao);
    txtValor.setEnabled(valor);
    btnOkay.setEnabled(okay);
  }
  
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jButton1 = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTextArea1 = new javax.swing.JTextArea();
    buttonGroup1 = new javax.swing.ButtonGroup();
    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    cboCliente = new javax.swing.JComboBox<>();
    btnConsultar = new javax.swing.JButton();
    btnNovo = new javax.swing.JButton();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    txtConta = new javax.swing.JTextField();
    txtNomeCliente = new javax.swing.JTextField();
    btnCancelar = new javax.swing.JButton();
    jLabel6 = new javax.swing.JLabel();
    lblNumeroClientes = new javax.swing.JLabel();
    lblVerificarNome = new javax.swing.JLabel();
    jPanel2 = new javax.swing.JPanel();
    rbtContaComum = new javax.swing.JRadioButton();
    rbtContaEspecial = new javax.swing.JRadioButton();
    rbtContaPoupança = new javax.swing.JRadioButton();
    lblVerificarConta = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    txtSaldo = new javax.swing.JTextField();
    jLabel5 = new javax.swing.JLabel();
    txtLimite = new javax.swing.JTextField();
    btnDepositar = new javax.swing.JButton();
    btnSacar = new javax.swing.JButton();
    btnGravar = new javax.swing.JButton();
    btnExcluir = new javax.swing.JButton();
    btnLimpar = new javax.swing.JButton();
    btnSair = new javax.swing.JButton();
    lblVerificarLimite = new javax.swing.JLabel();
    lblVerificarSaldo = new javax.swing.JLabel();
    jLabel11 = new javax.swing.JLabel();
    jLabel12 = new javax.swing.JLabel();
    txtValor = new javax.swing.JTextField();
    lblCifrao = new javax.swing.JLabel();
    btnOkay = new javax.swing.JButton();
    lblInformeQuantia = new javax.swing.JLabel();
    lblVerificarValor = new javax.swing.JLabel();

    jButton1.setText("jButton1");

    jTextArea1.setColumns(20);
    jTextArea1.setRows(5);
    jScrollPane1.setViewportView(jTextArea1);

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Controle Bancário");
    setName("frmControleBancario"); // NOI18N

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 51))); // NOI18N

    jLabel1.setText("Selecione");

    cboCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
    cboCliente.setName("cboSelecione"); // NOI18N
    cboCliente.setPreferredSize(new java.awt.Dimension(56, 18));
    cboCliente.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cboClienteActionPerformed(evt);
      }
    });

    btnConsultar.setText("Consultar");

    btnNovo.setText("Novo");
    btnNovo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnNovoActionPerformed(evt);
      }
    });

    jLabel2.setText("Número da conta");

    jLabel3.setText("Nome do cliente");

    txtConta.setMargin(new java.awt.Insets(1, 1, 1, 1));
    txtConta.setName("txtConta"); // NOI18N
    txtConta.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txtContaActionPerformed(evt);
      }
    });

    btnCancelar.setText("Cancelar");
    btnCancelar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCancelarActionPerformed(evt);
      }
    });

    jLabel6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
    jLabel6.setText("Número de clientes cadastrados");

    lblNumeroClientes.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
    lblNumeroClientes.setText("12");

    lblVerificarNome.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
    lblVerificarNome.setText("Somente letras");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(txtConta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(cboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel6)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblNumeroClientes)))
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 219, Short.MAX_VALUE)
            .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(35, 35, 35))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(lblVerificarNome)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel6)
          .addComponent(lblNumeroClientes))
        .addGap(1, 1, 1)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel1)
              .addComponent(cboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel2)
              .addComponent(txtConta, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel3)
              .addComponent(lblVerificarNome)))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(btnNovo)
              .addComponent(btnConsultar))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnCancelar)))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    txtConta.getAccessibleContext().setAccessibleName("");

    jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Tipo de Conta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 51))); // NOI18N
    jPanel2.setForeground(new java.awt.Color(204, 204, 204));

    rbtContaComum.setText("Conta Comum");

    rbtContaEspecial.setText("Conta Especial");

    rbtContaPoupança.setText("Conta Poupança");

    lblVerificarConta.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
    lblVerificarConta.setText("Selecione um tipo de conta");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(rbtContaComum)
        .addGap(18, 18, 18)
        .addComponent(rbtContaEspecial)
        .addGap(18, 18, 18)
        .addComponent(rbtContaPoupança)
        .addGap(27, 27, 27)
        .addComponent(lblVerificarConta)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(rbtContaComum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(rbtContaEspecial)
          .addComponent(rbtContaPoupança)
          .addComponent(lblVerificarConta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );

    jLabel4.setText("Limite");

    jLabel5.setText("Saldo atual");

    btnDepositar.setText("Depositar");
    btnDepositar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnDepositarActionPerformed(evt);
      }
    });

    btnSacar.setText("Sacar");
    btnSacar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnSacarActionPerformed(evt);
      }
    });

    btnGravar.setText("Gravar");
    btnGravar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnGravarActionPerformed(evt);
      }
    });

    btnExcluir.setText("Excluir");
    btnExcluir.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnExcluirActionPerformed(evt);
      }
    });

    btnLimpar.setText("Limpar");
    btnLimpar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnLimparActionPerformed(evt);
      }
    });

    btnSair.setText("Sair");
    btnSair.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnSairActionPerformed(evt);
      }
    });

    lblVerificarLimite.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
    lblVerificarLimite.setText("Somente números");

    lblVerificarSaldo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
    lblVerificarSaldo.setText("Somente números");

    jLabel11.setText("R$");

    jLabel12.setText("R$");

    lblCifrao.setText("R$");

    btnOkay.setText("Okay");
    btnOkay.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnOkayActionPerformed(evt);
      }
    });

    lblInformeQuantia.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
    lblInformeQuantia.setText("Informe a quantia");

    lblVerificarValor.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
    lblVerificarValor.setText("Somente números");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
              .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(73, 73, 73)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addComponent(lblCifrao)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnOkay, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGroup(layout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblInformeQuantia)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblVerificarValor))))
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                  .addComponent(jLabel11)
                  .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                    .addComponent(btnGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGroup(layout.createSequentialGroup()
                    .addComponent(txtLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblVerificarLimite))
                  .addGroup(layout.createSequentialGroup()
                    .addComponent(btnDepositar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnSacar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGroup(layout.createSequentialGroup()
                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblVerificarSaldo)))))
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(44, 44, 44)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(txtLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel4)
          .addComponent(lblVerificarLimite)
          .addComponent(jLabel11))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lblVerificarSaldo)
          .addComponent(jLabel12)
          .addComponent(jLabel5))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(lblInformeQuantia)
          .addComponent(lblVerificarValor))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lblCifrao)
          .addComponent(btnOkay))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(btnSacar)
          .addComponent(btnDepositar))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(btnExcluir)
          .addComponent(btnGravar)
          .addComponent(btnSair)
          .addComponent(btnLimpar))
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void cboClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboClienteActionPerformed
    // TODO add your handling code here:
    controller.cboCliente();
  }//GEN-LAST:event_cboClienteActionPerformed

  private void txtContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContaActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_txtContaActionPerformed

  private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
    // TODO add your handling code here:
    controller.btnSair();
  }//GEN-LAST:event_btnSairActionPerformed

  private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
    // TODO add your handling code here:
    controller.btnNovo();
  }//GEN-LAST:event_btnNovoActionPerformed

  private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
    // TODO add your handling code here:
    controller.btnCancelar();
  }//GEN-LAST:event_btnCancelarActionPerformed

  private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
    // TODO add your handling code here:
    controller.btnLimpar();
  }//GEN-LAST:event_btnLimparActionPerformed

  private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
    // TODO add your handling code here:
    controller.setObjValor(criarObjetoValor());
    controller.validarObjetoValor();
    controller.btnGravar();
  }//GEN-LAST:event_btnGravarActionPerformed

  private void btnOkayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkayActionPerformed
    // TODO add your handling code here:
    controller.btnOkay();
  }//GEN-LAST:event_btnOkayActionPerformed

  private void btnDepositarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositarActionPerformed
    // TODO add your handling code here:
    controller.btnDepositar();
  }//GEN-LAST:event_btnDepositarActionPerformed

  private void btnSacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacarActionPerformed
    // TODO add your handling code here:
    controller.btnSaquar();
  }//GEN-LAST:event_btnSacarActionPerformed

  private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
    // TODO add your handling code here:
    controller.btnExcluir();
  }//GEN-LAST:event_btnExcluirActionPerformed

  /**
   * @param args the command line arguments
   */

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnCancelar;
  private javax.swing.JButton btnConsultar;
  private javax.swing.JButton btnDepositar;
  private javax.swing.JButton btnExcluir;
  private javax.swing.JButton btnGravar;
  private javax.swing.JButton btnLimpar;
  private javax.swing.JButton btnNovo;
  private javax.swing.JButton btnOkay;
  private javax.swing.JButton btnSacar;
  private javax.swing.JButton btnSair;
  private javax.swing.ButtonGroup buttonGroup1;
  private javax.swing.JComboBox<String> cboCliente;
  private javax.swing.JButton jButton1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel11;
  private javax.swing.JLabel jLabel12;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTextArea jTextArea1;
  private javax.swing.JLabel lblCifrao;
  private javax.swing.JLabel lblInformeQuantia;
  private javax.swing.JLabel lblNumeroClientes;
  private javax.swing.JLabel lblVerificarConta;
  private javax.swing.JLabel lblVerificarLimite;
  private javax.swing.JLabel lblVerificarNome;
  private javax.swing.JLabel lblVerificarSaldo;
  private javax.swing.JLabel lblVerificarValor;
  private javax.swing.JRadioButton rbtContaComum;
  private javax.swing.JRadioButton rbtContaEspecial;
  private javax.swing.JRadioButton rbtContaPoupança;
  private javax.swing.JTextField txtConta;
  private javax.swing.JTextField txtLimite;
  private javax.swing.JTextField txtNomeCliente;
  private javax.swing.JTextField txtSaldo;
  private javax.swing.JTextField txtValor;
  // End of variables declaration//GEN-END:variables
}
