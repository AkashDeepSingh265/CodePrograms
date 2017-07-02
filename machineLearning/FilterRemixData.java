import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bsb.portal.config.MongoDBConfig;
import com.bsb.portal.db.MongoDBManager;
import com.bsb.portal.db.dao.CMSDao;
import com.bsb.portal.dto.AlbumMetadata;
import com.bsb.portal.util.HttpClient;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;




public class FilterRemixData {

	public static final String locationData = "/Users/akashdeep/data/search/data1.csv";
	public static final String outPutLocationRemix = "/Users/akashdeep/data/search/remix2.csv";
	public static final String outPutLocationOriginal = "/Users/akashdeep/data/search/original.csv";
	public static final String artistsRemixCount = "/Users/akashdeep/data/search/artistRemixCount.csv";
	
	public static List<String> remixIdentifier ;
	public static HashMap<String, Integer> artistCountMap = new HashMap<String, Integer>();
	private MongoDBManager       mongoCMSDBManager;
	private CMSDao cmsDao;
	
	public FilterRemixData() throws IOException{
		init();
	}
	
	private void init() throws IOException{
		remixIdentifier = new ArrayList<String>();
		remixIdentifier.add("remix");
		remixIdentifier.add("acoustic");
		remixIdentifier.add("mashup");
		remixIdentifier.add("instrumental");
		MongoDBConfig config = new MongoDBConfig();
		config.setMongoDBName("cmsdb");
		config.setMongodbHost("10.0.8.73");
		config.setMongodbPort(27017);
		mongoCMSDBManager = new MongoDBManager(config);
		cmsDao = new CMSDao(mongoCMSDBManager);
		loadArtistFromDisk();
	}
	
	public void loadArtistFromDisk() throws IOException{
		CSVReader reader = new CSVReader(new BufferedReader(new FileReader(artistsRemixCount)));
		String[] line ;
		while((line=reader.readNext()) !=null){
			artistCountMap.put(line[0], Integer.valueOf(line[1]));
		}
		reader.close();
	}
	
	public void segregateData() throws IOException, ParseException{
		int count = 500;
		int remixCount = 0;
		int originalCount = 0 ;
		CSVReader reader = new CSVReader(new FileReader(locationData));
		CSVWriter remixWriter = new CSVWriter(new FileWriter(outPutLocationRemix));
		//CSVWriter originalWriter = new CSVWriter(new FileWriter(outPutLocationOriginal));
		String[] line = reader.readNext();
		while((line=reader.readNext())!=null){
			if(isRemix(line[1])){
					if(remixCount++ < count)
						remixWriter.writeNext(adaptData(line,true));
			}else{
				if(!isRemix(line[2]) && originalCount++ < count)
				remixWriter.writeNext(adaptData(line,false));
			}
		}
		reader.close();
		remixWriter.close();
		//originalWriter.close();
	}
	
	public void segregateData1() throws IOException, ParseException{
		int count = 500;
		int remixCount = 0;
		int originalCount = 0 ;
		CSVReader reader = new CSVReader(new FileReader(locationData));
		CSVWriter remixWriter = new CSVWriter(new FileWriter(outPutLocationRemix));
		//CSVWriter originalWriter = new CSVWriter(new FileWriter(outPutLocationOriginal));
		String[] line = reader.readNext();
		while((line=reader.readNext())!=null){
			if(isRemix(line[1])){
					if(remixCount++ < count)
						remixWriter.writeNext(adaptData(line,true));
			}else{
				if(!isRemix(line[2]) && originalCount++ < count)
				remixWriter.writeNext(adaptData(line,false));
			}
		}
		reader.close();
		remixWriter.close();
		//originalWriter.close();
	}
	private String[] adaptData(String[] originalLine, boolean isRemix) throws ParseException {
		//String[] line = new String[originalLine.length+1];
		System.out.println(Arrays.toString(originalLine));
		String[] line = Arrays.copyOf(originalLine, originalLine.length+5);
		String contentId= originalLine[0];
		
		String title = originalLine[1];
		
		if(isRemix(title)){
			line[1] = "1";
		}else{
			line[1] = "0";
		}
		
		String albumTitle = originalLine[2];
		if(isRemix(albumTitle)){
			line[2] = "1";
		}else{
			line[2] = "0";
		}
		
		String artistTitle = originalLine[3];
		if(artistTitle.toLowerCase().contains("dj")){
			line[3] = "1";
		}else{
			line[3] = "0";
		}
		String lyricist = originalLine[4];
		if(lyricist.toLowerCase().contains("dj")){
			line[4] = "1";
		}else{
			line[4] = "0";
		}
		
		String director = originalLine[5];
		if(director.toLowerCase().contains("dj")){
			line[5] = "1";
		}else{
			line[5] = "0";
		}
		
		String composer = originalLine[6];
		if(composer.toLowerCase().contains("dj")){
			line[6] = "1";
		}else{
			line[6] = "0";
		}
		
		//#popularity of artist
		line[line.length-5] = Float.toString(getArtistPopularity(artistTitle));
		//#songs sung by artist
		line[line.length-4] = Integer.toString(getArtistCount(artistTitle));
		//#songs in album
		line[line.length-3] = Integer.toString(cmsDao.getAlbum(cmsDao.getContentMetadata(contentId).getAlbumId()).getSize());
		//#remix songs sung by artits
		if(artistCountMap.get(artistTitle.toLowerCase())!=null)
			line[line.length-2] = Integer.toString(artistCountMap.get(artistTitle.toLowerCase()));
		else
			line[line.length-2] = "0";
		
		if(isRemix)
			line[line.length-1] = "true";
		else
			line[line.length-1] = "false";
		return line;
	}

	private float getArtistPopularity(String artistName) throws ParseException {
		String json = HttpClient.getContent("http://10.0.7.232:8080/solr/cms-artist/select?q=title:\""+artistName+"\"&wt=json&indent=true");
		if(StringUtils.isEmpty(json))
			return 0f;
		JSONParser parser = new JSONParser();
		JSONObject jsonobj = (JSONObject) parser.parse(json);
		return (float) jsonobj.get("popularityRank");
		
	}
	
	private int getArtistCount(String artistName) throws ParseException {
		String json = HttpClient.getContent("http://10.0.7.232:8080/solr/cms-artist/select?q=title:"+artistName+"&wt=json&indent=true");
		if(StringUtils.isEmpty(json))
			return 0;
		JSONParser parser = new JSONParser();
		JSONObject jsonobj = (JSONObject) parser.parse(json);
		if(jsonobj.get("songCount")!=null)
			return (int) jsonobj.get("songCount");
		return 0;
		
	}

	private boolean isRemix(String title) {
		for(String remixIdentifier:remixIdentifier){
			if(title.toLowerCase().contains(remixIdentifier))
				return true;
		}
		return false;
	}
	
	private boolean isRemix(String[] line) {
		String title = line[1].toLowerCase();
		String albumTitle = line[2].toLowerCase();
		for(String remixIdentifier:remixIdentifier){
			if(title.contains(remixIdentifier) || albumTitle.contains(remixIdentifier))
				return true;
		}
		return false;
	}
	

	public static void main(String[] args) throws IOException, ParseException{
		FilterRemixData obj = new FilterRemixData();
		obj.segregateData1();
	}
}
