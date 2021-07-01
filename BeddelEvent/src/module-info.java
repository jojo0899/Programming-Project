module BeddelEvent {
	exports org.openstreetmap.gui.jmapviewer.events;
	exports org.openstreetmap.gui.jmapviewer.tilesources;
	exports Functionalities;
	exports org.openstreetmap.gui.jmapviewer.interfaces;
	exports org.openstreetmap.gui.jmapviewer;
	exports GUI;
	exports org.openstreetmap.gui.jmapviewer.checkBoxTree;
	exports DB;

	requires commons.codec;
	requires java.desktop;
	requires java.logging;
	requires java.sql;
	requires java.xml;
	requires javax.mail;
	requires jcalendar;
	requires json.simple;
	requires log4j;
}