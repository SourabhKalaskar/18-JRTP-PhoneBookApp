package in.ashokit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.bindings.ContactForm;
import in.ashokit.service.ContactService;

@RestController
public class ContactRestController {

	@Autowired
	private ContactService contactservice;
	
	@PostMapping("/save")
	public String saveContact(@RequestBody ContactForm form)
	{
		String status= contactservice.saveContact(form);
		return status;
	}
	
	@GetMapping("/contacts")
	public List<ContactForm> viewContact()
	{
		
		return contactservice.viewContacts();
	}
	
	@GetMapping("/edit/{contactId}")
	public ContactForm editContact(@PathVariable Integer contactId)
	{
		return contactservice.editContact(contactId);
	}
	
	@GetMapping("/delete/{contactId}")
	public List<ContactForm> deleteContact(@PathVariable Integer contactId)
	{
		return contactservice.deleteContact(contactId);
	}
	
}
