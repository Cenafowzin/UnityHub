package br.gov.cesarschool.project.unityhub.tela;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import br.gov.cesarschool.project.unityhub.entidade.Colaborador;
import br.gov.cesarschool.project.unityhub.entidade.Prioridade;
import br.gov.cesarschool.project.unityhub.entidade.Projeto;
import br.gov.cesarschool.project.unityhub.negocio.LoginCadastroMediator;
import br.gov.cesarschool.project.unityhub.tela.geral.TelaUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;

public class TelaCadastroProjeto {
	
	private Colaborador colaborador;
	protected Shell shell;
	private Text nomeText;
	private Label lblCidade;
	private Label lblEstado;
	private Label lblProjetoSocial;
	private Label lblRepresentanteProjeto;
	private Label lblEmail;
	private Label lblCelular;
	private Text representanteProjetoText;
	private Text celularText;
	private Text emailText;
	private Text textEstado;
	private Text cidadeText;
	private Button btnVoltar;
	private Text descricaoTexto;
	
	
	public TelaCadastroProjeto(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
	 
	LoginCadastroMediator mediator = LoginCadastroMediator.getInstancia();
	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
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
		nomeText.setBounds(9, 33, 324, 26);
		
		lblCidade = new Label(shell, SWT.NONE);
		lblCidade.setBounds(9, 321, 128, 26);
		lblCidade.setText("Cidade do projeto");
		
		lblEstado = new Label(shell, SWT.NONE);
		lblEstado.setBounds(9, 257, 174, 26);
		lblEstado.setText("Estado do projeto");
		
		lblProjetoSocial = new Label(shell, SWT.NONE);
		lblProjetoSocial.setBounds(9, 3, 254, 26);
		lblProjetoSocial.setText("Nome do projeto social");
		
		lblRepresentanteProjeto = new Label(shell, SWT.NONE);
		lblRepresentanteProjeto.setBounds(9, 65, 324, 26);
		lblRepresentanteProjeto.setText("Nome do representante do projeto");
		
		lblEmail = new Label(shell, SWT.NONE);
		lblEmail.setBounds(9, 193, 70, 26);
		lblEmail.setText("E-mail");
		
		lblCelular = new Label(shell, SWT.NONE);
		lblCelular.setBounds(9, 129, 70, 26);
		lblCelular.setText("Celular");
		
		representanteProjetoText = new Text(shell, SWT.BORDER);
		representanteProjetoText.setBounds(9, 97, 324, 26);
		representanteProjetoText.setText(colaborador.getNomeCompleto());
		representanteProjetoText.setEnabled(false);
		
		celularText = new Text(shell, SWT.BORDER);
		celularText.setBounds(9, 161, 324, 26);
		celularText.addModifyListener(new ModifyListener() {
		    @Override
		    public void modifyText(ModifyEvent e) {
		        formatarCelular();
		    }
		});
		
		emailText = new Text(shell, SWT.BORDER);
		emailText.setBounds(9, 225, 324, 26);
		emailText.setText(colaborador.getEmail());
		emailText.setEnabled(false);
		
		textEstado = new Text(shell, SWT.BORDER);
		textEstado.setBounds(9, 289, 324, 26);
		textEstado.setEnabled(false);
		textEstado.setText(colaborador.getEstado().getNome());
		
		cidadeText= new Text(shell, SWT.BORDER);
		cidadeText.setBounds(9, 353, 324, 26);
		
		btnVoltar = new Button(shell, SWT.NONE);
		btnVoltar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mediator.excluirColaborador(colaborador);
				shell.dispose();
				TelaCadastroEmbaixador novaJanela = new TelaCadastroEmbaixador();
                novaJanela.open();
			}
		});
		btnVoltar.setBounds(360, 10, 45, 30);
		btnVoltar.setText(" ←");
		
		Label lblDescricaoProjeto = new Label(shell, SWT.NONE);
		lblDescricaoProjeto.setBounds(9, 380, 324, 30);
		lblDescricaoProjeto.setText("Descrição do projeto social");
		
		descricaoTexto = new Text(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL);
		descricaoTexto.setBounds(9, 411, 396, 162);
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		Label lblUrgencia = new Label(shell, SWT.NONE);
		lblUrgencia.setText("Nível de urgência");
		lblUrgencia.setBounds(10, 579, 211, 21);
		
		Button btnBaixa = new Button(shell, SWT.RADIO);
		btnBaixa.setText("Baixa");
		btnBaixa.setBounds(9, 606, 70, 16);
		
		Button btnMedia = new Button(shell, SWT.RADIO);
		btnMedia.setText("Média");
		btnMedia.setBounds(93, 606, 70, 16);
		
		Button btnAlta = new Button(shell, SWT.RADIO);
		btnAlta.setText("Alta");
		btnAlta.setBounds(178, 606, 70, 16);
		
		Button btnConcluir = new Button(shell, SWT.NONE);
		btnConcluir.setText("Concluir");
		btnConcluir.setBounds(156, 628, 90, 30);
		btnConcluir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				Prioridade prioridadeSelecionada = null;

		        if (btnBaixa.getSelection()) {
		            prioridadeSelecionada = Prioridade.BAIXA;
		        } else if (btnMedia.getSelection()) {
		            prioridadeSelecionada = Prioridade.MEDIA;
		        } else if (btnAlta.getSelection()) {
		            prioridadeSelecionada = Prioridade.ALTA;
		        }
				
				Projeto projeto = new Projeto(nomeText.getText(), celularText.getText(), colaborador.getEmail(), descricaoTexto.getText(), 
						cidadeText.getText(), colaborador.getEstado(), prioridadeSelecionada);
				
				String message = mediator.cadastroProjeto(projeto);
				
				if(message != null) {
					TelaUtils.mostrarMensagemErro(message, shell);
				}else {
					shell.dispose();
					TelaPronto doneWindow = new TelaPronto();
					doneWindow.open();					
				}
				
			}
		});

	}
	
	private void formatarCelular() {
	    String text = celularText.getText().replaceAll("[^0-9]", ""); // Remove todos os caracteres que não são números

	    if (text.length() > 11) {
	        text = text.substring(0, 11);
	    }

	    StringBuilder formattedCelular = new StringBuilder();

	    int length = text.length();
	    for (int i = 0; i < length; i++) {
	        if (i == 0) {
	            formattedCelular.append('(');
	        } else if (i == 2) {
	            formattedCelular.append(") ");
	        } else if (i == 7) {
	            formattedCelular.append('-');
	        }
	        formattedCelular.append(text.charAt(i));
	    }

	    // Verifica se o texto formatado é diferente do texto atual antes de definir o texto
	    if (!formattedCelular.toString().equals(celularText.getText())) {
	        celularText.setText(formattedCelular.toString());
	        celularText.setSelection(celularText.getText().length()); // Coloca o cursor no final do campo
	    }
	}
}