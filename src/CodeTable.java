
public class CodeTable implements java.io.Serializable{
	private static final long serialVersionUID = 5236141400404076238L;

	private int id;
	private String EventName;
	private String EventCode;
	private String FeatureName;
	private String RangeFrom;
	private String vType;
	private String level;
	
	public String getEventName() {
		return EventName;
	}
	
	public void setEventName(String eventName) {
		EventName = eventName;
	}

	public String getEventCode() {
		return EventCode;
	}

	public void setEventCode(String eventCode) {
		EventCode = eventCode;
	}

	public String getFeatureName() {
		return FeatureName;
	}

	public void setFeatureName(String featureName) {
		FeatureName = featureName;
	}

	public String getRangeFrom() {
		return RangeFrom;
	}

	public void setRangeFrom(String rangeFrom) {
		RangeFrom = rangeFrom;
	}

	public String getvType() {
		return vType;
	}

	public void setvType(String vType) {
		this.vType = vType;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
