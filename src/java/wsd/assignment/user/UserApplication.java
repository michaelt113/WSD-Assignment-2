package wsd.assignment.user;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class UserApplication {
	
	private String filePath;
	private Users users;
                
        public UserApplication(String filePath, Users users) {
            super();
            this.filePath = filePath;
            this.users = users;
	}
        
        public UserApplication(){
            super();
        }
	
	public String getFilePath() {
		return filePath;
	}
	
	public void setFilePath(String filePath) throws JAXBException, IOException {
		// Create the unmarshaller
		JAXBContext jc = JAXBContext.newInstance(Users.class);
		Unmarshaller u = jc.createUnmarshaller();
		 
		// Now unmarshal the object from the file
		FileInputStream fin = new FileInputStream(filePath);
		users = (Users)u.unmarshal(fin); // This loads the "shop" object
		fin.close();
	}
	
	public Users getUsers() {
		return users;
	}
	
	public void setUsers(Users users) {
		this.users = users;
	}
        
        public User getUser(String email){
            return users.getUser(email);
        }
        
        	public void saveUsers() throws JAXBException, IOException {
		JAXBContext jc = JAXBContext.newInstance(Users.class);
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(users, new FileOutputStream("/Users/Bahamut/NetBeansProjects/WSD Assignment 2/build/web/WEB-INF/users.xml"));
                }
	
        
        
}
