package br.gov.cesarschool.project.unityhub.tela;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import br.gov.cesarschool.project.unityhub.entidade.Colaborador;
import br.gov.cesarschool.project.unityhub.entidade.Projeto;
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

public class TelaProjetosGerencia {
	
	private Colaborador colaborador;
	protected Shell shell;
	private Text buscar;
	private Label lblProjetos;
	private Button btnVoltar;
	ProjetoMediator mediator = ProjetoMediator.getInstancia();
	private Composite composite;
	
	public TelaProjetosGerencia(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TelaProjetosGerencia window = new TelaProjetosGerencia(null);
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
	    shell.setSize(527, 618);
	    shell.setText("SWT Application");

	    composite = new Composite(shell, SWT.NONE);
	    composite.setLayout(new GridLayout(1, false));
	    composite.setBounds(37, 100, 430, 418); // Definindo bounds para o composite

	    Projeto[] projetos = mediator.listarProjetos();
	    if (projetos != null) {
	        for (Projeto projeto : projetos) {
	            Button btnProjeto = new Button(composite, SWT.NONE);
	            btnProjeto.setText(projeto.getNome());
	            btnProjeto.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
	            btnProjeto.addSelectionListener(new SelectionAdapter() {
	    			@Override
	    			public void widgetSelected(SelectionEvent e) {
	                    shell.dispose(); // Fecha a janela atual

	                    TelaDetalhesProjeto novaJanela = new TelaDetalhesProjeto(colaborador, projeto);
	                    novaJanela.open(); // Abre a nova janela
	                }
	    		});
	        }
	    }

	    composite.layout();
		
		buscar = new Text(shell, SWT.BORDER);
		buscar.setBounds(109, 21, 271, 26);
		
		Button btnBuscar = new Button(shell, SWT.NONE);
		btnBuscar.setBounds(386, 19, 46, 30);
		btnBuscar.setText("🔍︎");
		
		btnBuscar.addSelectionListener(new SelectionAdapter() {
		    @Override
		    public void widgetSelected(SelectionEvent e) {
		        String searchText = buscar.getText().toLowerCase();
		        composite.dispose(); // Descarta o composite antigo

		        // Cria um novo Composite após descartar o antigo
		        composite = new Composite(shell, SWT.NONE);
		        composite.setLayout(new GridLayout(1, false));
		        composite.setBounds(10, 100, 430, 418);

		        Projeto[] projetos = mediator.listarProjetos();
		        if (projetos != null) {
		            for (Projeto projeto : projetos) {
		                if (projeto.getNome().toLowerCase().contains(searchText)) {
		                    Button btnProjeto = new Button(composite, SWT.NONE);
		                    btnProjeto.setText(projeto.getNome());
		                    btnProjeto.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		                    btnProjeto.addSelectionListener(new SelectionAdapter() {
		    	    			@Override
		    	    			public void widgetSelected(SelectionEvent e) {
		    	                    shell.dispose(); // Fecha a janela atual

		    	                    TelaDetalhesProjeto novaJanela = new TelaDetalhesProjeto(colaborador, projeto);
		    	                    novaJanela.open(); // Abre a nova janela
		    	                }
		    	    		});
		                }
		            }
		        }
		        composite.layout();
		        shell.layout(); // Atualiza o layout do shell para refletir as mudanças
		    }
		});
		
		lblProjetos = new Label(shell, SWT.NONE);
		lblProjetos.setBounds(218, 65, 70, 20);
		lblProjetos.setText("Projetos");
		
		btnVoltar = new Button(shell, SWT.NONE);
		btnVoltar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
                shell.dispose(); // Fecha a janela atual

                TelaMenu novaJanela = new TelaMenu(colaborador);
                novaJanela.open(); // Abre a nova janela
            }
		});
		btnVoltar.setBounds(31, 19, 46, 30);
		btnVoltar.setText(" ←");

	}
}
