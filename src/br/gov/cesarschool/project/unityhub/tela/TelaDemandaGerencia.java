package br.gov.cesarschool.project.unityhub.tela;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import br.gov.cesarschool.project.unityhub.entidade.Colaborador;
import br.gov.cesarschool.project.unityhub.entidade.Pedido;
import br.gov.cesarschool.project.unityhub.negocio.ProjetoMediator;
import br.gov.cesarschool.project.unityhub.tela.geral.TelaUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;

public class TelaDemandaGerencia {
	
	private Colaborador colaborador;
	protected Shell shell;
	private Label lblProjetos;
	private Button btnVoltar;
	ProjetoMediator mediator = ProjetoMediator.getInstancia();
	private Composite composite;
	
	public TelaDemandaGerencia(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TelaDemandaGerencia window = new TelaDemandaGerencia(null);
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
	    shell.setSize(450, 528);
	    shell.setText("SWT Application");

	    composite = new Composite(shell, SWT.NONE);
	    composite.setLayout(new GridLayout(1, false));
	    composite.setBounds(10, 100, 430, 418); // Definindo bounds para o composite

	    Pedido[] pedidos = mediator.listarPedidos();
	    if (pedidos != null) {
	        for (Pedido pedido : pedidos) {
	            Button btnProjeto = new Button(composite, SWT.NONE);
	            btnProjeto.setText("Demanda " + pedido.getId());
	            btnProjeto.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
	            btnProjeto.addSelectionListener(new SelectionAdapter() {
	    			@Override
	    			public void widgetSelected(SelectionEvent e) {
	                    shell.dispose(); // Fecha a janela atual

	                    //TelaDetalhesPedido novaJanela = new TelaDetalhesPedido(colaborador,pedido);
	                    //novaJanela.open(); // Abre a nova janela
	                }
	    		});
	        }
	    }

	    composite.layout();
		
		lblProjetos = new Label(shell, SWT.NONE);
		lblProjetos.setBounds(173, 74, 70, 20);
		lblProjetos.setText("Demandas");
		
		btnVoltar = new Button(shell, SWT.NONE);
		btnVoltar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
                shell.dispose(); // Fecha a janela atual

                TelaMenu novaJanela = new TelaMenu(colaborador);
                novaJanela.open(); // Abre a nova janela
            }
		});
		btnVoltar.setBounds(10, 19, 46, 30);
		btnVoltar.setText(" ←");

	}
}
