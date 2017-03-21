
package Assistant;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import star.common.Units;
import star.meshing.SimpleCylinderPart;
/**
 *
 * @author vfolomeev
 */
public class Part {
    Line l;
    public Part(Element node){
        
        NodeList pathList=node.getElementsByTagName("Path");
        Element path=(Element) pathList.item(0);
                
        NodeList byTwoPortsList=path.getElementsByTagName("ByTwoPorts");
        Element byTwoPorts=(Element) byTwoPortsList.item(0);
          
        this.l=new Line(byTwoPorts);
     
    
    }
    
    @Override
    public String toString()
    {
        
        return " Line="+this.l;
    }
    public void draw( SimpleCylinderPart cyl, Units units){
        this.l.draw(cyl, units);
    }
    
}
