package com.example.config;

import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class XMLTransformer {
    public XStream xstream = null;

    public XMLTransformer() {
        xstream = new XStream();
        xstream.addPermission(AnyTypePermission.ANY);
    }

    public static XMLTransformer getInstance() {
        return new XMLTransformer();
    }

    public String toXMLString(Object object) {
        return xstream.toXML(object);
    }

    public List<YoutubeDataSerializer> toObject(String xml) {
        return (List<YoutubeDataSerializer>) xstream.fromXML(xml);
    }

}
