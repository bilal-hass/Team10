SELECT C.Name, DP.Name, DP.Type, FJA.StartPrice, FJA.EndPrice, FJA.Amount FROM CustomerAccount AS C 
	INNER JOIN DiscountPlan AS DP ON C.DiscountPlan = DP.id
    INNER JOIN FlexibleDiscount AS FD ON DP.FlexibleDiscount = FD.id
    INNER JOIN FlexibleJobAmounts AS FJA ON FJA.FlexibleDiscount = FD.id
		WHERE C.No = 1;