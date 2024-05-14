package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class WeatherFetcher {

    //Singleton, that provide only one instance for this class
    private static WeatherFetcher instance;

    private WeatherFetcher() {

    }

    public static WeatherFetcher getInstance() {
        if (instance == null) {
            instance = new WeatherFetcher();

        }
        return instance;
    }

    public WeatherInfo[] fetch(String city) throws Exception{

        String uri = "https://api.openweathermap.org/data/2.5/forecast?q=" + city + "&mode=xml&appid=cfee61f2b7867ee48cabac9d3c5853e9";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse(uri);

        NodeList times = document.getElementsByTagName("time");

         WeatherInfo[] weatherInfos = new WeatherInfo[times.getLength()];

        for(int x = 0; x< times.getLength(); x++){
            Node time = times.item(x);
            NamedNodeMap timeAttribute = time.getAttributes();
            String timestamp = timeAttribute.getNamedItem("from").getNodeValue();

            String temperature = null;
            String humidity = null;
            String windspeed = null;
            String cloud = null;

            NodeList children = time.getChildNodes();
            for (int j = 0; j<children.getLength(); j++){
                Node child = children.item(j);

                if(child.getNodeName() == "temperature"){
                    temperature = child.getAttributes().getNamedItem("value").getNodeValue();
                }

                if(child.getNodeName() == "humidity"){
                   humidity = child.getAttributes().getNamedItem("value").getNodeValue();
                }

                if(child.getNodeName() == "windSpeed"){
                    windspeed = child.getAttributes().getNamedItem("mps").getNodeValue();
                }

                if(child.getNodeName() == "clouds"){
                    cloud = child.getAttributes().getNamedItem("value").getNodeValue();
                }
            }
            weatherInfos[x] = new WeatherInfo(timestamp, temperature, humidity, windspeed, cloud);

        }
        return weatherInfos;
    }
}
