package br.gov.cesarschool.project.unityhub.tela;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class telaMenuEmbaixador {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			telaMenuEmbaixador window = new telaMenuEmbaixador();
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
		
		Label lblBemVindoEmabaixador = new Label(shell, SWT.NONE);
		lblBemVindoEmabaixador.setBounds(140, 45, 168, 27);
		lblBemVindoEmabaixador.setText("Bem-vindo embaixador");
		
		Button btnGestaoDemanda = new Button(shell, SWT.NONE);
		btnGestaoDemanda.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnGestaoDemanda.setBounds(131, 104, 177, 30);
		btnGestaoDemanda.setText("Gestão de demanda");
		
		Button btnGestaoProjetos = new Button(shell, SWT.NONE);
		btnGestaoProjetos.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnGestaoProjetos.setBounds(126, 175, 182, 30);
		btnGestaoProjetos.setText("Gestão de projetos");
		
		Button btnVoltar = new Button(shell, SWT.NONE);
		btnVoltar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnVoltar.setBounds(10, 10, 29, 30);
		btnVoltar.setText(" ←");

	}
}
