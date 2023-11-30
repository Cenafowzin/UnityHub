package br.gov.cesarschool.project.unityhub.tela;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.List;

public class telaProjetosEmbaixador {

	protected Shell shell;
	private Text buscar;
	private Label lblProjetos;
	private Button btnVoltar;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			telaProjetosEmbaixador window = new telaProjetosEmbaixador();
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
		shell.setSize(450, 528);
		shell.setText("SWT Application");
		
		buscar = new Text(shell, SWT.BORDER);
		buscar.setBounds(99, 21, 212, 26);
		
		Button btnBuscar = new Button(shell, SWT.NONE);
		btnBuscar.setBounds(317, 19, 46, 30);
		btnBuscar.setText("🔍︎");
		
		lblProjetos = new Label(shell, SWT.NONE);
		lblProjetos.setBounds(173, 74, 70, 20);
		lblProjetos.setText("Projetos");
		
		List list = new List(shell, SWT.BORDER);
		list.setBounds(98, 116, 236, 80);
		
		btnVoltar = new Button(shell, SWT.NONE);
		btnVoltar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
                shell.dispose(); // Fecha a janela atual

                telaMenuEmbaixador novaJanela = new telaMenuEmbaixador();
                novaJanela.open(); // Abre a nova janela
            }
		});
		btnVoltar.setBounds(10, 19, 46, 30);
		btnVoltar.setText(" ←");

	}
}
