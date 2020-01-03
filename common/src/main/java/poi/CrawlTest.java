package poi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.*;

/**
 * @Description
 * @auther denny
 * @create 2020-01-02 15:02
 */
public class CrawlTest {

    public static void main(String[] args) {
        List<Map<String, String>> mapList = Arrays.asList(
                new HashMap<String, String>() {{ put("name","XT新塘地王广场");put("gps","113.614610,23.116868");put("adcode","增城区"); }}
        );
        String url = "https://apis.map.qq.com/bigdata/popinsight/v1/flownum";
        for (int i=0;i<mapList.size();i++) {
            Map<String, String> map = mapList.get(i);
            String params = "{ \"boundary_type\": \"circle\", \"center\": \"%s\", \"range\": \"500\", \"adcode\": \"%s\", \"min_area\": \"10000\", \"month\": \"201911\", \"date_type\": \"1,2,3\", \"key\":\"UJMBZ-T35WG-UEDQL-IGGWO-7V7TV-OGB4A\"}";
            String[] strings = map.get("gps").split(",");
            String gps = strings[1] + "," + strings[0];
            String adcode = "440118";
            params = String.format(params, gps, adcode);
            String result = httpPostRaw(url, params, null, "UTF-8");
            JSONObject object = JSON.parseObject(result).getJSONObject("result");
            JSONObject data = object.getJSONObject("500m");
            Iterator iterator = data.entrySet().iterator();
            List<String> list = new ArrayList<>();
            while (iterator.hasNext()){
                Map.Entry entry = (Map.Entry) iterator.next();
                String key = (String) entry.getKey();
                list.add(key+"_"+ "day_avg");
                for(int j=0;j<24;j++){
                    list.add(key+"_"+ "hour_avg_" + j);
                }
            }
            String[] title = new String[list.size()];
            for (int j=0;j<list.size();j++) {
                title[j] = list.get(j);
            }
            System.out.println(title);
        }

    }



    public static String httpPostRaw(String url, String stringJson, Map<String,String> headers, String encode){
        if(encode == null){
            encode = "utf-8";
        }
        //HttpClients.createDefault()等价于 HttpClientBuilder.create().build();
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        HttpPost httpost = new HttpPost(url);

        //设置header
        httpost.setHeader("Content-type", "application/json");
        if (headers != null && headers.size() > 0) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpost.setHeader(entry.getKey(),entry.getValue());
            }
        }
        //组织请求参数
        StringEntity stringEntity = new StringEntity(stringJson, encode);
        httpost.setEntity(stringEntity);
        String content = null;
        CloseableHttpResponse httpResponse = null;
        try {
            //响应信息
            httpResponse = closeableHttpClient.execute(httpost);
            HttpEntity entity = httpResponse.getEntity();
            content = EntityUtils.toString(entity, encode);

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                httpResponse.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {  //关闭连接、释放资源
            closeableHttpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
