package br.gov.cesarschool.project.unityhub.tela;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import br.gov.cesarschool.project.unityhub.tela.geral.TelaUtils;
import org.eclipse.swt.SWT;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class telaPronto {

	protected Shell shell;
	private Text txtTudoPronto;
	private LocalResourceManager localResourceManager;
	private Text text;
	private Text txtCadastroRealizado;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			telaPronto window = new telaPronto();
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
		createResourceManager();
		shell.setSize(450, 620);
		shell.setText("SWT Application");
		
		txtTudoPronto = new Text(shell, SWT.READ_ONLY);
		txtTudoPronto.setEditable(false);
		txtTudoPronto.setEnabled(false);
		txtTudoPronto.setText("Tudo Pronto!");
		txtTudoPronto.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 30, SWT.BOLD)));
		txtTudoPronto.setBounds(39, 98, 328, 73);
		
		Button btnHome = new Button(shell, SWT.NONE);
		btnHome.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
                shell.dispose(); // Fecha a janela atual
                // Agora, abra a tela de login
                telaLoginGeral loginWindow = new telaLoginGeral();
                loginWindow.open(); 
			}
		});
		btnHome.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 14, SWT.NORMAL)));
		btnHome.setBounds(122, 479, 194, 35);
		btnHome.setText("Voltar para home");
		
		text = new Text(shell, SWT.NONE);
		text.setEditable(false);
		text.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_GREEN));
		text.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 99, SWT.NORMAL)));
		text.setText("✔");
		text.setBounds(94, 177, 217, 229);
		
		txtCadastroRealizado = new Text(shell, SWT.NONE);
		txtCadastroRealizado.setEditable(false);
		txtCadastroRealizado.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 12, SWT.BOLD)));
		txtCadastroRealizado.setText("Seu cadastro foi realizado com sucesso!\n");
		txtCadastroRealizado.setBounds(24, 412, 387, 35);

	}
	private void createResourceManager() {
		localResourceManager = new LocalResourceManager(JFaceResources.getResources(),shell);
	}
}