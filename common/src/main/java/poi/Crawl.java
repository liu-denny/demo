package poi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @Description
 * @auther denny
 * @create 2019-12-31 13:59
 */
public class Crawl {


    public static void main(String[] args) throws Exception {
        Map<String,String> params = new HashMap<>();
        params.put("boundary", "region(广州,0)");
        params.put("key", "UJMBZ-T35WG-UEDQL-IGGWO-7V7TV-OGB4A");
        params.put("page_size", "20");
        String url = "https://apis.map.qq.com/ws/place/v1/search" ;

        List<String> keywords = Arrays.asList(
//        "购物:综合商场"
//        "购物:综合商场:购物中心" ,
//        "购物:便利店" ,
//        "购物:超市" ,
//        "购物:母婴儿童" ,
//        "购物:珠宝饰品" ,
//        "购物:珠宝饰品:珠宝" ,
//        "购物:珠宝饰品:饰品" ,
//        "购物:化妆品",
//        "教育学校" ,
//        "教育学校:大学" ,
//        "教育学校:中学" ,
//        "教育学校:小学" ,
//        "教育学校:幼儿园"
//        "基础设施:交通设施:公交车站" ,
//        "基础设施:交通设施:地铁站" ,
//        "基础设施:交通设施:港口码头" ,
//        "基础设施:交通设施:火车站" ,
//        "基础设施:交通设施:轻轨站" ,
//        "基础设施:交通设施:过境口岸" ,
//        "基础设施:交通设施:长途汽车站" ,
//        "基础设施:交通设施:飞机场" ,
//        "基础设施:交通设施:公交线路" ,
//        "基础设施:交通设施:地铁线路" ,
//        "基础设施:交通设施:地铁站出入口"
        "房产小区" ,
        "房产小区:住宅区" ,
        "房产小区:住宅区:住宅小区" ,
        "房产小区:住宅区:别墅" ,
        "房产小区:住宅区:宿舍" ,
        "房产小区:住宅区:社区中心" ,
        "房产小区:住宅区:其它住宅区" ,
        "房产小区:产业园区" ,
        "房产小区:商务楼宇" ,
        "房产小区:商务楼宇设施" ,
        "房产小区:房产小区附属" ,
        "房产小区:其它房产小区"
        );

        for (String keyword : keywords) {
            params.put("keyword", keyword);
            List<List<Object>> resultList = new ArrayList<>();
            int count = 0;
            for (int i = 1; i <= 10; i++) {
                params.put("page_index", "1");
                String result = HttpClientUtils.doGet(url, params);

                if(i == 1){
                    count = JSON.parseObject(result).getIntValue("count");
                }
                resultList = analyze(resultList, JSON.parseObject(result));
                Thread.sleep(1000*1);
            }

            CSVUtils csvUtils = new CSVUtils();
            String fileName = keyword.replace(":","-") + "-" + count;
            csvUtils.createCSVFile(resultList,"D:\\work\\demo\\common\\src\\main\\resources",fileName);
            System.out.println(keyword + "-" + "结束");
        }
//            String result = HttpClientUtils.doGet(url, params);
//            JSONObject object = JSON.parseObject(result);
//            int count = object.getIntValue("count");
//            int size = count / 20;
//            resultList = analyze(resultList,object);
//            for(int i=2;i<size+1;i++){
//                params.put("page_index",String.valueOf(i));
//                result = HttpClientUtils.doGet(url, params);
//                object = JSON.parseObject(result);
//                resultList = analyze(resultList,object);
//            }
//            CSVUtils csvUtils = new CSVUtils();
//            csvUtils.createCSVFile(resultList,"D:\\work\\demo\\common\\src\\main\\java\\poi",keyword);
//            System.out.println(keyword + "结束");
//        }
    }

    public static List<List<Object>> analyze(List<List<Object>> resultList,JSONObject object){
        JSONArray data = object.getJSONArray("data");
        for(int i=0;i<data.size();i++){
            List<Object> dataList = new ArrayList<>();
            JSONObject o = (JSONObject)data.get(i);

            dataList.add(o.getString("id"));
            dataList.add(o.getString("title"));
            dataList.add(o.getString("address"));
            dataList.add(o.getString("tel"));
            dataList.add(o.getString("category"));
            dataList.add(o.getString("type"));


            JSONObject location = o.getJSONObject("location");
            dataList.add(location.get("lat"));
            dataList.add(location.getString("lng"));

            JSONObject ad_info = o.getJSONObject("ad_info");
            dataList.add(ad_info.getString("adcode"));
            dataList.add(ad_info.getString("province"));
            dataList.add(ad_info.getString("city"));
            dataList.add(ad_info.getString("district"));

            resultList.add(dataList);
        }
        return resultList;
    }
}
