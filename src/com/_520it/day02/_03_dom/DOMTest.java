package com._520it.day02._03_dom;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import junit.framework.Assert;

//需求：获取Document对象：
public class DOMTest {
	
	private File f = new File("E:/JavaLearning/JavaSuperLearning/Java基础加强/contacts222.xml");
	
	@Test
	public void testGetDocument() throws Exception {
		//0):确定解析哪一个XML文件:
	}
	
	//1.得到某个具体的文本节点的内容：取出第二个联系人的名字
	@Test
	public void test1() throws Exception {
		// 1):获取Document文档对象.
		Document doc = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder().parse(f);
		
		// 2):获取根元素:contacts
		Element root = doc.getDocumentElement();
		
		// 3):获取根元素的第二个子元素:linkman元素.
		NodeList nodeList = root.getElementsByTagName("linkman");
		Element linkmanEl = (Element)nodeList.item(1);
		
		// 4):再获取第二个linkman元素中的name元素.
		Element nameEl = (Element)linkmanEl.getElementsByTagName("name").item(0);
		
		// 5):最后再获取name元素的文本内容.
		String name = nameEl.getTextContent();
		Assert.assertEquals("断言", "Stef", name);
	}
	
	//2.修改某个元素节点的主体内容：把第一个联系人的邮箱改掉
	//will@ 替换  iwiller@sina.cn.
	@Test
	public void test2() throws Exception {
		//1):获取Document文档对象.
		Document doc = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder().parse(f);
		
		//2):获取根元素:contacts.
		Element root = doc.getDocumentElement();
		
		//3):获取根元素的第一个子元素:linkman元素.
		Element linkmanEl = (Element)root.getElementsByTagName("linkman").item(0);
		
		//4):再获取第一个linkman元素中的email元素.
		Element emailEl = (Element) linkmanEl.getElementsByTagName("email").item(0);
		
		//5):给email元素设置新的文本内容:will@.
		emailEl.setTextContent("iwiller@sina.cn");

		//6):同步操作,把内存中的数据更新到磁盘的XML文件中.
		//   核心类:Transformer
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer trans = factory.newTransformer();//创建一个转换器对象
		Source xmlSource = new DOMSource(doc);//源:Document对象
		Result outputTarget = new StreamResult(f);//目标:File对象
		trans.transform(xmlSource, outputTarget);
	}
	
	//3.向指定元素节点中增加子元素节点：增加一个联系人信息
	@Test
	public void test3() throws Exception {	
		//1):获取Document文档对象.
		Document doc = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder().parse(f);
		
		//2):获取根元素:contacts.
		Element root = doc.getDocumentElement();
		
		//3):创建一个linkman元素片段  :  
		//3.1):创建linkman,name,email,address,group五个元素.
		Element linkmanEl = doc.createElement("linkman");
		Element nameEl = doc.createElement("name");
		Element emailEl = doc.createElement("email");
		Element addressEl = doc.createElement("address");
		Element groupEl = doc.createElement("group");
		//3.2):再给name,email,address,group四个元素设置文本内容.
		//linkmanEl.setAttribute("id","233");
		nameEl.setTextContent("Lucy");
		emailEl.setTextContent("Lucy@sina.cn");
		addressEl.setTextContent("四川");
		groupEl.setTextContent("大神组");
		
		//3.3):把name,email,address,group四个元素设置为linkman元素的子元素.
		linkmanEl.appendChild(nameEl);
		linkmanEl.appendChild(emailEl);
		linkmanEl.appendChild(addressEl);
		linkmanEl.appendChild(groupEl);
		
		//3.4):把linkman元素设置为根元素的子元素.
		root.appendChild(linkmanEl);
		
		//4):同步操作,把内存中的数据更新到磁盘的XML文件中.
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer trans = factory.newTransformer();//创建一个转换器对象
		Source xmlSource = new DOMSource(doc);//源:Document对象
		Result outputTarget = new StreamResult(f);//目标:File对象
		trans.transform(xmlSource, outputTarget);
	}
	
