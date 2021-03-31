SELECT C.`Name`, J.`Status`, JT.`Order`, JT.`Progress`, T.`TaskName`, J.`StartDate`, J.`CompletionDate`, T.`Price` AS `TaskPrice` FROM (
	(Job AS J INNER JOIN JobTasks AS JT 
		ON (JT.JobId = J.id)
	) INNER JOIN CustomerAccount AS C 
		ON J.CustomerNo = C.No) 
        INNER JOIN Task as T 
			ON T.TaskType = JT.TaskId;