package Discount;

public final class JobFlexibleData {
    Integer JobType;
    Float StartPrice;
    Float EndPrice;
    Float Amount;
    public JobFlexibleData(Integer _type, Float _startPrice, Float _endPrice, float _amount) {
        JobType = _type;
        StartPrice = _startPrice;
        EndPrice = _endPrice;
        Amount = _amount;
    }
}
