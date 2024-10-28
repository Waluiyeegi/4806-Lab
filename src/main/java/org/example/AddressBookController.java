package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class AddressBookController {
    @Autowired
    private AddressBookRepository addressBookRepository;

    @Autowired
    private BuddyInfoRepository buddyInfoRepository;

    @GetMapping("/addressBook")
    public String addressbookForm(Model model) {

        model.addAttribute("addressBook", new AddressBook());
        return "addressBook"; // This will map to a Thymeleaf template named 'index.html'
    }

    // Add a new BuddyInfo to an existing AddressBook
    @PostMapping("/addressBook")
    public String addAddressBook(
            @ModelAttribute AddressBook addressBook, Model model) {
        addressBookRepository.save(addressBook);
        model.addAttribute("addressBook", addressBook);
        return "result";
    }

    // Display form to add BuddyInfo to AddressBook
    @GetMapping("/addressBook/{id}/buddy")
    public String addBuddyForm(@PathVariable Long id, Model model) {
        model.addAttribute("buddyInfo", new BuddyInfo());
        model.addAttribute("addressBookId", id);
        return "buddy";
    }

    // Submit form to add BuddyInfo to AddressBook
    @PostMapping("/addressBook/{id}/addBuddy")
    public String addBuddySubmit(@PathVariable Long id, @ModelAttribute BuddyInfo buddyInfo, Model model) {
        buddyInfoRepository.save(buddyInfo);
        Optional<AddressBook> addressBookOpt = addressBookRepository.findById(id);
        if (addressBookOpt.isPresent()) {
            AddressBook addressBook = addressBookOpt.get();
            addressBook.addBuddy(buddyInfo); // This should add the populated buddyInfo
            addressBookRepository.save(addressBook); // Persist changes to the AddressBook
            model.addAttribute("addressBook", addressBook);
            return "result";
        }
        return "redirect:/addressBook"; // In case AddressBook with the given id is not found
    }

}
