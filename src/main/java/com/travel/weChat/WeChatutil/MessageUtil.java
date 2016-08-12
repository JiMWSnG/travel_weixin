package com.travel.weChat.WeChatutil;

import com.github.sd4324530.fastweixin.message.MusicMsg;
import com.github.sd4324530.fastweixin.message.NewsMsg;
import com.github.sd4324530.fastweixin.message.TextMsg;
import com.travel.weChat.msg.EventMsg;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.tree.DefaultCDATA;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 消息工具类
 * @author
 * @date
 */
public class MessageUtil {

    static Logger logger = Logger.getLogger(MessageUtil.class);

    public static final String XML = "xml";
    public static final String ToUserName = "ToUserName";
    public static final String FromUserName = "FromUserName";
    public static final String CreateTime = "CreateTime";
    public static final String MsgType = "MsgType";
    public static final String Event = "Event";
    public static final String EventKey = "EventKey";
    public static final String Content = "Content";
    public static final String FuncFlag = "FuncFlag";

    /**
     * 返回消息类型：文本
     */
    public static final String RESP_MESSAGE_TYPE_TEXT = "text";

    /**
     * 返回消息类型：音乐
     */
    public static final String RESP_MESSAGE_TYPE_MUSIC = "music";

    public static final String MESSAGE_TYPE_EVENT = "event";

    public static final String EVENT_VIEW = "VIEW";

    /**
     * 返回消息类型：图文
     */
    public static final String RESP_MESSAGE_TYPE_NEWS = "news";

    /**
     * 请求消息类型：文本
     */
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";

    /**
     * 请求消息类型：图片
     */
    public static final String REQ_MESSAGE_TYPE_IMAGE = "image";

    /**
     * 请求消息类型：链接
     */
    public static final String REQ_MESSAGE_TYPE_LINK = "link";

    /**
     * 请求消息类型：地理位置
     */
    public static final String REQ_MESSAGE_TYPE_LOCATION = "location";

    /**
     * 请求消息类型：音频
     */
    public static final String REQ_MESSAGE_TYPE_VOICE = "voice";

    /**
     * 请求消息类型：推送
     */
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";

    /**
     * 事件类型：subscribe(订阅)
     */
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";

    /**
     * 事件类型：unsubscribe(取消订阅)
     */
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";

    /**
     * 事件类型：VIEW(跳转链接时的事件)
     */
    public static final String EVENT_TYPE_VIEW = "VIEW";

    /**
     * 扫码事件
     */
    public static final String EVENT_TYPE_SCAN = "SCAN";

    /**
     * 事件类型：CLICK(自定义菜单点击事件)
     */
    public static final String EVENT_TYPE_CLICK = "CLICK";

    /**
     *
     */
    public static final String EVENT_KEY = "EventKey";

    /**
     * 解析微信发来的请求（XML）
     *
     * @param request
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> parseXml(HttpServletRequest request) throws IOException, DocumentException {
        // 将解析结果存储在HashMap中
        Map<String, String> map = new HashMap<String, String>();

        // 从request中取得输入流
        InputStream inputStream = request.getInputStream();
        // 读取输入流
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        logger.info(document.getText());
        // 得到xml根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();

        // 遍历所有子节点
        for (Element e : elementList) {
            logger.info(e.getName()+"----->"+e.getText());
            map.put(e.getName(), e.getText());
        }
        // 释放资源
        inputStream.close();
        inputStream = null;

        return map;
    }

    /**
     * 文本消息对象转换成xml
     * http://mp.weixin.qq.com/wiki/index.php?title=%E6%B6%88%E6%81%AF%E6%8E%A5%E5%8F%A3%E6%8C%87%E5%8D%97#.E5.9B.9E.E5.A4.8D.E6.96.87.E6.9C.AC.E6.B6.88.E6.81.AF
     *  <xml>
     *      <ToUserName><![CDATA[toUser]]></ToUserName>
     *      <FromUserName><![CDATA[fromUser]]></FromUserName>
     *      <CreateTime>12345678</CreateTime>
     *      <MsgType><![CDATA[text]]></MsgType>
     *      <Content><![CDATA[content]]></Content>
     *      <FuncFlag>0</FuncFlag>
     *  </xml>
     * @param textMessage 文本消息对象
     * @return xml
     */
    public static String textMessageToXml(TextMsg textMessage) {
        Document document = DocumentHelper.createDocument();
        Element xml = document.addElement(XML);
        Element ToUserNameElm = xml.addElement(ToUserName);
        ToUserNameElm.add(new DefaultCDATA(textMessage.getToUserName()));
        Element FromUserNameElm = xml.addElement(FromUserName);
        FromUserNameElm.add(new DefaultCDATA(textMessage.getFromUserName()));
        Element CreateTimeElm = xml.addElement(CreateTime);
        CreateTimeElm.setText(String.valueOf(textMessage.getCreateTime()));
        Element MsgTypeElm = xml.addElement(MsgType);
        MsgTypeElm.add(new DefaultCDATA(textMessage.getMsgType()));
        Element ContentElm = xml.addElement(Content);
        ContentElm.add(new DefaultCDATA(textMessage.getContent()));
//        Element FuncFlagElm = xml.addElement(FuncFlag);
//        FuncFlagElm.setText(String.valueOf(textMessage.getFuncFlag()));
        return document.asXML();
    }

