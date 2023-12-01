package br.gov.cesarschool.project.unityhub.tela;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import br.gov.cesarschool.project.unityhub.tela.geral.TelaUtils;
import org.eclipse.swt.widgets.List;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class telaGestaoDemanda {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			telaGestaoDemanda window = new telaGestaoDemanda();
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
		
		ListViewer listViewer = new ListViewer(shell, SWT.BORDER | SWT.V_SCROLL);
		List list = listViewer.getList();
		list.setBounds(141, 90, 166, 116);
		
		Label lblDemandas = new Label(shell, SWT.NONE);
		lblDemandas.setBounds(185, 42, 70, 20);
		lblDemandas.setText("Demandas:");
		
		Button btnVoltar = new Button(shell, SWT.NONE);
		btnVoltar.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
                shell.dispose(); // Fecha a janela atual

                telaMenuEmbaixador novaJanela = new telaMenuEmbaixador();
                novaJanela.open(); // Abre a nova janela
            }
		});
		
		btnVoltar.setBounds(10, 10, 54, 30);
		btnVoltar.setText(" ←");
		
		

	}
}
