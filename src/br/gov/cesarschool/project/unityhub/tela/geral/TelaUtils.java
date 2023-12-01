package br.gov.cesarschool.project.unityhub.tela.geral;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Monitor;

public class TelaUtils {
	
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
    
    public static void mostrarMensagemErro(String mensagem, Shell shell) {
	    MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR | SWT.OK);
	    messageBox.setMessage(mensagem);
	    messageBox.open();
	}
}
