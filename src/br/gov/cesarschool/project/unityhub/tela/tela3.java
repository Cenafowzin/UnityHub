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

public class tela3 {

	protected Shell shell;
	private Text text;
	private Label lblProjetos;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			tela3 window = new tela3();
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
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(99, 21, 212, 26);
		
		Button btnBuscar = new Button(shell, SWT.NONE);
		btnBuscar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnBuscar.setBounds(317, 19, 46, 30);
		btnBuscar.setText("🔍︎");
		
		lblProjetos = new Label(shell, SWT.NONE);
		lblProjetos.setBounds(173, 74, 70, 20);
		lblProjetos.setText("Projetos");
		
		List list = new List(shell, SWT.BORDER);
		list.setBounds(98, 116, 236, 310);

	}
}
