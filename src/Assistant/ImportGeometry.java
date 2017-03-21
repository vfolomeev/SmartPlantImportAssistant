package Assistant;

import java.io.File;

import javax.swing.JFileChooser;

import star.assistant.Task;
import star.assistant.annotation.StarAssistantTask;
import star.assistant.ui.FunctionTaskController;
import star.common.Simulation;

@StarAssistantTask(display = "Import Geometry",
        contentPath = "XHTML/ImportGeometry.xhtml",
        controller = ImportGeometry.ImportGeometryTaskController.class)
public class ImportGeometry extends Task {

    public ImportGeometry() {
    }

    public class ImportGeometryTaskController extends FunctionTaskController {

        public void importGeometryDialog() {

            //open a file chooser
            System.out.println("Hello world");
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
                return;
            }
            File xmlFile = fileChooser.getSelectedFile();
            Structure struct = new Structure(xmlFile);
            System.out.println(struct);
            Simulation sim = getActiveSimulation();

            struct.draw(sim);
        }
    }
}
