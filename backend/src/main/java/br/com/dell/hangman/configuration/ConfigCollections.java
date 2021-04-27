package br.com.dell.hangman.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import br.com.dell.hangman.entity.Game;
import br.com.dell.hangman.entity.Word;

@Configuration
public class ConfigCollections {
	@Value("resources/hangman.xml")
	Resource resourceFile;
	private static int id = 1;
	@Bean
	public List<Game> produceGame(){
		return new ArrayList<>();
	}
	
	
	@Bean
	public List<Word> produceWord(){
		List<String> listStringWords = createListFromXmlFile();
		return createList(listStringWords);
	}


	private List<String> createListFromXmlFile() {
		List<String> list = new ArrayList<>();
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
	
	        Document doc = db.parse(resourceFile.getFile());
	        doc.getDocumentElement().normalize();
	        NodeList listNodes = doc.getElementsByTagName("word");
	        
	        for(int i= 0; i< listNodes.getLength();i++) {
	        	list.add(listNodes.item(i).getFirstChild().getNodeValue());
	        }
	        
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	private List<Word> createList(List<String> listStringWords) {
		return listStringWords.stream().map(str-> new Word(getId(),str,str.length())).collect(Collectors.toList());
	}
	
	private static synchronized Integer getId() {
		return new Integer(id++);
	}
}
