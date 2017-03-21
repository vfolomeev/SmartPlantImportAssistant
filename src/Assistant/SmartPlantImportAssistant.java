package Assistant;
 
import java.util.ArrayList;
import java.util.List;
import star.assistant.SimulationAssistant;
import star.assistant.Task;
import star.assistant.annotation.StarAssistant;
 
// Specifies the name of the Simulation Assistant in the GUI.
@StarAssistant(display = "Internal Flow Assistant")
public class SmartPlantImportAssistant extends SimulationAssistant {
 
    public SmartPlantImportAssistant() {
        // Creates a new array list for the list of tasks.
        List<Task> tasks = new ArrayList<Task>();
        // Contains the list of tasks.
        tasks.add(new ImportGeometry());
        setOutline(tasks);
    }
}