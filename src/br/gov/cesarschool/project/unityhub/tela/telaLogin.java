package br.gov.cesarschool.project.unityhub.tela;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;

public class telaLogin {

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

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			telaLogin window = new telaLogin();
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
		shell.setSize(450, 523);
		shell.setText("SWT Application");
		
		nomeText = new Text(shell, SWT.BORDER);
		nomeText.setBounds(17, 38, 324, 26);
		
		Button btnCadastro = new Button(shell, SWT.NONE);
		btnCadastro.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnCadastro.setBounds(153, 425, 90, 30);
		btnCadastro.setText("Avançar");
		
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

	}

}
