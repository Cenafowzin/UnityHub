package br.gov.cesarschool.project.unityhub.tela;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;

import br.gov.cesarschool.project.unityhub.entidade.Colaborador;
import br.gov.cesarschool.project.unityhub.entidade.Pedido;
import br.gov.cesarschool.project.unityhub.tela.geral.TelaUtils;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class TelaConcluirPedido {

	protected Shell shell;
	private Colaborador colaborador;
	private Pedido pedido;
	private Text textProjeto;
	private Text textDescricao;
	
	public TelaConcluirPedido(Colaborador colaborador, Pedido pedido) {
		this.colaborador = colaborador;
		this.pedido = pedido;
	}
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TelaConcluirPedido window = new TelaConcluirPedido(null,null);
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
		
		textProjeto = new Text(shell, SWT.BORDER);
		textProjeto.setEnabled(false);
		textProjeto.setEditable(false);
		textProjeto.setBounds(10, 82, 392, 26);
		textProjeto.setText(pedido.getProjeto().getNome());
		
		Label lblDescrio = new Label(shell, SWT.NONE);
		lblDescrio.setBounds(10, 141, 70, 20);
		lblDescrio.setText("Descrição:");
		
		textDescricao = new Text(shell, SWT.BORDER | SWT.V_SCROLL);
		textDescricao.setEnabled(false);
		textDescricao.setEditable(false);
		textDescricao.setBounds(10, 174, 392, 181);
		textDescricao.setText(pedido.getDescricao());
		
		Combo comboPrioridade = new Combo(shell, SWT.NONE);
		comboPrioridade.setEnabled(false);
		comboPrioridade.setBounds(10, 412, 137, 28);
		comboPrioridade.setText(pedido.getPrioridade().getNome());
		
		Label lblPrioridade = new Label(shell, SWT.NONE);
		lblPrioridade.setBounds(10, 385, 122, 20);
		lblPrioridade.setText("Prioridade:");
		
		Button btnConcluido = new Button(shell, SWT.NONE);
		btnConcluido.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				TelaDemanda tela = new TelaDemanda(colaborador);
				tela.open();
			}
		});
		btnConcluido.setBounds(128, 505, 179, 30);
		btnConcluido.setText("Marcar como concluído");
		
		Button btnVoltar = new Button(shell, SWT.NONE);
		btnVoltar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				TelaDemanda tela = new TelaDemanda(colaborador);
				tela.open();
			}
		});
		btnVoltar.setBounds(10, 5, 41, 30);
		btnVoltar.setText(" ←");

	}
}
