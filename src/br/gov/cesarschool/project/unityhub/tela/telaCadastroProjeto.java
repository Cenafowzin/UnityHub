package br.gov.cesarschool.project.unityhub.tela;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import br.gov.cesarschool.project.unityhub.entidade.Colaborador;
import br.gov.cesarschool.project.unityhub.negocio.LoginCadastroMediator;
import br.gov.cesarschool.project.unityhub.tela.geral.TelaUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;

public class telaCadastroProjeto {
	
	private Colaborador colaborador;
	protected Shell shell;
	private Text nomeText;
	private Label lblCidade;
	private Label lblEstado;
	private Label lblCep;
	private Label lblProjetoSocial;
	private Label lblRepresentanteProjeto;
	private Label lblEmail;
	private Label lblCelular;
	private Text representanteProjetoText;
	private Text celularText;
	private Text emailText;
	private Text estadoText;
	private Text cidadeText;
	private Text cepText;
	private Button btnVoltar;
	private Text descricaoTexto;
	private Text necessidadesText;
	
	
	public telaCadastroProjeto(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
	
	LoginCadastroMediator mediator = LoginCadastroMediator.getInstancia();
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
		shell.setSize(450, 759);
		shell.setText("SWT Application");
		
		nomeText = new Text(shell, SWT.BORDER);
		nomeText.setBounds(9, 21, 324, 26);
		
		lblCidade = new Label(shell, SWT.NONE);
		lblCidade.setBounds(9, 222, 70, 15);
		lblCidade.setText("Cidade");
		
		lblEstado = new Label(shell, SWT.NONE);
		lblEstado.setBounds(9, 179, 70, 15);
		lblEstado.setText("Estado");
		
		lblCep = new Label(shell, SWT.NONE);
		lblCep.setBounds(140, 222, 70, 15);
		lblCep.setText("Cep");
		
		lblProjetoSocial = new Label(shell, SWT.NONE);
		lblProjetoSocial.setBounds(9, 3, 138, 15);
		lblProjetoSocial.setText("Nome do projeto social");
		
		lblRepresentanteProjeto = new Label(shell, SWT.NONE);
		lblRepresentanteProjeto.setBounds(9, 49, 201, 15);
		lblRepresentanteProjeto.setText("Nome do representante do projeto");
		
		lblEmail = new Label(shell, SWT.NONE);
		lblEmail.setBounds(9, 134, 70, 15);
		lblEmail.setText("E-mail");
		
		lblCelular = new Label(shell, SWT.NONE);
		lblCelular.setBounds(9, 90, 70, 15);
		lblCelular.setText("Celular");
		
		representanteProjetoText = new Text(shell, SWT.BORDER);
		representanteProjetoText.setBounds(9, 64, 324, 26);
		
		celularText = new Text(shell, SWT.BORDER);
		celularText.setBounds(9, 106, 324, 26);
		
		emailText = new Text(shell, SWT.BORDER);
		emailText.setBounds(9, 151, 324, 26);
		
		estadoText = new Text(shell, SWT.BORDER);
		estadoText.setBounds(9, 195, 324, 26);
		
		cidadeText= new Text(shell, SWT.BORDER);
		cidadeText.setBounds(9, 239, 128, 26);
		
		cepText = new Text(shell, SWT.BORDER);
		cepText.setBounds(140, 239, 193, 26);
		
		btnVoltar = new Button(shell, SWT.NONE);
		btnVoltar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mediator.excluirColaborador(colaborador);
				shell.dispose();
                telaCadastroEmbaixador novaJanela = new telaCadastroEmbaixador();
                novaJanela.open();
			}
		});
		btnVoltar.setBounds(360, 10, 45, 30);
		btnVoltar.setText(" ←");
		
		Label lblDescricaoProjeto = new Label(shell, SWT.NONE);
		lblDescricaoProjeto.setBounds(9, 268, 146, 15);
		lblDescricaoProjeto.setText("Descrição do projeto social");
		
		descricaoTexto = new Text(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL);
		descricaoTexto.setBounds(9, 284, 324, 118);
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		Label lblNecessidades = new Label(shell, SWT.NONE);
		lblNecessidades.setText("Necessidades atuais");
		lblNecessidades.setBounds(9, 405, 120, 15);
		
		necessidadesText = new Text(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL);
		necessidadesText.setBounds(9, 424, 324, 118);
		
		Label lblUrgencia = new Label(shell, SWT.NONE);
		lblUrgencia.setText("Nível de urgência");
		lblUrgencia.setBounds(9, 544, 100, 15);
		
		Button btnBaixa = new Button(shell, SWT.RADIO);
		btnBaixa.setText("Baixa");
		btnBaixa.setBounds(9, 565, 70, 16);
		
		Button btnMedia = new Button(shell, SWT.RADIO);
		btnMedia.setText("Média");
		btnMedia.setBounds(93, 565, 70, 16);
		
		Button btnAlta = new Button(shell, SWT.RADIO);
		btnAlta.setText("Alta");
		btnAlta.setBounds(178, 565, 70, 16);
		
		Button btnConcluir = new Button(shell, SWT.NONE);
		btnConcluir.setText("Concluir");
		btnConcluir.setBounds(156, 628, 90, 30);

	}
}