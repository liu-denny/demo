//package poi;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.OutputStreamWriter;
//import java.nio.charset.StandardCharsets;
//import java.util.*;
//
///**
// * @Description
// * @auther denny
// * @create 2019-12-31 11:46
// */
//public class main {
//    public static void main(String[] args) throws Exception {
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("boundary", "region(广州,0)");
//        params.put("keyword", "基础设施:交通设施:公交车站");
//        params.put("key", "UJMBZ-T35WG-UEDQL-IGGWO-7V7TV-OGB4A");
//        String result = HttpClientUtils.doGet("https://apis.map.qq.com/ws/place/v1/search", params);
//
//        JSONObject object = JSON.parseObject(result);
//        JSONArray datas = object.getJSONArray("data");
////        File csvFile = new File("D:\\work\\demo\\common\\src\\main\\java\\poi" + "/" + "test.csv");;
////        BufferedWriter csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), StandardCharsets.UTF_8), 1024);
//        List<List<String>> datasList = new ArrayList<List<String>>();
//        List<String> dataList =null;
//        for(int i=0;i<datas.size();i++){
//            dataList = new ArrayList<String>();
//            JSONObject data = (JSONObject)datas.get(i);
//            dataList.add(data.getString("id"));
//            dataList.add(data.getString("title"));
//            dataList.add(data.getString("address"));
//            datasList.addAll(Collections.singleton(dataList));
//        }
//        CSVUtils csvUtils=new CSVUtils();
//        csvUtils.createCSVFile(datasList,"D:\\work\\demo\\common\\src\\main\\java\\poi","test");
//        System.out.println("结束");
//    }
//}
