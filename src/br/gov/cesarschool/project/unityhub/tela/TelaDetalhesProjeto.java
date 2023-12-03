package br.gov.cesarschool.project.unityhub.tela;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import br.gov.cesarschool.project.unityhub.entidade.Colaborador;
import br.gov.cesarschool.project.unityhub.entidade.Projeto;
import br.gov.cesarschool.project.unityhub.tela.geral.TelaUtils;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;

public class TelaDetalhesProjeto {

	protected Shell shell;
	private Colaborador colaborador;
	private Projeto projeto;
	private Text textoProjeto;
	private Text textoEstado;
	private Text textoDescricao;
	private Label lblDescricao;
	private Button btnVoltar;
	
	public TelaDetalhesProjeto(Colaborador colaborador, Projeto projeto) {
		this.colaborador = colaborador;
		this.projeto = projeto;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TelaDetalhesProjeto window = new TelaDetalhesProjeto(null, null);
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
		
		textoProjeto = new Text(shell, SWT.BORDER);
		textoProjeto.setEnabled(false);
		textoProjeto.setBounds(55, 101, 327, 29);
		textoProjeto.setText(projeto.getNome());;
		
		Label lblNomeDoPrjeto = new Label(shell, SWT.NONE);
		lblNomeDoPrjeto.setBounds(55, 66, 96, 29);
		lblNomeDoPrjeto.setText("Projeto");
		
		Label lblEstado = new Label(shell, SWT.NONE);
		lblEstado.setText("Estado");
		lblEstado.setBounds(55, 136, 96, 33);
		
		textoEstado = new Text(shell, SWT.BORDER);
		textoEstado.setEnabled(false);
		textoEstado.setBounds(55, 175, 327, 29);
		textoEstado.setText(projeto.getEstado().getNome());
		
		textoDescricao = new Text(shell, SWT.BORDER | SWT.V_SCROLL);
		textoDescricao.setEnabled(false);
		textoDescricao.setBounds(55, 245, 327, 179);
		textoDescricao.setText(projeto.getDescricao());
		
		lblDescricao = new Label(shell, SWT.NONE);
		lblDescricao.setText("Descrição");
		lblDescricao.setBounds(55, 210, 111, 29);
		
		btnVoltar = new Button(shell, SWT.NONE);
		btnVoltar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
                shell.dispose(); // Fecha a janela atual

                TelaProjetos novaJanela = new TelaProjetos(colaborador);
                novaJanela.open(); // Abre a nova janela
            }
		});
		btnVoltar.setBounds(10, 19, 46, 30);
		btnVoltar.setText(" ←");
		
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
		shell.setSize(454, 503);
		shell.setText("SWT Application");

	}
}
