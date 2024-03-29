package com.bridgelabz.addressbook;

import java.util.*; 

public class AddressBook {
	List<PersonDetails> referenceBook = new LinkedList<PersonDetails>();
	public  HashMap<String, LinkedList<PersonDetails>> personsByCity = new HashMap<String, LinkedList<PersonDetails>>();
	public  HashMap<String, LinkedList<PersonDetails>> personsByState = new HashMap<String, LinkedList<PersonDetails>>();
	private int numOfContacts = 0;
	
	public void addPerson() {
		System.out.println("Enter Person details:");
		
		PersonDetails person = intake();
		for(int i=0; i< referenceBook.size();i++) {
			if(person.getFirstName().equals(referenceBook.get(i).getFirstName())) {
				if(!person.equals(referenceBook.get(i))) {
					referenceBook.add(person);
					if(personsByCity.get(person.getCity()) == null) personsByCity.put(person.getCity(), new LinkedList<>());
					personsByCity.get(person.getCity()).add(person);
					if(personsByState.get(person.getState()) == null) personsByCity.put(person.getState(), new LinkedList<>());
					personsByState.get(person.getState()).add(person);
					return;
				}
				else System.out.println("Duplicate data entry. discarded");
			}
		}
		referenceBook.add(person);
		if(personsByCity.get(person.getCity()) == null) personsByCity.put(person.getCity(), new LinkedList<>());
		personsByCity.get(person.getCity()).add(person);
		if(personsByState.get(person.getState()) == null) personsByState.put(person.getState(), new LinkedList<>());
		personsByState.get(person.getState()).add(person);
	}
	
	public void searchByCity(String city,String firstName) {
		for(int i=0;i<referenceBook.size();i++) {
			if(city.equals(referenceBook.get(i).getCity()) && firstName.equals(referenceBook.get(i).getFirstName())) {
				output(referenceBook.get(i));
				System.out.println();
			}
		}
	}
	
	public void searchByState(String state, String firstName) {
		for(int i=0;i<referenceBook.size();i++) {
			if(state.equals(referenceBook.get(i).getState()) && firstName.equals(referenceBook.get(i).getFirstName())) {
				output(referenceBook.get(i));
				System.out.println();
			}
		}
	}
	
	public void personsInCity(String city) {
		LinkedList<PersonDetails> list = personsByCity.get(city);
		for(int i=0; i< list.size();i++) {
			output(list.get(i));
			System.out.println();
		}
	}
	
	public void personsInState(String State) {
		LinkedList<PersonDetails> list = personsByState.get(State);
		
		for(int i=0; i< list.size();i++) {
			output(list.get(i));
			System.out.println();
		}
	}
	public void editPerson(String name) {
		int i=0;
		for(i=0;i<referenceBook.size();i++) {
			if(name.equals(referenceBook.get(i).getFirstName())) break;
		}
		if(i == referenceBook.size()) {
			System.out.println("name not found");
			return;
		}
		System.out.println("Changing details, Enter new details  of "+name);
		referenceBook.add(intake());
	}
	
	public void display() {
		Scanner sc = new Scanner(System.in);
		PersonDetails person = null; 
		System.out.println("Persons present in the address book:");
		for(int i=0; i<referenceBook.size();i++) {
			System.out.print(referenceBook.get(i).getFirstName()+"  ");
		}
		System.out.println();
		System.out.println("Enter name to see details");
		String name = sc.next();
		
		for(int i = 0;i<referenceBook.size();i++) {
			if(referenceBook.get(i).getFirstName().equals(name)) {
				person = referenceBook.get(i);
				break;
			}
		}
		if(person == null) {
			System.out.println("name not found!");
			return;
		}
		
		output(person);
		
	}
	
	
	public void deletePerson(String name) {
		int i=0;
		for(i=0;i<referenceBook.size();i++) {
			if(referenceBook.get(i).getFirstName().equals(name)) {
				referenceBook.remove(i);
				System.out.println("Deleted details of : "+ name);
				return;
			}
		}
		System.out.println("Name not found");
		
	}
	
	public int countByCity(String city) {
		
		return (personsByCity.get(city)==null)?0:personsByCity.get(city).size();
	}
	public int countByState(String state) {
		return personsByState.get(state)==null?0:personsByState.get(state).size();
	}
	
	private static PersonDetails intake() {
		Scanner sc = new Scanner(System.in);
		PersonDetails person1 = new PersonDetails();
		
		System.out.println("Enter firstName:");
		person1.setFirstName(sc.next());
		System.out.println("Enter SecondName:");
		person1.setLastName(sc.next());
		System.out.println("Enter Address:");
		person1.setAddress(sc.next());
		System.out.println("Enter City:");
		person1.setCity(sc.next());
		System.out.println("Enter State:");
		person1.setState(sc.next());
		System.out.println("Enter Pin code:");
		person1.setPinCode(sc.nextInt());
		System.out.println("Enter Phone nmber:");
		person1.setPhoneNumber(sc.next());
		System.out.println("Enter email:");
		person1.setEmail(sc.next());
		return person1;
	}
	
	private static void output(PersonDetails person) {
		System.out.println("firstName : "+person.getFirstName());
		System.out.println("SecondName : "+ person.getLastName());
		System.out.println("Address : "+ person.getAddress());
		System.out.println("City : "+person.getCity());
		System.out.println("State : "+person.getState());
		System.out.println("Pin code : "+person.getPinCode());
		System.out.println("Phone nmber : "+person.getPhoneNumber() );
		System.out.println("email : "+person.getEmail());
	}
	
}
