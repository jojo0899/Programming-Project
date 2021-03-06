// License: GPL. For details, see Readme.txt file.
package Functionalities;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.List;
import java.awt.Point;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.JMapViewerTree;
import org.openstreetmap.gui.jmapviewer.Layer;
import org.openstreetmap.gui.jmapviewer.LayerGroup;
import org.openstreetmap.gui.jmapviewer.MapMarkerCircle;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;
import org.openstreetmap.gui.jmapviewer.MapRectangleImpl;
import org.openstreetmap.gui.jmapviewer.OsmTileLoader;
import org.openstreetmap.gui.jmapviewer.events.JMVCommandEvent;
import org.openstreetmap.gui.jmapviewer.interfaces.JMapViewerEventListener;
import org.openstreetmap.gui.jmapviewer.interfaces.MapPolygon;
import org.openstreetmap.gui.jmapviewer.interfaces.TileLoader;
import org.openstreetmap.gui.jmapviewer.interfaces.TileSource;
import org.openstreetmap.gui.jmapviewer.tilesources.BingAerialTileSource;
import org.openstreetmap.gui.jmapviewer.tilesources.OsmTileSource;

/**
 * Demonstrates the usage of {@link JMapViewer}
 *
 * @author Jan Peter Stotz
 *
 */
public class Map extends JPanel implements JMapViewerEventListener {
	private int counter =0;
    private static final long serialVersionUID = 1L;
    public static double xtemp;
    public static double ytemp;
    private final JMapViewerTree treeMap;
    MapMarkerDot controlDot = null;
    public static ArrayList<String>  xMark = new ArrayList<>();
	public static ArrayList<String>  yMark = new ArrayList<>();
	public static ArrayList<String>  nMark = new ArrayList<>();
	public static String label;
	public static String x;
	public static String y;
    

    private final JLabel zoomLabel;
    private final JLabel zoomValue;

    private final JLabel mperpLabelName;
    private final JLabel mperpLabelValue;
    
    /**
     * Constructs the {@code Demo}.
     * @throws SQLException 
     */
    public Map() throws SQLException {
    	
        DB.DB.getMakers();
        
     
         
        
        
        //super("JMapViewer Demo");
        setSize(800, 400);

        treeMap = new JMapViewerTree("Zones");

        // Listen to the map viewer for user operations so components will
        // receive events and update
        map().addJMVListener(this);

        setLayout(new BorderLayout());
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        JPanel panel = new JPanel(new BorderLayout());
        JPanel panelTop = new JPanel();
        JPanel panelBottom = new JPanel();
        JPanel helpPanel = new JPanel();

        mperpLabelName = new JLabel("Meters/Pixels: ");
        mperpLabelValue = new JLabel(String.format("%s", map().getMeterPerPixel()));

        zoomLabel = new JLabel("Zoom: ");
        zoomValue = new JLabel(String.format("%s", map().getZoom()));

        add(panel, BorderLayout.NORTH);
        add(helpPanel, BorderLayout.SOUTH);
        panel.add(panelTop, BorderLayout.NORTH);
        panel.add(panelBottom, BorderLayout.SOUTH);
        JLabel helpLabel = new JLabel("Rechte Maustaste zum Bewegen\n "
                + "und Mausrad zum Zoomen.");
        helpPanel.add(helpLabel);
        JButton button = new JButton("setDisplayToFitMapMarkers");
        button.addActionListener(e -> map().setDisplayToFitMapMarkers());
        JComboBox<TileSource> tileSourceSelector = new JComboBox<>(new TileSource[] {
                new OsmTileSource.Mapnik(),
                new OsmTileSource.TransportMap(),
                new BingAerialTileSource(),
        });
        tileSourceSelector.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                map().setTileSource((TileSource) e.getItem());
            }
        });
        JComboBox<TileLoader> tileLoaderSelector;
        tileLoaderSelector = new JComboBox<>(new TileLoader[] {new OsmTileLoader(map())});
        tileLoaderSelector.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                map().setTileLoader((TileLoader) e.getItem());
            }
        });
        map().setTileLoader((TileLoader) tileLoaderSelector.getSelectedItem());
       // panelTop.add(tileSourceSelector);
     //   panelTop.add(tileLoaderSelector);
        final JCheckBox showMapMarker = new JCheckBox("Map markers visible");
        showMapMarker.setSelected(map().getMapMarkersVisible());
        showMapMarker.addActionListener(e -> map().setMapMarkerVisible(showMapMarker.isSelected()));
       // panelBottom.add(showMapMarker);
        ///
        final JCheckBox showTreeLayers = new JCheckBox("Tree Layers visible");
        showTreeLayers.addActionListener(e -> treeMap.setTreeVisible(showTreeLayers.isSelected()));
       // panelBottom.add(showTreeLayers);
        ///
        final JCheckBox showToolTip = new JCheckBox("ToolTip visible");
        showToolTip.addActionListener(e -> map().setToolTipText(null));
       // panelBottom.add(showToolTip);
        ///
        final JCheckBox showTileGrid = new JCheckBox("Tile grid visible");
        showTileGrid.setSelected(map().isTileGridVisible());
        showTileGrid.addActionListener(e -> map().setTileGridVisible(showTileGrid.isSelected()));
        //panelBottom.add(showTileGrid);
        final JCheckBox showZoomControls = new JCheckBox("Show zoom controls");
        showZoomControls.setSelected(map().getZoomControlsVisible());
        showZoomControls.addActionListener(e -> map().setZoomControlsVisible(showZoomControls.isSelected()));
       // panelBottom.add(showZoomControls);
        final JCheckBox scrollWrapEnabled = new JCheckBox("Scrollwrap enabled");
        scrollWrapEnabled.addActionListener(e -> map().setScrollWrapEnabled(scrollWrapEnabled.isSelected()));
       // panelBottom.add(scrollWrapEnabled);
       // panelBottom.add(button);

       // panelTop.add(zoomLabel);
      //  panelTop.add(zoomValue);
       // panelTop.add(mperpLabelName);
      //  panelTop.add(mperpLabelValue);

        add(treeMap, BorderLayout.CENTER);

        LayerGroup germanyGroup = new LayerGroup("Germany");
        Layer germanyWestLayer = germanyGroup.addLayer("Germany West");

        //FUNKTION F?R AKTUELL GESETZT WAYPOINTS SETZEN
        
        treeMap.addLayer(germanyWestLayer);
        int size = Map.nMark.size();
        