    /**
     * 对象转换成xml
     * http://mp.weixin.qq.com/wiki/9/981d772286d10d153a3dc4286c1ee5b5.html#.E7.82.B9.E5.87.BB.E8.8F.9C.E5.8D.95.E8.B7.B3.E8.BD.AC.E9.93.BE.E6.8E.A5.E6.97.B6.E7.9A.84.E4.BA.8B.E4.BB.B6.E6.8E.A8.E9.80.81
     *  <xml>
         <ToUserName><![CDATA[toUser]]></ToUserName>
         <FromUserName><![CDATA[FromUser]]></FromUserName>
         <CreateTime>123456789</CreateTime>
         <MsgType><![CDATA[event]]></MsgType>
         <Event><![CDATA[VIEW]]></Event>
         <EventKey><![CDATA[www.qq.com]]></EventKey>
        </xml>
     * @param textMessage 文本消息对象
     * @return xml
     */
    public static String eventMessageToXml(EventMsg textMessage) {
        Document document = DocumentHelper.createDocument();
        Element xml = document.addElement(XML);

        Element ToUserNameElm = xml.addElement(ToUserName);
        ToUserNameElm.add(new DefaultCDATA(textMessage.getToUserName()));

        Element FromUserNameElm = xml.addElement(FromUserName);
        FromUserNameElm.add(new DefaultCDATA(textMessage.getFromUserName()));

        Element CreateTimeElm = xml.addElement(CreateTime);
        CreateTimeElm.setText(String.valueOf(textMessage.getCreateTime()));

        Element MsgTypeElm = xml.addElement(MsgType);
        MsgTypeElm.add(new DefaultCDATA(textMessage.getMsgType()));

        Element EventElm = xml.addElement(Event);
        EventElm.add(new DefaultCDATA(textMessage.getEvent()));

        Element EventKeyElm = xml.addElement(EventKey);
        EventKeyElm.add(new DefaultCDATA(textMessage.getEventKey()));

        return document.asXML();
    }

    /**
     * 音乐消息对象转换成xml
     *
     * @param musicMessage 音乐消息对象
     * @return xml
     */
    public static String musicMessageToXml(MusicMsg musicMessage) {
        /*xstream.alias("xml", musicMessage.getClass());
        return xstream.toXML(musicMessage);*/
        return null;
    }

    /**
     * 图文消息对象转换成xml
     *
     * @param newsMessage 图文消息对象
     * @return xml
     */
    public static String newsMessageToXml(NewsMsg newsMessage) {
        /*xstream.alias("xml", newsMessage.getClass());
        xstream.alias("item", new Article().getClass());
        return xstream.toXML(newsMessage);*/
        return null;
    }

    /**
     * 判断是否是QQ表情
     *
     * @param content
     * @return
     */
    public static boolean isQqFace(String content) {
        boolean result = false;

        // 判断QQ表情的正则表达式
        String qqfaceRegex = "/::\\)|/::~|/::B|/::\\||/:8-\\)|/::<|/::$|/::X|/::Z|/::'\\(|/::-\\||/::@|/::P|/::D|/::O|/::\\(|/::\\+|/:--b|/::Q|/::T|/:,@P|/:,@-D|/::d|/:,@o|/::g|/:\\|-\\)|/::!|/::L|/::>|/::,@|/:,@f|/::-S|/:\\?|/:,@x|/:,@@|/::8|/:,@!|/:!!!|/:xx|/:bye|/:wipe|/:dig|/:handclap|/:&-\\(|/:B-\\)|/:<@|/:@>|/::-O|/:>-\\||/:P-\\(|/::'\\||/:X-\\)|/::\\*|/:@x|/:8\\*|/:pd|/:<W>|/:beer|/:basketb|/:oo|/:coffee|/:eat|/:pig|/:rose|/:fade|/:showlove|/:heart|/:break|/:cake|/:li|/:bome|/:kn|/:footb|/:ladybug|/:shit|/:moon|/:sun|/:gift|/:hug|/:strong|/:weak|/:share|/:v|/:@\\)|/:jj|/:@@|/:bad|/:lvu|/:no|/:ok|/:love|/:<L>|/:jump|/:shake|/:<O>|/:circle|/:kotow|/:turn|/:skip|/:oY|/:#-0|/:hiphot|/:kiss|/:<&|/:&>";
        Pattern p = Pattern.compile(qqfaceRegex);
        Matcher m = p.matcher(content);
        if (m.matches()) {
            result = true;
        }
        return result;
    }

    /**
     * 将long类型的时间转换成标准格式（yyyy-MM-dd HH:mm:ss）
     *
     * @param longTime
     * @return
     */
    public static String formatTime(long longTime) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date(longTime));
    }

}

