package br.gov.cesarschool.project.unityhub.tela;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import br.gov.cesarschool.project.unityhub.entidade.Cargo;
import br.gov.cesarschool.project.unityhub.entidade.Colaborador;
import br.gov.cesarschool.project.unityhub.entidade.Estado;
import br.gov.cesarschool.project.unityhub.negocio.LoginCadastroMediator;
import br.gov.cesarschool.project.unityhub.tela.geral.TelaUtils;
import java.time.DateTimeException;
import java.time.LocalDate;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;

public class TelaCadastroEmbaixador {

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
	private Label lblCargo;
	private Text cpfText;
	private Text generoText;
	private Text celularText;
	private Text dataNascText;
	private Combo cmbEstado;
	private Combo cmbCargo;
	private Text cidadeText;
	private Text cepText;
	private Text criarSenhaText;
	private Text emailText;
	private Text confirmSenhaText;
	private Label lblEmail;
	private Label lblConfirmeSuaSenha;
	private Label lblCrieUmaSenha;
	private Button btnVoltar;
	
	LoginCadastroMediator mediator = LoginCadastroMediator.getInstancia();

	/**
	 * Launch the application.
	 * @param args
	 */ 
	public static void main(String[] args) {
		try {
			TelaCadastroEmbaixador window = new TelaCadastroEmbaixador();
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
		shell.setSize(450, 759);
		shell.setText("SWT Application");
		
		nomeText = new Text(shell, SWT.BORDER);
		nomeText.setBounds(17, 38, 324, 26);
		
		Button btnConcluir = new Button(shell, SWT.NONE);
		btnConcluir.setBounds(164, 651, 90, 30);
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
		cpfText.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                formatarCPF();
            }
        });
		
		generoText = new Text(shell, SWT.BORDER);
		generoText.setBounds(19, 153, 324, 26);
		
		celularText = new Text(shell, SWT.BORDER);
		celularText.setBounds(20, 211, 324, 26);
		celularText.addModifyListener(new ModifyListener() {
		    @Override
		    public void modifyText(ModifyEvent e) {
		        formatarCelular();
		    }
		});
		
		dataNascText = new Text(shell, SWT.BORDER);
		dataNascText.setBounds(18, 260, 324, 26);
		dataNascText.addModifyListener(new ModifyListener() {
		    @Override
		    public void modifyText(ModifyEvent e) {
		        formatarDataNascimento();
		    }
		});
		
		String[] estados = mediator.listarEstados();
		cmbEstado = new Combo(shell, SWT.READ_ONLY);
	    cmbEstado.setBounds(14, 320, 324, 26);
	    cmbEstado.setItems(estados);
		
		cidadeText= new Text(shell, SWT.BORDER);
		cidadeText.setBounds(20, 382, 128, 26);
		
		cepText = new Text(shell, SWT.BORDER);
		cepText.setBounds(229, 386, 189, 26);
		cepText.addModifyListener(new ModifyListener() {
		    @Override
		    public void modifyText(ModifyEvent e) {
		        formatarCEP();
		    }
		});
		
		cmbCargo = new Combo(shell, SWT.READ_ONLY);
        cmbCargo.setBounds(245, 517, 128, 26);
        cmbCargo.setItems(getNomesCargos());
		
		criarSenhaText = new Text(shell, SWT.BORDER);
		criarSenhaText.setBounds(20, 517, 128, 26);
		
		emailText = new Text(shell, SWT.BORDER);
		emailText.setBounds(17, 459, 350, 26);
		
		confirmSenhaText = new Text(shell, SWT.BORDER);
		confirmSenhaText.setBounds(17, 603, 78, 26);
		
		lblEmail = new Label(shell, SWT.NONE);
		lblEmail.setBounds(17, 423, 70, 20);
		lblEmail.setText("e-mail");
		
		lblConfirmeSuaSenha = new Label(shell, SWT.NONE);
		lblConfirmeSuaSenha.setBounds(17, 577, 156, 20);
		lblConfirmeSuaSenha.setText("confirme sua senha");
		
		lblCrieUmaSenha = new Label(shell, SWT.NONE);
		lblCrieUmaSenha.setBounds(17, 491, 138, 20);
		lblCrieUmaSenha.setText("crie uma senha");
		
		lblCargo = new Label(shell, SWT.NONE);
		lblCargo.setBounds(245, 491, 138, 20);
		lblCargo.setText("Cargo");
		
		btnVoltar = new Button(shell, SWT.NONE);
		btnVoltar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
                shell.dispose(); // Fecha a janela atual
                // Agora, abra a tela de login
                TelaLogin loginWindow = new TelaLogin();
                loginWindow.open();
			}
		});
		btnVoltar.setBounds(377, 10, 45, 30);
		btnVoltar.setText(" ←");
		
		btnConcluir.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				String dataNascString = dataNascText.getText();
				LocalDate dataNasc = null;
				if (dataNascString.matches("\\d{2}/\\d{2}/\\d{4}")) {
					 try {
				            String[] partesData = dataNascString.split("/");
				            int dia = Integer.parseInt(partesData[0]);
				            int mes = Integer.parseInt(partesData[1]);
				            int ano = Integer.parseInt(partesData[2]);
				            dataNasc = LocalDate.of(ano, mes, dia);
				        } catch (DateTimeException e1) {
				        	TelaUtils.mostrarMensagemErro("Data de Nascimento inválida!", shell);
				            return;
				        }
				 }
				Estado estado = mediator.buscarEstado(cmbEstado.getText());
				Cargo cargoSelecionado = obterCargoSelecionado();
				if(estado == null){
					TelaUtils.mostrarMensagemErro("Estado não selecionado", shell);
				}else {
					Colaborador colaborador = new Colaborador(cpfText.getText(), nomeText.getText(), celularText.getText(), emailText.getText(), criarSenhaText.getText(), generoText.getText(), 
							estado, cepText.getText(), cidadeText.getText(), dataNasc, cargoSelecionado);
					String mensagem = mediator.cadastrarColaborador(colaborador, confirmSenhaText.getText());
					if(mensagem != null) {
						TelaUtils.mostrarMensagemErro(mensagem, shell);
					}else {
						if(cargoSelecionado == Cargo.USUARIO) {
							shell.dispose();
							TelaCadastroProjeto telaProjeto = new TelaCadastroProjeto(colaborador);
							telaProjeto.open();
							
						}else {
							shell.dispose();
							TelaPronto doneWindow = new TelaPronto();
							doneWindow.open();			
						}
					}
				}
            }
		});

	}
	
	private String[] getNomesCargos() {
        Cargo[] cargos = Cargo.values();
        String[] nomesCargos = new String[cargos.length];

        for (int i = 0; i < cargos.length; i++) {
            nomesCargos[i] = cargos[i].getNome();
        }

        return nomesCargos;
    }

    private Cargo obterCargoSelecionado() {
        int indiceSelecionado = cmbCargo.getSelectionIndex();
        if (indiceSelecionado != -1) {
            String nomeCargo = cmbCargo.getItem(indiceSelecionado);
            for (Cargo cargo : Cargo.values()) {
                if (cargo.getNome().equals(nomeCargo)) {
                    return cargo;
                }
            }
        }
        return null;
    }
	
	private void formatarCPF() {
	    String text = cpfText.getText().replaceAll("[^0-9]", ""); // Remove todos os caracteres que não são números

	    if (text.length() > 11) {
	        text = text.substring(0, 11);
	    }

	    StringBuilder formattedCPF = new StringBuilder();

	    int length = text.length();
	    for (int i = 0; i < length; i++) {
	        if (i == 3 || i == 6) {
	            formattedCPF.append('.');
	        } else if (i == 9) {
	            formattedCPF.append('-');
	        }
	        formattedCPF.append(text.charAt(i));
	    }

	    // Verifica se o texto formatado é diferente do texto atual antes de definir o texto
	    if (!formattedCPF.toString().equals(cpfText.getText())) {
	        cpfText.setText(formattedCPF.toString());
	        cpfText.setSelection(cpfText.getText().length()); // Coloca o cursor no final do campo
	    }
	}
	
	private void formatarDataNascimento() {
	    String text = dataNascText.getText().replaceAll("[^0-9/]", ""); // Remove todos os caracteres que não são números nem a barra

	    if (text.length() > 10) {
	        text = text.substring(0, 10);
	    }

	    StringBuilder formattedData = new StringBuilder();

	    int length = text.length();
	    for (int i = 0; i < length; i++) {
	        if ((i == 2 || i == 5) && text.charAt(i) != '/') {
	            formattedData.append('/');
	        }
	        formattedData.append(text.charAt(i));
	    }

	    // Verifica se o texto formatado é diferente do texto atual antes de definir o texto
	    if (!formattedData.toString().equals(dataNascText.getText())) {
	        dataNascText.setText(formattedData.toString());
	        dataNascText.setSelection(dataNascText.getText().length()); // Coloca o cursor no final do campo
	    }
	}
	
	private void formatarCEP() {
	    String text = cepText.getText().replaceAll("[^0-9]", ""); // Remove todos os caracteres que não são números

	    if (text.length() > 8) {
	        text = text.substring(0, 8);
	    }

	    StringBuilder formattedCEP = new StringBuilder();

	    int length = text.length();
	    for (int i = 0; i < length; i++) {
	        if (i == 5) {
	            formattedCEP.append('-');
	        }
	        formattedCEP.append(text.charAt(i));
	    }

	    // Verifica se o texto formatado é diferente do texto atual antes de definir o texto
	    if (!formattedCEP.toString().equals(cepText.getText())) {
	        cepText.setText(formattedCEP.toString());
	        cepText.setSelection(cepText.getText().length()); // Coloca o cursor no final do campo
	    }
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