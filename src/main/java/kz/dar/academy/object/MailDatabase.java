package kz.dar.academy.object;

import kz.dar.academy.object.Mail;

import java.util.ArrayList;
import java.util.List;

public class MailDatabase {
    List<Mail> mailStore = new ArrayList<>();

    public Mail findById(Integer id) {

        for(int i=0; i<mailStore.size(); i++) {
            if(id == mailStore.get(i).getId())
                return mailStore.get(i);
        }

        return null;
    }

}
