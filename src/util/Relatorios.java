package util;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author felip
 */
public class Relatorios {

    public static void relatorio(String nomeRelatorio, String chave, String parametro) throws IOException {
        //Conexao c = new Conexao();
        Conexao.conectar();

        try {

            //String jrxmlPath = "src/relatorios/" + nomeRelatorio + ".jrxml";
            //String jasperPath = "src/relatorios/" + nomeRelatorio + ".jasper";
            Map<String, Object> parameters = new HashMap<>();
            //parameters.put(chave, parametro);

            JasperCompileManager.compileReportToFile("src\\relatorios\\" + nomeRelatorio + ".jrxml");
            // Compila e cria o .jasper
            //JasperCompileManager.compileReportToFile(jrxmlPath, jasperPath);

            JasperPrint print = JasperFillManager.fillReport("src\\relatorios\\" + nomeRelatorio + ".jasper", parameters, Conexao.conector);
            // Usa o .jasper compilado
            //JasperPrint print = JasperFillManager.fillReport(jasperPath, parameters, Conexao.conector);

            JasperViewer viewer = new JasperViewer(print, false);
            //viewer.setVisible(true);

            if (print.getPages().isEmpty()) {
                System.out.println("====================== Relatório está vazio (sem páginas).");
            } else {
                System.out.println("========================== Relatório gerado com sucesso. Total de páginas: " + print.getPages().size());
            }

            JasperExportManager.exportReportToPdfFile(print, nomeRelatorio + ".pdf");

            String aleatorio = System.getProperty("java.io.tmpdir") + File.separator + "relatorio_" + System.currentTimeMillis() + ".pdf";
            JasperExportManager.exportReportToPdfFile(print, aleatorio);

            Desktop desktop = Desktop.getDesktop();
            File file = new File(aleatorio);
            desktop.open(file);

        } catch (JRException e) {
            throw new RuntimeException("ImpossÃ­vel abrir relatÃ³rio! ", e);
        } finally {
            if (Conexao.conector != null) {
                Conexao.desconectar();
            }

        }

    }

}
