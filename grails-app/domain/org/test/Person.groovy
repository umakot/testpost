package org.test
import org.test.pojo.Address
import net.kaleidos.hibernate.usertype.JsonMapType


class Person {
	String fName
	String lName
	int		age
	Map<String,Address> addresses = new HashMap<String,Address>();
	
	/*
	
	My desire here is to create a list of addresses as list and not as Map. 
	
	Json with the above map is 
	
	>>>>>
	testpost=# select * from person ;
 id | version |                                                                                                                        addresses                                                                                                                         | age | f_name | l_name 
----+---------+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+-----+--------+--------
  1 |       0 | {"2":{"label":"Work","houseNum":"1234","streetName":"Washington Street","city":"Princeton","zipcode":"06990","country":"USA"},"1":{"label":"Home","houseNum":"1234","streetName":"New Port Pavonia","city":"New York","zipcode":"07310","country":"USA"}} |  32 | George | Smith
  2 |       0 | {"2":{"label":"Work","houseNum":"1234","streetName":"Washington Street","city":"Princeton","zipcode":"06990","country":"USA"},"1":{"label":"Home","houseNum":"1234","streetName":"New Port Pavonia","city":"New York","zipcode":"07310","country":"USA"}} |  28 | Tracy  | Smith
(2 rows)


>>>

Json with "List" would be (edited below)

testpost=# select * from person ;
 id | version |                                                                                                                        addresses                                                                                                                         | age | f_name | l_name 
----+---------+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+-----+--------+--------
  1 |       0 | {"label":"Work","houseNum":"1234","streetName":"Washington Street","city":"Princeton","zipcode":"06990","country":"USA"},{"label":"Home","houseNum":"1234","streetName":"New Port Pavonia","city":"New York","zipcode":"07310","country":"USA"} |  32 | George | Smith
  2 |       0 | {"label":"Work","houseNum":"1234","streetName":"Washington Street","city":"Princeton","zipcode":"06990","country":"USA"},{"label":"Home","houseNum":"1234","streetName":"New Port Pavonia","city":"New York","zipcode":"07310","country":"USA"} |  28 | Tracy  | Smith
(2 rows)

>>>
	
	
	
	*/

    static constraints = {
    }
    static mapping = {
		addresses type: JsonMapType
	}

    
}
