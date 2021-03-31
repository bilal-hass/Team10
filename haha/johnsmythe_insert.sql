INSERT INTO JobTypes(JobType) VALUES 
	("PROCESSING"),
    ("ENLARGENING"),
    ("MISC");

INSERT INTO Task(TaskName, TaskDescription, Location, Price, Duration) VALUES 
	("Enlarge", "Usage of large copy camera to enlarge image", "Copy Room", 19.00, 90),
    ("B&WProcess", "Black and White film processing", "Development Area", 49.50, 60),
    ("Bagging", "Bagging of images or film", "Packing Department", 6.00, 30),
    ("ColorProcess", "Colored film processing", "Development Area", 80.0, 90),
    ("ColorTransparencyProcess", "Colored film Transparency Processing", "Development Area", 110.30, 180);
    
    #ROLES
    #1 OfficeManager
    #2 ShiftManager
    #3 Receptionist
    #4 Technician 
INSERT INTO StaffAccount (`Role`, `Username`, `Password`, `Name`, `Address`, `Department`) VALUES
	(4, "Technician1", "Password1", "Michael", "SomeNumber SomePlace St. SomeCity", "Development Area"),
    (3, "Receptionist1", "Password1", "James", "SomeNumber SomePlace St. SomeCity", "Reception"),
	(1, "OfficeManager1", "Password1", "BigBoss420", "SomeNumber SomePlace St. SomeCity", "*");
    
INSERT INTO VariableDiscount() VALUES
	();

INSERT INTO VariableTaskAmounts(`Amount`, `VariableDiscount`, `TaskType`) VALUES
	( .05, 1, 1 ), 
    ( .05, 1, 3 );
    
INSERT INTO FlexibleDiscount() VALUES ();
INSERT INTO FlexibleDiscount() VALUES ();
    
INSERT INTO FlexibleJobAmounts(`StartPrice`, `EndPrice`, `Amount`, `FlexibleDiscount`, `JobType`) VALUES
	(0.0, 100.0, .05, 1, 1),
    (100.0, 200.0, .1, 1, 1),
    (200.0, 999999999.0, .15, 1, 1),
    (0.0, 100.0, 0.05, 2, 1),
	(100.0, 200.0, 0.1, 2, 1),
	(200.0, 999999999.0, 0.15, 2, 1);
    
INSERT INTO DiscountPlan(`Name`, `Description`, `Type`, VariableDiscount, FlexibleDiscount, FlatDiscount) VALUES 
	("Flat5Off", "5% Reduction on all prices", "FIXED", NULL, NULL, .05),
    ("10OffBaggingEnlarge", "10% Reduction on Bagging task cost and Black & Enlargening", "VARIABLE", 1, NULL, 0),
    ("5OffPer100Processing", "5% Reduction on all Processing jobs per 100£ spent this month, up to 15%", "FLEXIBLE", NULL, 1, 0);
    
INSERT INTO CustomerAccount(`Name`,`Address`,`Email`, `Phone`,`Valued`, `DiscountPlan`) VALUES
	("John Smythe", "11 Prentiss St. London", "JohnSmythe@DEBUG", "07479945650", False, 3);

INSERT INTO Job(CustomerNo, Status, Paid, StartDate, CompletionDate, JobType, Urgency) VALUES
	(1, "COMPLETE", true, '2021-03-2 10:34:09', '2020-07-18 13:12:53', 1, 1),
    (1, "ACTIVE", true, '2021-03-28 10:15:03', NULL, 1, 3);
    
INSERT INTO JobTasks(`Order`, StartTime, Completed, TaskId, JobId, CompletionStaff, CompletionTime) VALUES
	(1, '2021-03-16', True, 1, 1, 1, '2021-03-16 16:53:28'),
    (2, '2021-03-16', True, 3, 1, 1, '2021-03-17 11:53:28'),
    (1, '2021-03-17', False, 2, 2, NULL, NULL),
    (2, '2021-03-17', False, 3, 2, NULL, NULL);