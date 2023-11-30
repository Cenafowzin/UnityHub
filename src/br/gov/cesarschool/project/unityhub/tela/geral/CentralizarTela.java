package br.gov.cesarschool.project.unityhub.tela.geral;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;

public class CentralizarTela {
	
    public static void centralizarJanela(Shell shell) {
        // Obtém o monitor primário
        Monitor primary = shell.getDisplay().getPrimaryMonitor();
        Rectangle bounds = primary.getBounds();

        // Calcula a posição central da tela
        int x = bounds.x + (bounds.width - shell.getBounds().width) / 2;
        int y = bounds.y + (bounds.height - shell.getBounds().height) / 2;

        // Define a localização central para a janela
        shell.setLocation(x, y);
    }
}
