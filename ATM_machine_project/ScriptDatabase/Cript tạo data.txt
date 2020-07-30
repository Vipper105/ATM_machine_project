 INSERT INTO user (userName,age,sex,phoneNumber,address)
 VALUES ("Huy",25,"Nam","0902822157","abcTranhungdao");
 
 INSERT INTO user (userName,age,sex,phoneNumber,address)
 VALUES ("Tu anh",25,"Nu","0902822157","abcTranhungdao");
 
 INSERT INTO user (userName,age,sex,phoneNumber,address)
 VALUES ("To Nga",25,"Nam","0902822157","abcTranhungdao");
 
 INSERT INTO user (userName,age,sex,phoneNumber,address)
 VALUES ("Chinh",25,"Nu","0902822157","abcTranhungdao");
 
 --=====================================================
 INSERT INTO role (roleID,roleName)
 VALUES ("1","Admin");
 
 INSERT INTO role (roleID,roleName)
 VALUES ("2","User");
 -- ======================================================
 
 INSERT INTO accounttype (accountTypeName)
 VALUES ("Checking account");
 
 INSERT INTO accounttype (accountTypeName)
 VALUES ("Saving account");
 
 INSERT INTO accounttype (accountTypeName)
 VALUES ("Bussiness account");
 --===================================================
 INSERT INTO location (locationID,locationName)
 VALUES ("1","HCM");
 
 INSERT INTO location (locationID,locationName)
 VALUES ("2","ĐN");
 
 INSERT INTO location (locationID,locationName)
 VALUES ("3","HN");
 
 INSERT INTO location (locationName)
 VALUES ("Hue");
 
 INSERT INTO location (locationName)
 VALUES ("Binh Dinh");
 
 INSERT INTO location (locationName)
 VALUES ("Nha Trang");
 
 --=====================================
  INSERT INTO account (pinCode,accountName,availableBalance,totalBalance,accountTypeID,userID,roleID,locationID)
 VALUES (1111,"Boss Admin",1000,1500,1,1,1,1);
 
  INSERT INTO account (pinCode,accountName,availableBalance,totalBalance,accountTypeID,userID,roleID,locationID)
 VALUES (1111,"Nguyen Chinh",500,1000,1,4,2,1);
 
  INSERT INTO account (pinCode,accountName,availableBalance,totalBalance,accountTypeID,userID,roleID,locationID)
 VALUES (1111,"Nguyen Chinh 2",1200,1500,2,4,2,3);
 
  INSERT INTO account (pinCode,accountName,availableBalance,totalBalance,accountTypeID,userID,roleID,locationID)
 VALUES (1111,"Nguyen Chinh 3",200,500,3,7,2,3);
 
  INSERT INTO account (pinCode,accountName,availableBalance,totalBalance,accountTypeID,userID,roleID,locationID)
 VALUES (1111,"Nguyen Chinh 4",2000,2200,2,7,2,2);
 
 INSERT INTO account (pinCode,accountName,availableBalance,totalBalance,accountTypeID,userID,roleID,locationID)
 VALUES (1111,"Nguyen Chinh 5",1800,2000,3,7,2,1);
 
 --=========================================================
 INSERT INTO transaction (transactionID,loaiGiaoDich,description,date_transaction,accountID,accountReceived,moneySend,addedMoney,withdrawlMoney,oldPIN,newPIN)
  values(?,?,?,?,?,?,?,?,?,?,?)
  
INSERT INTO atmmachine (machineName,locationID)
 VALUES ("ATM HCM",1);
 INSERT INTO atmmachine (machineName,locationID)
 VALUES ("ATM ĐN",2);
 INSERT INTO atmmachine (machineName,locationID)
 VALUES ("ATM HN",3);
  
 INSERT INTO coins (priceTag,quantity,machineID)
 VALUES (1,1000,1);
  INSERT INTO coins (priceTag,quantity,machineID)
 VALUES (10,100,1);
  INSERT INTO coins (priceTag,quantity,machineID)
 VALUES (50,50,1);
  INSERT INTO coins (priceTag,quantity,machineID)
 VALUES (100,50,1);
  INSERT INTO coins (priceTag,quantity,machineID)
 VALUES (500,30,1);
  INSERT INTO coins (priceTag,quantity,machineID)
 VALUES (1000,20,1);
 
 INSERT INTO coins (priceTag,quantity,machineID)
 VALUES (1,1000,2);
  INSERT INTO coins (priceTag,quantity,machineID)
 VALUES (10,100,2);
  INSERT INTO coins (priceTag,quantity,machineID)
 VALUES (50,50,2);
  INSERT INTO coins (priceTag,quantity,machineID)
 VALUES (100,50,2);
  INSERT INTO coins (priceTag,quantity,machineID)
 VALUES (500,30,2);
  INSERT INTO coins (priceTag,quantity,machineID)
 VALUES (1000,20,2);
 
 INSERT INTO coins (priceTag,quantity,machineID)
 VALUES (1,1000,3);
  INSERT INTO coins (priceTag,quantity,machineID)
 VALUES (10,100,3);
  INSERT INTO coins (priceTag,quantity,machineID)
 VALUES (50,50,3);
  INSERT INTO coins (priceTag,quantity,machineID)
 VALUES (100,50,3);
  INSERT INTO coins (priceTag,quantity,machineID)
 VALUES (500,30,3);
  INSERT INTO coins (priceTag,quantity,machineID)
 VALUES (1000,20,3);
 
 INSERT INTO coins (priceTag,quantity,machineID)
 VALUES (1,1000,4);
  INSERT INTO coins (priceTag,quantity,machineID)
 VALUES (10,100,4);
  INSERT INTO coins (priceTag,quantity,machineID)
 VALUES (50,50,4);
  INSERT INTO coins (priceTag,quantity,machineID)
 VALUES (100,50,4);
  INSERT INTO coins (priceTag,quantity,machineID)
 VALUES (500,30,4);
  INSERT INTO coins (priceTag,quantity,machineID)
 VALUES (1000,20,4);
 
 INSERT INTO coins (priceTag,quantity,machineID)
 VALUES (1,1000,5);
  INSERT INTO coins (priceTag,quantity,machineID)
 VALUES (10,100,5);
  INSERT INTO coins (priceTag,quantity,machineID)
 VALUES (50,50,5);
  INSERT INTO coins (priceTag,quantity,machineID)
 VALUES (100,50,5);
  INSERT INTO coins (priceTag,quantity,machineID)
 VALUES (500,30,5);
  INSERT INTO coins (priceTag,quantity,machineID)
 VALUES (1000,20,5);