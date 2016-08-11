package com.travel.contants;

public class Contants {


	public static  final int  INITIAL_CODE = 9999;
	/**
	 *  error
     */
	public  static final int USERNAME_ERROR_CODE = -1;
	public  static final int PASSWD_ERROR_CODE = -2;
	public  static final int AUTHORIZATION_ERROR_CODE = -4;
	/**
	 * TOKEN
     */
	public  static  final String TRAVEL_TOKEN ="QAZWSXEDCRFVBGTYHNMJUIKL";

	/** error
	 *
     */
	public static final int PARAM_ERROR_CODE = -101;
	public static final int DB_ERROR_CODE =    -109;
	public static final int TOKEN_ERROR_CODE = -110;

	/**
	 * route的type
	 */
	public static final String ROUTE_TYPE_RECOMMEND = "1";
	public static final String ROUTE_TYPE_NORMAL  = "0";
	public static final String ROUTE_TYPE_HOT = "2";
	public static final String ROUTE_TYPE_NEW = "3";
	public static final String ROUTE_TYPE_DEFAULT = "-1";

	/**
	 * route status
     */

	public static final String ROUTE_STATUS_OPEN = "0";
	public static final String ROUTE_STATUS_CLOSE = "1";


	/**
	 * hotel   category
	 */
	public static final String HOTEL_CATEGORY_RECOMMEND = "recommend";
	public static final String HOTEL_CATEGORY_NORMAL  = "normal";
	public static final String HOTEL_CATEGORY_HOT = "hot";
	/**
	 * HOTEL TYPE 房型
     */
	public static final String HOTEL_TYPE_SINGLE = "1";
	public static final String HOTEL_TYPE_DOUBLE = "2";
	public static final String HOTEL_TYPE_TRIPLE = "3";
	public static final String HOTEL_TYPE_QUAD = "4";
	public static final String HOTEL_TYPE_STANDARD = "5";

	public static final String HOTEL_TYPE_SINGLEROOM = "1";
	/*按设施及规格分：

　　单人间 Single Room

　　双人间 Double Room

　　大床间 King Size & Queen Size Room

　　标准间 Standard

　　标准间单人住 TSU(Twin for Sole Use)

　　三人间 Triple

　　四人间 Quad

　　套间 Suite

　　公寓 Apartment

　　别墅 Villa

　　按级别分：

　　经济间 Economic Room

　　普通间 Standard Room

　　高级间 Superior Room

　　豪华间 Deluxe Room

　　商务标间 Business Room

　　行政标间 Executive Room

　　行政楼层 Executive Floor

　　按朝向分:

　　朝街房 Front View Room

　　背街房 Rear View Room

　　城景房 City View Room

　　园景房 Garden View Room

　　海景房 Sea View Room

　　湖景房 Lake View Room

　　特殊房型:

　　不限房型 Run of the House

　　无烟标准间 Non Smoking

　　残疾人客房 Handicapped Room

　　带厨房客房 Room with Kitchen

　　相邻房 Adjoining Room

　　ST-Standard  Twin  标准双人房
　　SD-Standard  Ded   标准大床房
　　LD-Lady  Ded       女士房
　　DD-Deluxe  Ded     豪华大床房
　　SS-Standard Single 标准单人间
　　DS-Deluxe Suite    豪华套房*/
	/**
	 * ticket   type
	 */
	public static final String TICKET_TYPE_RECOMMEND = "recommend";
	public static final String TICKET_TYPE_NORMAL  = "normal";
	public static final String TICKET_TYPE_HOT = "hot";

	/**
	 * authorization
	 *
     */
	public  static final String AUTHORIZATION_NORMAL = "normal";
	public  static final String AUTHORIZATION_vip = "vip";
	public  static final String AUTHORIZATION_ADMIN = "admin";
	public  static final String AUTHORIZATION_BOSS = "boss";


	/**
	 * slidebox type
     */
	public  static final String SLIDEBOX_TYPE_ROUTE = "route";
	public  static final String SLIDEBOX_TYPE_HOTEL = "hotel";
	public  static final String SLIDEBOX_TYPE_TICKET = "ticket";

	/**
	 * order status
	 *
     */
	public static final String ORDER_STATUS_TOVERIFY = "toVerify";
	public static final String ORDER_STATUS_TOPAY = "toPay";
	public static final String ORDER_STATUS_PAYED = "payed";
	public static final String ORDER_STATUS_CONSIGNED = "consigned";
	public static final String ORDER_STATUS_FINISHED = "finished";
	public static final String ORDER_STATUS_CANCEL = "cancel";

	/**
	 * contact idcard
	 */
	public static final String CONTACT_IDTYPE_SHENFENZHENG = "0";
	public static final String CONTACT_IDTYPE_HUZHAO = "1";
	public static final String CONTACT_IDTYPE_HUKOUBEN = "2";
}
