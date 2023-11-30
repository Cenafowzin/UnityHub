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


public class telaLoginGeral {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			telaLoginGeral window = new telaLoginGeral();
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
	    shell.setSize(450, 300);
	    shell.setText("SWT Application");
	    
	    // Rótulo para o título da aplicação
	    Label lblUnityhub = new Label(shell, SWT.NONE);
	    lblUnityhub.setBounds(181, 23, 102, 65);
	    lblUnityhub.setText("UnityHub");
	    
	    // Botão de login
	    Button btnLogin = new Button(shell, SWT.NONE);
	    btnLogin.setBounds(181, 190, 90, 30);
	    btnLogin.setText("Login");
	    
	    // Adicionando manipulador de eventos para o botão de login
	    btnLogin.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                shell.dispose(); // Fecha a janela atual

                telaMenuEmbaixador novaJanela = new telaMenuEmbaixador();
                novaJanela.open(); // Abre a nova janela
            }
        });
	    
	    // Campos de texto para o usuário inserir suas credenciais
	    Label lblEmail = new Label(shell, SWT.NONE);
	    lblEmail.setBounds(10, 100, 55, 15);
	    lblEmail.setText("E-mail:");
	    
	    Text textEmail = new Text(shell, SWT.BORDER);
	    textEmail.setBounds(71, 97, 160, 21);
	    
	    Label lblSenha = new Label(shell, SWT.NONE);
	    lblSenha.setBounds(10, 130, 55, 15);
	    lblSenha.setText("Senha:");
	    
	    Text textSenha = new Text(shell, SWT.BORDER | SWT.PASSWORD);
	    textSenha.setBounds(71, 127, 160, 21);
	    
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
        
        radioGerencia.addSelectionListener(radioButtonSelectionAdapter);
        radioEmbaixador.addSelectionListener(radioButtonSelectionAdapter);
        radioUsuario.addSelectionListener(radioButtonSelectionAdapter);
    }
}
