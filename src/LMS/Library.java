package LMS;

import java.io.BufferedWriter;


import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Library{

    private List<Book> booksList;
    private List<Member> membersList;
    private List<Transactions> transactionsList;
    private Map<Integer, Book> bookSearch;
    private Map<Integer, Member> memberSearch;
    private BufferedWriter addLog;
    private BufferedWriter removeLog;
    public int memberCounter;

    public Library() throws IOException {
     booksList = new ArrayList<>();
     membersList = new ArrayList<>();
     transactionsList = new ArrayList<>();
     bookSearch = new HashMap<>();
     memberSearch = new HashMap<>();
     addLog = new BufferedWriter(new FileWriter("Add Log.txt"));
     removeLog = new BufferedWriter(new FileWriter("Remove Log.txt"));
    }

    public void addMember(int memberID, String name, String email, String phoneNumber, ArrayList<String> borrowedBooks ) throws IOException {
        membersList.add(new Member(memberID,name,email,phoneNumber,borrowedBooks));
        addLog.write("\n");
        addLog.write(memberCounter++ +": " + memberID + ", "
                + name + ", "
                + email + ", "
                + phoneNumber + ", " + borrowedBooks.get(memberCounter));
        addLog.close();
    }

    public void removeMember(int memberID) throws IOException {
        int counter = 0;
        membersList.remove(memberID);
        removeLog.write("\n");
        removeLog.write(counter++);
        removeLog.write("placeHolder");
        removeLog.close();
        memberCounter--;
    }







}
