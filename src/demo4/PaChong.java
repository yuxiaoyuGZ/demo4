package demo4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;


public class PaChong {
	static InputStream imputStream=null;
	static OutputStream outputStream=null;
	
	public static void main(String[] args) throws Exception {
		post("http://item.jd.com/10489963990.html");
	}
	
	public static void post(String path) throws Exception{
		HttpClient httpclient=new HttpClient();
		
		/*GetMethod getMethod=new GetMethod("http://item.jd.com/10489963990.html");*/
		
		PostMethod postMethod=new PostMethod(path);
		
		NameValuePair[] nvp=new NameValuePair[1];
		nvp[0] = new NameValuePair("衣服","裤子");
		
		postMethod.addParameters(nvp);
		
		int status=httpclient.executeMethod(postMethod);
 		
		imputStream=postMethod.getResponseBodyAsStream();
		
		System.out.println(postMethod.getResponseBodyAsStream());
		
		String filename=path.substring(path.lastIndexOf("/")+1);
		
		System.out.println(filename);
		outputStream=new FileOutputStream(filename);
		
		
		int tempByte=-1;
		while((tempByte=imputStream.read())>0){
			outputStream.write(tempByte);
		}
		
		if(imputStream!=null){
			imputStream.close();
		}
		if(outputStream!=null){
			outputStream.close();
		}
		
		
		
	
		System.out.println(status);
		
		
		
		
		
		
		
//		System.out.println(postMethod.getResponseBodyAsString());
		
		postMethod.releaseConnection();
	}

}
