package Report;

public class Report {
	private String _text;
	private int _reportID;

	public String getText() {
		return this._text;
	}

	public void setText(String aText) {
		this._text = aText;
	}

	public int getReportID() {
		return this._reportID;
	}

	public void setReportID(int aReportID) {
		this._reportID = aReportID;
	}

	public Report() {
		throw new UnsupportedOperationException();
	}
}