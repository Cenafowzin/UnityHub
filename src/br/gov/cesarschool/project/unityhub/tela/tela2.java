package br.gov.cesarschool.project.unityhub.tela;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class tela2 {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			tela2 window = new tela2();
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
		
		Label lblBemVindoColaborador = new Label(shell, SWT.NONE);
		lblBemVindoColaborador.setBounds(140, 45, 168, 27);
		lblBemVindoColaborador.setText("Bem-vindo colaborador");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton.setBounds(131, 104, 177, 30);
		btnNewButton.setText("Gestão de embaixadores");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.setBounds(126, 175, 182, 30);
		btnNewButton_1.setText("Gestão de projetos");
		
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
