package Discount;

import com.mysql.cj.protocol.x.Notice;

public final class JobFlexibleData {
    public Integer JobType;
    public Float StartPrice;
    public Float EndPrice;
    public Float Amount;
    private Integer _internalId;
    public JobFlexibleData(Integer _type, Float _startPrice, Float _endPrice, float _amount) {
        JobType = _type;
        StartPrice = _startPrice;
        EndPrice = _endPrice;
        Amount = _amount;
    }
    public void setInternalId(Integer id) {
        _internalId = id;
    }
}