//        System.out.println(Map.nMark);
        
  
            
      
        int j=0;
      	
        for(int i=0;i<size;i++) {
        	if(i%3==0) {
        		label = Map.nMark.get(i);
        		x =Map.nMark.get(i+1);
                y = Map.nMark.get(i+2);
            
            	double xd = Double.parseDouble(x);
                double yd = Double.parseDouble(y);
                MapMarkerDot testerererer=new MapMarkerDot(germanyWestLayer,label,xd,yd);
                map().addMapMarker(testerererer);           	
    			}
        	    

    
        }
     	
        
        
        
        
       
      
//        
    	double xd = Double.parseDouble(x);
        double yd = Double.parseDouble(y);
        MapMarkerDot testerererer=new MapMarkerDot(germanyWestLayer,label,xd,yd);
        map().addMapMarker(testerererer);
//        
        // map.setDisplayPosition(new Coordinate(49.807, 8.6), 11);
        // map.setTileGridVisible(true);

        map().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
            
                    map().getAttribution().handleAttribution(e.getPoint(), true);
                    
                    if(controlDot==null) {
                    	System.out.println("noch kein punkt vorhanden");
                    xtemp= map().getPosition(getMousePosition()).getLat();
                    ytemp =map().getPosition(getMousePosition()).getLon();
                    MapMarkerDot MyEvent= new MapMarkerDot(germanyWestLayer, "Meine Veranstaltung",xtemp,ytemp);
                    controlDot = MyEvent;
                    map().addMapMarker(controlDot);
                    }else {
                    	System.out.println("punkt ovrhanden");
                    	map().removeMapMarker(controlDot);
                    	 xtemp= map().getPosition(getMousePosition()).getLat();
                         ytemp =map().getPosition(getMousePosition()).getLon();
                         MapMarkerDot MyEvent= new MapMarkerDot(germanyWestLayer, "Meine Veranstaltung",xtemp,ytemp);
                         controlDot = MyEvent;
                         map().addMapMarker(controlDot);
                    }
                    
                    
                             
                                       
                    
                    System.out.println(xtemp);
                    System.out.println(ytemp);
                    counter++;
                   }
                
            }
        });

        map().addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Point p = e.getPoint();
                boolean cursorHand = map().getAttribution().handleAttributionCursor(p);
                if (cursorHand) {
                    map().setCursor(new Cursor(Cursor.HAND_CURSOR));
                } else {
                    map().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
                if (showToolTip.isSelected()) map().setToolTipText(map().getPosition(p).toString());
            }
        });
    }

    private JMapViewer map() {
        return treeMap.getViewer();
    }

    private static Coordinate c(double lat, double lon) {
    	
        return new Coordinate(lat, lon);
    }

    /**
     * @param args Main program arguments
     * @throws SQLException 
     */
    public static void main(String[] args) throws SQLException {
        new Map().setVisible(true);
    }

    private void updateZoomParameters() {
        if (mperpLabelValue != null)
            mperpLabelValue.setText(String.format("%s", map().getMeterPerPixel()));
        if (zoomValue != null)
            zoomValue.setText(String.format("%s", map().getZoom()));
    }

    @Override
    public void processCommand(JMVCommandEvent command) {
        if (command.getCommand().equals(JMVCommandEvent.COMMAND.ZOOM) ||
                command.getCommand().equals(JMVCommandEvent.COMMAND.MOVE)) {
            updateZoomParameters();
        }
    }
}
