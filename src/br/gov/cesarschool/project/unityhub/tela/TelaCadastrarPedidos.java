package br.gov.cesarschool.project.unityhub.tela;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.time.LocalDateTime;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;

import br.gov.cesarschool.project.unityhub.entidade.Colaborador;
import br.gov.cesarschool.project.unityhub.entidade.Pedido;
import br.gov.cesarschool.project.unityhub.entidade.Prioridade;
import br.gov.cesarschool.project.unityhub.entidade.Projeto;
import br.gov.cesarschool.project.unityhub.negocio.ProjetoMediator;
import br.gov.cesarschool.project.unityhub.negocio.geral.StringUtil;
import br.gov.cesarschool.project.unityhub.tela.geral.TelaUtils;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class TelaCadastrarPedidos {

	protected Shell shell;
	private Colaborador colaborador;
	private Text textProjeto;
	private Text textDescricao;
	
	public TelaCadastrarPedidos(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
	
	private ProjetoMediator mediator = ProjetoMediator.getInstancia();
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TelaCadastrarPedidos window = new TelaCadastrarPedidos(null);
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
		shell.setSize(450, 603);
		shell.setText("SWT Application");
		
		Label lblPedidos = new Label(shell, SWT.NONE);
		lblPedidos.setBounds(174, 10, 70, 20);
		lblPedidos.setText("Pedido");
		
		Label lblProjeto = new Label(shell, SWT.NONE);
		lblProjeto.setBounds(10, 56, 70, 20);
		lblProjeto.setText("Projeto:");
		
		Projeto projeto = mediator.buscarProjeto(colaborador.getEmail());
		textProjeto = new Text(shell, SWT.BORDER);
		textProjeto.setEnabled(false);
		textProjeto.setEditable(false);
		textProjeto.setBounds(10, 82, 392, 26);
		textProjeto.setText(projeto.getNome());
		
		Label lblDescrio = new Label(shell, SWT.NONE);
		lblDescrio.setBounds(10, 141, 70, 20);
		lblDescrio.setText("Descrição:");
		
		textDescricao = new Text(shell, SWT.BORDER | SWT.V_SCROLL);
		textDescricao.setBounds(10, 174, 392, 181);
		
		Combo comboPrioridade = new Combo(shell, SWT.READ_ONLY);
		comboPrioridade.setBounds(10, 412, 137, 28);
		for (Prioridade prioridade : Prioridade.values()) {
		    comboPrioridade.add(prioridade.getNome());
		}
		
		Label lblPrioridade = new Label(shell, SWT.NONE);
		lblPrioridade.setBounds(10, 385, 122, 20);
		lblPrioridade.setText("Prioridade:");
		
		
		
		Button btnConfirmar = new Button(shell, SWT.NONE);
		btnConfirmar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnConfirmar.setBounds(168, 510, 90, 30);
		btnConfirmar.setText("Confirmar");
		btnConfirmar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(StringUtil.ehNuloOuBranco(textDescricao.getText())) {
					TelaUtils.mostrarMensagemErro("Descrição não informada", shell);
				}else if(StringUtil.ehNuloOuBranco(comboPrioridade.getText())) {
					TelaUtils.mostrarMensagemErro("Prioridade não selecionada", shell);
				}else {
					String prioridadeSelecionada = comboPrioridade.getText();
					Prioridade prioridade = Prioridade.valueOf(prioridadeSelecionada.toUpperCase());
					LocalDateTime dataHoraInicio = LocalDateTime.now();
					int id = mediator.listarPedidos().length + 1;
					Projeto projeto = mediator.buscarProjeto(colaborador.getEmail());
					Pedido pedido = new Pedido(id, projeto,textDescricao.getText(), prioridade, dataHoraInicio);
					String message = mediator.criarPedido(pedido);
					if(message != null) {
						TelaUtils.mostrarMensagemErro(message, shell);
					}else {
						shell.dispose();
						TelaMenuUsuario menuUser= new TelaMenuUsuario(colaborador);
						menuUser.open();
					}
				}
			}
		});
		
		Button btnVoltar = new Button(shell, SWT.NONE);
		btnVoltar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				TelaMenuUsuario menuUser= new TelaMenuUsuario(colaborador);
				menuUser.open();
			}
		});
		btnVoltar.setBounds(10, 5, 41, 30);
		btnVoltar.setText(" ←");

	}
}
