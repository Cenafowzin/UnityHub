package br.gov.cesarschool.project.unityhub.tela;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import br.gov.cesarschool.project.unityhub.entidade.Colaborador;
import br.gov.cesarschool.project.unityhub.tela.geral.TelaUtils;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class TelaMenu {
	
	private Colaborador colaborador;
	protected Shell shell;
	
	public TelaMenu(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TelaMenu window = new TelaMenu(null);
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
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Label lblBemVindoEmabaixador = new Label(shell, SWT.CENTER);
		lblBemVindoEmabaixador.setBounds(140, 45, 168, 27);
		if(colaborador != null) {
			String[] partesNome = colaborador.getNomeCompleto().split(" ");
			String primeiroNome = partesNome[0];
			lblBemVindoEmabaixador.setText("Bem-vindo\n" + primeiroNome);
		}
		
		Button btnGestaoDemanda = new Button(shell, SWT.NONE);
		btnGestaoDemanda.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose(); // Fecha a janela atual

				TelaDemandaGerencia novaJanela4 = new TelaDemandaGerencia(colaborador);
                novaJanela4.open(); // Abre a nova janela
			}
		});
		btnGestaoDemanda.setBounds(131, 104, 177, 30);
		btnGestaoDemanda.setText("Gestão de demanda");
		
		Button btnGestaoProjetos = new Button(shell, SWT.NONE);
		btnGestaoProjetos.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose(); // Fecha a janela atual

				TelaProjetosGerencia novaJanela2 = new TelaProjetosGerencia(colaborador);
                novaJanela2.open(); // Abre a nova janela
			}
		});
		btnGestaoProjetos.setBounds(126, 175, 182, 30);
		btnGestaoProjetos.setText("Gestão de projetos");
		
		Button btnVoltar = new Button(shell, SWT.NONE);
		btnVoltar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
                shell.dispose(); // Fecha a janela atual
                // Agora, abra a tela de login
                TelaLogin loginWindow = new TelaLogin();
                loginWindow.open(); 
			}
		});
		btnVoltar.setBounds(10, 10, 29, 30);
		btnVoltar.setText(" ←");
		
		
		

	}
}