	//4.操作XML文件属性：设置/获取第三个联系人的id属性
	@Test
	public void test4() throws Exception {
		//1):获取Document文档对象.
		Document doc = DocumentBuilderFactory.newInstance()
						.newDocumentBuilder().parse(f);
				
		//2):获取根元素:contacts.
		Element root = doc.getDocumentElement();
		
		//3):获取第三个linkman元素.
		Element linkmanEl = (Element)doc.getElementsByTagName("linkman").item(2);
		
		//4):给linkman元素设置id属性/获取linkman元素的id属性值
		linkmanEl.setAttribute("id","233");
		String id = linkmanEl.getAttribute("id");
		
		//5):如果是设置属性值,还得同步.
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer trans = factory.newTransformer();//创建一个转换器对象
		Source xmlSource = new DOMSource(doc);//源:Document对象
		Result outputTarget = new StreamResult(f);//目标:File对象
		trans.transform(xmlSource, outputTarget);
	}
	
	//5.删除指定元素节点：删除第三个联系人信息
	@Test
	public void test5() throws Exception {
		
		//1):获取Document文档对象.
		Document doc = DocumentBuilderFactory.newInstance()
						.newDocumentBuilder().parse(f);
					
		//2):获取根元素:contacts.
		Element root = doc.getDocumentElement();
		
		//3):获取第三个linkman元素.
		Element linkmanEl = (Element)doc.getElementsByTagName("linkman").item(2);
		
		//4):删除第三个联系人的linkman元素
		//root.removeChild(linkmanEl);
		linkmanEl.getParentNode().removeChild(linkmanEl);
		
		//5):同步操作
		Transformer trans = TransformerFactory.newInstance().newTransformer();//创建一个转换器对象
		trans.transform(new DOMSource(doc), new StreamResult(f));
	}
	
	//6.在内存中创建一个Document对象
	@Test
	public void test6() throws Exception {
		//1):获取Document文档对象.
		Document doc = null;
		DocumentBuilder builder = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		//====================================================
		//如果File对象存在，则直接解析，否则在内存中创建一个新的Document对象
		if(f.exists()){
			doc = builder.parse(f);
		}else{
			doc = builder.newDocument();
			doc.setXmlVersion("1.0");//设置XML的声明
			//设置一个根元素，并作为文档的儿子节点
			doc.appendChild(doc.createElement("contacts"));
			
		}
		//====================================================
		
		//2):获取根元素:contacts.
		Element root = doc.getDocumentElement();
		
		//3):创建一个linkman元素片段  :  
		//3.1):创建linkman,name,email,address,group五个元素.
		Element linkmanEl = doc.createElement("linkman");
		Element nameEl = doc.createElement("name");
		Element emailEl = doc.createElement("email");
		Element addressEl = doc.createElement("address");
		Element groupEl = doc.createElement("group");
		//3.2):再给name,email,address,group四个元素设置文本内容.
		//linkmanEl.setAttribute("id","233");
		nameEl.setTextContent("Lucy");
		emailEl.setTextContent("Lucy@sina.cn");
		addressEl.setTextContent("四川");
		groupEl.setTextContent("大神组");
		
		//3.3):把name,email,address,group四个元素设置为linkman元素的子元素.
		linkmanEl.appendChild(nameEl);
		linkmanEl.appendChild(emailEl);
		linkmanEl.appendChild(addressEl);
		linkmanEl.appendChild(groupEl);
		
		//3.4):把linkman元素设置为根元素的子元素.
		root.appendChild(linkmanEl);
		
		//4):同步操作,把内存中的数据更新到磁盘的XML文件中.
		Transformer trans = TransformerFactory.newInstance().newTransformer();//创建一个转换器对象
		trans.transform(new DOMSource(doc), new StreamResult(f));
		
	}
}
