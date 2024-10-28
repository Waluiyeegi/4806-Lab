package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class);
    }
//
//    @Bean
//    public CommandLineRunner demo(BuddyInfoRepository repository) {
//        return (args) -> {
//            // save a few Buddyinfos
//            repository.save(new BuddyInfo("Jack", "101"));
//            repository.save(new BuddyInfo("Caleb", "102"));
//            repository.save(new BuddyInfo("Kim", "103"));
//            repository.save(new BuddyInfo("David", "104"));
//            repository.save(new BuddyInfo("Michelle", "105"));
//
//            // fetch all Byuddyinfos
//            log.info("BuddyInfo found with findAll():");
//            log.info("-------------------------------");
//            repository.findAll().forEach(buddyInfo -> {
//                log.info(buddyInfo.toString());
//            });
//            log.info("");
//
//            // fetch an individual buddyinfo by ID
//            BuddyInfo buddyInfo = repository.findById(1L);
//            log.info("BuddyInfo found with findById(1L):");
//            log.info("--------------------------------");
//            log.info(buddyInfo.toString());
//            log.info("");
//
//            // fetch Buddyinfos by last name
//            log.info("BuddyInfo found with findByLastName('Bauer'):");
//            log.info("--------------------------------------------");
//            repository.findByName("Caleb").forEach(bauer -> {
//                log.info(bauer.toString());
//            });
//            log.info("");
//
//            log.info("BuddyInfo found with PhoneNumber('105'):");
//            log.info("--------------------------------------------");
//            repository.findByPhoneNumber("105").forEach(bauer -> {
//                log.info(bauer.toString());
//            });
//            log.info("");
//        };
//    }
//    @Bean
//    public CommandLineRunner demo2(AddressBookRepository repository) {
//        return (args) -> {
//            // save a few Addressbooks
//
//            AddressBook addressBook1 = new AddressBook();
//            BuddyInfo buddyInfo1 = new BuddyInfo("Jack", "101");
//            BuddyInfo buddyInfo2 = new BuddyInfo("Caleb", "102");
//            addressBook1.addBuddy(buddyInfo1);
//            addressBook1.addBuddy(buddyInfo2);
//
//            AddressBook addressBook2 = new AddressBook();
//            BuddyInfo buddyInfo3 = new BuddyInfo("Kim", "103");
//            BuddyInfo buddyInfo4 = new BuddyInfo("David", "104");
//            addressBook2.addBuddy(buddyInfo3);
//            addressBook2.addBuddy(buddyInfo4);
//
//            repository.save(addressBook1);
//            repository.save(addressBook2);
//
//            // fetch all addressbooks
//            log.info("Addressbook found with findAll():");
//            log.info("-------------------------------");
//            repository.findAll().forEach(addressbook -> {
//                log.info(addressbook.toString());
//            });
//            log.info("");
//
//            // fetch an individual addressbook by ID
//            AddressBook addressBook = repository.findById(1L);
//            log.info("Addressbook found with findById(1L):");
//            log.info("--------------------------------");
//            log.info(addressBook.toString());
//            log.info("");
//
////            log.info("Buddyinfo found with findById(1L) and (1):");
////            log.info("--------------------------------");
////            log.info(addressBook.getBudd(1).getName());
////            log.info(addressBook.getBudd(1).getPhoneNumber());
////            log.info("");
//
//
//        };
//    }
//

}
