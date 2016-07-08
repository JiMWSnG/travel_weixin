import com.travel.util.Page;
import org.apache.log4j.Logger;


@SuppressWarnings("serial")
public class HandlerResult implements java.io.Serializable
{
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(HandlerResult.class);
	
	ResultState resultState;
	
	protected Object resultObj;
	
	protected Page page;
	
	protected ClientCallbackInfo clientCallbackInfo;
	
	public ResultState getResultState() {
		return resultState;
	}

	public void setResultState(ResultState resultState) {
		this.resultState = resultState;
	}

	public HandlerResult(){}

	public ClientCallbackInfo getClientCallbackInfo()
	{
		return clientCallbackInfo;
	}

	public void setClientCallbackInfo(ClientCallbackInfo clientCallbackInfo)
	{
		this.clientCallbackInfo = clientCallbackInfo;
	}


	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Object getResultObj() {
		return resultObj;
	}

	public void setResultObj(Object resultObj) {
		this.resultObj = resultObj;
	}


}
