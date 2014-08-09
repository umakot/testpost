package org.test
import org.test.pojo.Address

class PersonController {

    def index() { }
    
def savePersons(){
	
	// Save Person 1 
		def per1 = new Person()
	
		per1.fName = "George" 
		per1.lName = "Smith"
		per1.age	  = 32
		
		def addr1 = new Address()
		
		addr1.label	= "Home"
		addr1.houseNum = "1234"
		addr1.streetName = "New Port Pavonia"
		addr1.city	  = "New York"
		addr1.zipcode  = "07310" 
		addr1.country  = "USA"
	
		def addr2 = new Address()
		
		addr2.label	= "Work"
		addr2.houseNum = "1234"
		addr2.streetName = "Washington Street"
		addr2.city	  = "Princeton"
		addr2.zipcode  = "06990" 
		addr2.country  = "USA"
		per1.addresses.put("1", addr1)
		per1.addresses.put("2", addr2) 
		per1.save(flush:true) 
		print 'Saved Person !!' + per1.fName 
		
		// Save Person 2
		
		def per2 = new Person()
	
		per2.fName = "Tracy" 
		per2.lName = "Smith"
		per2.age	  = 28
		
		def addr3 = new Address()
		
		addr3.label	= "Work"
		addr3.houseNum = "1234"
		addr3.streetName = "Reynold st"
		addr3.city	  = "Princeton"
		addr3.zipcode  = "06990"
		addr3.country  = "USA"
	
		
		per2.addresses.put("1", addr1)
		per2.addresses.put("2", addr3) 
		per2.save(flush:true) 
		print 'Saved Person !!' + per2.fName 

	}

	def listPersons(){
		def listPers = Person.list(); 
		
		listPers.each {record ->
			println 'First Name is' + record.fName	
			println 'Full Address is' + record.addresses.get("1")
			println 'City is ' + record.addresses.get("1").city
			
		}
	}
	
	}
