import org.apache.commons.collections.list.TreeList;

import java.util.*;

public class EmailList {
    ArrayList<String> mail = new ArrayList<>();

    public void add(String email) {
        // TODO: валидный формат email добавляется

        if (email.contains("@") && email.contains(".") && email.indexOf("@") == email.lastIndexOf("@") && !email.substring(email.indexOf("@"),email.lastIndexOf(".")).contains(".")) {

            mail.add(email.toLowerCase(Locale.ROOT));

        }
    }


    public List<String> getSortedEmails() {
        // TODO: возвращается список электронных адресов в алфавитном порядке
            TreeSet<String> mails = new TreeSet<>();
            mails.addAll(mail);
            mail.clear();
            mail.addAll(mails);
        return mail;
    }

}
