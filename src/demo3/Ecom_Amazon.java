package demo3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
//网络集群模板
public class Ecom_Amazon {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader read = new BufferedReader(new FileReader(new File(
				"C:\\Users\\Administrator\\Desktop\\amazonurl0525.txt")));//----------------------需要爬取得地址
		String URL = "";
		while ((URL = read.readLine()) != null) {
			URL url = new URL(URL);
			// URL url = new
			// URL("http://tv.sohu.com/20160314/n440332467.shtml");
			try {
				Document doc = Jsoup.parse(url, 11111);
				String uri = "";
				String label = "";
				String name = "";
				String title = "";
				String cat = "";

				String brand = "";
				String price = "";
				
				/*Elements aaa = doc.select("a");
				for (Element zzz : aaa) {
					String abc = zzz.attr("href");
					if (abc.contains("www.amazon.cn")) {
						abc = "http:" + abc ;
						if (abc.contains("#comments")) {
							abc = abc.substring(0, abc.indexOf("#comments-list"));
						//	surl.append(abc + "\r\n");
							surl.append(url + "\t" + abc + "\t" + ItemId.evaluate(abc)
									+ "\r\n");
							System.out.println(abc);
						} else {

					//		surl.append(abc + "\r\n");
							surl.append(url + "\t" + abc + "\t" + ItemId.evaluate(abc)
									+ "\r\n");
							System.out.println(abc);

						}
					}
				}*/

				Elements eles = doc.select("a.pic");
				if (eles.size() > 0) {
					// System.out.println(eles.select("div.breadcrumb").text());
					Elements eles2 = eles.select("li.zg_hrsr_item");

					for (Element e : eles2) {
						Elements eles3 = e.getElementsByTag("li");
						int EleSize = eles3.size();
						for (int i = 0; i < EleSize; i++) {
							label += eles3.get(i).text() + ",";
						}
					}
					String gv[] = label.split(",");
					// System.out.println(kv[0]);
					// System.out.println(kv.length);
					label = gv[0].trim();
					label = label.substring(label.indexOf("-") + 1);
					label = label.replaceAll(">", ",");
				} else if (eles.size() == 0) {
					Elements abc = doc.select("ul.a-horizontal").select(
							"ul.a-size-small");
					Elements cde = abc.select("span.a-list-item");
					System.out.println(cde.text());
					for (Element e : cde) {
						Elements eles3 = e.getElementsByTag("a");
						int EleSize = eles3.size();
						for (int i = 0; i < EleSize; i++) {
							label += eles3.get(i).text() + ",";
						}
					}
					if ((null != label) && (label.endsWith(","))) {
						label = label.substring(0, label.length() - 1);
					}

				}

				/*Elements metas = doc.select("meta");
				for (Element meta : metas) {
					if (meta.attr("name").equals("description")) {
						description = meta.attr("content");
					}
					if (meta.attr("name").trim().equals("keywords")) {
						keywords = meta.attr("content");
					}
					if (meta.attr("name").trim().equals("title")) {
						title = meta.attr("content");
					}
				}*/

				Elements detaillists1 = doc.select("td.bucket");
				Elements detaillists = detaillists1.select("div.content");
				if (detaillists.size() > 0) {
					for (Element detail : detaillists) {
						Elements tags = detail.getElementsByTag("li");
						// System.out.println(tags.text());
						String kv[] = new String[2];
						int EleSize = tags.size();
						for (int i = 0; i < EleSize; i++) {
							String tag = tags.get(i).text();
							/*
							 * if(tag.contains("用户评分")){ tag =
							 * tag.substring(0,tag.indexOf("用户评分")); tag =
							 * tag.substring(0,tag.indexOf("亚马逊")); }
							 */

							if (tag.contains(":")) {
								kv = tag.split(":");
							} else if (tag.contains("：")) {
								kv = tag.split("：");
							} else {
								continue;
							}
							if ((kv != null) && (kv.length > 1)) {
								String key = kv[0].trim();
								String value = kv[1].trim();
								/*detaillist
										.put(key, value.length() > 0 ? value : "NULL");*/
							}
						}
					}
				} else {
					Elements info = doc.select("div.container");
					Elements info1 = info.select("div.content");
					Elements info2 = info1.select("tbody");
					Elements info3 = info2.select("tr");
					// System.out.println(info3.size());
					// System.out.println(info3.first().text());
					for (Element INFO : info3) {
						// Elements TAGS = INFO.getElementsByTag("tr");
						// System.out.println(INFO.);
						Elements a = INFO.select("td.label");
						Elements b = INFO.select("td.value");
						// System.out.println(TAGS.text());
						// System.out.println(a.text());
						// System.out.println(b.text());
						String key = a.text();
						String value = b.text();
//						detaillist.put(key, value.length() > 0 ? value : "NULL");
						if (key.contains("型号")) {
//							type = value;
						}
					}
				}
				Elements z = doc.select("div.a-section");
				Elements x = z.select("a#brand");
				if (x.size() > 0) {
				    brand = x.text();
				}

				Elements els = doc.select("table.a-lineitem");
				Elements eles1 = els.select("span#priceblock_ourprice");
				if (eles1.size() > 0) {
					price = eles1.text();
				}
				Elements aa = doc.select("div.a-section");
				// System.out.println(1 + aa.text());
				Elements bb = aa.select("span#productTitle");
				// System.out.println(2 + bb.text());
				if (bb.size() > 0) {
					name = bb.text();
				} else {
					Elements cc = doc.select("div.buying");
					// System.out.println(1 + aa.text());
					Elements dd = aa.select("span#btAsinTitle");
					if (dd.size() > 0) {
						name = dd.text();
					}
				}
				
				System.out.println(url + "\t" + name + "\t" + label  + "\t" + brand + "\t" + price);

				
			} catch (org.jsoup.HttpStatusException e) {
				System.out.println(e);
			}

			// }
		}
	}

}
