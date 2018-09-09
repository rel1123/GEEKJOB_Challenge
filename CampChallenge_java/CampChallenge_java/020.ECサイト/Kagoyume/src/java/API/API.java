/*
APIに関する処理を行うクラス

 */
package API;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 検索用のAPIURL　String型で保存
 * @author stsno
 */
public class API {
    public static String SearchAPIbaseUrl(){
        return "https://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch?appid=dj00aiZpPVNwSXZrbXNSdXlvQSZzPWNvbnN1bWVyc2VjcmV0Jng9M2U-";
    }
    
    public static String ItemAPIbaseUrl(){
        return "https://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemLookup?appid=dj00aiZpPVNwSXZrbXNSdXlvQSZzPWNvbnN1bWVyc2VjcmV0Jng9M2U-";
    }
    
    
     /**
     * urlStringから帰ってきたデータをJsonNodeに変換
     * <p>
     *
     *
     * @引数   String urlString
     * @戻り値  JsonNode
     */
    public static JsonNode getJsonNode(String urlString){
        String result = "";
        JsonNode head = null;
        try{
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String tmp = "";
            while ((tmp = in.readLine()) != null) {
                result += tmp;
            }
            in.close();
            con.disconnect();

            JsonFactory jfactory = new JsonFactory();
            JsonParser parser = jfactory.createJsonParser(result);
            ObjectMapper mapper = new ObjectMapper();
            head = mapper.readTree(parser);
            return head;
        }catch(Exception e){
            e.printStackTrace();
            return head;
        }
    }
  
    
}
