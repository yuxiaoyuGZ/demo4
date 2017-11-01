package demo3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
//本地
public class BLList {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		long ts = System.currentTimeMillis();
		HttpClient client = new DefaultHttpClient();
		// String url =
		// "http://rate.taobao.com/feedRateList.htm?_ksTS=1426064818677_1249&callback=jsonp_reviews_list&userNumId=2083639891&auctionNumId=42082953976&siteID=4&currentPageNum=1&rateType=&orderType=sort_weight&showContent=1&attribute=&ua=";
		// System.out.println(""+ts);
		String URL = "";
		String url = "";
		BufferedReader read = new BufferedReader(new FileReader(new File(
				"C:\\Users\\Administrator\\Desktop\\amazonurl0525.txt")));
		/*
		 * BufferedWriter wr = new BufferedWriter(new FileWriter(new File(
		 * "E://CarLabel//汽车品牌详情//Aika_0927_1.txt")));
		 */
		// String URL = "";
		while ((URL = read.readLine()) != null) {
			String kv[] = URL.split("	");
			url = kv[0];
			String price = "";
			String text = "";
			String newtext = "";
			String name = "";
			String level = "";
			// String url =
			// "http://search.blemall.com/?words=&classid=00005223&key2=";
			// String url =
			// "http://rate.taobao.com/feedRateList.htm?userNumId=2083639891&auctionNumId=42082953976&siteID=4&currentPageNum=1&rateType=&orderType=sort_weight&showContent=1&attribute=&ua=";
			// "http://detailskip.taobao.com/json/sib.htm?itemId=42082953976&sellerId=2083639891&u=1&p=1&rcid=50022703&sts=274534400,1170936092094889988,70368744210560,4297080835&chnl=pc&price=34800&shopId=&vd=1&skil=false&pf=1&al=false&ap=1&ss=1&free=0&st=1&ct=1&ns=1&prior=1&ref="
			HttpGet get = new HttpGet(url);
			get.setHeader("Accept", "*/*");
			String host = get.getURI().getHost();
			// get.setHeader("Accept", "application/javascript, */*;q=0.8");
			// System.out.println(""+host);

			get.setHeader("Connection", "Keep-Alive");
			get.setHeader("Cache-Control", "no-cache");
			get.setHeader(
					"Cookie",
					"thw=cn; cna=exc0DcUaGjwCAdpTbaiwTSc6; lzstat_uv=21891771101599735701|878758; tma=6906807.39987332.1420900625243.1422782504879.1423366358299.8; tmd=10.6906807.39987332.1420900625243.; uc3=nk2=EvGrgYMIeg%3D%3D&id2=UoLefcbN%2FclV&vt3=F8dATk5wJ1XRc0F%2FJKQ%3D&lg2=VFC%2FuZ9ayeYq2g%3D%3D; unt=qdj6679%26unit; lgc=qdj6679; tracknick=qdj6679; _cc_=VFC%2FuZ9ajQ%3D%3D; tg=0; ubn=p; ucn=unit; ali_ab=218.83.109.168.1420900650248.2; mt=ci=-1_0; t=1e8ceb0334b2c1b40ae50863c8108daa; x=e%3D1%26p%3D*%26s%3D0%26c%3D0%26f%3D0%26g%3D0%26t%3D0%26__ll%3D-1%26_ato%3D0; isg=CB067915C14442153804E729C90678C1; _tb_token_=tiq0c8Z8fPGT; cookie2=69991ac0b768c32035eedbd665aaff90");
			get.setHeader(
					"Referer",
					"http://detail.tmall.com/item.htm?spm=a220m.1000858.1000725.21.3ruVgZ&id=14430421341");
			get.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
			get.setHeader("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko");
			get.setHeader("Host", host);
			HttpResponse response = client.execute(get);
			// System.out.println(response.getStatusLine().getStatusCode());
			HttpEntity entity = response.getEntity();
			InputStream inputstream = entity.getContent();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					inputstream, "gbk"));
			StringBuffer sb = new StringBuffer();
			String line = "";
			while ((line = br.readLine()) != null) {
				// System.out.println(line);
				sb.append(line + "\n\r");
			}
			// System.out.println(sb);
			Document doc = Jsoup.parse(sb.toString());
			System.out.println(doc.toString());
			
		/*	2016.9.28
		 * text = doc.select("a[title]").toString();
			
			System.out.println(doc.select("a[title]").first().text());
			System.out.println(doc.select("a[title]").attr("title"));*/
			/*System.out.println(doc.select("title").text());*/
		
			
		/*	Elements ele=doc.select("li#ttbar-apps");
			System.out.println(ele.toString());
			Elements ele1=ele.select("div.dt cw-icon");
			Elements ele2=ele1.select("a");
			System.out.println(ele2.text());
			System.out.println(ele2.attr("href"));*/
			
			
			Elements ele=doc.select("li[class='fore6 dorpdown']");
			System.out.println(ele.toString());
			
			
			/*
			 * Elements a = doc.select("div.demio_wp"); Elements b =
			 * a.select("div.tt_h1").select("span.lt_f1"); Elements d =
			 * a.select("div.tt_h1").select("h1");
			 * 
			 * name = b.text() + d.text();
			 * 
			 * Elements f = doc.select("div.ref_gd"); price =
			 * f.text().replace("厂商指导价：", "");
			 * 
			 * Elements h = doc.select("div.ref_par"); for (Element hh : h) {
			 * Elements z = hh.getElementsByTag("li"); int size = z.size(); for
			 * (int i = 0; i < size; i++) { Elements w = z.get(i).select("li");
			 * if (w.text().contains("：")) { String tag[] = w.text().split("：",
			 * -1); String key1 = tag[0].trim(); String value1 = tag[1].trim();
			 * if (key1.contains("级　别")) { level = value1.trim(); } } } }
			 */

			// System.out.println(url + "\t" + name + "\t" + level + "\t" +
			// price);
			/*
			 * wr.append(url + "\t" + name + "\t" + level + "\t" + price);
			 * wr.newLine(); wr.flush();
			 */

			if (url.toString().contains("p.3.cn")) {
				text = doc.select("body").toString();
				newtext = text.replace("<body>", "");
				newtext = newtext.replace("</body>", "");
				if (newtext.contains("(")) {
					newtext = newtext.substring(newtext.indexOf("(") + 1);
				}
				if (newtext.contains(")")) {
					newtext = newtext.substring(0, newtext.indexOf(")"));
				}
				if (newtext.contains("&quot;")) {
					newtext = newtext.replaceAll("&quot;", "\"");
				}
				newtext = "{\"wangchengwei\":" + newtext + "}"; //
				// System.out.println(newtext);
				Map<String, Object> mapping = parseJSON2Map(newtext);

				// System.out.println(mapping); String json =
				// mapping.toString();
				JSONObject jsonObject = JSONObject.fromObject(newtext);
				JSONArray itemList = jsonObject.getJSONArray("wangchengwei");
				if (itemList.toString().length() > 0) {
					for (int i = 0; i < itemList.size(); i++) {
						String s = itemList.getString(i);
						JSONObject data = JSONObject.fromObject(s);
						if (s.contains("p")) {
							price = data.getString("p");
						}
					}
				}
			} else if (url.toString().contains("gps.yhd.com")) {
				text = doc.select("body").toString();
				newtext = text.replace("<body>", "");
				newtext = newtext.replace("</body>", "");
				if (newtext.contains("(")) {
					newtext = newtext.substring(newtext.indexOf("(") + 1);
				}
				if (newtext.contains(")")) {
					newtext = newtext.substring(0, newtext.indexOf(")"));
				}
				if (newtext.contains("&quot;")) {
					newtext = newtext.replaceAll("&quot;", "\"");
				}
				newtext = "{\"wangchengwei\":" + newtext + "}";
				// System.out.println(newtext);
				Map<String, Object> mapping = parseJSON2Map(newtext);

				// System.out.println(mapping);
				String json = mapping.toString();
				JSONObject jsonObject = JSONObject.fromObject(json);
				JSONObject jsonObject1 = jsonObject
						.getJSONObject("wangchengwei");
				if (jsonObject1.toString().contains("currentPrice")) {
					price = jsonObject1.getString("currentPrice");
				}
			} else if (url.toString().contains("product.dangdang.com")) {
				newtext = doc.text();
				Elements a = doc.select("p#price_sale");
				price = a.text();
			} else if (url.toString().contains("ss.gome.com.cn")) {
				text = doc.select("body").toString();
				newtext = text.replace("<body>", "");
				newtext = newtext.replace("</body>", "");
				if (newtext.contains("(")) {
					newtext = newtext.substring(newtext.indexOf("(") + 1);
				}
				if (newtext.contains(")")) {
					newtext = newtext.substring(0, newtext.indexOf(")"));
				}
				if (newtext.contains("&quot;")) {
					newtext = newtext.replaceAll("&quot;", "\"");
				}
				if(newtext.contains("\"salePrice\":\"")){
					price = newtext.substring(newtext.indexOf("\"salePrice\":\"") +13 );
				}
				if(price.contains("\"")){
					price = price.substring(0,price.indexOf("\""));
				}

			}else if(url.toString().contains("icps.suning.com")){
				text = doc.select("body").toString();
				newtext = text.replace("<body>", "");
				newtext = newtext.replace("</body>", "");
				if (newtext.contains("(")) {
					newtext = newtext.substring(newtext.indexOf("(") + 1);
				}
				if (newtext.contains(")")) {
					newtext = newtext.substring(0, newtext.indexOf(")"));
				}
				if (newtext.contains("&quot;")) {
					newtext = newtext.replaceAll("&quot;", "\"");
				}
				if(newtext.contains("\"promotionPrice\":\"")){
					price = newtext.substring(newtext.indexOf("\"promotionPrice\":\"") +18 );
				}
				if(price.contains("\"")){
					price = price.substring(0,price.indexOf("\""));
				}

			}else if(url.toString().contains("pas.suning.com")){
				text = doc.select("body").toString();
				newtext = text.replace("<body>", "");
				newtext = newtext.replace("</body>", "");
				if (newtext.contains("(")) {
					newtext = newtext.substring(newtext.indexOf("(") + 1);
				}
				if (newtext.contains(")")) {
					newtext = newtext.substring(0, newtext.indexOf(")"));
				}
				if (newtext.contains("&quot;")) {
					newtext = newtext.replaceAll("&quot;", "\"");
				}
				if(newtext.contains("\"netPrice\":\"")){
					price = newtext.substring(newtext.indexOf("\"netPrice\":\"") +12 );
				}
				if(price.contains("\"")){
					price = price.substring(0,price.indexOf("\""));
				}

			}else if(url.toString().contains("www.amazon.cn")){
				newtext = doc.text();
				Elements els = doc.select("span.a-color-secondary");
				Elements eles1 = els.select("span#priceblock_ourprice");
				if (els.size() > 0) {
					price = els.text();
				}
				System.out.println(url + "\t" + price + "\t" + newtext);

			}

		}
	}

	public static Map<String, Object> parseJSON2Map(String jsonStr) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 最外层解析
		JSONObject json = JSONObject.fromObject(jsonStr);
		for (Object k : json.keySet()) {
			Object v = json.get(k);
			// 如果内层还是数组的话，继续解析
			if (v instanceof JSONArray) {
				List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
				if (list.size() > 0) {
					Iterator<JSONObject> it = ((JSONArray) v).iterator();
					while (it.hasNext()) {
						JSONObject json2 = it.next();
						list.add(parseJSON2Map(json2.toString()));
					}
					map.put(k.toString(), list);
				}
			} else {
				map.put(k.toString(), v);
			}
		}
		return map;
	}
}
