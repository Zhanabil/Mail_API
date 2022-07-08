package kz.dar.academy.controller;

import kz.dar.academy.object.Mail;
import kz.dar.academy.object.MailDatabase;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MailController {
    List<Mail> mailList = new ArrayList<>();

    MailDatabase mailDatabase = new MailDatabase();

    private static final String template = "wtf %s";

    @PostMapping("/post")
    public void post(@RequestParam(value = "id") Integer id, @RequestParam(value = "name") String name) {

        mailList.add(new Mail(id, name));
    }

    @GetMapping("/all")
    public List<Mail> getAll() {
        return mailList;
    }

    @GetMapping("/getById")
    public Mail getById(@RequestParam(value = "id") Integer id) {

        for(int i=0; i<mailList.size(); i++) {
            if(id == mailList.get(i).getId())
                return mailList.get(i);
        }

        return null;
    }

    @DeleteMapping("/removeById")
    public void removeById(@RequestParam(value = "id") Integer id) {

        for(int i=0; i<mailList.size(); i++) {
            if(id == mailList.get(i).getId())
                mailList.remove(i);
        }
    }

    @PutMapping("/put")
    public void update(@RequestParam(value = "id") Integer id, @RequestParam(value = "name") String name) {

        for(int i=0; i<mailList.size(); i++) {
            if(id == mailList.get(i).getId()) {
                mailList.remove(mailList.get(i));
                mailList.add(new Mail(id, name));
            }
        }
    }



    public Mail findById(Integer id) {

        for(int i=0; i<mailList.size(); i++) {
            if(id == mailList.get(i).getId()) {
                return mailList.get(i);
            }
        }

        return null;
    }
}

