#travel_api
/**route的api基本完善，hotel的还有些问题，ticket还没测
slideBox place: index route
插入数据库的时间单位为s，gettime()/1000

/login  登录                                                                                           ok
params:username,passwd,CAPTCHA,authorization,token  可以少，但名字要一样，用表单或json都行
return： success {"success":true,"code":0,"msg":null,"data":userId}
           fail  {"success":false,"code":error_code,"msg":error_msg,"data":null}

/logout 登出
params:
return: success
           fail

/register 注册,                                                                                        OK
密码在后台加密，明文传输；
params:username,passwd,phone,token,email,lastIp,deviceType
return: success {"success":true,"code":0,"msg":null,"data":userId}
          fail  {"success":false,"code":error_code,"msg":error_msg,"data":null}

/route/recommends                                                                                      ok
需要分页
params:pageSize,currentPage
return: success  {"success":true,"code":0,"msg":null,"data":[{"id":10,"picturePath":"iqweb","name":"bei'ji","type":"1","description":"a good route","createTime":131213131,"updateTime":1312123131,"price":100.0,"location":"beiji","status":"1","indexs":"beijidsa","themeId":null}],"page":{"pageSize":10,"currentPage":1,"totalPages":0,"totalRows":0,"pageStartRow":0,"pageEndRow":0,"pagination":false,"hasNextPage":false,"hasPreviousPage":false,"pagedView":null}}
           fail  {"success":false,"code":error_code,"msg":error_msg,"data":null}

/hotel/recommends                                                                                       ok
需要分页
params:pageSize,currentPage
return: success  {"success":true,"code":0,"msg":null,"data":[],"page":{"pageSize":10,"currentPage":1,"totalPages":0,"totalRows":0,"pageStartRow":0,"pageEndRow":0,"pagination":false,"hasNextPage":false,"hasPreviousPage":false,"pagedView":null}}
           fail  {"success":false,"code":error_code,"msg":error_msg,"data":null}


/ticket/recommends
需要分页
params:pageSize,currentPage
return: success  {"success":true,"code":0,"msg":null,"page":{},"data":[]ticket list}
           fail  {"success":false,"code":error_code,"msg":error_msg,"data":null}

/route/slideBox  线路页面轮播窗                                                                  ok
params:
return: success  {"success":true,"code":0,"msg":null,"page":{},"data":[route list]}
           fail  {"success":false,"code":error_code,"msg":error_msg,"data":null}

/route/search/{type}/{location}/{indexs}线路的搜索
eg:   http://localhost:8010/route/search/2/北京市内/故宫                                         ok
indexs是搜索的关键字
params:location,type,indexs , pageSize,currentPage
return: success  {"success":true,"code":0,"msg":null,"data":[{"id":28,"picturePath":"","name":"北京三日游","type":"2","description":"这是一个测试线路，啦啦啦啦啦啦啦啦啦","createTime":1470385539,"updateTime":1470385539,"price":100.0,"location":"北京市内","status":"0","indexs":"故宫，颐和园，长城","themeId":null},{"id":18,"picturePath":"","name":"北京三日游","type":"2","description":"这是一个测试线路，啦啦啦啦啦啦啦啦啦", "createTime":1470384661,"updateTime":1470384661,"price":100.0,"location":"北京市内","status":"0","indexs":"故宫，颐和园，长城","themeId":null}],"page":{"pageSize":10,"currentPage":1,"totalPages":0,"totalRows":0,"pageStartRow":0,"pageEndRow":0,"pagination":false,"hasNextPage":false,"hasPreviousPage":false,"pagedView":null}}
           fail  {"success":false,"code":error_code,"msg":error_msg,"data":null}

/route/detail/{routeId}                                                                         ok
查询线路细节
params:routeId
return: success  {"success":true,"code":0,"msg":null,"data":{"route":{"id":24,"picturePath":"","name":"北京三日游","type":"2","description":"这是一个测试线路，啦啦啦啦啦啦啦啦啦","createTime":1470385140,"updateTime":1470385140,"price":100.0,"location":"北京市内","status":"0","indexs":"故宫，颐和园，长城","themeId":null},"routeCalendar":{"id":5,"productId":24,"calendar":"{2016:{may:{1:{price:1.00,totalMount:100,currentMount:99},2:{...}},june:{...}},2017:{...}}","createTime":1470385145,"updateTime":1470385145}}}
           fail  {"success":false,"code":error_code,"msg":error_msg,"data":null}

/hotel/search/{type}/{location}/{indexs}/{level}                                                ok
params:location,type,indexs ,level,  pageSize,currentPage
return: success  {"success":true,"code":0,"msg":null,"data":[],"page":{"pageSize":10,"currentPage":1,"totalPages":0,"totalRows":0,"pageStartRow":0,"pageEndRow":0,"pagination":false,"hasNextPage":false,"hasPreviousPage":false,"pagedView":null}}
           fail  {"success":false,"code":error_code,"msg":error_msg,"data":null}

/detail/{hotelId}
params:hotelId
return: success  {"success":true,"code":0,"msg":null,"data":{"route":{"id":24,"picturePath":"","name":"北京三日游","type":"2","description":"这是一个测试线路，啦啦啦啦啦啦啦啦啦","createTime":1470385140,"updateTime":1470385140,"price":100.0,"location":"北京市内","status":"0","indexs":"故宫，颐和园，长城","themeId":null},"routeCalendar":{"id":5,"productId":24,"calendar":"{2016:{may:{1:{price:1.00,totalMount:100,currentMount:99},2:{...}},june:{...}},2017:{...}}","createTime":1470385145,"updateTime":1470385145}}}
           fail  {"success":false,"code":error_code,"msg":error_msg,"data":null}
《-----------------------------------------后台api-------------------------------------------------------》
/backstage/route/add     添加线路                                                                      ok
params:picturePath,name,type,description,price,location,status,indexs,themeId,calendar
return: success  {"success":true,"code":0,"msg":null,"data":routeId}
           fail  {"success":false,"code":error_code,"msg":error_msg,"data":null}

/backstage/slideBox/add                                                                               ok
params:picture,type,productId,place,status
return: success  {"success":true,"code":0,"msg":null,"data":null}
           fail  {"success":false,"code":error_code,"msg":error_msg,"data":null}


《-----------------------------------------常量-------------------------------------------------------》
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
	public  static  final String TRAVEL_TOKEN ="QAZWSXEDCRFVBGTYHNMJUIKL";  //token全局用一个

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
