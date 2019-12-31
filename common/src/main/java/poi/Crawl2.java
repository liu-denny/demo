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
 * @create 2019-12-31 17:35
 */
public class Crawl2 {
    public static void main(String[] args) throws Exception {
        List<Map<String,String>> mapList = Arrays.asList(
//                new HashMap<String, String>() {{ put("name","XT新塘地王广场");put("gps","113.614610,23.116868"); }},
//                new HashMap<String, String>() {{ put("name","HD花来又来广百");put("gps","113.233118,23.397909"); }},
//                new HashMap<String, String>() {{ put("name","GZ中华广场");put("gps","113.282599,23.125918"); }},
//                new HashMap<String, String>() {{ put("name","GZ正佳广场");put("gps","113.327030,23.132175"); }},
//                new HashMap<String, String>() {{ put("name","GZ增城增江");put("gps","113.839980,23.280614"); }},
//                new HashMap<String, String>() {{ put("name","GZ增城万达广场");put("gps","113.815277,23.276029"); }},
//                new HashMap<String, String>() {{ put("name","GZ增城锦绣");put("gps","113.811451,23.286874"); }},
//                new HashMap<String, String>() {{ put("name","GZ增城挂绿广场");put("gps","113.833175,23.291104"); }},
//                new HashMap<String, String>() {{ put("name","GZ增城东汇城");put("gps","113.823881,23.285385"); }},
//                new HashMap<String, String>() {{ put("name","GZ粤信大厦");put("gps","113.332718,23.094867"); }}

//                new HashMap<String, String>() {{ put("name","GZ越秀粤海");put("gps","113.269620,23.119570"); }},
//                new HashMap<String, String>() {{ put("name","GZ又一城");put("gps","113.321506,23.132529"); }},
//                new HashMap<String, String>() {{ put("name","GZ宜安广场店");put("gps","113.284827,23.134374"); }},
//                new HashMap<String, String>() {{ put("name","GZ新市新天地");put("gps","113.264642,23.191245"); }},
//                new HashMap<String, String>() {{ put("name","GZ欣荣宏商贸城");put("gps","113.590780,23.532056"); }},
//                new HashMap<String, String>() {{ put("name","GZ晓港湾");put("gps","113.294085,23.071044"); }},
//                new HashMap<String, String>() {{ put("name","GZ夏茅金铂");put("gps","113.251922,23.213315"); }},
//                new HashMap<String, String>() {{ put("name","GZ下渡路");put("gps","113.307988,23.099633"); }},
//                new HashMap<String, String>() {{ put("name","GZ西湖路");put("gps","113.267460,23.123320"); }},
//                new HashMap<String, String>() {{ put("name","GZ西城都荟");put("gps","113.240152,23.110770"); }}
//
//                new HashMap<String, String>() {{ put("name","GZ五号停机坪");put("gps","113.264528,23.181180"); }},
//                new HashMap<String, String>() {{ put("name","GZ万家福广场");put("gps","113.298757,23.332571"); }},
//                new HashMap<String, String>() {{ put("name","GZ天银广场");put("gps","113.321196,23.137388"); }},
//                new HashMap<String, String>() {{ put("name","GZ天河直通车");put("gps","113.321962,23.135186"); }},
//                new HashMap<String, String>() {{ put("name","GZ天河娱乐店");put("gps","113.340038,23.135646"); }},
//                new HashMap<String, String>() {{ put("name","GZ天河曜一城");put("gps","113.344600,23.141779"); }},
//                new HashMap<String, String>() {{ put("name","GZ天河万科");put("gps","113.402586,23.168336"); }},
//                new HashMap<String, String>() {{ put("name","GZ天河天汇广场");put("gps","113.332151,23.116274"); }},
//                new HashMap<String, String>() {{ put("name","GZ天河天环广场");put("gps","113.325673,23.131722"); }},
//                new HashMap<String, String>() {{ put("name","GZ天河尚德大厦");put("gps","113.344295,23.139679"); }}
//
//                new HashMap<String, String>() {{ put("name","GZ天河路");put("gps","113.330170,23.132829"); }},
//                new HashMap<String, String>() {{ put("name","GZ天河乐都汇");put("gps","113.376466,23.126979"); }},
//                new HashMap<String, String>() {{ put("name","GZ天河骏唐广场");put("gps","113.383416,23.125877"); }},
//                new HashMap<String, String>() {{ put("name","GZ天河好又多店");put("gps","113.378272,23.124939"); }},
//                new HashMap<String, String>() {{ put("name","GZ天河国金中心");put("gps","113.322846,23.118160"); }},
//                new HashMap<String, String>() {{ put("name","GZ天河城");put("gps","113.323209,23.132363"); }},
//                new HashMap<String, String>() {{ put("name","GZ太阳新天地");put("gps","113.343720,23.123460"); }},
//                new HashMap<String, String>() {{ put("name","GZ四季时尚荟");put("gps","113.401970,23.119117"); }},
//                new HashMap<String, String>() {{ put("name","GZ时尚天河");put("gps","113.319942,23.141626"); }},
//                new HashMap<String, String>() {{ put("name","GZ狮岭家宜多");put("gps","113.155865,23.461858"); }}
//
//                new HashMap<String, String>() {{ put("name","GZ圣地广场");put("gps","113.229792,23.132650"); }},
//                new HashMap<String, String>() {{ put("name","GZ三元里大道");put("gps","113.251677,23.172184"); }},
//                new HashMap<String, String>() {{ put("name","GZ祈福缤纷世界");put("gps","113.332024,22.969600"); }},
//                new HashMap<String, String>() {{ put("name","GZ南沙万达广场");put("gps","113.532817,22.794742"); }},
//                new HashMap<String, String>() {{ put("name","GZ南沙华汇广场");put("gps","113.557716,22.800598"); }},
//                new HashMap<String, String>() {{ put("name","GZ南沙大岗达森");put("gps","113.406128,22.802368"); }},
//                new HashMap<String, String>() {{ put("name","GZ南沙COCO");put("gps","113.547061,22.807183"); }},
//                new HashMap<String, String>() {{ put("name","GZ木棉湾广场");put("gps","113.329069,23.185444"); }},
//                new HashMap<String, String>() {{ put("name","GZ名盛广场");put("gps","113.270708,23.121961"); }},
//                new HashMap<String, String>() {{ put("name","GZ美东百货");put("gps","113.297243,23.128294"); }},
//
//                new HashMap<String, String>() {{ put("name","GZ梅花园");put("gps","113.321062,23.178549"); }},
//                new HashMap<String, String>() {{ put("name","GZ漫广场");put("gps","113.424873,23.112497"); }},
//                new HashMap<String, String>() {{ put("name","GZ萝岗区高德汇");put("gps","113.452784,23.167779"); }},
//                new HashMap<String, String>() {{ put("name","GZ萝岗奥园");put("gps","113.501067,23.174213"); }},
//                new HashMap<String, String>() {{ put("name","GZ罗冲围友田城");put("gps","113.227654,23.144227"); }},
//                new HashMap<String, String>() {{ put("name","GZ龙骏广场");put("gps","113.226801,23.177741"); }},
//                new HashMap<String, String>() {{ put("name","GZ龙洞商业楼");put("gps","113.368398,23.193693"); }},
//                new HashMap<String, String>() {{ put("name","GZ六福广场");put("gps","113.327173,23.086339"); }}
//
//                new HashMap<String, String>() {{ put("name","GZ荔园新天地");put("gps","113.345624,22.919752"); }},
//                new HashMap<String, String>() {{ put("name","GZ荔湾荔胜广场");put("gps","113.233291,23.073920"); }},
//                new HashMap<String, String>() {{ put("name","GZ荔湾花地人家");put("gps","113.230071,23.095207"); }},
//                new HashMap<String, String>() {{ put("name","GZ丽影广场");put("gps","113.321047,23.095769"); }},
//                new HashMap<String, String>() {{ put("name","GZ乐峰广场");put("gps","113.259017,23.089267"); }},
//                new HashMap<String, String>() {{ put("name","GZ金田百佳");put("gps","113.335354,23.141910"); }},
//                new HashMap<String, String>() {{ put("name","GZ金沙洲梦乐城");put("gps","113.194081,23.147189"); }},
//                new HashMap<String, String>() {{ put("name","GZ金海岸城市广");put("gps","113.602585,23.127689"); }},
//                new HashMap<String, String>() {{ put("name","GZ金国商业广场");put("gps","113.253981,23.204473"); }},
//                new HashMap<String, String>() {{ put("name","GZ江夏新天地");put("gps","113.282532,23.211133"); }},
//                new HashMap<String, String>() {{ put("name","GZ江南西人");put("gps","113.272263,23.095610"); }},
//                new HashMap<String, String>() {{ put("name","GZ江高家宜多");put("gps","113.232854,23.274836"); }},
//                new HashMap<String, String>() {{ put("name","GZ黄埔潮楼购物");put("gps","113.424875,23.112499"); }},
//                new HashMap<String, String>() {{ put("name","GZ花都盛妆");put("gps","113.209466,23.382311"); }},
//                new HashMap<String, String>() {{ put("name","GZ花都融创茂");put("gps","113.604209,23.140307"); }},
//                new HashMap<String, String>() {{ put("name","GZ花都摩登");put("gps","113.204970,23.386230"); }},
//                new HashMap<String, String>() {{ put("name","GZ花都骏壹万邦");put("gps","113.227390,23.405389"); }},
//                new HashMap<String, String>() {{ put("name","GZ花都建设路");put("gps","113.210069,23.374717"); }},
//                new HashMap<String, String>() {{ put("name","GZ花都百花广场");put("gps","113.223112,23.379196"); }},
//                new HashMap<String, String>() {{ put("name","GZ恒宝华庭店");put("gps","113.241603,23.118105"); }}
//
//                new HashMap<String, String>() {{ put("name","GZ合生广场");put("gps","113.275185,23.088314"); }},
//                new HashMap<String, String>() {{ put("name","GZ好信广场");put("gps","113.302410,23.070008"); }},
//                new HashMap<String, String>() {{ put("name","GZ海珠万国广场");put("gps","113.272883,23.101389"); }},
//                new HashMap<String, String>() {{ put("name","GZ海珠保利广场");put("gps","113.280536,23.102284"); }},
//                new HashMap<String, String>() {{ put("name","GZ海印自由闲");put("gps","113.285863,23.126264"); }},
//                new HashMap<String, String>() {{ put("name","GZ海铂丽廊广场");put("gps","113.312450,23.103120"); }},
//                new HashMap<String, String>() {{ put("name","GZ广州亚运城");put("gps","113.477228,22.940801"); }},
//                new HashMap<String, String>() {{ put("name","GZ广州骐利广场");put("gps","113.235294,23.156027"); }},
//                new HashMap<String, String>() {{ put("name","GZ广州龙归金铂");put("gps","113.293413,23.267821"); }},
//                new HashMap<String, String>() {{ put("name","GZ广州领好广场");put("gps","113.526046,23.085015"); }},
//                new HashMap<String, String>() {{ put("name","GZ广州金铂广场");put("gps","113.325608,23.196350"); }},
//                new HashMap<String, String>() {{ put("name","GZ广州江燕路");put("gps","113.277967,23.082078"); }},
//                new HashMap<String, String>() {{ put("name","GZ广州江南新地");put("gps","113.270569,23.094681"); }},
//                new HashMap<String, String>() {{ put("name","GZ广州黄埔万达");put("gps","113.466258,23.167464"); }},
//                new HashMap<String, String>() {{ put("name","GZ广州花都国华");put("gps","113.208262,23.375644"); }},
//                new HashMap<String, String>() {{ put("name","GZ广州高德汇");put("gps","113.347353,23.169586"); }},
//                new HashMap<String, String>() {{ put("name","GZ广州大道北");put("gps","113.326234,23.187919"); }},
//                new HashMap<String, String>() {{ put("name","GZ广州卜蜂莲花");put("gps","113.256967,23.160901"); }},
//                new HashMap<String, String>() {{ put("name","GZ广州白云万达");put("gps","113.266379,23.172775"); }},
//                new HashMap<String, String>() {{ put("name","GZ广州白云凯德");put("gps","113.269448,23.181018"); }},
//                new HashMap<String, String>() {{ put("name","GZ广天河优托邦");put("gps","113.415600,23.132750"); }}
//
//                new HashMap<String, String>() {{ put("name","GZ广海珠同乐汇");put("gps","113.271532,23.104079"); }},
//                new HashMap<String, String>() {{ put("name","GZ广百新一城");put("gps","113.266656,23.092994"); }},
//                new HashMap<String, String>() {{ put("name","GZ高德置地春");put("gps","113.322172,23.119884"); }},
//                new HashMap<String, String>() {{ put("name","GZ富丽城");put("gps","113.311339,23.026651"); }},
//                new HashMap<String, String>() {{ put("name","GZ富景花园店");put("gps","113.289506,23.092654"); }},
//                new HashMap<String, String>() {{ put("name","GZ凤凰城");put("gps","113.576840,23.125721"); }},
//                new HashMap<String, String>() {{ put("name","GZ番禺愉园酒店");put("gps","113.366310,22.941120"); }},
//                new HashMap<String, String>() {{ put("name","GZ番禺永旺广场");put("gps","113.384300,22.934005"); }},
//                new HashMap<String, String>() {{ put("name","GZ番禺雄峰城");put("gps","113.303334,22.970348"); }},
//                new HashMap<String, String>() {{ put("name","GZ番禺喜悦天地");put("gps","113.361600,22.949411"); }},
//                new HashMap<String, String>() {{ put("name","GZ番禺万科里");put("gps","113.378011,22.932867"); }},
//                new HashMap<String, String>() {{ put("name","GZ番禺万达广场");put("gps","113.348742,22.990104"); }},
//                new HashMap<String, String>() {{ put("name","GZ番禺人人佳");put("gps","113.387531,23.004902"); }},
//                new HashMap<String, String>() {{ put("name","GZ番禺桥东路店");put("gps","113.367009,22.936720"); }},
//                new HashMap<String, String>() {{ put("name","GZ番禺建华汇");put("gps","113.315316,23.024777"); }},
//                new HashMap<String, String>() {{ put("name","GZ番山商贸城店");put("gps","113.365102,22.941331"); }},
//                new HashMap<String, String>() {{ put("name","GZ动漫星城");put("gps","113.267021,23.125887"); }},
//                new HashMap<String, String>() {{ put("name","GZ东平时代都荟");put("gps","113.309423,23.248031"); }},
//                new HashMap<String, String>() {{ put("name","GZ东急新天地店");put("gps","113.248754,23.114504"); }},
//                new HashMap<String, String>() {{ put("name","GZ大学城新天地");put("gps","113.393421,23.060742"); }}
//
                new HashMap<String, String>() {{ put("name","GZ大石金科广场");put("gps","113.325036,23.010095"); }},
                new HashMap<String, String>() {{ put("name","GZ潮流新天地");put("gps","113.327676,23.130793"); }},
                new HashMap<String, String>() {{ put("name","GZ保利中环广场");put("gps","113.281489,23.137405"); }},
                new HashMap<String, String>() {{ put("name","GZ百事佳商业城");put("gps","113.543391,23.110467"); }},
                new HashMap<String, String>() {{ put("name","GZ百佳购物广场");put("gps","113.454076,23.100816"); }},
                new HashMap<String, String>() {{ put("name","GZ白云万民广场");put("gps","113.228646,23.212658"); }},
                new HashMap<String, String>() {{ put("name","GZ白云时代广场");put("gps","113.304646,23.221700"); }},
                new HashMap<String, String>() {{ put("name","GZ白云岭南新世");put("gps","113.265106,23.181008"); }},
                new HashMap<String, String>() {{ put("name","GZ白云来利");put("gps","113.357180,23.292247"); }},
                new HashMap<String, String>() {{ put("name","GZ白云百信西广");put("gps","113.262607,23.194289"); }},
                new HashMap<String, String>() {{ put("name","GZ白云安华汇");put("gps","113.302696,23.226385"); }},
                new HashMap<String, String>() {{ put("name","GZ奥园广场");put("gps","113.357256,22.924046"); }},
                new HashMap<String, String>() {{ put("name","GZ奥园城市广场");put("gps","113.300915,23.051377"); }},
                new HashMap<String, String>() {{ put("name","CH新世纪广场");put("gps","113.267766,23.115023"); }}
//
//

        );
        String url1 = "https://apis.map.qq.com/bigdata/popinsight/v1/residentnum";
        String url2 = "https://apis.map.qq.com/bigdata/popinsight/v1/residentuserprofile";
        String url3 = "https://apis.map.qq.com/bigdata/popinsight/v1/flownum";


        for (Map<String, String> map : mapList) {

            String params1 = "{ \"boundary_type\": \"circle\", \"center\": \"%s\", \"range\": \"500\", \"adcode\": \"440104\", \"min_area\": \"10000\", \"month\": \"201911\", \"people_type\": \"1,2,3,4\", \"key\": \"UJMBZ-T35WG-UEDQL-IGGWO-7V7TV-OGB4A\" }";
            String params2 = "{ \"boundary_type\": \"circle\", \"center\": \"%s\", \"range\": \"500\", \"adcode\": \"440104\", \"min_area\": \"10000\", \"month\": \"201911\", \"people_type\": \"4\", \"label\":\"101010,101012,101015,101110,1012,1013,1112,1124,1120,1121,1125,1110,1117,1116,1119,1310,1311,1312,1401,1501,1610,1612\", \"key\": \"UJMBZ-T35WG-UEDQL-IGGWO-7V7TV-OGB4A\" }";
            String params3 = "{ \"boundary_type\": \"circle\", \"center\": \"%s\", \"range\": \"500\", \"adcode\": \"440104\", \"min_area\": \"10000\", \"month\": \"201911\", \"date_type\": \"1,2,3\", \"key\":\"UJMBZ-T35WG-UEDQL-IGGWO-7V7TV-OGB4A\"}";

            String[] strings = map.get("gps").split(",");
            String gps = strings[1] + "," + strings[0];
            params1 = String.format(params1,gps);
            params2 = String.format(params2,gps);
            params3 = String.format(params3,gps);

            String result1 = httpPostRaw(url1, params1,null,"UTF-8");
            String result2 = httpPostRaw(url2, params2,null,"UTF-8");
            String result3 = httpPostRaw(url3, params3,null,"UTF-8");

            JSONObject object1 = JSON.parseObject(result1);
            JSONObject object2 = JSON.parseObject(result2);
            JSONObject object3 = JSON.parseObject(result3);

            List<List<Object>> resultList = new ArrayList<>();
            List<Object> dataList = new ArrayList<>();
            dataList.add(object1.get("result"));
            dataList.add(object2.get("result"));
            dataList.add(object3.get("result"));
            resultList.add(dataList);
            String name = map.get("name");
            CSVUtils csvUtils = new CSVUtils();
            csvUtils.createCSVFile(resultList,"D:\\work\\demo\\common\\src\\main\\resources\\qu",name);
            System.out.println(name + "-" + "结束");
            Thread.sleep(1000*1);
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
