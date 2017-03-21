/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assistant;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import star.base.neo.IntVector;
import star.common.Simulation;
import star.common.SimulationPartManager;
import star.common.Units;
import star.meshing.MeshPartFactory;
import star.meshing.SimpleCylinderPart;
/**
 *
 * @author vfolomeev
 */
public class Structure {
    ArrayList<Part> partsList;
    
    public Structure(File file){
        try{
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // Создается дерево DOM документа из файла
            Document document = documentBuilder.parse(file);
            document.normalize();
 
            // Получаем корневой элемент
            Element root = document.getDocumentElement();
            root.normalize();
            NodeList partList=root.getElementsByTagName("CSPSMemberPartPrismatic");
            this.partsList=new ArrayList<Part>();
            this.partsList.clear();
            int len=partList.getLength();
            
            
            for(int i=0;i!=len;i++){
                
                Element node=(Element) partList.item(i);
                Part p= new Part(node);
                this.partsList.add(p);
                
        
            }
               
        }
        catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);
    }
        catch (SAXException ex) {
            ex.printStackTrace(System.out);
    }   catch (IOException ex) {
            ex.printStackTrace(System.out);   
}
    
    
    }
    
    @Override
    public String toString(){
        String s="";
        for(Part p:this.partsList){
            s=s+p+"\n";
        }
        
        return s;
    }
    public void draw(Simulation sim){
        
        Units units = sim.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
        MeshPartFactory factory= sim.get(MeshPartFactory.class);
        
        for(Part p:this.partsList){
            SimpleCylinderPart cyl = factory.createNewCylinderPart(sim.get(SimulationPartManager.class));
            p.draw(cyl, units);
        }
    }
    
    
}
