package Report;

import Controller.DatabaseConnection;

class Report {
    String _text;
    private int _reportID;
	DatabaseConnection databaseConnection;

    String getText() {
        return this._text;
    }

    void setText(String aText) {
        this._text = aText;
    }

    int getReportID() {
        return this._reportID;
    }

    void setReportID(int aReportID) {
        this._reportID = aReportID;
    }

    void generate() {
        throw new UnsupportedOperationException();
    }

    Report() {
        throw new UnsupportedOperationException();
    }
}