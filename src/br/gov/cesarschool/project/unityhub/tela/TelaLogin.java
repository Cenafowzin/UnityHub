package br.gov.cesarschool.project.unityhub.tela;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import br.gov.cesarschool.project.unityhub.entidade.Cargo;
import br.gov.cesarschool.project.unityhub.entidade.Colaborador;
import br.gov.cesarschool.project.unityhub.negocio.LoginCadastroMediator;
import br.gov.cesarschool.project.unityhub.tela.geral.TelaUtils;

import org.eclipse.wb.swt.SWTResourceManager;


public class TelaLogin {

	protected Shell shell;
	
	LoginCadastroMediator mediator = LoginCadastroMediator.getInstancia();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TelaLogin window = new TelaLogin();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		TelaUtils.centralizarJanela(shell);
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
	    shell = new Shell();
	    shell.setSize(450, 403);
	    shell.setText("SWT Application");
	    
	    // Rótulo para o título da aplicação
	    Label lblUnityhub = new Label(shell, SWT.NONE);
	    lblUnityhub.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
	    lblUnityhub.setBounds(159, 23, 121, 42);
	    lblUnityhub.setText("UnityHub");
	    
	    // Botão de login
	    Button btnLogin = new Button(shell, SWT.NONE);
	    btnLogin.setBounds(165, 209, 90, 30);
	    btnLogin.setText("Login");
	    
	    // Campos de texto para o usuário inserir suas credenciais
	    Label lblEmail = new Label(shell, SWT.NONE);
	    lblEmail.setBounds(10, 100, 55, 18);
	    lblEmail.setText("E-mail:");
	    
	    Text textEmail = new Text(shell, SWT.BORDER);
	    textEmail.setBounds(71, 97, 294, 21);
	    
	    Label lblSenha = new Label(shell, SWT.NONE);
	    lblSenha.setBounds(10, 130, 55, 24);
	    lblSenha.setText("Senha:");
	    
	    Text textSenha = new Text(shell, SWT.BORDER | SWT.PASSWORD);
	    textSenha.setBounds(71, 127, 294, 21);
	    
	 // Botões de rádio para seleção do tipo de usuário
        Button radioGerencia = new Button(shell, SWT.RADIO);
        radioGerencia.setBounds(10, 160, 130, 25);
        radioGerencia.setText(Cargo.GERENCIA.getNome());
        
        Button radioEmbaixador = new Button(shell, SWT.RADIO);
        radioEmbaixador.setBounds(150, 160, 130, 25);
        radioEmbaixador.setText(Cargo.EMBAIXADOR.getNome());
        
        Button radioUsuario = new Button(shell, SWT.RADIO);
        radioUsuario.setBounds(290, 160, 130, 25);
        radioUsuario.setText(Cargo.USUARIO.getNome());
        
        Button btnCadastrar = new Button(shell, SWT.NONE);
        btnCadastrar.setBounds(165, 305, 90, 30);
        btnCadastrar.setText("Cadastre-se");
        
        // Adicionando manipulador de eventos para o botão de cadastro
	    btnCadastrar.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                shell.dispose(); // Fecha a janela atual

                TelaCadastroEmbaixador novaJanela = new TelaCadastroEmbaixador();
                novaJanela.open(); // Abre a nova janela
            }
        });
        
        Label lblNoPossuiLogin = new Label(shell, SWT.NONE);
        lblNoPossuiLogin.setBounds(150, 279, 133, 20);
        lblNoPossuiLogin.setText("Não possui login?");

        // Manipulador de eventos para os botões de rádio
        SelectionAdapter radioButtonSelectionAdapter = new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button source = (Button) e.getSource();
                if (source.getSelection()) { // Verifica se o botão de rádio está selecionado
                    Cargo cargoSelecionado = Cargo.valueOf(source.getText().toUpperCase().replace(" ", "_"));
                    System.out.println("Cargo selecionado: " + cargoSelecionado.getNome() +
                                       " - Código: " + cargoSelecionado.getCodigo());
                }
            }
        };
        
        // Adicionando manipulador de eventos para o botão de login
	    btnLogin.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
            	Colaborador colaborador = mediator.buscarColaborador(textEmail.getText());
            	String message = mediator.logarColaborador(colaborador, textSenha.getText());
            	if(message != null) {
            		TelaUtils.mostrarMensagemErro(message, shell);
            	}else {
            		if(colaborador.getCargo() == Cargo.GERENCIA) {
            			TelaUtils.mostrarMensagemErro("Gerente", shell);
            			shell.dispose();
            		}else if(colaborador.getCargo() == Cargo.EMBAIXADOR) {
            			shell.dispose();
            			TelaMenu novaJanela = new TelaMenu(colaborador);
            			novaJanela.open();            			
            		}else {
            			TelaUtils.mostrarMensagemErro("Random", shell);
            		}
            	}
            }
        });
        
        radioGerencia.addSelectionListener(radioButtonSelectionAdapter);
        radioEmbaixador.addSelectionListener(radioButtonSelectionAdapter);
        radioUsuario.addSelectionListener(radioButtonSelectionAdapter);
    }
}
