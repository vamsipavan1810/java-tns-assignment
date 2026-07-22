package org.tns.java.assignment.row6exceptionhandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserFileProcessor {

	private List<User> users = new ArrayList<>();
	
	public void readUsers(String filePath)  {
		Set<String> emailSet = new HashSet<>();
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
			String line;
			bufferedReader.readLine();
			int rowNum = 1;
			while((line =  bufferedReader.readLine()) !=  null) {
				rowNum++;
				try {
					String[] data = line.split(",");
					if(data.length != 3) throw new ValidationException("Invalid number of columns in row " + rowNum);
					int id = Integer.parseInt(data[0].trim());
					String name = data[1].trim();
					String email = data[2].trim();
					
					validateUser(id, name, email);
					
					if(emailSet.contains(email)) throw new DuplicateEmailException("Duplicate email found : " + email);
					emailSet.add(email);
					users.add(new User(id, name, email));
				}  catch (ValidationException | DuplicateEmailException e) {
					System.err.println("Row " + rowNum + " processing failed: " + e.getMessage());
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not found: " + filePath);
		} catch (IOException e) {
			System.err.println("I/O error occurred: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Unexpected error: " + e.getMessage());
		} finally {
			System.out.println("File processing completed");
		}
	}
	
	private void validateUser(int id, String name, String email) throws ValidationException {
		if(id <= 0) throw new ValidationException("Invalid user id");
		
		if(name == null || name.isBlank()) throw new ValidationException("Name cannot be empty");
		
		if(!email.contains("@")) throw  new ValidationException("Invalid email format");
	}
	
	public User findUserById(int id) throws UserNotFoundException {
		return users
				.stream()
				.filter(u -> u.getId() == id)
				.findFirst()
				.orElseThrow(() -> new UserNotFoundException("User not found with ID : " + id));
	}
}