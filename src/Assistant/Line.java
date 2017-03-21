/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assistant;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import star.common.Coordinate;
import star.common.Units;
import star.meshing.SimpleCylinderPart;

/**
 *
 * @author vfolomeev
 */
public class Line {

    Vector3d start;
    Vector3d end;

    public Line() {
        this.start = new Vector3d();
        this.end = new Vector3d(1.0, 1.0, 1.0);

    }

    public Line(Element node) {
        NodeList startList = node.getElementsByTagName("StartPoint");
        Element startNode = (Element) startList.item(0);
        this.start = new Vector3d(startNode);
        NodeList endList = node.getElementsByTagName("EndPoint");
        Element endNode = (Element) endList.item(0);
        this.end = new Vector3d(endNode);

    }

    @Override
    public String toString() {

        return " start=" + this.start + "\n end=" + this.end;
    }

    public void draw(SimpleCylinderPart cyl, Units units) {

        Coordinate point1 = cyl.getStartCoordinate();
        point1.setCoordinate(units, units, units, this.start.toDoubleVector());

        Coordinate point2 = cyl.getEndCoordinate();
        point2.setCoordinate(units, units, units, this.end.toDoubleVector());
        cyl.getRadius().setUnits(units);
        cyl.getRadius().setValue(0.05);

        cyl.rebuildSimpleShapePart();

        cyl.setDoNotRetessellate(false);

    }
}
