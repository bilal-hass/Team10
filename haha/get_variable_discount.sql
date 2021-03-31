SELECT C.Name, DP.Name, DP.Type, DP.Description, VTA.Amount, T.TaskName FROM CustomerAccount AS C 
	INNER JOIN DiscountPlan AS DP ON C.DiscountPlan = DP.id
    INNER JOIN VariableDiscount AS VD ON VD.id = DP.VariableDiscount
    INNER JOIN VariableTaskAmounts AS VTA ON VTA.VariableDiscount = VD.id
    INNER JOIN Task AS T ON T.TaskType = VDA.TaskType
    WHERE C.No = 1;