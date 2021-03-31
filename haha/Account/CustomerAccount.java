package Account;

import DB.DBConnWrapper;
import Processing.Job;
import Discount.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class CustomerAccount {
    private Integer _customerId;
    private String _name;
    private String _address;
    private String _email;
    private String  _phoneNumber;
    private Boolean _valued;
    private Date _lastReportTime;
    private ArrayList<String> _cardNumbers;
    private Integer _discountPlanId;

    private Boolean SetSQL(String Column, String Value) {
        Connection conn = DBConnWrapper.getConnection();
        String query = "UPDATE CustomerAccount \n"+
                "SET " + Column + " = " + Value + "\n"+
                "WHERE `No` = " + getId().toString();
        try {
            Integer num = conn.createStatement().executeUpdate(query);
            if (num == 0) {
                throw new RuntimeException("Failed SQL update " + Column + " = " + Value);
            }
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void loadDetails() {
        Connection conn = DBConnWrapper.getConnection();
        String query = "SELECT * FROM CustomerAccount WHERE `No` = " + getId().toString();
        try {
            ResultSet RS = conn.createStatement().executeQuery(query);
            while (RS.next()) {
                _name = RS.getString("Name");
                _address = RS.getString("Address");
                _phoneNumber = RS.getString("Phone");
                _email = RS.getString("Email");
                _valued = RS.getBoolean("Valued");
                _lastReportTime = new Date(RS.getDate("LastReportTime").getTime());
                _discountPlanId = RS.getInt("DiscountPlan");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        _cardNumbers = new ArrayList<>();
        query = "SELECT * FROM CardDetails AS CD INNER JOIN CustomerAccount AS C ON CD.CustomerNo = C.No;";
        try {
            ResultSet RS = conn.createStatement().executeQuery(query);
            while (RS.next()) {
                _cardNumbers.add(RS.getString("CardNumber"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Boolean hasDiscountPlan() {
        loadDetails();
        return _discountPlanId.intValue() != 0;
    }

    public Discount getDiscountPlan() {
        return DiscountController.getDiscount(this);
    }

    public void setDiscount(Discount p) {
        if (p == null) {
            SetSQL("DiscountPlan", "NULL");
            return;
        }
        Integer id = p.getId();
        SetSQL("DiscountPlan", p.getId().toString());
    }

    public Integer getId() {
        return this._customerId;
    }

    void setId(Integer aCustomerId) {
        this._customerId = aCustomerId;
    }

    public String getName() {
        return this._name;
    }

    void setName(String Name) {
        this._name = Name;
        SetSQL("Name", Name);
    }

    public String getAddress() {
        return this._address;
    }

    void setAddress(String aAddress) {
        this._address = aAddress;
        SetSQL("Address", aAddress);
    }

    public String getEmail() {
        return this._email;
    }

    public void setEmail(String aEmail) {
        this._email = aEmail;
        SetSQL("Email", aEmail);
    }

    public String getPhoneNumber() {
        return this._phoneNumber;
    }

    void setPhoneNumber(String aPhoneNumber) {
        this._phoneNumber = aPhoneNumber;
        SetSQL("Phone", aPhoneNumber);
    }

	public Boolean getValued() {
		return this._valued;
	}

	public void setValued(Boolean aValued) {
		this._valued = aValued;
		SetSQL("Valued",  aValued.equals(true) ? "1" : "0");
	}

    public CustomerAccount(Integer id) {
        _customerId = id;

        loadDetails();
    }

    public Boolean hasCardStored(String CardNumber) {
        for (String c: _cardNumbers) {
            if (c.equals(CardNumber)) {
                return true;
            }
        }
        return false;
    }

    public void storeCard(String CardNumber) {
        _cardNumbers.add(CardNumber);
        String query = "INSERT INTO CardDetails (`CardNumber`, `CustomerNo`) VALUES\n"
                + "('"+CardNumber+"', "+getId().toString()+")";
        System.out.println(query);
        Connection conn = DBConnWrapper.getConnection();
        try {
            if (conn.createStatement().executeUpdate(query) == 0) {
                throw new RuntimeException("failed to add cardnumber to DB");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "id " + getId().toString() + "\n"
                + "Name " + getName() + "\n"
                + "Address " + getAddress() + "\n"
                + "Phone " + getPhoneNumber() + "\n"
                + "Valued " + (getValued() ? "YES" : "NO") + "\n"
                + "DiscountPlan " + getDiscountPlan().getName();
    }
}