package poi;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @auther denny
 * @create 2020-01-03 14:07
 */
public class Crawl6_4 {
    public static void main(String[] args) throws Exception {
        List<String> keywords = Arrays.asList(
                "文化场馆:档案馆",
                "文化场馆:文化宫",
                "文化场馆:美术馆",
                "文化场馆:会展中心",
                "文化场馆:其它文化场馆",
                "教育学校",
                "教育学校:大学",
                "教育学校:中学",
                "教育学校:小学",
                "教育学校:幼儿园",
                "教育学校:培训",
                "教育学校:培训:幼儿教育",
                "教育学校:培训:外语培训",
                "教育学校:培训:音乐舞蹈",
                "教育学校:培训:升学辅导",
                "教育学校:培训:美术培训",
                "教育学校:培训:体育培训",
                "教育学校:职业技术学校",
                "教育学校:成人教育",
                "教育学校:教育学校附属",
                "教育学校:其它教育学校",
                "银行金融",
                "银行金融:银行",
                "银行金融:自动提款机",
                "银行金融:保险公司",
                "银行金融:证券公司",
                "银行金融:财务公司",
                "银行金融:银行金融场所附属",
                "银行金融:其它银行金融",
                "地名地址",
                "地名地址:交通地名",
                "地名地址:地名地址信息",
                "地名地址:道路名",
                "地名地址:自然地名",
                "地名地址:自然地名:山",
                "地名地址:自然地名:岛屿",
                "地名地址:自然地名:河流",
                "地名地址:自然地名:海湾海峡",
                "地名地址:自然地名:湖泊",
                "地名地址:自然地名:其它自然地名",
                "地名地址:行政地名",
                "地名地址:门牌信息",
                "地名地址:其它地名地址",
                "基础设施",
                "基础设施:交通设施",
                "基础设施:交通设施:交通服务相关",
                "基础设施:交通设施:公交车站",
                "基础设施:交通设施:地铁站",
                "基础设施:交通设施:港口码头",
                "基础设施:交通设施:火车站",
                "基础设施:交通设施:轻轨站",
                "基础设施:交通设施:过境口岸",
                "基础设施:交通设施:长途汽车站",
                "基础设施:交通设施:飞机场",
                "基础设施:交通设施:公交线路",
                "基础设施:交通设施:地铁线路",
                "基础设施:交通设施:地铁站出入口",
                "基础设施:交通设施:其它交通设施",
                "基础设施:机场附属",
                "基础设施:机场附属:登机口",
                "基础设施:机场附属:候机厅",
                "基础设施:机场附属:出发",
                "基础设施:机场附属:到达",
                "基础设施:机场附属:值机柜台",
                "基础设施:机场附属:机场中转服务柜台",
                "基础设施:机场附属:出入境柜台",
                "基础设施:机场附属:航空公司服务柜台",
                "基础设施:机场附属:机场巴士站",
                "基础设施:火车站附属",
                "基础设施:火车站附属:候车厅",
                "基础设施:火车站附属:检票口",
                "基础设施:火车站附属:出站口",
                "基础设施:火车站附属:进站口",
                "基础设施:火车站附属:火车站台",
                "基础设施:其它交通设施附属",
                "基础设施:其它交通设施附属:行李服务",
                "基础设施:其它交通设施附属:地铁设施",
                "基础设施:其它交通设施附属:地铁站台",
                "基础设施:其它交通设施附属:交通停靠点",
                "基础设施:其它交通设施附属:票务服务",
                "基础设施:公共设施",
                "基础设施:公共设施:公共厕所",
                "基础设施:公共设施:男洗手间",
                "基础设施:公共设施:女洗手间",
                "基础设施:公共设施:无障碍洗手间",
                "基础设施:公共设施:座椅设施",
                "基础设施:公共设施:公用电话",
                "基础设施:公共设施:紧急避难场所",
                "基础设施:公共设施:其它公共设施",
                "基础设施:道路附属",
                "基础设施:道路附属:收费站",
                "基础设施:道路附属:服务区",
                "基础设施:道路附属:道路出入口",
                "基础设施:道路附属:路口",
                "基础设施:道路附属:桥",
                "基础设施:道路附属:其它道路附属",
                "基础设施:其它基础设施",
                "房产小区",
                "房产小区:住宅区",
                "房产小区:住宅区:住宅小区",
                "房产小区:住宅区:别墅",
                "房产小区:住宅区:宿舍",
                "房产小区:住宅区:社区中心",
                "房产小区:住宅区:其它住宅区",
                "房产小区:产业园区",
                "房产小区:商务楼宇",
                "房产小区:商务楼宇设施",
                "房产小区:房产小区附属",
                "房产小区:其它房产小区",
                "室内及附属设施",
                "室内及附属设施:通行设施",
                "室内及附属设施:其它室内及附属设施",
                "其它"
        );

        List<Map<String, String>> mapList = Arrays.asList(
//                new HashMap<String, String>() {{ put("name","XT新塘地王广场");put("gps","113.614610,23.116868");put("adcode","增城区"); }},
//                new HashMap<String, String>() {{ put("name","HD花来又来广百");put("gps","113.233118,23.397909");put("adcode","花都区"); }},
//                new HashMap<String, String>() {{ put("name","GZ中华广场");put("gps","113.282599,23.125918");put("adcode","越秀区"); }},
//                new HashMap<String, String>() {{ put("name","GZ正佳广场");put("gps","113.327030,23.132175");put("adcode","天河区"); }},
//                new HashMap<String, String>() {{ put("name","GZ增城增江");put("gps","113.839980,23.280614");put("adcode","增城区"); }},
//                new HashMap<String, String>() {{ put("name","GZ增城万达广场");put("gps","113.815277,23.276029");put("adcode","增城区"); }},
//                new HashMap<String, String>() {{ put("name","GZ增城锦绣");put("gps","113.811451,23.286874");put("adcode","增城区"); }},
//                new HashMap<String, String>() {{ put("name","GZ增城挂绿广场");put("gps","113.833175,23.291104");put("adcode","增城区"); }},
//                new HashMap<String, String>() {{ put("name","GZ增城东汇城");put("gps","113.823881,23.285385");put("adcode","增城区"); }},
//                new HashMap<String, String>() {{ put("name","GZ粤信大厦");put("gps","113.332718,23.094867");put("adcode","海珠区"); }},
//
//                new HashMap<String, String>() {{ put("name","GZ越秀粤海");put("gps","113.269620,23.119570");put("adcode","越秀区"); }},
//                new HashMap<String, String>() {{ put("name","GZ又一城");put("gps","113.321506,23.132529");put("adcode","天河区"); }},
//                new HashMap<String, String>() {{ put("name","GZ宜安广场店");put("gps","113.284827,23.134374");put("adcode","越秀区"); }},
//                new HashMap<String, String>() {{ put("name","GZ新市新天地");put("gps","113.264642,23.191245");put("adcode","白云区"); }},
//                new HashMap<String, String>() {{ put("name","GZ欣荣宏商贸城");put("gps","113.590780,23.532056");put("adcode","从化区"); }},
//                new HashMap<String, String>() {{ put("name","GZ晓港湾");put("gps","113.294085,23.071044");put("adcode","海珠区"); }},
//                new HashMap<String, String>() {{ put("name","GZ夏茅金铂");put("gps","113.251922,23.213315");put("adcode","白云区"); }},
//                new HashMap<String, String>() {{ put("name","GZ下渡路");put("gps","113.307988,23.099633");put("adcode","海珠区"); }},
//                new HashMap<String, String>() {{ put("name","GZ西湖路");put("gps","113.267460,23.123320");put("adcode","越秀区"); }},
//                new HashMap<String, String>() {{ put("name","GZ西城都荟");put("gps","113.240152,23.110770");put("adcode","荔湾区"); }},
//
//                new HashMap<String, String>() {{ put("name","GZ五号停机坪");put("gps","113.264528,23.181180");put("adcode","白云区"); }},
//                new HashMap<String, String>() {{ put("name","GZ万家福广场");put("gps","113.298757,23.332571");put("adcode","白云区"); }},
//                new HashMap<String, String>() {{ put("name","GZ天银广场");put("gps","113.321196,23.137388");put("adcode","天河区"); }},
//                new HashMap<String, String>() {{ put("name","GZ天河直通车");put("gps","113.321962,23.135186");put("adcode","天河区"); }},
//                new HashMap<String, String>() {{ put("name","GZ天河娱乐店");put("gps","113.340038,23.135646");put("adcode","天河区"); }},
//                new HashMap<String, String>() {{ put("name","GZ天河曜一城");put("gps","113.344600,23.141779");put("adcode","天河区"); }},
//                new HashMap<String, String>() {{ put("name","GZ天河万科");put("gps","113.402586,23.168336");put("adcode","天河区"); }},
//                new HashMap<String, String>() {{ put("name","GZ天河天汇广场");put("gps","113.332151,23.116274");put("adcode","天河区"); }},
//                new HashMap<String, String>() {{ put("name","GZ天河天环广场");put("gps","113.325673,23.131722");put("adcode","天河区"); }},
//                new HashMap<String, String>() {{ put("name","GZ天河尚德大厦");put("gps","113.344295,23.139679");put("adcode","天河区"); }},
//
//                new HashMap<String, String>() {{ put("name","GZ天河路");put("gps","113.330170,23.132829");put("adcode","天河区"); }},
//                new HashMap<String, String>() {{ put("name","GZ天河乐都汇");put("gps","113.376466,23.126979");put("adcode","天河区"); }},
//                new HashMap<String, String>() {{ put("name","GZ天河骏唐广场");put("gps","113.383416,23.125877");put("adcode","天河区"); }},
//                new HashMap<String, String>() {{ put("name","GZ天河好又多店");put("gps","113.378272,23.124939");put("adcode","天河区"); }},
//                new HashMap<String, String>() {{ put("name","GZ天河国金中心");put("gps","113.322846,23.118160");put("adcode","天河区"); }},
//                new HashMap<String, String>() {{ put("name","GZ天河城");put("gps","113.323209,23.132363");put("adcode","天河区"); }},
//                new HashMap<String, String>() {{ put("name","GZ太阳新天地");put("gps","113.343720,23.123460");put("adcode","天河区"); }},
//                new HashMap<String, String>() {{ put("name","GZ四季时尚荟");put("gps","113.401970,23.119117");put("adcode","天河区"); }},
//                new HashMap<String, String>() {{ put("name","GZ时尚天河");put("gps","113.319942,23.141626");put("adcode","天河区"); }},
//                new HashMap<String, String>() {{ put("name","GZ狮岭家宜多");put("gps","113.155865,23.461858");put("adcode","花都区"); }},
//
//                new HashMap<String, String>() {{ put("name","GZ圣地广场");put("gps","113.229792,23.132650");put("adcode","荔湾区"); }},
//                new HashMap<String, String>() {{ put("name","GZ三元里大道");put("gps","113.251677,23.172184");put("adcode","白云区"); }},
//                new HashMap<String, String>() {{ put("name","GZ祈福缤纷世界");put("gps","113.332024,22.969600");put("adcode","番禺区"); }},
//                new HashMap<String, String>() {{ put("name","GZ南沙万达广场");put("gps","113.532817,22.794742");put("adcode","南沙区"); }},
//                new HashMap<String, String>() {{ put("name","GZ南沙华汇广场");put("gps","113.557716,22.800598");put("adcode","南沙区"); }},
//                new HashMap<String, String>() {{ put("name","GZ南沙大岗达森");put("gps","113.406128,22.802368");put("adcode","南沙区"); }},
//                new HashMap<String, String>() {{ put("name","GZ南沙COCO");put("gps","113.547061,22.807183");put("adcode","南沙区"); }},
//                new HashMap<String, String>() {{ put("name","GZ木棉湾广场");put("gps","113.329069,23.185444");put("adcode","白云区"); }},
//                new HashMap<String, String>() {{ put("name","GZ名盛广场");put("gps","113.270708,23.121961");put("adcode","越秀区"); }},
//                new HashMap<String, String>() {{ put("name","GZ美东百货");put("gps","113.297243,23.128294");put("adcode","越秀区"); }},
//
//                new HashMap<String, String>() {{ put("name","GZ梅花园");put("gps","113.321062,23.178549");put("adcode","天河区"); }},
//                new HashMap<String, String>() {{ put("name","GZ漫广场");put("gps","113.424873,23.112497");put("adcode","天河区"); }},
//                new HashMap<String, String>() {{ put("name","GZ萝岗区高德汇");put("gps","113.452784,23.167779");put("adcode","天河区"); }},
//                new HashMap<String, String>() {{ put("name","GZ萝岗奥园");put("gps","113.501067,23.174213");put("adcode","黄埔区"); }},
//                new HashMap<String, String>() {{ put("name","GZ罗冲围友田城");put("gps","113.227654,23.144227");put("adcode","白云区"); }},
//                new HashMap<String, String>() {{ put("name","GZ龙骏广场");put("gps","113.226801,23.177741");put("adcode","白云区"); }},
//                new HashMap<String, String>() {{ put("name","GZ龙洞商业楼");put("gps","113.368398,23.193693");put("adcode","天河区"); }},
//                new HashMap<String, String>() {{ put("name","GZ六福广场");put("gps","113.327173,23.086339");put("adcode","海珠区"); }},
//
//                new HashMap<String, String>() {{ put("name","GZ荔园新天地");put("gps","113.345624,22.919752");put("adcode","番禺区"); }},
//                new HashMap<String, String>() {{ put("name","GZ荔湾荔胜广场");put("gps","113.233291,23.073920");put("adcode","荔湾区"); }},
//                new HashMap<String, String>() {{ put("name","GZ荔湾花地人家");put("gps","113.230071,23.095207");put("adcode","荔湾区"); }},
//                new HashMap<String, String>() {{ put("name","GZ丽影广场");put("gps","113.321047,23.095769");put("adcode","越秀区"); }},
//                new HashMap<String, String>() {{ put("name","GZ乐峰广场");put("gps","113.259017,23.089267");put("adcode","海珠区"); }},
//                new HashMap<String, String>() {{ put("name","GZ金田百佳");put("gps","113.335354,23.141910");put("adcode","天河区"); }},
//                new HashMap<String, String>() {{ put("name","GZ金沙洲梦乐城");put("gps","113.194081,23.147189");put("adcode","白云区"); }},
//                new HashMap<String, String>() {{ put("name","GZ金海岸城市广");put("gps","113.602585,23.127689");put("adcode","增城区"); }},
//                new HashMap<String, String>() {{ put("name","GZ金国商业广场");put("gps","113.253981,23.204473");put("adcode","白云区"); }},
//                new HashMap<String, String>() {{ put("name","GZ江夏新天地");put("gps","113.282532,23.211133");put("adcode","白云区"); }},
//                new HashMap<String, String>() {{ put("name","GZ江南西人");put("gps","113.272263,23.095610");put("adcode","海珠区"); }},
//                new HashMap<String, String>() {{ put("name","GZ江高家宜多");put("gps","113.232854,23.274836");put("adcode","白云区"); }},
//                new HashMap<String, String>() {{ put("name","GZ黄埔潮楼购物");put("gps","113.424875,23.112499");put("adcode","黄埔区"); }},
//                new HashMap<String, String>() {{ put("name","GZ花都盛妆");put("gps","113.209466,23.382311");put("adcode","花都区"); }},
//                new HashMap<String, String>() {{ put("name","GZ花都融创茂");put("gps","113.604209,23.140307");put("adcode","花都区"); }},
//                new HashMap<String, String>() {{ put("name","GZ花都摩登");put("gps","113.204970,23.386230");put("adcode","花都区"); }},
//                new HashMap<String, String>() {{ put("name","GZ花都骏壹万邦");put("gps","113.227390,23.405389");put("adcode","花都区"); }},
//                new HashMap<String, String>() {{ put("name","GZ花都建设路");put("gps","113.210069,23.374717");put("adcode","花都区"); }},
//                new HashMap<String, String>() {{ put("name","GZ花都百花广场");put("gps","113.223112,23.379196");put("adcode","花都区"); }},
//                new HashMap<String, String>() {{ put("name","GZ恒宝华庭店");put("gps","113.241603,23.118105");put("adcode","荔湾区"); }},
//
//                new HashMap<String, String>() {{ put("name","GZ合生广场");put("gps","113.275185,23.088314");put("adcode","海珠区"); }},
//                new HashMap<String, String>() {{ put("name","GZ好信广场");put("gps","113.302410,23.070008");put("adcode","海珠区"); }},
//                new HashMap<String, String>() {{ put("name","GZ海珠万国广场");put("gps","113.272883,23.101389");put("adcode","海珠区"); }},
//                new HashMap<String, String>() {{ put("name","GZ海珠保利广场");put("gps","113.280536,23.102284");put("adcode","海珠区"); }},
//                new HashMap<String, String>() {{ put("name","GZ海印自由闲");put("gps","113.285863,23.126264");put("adcode","越秀区"); }},
//                new HashMap<String, String>() {{ put("name","GZ海铂丽廊广场");put("gps","113.312450,23.103120");put("adcode","海珠区"); }},
//                new HashMap<String, String>() {{ put("name","GZ广州亚运城");put("gps","113.477228,22.940801");put("adcode","番禺区"); }},
//                new HashMap<String, String>() {{ put("name","GZ广州骐利广场");put("gps","113.235294,23.156027");put("adcode","白云区"); }},
//                new HashMap<String, String>() {{ put("name","GZ广州龙归金铂");put("gps","113.293413,23.267821");put("adcode","白云区"); }},
//                new HashMap<String, String>() {{ put("name","GZ广州领好广场");put("gps","113.526046,23.085015");put("adcode","黄埔区"); }},
//                new HashMap<String, String>() {{ put("name","GZ广州金铂广场");put("gps","113.325608,23.196350");put("adcode","白云区"); }},
                new HashMap<String, String>() {{ put("name","GZ广州江燕路");put("gps","113.277967,23.082078");put("adcode","海珠区"); }},
                new HashMap<String, String>() {{ put("name","GZ广州江南新地");put("gps","113.270569,23.094681");put("adcode","海珠区"); }},
                new HashMap<String, String>() {{ put("name","GZ广州黄埔万达");put("gps","113.466258,23.167464");put("adcode","黄浦区"); }},
                new HashMap<String, String>() {{ put("name","GZ广州花都国华");put("gps","113.208262,23.375644");put("adcode","花都区"); }},
                new HashMap<String, String>() {{ put("name","GZ广州高德汇");put("gps","113.347353,23.169586");put("adcode","天河区"); }},
                new HashMap<String, String>() {{ put("name","GZ广州大道北");put("gps","113.326234,23.187919");put("adcode","白云区"); }},
                new HashMap<String, String>() {{ put("name","GZ广州卜蜂莲花");put("gps","113.256967,23.160901");put("adcode","白云区"); }},
                new HashMap<String, String>() {{ put("name","GZ广州白云万达");put("gps","113.266379,23.172775");put("adcode","白云区"); }},
                new HashMap<String, String>() {{ put("name","GZ广州白云凯德");put("gps","113.269448,23.181018");put("adcode","白云区"); }},
                new HashMap<String, String>() {{ put("name","GZ广天河优托邦");put("gps","113.415600,23.132750");put("adcode","天河区"); }},

                new HashMap<String, String>() {{ put("name","GZ广海珠同乐汇");put("gps","113.271532,23.104079");put("adcode","海珠区"); }},
                new HashMap<String, String>() {{ put("name","GZ广百新一城");put("gps","113.266656,23.092994");put("adcode","海珠区"); }},
                new HashMap<String, String>() {{ put("name","GZ高德置地春");put("gps","113.322172,23.119884");put("adcode","天河区"); }},
                new HashMap<String, String>() {{ put("name","GZ富丽城");put("gps","113.311339,23.026651");put("adcode","番禺区"); }},
                new HashMap<String, String>() {{ put("name","GZ富景花园店");put("gps","113.289506,23.092654");put("adcode","海珠区"); }},
                new HashMap<String, String>() {{ put("name","GZ凤凰城");put("gps","113.576840,23.125721");put("adcode","增城区"); }},
                new HashMap<String, String>() {{ put("name","GZ番禺愉园酒店");put("gps","113.366310,22.941120");put("adcode","番禺区"); }},
                new HashMap<String, String>() {{ put("name","GZ番禺永旺广场");put("gps","113.384300,22.934005");put("adcode","番禺区"); }},
                new HashMap<String, String>() {{ put("name","GZ番禺雄峰城");put("gps","113.303334,22.970348");put("adcode","番禺区"); }},
                new HashMap<String, String>() {{ put("name","GZ番禺喜悦天地");put("gps","113.361600,22.949411");put("adcode","番禺区"); }},
                new HashMap<String, String>() {{ put("name","GZ番禺万科里");put("gps","113.378011,22.932867");put("adcode","番禺区"); }},
                new HashMap<String, String>() {{ put("name","GZ番禺万达广场");put("gps","113.348742,22.990104");put("adcode","番禺区"); }},
                new HashMap<String, String>() {{ put("name","GZ番禺人人佳");put("gps","113.387531,23.004902");put("adcode","番禺区"); }},
                new HashMap<String, String>() {{ put("name","GZ番禺桥东路店");put("gps","113.367009,22.936720");put("adcode","番禺区"); }},
                new HashMap<String, String>() {{ put("name","GZ番禺建华汇");put("gps","113.315316,23.024777");put("adcode","番禺区"); }},
                new HashMap<String, String>() {{ put("name","GZ番山商贸城店");put("gps","113.365102,22.941331");put("adcode","番禺区"); }},
                new HashMap<String, String>() {{ put("name","GZ动漫星城");put("gps","113.267021,23.125887");put("adcode","越秀区"); }},
                new HashMap<String, String>() {{ put("name","GZ东平时代都荟");put("gps","113.309423,23.248031");put("adcode","白云区"); }},
                new HashMap<String, String>() {{ put("name","GZ东急新天地店");put("gps","113.248754,23.114504");put("adcode","荔湾区"); }},
                new HashMap<String, String>() {{ put("name","GZ大学城新天地");put("gps","113.393421,23.060742");put("adcode","番禺区"); }},
//
                new HashMap<String, String>() {{ put("name","GZ大石金科广场");put("gps","113.325036,23.010095");put("adcode","番禺区"); }},
                new HashMap<String, String>() {{ put("name","GZ潮流新天地");put("gps","113.327676,23.130793");put("adcode","天河区"); }},
                new HashMap<String, String>() {{ put("name","GZ保利中环广场");put("gps","113.281489,23.137405");put("adcode","越秀区"); }},
                new HashMap<String, String>() {{ put("name","GZ百事佳商业城");put("gps","113.543391,23.110467");put("adcode","黄埔区"); }},
                new HashMap<String, String>() {{ put("name","GZ百佳购物广场");put("gps","113.454076,23.100816");put("adcode","黄埔区"); }},
                new HashMap<String, String>() {{ put("name","GZ白云万民广场");put("gps","113.228646,23.212658");put("adcode","白云区"); }},
                new HashMap<String, String>() {{ put("name","GZ白云时代广场");put("gps","113.304646,23.221700");put("adcode","白云区"); }},
                new HashMap<String, String>() {{ put("name","GZ白云岭南新世");put("gps","113.265106,23.181008");put("adcode","白云区"); }},
                new HashMap<String, String>() {{ put("name","GZ白云来利");put("gps","113.357180,23.292247");put("adcode","白云区"); }},
                new HashMap<String, String>() {{ put("name","GZ白云百信西广");put("gps","113.262607,23.194289");put("adcode","白云区"); }},
                new HashMap<String, String>() {{ put("name","GZ白云安华汇");put("gps","113.302696,23.226385");put("adcode","白云区"); }},
                new HashMap<String, String>() {{ put("name","GZ奥园广场");put("gps","113.357256,22.924046");put("adcode","番禺区"); }},
                new HashMap<String, String>() {{ put("name","GZ奥园城市广场");put("gps","113.300915,23.051377");put("adcode","番禺区"); }},
                new HashMap<String, String>() {{ put("name","CH新世纪广场");put("gps","113.267766,23.115023");put("adcode","番禺区"); }}
        );

        Map<String,String> params = new HashMap<>();
        params.put("key", "CK6BZ-FUMLI-D44GB-5RTY5-D3I65-SBBKX");
        params.put("page_size", "20");
        String url = "https://apis.map.qq.com/ws/place/v1/search" ;

        String[][] values = new String[mapList.size()+1][keywords.size()+1];
        String[][] jsons = new String[mapList.size()+1][keywords.size()+1];

        for (int i=0;i<mapList.size();i++) {
            Map<String, String> map = mapList.get(i);
            String name = map.get("name");
            String boundary = "nearby(%s,500)";
            String[] strings = map.get("gps").split(",");
            String gps = strings[1] + "," + strings[0];
            boundary = String.format(boundary,gps);
            params.put("boundary",boundary);
            values[i][0] = name;
            jsons[i][0] = name;
            for(int j=0;j<keywords.size();j++){
                String keyword = keywords.get(j);
                String category = "category=" + keyword;
                params.put("keyword",category);

                String result = HttpClientUtils.doGet(url, params);
                String count = JSON.parseObject(result).getString("count");
                values[i][j+1] = count;

                String json = JSON.parseObject(result).getString("data");
                jsons[i][j+1] = json;
                Thread.sleep(300);
            }
            System.out.println(name + "结束");
        }
        String[] title = new String[keywords.size()+1];
        title[0] = "门店名称";
        for (int j=0;j<keywords.size();j++) {
            title[j+1] = keywords.get(j);
        }
        String path = "D:\\java_work\\demo\\common\\src\\resources\\" + "业态查询三级维度Count_4.1.xlsx";
        ExcelUtils.createExcel(path, "sheet1", title, null);
        ExcelUtils.appendToExcel(path,"sheet1",values);

        String jsonPath = "D:\\java_work\\demo\\common\\src\\resources\\" + "业态查询三级维度Count_Json_4.xlsx";
        ExcelUtils excelUtils = new ExcelUtils();
        excelUtils.createExcel(jsonPath, "sheet1", title, null);
        excelUtils.appendToExcel(jsonPath, "sheet1", jsons);
    }
}
