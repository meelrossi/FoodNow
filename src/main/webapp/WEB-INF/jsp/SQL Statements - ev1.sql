CREATE TABLE RATING (
	DESCRIPTION TEXT NOT NULL, 
	FN_USER_ID INT NOT NULL, 
	FOREIGN KEY(FN_USER_ID) REFERENCES FN_USER 
);