package br.gov.cesarschool.project.unityhub.tela;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;

public class telaCadastroEmbaixador {

	protected Shell shell;
	private Text nomeText;
	private Label lblCidade;
	private Label lblEstado;
	private Label lblCep;
	private Label lblNomeCompleto;
	private Label lblCpf;
	private Label lblGnero;
	private Label lblDataDeNascimento;
	private Label lblCelular;
	private Text cpfText;
	private Text generoText;
	private Text celularText;
	private Text dataNascText;
	private Text estadoText;
	private Text cidadeText;
	private Text cepText;
	private Text criarSenhaText;
	private Text emailText;
	private Text confirmSenhaText;
	private Label lblEmail;
	private Label lblConfirmeSuaSenha;
	private Label lblCrieUmaSenha;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			telaCadastroEmbaixador window = new telaCadastroEmbaixador();
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
		shell.setSize(450, 717);
		shell.setText("SWT Application");
		
		nomeText = new Text(shell, SWT.BORDER);
		nomeText.setBounds(17, 38, 324, 26);
		
		Button btnConcluir = new Button(shell, SWT.NONE);
		btnConcluir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnConcluir.setBounds(159, 630, 90, 30);
		btnConcluir.setText("Concluir");
		
		lblCidade = new Label(shell, SWT.NONE);
		lblCidade.setBounds(20, 361, 70, 20);
		lblCidade.setText("Cidade");
		
		lblEstado = new Label(shell, SWT.NONE);
		lblEstado.setBounds(20, 295, 70, 20);
		lblEstado.setText("Estado");
		
		lblCep = new Label(shell, SWT.NONE);
		lblCep.setBounds(216, 358, 70, 20);
		lblCep.setText("Cep");
		
		lblNomeCompleto = new Label(shell, SWT.NONE);
		lblNomeCompleto.setBounds(20, 10, 138, 20);
		lblNomeCompleto.setText("Nome completo");
		
		lblCpf = new Label(shell, SWT.NONE);
		lblCpf.setBounds(18, 74, 70, 20);
		lblCpf.setText("CPF:");
		
		lblGnero = new Label(shell, SWT.NONE);
		lblGnero.setBounds(18, 129, 70, 20);
		lblGnero.setText("Gênero");
		
		lblDataDeNascimento = new Label(shell, SWT.NONE);
		lblDataDeNascimento.setBounds(20, 235, 186, 20);
		lblDataDeNascimento.setText("Data de Nascimento");
		
		lblCelular = new Label(shell, SWT.NONE);
		lblCelular.setBounds(22, 188, 70, 20);
		lblCelular.setText("Celular");
		
		cpfText = new Text(shell, SWT.BORDER);
		cpfText.setBounds(16, 94, 324, 26);
		
		generoText = new Text(shell, SWT.BORDER);
		generoText.setBounds(19, 153, 324, 26);
		
		celularText = new Text(shell, SWT.BORDER);
		celularText.setBounds(20, 211, 324, 26);
		
		dataNascText = new Text(shell, SWT.BORDER);
		dataNascText.setBounds(18, 260, 324, 26);
		
		estadoText = new Text(shell, SWT.BORDER);
		estadoText.setBounds(14, 320, 324, 26);
		
		cidadeText= new Text(shell, SWT.BORDER);
		cidadeText.setBounds(20, 382, 128, 26);
		
		cepText = new Text(shell, SWT.BORDER);
		cepText.setBounds(229, 386, 189, 26);
		
		criarSenhaText = new Text(shell, SWT.BORDER);
		criarSenhaText.setBounds(20, 517, 128, 26);
		
		emailText = new Text(shell, SWT.BORDER);
		emailText.setBounds(17, 459, 350, 26);
		
		confirmSenhaText = new Text(shell, SWT.BORDER);
		confirmSenhaText.setBounds(20, 590, 78, 26);
		
		lblEmail = new Label(shell, SWT.NONE);
		lblEmail.setBounds(17, 423, 70, 20);
		lblEmail.setText("e-mail");
		
		lblConfirmeSuaSenha = new Label(shell, SWT.NONE);
		lblConfirmeSuaSenha.setBounds(17, 562, 156, 20);
		lblConfirmeSuaSenha.setText("confirme sua senha");
		
		lblCrieUmaSenha = new Label(shell, SWT.NONE);
		lblCrieUmaSenha.setBounds(17, 491, 138, 20);
		lblCrieUmaSenha.setText("crie uma senha");

	}

}
